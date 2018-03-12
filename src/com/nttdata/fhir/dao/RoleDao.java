package com.nttdata.fhir.dao;

import org.apache.ibatis.annotations.Param;

import com.nttdata.fhir.model.Role;

public interface RoleDao {
	
	public Role getById(@Param("id") String id);
	
	public Role getByRole(@Param("role") String role);

}
