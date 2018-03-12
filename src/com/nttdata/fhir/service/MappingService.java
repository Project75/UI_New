package com.nttdata.fhir.service;

import org.json.JSONObject;

import com.nttdata.fhir.model.MappingDetailMaster;

public interface MappingService {
	
	public String getResponseFromAPI(String url) throws Exception;

	public JSONObject createMappingInputForAPI(MappingDetailMaster mapping, String action) throws Exception;
	
	public void updateWorkFlowStatus(String mappingId , String newStatus , String webUser) throws Exception;

	public void promoteMapping(String mappingId, String webUser) throws Exception;

	public void suspendMapping(String mappingId, String webUser)throws Exception;

	public void changeStatus(String mappingId, String targetStatusCode, String webUser) throws Exception;

}
