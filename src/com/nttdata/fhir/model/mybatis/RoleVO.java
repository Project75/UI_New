package com.nttdata.fhir.model.mybatis;

import com.nttdata.fhir.model.DataObject;
import java.io.Serializable;

public class RoleVO extends DataObject implements Serializable {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column role.id
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column role.role
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	private String role;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column role.isActive
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	private Boolean isActive;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table role
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column role.id
	 * @return  the value of role.id
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column role.id
	 * @param id  the value for role.id
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column role.role
	 * @return  the value of role.role
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public String getRole() {
		return role;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column role.role
	 * @param role  the value for role.role
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public void setRole(String role) {
		this.role = role == null ? null : role.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column role.isActive
	 * @return  the value of role.isActive
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column role.isActive
	 * @param isActive  the value for role.isActive
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
}