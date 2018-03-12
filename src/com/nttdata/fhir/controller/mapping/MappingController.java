package com.nttdata.fhir.controller.mapping;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nttdata.fhir.dao.BaseProfileTypeDao;
import com.nttdata.fhir.dao.HL7FieldDao;
import com.nttdata.fhir.dao.HL7SegmentDao;
import com.nttdata.fhir.dao.ProfileFieldDao;
import com.nttdata.fhir.dao.ResourceDao;
import com.nttdata.fhir.model.BaseProfileType;
import com.nttdata.fhir.model.HL7Field;
import com.nttdata.fhir.model.HL7Segment;
import com.nttdata.fhir.model.MappingDetailMaster;
import com.nttdata.fhir.model.ProfileField;
import com.nttdata.fhir.model.ProfileFieldSearch;
import com.nttdata.fhir.model.Resource;
import com.nttdata.fhir.service.MappingService;



@RestController
@RequestMapping("api/mapping")
public class MappingController {
	
	//Field used for programmer logging
	private static final Logger LOG = LogManager.getLogger(MappingController.class);
 
	@Autowired private Environment env;
	
	@Autowired private ResourceDao resourceDao;
	@Autowired private BaseProfileTypeDao baseProfileTypeDao;
	@Autowired private ProfileFieldDao profileFieldDao;
	@Autowired private HL7SegmentDao hl7SegmentDao;
	@Autowired private HL7FieldDao hl7FieldDao;
	@Autowired private MappingService mappingService;
	
