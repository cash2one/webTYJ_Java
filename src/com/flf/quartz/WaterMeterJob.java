package com.flf.quartz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.flf.entity.MeterReadingData;
import com.flf.entity.MeterReadingProgram;
import com.flf.entity.WaterLoss;
import com.flf.entity.WaterMeterProject;
import com.flf.entity.WaterMeterRecords;
import com.flf.mapper.MeterProjectMapper;
import com.flf.mapper.MeterReadingDataMapper;
import com.flf.mapper.MeterReadingProgramMapper;
import com.flf.mapper.MeterRecordsMapper;
import com.flf.mapper.WaterLossMapper;

public class WaterMeterJob {
	
	@Autowired
	private MeterReadingProgramMapper meterReadingProgramMapper; //抄表计划
	@Autowired
	private MeterProjectMapper meterProjectMapper; //水表抄表计划关系
	@Autowired
	private MeterReadingDataMapper meterReadingDataMapper; //抄表数据
	@Autowired
	private MeterRecordsMapper meterRecordsMapper;
	@Autowired
	private WaterLossMapper waterLossMapper;
	
	public MeterReadingProgramMapper getMeterReadingProgramMapper() {
		return meterReadingProgramMapper;
	}

	public void setMeterReadingProgramMapper(MeterReadingProgramMapper meterReadingProgramMapper) {
		this.meterReadingProgramMapper = meterReadingProgramMapper;
	}

	public MeterProjectMapper getMeterProjectMapper() {
		return meterProjectMapper;
	}

	public void setMeterProjectMapper(MeterProjectMapper meterProjectMapper) {
		this.meterProjectMapper = meterProjectMapper;
	}

	public MeterReadingDataMapper getMeterReadingDataMapper() {
		return meterReadingDataMapper;
	}

	public void setMeterReadingDataMapper(MeterReadingDataMapper meterReadingDataMapper) {
		this.meterReadingDataMapper = meterReadingDataMapper;
	}

	public MeterRecordsMapper getMeterRecordsMapper() {
		return meterRecordsMapper;
	}

	public void setMeterRecordsMapper(MeterRecordsMapper meterRecordsMapper) {
		this.meterRecordsMapper = meterRecordsMapper;
	}

	public WaterLossMapper getWaterLossMapper() {
		return waterLossMapper;
	}

	public void setWaterLossMapper(WaterLossMapper waterLossMapper) {
		this.waterLossMapper = waterLossMapper;
	}

	/**
	 * 自动创建抄表计划
	 */
	public void createMeterProject(){
		Date nowDate = new Date();
		List<MeterReadingProgram> meterReadingProgramList = meterReadingProgramMapper.selectMeterReadingProgramByNowDate(nowDate);
		for (MeterReadingProgram item : meterReadingProgramList) {
			MeterReadingProgram meterReadingProgram = new MeterReadingProgram();
			String uuid = UUID.randomUUID().toString();
			meterReadingProgram.setMeterReadingProgramId(uuid);
			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();
			c1.setTime(item.getStartTime());
			c2.setTime(item.getEndTime());
			c1.add(Calendar.MONTH, item.getExecutionFrequency());
			c2.add(Calendar.MONTH, item.getExecutionFrequency());
			meterReadingProgram.setProjectName(item.getProjectName());
			meterReadingProgram.setProjectId(item.getProjectId());
			meterReadingProgram.setStartTime(c1.getTime());
			meterReadingProgram.setEndTime(c2.getTime());
			meterReadingProgram.setProgramExecutionStatus(0);
			meterReadingProgram.setMeterReadingNum(0);
			meterReadingProgram.setUnfinishedNum(item.getMeterReadingDataList().size());
			meterReadingProgram.setExecutionFrequency(item.getExecutionFrequency());
			meterReadingProgram.setAuditTime(item.getAuditTime());
			meterReadingProgram.setCurrentExecutor(item.getCurrentExecutor());
			meterReadingProgramMapper.insertSelective(meterReadingProgram);
			for (MeterReadingData item1 : item.getMeterReadingDataList()) {
				WaterMeterProject waterMeterProject=new WaterMeterProject();
				waterMeterProject.setWaterMeterRecordsId(item1.getWaterMeterRecordId());
				waterMeterProject.setReadingProgramId(uuid);
				meterProjectMapper.insertWaterMeterProject(waterMeterProject);
				
				MeterReadingData meterReadingData = new MeterReadingData();
				meterReadingData.setLastMonthReading(item1.getReading());
				meterReadingData.setMeterReadingProgramId(uuid);
				meterReadingData.setMeterReadingDataId(UUID.randomUUID().toString());
				meterReadingData.setWaterMeterRecordId(item1.getWaterMeterRecordId());
				meterReadingData.setMeterReadingPeople(meterReadingProgram.getCurrentExecutor());
				meterReadingData.setSpecifiedDate(meterReadingProgram.getStartTime());
				meterReadingDataMapper.insertMeterReadingData(meterReadingData);
			}
		}
	}
	
