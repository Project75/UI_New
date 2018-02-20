package com.nttdata.fhir.model.mybatis;

import com.nttdata.fhir.model.DataObject;
import java.io.Serializable;
import java.util.Date;

public class BaseProfileTypeVO extends DataObject implements Serializable {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column baseprofiletype.id
	 * @mbg.generated  Thu Feb 01 14:43:52 IST 2018
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column baseprofiletype.profileName
	 * @mbg.generated  Thu Feb 01 14:43:52 IST 2018
	 */
	private String profileName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column baseprofiletype.isActive
	 * @mbg.generated  Thu Feb 01 14:43:52 IST 2018
	 */
	private Boolean isActive;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column baseprofiletype.description
	 * @mbg.generated  Thu Feb 01 14:43:52 IST 2018
	 */
	private String description;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table baseprofiletype
	 * @mbg.generated  Thu Feb 01 14:43:52 IST 2018
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column baseprofiletype.id
	 * @return  the value of baseprofiletype.id
	 * @mbg.generated  Thu Feb 01 14:43:52 IST 2018
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column baseprofiletype.id
	 * @param id  the value for baseprofiletype.id
	 * @mbg.generated  Thu Feb 01 14:43:52 IST 2018
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column baseprofiletype.profileName
	 * @return  the value of baseprofiletype.profileName
	 * @mbg.generated  Thu Feb 01 14:43:52 IST 2018
	 */
	public String getProfileName() {
		return profileName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column baseprofiletype.profileName
	 * @param profileName  the value for baseprofiletype.profileName
	 * @mbg.generated  Thu Feb 01 14:43:52 IST 2018
	 */
	public void setProfileName(String profileName) {
		this.profileName = profileName == null ? null : profileName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column baseprofiletype.isActive
	 * @return  the value of baseprofiletype.isActive
	 * @mbg.generated  Thu Feb 01 14:43:52 IST 2018
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column baseprofiletype.isActive
	 * @param isActive  the value for baseprofiletype.isActive
	 * @mbg.generated  Thu Feb 01 14:43:52 IST 2018
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column baseprofiletype.description
	 * @return  the value of baseprofiletype.description
	 * @mbg.generated  Thu Feb 01 14:43:52 IST 2018
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column baseprofiletype.description
	 * @param description  the value for baseprofiletype.description
	 * @mbg.generated  Thu Feb 01 14:43:52 IST 2018
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}
}