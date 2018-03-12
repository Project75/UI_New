package com.nttdata.fhir.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nttdata.fhir.dao.RoleDao;
import com.nttdata.fhir.dao.WorkflowDao;
import com.nttdata.fhir.dao.WorkflowStatusDao;
import com.nttdata.fhir.dao.helper.WorkflowHelper;
import com.nttdata.fhir.model.MappingDetailMaster;
import com.nttdata.fhir.model.ProfileField;
import com.nttdata.fhir.model.Role;
import com.nttdata.fhir.model.Workflow;
import com.nttdata.fhir.model.WorkflowStatus;
import com.nttdata.fhir.service.MappingService;


@Component(value="mappingServiceImpl")
public class MappingServiceImpl implements MappingService{
	
	//Field used for programmer logging
	private static final Logger LOG = LogManager.getLogger(MappingServiceImpl.class);
	
	@Autowired private WorkflowDao workflowDao;
	@Autowired private WorkflowHelper workflowHelper;
	@Autowired private WorkflowStatusDao workflowSatusDao;
	@Autowired private RoleDao roleDao;

	@Override
	public JSONObject createMappingInputForAPI(MappingDetailMaster mapping , String action)  throws Exception{
		JSONObject jObject = new JSONObject();
		JSONArray jArray = new JSONArray();
		 
		 if (action.equalsIgnoreCase("Update")) {
			 jObject.put("id", mapping.getId());
		 }
		
		 jObject.put("name", mapping.getName());
		 jObject.put("additionalNotes", mapping.getAdditionalNotes());
		 jObject.put("baseProfileTypeId", mapping.getBaseProfileTypeId());
		 jObject.put("bundleType", mapping.getBundleType());
		 jObject.put("mappingType", mapping.getMappingType());
		 jObject.put("messageType", mapping.getMessageType());
		 jObject.put("referenceUrlOptions", mapping.getReferenceUrlOptions());
		 jObject.put("resourceCreationRules", mapping.getResourceCreationRules());
		 jObject.put("resources", mapping.getResources());
		 
		 if (mapping.isMarkedComplete()) {
			 jObject.put("status", "testing");
		 } else if (StringUtils.isNotBlank(mapping.getStatus())) {
			 jObject.put("status", mapping.getStatus());
		 } else {
			 jObject.put("status", "development"); 
		 } 
		
		 if ( mapping.getMappingDetail() != null  &&  mapping.getMappingDetail().size() > 0) {
			 for (ProfileField field : mapping.getMappingDetail())
			    {
			         JSONObject mappingJson = new JSONObject();
			         
			         if ((field.getHl7Field() != null) && StringUtils.isNotEmpty(field.getFieldName()) 
			        		 && StringUtils.isNotEmpty(field.getHl7Field())) {
			        	 
			        	 if (action.equalsIgnoreCase("Update")) {
			        		 mappingJson.put("id", field.getId() );
			        	 }
			        	 mappingJson.put("fieldName", field.getFieldName());
			        	 mappingJson.put("hl7Field", field.getHl7Field());
			        	 mappingJson.put("staticValue", field.getStaticValue());
			        	 mappingJson.put("hl7Segment", field.getHl7Segment());
			        	 mappingJson.put("isRequired", field.getIsRequired());
			        	 mappingJson.put("isRepeating", field.getIsRepeating());
			        	 mappingJson.put("isExtension", field.getIsExtension());
			        	 
				         jArray.put(mappingJson);
			         }
			    } 
		 }
		 
	 	
	    jObject.put("mappingDetail", jArray);
		return jObject;
	}

	@Override
	public String getResponseFromAPI(String url) throws Exception {
		
		String result = null;
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet getRequest = new HttpGet(url);

		HttpResponse response = httpClient.execute(getRequest);
		
		LOG.info("Status code:" + response.getStatusLine().getStatusCode());
		LOG.info("Status Line :" + response.getStatusLine());
		LOG.info("resposne :" + response.toString());
		LOG.info("message:" + response.getEntity().getContent());
		
		
		if (response.getStatusLine().getStatusCode() == 200) {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(response.getEntity().getContent()));

				StringBuffer stringBuffer = new StringBuffer();
				String line = "";
				while ((line = reader.readLine()) != null) {
					stringBuffer.append(line);
				}
			result = stringBuffer.toString();
		} else {
			LOG.warn("Connection not established to Translator API !");
		}
		
		return result;
	}

	@Override
	public void updateWorkFlowStatus(String mappingId, String newStatusCode , String webUser) throws Exception {
		
		Workflow newWorkflow = new Workflow();
		List<Workflow> existingWorkflows = workflowDao.getAllByMappingId(mappingId, true);
		WorkflowStatus nextWorkflowStatus =  workflowSatusDao.getByStatusCode(newStatusCode);
		Role role = roleDao.getByRole("admin");  //TODO  : Remove hard coding 
		
		newWorkflow.setMappingId(mappingId);
		newWorkflow.setAssignedToRoleId(role.getId());
		newWorkflow.setNotes(null);
		if (nextWorkflowStatus != null) {
			newWorkflow.setWorkflowStatusId(nextWorkflowStatus.getId());
		}
		
		workflowHelper.insert(newWorkflow, webUser);
		
		if (existingWorkflows.size() > 0) {
			workflowDao.updateAll(existingWorkflows, webUser);
		}	
		
		
	}

	@Override
	public void promoteMapping(String mappingId, String webUser) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void suspendMapping(String mappingId, String webUser) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeStatus(String mappingId, String targetStatusCode, String webUser) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	

}
