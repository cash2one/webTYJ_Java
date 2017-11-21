package com.flf.quartz;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.flf.entity.ElectricityLoss;
import com.flf.entity.ElectricityMeterRecords;
import com.flf.mapper.ElectricityLossMapper;
import com.flf.mapper.ElectricityMeterRecordsMapper;

public class ElectricityMeter extends QuartzJobBean{
	@Autowired
	private ElectricityMeterRecordsMapper electricityMeterRecordsMapper;
	@Autowired
	private ElectricityLossMapper electricityLossMapper;
	
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		
	}
	public void getElectricityDamage(){
		Date nowDate = new Date();
		ElectricityMeterRecords electricityMeterRecords = new ElectricityMeterRecords();
		electricityMeterRecords.setQueryDate(nowDate);
		qwer(electricityMeterRecords, 1);
	}
	
	public List<ElectricityMeterRecords> qwer(ElectricityMeterRecords electricityMeterRecords, int count){
		List<ElectricityMeterRecords> electricityMeterRecordList = new ArrayList<ElectricityMeterRecords>();
		if(electricityMeterRecords.getParentNumList() == null || electricityMeterRecords.getParentNumList().size() == 0){
			electricityMeterRecordList = electricityMeterRecordsMapper.getElectricityDamage(electricityMeterRecords); //查询所有父表编号为空的电表
			electricityLossMapper.deleteByMeterDate(electricityMeterRecords.getQueryDate());
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("queryDate", electricityMeterRecords.getQueryDate());
			map.put("parentNumList", electricityMeterRecords.getParentNumList());
			electricityMeterRecordList = electricityMeterRecordsMapper.getElectricityDamageTwo(map);
		}
		
		for (ElectricityMeterRecords item : electricityMeterRecordList) {
			item.setChildMeterReading(0.0);
			Double sumReading = electricityMeterRecordsMapper.selectSumReadingByParentNum(item.getElectricityMeterNum(), electricityMeterRecords.getQueryDate());//主表的子表总量
			if(sumReading != null){
				item.setChildMeterReading(sumReading + item.getChildMeterReading());
			}
			if(item.getFromNum() != null && !"".equals(item.getFromNum())){ //如果从表id不为空
				ElectricityMeterRecords meterRecords = electricityMeterRecordsMapper.selectReadingById(item.getFromNum(), electricityMeterRecords.getQueryDate()); //查询从表读数
				if(meterRecords.getReading() != null && !"".equals(meterRecords.getReading())){
					item.setReading((Double.parseDouble(meterRecords.getReading()) + Double.parseDouble(item.getReading())) + "");//主从表读数相加
				}
				item.setElectricityMeterDescribed(item.getElectricityMeterDescribed() + "," + meterRecords.getElectricityMeterDescribed());//主从表描述相加
				item.setElectricityMeterNum(item.getElectricityMeterNum() + "," + meterRecords.getElectricityMeterNum());//主从表编号相加
				
				sumReading = electricityMeterRecordsMapper.selectSumReadingByParentNum(meterRecords.getElectricityMeterNum(), electricityMeterRecords.getQueryDate());//从表的子表总量
				if(sumReading != null){
					item.setChildMeterReading(sumReading + item.getChildMeterReading());
				}
			}
			
			
/*			java.util.List<String> pnList = new java.util.ArrayList<String>();
			pnList.add(item.getElectricityMeterNum());
			Map<String, Object> bootMap = new HashMap<String, Object>();
			bootMap.put("queryDate", electricityMeterRecords.getQueryDate());
			bootMap.put("parentNumList", pnList);
			List<ElectricityMeterRecords> bootElectricityMeterRecordList = electricityMeterRecordsMapper.getElectricityDamageTwo(bootMap);
			
			Double bootReading = 0.0;
			
			for(ElectricityMeterRecords bootItem : bootElectricityMeterRecordList){
				if(bootItem.getFromNum() != null && !"".equals(bootItem.getFromNum())){ //如果从表id不为空
					ElectricityMeterRecords meterRecords = electricityMeterRecordsMapper.selectReadingById(bootItem.getFromNum(), electricityMeterRecords.getQueryDate()); //查询从表读数
					if(meterRecords.getReading() != null && !"".equals(meterRecords.getReading())){
						bootReading += Double.parseDouble(meterRecords.getReading()) + Double.parseDouble(bootItem.getReading());//主从表读数相加
					}
				}
			}
			*/
			
			Double bootReading = 0.0;
			
			
			java.util.List<String> pnList = new java.util.ArrayList<String>();
			String s[]=item.getElectricityMeterNum().split(",");
			for(String b : s){
				pnList.add(b);
			}
			
			Map<String, Object> bootMap = new HashMap<String, Object>();
			bootMap.put("queryDate", electricityMeterRecords.getQueryDate());
			bootMap.put("parentNumList", pnList);
			List<ElectricityMeterRecords> bootElectricityMeterRecordList = electricityMeterRecordsMapper.getElectricityDamageTwo(bootMap);
			

			for(ElectricityMeterRecords bootItem : bootElectricityMeterRecordList){
				Double tmp=electricityMeterRecordsMapper.selectSumReadingByParentNum_AndIsBilling1(bootItem.getElectricityMeterNum(), electricityMeterRecords.getQueryDate());//子表的子表总量

				if(tmp!=null){
					bootReading += tmp;
			
				}
			}
			
			item.setParentNumList(Arrays.asList(item.getElectricityMeterNum().split(",")));
			item.setQueryDate(electricityMeterRecords.getQueryDate());
			ElectricityLoss electricityLoss = new ElectricityLoss();
			electricityLoss.setElectricityNum(item.getElectricityMeterNum());
			electricityLoss.setElectricityName(item.getElectricityMeterDescribed());
			electricityLoss.setLevel(count);
			if (item.getReading()==null) {
				electricityLoss.setConsumption(0.0);
			}else{
				electricityLoss.setConsumption(Double.parseDouble(item.getReading()));
			}
			if(item.getChildMeterReading() != 0){
				electricityLoss.setChildConsumption(item.getChildMeterReading());
				electricityLoss.setElectricityLoss(electricityLoss.getConsumption() - electricityLoss.getChildConsumption());
				DecimalFormat df = new DecimalFormat("#.00");
				electricityLoss.setLossRate(df.format((electricityLoss.getConsumption() - electricityLoss.getChildConsumption())/electricityLoss.getConsumption()*100) + "%");
			}
			electricityLoss.setMeterDate(item.getQueryDate());
			electricityLossMapper.insertSelective(electricityLoss);
			qwer(item,count + 1);
		}
		
		return null;
	}
}
