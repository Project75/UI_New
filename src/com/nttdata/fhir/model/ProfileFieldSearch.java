package com.nttdata.fhir.model;

public class ProfileFieldSearch {
	
	
	private String profileTypeId;
	private boolean repeating;
	private boolean required;
	private boolean extension;
	private boolean optional;
	
	
	public String getProfileTypeId() {
		return profileTypeId;
	}
	
	public void setProfileTypeId(String profileTypeId) {
		this.profileTypeId = profileTypeId;
	}
	
	public boolean isRequired() {
		return required;
	}
	
	public void setRequired(boolean required) {
		this.required = required;
	}
	
	public boolean isOptional() {
		return optional;
	}
	
	public void setOptional(boolean optional) {
		this.optional = optional;
	}

	public boolean isRepeating() {
		return repeating;
	}

	public void setRepeating(boolean repeating) {
		this.repeating = repeating;
	}

	public boolean isExtension() {
		return extension;
	}

	public void setExtension(boolean extension) {
		this.extension = extension;
	}
	
	
	
}
