package com.nttdata.fhir.model;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class MappingDetailMaster {
	
	private String name;
	private String id;
	private String baseProfileTypeId;
	private String mappingType;
	private String messageType;
	private String bundleType;
	private String referenceUrlOptions;
	private String resourceCreationRules;
	private String additionalNotes;
	private String status;
	private String resources;
	
	private boolean markedComplete;
	
	
	private List<Resource> selectedResources;
	private List<ProfileField>  mappingDetail;
 

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

	public String getName() {
		return name;
	}
	
	public void setName(String mappingName) {
		this.name = mappingName;
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

	public String getResourceCreationRules() {
		return resourceCreationRules;
	}

	public void setResourceCreationRule(String resourceCreationRule) {
		this.resourceCreationRules = resourceCreationRule;
	}

	public List<Resource> getSelectedResources() {
		return selectedResources;
	}

	public void setSelectedResources(List<Resource> selectedResources) {
		this.selectedResources = selectedResources;
	}

	public List<ProfileField> getMappingDetail() {
		return mappingDetail;
	}

	public void setMappedFields(List<ProfileField> mappingDetail) {
		this.mappingDetail = mappingDetail;
	}
	
	/*public String getSelectedResourcesAsString() {
		String retVal = null;	
		
		retVal = selectedResources.stream().map(resource -> resource.getName())
				 .collect(Collectors.joining(","));
		return retVal;
	}*/

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResources() {
		if (resources == null) {
			if (selectedResources != null && selectedResources.size() > 0) {
				resources = selectedResources.stream().map(resource -> resource.getName())
						 .collect(Collectors.joining(","));
			}
		}
		
		return resources;
	}

	public void setResources(String resources) {
		this.resources = resources;
	}

	public boolean isMarkedComplete() {
		
		/*
		if (getStatus().equalsIgnoreCase("Development")) {
			markedComplete = false;
		} else if (StringUtils.isNotBlank(getStatus())){
			markedComplete = true;
		}*/
		
		return markedComplete;
	}

	public void setMarkedComplete(boolean markedComplete) {
		this.markedComplete = markedComplete;
	}

	
	

}
