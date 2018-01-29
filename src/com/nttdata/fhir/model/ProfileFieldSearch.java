package com.nttdata.fhir.model;

public class ProfileFieldSearch {
	
	
	private String profileTypeId;
	private boolean repetitive;
	private boolean required;
	private boolean customField;
	private boolean optional;
	
	
	public String getProfileTypeId() {
		return profileTypeId;
	}
	
	public void setProfileTypeId(String profileTypeId) {
		this.profileTypeId = profileTypeId;
	}
	
	public boolean isRepetitive() {
		return repetitive;
	}
	
	public void setRepetitive(boolean repetitive) {
		this.repetitive = repetitive;
	}
	
	public boolean isRequired() {
		return required;
	}
	
	public void setRequired(boolean required) {
		this.required = required;
	}
	
	public boolean isCustomField() {
		return customField;
	}
	
	public void setCustomField(boolean customField) {
		this.customField = customField;
	}
	
	public boolean isOptional() {
		return optional;
	}
	
	public void setOptional(boolean optional) {
		this.optional = optional;
	}
	
}
