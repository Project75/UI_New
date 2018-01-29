package com.nttdata.fhir.dao;

import java.util.List;

import com.nttdata.fhir.model.Resource;


public interface ResourceDao {
	
	public List<Resource> getAll();
	
	public Resource getById(String resourceId);

}
