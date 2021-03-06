package com.nttdata.fhir.dao.mybatis;

import com.nttdata.fhir.model.mybatis.WorkflowStatusVO;
import com.nttdata.fhir.model.mybatis.WorkflowStatusVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkflowStatusVOMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table workflowstatus
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	long countByExample(WorkflowStatusVOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table workflowstatus
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	int deleteByExample(WorkflowStatusVOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table workflowstatus
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	int insert(WorkflowStatusVO record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table workflowstatus
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	int insertSelective(WorkflowStatusVO record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table workflowstatus
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	List<WorkflowStatusVO> selectByExample(WorkflowStatusVOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table workflowstatus
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	int updateByExampleSelective(@Param("record") WorkflowStatusVO record,
			@Param("example") WorkflowStatusVOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table workflowstatus
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	int updateByExample(@Param("record") WorkflowStatusVO record, @Param("example") WorkflowStatusVOExample example);
}