	@RequestMapping(value = "/getForAddInit", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<MappingAddModel> getForAddInit() {
		
		MappingAddModel model = new MappingAddModel();
		List<Resource> resourceList = null;
		List<BaseProfileType> baseProfileList = null;

		try {
			resourceList = resourceDao.getAll();
			baseProfileList = baseProfileTypeDao.getAll();
			
			model.setResourceList(resourceList);
			model.setBaseProfileTypeList(baseProfileList);
			
		} catch (SecurityException se) {
			LOG.warn(se.toString());
			return new ResponseEntity<MappingAddModel>(HttpStatus.UNAUTHORIZED);
		} catch (Throwable t) {
			LOG.error(t.getMessage());
			return new ResponseEntity<MappingAddModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<MappingAddModel>(model, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/getList/{searchStr}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<MappingDetailMaster>> getList(@PathVariable String searchStr) {
		
		List<MappingDetailMaster> response = new ArrayList<MappingDetailMaster>();
		String apiURL = env.getProperty("translatorApiURL");
		String result = null;
		try {
			
			String path = apiURL + "getall/" ;
			LOG.info("path : " +  path);result = mappingService.getResponseFromAPI(path);
			if (StringUtils.isNotBlank(result)) {
				ObjectMapper mapper = new ObjectMapper();
				List<MappingDetailMaster> mappingList = mapper.readValue(result, new TypeReference<List<MappingDetailMaster>>(){});
				if (mappingList != null  && ! searchStr.equalsIgnoreCase("~")) {
					response = mappingList.parallelStream().filter(mapping -> mapping.getName().contains(searchStr)
							|| (StringUtils.isNotBlank(mapping.getReferenceUrlOptions()) && mapping.getReferenceUrlOptions().contains(searchStr))
							|| (StringUtils.isNotBlank(mapping.getResourceCreationRules()) && mapping.getResourceCreationRules().contains(searchStr))
							|| (StringUtils.isNotBlank(mapping.getMappingType()) && mapping.getMappingType().contains(searchStr))
							|| (StringUtils.isNotBlank(mapping.getMessageType()) && mapping.getMessageType().contains(searchStr))
							|| (StringUtils.isNotBlank(mapping.getBundleType()) && mapping.getBundleType().contains(searchStr))
							|| (StringUtils.isNotBlank(mapping.getStatus()) && mapping.getStatus().contains(searchStr))
							).collect(Collectors.toList());
				} else {
					response = mappingList;
				}
			}
			
		} catch (SecurityException se) {
			LOG.warn(se.toString());
			return new ResponseEntity<List<MappingDetailMaster>>(HttpStatus.UNAUTHORIZED);
		} catch (Throwable t) {
			LOG.error(t.getMessage());
			return new ResponseEntity<List<MappingDetailMaster>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<List<MappingDetailMaster>>(response, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = "/{mappingId}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getById(@PathVariable String mappingId) {
		
		String apiURL = env.getProperty("translatorApiURL");
		String result = null;
		try {
			
			String path = apiURL + "get/" + mappingId ;
			LOG.info("path : " +  path);
			
			result = mappingService.getResponseFromAPI(path);
			
		} catch (SecurityException se) {
			LOG.warn(se.toString());
			return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
		} catch (Throwable t) {
			LOG.error(t.getMessage());
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/delete/{mappingId}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> delete(@PathVariable String mappingId) {
		
		String apiURL = env.getProperty("translatorApiURL");
		String result = null;
		try {
			
			String path = apiURL + "delete/" + mappingId ;
			LOG.info("path : " +  path);
			
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpDelete deleteRequest = new HttpDelete(path);

			HttpResponse response = httpClient.execute(deleteRequest);
			
			LOG.info("Status Line :" + response.getStatusLine().getStatusCode());
			//if (response.getStatusLine().getStatusCode() == 200) 
			
		} catch (SecurityException se) {
			LOG.warn(se.toString());
			return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
		} catch (Throwable t) {
			LOG.error(t.getMessage());
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Void> addMapping(@RequestBody MappingDetailMaster mapping ) {
		JSONObject inputMappingJSON = null;
		String apiURL = env.getProperty("translatorApiURL");
		HttpResponse response = null;
		String path = null;
		StringEntity inputForApi = null;
		String mappingId = null;
		String webUser = "admin";
		
		try	{			
			//Code  for calling mapping API translator
			
			inputMappingJSON = mappingService.createMappingInputForAPI(mapping , "Add");
			inputForApi = new StringEntity(inputMappingJSON.toString());
			inputForApi.setContentType("application/json");
//			LOG.info("Input for API :" + inputMappingJSON);
			path = apiURL + "create";
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpPost request = new HttpPost(path);
			request.setEntity(inputForApi);
			response = httpClient.execute(request);
						
			/*LOG.info("Status code:" + response.getStatusLine().getStatusCode());
			LOG.info("Status Line :" + response.getStatusLine());
			LOG.info("resposne :" + response.toString());
			LOG.info("message:" + response.getEntity().getContent());*/
			
			if (response.getStatusLine().getStatusCode() == 201) {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(response.getEntity().getContent()));

					StringBuffer stringBuffer = new StringBuffer();
					String line = "";
					while ((line = reader.readLine()) != null) {
						stringBuffer.append(line);
					}
					mappingId = stringBuffer.toString();
			}
			
			mappingService.updateWorkFlowStatus(mappingId,"development" ,webUser);
			
		} catch (SecurityException se) {
			LOG.warn(se);
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		} catch (Throwable t) {
			LOG.error(t.getMessage());
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@Transactional
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Void> saveMapping(@RequestBody MappingDetailMaster mapping ) {
		JSONObject inputMappingJSON = null;
		String webUser = "admin";
		String apiURL = env.getProperty("translatorApiURL");
		HttpResponse response = null;
		String path = null;
		StringEntity inputForApi = null;
		
		try	{			
			//Code  for calling mapping API translator
			
			inputMappingJSON = mappingService.createMappingInputForAPI(mapping ,"update");
			LOG.info("Input for API :" + inputMappingJSON);
			inputForApi = new StringEntity(inputMappingJSON.toString());
			inputForApi.setContentType("application/json");
			path = apiURL + "update/" + mapping.getId();
			LOG.info("path :" +  path);
			
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpPut request = new HttpPut(path);
			request.setEntity(inputForApi);
			response = httpClient.execute(request);
					
		/*	if (response.getStatusLine().getStatusCode() != 201  && response.getStatusLine().getStatusCode() != 200) {
				throw new Exception("Unable to connect to translator API");
			} 
			LOG.info("Status code:" + response.getStatusLine().getStatusCode());
			LOG.info("Status Line :" + response.getStatusLine());
			LOG.info("resposne :" + response.toString());
			LOG.info("message:" + response.getEntity().getContent());
			*/
			if (mapping.isMarkedComplete()) {
				mappingService.updateWorkFlowStatus(mapping.getId(),"testing", webUser );
			} else {
				mappingService.updateWorkFlowStatus(mapping.getId(),"development", webUser );
			}
			
		} catch (SecurityException se) {
			LOG.warn(se);
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		} catch (Throwable t) {
			LOG.error(t.getMessage());
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = "/getForNewMapping", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<MappingAddModel> getForNewMapping(@RequestBody MappingDetailMaster mappingOptions ) {
		List<ProfileField> allFieldList = null;
		List<HL7Field> hl7fieldList = null;
		List<HL7Segment> hl7segmentList = null;
		List<ProfileField> mandatoryFieldList = null;
		List<ProfileField> optionalFieldList = null;
		List<ProfileField> customFieldList = null;
		ProfileFieldSearch search = new ProfileFieldSearch();
		
		MappingAddModel response = new MappingAddModel();
		
		try {
			allFieldList = profileFieldDao.getAllByProfileId(mappingOptions.getBaseProfileTypeId());
			hl7segmentList = hl7SegmentDao.getAll();
			hl7fieldList = hl7FieldDao.getAll();
						
			search.setProfileTypeId(mappingOptions.getBaseProfileTypeId());
			
			//Only required Fields
			search.setRequired(true);
			mandatoryFieldList = profileFieldDao.getList(search);
			
			//Only optional Fields
			search.setRequired(false);
			search.setOptional(true);
			optionalFieldList = profileFieldDao.getList(search);
			
			//Only custom Fields
			search.setExtension(true);
			search.setRequired(false);
			search.setOptional(false);
			customFieldList = profileFieldDao.getList(search);
			
			hl7segmentList = hl7SegmentDao.getAll();
			hl7fieldList = hl7FieldDao.getAll();
			
			response.setAllFieldList(allFieldList);
			response.setHl7fieldList(hl7fieldList);
			response.setSegmentList(hl7segmentList);
			response.setCustomFieldList(customFieldList);
			response.setMandatoryFieldList(mandatoryFieldList);
			response.setOptionalFieldList(optionalFieldList);
			
		} catch (SecurityException se) {
			LOG.warn(se);
			return new ResponseEntity<MappingAddModel>(HttpStatus.UNAUTHORIZED);
		} catch (Throwable t) {
			LOG.error(t);
			return new ResponseEntity<MappingAddModel>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<MappingAddModel>(response, HttpStatus.OK);
	}
	
	
	@Transactional
	@RequestMapping(value = "/changeStatus/{targetStatusCode}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> changeStatus(@PathVariable String targetStatusCode ,@RequestBody MappingDetailMaster mapping) {
		String webUser = "admin";	
		
		try {
					
			if ("deployed".equalsIgnoreCase(targetStatusCode)) {
				mappingService.promoteMapping(mapping.getId(), webUser);
			} else if ("suspended".equalsIgnoreCase(targetStatusCode)) {
				mappingService.suspendMapping(mapping.getId(), webUser);
			}	else if ("reviewed".equalsIgnoreCase(targetStatusCode) ||  "testing".equalsIgnoreCase(targetStatusCode) || "development".equalsIgnoreCase(targetStatusCode)
					|| "onHold".equalsIgnoreCase(targetStatusCode)) {
				mappingService.changeStatus(mapping.getId(), targetStatusCode ,webUser);
				mappingService.updateWorkFlowStatus(mapping.getId(), targetStatusCode , webUser);
			}
			
			
			if ( ! StringUtils.equalsIgnoreCase(mapping.getStatus() , targetStatusCode)) {
				
				mapping.setStatus(targetStatusCode);
				saveMapping(mapping);
			}
			
		} catch (SecurityException se) {
			LOG.warn(se);
			return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
		} catch (Throwable t) {
			LOG.error(t);
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<String>( HttpStatus.OK);
	}
	
	
	
	
	
	private class MappingAddModel {
		
		private List<Resource> resourceList;
		private List<BaseProfileType>  baseProfileTypeList;
		private List<ProfileField> mandatoryFieldList;
		private List<ProfileField> optionalFieldList;
		private List<ProfileField> customFieldList;
		private List<ProfileField> allFieldList;
		private List<HL7Segment> segmentList;
		private List<HL7Field> hl7fieldList;
		
		
		public List<Resource> getResourceList() {
			return resourceList;
		}
		public void setResourceList(List<Resource> resourceList) {
			this.resourceList = resourceList;
		}		
		public List<ProfileField> getMandatoryFieldList() {
			return mandatoryFieldList;
		}
		public void setMandatoryFieldList(List<ProfileField> mandatoryFieldList) {
			this.mandatoryFieldList = mandatoryFieldList;
		}
		public List<ProfileField> getOptionalFieldList() {
			return optionalFieldList;
		}
		public void setOptionalFieldList(List<ProfileField> optionalFieldList) {
			this.optionalFieldList = optionalFieldList;
		}
		public List<ProfileField> getCustomFieldList() {
			return customFieldList;
		}
		public void setCustomFieldList(List<ProfileField> customFieldList) {
			this.customFieldList = customFieldList;
		}
		public List<HL7Segment> getSegmentList() {
			return segmentList;
		}
		public void setSegmentList(List<HL7Segment> segmentList) {
			this.segmentList = segmentList;
		}
		public List<HL7Field> getHl7fieldList() {
			return hl7fieldList;
		}
		public void setHl7fieldList(List<HL7Field> hl7fieldList) {
			this.hl7fieldList = hl7fieldList;
		}
		public List<ProfileField> getAllFieldList() {
			return allFieldList;
		}
		public void setAllFieldList(List<ProfileField> allFieldList) {
			this.allFieldList = allFieldList;
		}
		public List<BaseProfileType> getBaseProfileTypeList() {
			return baseProfileTypeList;
		}
		public void setBaseProfileTypeList(List<BaseProfileType> baseProfileTypeList) {
			this.baseProfileTypeList = baseProfileTypeList;
		}
	
	}	

}
