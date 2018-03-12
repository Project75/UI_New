package com.nttdata.fhir.dao;

import org.apache.ibatis.annotations.Param;

import com.nttdata.fhir.model.WorkflowStatus;

public interface WorkflowStatusDao {
	
	
	public WorkflowStatus getByStatusCode(@Param ("code") String code);

}
