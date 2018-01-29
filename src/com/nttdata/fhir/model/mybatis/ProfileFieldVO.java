package com.nttdata.fhir.model.mybatis;

import com.nttdata.fhir.model.DataObject;
import java.io.Serializable;

public class ProfileFieldVO extends DataObject implements Serializable {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column profilefield.id
	 * @mbg.generated  Tue Jan 23 20:49:41 IST 2018
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column profilefield.profileTypeId
	 * @mbg.generated  Tue Jan 23 20:49:41 IST 2018
	 */
	private Integer profileTypeId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column profilefield.resourceId
	 * @mbg.generated  Tue Jan 23 20:49:41 IST 2018
	 */
	private Integer resourceId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column profilefield.fieldName
	 * @mbg.generated  Tue Jan 23 20:49:41 IST 2018
	 */
	private String fieldName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column profilefield.description
	 * @mbg.generated  Tue Jan 23 20:49:41 IST 2018
	 */
	private String description;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column profilefield.isRequired
	 * @mbg.generated  Tue Jan 23 20:49:41 IST 2018
	 */
	private Boolean isRequired;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column profilefield.isRepetitive
	 * @mbg.generated  Tue Jan 23 20:49:41 IST 2018
	 */
	private Boolean isRepetitive;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column profilefield.isCustomField
	 * @mbg.generated  Tue Jan 23 20:49:41 IST 2018
	 */
	private Boolean isCustomField;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table profilefield
	 * @mbg.generated  Tue Jan 23 20:49:41 IST 2018
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column profilefield.id
	 * @return  the value of profilefield.id
	 * @mbg.generated  Tue Jan 23 20:49:41 IST 2018
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column profilefield.id
	 * @param id  the value for profilefield.id
	 * @mbg.generated  Tue Jan 23 20:49:41 IST 2018
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column profilefield.profileTypeId
	 * @return  the value of profilefield.profileTypeId
	 * @mbg.generated  Tue Jan 23 20:49:41 IST 2018
	 */
	public Integer getProfileTypeId() {
		return profileTypeId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column profilefield.profileTypeId
	 * @param profileTypeId  the value for profilefield.profileTypeId
	 * @mbg.generated  Tue Jan 23 20:49:41 IST 2018
	 */
	public void setProfileTypeId(Integer profileTypeId) {
		this.profileTypeId = profileTypeId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column profilefield.resourceId
	 * @return  the value of profilefield.resourceId
	 * @mbg.generated  Tue Jan 23 20:49:41 IST 2018
	 */
	public Integer getResourceId() {
		return resourceId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column profilefield.resourceId
	 * @param resourceId  the value for profilefield.resourceId
	 * @mbg.generated  Tue Jan 23 20:49:41 IST 2018
	 */
	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column profilefield.fieldName
	 * @return  the value of profilefield.fieldName
	 * @mbg.generated  Tue Jan 23 20:49:41 IST 2018
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column profilefield.fieldName
	 * @param fieldName  the value for profilefield.fieldName
	 * @mbg.generated  Tue Jan 23 20:49:41 IST 2018
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName == null ? null : fieldName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column profilefield.description
	 * @return  the value of profilefield.description
	 * @mbg.generated  Tue Jan 23 20:49:41 IST 2018
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column profilefield.description
	 * @param description  the value for profilefield.description
	 * @mbg.generated  Tue Jan 23 20:49:41 IST 2018
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column profilefield.isRequired
	 * @return  the value of profilefield.isRequired
	 * @mbg.generated  Tue Jan 23 20:49:41 IST 2018
	 */
	public Boolean getIsRequired() {
		return isRequired;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column profilefield.isRequired
	 * @param isRequired  the value for profilefield.isRequired
	 * @mbg.generated  Tue Jan 23 20:49:41 IST 2018
	 */
	public void setIsRequired(Boolean isRequired) {
		this.isRequired = isRequired;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column profilefield.isRepetitive
	 * @return  the value of profilefield.isRepetitive
	 * @mbg.generated  Tue Jan 23 20:49:41 IST 2018
	 */
	public Boolean getIsRepetitive() {
		return isRepetitive;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column profilefield.isRepetitive
	 * @param isRepetitive  the value for profilefield.isRepetitive
	 * @mbg.generated  Tue Jan 23 20:49:41 IST 2018
	 */
	public void setIsRepetitive(Boolean isRepetitive) {
		this.isRepetitive = isRepetitive;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column profilefield.isCustomField
	 * @return  the value of profilefield.isCustomField
	 * @mbg.generated  Tue Jan 23 20:49:41 IST 2018
	 */
	public Boolean getIsCustomField() {
		return isCustomField;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column profilefield.isCustomField
	 * @param isCustomField  the value for profilefield.isCustomField
	 * @mbg.generated  Tue Jan 23 20:49:41 IST 2018
	 */
	public void setIsCustomField(Boolean isCustomField) {
		this.isCustomField = isCustomField;
	}
}