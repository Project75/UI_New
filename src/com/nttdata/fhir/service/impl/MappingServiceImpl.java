package com.nttdata.fhir.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.nttdata.fhir.model.MappingOptions;
import com.nttdata.fhir.model.ProfileField;
import com.nttdata.fhir.service.MappingService;


@Component(value="mappingServiceImpl")
public class MappingServiceImpl implements MappingService{

	@Override
	public JSONArray createMappingInputForAPI(MappingOptions mapping)  throws Exception{
		JSONObject jObject = new JSONObject();
		 JSONArray jArray = new JSONArray();
		 
		 for (ProfileField field : mapping.getMappedFields())
		    {
		         JSONObject mappingJson = new JSONObject();
		         
		         if ((field.getHl7Field() != null) && StringUtils.isNotEmpty(field.getFieldName()) 
		        		 && StringUtils.isNotEmpty(field.getHl7Field().getFieldName())) {
		        	 mappingJson.put("fhir", field.getFieldName());
		        	 mappingJson.put("hl7", field.getHl7Field().getFieldName());
		        	 
			         jArray.put(mappingJson);
		         }
		    }
		    jObject.put("mappingFields", jArray);
			return jArray;
	}

}
