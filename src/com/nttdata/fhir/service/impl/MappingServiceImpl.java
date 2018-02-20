package com.nttdata.fhir.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.nttdata.fhir.model.MappingOptions;
import com.nttdata.fhir.model.ProfileField;
import com.nttdata.fhir.service.MappingService;


@Component(value="mappingServiceImpl")
public class MappingServiceImpl implements MappingService{
	
	//Field used for programmer logging
	private static final Logger LOG = LogManager.getLogger(MappingServiceImpl.class);

	@Override
	public JSONObject createMappingInputForAPI(MappingOptions mapping)  throws Exception{
		JSONObject jObject = new JSONObject();
		 JSONArray jArray = new JSONArray();
		 
		 jObject.put("name", mapping.getMappingName());
		 for (ProfileField field : mapping.getMappedFields())
		    {
		         JSONObject mappingJson = new JSONObject();
		         
		         if ((field.getHl7Field() != null) && StringUtils.isNotEmpty(field.getFieldName()) 
		        		 && StringUtils.isNotEmpty(field.getHl7Field())) {
		        	 mappingJson.put("fieldName", field.getFieldName());
		        	 mappingJson.put("hl7Field", field.getHl7Field());
		        	 mappingJson.put("staticValue", field.getStaticValue());
		        	 mappingJson.put("hl7Segment", field.getHl7Segment());
		        	 mappingJson.put("isRequired", field.getIsExtension());
		        	 mappingJson.put("isRepeating", field.getIsRepeating());
		        	 mappingJson.put("isExtension", field.getIsExtension());
		        	 
			         jArray.put(mappingJson);
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
			System.out.println("result :"  + result);
		} else {
			LOG.warn("Connection not established to Translator API !");
		}
		
		return result;
	}

}
