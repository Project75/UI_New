package com.nttdata.fhir.model;

import java.util.List;

public class MappingMasterForApi {
	
	
	private String name;
    private String status;
    private String resources;
    private List <?> mappingDetail;
    
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getResources() {
		return resources;
	}
	public void setResources(String resources) {
		this.resources = resources;
	}
	public List<?> getMappingDetail() {
		return mappingDetail;
	}
	public void setMappingDetail(List<?> mappingDetail) {
		this.mappingDetail = mappingDetail;
	}
    
    

}
