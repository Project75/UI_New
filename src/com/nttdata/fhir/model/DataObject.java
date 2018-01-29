package com.nttdata.fhir.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;


public class DataObject implements Serializable {
	
	private static final long serialVersionUID = 4203674133634302855L;
		
	private String createdBy;
	private Date createdOn;
	/*private String modifiedBy;
	private Date modifiedOn;
	*/
	
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
	

	
	public void updateModificationData(String user) {
		Date currentDate = new Date();
		
		if (StringUtils.isBlank(createdBy)) {
			setCreatedBy(user);
			setCreatedOn(currentDate);
		}
	}
	
}
