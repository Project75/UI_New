package com.nttdata.fhir.service;

import org.json.JSONObject;

import com.nttdata.fhir.model.MappingOptions;

public interface MappingService {
	
	public JSONObject createMappingInputForAPI(MappingOptions mapping) throws Exception;
	
	public String getResponseFromAPI(String url) throws Exception;

}
