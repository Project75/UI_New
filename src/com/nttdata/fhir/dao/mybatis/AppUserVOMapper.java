package com.nttdata.fhir.dao.mybatis;

import com.nttdata.fhir.model.mybatis.AppUserVO;
import com.nttdata.fhir.model.mybatis.AppUserVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppUserVOMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table appuser
	 * @mbg.generated  Tue Jan 23 20:49:41 IST 2018
	 */
	long countByExample(AppUserVOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table appuser
	 * @mbg.generated  Tue Jan 23 20:49:41 IST 2018
	 */
	int deleteByExample(AppUserVOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table appuser
	 * @mbg.generated  Tue Jan 23 20:49:41 IST 2018
	 */
	int insert(AppUserVO record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table appuser
	 * @mbg.generated  Tue Jan 23 20:49:41 IST 2018
	 */
	int insertSelective(AppUserVO record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table appuser
	 * @mbg.generated  Tue Jan 23 20:49:41 IST 2018
	 */
	List<AppUserVO> selectByExample(AppUserVOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table appuser
	 * @mbg.generated  Tue Jan 23 20:49:41 IST 2018
	 */
	int updateByExampleSelective(@Param("record") AppUserVO record, @Param("example") AppUserVOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table appuser
	 * @mbg.generated  Tue Jan 23 20:49:41 IST 2018
	 */
	int updateByExample(@Param("record") AppUserVO record, @Param("example") AppUserVOExample example);
}