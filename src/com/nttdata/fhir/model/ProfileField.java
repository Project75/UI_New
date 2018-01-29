package com.nttdata.fhir.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nttdata.fhir.model.mybatis.ProfileFieldVO;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfileField extends ProfileFieldVO {
	
	private int noOfMinOccurences;
	private int totalOccurences = 1;
	
	//Below fields are used for API input  format
	//private String fhir;
	private HL7Segment hl7Segment;
	private HL7Field hl7Field;
	
	private List<HL7Field> hl7fieldList;	

	
	public List<HL7Field> getHl7fieldList() {
		return hl7fieldList;
	}

	public void setHl7fieldList(List<HL7Field> hl7fieldList) {
		this.hl7fieldList = hl7fieldList;
	}
/*
	public String getFhir() {
		return fhir;
	}

	public void setFhir(String fhir) {
		this.fhir = fhir;
	}*/

	public HL7Segment getHl7Segment() {
		return hl7Segment;
	}

	public void setHl7Segment(HL7Segment hl7Segment) {
		this.hl7Segment = hl7Segment;
	}

	public HL7Field getHl7Field() {
		return hl7Field;
	}

	public void setHl7Field(HL7Field hl7Field) {
		this.hl7Field = hl7Field;
	}

	public int getNoOfMinOccurences() {
		
		if (getIsRequired() == true) {
			noOfMinOccurences = 1;
		} else {
			noOfMinOccurences = 0;
		}
		
		return noOfMinOccurences;
	}

	public void setNoOfMinOccurences(int noOfMinOccurences) {
		this.noOfMinOccurences = noOfMinOccurences;
	}

	public int getTotalOccurences() {
		return totalOccurences;
	}

	public void setTotalOccurences(int totalOccurences) {
		this.totalOccurences = totalOccurences;
	}
	
	

}
