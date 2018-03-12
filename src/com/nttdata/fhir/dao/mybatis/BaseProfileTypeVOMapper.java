package com.nttdata.fhir.dao.mybatis;

import com.nttdata.fhir.model.mybatis.BaseProfileTypeVO;
import com.nttdata.fhir.model.mybatis.BaseProfileTypeVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseProfileTypeVOMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table baseprofiletype
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	long countByExample(BaseProfileTypeVOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table baseprofiletype
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	int deleteByExample(BaseProfileTypeVOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table baseprofiletype
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	int insert(BaseProfileTypeVO record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table baseprofiletype
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	int insertSelective(BaseProfileTypeVO record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table baseprofiletype
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	List<BaseProfileTypeVO> selectByExample(BaseProfileTypeVOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table baseprofiletype
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	int updateByExampleSelective(@Param("record") BaseProfileTypeVO record,
			@Param("example") BaseProfileTypeVOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table baseprofiletype
	 * @mbg.generated  Tue Mar 06 15:17:26 IST 2018
	 */
	int updateByExample(@Param("record") BaseProfileTypeVO record, @Param("example") BaseProfileTypeVOExample example);
}