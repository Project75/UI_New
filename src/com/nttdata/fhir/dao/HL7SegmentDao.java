package com.nttdata.fhir.dao;

import java.util.List;

import com.nttdata.fhir.model.HL7Segment;

public interface HL7SegmentDao {
	
	public List<HL7Segment> getAll();

}
