package com.flf.service.impl;

import java.util.Arrays;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

import com.flf.entity.Annex;
import com.flf.entity.ElectricityMeterReadingData;
import com.flf.entity.ElectricityMeterReadingProgram;
import com.flf.entity.MeterReadingData;
import com.flf.entity.MeterReadingProgram;
import com.flf.entity.PageRestful;
import com.flf.entity.SearchMeter;
import com.flf.entity.Staff;
import com.flf.mapper.ElectricityMeterReadingDataMapper;
import com.flf.request.ExcelInfo;
import com.flf.mapper.ElectricityMeterReadingProgramMapper;
import com.flf.mapper.StaffMapper;
import com.flf.request.Info;
import com.flf.service.ElectricityMeterReadingDataService;
import com.flf.util.Excel;
import com.flf.util.ExcelUtils;
import com.flf.util.Tools;

public class ElectricityMeterReadingDataServiceImpl implements	ElectricityMeterReadingDataService {
	private ElectricityMeterReadingDataMapper electricityMeterReadingDataMapper;
	
	private ElectricityMeterReadingProgramMapper electricityMeterReadingProgramMapper;
	
	private StaffMapper staffMapper;
	

	public ElectricityMeterReadingProgramMapper getElectricityMeterReadingProgramMapper() {
		return electricityMeterReadingProgramMapper;
	}

	public void setElectricityMeterReadingProgramMapper(
			ElectricityMeterReadingProgramMapper electricityMeterReadingProgramMapper) {
		this.electricityMeterReadingProgramMapper = electricityMeterReadingProgramMapper;
	}

	public ElectricityMeterReadingDataMapper getElectricityMeterReadingDataMapper() {
		return electricityMeterReadingDataMapper;
	}

	public void setElectricityMeterReadingDataMapper(
			ElectricityMeterReadingDataMapper electricityMeterReadingDataMapper) {
		this.electricityMeterReadingDataMapper = electricityMeterReadingDataMapper;
	}

	/**
	 * 分页查询电表
	 */
	@Override
	public PageRestful listPageElectricityMeterReadingDate(
			SearchMeter searchMeter) {
		// TODO Auto-generated method stub
		PageRestful pageRestful =new PageRestful();
		List<ElectricityMeterReadingData> electricityMeterReadingDatas=electricityMeterReadingDataMapper.listPageElectricityMeterReadingDataBySearchMeter(searchMeter);
		electricityMeterReadingDatas.add(0,null);
		pageRestful.setElectricityMeterReadingData(electricityMeterReadingDatas);
		pageRestful.setPage(searchMeter.getPage());
		return pageRestful;
	}
	
	@Override
	public PageRestful listPageElectricityMeterReadingData(ElectricityMeterReadingData electricityMeterReadingData){
		PageRestful pageRestful =new PageRestful();
		List<ElectricityMeterReadingData> electricityMeterReadingDatas=electricityMeterReadingDataMapper.listPageElectricityMeterReadingData(electricityMeterReadingData);
		electricityMeterReadingDatas.add(0,null);
		pageRestful.setElectricityMeterReadingData(electricityMeterReadingDatas);
		pageRestful.setPage(electricityMeterReadingData.getPage());
		return pageRestful;
	}

	@Override
	public List<ElectricityMeterReadingData> listElectricityMeterReadingDatebyDate(
			Date meterReadingDate) {
		// TODO Auto-generated method stub
		return electricityMeterReadingDataMapper.listElectricityMeterReadingDatebyDate(meterReadingDate);
	}

	@Override
	public List<ElectricityMeterReadingData> listAllElectricityMeterReadingData() {
		// TODO Auto-generated method stub
		return electricityMeterReadingDataMapper.listAllElectricityMeterReadingData();
	}

	@Override
	public ElectricityMeterReadingData getUserByIdRest(
			String electricityMeterReadingDataId) {
		// TODO Auto-generated method stub
		return electricityMeterReadingDataMapper.getElectricityMeterReadingDatabyId(electricityMeterReadingDataId);
	}

	@Override
	public List<ElectricityMeterReadingData> listElectricityMeterReadingDatebyName(
			String projectName) {
		// TODO Auto-generated method stub
		return electricityMeterReadingDataMapper.listElectricityMeterReadingDatebyName(projectName);
	}

