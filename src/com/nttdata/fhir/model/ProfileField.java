package com.nttdata.fhir.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nttdata.fhir.model.mybatis.ProfileFieldVO;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfileField extends ProfileFieldVO {
	
	private int noOfMinOccurences;
	private int totalOccurences = 1;
		
	//Below fields are used for API input  format
	
	private String hl7Segment;
	private String hl7Field;
	private String staticValue;
	
	public String getStaticValue() {
		return staticValue;
	}

	public void setStaticValue(String staticValue) {
		this.staticValue = staticValue;
	}

	private List<HL7Field> hl7fieldList;	

	
	public List<HL7Field> getHl7fieldList() {
		return hl7fieldList;
	}

	public void setHl7fieldList(List<HL7Field> hl7fieldList) {
		this.hl7fieldList = hl7fieldList;
	}

	public String getHl7Segment() {
		return hl7Segment;
	}

	public void setHl7Segment(String hl7Segment) {
		this.hl7Segment = hl7Segment;
	}

	public String getHl7Field() {
		return hl7Field;
	}

	public void setHl7Field(String hl7Field) {
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

	public List<String> getStaticValuesList() {
		
		List<String> staticValuesList = null;
		
		if (StringUtils.isNotBlank(getStaticValues())) {
			StringTokenizer st = new StringTokenizer(getStaticValues(), "|");
			staticValuesList = new ArrayList<String>();
			 while(st.hasMoreTokens()) {
		        	staticValuesList.add(st.nextToken().trim());
			 }  	
		}	
		return staticValuesList;
	}	
	

}
