package com.nttdata.fhir.model.mybatis;

import com.nttdata.fhir.model.DataObject;
import java.io.Serializable;
import java.util.Date;

public class HL7FieldVO extends DataObject implements Serializable {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column hl7field.fieldId
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	private Integer fieldId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column hl7field.segmentId
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	private Integer segmentId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column hl7field.segmentName
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	private String segmentName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column hl7field.fieldName
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	private String fieldName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column hl7field.isActive
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	private Boolean isActive;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table hl7field
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column hl7field.fieldId
	 * @return  the value of hl7field.fieldId
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public Integer getFieldId() {
		return fieldId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column hl7field.fieldId
	 * @param fieldId  the value for hl7field.fieldId
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public void setFieldId(Integer fieldId) {
		this.fieldId = fieldId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column hl7field.segmentId
	 * @return  the value of hl7field.segmentId
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public Integer getSegmentId() {
		return segmentId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column hl7field.segmentId
	 * @param segmentId  the value for hl7field.segmentId
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public void setSegmentId(Integer segmentId) {
		this.segmentId = segmentId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column hl7field.segmentName
	 * @return  the value of hl7field.segmentName
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public String getSegmentName() {
		return segmentName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column hl7field.segmentName
	 * @param segmentName  the value for hl7field.segmentName
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public void setSegmentName(String segmentName) {
		this.segmentName = segmentName == null ? null : segmentName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column hl7field.fieldName
	 * @return  the value of hl7field.fieldName
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column hl7field.fieldName
	 * @param fieldName  the value for hl7field.fieldName
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName == null ? null : fieldName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column hl7field.isActive
	 * @return  the value of hl7field.isActive
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column hl7field.isActive
	 * @param isActive  the value for hl7field.isActive
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
}