	@Override
	public List<ElectricityMeterReadingData> listElectricityMeterReadingDatabyId(
			String electricityMeterRecordId) {
		// TODO Auto-generated method stub
		return electricityMeterReadingDataMapper.listElectricityMeterReadingDatabyId(electricityMeterRecordId);
	}
	
	@Override
	public List<ElectricityMeterReadingData> listElectricityMeterReadingDatabyBuildingId(
			String addressId) {
		// TODO Auto-generated method stub
		return electricityMeterReadingDataMapper.listElectricityMeterReadingDatabyBuildingId(addressId);
	}

	@Override
	public void insertElectricityMeterReadingDatarest(
			ElectricityMeterReadingData electricityMeterReadingData) {
		// TODO Auto-generated method stub
		electricityMeterReadingDataMapper.insertElectricityMeterReadingData(electricityMeterReadingData);
	}

	@Override
	public void updateElectricityMeterReadingDatarest(
			ElectricityMeterReadingData electricityMeterReadingData) {
		// TODO Auto-generated method stub
		electricityMeterReadingDataMapper.updateElectricityMeterReadingData(electricityMeterReadingData);
	}

	@Override
	public void deleteElectricityMeterReadingDatarest(
			String electricityMeterReadingDataId) {
		// TODO Auto-generated method stub
		electricityMeterReadingDataMapper.deleteElectricityMeterReadingData(electricityMeterReadingDataId);
	}
	
	/*@Override
	public Double getElectricityMeterUsage(ElectricityMeterReadingData electricityMeterReadingData) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str = sdf.format(electricityMeterReadingData.getSpecifiedDate());
		MeterReadingData item = electricityMeterReadingDataMapper.selectByBuildingStructureIdAndElectricityMeterReadingDate(electricityMeterReadingData.getBuildingStructureId(),str);
	    if(item == null)
	    {
	    	double electricitymetermsage = 0;
	    	return electricitymetermsage;
	    }
	    else
	    {
	    	double electricitymetermsage = item.getConsumption();
	    	return electricitymetermsage;
		}
	}*/
	
	/**
	 * 分页查询所有电表数据信息
	 */
	@Override
	public PageRestful listPageElectricityMeterRecordAll(
			ElectricityMeterReadingData electricityMeterReadingData) {
		// TODO Auto-generated method stub
		PageRestful pageRestful =new PageRestful();
		List<ElectricityMeterReadingData> electricityMeterReadingDatas=electricityMeterReadingDataMapper.listPageElectricityMeterRecordAll(electricityMeterReadingData);
		
		for (ElectricityMeterReadingData item : electricityMeterReadingDatas) {
			//计算上个月的日期
			Calendar calender = Calendar.getInstance();
			if (item.getCorrection()==null) {
				item.setCorrection(0.0);
			}
			if(item.getSpecifiedDate()!=null)
			{
				calender.setTime(item.getSpecifiedDate());
				calender.add(Calendar.MONTH, -1);
				//上个月的电表使用记录
				ElectricityMeterReadingData meterReadingData = electricityMeterReadingDataMapper.selectByElectricityMeterRecordIdAndDate(item.getElectricityMeterRecordId(), calender.getTime());
				if(meterReadingData != null){
					if (meterReadingData.getConsumption()!=null) {
						item.setLastMonthUse(meterReadingData.getConsumption());
					}
					else{
						item.setLastMonthUse(0.0);
					}
				}
				else{
					item.setLastMonthUse(0.0);
				}
				//计算去年的日期
				calender.add(Calendar.MONTH, 1);
		        calender.add(Calendar.YEAR, -1);
		        //去年的电表使用量
		        ElectricityMeterReadingData meterReadingData2 = electricityMeterReadingDataMapper.selectByElectricityMeterRecordIdAndDate(item.getElectricityMeterRecordId(), calender.getTime());
		        if(meterReadingData2 != null){
		        	if (meterReadingData2.getConsumption()!=null) {
		        		item.setLastYearUse(meterReadingData2.getConsumption());
					}
		        	else{
		        		item.setLastYearUse(0.0);
		        	}
		        	if (item.getLastYearRead()==null) {
						item.setLastYearRead(0.0);
					}
		        	else {
						item.setLastYearRead(meterReadingData2.getLastYearRead());
					}
		        }
		        else{
		        	item.setLastYearUse(0.0);
		        	item.setLastYearRead(0.0);
		        }
		        if (item.getLastMonthUse()==0.0) {
		        	item.setComparedSame(1.0);
				}else {
					item.setComparedSame((item.getConsumption() - item.getLastMonthUse())/item.getLastMonthUse());
				}
		        if (item.getLastYearUse()==0.0) {
		        	item.setSequential(1.0);
				}else {
					item.setSequential((item.getConsumption() - item.getLastYearUse())/item.getLastYearUse());
				}
			}
		}
		
		electricityMeterReadingDatas.add(0,null);
		pageRestful.setElectricityMeterReadingData(electricityMeterReadingDatas);
		pageRestful.setPage(electricityMeterReadingData.getPage());
		return pageRestful;
	}

