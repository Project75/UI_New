package com.nttdata.fhir.model.mybatis;

import com.nttdata.fhir.model.DataObject;
import java.io.Serializable;
import java.util.Date;

public class WorkflowVO extends DataObject implements Serializable {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column workflow.id
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column workflow.mappingId
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	private String mappingId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column workflow.workflowStatusId
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	private Integer workflowStatusId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column workflow.startDate
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	private Date startDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column workflow.endDate
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	private Date endDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column workflow.assignedToRoleId
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	private Integer assignedToRoleId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column workflow.notes
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	private String notes;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table workflow
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column workflow.id
	 * @return  the value of workflow.id
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column workflow.id
	 * @param id  the value for workflow.id
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column workflow.mappingId
	 * @return  the value of workflow.mappingId
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public String getMappingId() {
		return mappingId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column workflow.mappingId
	 * @param mappingId  the value for workflow.mappingId
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public void setMappingId(String mappingId) {
		this.mappingId = mappingId == null ? null : mappingId.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column workflow.workflowStatusId
	 * @return  the value of workflow.workflowStatusId
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public Integer getWorkflowStatusId() {
		return workflowStatusId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column workflow.workflowStatusId
	 * @param workflowStatusId  the value for workflow.workflowStatusId
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public void setWorkflowStatusId(Integer workflowStatusId) {
		this.workflowStatusId = workflowStatusId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column workflow.startDate
	 * @return  the value of workflow.startDate
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column workflow.startDate
	 * @param startDate  the value for workflow.startDate
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column workflow.endDate
	 * @return  the value of workflow.endDate
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column workflow.endDate
	 * @param endDate  the value for workflow.endDate
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column workflow.assignedToRoleId
	 * @return  the value of workflow.assignedToRoleId
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public Integer getAssignedToRoleId() {
		return assignedToRoleId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column workflow.assignedToRoleId
	 * @param assignedToRoleId  the value for workflow.assignedToRoleId
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public void setAssignedToRoleId(Integer assignedToRoleId) {
		this.assignedToRoleId = assignedToRoleId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column workflow.notes
	 * @return  the value of workflow.notes
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column workflow.notes
	 * @param notes  the value for workflow.notes
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	public void setNotes(String notes) {
		this.notes = notes == null ? null : notes.trim();
	}
}