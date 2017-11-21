package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.flf.entity.DecorationInspectionPlans;
import com.flf.entity.ExecutionTimeRecords;
import com.flf.entity.FrequencyRecord;
import com.flf.entity.PageRestful;
import com.flf.entity.Tasks;
import com.flf.mapper.DecorationInspectionPlansMapper;
import com.flf.mapper.ExecutionTimeRecordsMapper;
import com.flf.mapper.FrequencyRecordMapper;
import com.flf.service.DecorationInspectionPlansService;

public class DecorationInspectionPlansServiceImpl implements DecorationInspectionPlansService {
    private DecorationInspectionPlansMapper decorationInspectionPlansMapper;//装修巡检方案
    private FrequencyRecordMapper frequencyRecordMapper;//执行频率表
    private ExecutionTimeRecordsMapper executionTimeRecordsMapper;//执行频率和时间表
    
    
	public FrequencyRecordMapper getFrequencyRecordMapper() {
		return frequencyRecordMapper;
	}

	public void setFrequencyRecordMapper(FrequencyRecordMapper frequencyRecordMapper) {
		this.frequencyRecordMapper = frequencyRecordMapper;
	}

	public ExecutionTimeRecordsMapper getExecutionTimeRecordsMapper() {
		return executionTimeRecordsMapper;
	}

	public void setExecutionTimeRecordsMapper(
			ExecutionTimeRecordsMapper executionTimeRecordsMapper) {
		this.executionTimeRecordsMapper = executionTimeRecordsMapper;
	}

	public DecorationInspectionPlansMapper getDecorationInspectionPlansMapper() {
		return decorationInspectionPlansMapper;
	}

	public void setDecorationInspectionPlansMapper(
			DecorationInspectionPlansMapper decorationInspectionPlansMapper) {
		this.decorationInspectionPlansMapper = decorationInspectionPlansMapper;
	}

	//arraylist转换为string类型
	public String listToString(List list, char separator) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append(separator);
		}
		return sb.toString().substring(0, sb.toString().length() - 1);
	}
	@Override
	public void AddDecorationInspectionPlans(
			DecorationInspectionPlans decorationInspectionPlans) {
		// TODO Auto-generated method stub
		String uuid = UUID.randomUUID().toString();
		String Frid = UUID.randomUUID().toString();
		String exid = UUID.randomUUID().toString();
		Date date = new Date();
		if(decorationInspectionPlans !=null && decorationInspectionPlans.getFrequencyRecord() !=null 
		&& decorationInspectionPlans.getExecutionTimeRecords() !=null){
			
			decorationInspectionPlans.setDecorationInspectionPlanId(uuid);
			decorationInspectionPlans.setCreTme(date);
			decorationInspectionPlans.setState((byte)1);
			decorationInspectionPlansMapper.AddDecorationInspectionPlansUUID(decorationInspectionPlans);
			
			FrequencyRecord frequencyRecord = decorationInspectionPlans.getFrequencyRecord();
			if(frequencyRecord.getFrequencyType()==0){
				frequencyRecord.setExecutionFrequency("每天执行");
				frequencyRecord.setRelationId(uuid);//巡检方案id
				frequencyRecord.setrecordId(Frid);//记录id
				frequencyRecordMapper.insertFrequencyRecordUUID(frequencyRecord);
			}else{
				//执行频率数组
				List<String> ExecutionFrequencys =decorationInspectionPlans.getFrequencyRecord().getExecutionFrequencys();
				//（ 将数组转成string类型，以逗号"," 隔开）
				String executionFrequency=listToString(ExecutionFrequencys,',');
				frequencyRecord.setExecutionFrequency(executionFrequency);
				frequencyRecord.setRelationId(uuid);//巡检方案id
				frequencyRecord.setrecordId(Frid);//记录id
				frequencyRecordMapper.insertFrequencyRecordUUID(frequencyRecord);
			}
			List<ExecutionTimeRecords> executionTimeRecordsList =decorationInspectionPlans.getExecutionTimeRecords();
			for(ExecutionTimeRecords executionTimeRecords : executionTimeRecordsList){
				executionTimeRecords.setExecutiveNumId(exid);
				executionTimeRecords.setExecutionFrequencyId(Frid);
				executionTimeRecords.setServiceRequestId(uuid);
				executionTimeRecordsMapper.insert(executionTimeRecords);
			}
			
			
		}
	}

	@Override
	public PageRestful listPageDecorationInspectionPlans(
			DecorationInspectionPlans decorationInspectionPlans) {
		// TODO Auto-generated method stub
		PageRestful pageRestful = new PageRestful();
		List<DecorationInspectionPlans> decorationInspectionPlan = decorationInspectionPlansMapper.listPageDecorationInspectionPlans(decorationInspectionPlans);
		decorationInspectionPlan.add(0, decorationInspectionPlans);
		pageRestful.setDecorationInspectionPlan(decorationInspectionPlan);
		pageRestful.setPage(decorationInspectionPlans.getPage());
		return pageRestful;
	}

	@Override
	public DecorationInspectionPlans getDecorationInspectionPlansbyId(
			String decorationInspectionPlanId) {
		// TODO Auto-generated method stub
		return decorationInspectionPlansMapper.selectByPrimaryKey(decorationInspectionPlanId);
	}

	//修改状态
	@Override
	public void UpdateDecorationInspectionPlans(DecorationInspectionPlans decorationInspectionPlans) {
		// TODO Auto-generated method stub
		decorationInspectionPlansMapper.updateByPrimaryKeySelective(decorationInspectionPlans);
	}

	@Override
	public List<DecorationInspectionPlans> getDecorationInspectionPlans() {
		// TODO Auto-generated method stub
		return  decorationInspectionPlansMapper.getDecorationInspectionPlans();
	}

	@Override
	public FrequencyRecord getDecorationFrequencyRecord(String relationId) {
		
		return frequencyRecordMapper.getFrequencyRecordbyServieId(relationId);
	}

}