	/**
	 * 自动核实通过
	 */
	public void examineProject(){
		Date nowDate = new Date();
		//查询所有需要自动核实的计划
		List<String> meterReadingProgramIdList = meterReadingProgramMapper.selectMeterReadingProgramExamineProject(nowDate);
		//执行自动核实
		if(meterReadingProgramIdList != null && meterReadingProgramIdList.size() > 0){
			meterReadingDataMapper.examineProject(meterReadingProgramIdList);
			meterReadingProgramMapper.examineProject(meterReadingProgramIdList);
		}
	}
	
	/**
	 * 自动执行抄表计划
	 */
	public void automatic(){
		Date nowDate = new Date();
		List<String> meterReadingProgramIdList = meterReadingProgramMapper.selectMeterReadingProgramAutomatic(nowDate);
		if(meterReadingProgramIdList != null && meterReadingProgramIdList.size() > 0){
			meterReadingProgramMapper.implementProgram(meterReadingProgramIdList);
		}
	}
	
	/**
	 * 自动统计水损
	 */
	public void getWaterDamage(){
		Date nowDate = new Date();
		WaterMeterRecords waterMeterRecords = new WaterMeterRecords();
		waterMeterRecords.setQueryDate(nowDate);
		qwer(waterMeterRecords, 1);
	}
	
	public List<WaterMeterRecords> qwer(WaterMeterRecords waterMeterRecords, int count){
		List<WaterMeterRecords> waterMeterRecordList = new ArrayList<WaterMeterRecords>();
		if(waterMeterRecords.getParentNumList() == null || waterMeterRecords.getParentNumList().size() == 0){
			waterMeterRecordList = meterRecordsMapper.getWaterDamage(waterMeterRecords); //查询所有父表编号为空的水表
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("queryDate", waterMeterRecords.getQueryDate());
			map.put("parentNumList", waterMeterRecords.getParentNumList());
			waterMeterRecordList = meterRecordsMapper.getWaterDamageTwo(map);
		}
		
		for (WaterMeterRecords item : waterMeterRecordList) {
			item.setChildMeterReading(0.0);
			Double sumReading = meterRecordsMapper.selectSumReadingByParentNum(item.getWaterMeterNum(), waterMeterRecords.getQueryDate());//主表的子表总量
			if(sumReading != null){
				item.setChildMeterReading(sumReading + item.getChildMeterReading());
			}
			if(item.getFromNum() != null && !"".equals(item.getFromNum())){ //如果从表id不为空
				WaterMeterRecords meterRecords = meterRecordsMapper.selectReadingById(item.getFromNum(), waterMeterRecords.getQueryDate()); //查询从表读数
				if(meterRecords.getReading() != null && !"".equals(meterRecords.getReading())){
					item.setReading((Double.parseDouble(meterRecords.getReading()) + Double.parseDouble(item.getReading())) + "");//主从表读数相加
				}
				item.setWaterMeterDescribed(item.getWaterMeterDescribed() + "," + meterRecords.getWaterMeterDescribed());//主从表描述相加
				item.setWaterMeterNum(item.getWaterMeterNum() + "," + meterRecords.getWaterMeterNum());//主从表编号相加
				
				sumReading = meterRecordsMapper.selectSumReadingByParentNum(meterRecords.getWaterMeterNum(), waterMeterRecords.getQueryDate());//从表的子表总量
				if(sumReading != null){
					item.setChildMeterReading(sumReading + item.getChildMeterReading());
				}
			}
			
			
			
			item.setParentNumList(Arrays.asList(item.getWaterMeterNum().split(",")));
			item.setQueryDate(waterMeterRecords.getQueryDate());
			WaterLoss waterLoss = new WaterLoss();
			waterLoss.setWaterNum(item.getWaterMeterNum());
			waterLoss.setWaterName(item.getWaterMeterDescribed());
			waterLoss.setLevel(count);
			waterLoss.setConsumption(Double.parseDouble(item.getReading()));
			if(item.getChildMeterReading() != 0){
				waterLoss.setChildConsumption(item.getChildMeterReading());
				waterLoss.setWaterLoss(waterLoss.getConsumption() - waterLoss.getChildConsumption());
				waterLoss.setLossRate((waterLoss.getConsumption() - waterLoss.getChildConsumption())/waterLoss.getConsumption()*100 + "%");
			}
			waterLoss.setMeterDate(item.getQueryDate());
			waterLossMapper.insertSelective(waterLoss);
			qwer(item,count + 1);
		}
		
		return null;
	}
	
}
