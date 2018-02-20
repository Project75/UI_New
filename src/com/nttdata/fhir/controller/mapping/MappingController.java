package com.nttdata.fhir.controller.mapping;

import java.util.List;

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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.fhir.dao.BaseProfileTypeDao;
import com.nttdata.fhir.dao.HL7FieldDao;
import com.nttdata.fhir.dao.HL7SegmentDao;
import com.nttdata.fhir.dao.ProfileFieldDao;
import com.nttdata.fhir.dao.ResourceDao;
import com.nttdata.fhir.model.BaseProfileType;
import com.nttdata.fhir.model.HL7Field;
import com.nttdata.fhir.model.HL7Segment;
import com.nttdata.fhir.model.MappingOptions;
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
	
	
	@RequestMapping(value = "/getList", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> getList() {
		
		String apiURL = env.getProperty("translatorApiURL");
		String result = null;
		try {
			
			String path = apiURL + "getall/" ;
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
	
	
	@RequestMapping(value = "/getById/{mappingId}", method = RequestMethod.GET)
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
	
	
	@RequestMapping(value = "/saveMappping", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Void> saveMappping(@RequestBody MappingOptions mapping ) {
		JSONObject inputMappingJSON = null;
		String apiURL = env.getProperty("translatorApiURL");
		HttpResponse response = null;
		String path = null;
		
		LOG.info("apiURL:" + apiURL);	
		
		try
			{
			inputMappingJSON = mappingService.createMappingInputForAPI(mapping);
			LOG.info("Input for API :" + inputMappingJSON);

			
			//Code  for calling mapping API translator
			
			HttpClient httpClient = HttpClientBuilder.create().build();
			StringEntity inputForApi = new StringEntity(inputMappingJSON.toString());
			inputForApi.setContentType("application/json");
			
			System.out.println("ID :" + mapping.getId());
			
			if (StringUtils.isNotBlank(mapping.getId())) {
				//Update
				
				path = apiURL + "update/" + mapping.getId();
				LOG.info("path :" +  path);
				HttpPut request = new HttpPut(path);
				request.setEntity(inputForApi);
				response = httpClient.execute(request);
			} else {
				//Add
				path = apiURL + "create";
				LOG.info("path :" +  path);
				HttpPost request = new HttpPost(path);
				request.setEntity(inputForApi);
				response = httpClient.execute(request);
			}			
			/*if (response.getStatusLine().getStatusCode() != 201  && response.getStatusLine().getStatusCode() != 200) {
				throw new Exception("Unable to connect to translator API");
			} */
			LOG.info("Status code:" + response.getStatusLine().getStatusCode());
			LOG.info("Status Line :" + response.getStatusLine());
			LOG.info("resposne :" + response.toString());
			LOG.info("message:" + response.getEntity().getContent());
			
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
	public ResponseEntity<MappingAddModel> getForNewMapping(@RequestBody MappingOptions mappingOptions ) {
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
