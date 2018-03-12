package com.nttdata.fhir.dao.mybatis;

import com.nttdata.fhir.model.mybatis.ResourceVO;
import com.nttdata.fhir.model.mybatis.ResourceVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResourceVOMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table resource
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	long countByExample(ResourceVOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table resource
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	int deleteByExample(ResourceVOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table resource
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	int insert(ResourceVO record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table resource
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	int insertSelective(ResourceVO record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table resource
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	List<ResourceVO> selectByExample(ResourceVOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table resource
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	int updateByExampleSelective(@Param("record") ResourceVO record, @Param("example") ResourceVOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table resource
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	int updateByExample(@Param("record") ResourceVO record, @Param("example") ResourceVOExample example);
}