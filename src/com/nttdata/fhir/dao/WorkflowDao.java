package com.nttdata.fhir.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nttdata.fhir.model.Workflow;

public interface WorkflowDao {
	
	public List<Workflow> getAll();
	
	
	public List<Workflow> getAllByMappingId(@Param("mappingId") String mappingId , @Param("activeOnly") boolean activeOnly);
	
	/**
	 * Updates the end date to the past date for all active workflow entries
	 * 
	 * @param List<Workflow> WorkflowList
	 */
	public void updateAll(@Param("workflowList") List<Workflow> workflowList, @Param("webUser") String webUser);
	

}
