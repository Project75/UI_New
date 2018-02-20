package com.nttdata.fhir.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nttdata.fhir.model.BaseProfileType;

public interface BaseProfileTypeDao {
	
	public List<BaseProfileType> getAll();
	
	public BaseProfileType getById(@Param("profileId") String profileId , @Param("includeFields") boolean includeFields);

}
