package com.nttdata.fhir.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class MappingOptions {
	
	String mappingName;
	//String mappingId;
	String baseProfileTypeId;
	List<Resource> selectedResources;
	List<ProfileField>  mappedFields;
 	
	public String getMappingName() {
		return mappingName;
	}
	
	public void setMappingName(String mappingName) {
		this.mappingName = mappingName;
	}
	
	/*public String getMappingId() {
		return mappingId;
	}
	
	public void setMappingId(String mappingId) {
		this.mappingId = mappingId;
	}*/
	
	public String getBaseProfileTypeId() {
		return baseProfileTypeId;
	}
	
	public void setBaseProfileTypeId(String baseProfileTypeId) {
		this.baseProfileTypeId = baseProfileTypeId;
	}

	public List<Resource> getSelectedResources() {
		return selectedResources;
	}

	public void setSelectedResources(List<Resource> selectedResources) {
		this.selectedResources = selectedResources;
	}

	public List<ProfileField> getMappedFields() {
		return mappedFields;
	}

	public void setMappedFields(List<ProfileField> mappedFields) {
		this.mappedFields = mappedFields;
	}
	
	
	

}
