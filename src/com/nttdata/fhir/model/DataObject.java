package com.nttdata.fhir.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class DataObject implements Serializable {
	
	private static final long serialVersionUID = 4203674133634302855L;
	
	@JsonIgnore
	private String createdBy;
	
	@JsonIgnore
	private Date createdOn;
	
	@JsonIgnore
	private String modifiedBy;
	
	@JsonIgnore
	private Date modifiedOn;
	
	
	public String getCreatedBy() {
		return createdBy;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	
	
	public void updateCreationData(String user) {
		Date currentDate = new Date();
		if (StringUtils.isEmpty(this.createdBy)) {
			this.setCreatedBy(user);
			this.setCreatedOn(currentDate);
		}

		this.updateModificationData(user);
	}

	
	public void updateModificationData(String user) {
		Date currentDate = new Date();
		
		if (StringUtils.isBlank(createdBy)) {
			setCreatedBy(user);
			setCreatedOn(currentDate);
		}
		
		this.setModifiedBy(user);
		this.setModifiedOn(currentDate);
	}
	
	
}
