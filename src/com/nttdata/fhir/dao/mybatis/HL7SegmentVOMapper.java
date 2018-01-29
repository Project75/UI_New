package com.nttdata.fhir.dao.mybatis;

import com.nttdata.fhir.model.mybatis.HL7SegmentVO;
import com.nttdata.fhir.model.mybatis.HL7SegmentVOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HL7SegmentVOMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hl7segment
	 * @mbg.generated  Tue Jan 23 20:49:41 IST 2018
	 */
	long countByExample(HL7SegmentVOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hl7segment
	 * @mbg.generated  Tue Jan 23 20:49:41 IST 2018
	 */
	int deleteByExample(HL7SegmentVOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hl7segment
	 * @mbg.generated  Tue Jan 23 20:49:41 IST 2018
	 */
	int insert(HL7SegmentVO record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hl7segment
	 * @mbg.generated  Tue Jan 23 20:49:41 IST 2018
	 */
	int insertSelective(HL7SegmentVO record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hl7segment
	 * @mbg.generated  Tue Jan 23 20:49:41 IST 2018
	 */
	List<HL7SegmentVO> selectByExample(HL7SegmentVOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hl7segment
	 * @mbg.generated  Tue Jan 23 20:49:41 IST 2018
	 */
	int updateByExampleSelective(@Param("record") HL7SegmentVO record, @Param("example") HL7SegmentVOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table hl7segment
	 * @mbg.generated  Tue Jan 23 20:49:41 IST 2018
	 */
	int updateByExample(@Param("record") HL7SegmentVO record, @Param("example") HL7SegmentVOExample example);
}