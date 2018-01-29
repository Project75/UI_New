package com.nttdata.fhir.service;

import org.json.JSONArray;

import com.nttdata.fhir.model.MappingOptions;

public interface MappingService {
	
	public JSONArray createMappingInputForAPI(MappingOptions mapping) throws Exception;

}