	@Override
	public InputStream exportElectricityDataReportExcel() {
		// TODO Auto-generated method stub
				//导出到excel
				Excel ex=new Excel();
			    List<ExcelInfo> list=new ArrayList<ExcelInfo>();
				String[] headers = { "计划名称","电表编号","电表描述","本月读数","本月修正量",
						"本月用量",
						"上月读数","上月用量","上月修正量","同比","去年读数","去年用量","环比"};
				String[] fields = {"projectName","electricityMeterNum","electricityMeterDescribed","reading","correction",
						"consumption",
						"lastMonthReading","lastMonthUse","correction","comparedSame","lastYearRead","lastYearUse","sequential"};
		        List<ElectricityMeterReadingData> dataset = electricityMeterReadingDataMapper.listAllElectricityMeterReadingData1();
		        for (ElectricityMeterReadingData item : dataset) {
					//计算上个月的日期
					Calendar calender = Calendar.getInstance();
					if (item.getCorrection()==null) {
						item.setCorrection(0.0);
					}
					if(item.getSpecifiedDate()!=null)
					{
						calender.setTime(item.getSpecifiedDate());
						calender.add(Calendar.MONTH, -1);
						//上个月的电表使用记录
						ElectricityMeterReadingData meterReadingData = electricityMeterReadingDataMapper.selectByElectricityMeterRecordIdAndDate(item.getElectricityMeterRecordId(), calender.getTime());
						if(meterReadingData != null){
							if (meterReadingData.getConsumption()!=null) {
								item.setLastMonthUse(meterReadingData.getConsumption());
							}
							else{
								item.setLastMonthUse(0.0);
							}
						}
						else{
							item.setLastMonthUse(0.0);
						}
						//计算去年的日期
						calender.add(Calendar.MONTH, 1);
				        calender.add(Calendar.YEAR, -1);
				        //去年的电表使用量
				        ElectricityMeterReadingData meterReadingData2 = electricityMeterReadingDataMapper.selectByElectricityMeterRecordIdAndDate(item.getElectricityMeterRecordId(), calender.getTime());
				        if(meterReadingData2 != null){
				        	if (meterReadingData2.getConsumption()!=null) {
				        		item.setLastYearUse(meterReadingData2.getConsumption());
							}
				        	else{
				        		item.setLastYearUse(0.0);
				        	}
				        	if (item.getLastYearRead()==null) {
								item.setLastYearRead(0.0);
							}
				        	else {
								item.setLastYearRead(meterReadingData2.getLastYearRead());
							}
				        }
				        else{
				        	item.setLastYearUse(0.0);
				        	item.setLastYearRead(0.0);
				        }
				        if (item.getLastMonthUse()==0.0) {
				        	item.setComparedSame(1.0);
						}else {
							item.setComparedSame((item.getConsumption() - item.getLastMonthUse())/item.getLastMonthUse());
						}
				        if (item.getLastYearUse()==0.0) {
				        	item.setSequential(1.0);
						}else {
							item.setSequential((item.getConsumption() - item.getLastYearUse())/item.getLastYearUse());
						}
					}
				}
		        if(dataset.size() > 0){
		        	ExcelInfo exl=new ExcelInfo();
					exl.setFields(fields);
					exl.setTitles(headers);
					exl.setSheetName("电表数据报表");
					exl.setList(dataset);
					list.add(exl);
		        }
				try {
				    return ex.createExcelInputStream(list);
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
	}
	@Override
	public PageRestful listPageMeterRecoedDateList(ElectricityMeterReadingData electricityMeterReadingData) {
		PageRestful pageRestful =new PageRestful();
		List<ElectricityMeterReadingData> meterReadingDatas1=electricityMeterReadingDataMapper.listPageMeterRecoedDateList(electricityMeterReadingData);
		
		for (ElectricityMeterReadingData item: meterReadingDatas1) {
			if (item.getMeterReadingPeople() != null) {
				Staff staff=staffMapper.findStaffBystaffId(item.getMeterReadingPeople());
				if (staff!=null) {
					if (staff.getStaffName()!=null) {
						item.setMeterReadingPeople(staff.getStaffName());
					}
				}
			}
		}
		meterReadingDatas1.add(0,null);
		pageRestful.setElectricityMeterReadingData(meterReadingDatas1);
		pageRestful.setPage(electricityMeterReadingData.getPage());
		return pageRestful;
	}

	@Override
	public String setMeterReadingData(ElectricityMeterReadingData electricityMeterReadingData) {
		ElectricityMeterReadingData readingData = electricityMeterReadingDataMapper.selectByPrimaryKey(electricityMeterReadingData.getElectricityMeterReadingDataId());
		readingData.setReading(electricityMeterReadingData.getReading());
		//double useDate = readingData.getReading() - readingData.getLastMonthReading();
		
		/*ElectricityMeterReadingProgram electricityMeterReadingProgram = electricityMeterReadingProgramMapper
				.selectByPrimaryKey(readingData.getElectricityMeterReadingProgramId());
		Date specifiedDate = readingData.getSpecifiedDate(); // 指定抄表日期
		int executionFrequency = electricityMeterReadingProgram.getExecutionFrequency(); //抄表频率
		Calendar c1 = Calendar.getInstance();
		c1.setTime(specifiedDate);
		c1.add(Calendar.MONTH, -executionFrequency);
		ElectricityMeterReadingData lastMonth = electricityMeterReadingDataMapper
				.selectByWaterMeterRecordIdAndDate(readingData.getElectricityMeterRecordId(), c1.getTime());
		c1.add(Calendar.MONTH, -executionFrequency);
		ElectricityMeterReadingData lastTwoMonth = electricityMeterReadingDataMapper
				.selectByWaterMeterRecordIdAndDate(readingData.getElectricityMeterRecordId(), c1.getTime());
		c1.setTime(specifiedDate);
		c1.add(Calendar.YEAR, -1);
		ElectricityMeterReadingData lastYear = electricityMeterReadingDataMapper
				.selectByWaterMeterRecordIdAndDate(readingData.getElectricityMeterRecordId(), c1.getTime());*/
		
		
		/*double tongbi = 0;
		double pingjun = 0;
		double huanbi = 0;*/
		/*if(lastMonth != null){
			double lastMonthUse = lastMonth.getReading() - lastMonth.getLastMonthReading();
			tongbi = (useDate - lastMonthUse)/lastMonthUse; //同比
			if(lastTwoMonth != null){
				double lastTwoMonthUse = lastTwoMonth.getReading() - lastTwoMonth.getLastMonthReading();
				pingjun = (useDate - (useDate + lastMonthUse + lastTwoMonthUse)/3)/((useDate + lastMonthUse + lastTwoMonthUse)/3);
			}
		}
		if(lastYear != null){
			double lastYearUse = lastYear.getReading() - lastYear.getLastMonthReading();
			huanbi = (useDate - lastYearUse)/lastYearUse; //环比
		}*/
		/*double x = Math.abs(tongbi) > Math.abs(pingjun) ? Math.abs(tongbi) : Math.abs(pingjun);
		double max = x > Math.abs(huanbi) ? x : Math.abs(huanbi);
		if(max > 0.1 && max <= 0.3){//异常
			readingData.setAbnormalState(1);
			if(electricityMeterReadingProgram.getMeterReadingWarningNum() == null){
				electricityMeterReadingProgram.setMeterReadingWarningNum(1);
			} else {
			}
		} else if(max > 0.3){//错误
			readingData.setAbnormalState(2);
			if(electricityMeterReadingProgram.getMeterReadingErrorNum() == null){
				electricityMeterReadingProgram.setMeterReadingErrorNum(1);
			} else {
			}
		} else {//正常
			readingData.setAbnormalState(0);
			if(electricityMeterReadingProgram.getMeterReadingNormalNum() == null){
				electricityMeterReadingProgram.setMeterReadingNormalNum(1);
			} else {
			}
		}*/
		
		//readingData.setConsumption(readingData.getReading() - readingData.getLastMonthReading());
		//关键		
		electricityMeterReadingDataMapper.updateByPrimaryKeySelective(readingData);
		//关键
		//electricityMeterReadingProgramMapper.updateMeterReadingProgram(electricityMeterReadingProgram);
		return null;
	}

	@Override
	public Info importExcelFileMeterReadingData(Annex annex) {
		String filePath = annex.getAnnexAddress();
		ElectricityMeterReadingData electricityMeterReadingData = null;
		if (Tools.notEmpty(filePath)) {
			try {
				List<Map<Short, String>> dataList = new ExcelUtils().readExcel(filePath);
				if (dataList != null && dataList.size() > 0) {
					for (Map<Short, String> t : dataList) {
						electricityMeterReadingData = new ElectricityMeterReadingData();
						electricityMeterReadingData.setElectricityMeterReadingDataId(t.get((short) 0));
						electricityMeterReadingData.setReading(Double.parseDouble(t.get((short) 5)));
						ElectricityMeterReadingData readingData = electricityMeterReadingDataMapper.selectByPrimaryKey(electricityMeterReadingData.getElectricityMeterReadingDataId());
						readingData.setReading(electricityMeterReadingData.getReading());
						double useDate = readingData.getReading() - readingData.getLastMonthReading();
						
						ElectricityMeterReadingProgram electricityMeterReadingProgram = electricityMeterReadingProgramMapper
								.selectByPrimaryKey(readingData.getElectricityMeterReadingProgramId());
						Date specifiedDate = readingData.getSpecifiedDate(); // 指定抄表日期
						int executionFrequency = electricityMeterReadingProgram.getExecutionFrequency(); //抄表频率
						Calendar c1 = Calendar.getInstance();
						c1.setTime(specifiedDate);
						c1.add(Calendar.MONTH, -executionFrequency);
						ElectricityMeterReadingData lastMonth = electricityMeterReadingDataMapper
								.selectByWaterMeterRecordIdAndDate(readingData.getElectricityMeterRecordId(), c1.getTime());
						c1.add(Calendar.MONTH, -executionFrequency);
						ElectricityMeterReadingData lastTwoMonth = electricityMeterReadingDataMapper
								.selectByWaterMeterRecordIdAndDate(readingData.getElectricityMeterRecordId(), c1.getTime());
						c1.setTime(specifiedDate);
						c1.add(Calendar.YEAR, -1);
						ElectricityMeterReadingData lastYear = electricityMeterReadingDataMapper
								.selectByWaterMeterRecordIdAndDate(readingData.getElectricityMeterRecordId(), c1.getTime());
						
						
						double tongbi = 0;
						double pingjun = 0;
						double huanbi = 0;
						if(lastMonth != null){
							double lastMonthUse = lastMonth.getReading() - lastMonth.getLastMonthReading();
							tongbi = (useDate - lastMonthUse)/lastMonthUse; //同比
							if(lastTwoMonth != null){
								double lastTwoMonthUse = lastTwoMonth.getReading() - lastTwoMonth.getLastMonthReading();
								pingjun = (useDate - (useDate + lastMonthUse + lastTwoMonthUse)/3)/((useDate + lastMonthUse + lastTwoMonthUse)/3);
							}
						}
						if(lastYear != null){
							double lastYearUse = lastYear.getReading() - lastYear.getLastMonthReading();
							huanbi = (useDate - lastYearUse)/lastYearUse; //环比
						}
						double x = Math.abs(tongbi) > Math.abs(pingjun) ? Math.abs(tongbi) : Math.abs(pingjun);
						double max = x > Math.abs(huanbi) ? x : Math.abs(huanbi);
						if(max > 0.1 && max <= 0.3){//异常
							readingData.setAbnormalState(1);
							if(electricityMeterReadingProgram.getMeterReadingWarningNum() == null){
								electricityMeterReadingProgram.setMeterReadingWarningNum(1);
							} else {
							}
						} else if(max > 0.3){//错误
							readingData.setAbnormalState(2);
							if(electricityMeterReadingProgram.getMeterReadingErrorNum() == null){
								electricityMeterReadingProgram.setMeterReadingErrorNum(1);
							} else {
							}
						} else {//正常
							readingData.setAbnormalState(0);
							if(electricityMeterReadingProgram.getMeterReadingNormalNum() == null){
								electricityMeterReadingProgram.setMeterReadingNormalNum(1);
							} else {
							}
						}
						
						readingData.setConsumption(readingData.getReading() - readingData.getLastMonthReading());
						electricityMeterReadingDataMapper.updateByPrimaryKeySelective(readingData);
						electricityMeterReadingProgramMapper.updateMeterReadingProgram(electricityMeterReadingProgram);
					}
					return Tools.msg("数据导入成功!",true);
				}
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		return Tools.msg("数据导入失败!", false);
	}

	@Override
	public void updateMeterChecked(String meterReadingDataId) {
		electricityMeterReadingDataMapper.updateMeterChecked(Arrays.asList(meterReadingDataId.split(",")));
	}

	@Override
	public void updateMeterRecoed(String meterReadingDataId) {
		electricityMeterReadingDataMapper.updateMeterRecoed(Arrays.asList(meterReadingDataId.split(",")));		
	}

	@Override
	public String setLoopNum(ElectricityMeterReadingData electricityMeterReadingData) {
		ElectricityMeterReadingData item = electricityMeterReadingDataMapper.selectByPrimaryKey(electricityMeterReadingData.getElectricityMeterReadingDataId());
		item.setLoopNum(electricityMeterReadingData.getLoopNum());
		item.setConsumption(item.getLoopNum() + item.getReading() - item.getLastMonthReading());
		electricityMeterReadingDataMapper.updateByPrimaryKeySelective(item);
		return null;
	}

	@Override
	public PageRestful listPageMeterRecoedDateList2(ElectricityMeterReadingData electricityMeterReadingData) {
		PageRestful pageRestful =new PageRestful();
		List<ElectricityMeterReadingData> electricityMeterReadingDatas=electricityMeterReadingDataMapper.listPageMeterRecoedDateList2(electricityMeterReadingData);
		for (ElectricityMeterReadingData item: electricityMeterReadingDatas) {
			if (item.getMeterReadingPeople() != null) {
				Staff staff=staffMapper.findStaffBystaffId(item.getMeterReadingPeople());
				if (staff!=null) {
					if (staff.getStaffName()!=null) {
						item.setMeterReadingPeople(staff.getStaffName());
					}
				}
			}
		}
		electricityMeterReadingDatas.add(0,null);
		pageRestful.setElectricityMeterReadingData(electricityMeterReadingDatas);
		pageRestful.setPage(electricityMeterReadingData.getPage());
		return pageRestful;
	}

	@Override
	public void updateMeterReject(ElectricityMeterReadingData searchMeters) {
				List<String> list = new ArrayList<String>();
			    list = searchMeters.getListleasesArray1();
			    electricityMeterReadingDataMapper.updateMeterReject(list);
	}

	@Override
	public void updateVerification(ElectricityMeterReadingData searchMeters) {
		List list = new ArrayList();
	    list = searchMeters.getListleasesArray1();
	    electricityMeterReadingDataMapper.updateVerification(list);
	    if(list.size()>0){
	    	for(int i=0; i<list.size(); i++){
	    		ElectricityMeterReadingData readingData = electricityMeterReadingDataMapper.selectByPrimaryKey(list.get(i).toString());	
	    		String uuid=UUID.randomUUID().toString();
	    		readingData.setElectricityMeterReadingDataId(uuid);
	    		readingData.setVerificationRecord(0);
	    		//readingData.setNote("读数重表");
	    		readingData.setNote(searchMeters.getNote());
	    		electricityMeterReadingDataMapper.insertElectricityMeterReadingData(readingData);
	    	}
	    }		
	}

	public StaffMapper getStaffMapper() {
		return staffMapper;
	}

	public void setStaffMapper(StaffMapper staffMapper) {
		this.staffMapper = staffMapper;
	}
}
