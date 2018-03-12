package com.nttdata.fhir.dao.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nttdata.fhir.dao.mybatis.WorkflowVOMapper;
import com.nttdata.fhir.model.mybatis.WorkflowVO;
import com.nttdata.fhir.util.AppUtil;



@Component(value="workflow")
public class WorkflowHelper {
	
	private	WorkflowVOMapper mapper;
	
	public WorkflowVO getById(String id) throws Exception {
		WorkflowVO record = mapper.selectByPrimaryKey(Integer.valueOf(id));
		return record; 
	}
	
	public long insert(WorkflowVO record, String userId){
		record.setStartDate(AppUtil.getCurrentDate());
		record.setEndDate(AppUtil.futureEndDate());
		record.updateCreationData(userId);
		long out = mapper.insert(record);
		return out;
	}
	
	public void update(WorkflowVO record, String webUser) {		
		record.updateModificationData(webUser);
		mapper.updateByPrimaryKey(record);
	}
	
	@Autowired
	public void setMapper(WorkflowVOMapper mapper) {
		this.mapper = mapper;
	}

}
