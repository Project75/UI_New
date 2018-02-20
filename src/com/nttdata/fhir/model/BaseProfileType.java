package com.nttdata.fhir.model;

import java.util.List;

import com.nttdata.fhir.model.mybatis.BaseProfileTypeVO;

public class BaseProfileType extends BaseProfileTypeVO {
	
	
	private List<ProfileField> fieldList;

	public List<ProfileField> getFieldList() {
		return fieldList;
	}

	public void setFieldList(List<ProfileField> fieldList) {
		this.fieldList = fieldList;
	}

}
