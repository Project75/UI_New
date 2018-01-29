package com.nttdata.fhir.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.nttdata.fhir.model.ProfileField;
import com.nttdata.fhir.model.ProfileFieldSearch;


public interface ProfileFieldDao  {
	
	public List<ProfileField> getAllByProfileId(@Param("profileTypeId") String profileTypeId);
	
	public List<ProfileField> getList(@Param("search") ProfileFieldSearch search);

}
