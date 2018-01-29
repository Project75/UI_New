package com.nttdata.fhir.dao;

import java.util.List;

import com.nttdata.fhir.model.HL7Field;

public interface HL7FieldDao {
	
	public List<HL7Field> getAll();

}
