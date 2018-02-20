package com.nttdata.fhir.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class MappingOptions {
	
	String mappingName;
	String id;
	String baseProfileTypeId;
	String mappingType;
	String messageType;
	String bundleType;
	String referenceUrlOptions;
	String resourceCreationRule;
	String additionalNotes;
	
	List<Resource> selectedResources;
	List<ProfileField>  mappedFields;
 	
	
	public String getId() {
		return id;
	}

	public void setId(String mappingId) {
		this.id = mappingId;
	}

	public String getReferenceUrlOptions() {
		return referenceUrlOptions;
	}

	public void setReferenceUrlOptions(String referenceUrlOptions) {
		this.referenceUrlOptions = referenceUrlOptions;
	}

	public String getAdditionalNotes() {
		return additionalNotes;
	}

	public void setAdditionalNotes(String additionalNotes) {
		this.additionalNotes = additionalNotes;
	}

	public String getMappingName() {
		return mappingName;
	}
	
	public void setMappingName(String mappingName) {
		this.mappingName = mappingName;
	}
	
	public String getBaseProfileTypeId() {
		return baseProfileTypeId;
	}
	
	public void setBaseProfileTypeId(String baseProfileTypeId) {
		this.baseProfileTypeId = baseProfileTypeId;
	}

	public String getMappingType() {
		return mappingType;
	}

	public void setMappingType(String mappingType) {
		this.mappingType = mappingType;
	}

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getBundleType() {
		return bundleType;
	}

	public void setBundleType(String bundleType) {
		this.bundleType = bundleType;
	}

	public String getResourceCreationRule() {
		return resourceCreationRule;
	}

	public void setResourceCreationRule(String resourceCreationRule) {
		this.resourceCreationRule = resourceCreationRule;
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
