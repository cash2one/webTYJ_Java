package com.flf.service.impl;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
/* Created by Administrator on 2015/6/15. 
author:尹磊
修改时间：2015/6/15  修改人：尹磊*/ 
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.alibaba.fastjson.JSONArray;
import com.flf.entity.BuildingStructureNew;
import com.flf.entity.Log;
import com.flf.entity.MeterReadingData;
import com.flf.entity.MeterReadingProgram;
import com.flf.entity.PageRestful;
import com.flf.entity.SearchMeter;
import com.flf.entity.Staff;
import com.flf.entity.WaterLoss;
import com.flf.entity.WaterMeterProject;
import com.flf.entity.WaterMeterRecords;
import com.flf.mapper.MeterProjectMapper;
import com.flf.mapper.MeterReadingDataMapper;
import com.flf.mapper.MeterReadingProgramMapper;
import com.flf.mapper.MeterRecordsMapper;
import com.flf.mapper.PlanLinkBuildingStructureMapper;
import com.flf.mapper.StaffMapper;
import com.flf.mapper.WaterLossMapper;
import com.flf.request.ExcelInfo;
import com.flf.service.LogService;
import com.flf.service.LogTypeService;
import com.flf.service.MeterReadingProgramService;
import com.flf.service.WaterMeterProjectService;
import com.flf.service.WaterMeterRecordsService;
import com.flf.util.Excel;
import com.flf.util.JsonUtil;

public class MeterReadingProgramServiceImpl implements
		MeterReadingProgramService {
	private MeterReadingProgramMapper meterReadingProgramMapper;
	
	private WaterMeterRecordsService waterMeterRecordsService;
	
	private WaterMeterProjectService waterMeterProjectService;
	
	private MeterProjectMapper meterProjectMapper;
	
	private MeterRecordsMapper meterRecordsMapper;
	
	private MeterReadingDataMapper meterReadingDataMapper;
	
	private PlanLinkBuildingStructureMapper planLinkBuildingStructureMapper;
	
	private LogService logService;
	
	private LogTypeService logTypeService;
	
	private WaterLossMapper waterLossMapper;
	
	private StaffMapper staffMapper;
	
	public StaffMapper getStaffMapper() {
		return staffMapper;
	}


	public void setStaffMapper(StaffMapper staffMapper) {
		this.staffMapper = staffMapper;
	}
	
	public LogTypeService getLogTypeService() {
		return logTypeService;
	}

	public void setLogTypeService(LogTypeService logTypeService) {
		this.logTypeService = logTypeService;
	}

	public LogService getLogService() {
		return logService;
	}

	public void setLogService(LogService logService) {
		this.logService = logService;
	}

	public PlanLinkBuildingStructureMapper getPlanLinkBuildingStructureMapper() {
		return planLinkBuildingStructureMapper;
	}

	public void setPlanLinkBuildingStructureMapper(
			PlanLinkBuildingStructureMapper planLinkBuildingStructureMapper) {
		this.planLinkBuildingStructureMapper = planLinkBuildingStructureMapper;
	}

	public MeterReadingDataMapper getMeterReadingDataMapper() {
		return meterReadingDataMapper;
	}

	public void setMeterReadingDataMapper(
			MeterReadingDataMapper meterReadingDataMapper) {
		this.meterReadingDataMapper = meterReadingDataMapper;
	}

	public MeterRecordsMapper getMeterRecordsMapper() {
		return meterRecordsMapper;
	}

	public void setMeterRecordsMapper(MeterRecordsMapper meterRecordsMapper) {
		this.meterRecordsMapper = meterRecordsMapper;
	}

	public MeterProjectMapper getMeterProjectMapper() {
		return meterProjectMapper;
	}

	public void setMeterProjectMapper(MeterProjectMapper meterProjectMapper) {
		this.meterProjectMapper = meterProjectMapper;
	}

	public WaterMeterProjectService getWaterMeterProjectService() {
		return waterMeterProjectService;
	}

	public void setWaterMeterProjectService(
			WaterMeterProjectService waterMeterProjectService) {
		this.waterMeterProjectService = waterMeterProjectService;
	}

	public WaterMeterRecordsService getWaterMeterRecordsService() {
		return waterMeterRecordsService;
	}

	public void setWaterMeterRecordsService(
			WaterMeterRecordsService waterMeterRecordsService) {
		this.waterMeterRecordsService = waterMeterRecordsService;
	}

	public MeterReadingProgramMapper getMeterReadingProgramMapper() {
		return meterReadingProgramMapper;
	}

	public void setMeterReadingProgramMapper(
			MeterReadingProgramMapper meterReadingProgramMapper) {
		this.meterReadingProgramMapper = meterReadingProgramMapper;
	}

	public WaterLossMapper getWaterLossMapper() {
		return waterLossMapper;
	}

	public void setWaterLossMapper(WaterLossMapper waterLossMapper) {
		this.waterLossMapper = waterLossMapper;
	}

	/**
	 * 查询所有抄表计划信息
	 * @return
	 */
	@Override
	public List<MeterReadingProgram> listAllMeterReadingProgram() {
		// TODO Auto-generated method stub
		return meterReadingProgramMapper.listAllMeterReadingProgram();
	}

	
	/**
	 * 根据id查询所有抄表计划信息
	 * @return
	 */
	@Override
	public MeterReadingProgram getUserByIdRest(String meterReadingProgramId) {
		// TODO Auto-generated method stub
		return meterReadingProgramMapper.getMeterReadingProgrambyId(meterReadingProgramId);
	}

	
	/**
	 * 新增抄表计划信息
	 * @return
	 */
	@Override
	public void insertMeterReadingProgramrest(
			MeterReadingProgram meterReadingProgram) {
		// TODO Auto-generated method stub

		
		String uuid = UUID.randomUUID().toString();
		meterReadingProgram.setMeterReadingProgramId(uuid);
		meterReadingProgram.setProgramExecutionStatus(0);
		meterReadingProgram.setAllNum(meterReadingProgram.getIds().size());
		meterReadingProgram.setMeterReadingNum(0);
		meterReadingProgram.setUnfinishedNum(meterReadingProgram.getIds().size());
		meterReadingProgramMapper.insertSelective(meterReadingProgram);
		for (String str : meterReadingProgram.getIds()) {
			WaterMeterProject waterMeterProject = new WaterMeterProject();
			waterMeterProject.setWaterMeterRecordsId(str);
			waterMeterProject.setReadingProgramId(uuid);
			meterProjectMapper.insertWaterMeterProject(waterMeterProject);
			MeterReadingData meterReadingData = new MeterReadingData();
			MeterReadingData item = meterReadingDataMapper.selectLastMonthReading(str);
			if (item != null) {
				meterReadingData.setLastMonthReading(item.getReading());
			} else {
				WaterMeterRecords waterMeterRecords = meterRecordsMapper.selectByPrimePrimaryKey(str);
				if (waterMeterRecords.getInitialReading()==null) {
					meterReadingData.setLastMonthReading(0.0);
				}else {
					meterReadingData.setLastMonthReading(waterMeterRecords.getInitialReading());
				}
			}
			meterReadingData.setMeterReadingProgramId(uuid);
			meterReadingData.setMeterReadingDataId(UUID.randomUUID().toString());
			meterReadingData.setWaterMeterRecordId(str);
			meterReadingData.setMeterReadingPeople(meterReadingProgram.getCurrentExecutor());
			meterReadingData.setSpecifiedDate(meterReadingProgram.getStartTime());
			meterReadingDataMapper.insertMeterReadingData(meterReadingData);
		}
		
		
//		String uuid=UUID.randomUUID().toString();
//		meterReadingProgram.setMeterReadingProgramId(uuid);
//		if(meterReadingProgram!=null){
//			meterReadingProgram.setProgramExecutionStatus(0);
//			meterReadingProgramMapper.insertMeterReadingProgram(meterReadingProgram);
//		}
//		for (String str : meterReadingProgram.getIds()) {
//			WaterMeterProject waterMeterProject=new WaterMeterProject();
//			waterMeterProject.setWaterMeterProjectId(UUID.randomUUID().toString());
//			waterMeterProject.setWaterMeterRecordsId(str);
//			waterMeterProject.setReadingProgramId(uuid);
//			meterProjectMapper.insertWaterMeterProject(waterMeterProject);
//		}
		//List<String> ids=new ArrayList<String>();
//		for (BuildingStructureNew buildingStructureNew : meterReadingProgram.getBuildingStructureNew()) {
//			//ids.add(buildingStructureNew.getId());
//			PlanLinkBuildingStructure planLinkBuildingStructure=new PlanLinkBuildingStructure();
//			planLinkBuildingStructure.setBuildingStructureId(buildingStructureNew.getId());
//			planLinkBuildingStructure.setMeterReadingProgramId(uuid);
//			planLinkBuildingStructureMapper.insertPlanLinkBuildingStructure(planLinkBuildingStructure);
//		}
	/*	List<WaterMeterRecords> waterMeterRecords=waterMeterRecordsService.listWaterMeterRecordsbybuildigIds(ids);
		
		for (WaterMeterRecords waterMeterRecords2 : waterMeterRecords) {
			if(waterMeterRecords!=null){
			WaterMeterProject waterMeterProject=new WaterMeterProject();
			waterMeterProject.setReadingProgramId(uuid);
			waterMeterProject.setWaterMeterRecordsId(waterMeterRecords2.getWaterMeterRecordsId());
			waterMeterProjectService.insertWaterMeterProjectrest(waterMeterProject);
			MeterReadingData meterReadingData=new MeterReadingData();
			meterReadingData.setWaterMeterRecordId(waterMeterRecords2.getWaterMeterRecordsId());
			meterReadingData.setBuildingStructureId(waterMeterRecords2.getBuildingStructureId());
			meterReadingData.setMeterReadingProgramId(uuid);
			meterReadingDataMapper.insertMeterReadingData(meterReadingData);
		}
		}*/
	}

	
	/**
	 * 修改抄表计划信息
	 * @return
	 */
	@Override
	public void updateMeterReadingProgramrest(MeterReadingProgram meterReadingProgram) {
		// TODO Auto-generated method stub
		Date date = new Date();
		if (meterReadingProgramMapper.updateMeterReadingProgram(meterReadingProgram) > 0) {
			Log log = new Log();
			log.setOperation("修改");// 操作
			log.setService("抄表计划");// 业务
			log.setThing("修改：" + meterReadingProgram.getProjectName() + "抄表计划");
			log.setStaff(meterReadingProgram.getCurrentExecutor());// 操作人
			log.setTable("t_meter_reading_program");// 操作的表名
			log.setTime(date);
			log.setRelevanceId(meterReadingProgram.getMeterReadingProgramId());// 关联id
			meterReadingProgram.setLogId(log.getId());
			logService.insertWaterLog(log);// 记录日志

		}
//		String uuid = UUID.randomUUID().toString();
//		meterReadingProgram.setMeterReadingProgramId(uuid);
		
		
//		meterReadingProgram.setProgramExecutionStatus(0);
//		meterReadingProgram.setAllNum(meterReadingProgram.getIds().size());
//		meterReadingProgram.setMeterReadingNum(0);
//		meterReadingProgram.setUnfinishedNum(meterReadingProgram.getIds().size());
//		meterReadingProgramMapper.insertSelective(meterReadingProgram);
		//meterProjectMapper.deleteByReadingProgramId(meterReadingProgram.getMeterReadingProgramId());
		//meterReadingDataMapper.deleteByReadingProgramId(meterReadingProgram.getMeterReadingProgramId());
		
		meterReadingProgramMapper.updateByPrimaryKeySelective(meterReadingProgram);
		for (String str : meterReadingProgram.getIds()) {
			WaterMeterProject waterMeterProject = new WaterMeterProject();
			waterMeterProject.setWaterMeterRecordsId(str);
			waterMeterProject.setReadingProgramId(meterReadingProgram.getMeterReadingProgramId());
			meterProjectMapper.updateWaterMeterProject(waterMeterProject);
			MeterReadingData meterReadingData = new MeterReadingData();
			MeterReadingData item = meterReadingDataMapper.selectLastMonthReading(str);
			WaterMeterRecords waterMeterRecords = meterRecordsMapper.selectByPrimePrimaryKey(str);
			if (item != null) {
				meterReadingData.setReading(item.getReading());
				if (item.getLastMonthReading()==null) {
					meterReadingData.setLastMonthReading(0.0);
				}else {
					meterReadingData.setLastMonthReading(item.getLastMonthReading());
				}
			} else {
				if (waterMeterRecords.getInitialReading()==null) {
					meterReadingData.setLastMonthReading(0.0);
				}else {
					meterReadingData.setLastMonthReading(waterMeterRecords.getInitialReading());
				}
			}
			meterReadingData.setMeterReadingProgramId(meterReadingProgram.getMeterReadingProgramId());
			MeterReadingData meterReadingDataaa=meterReadingDataMapper.listMeterReadingDatabyRecordId(str);
			if (meterReadingDataaa.getMeterReadingDataId()!=null) {
				meterReadingData.setMeterReadingDataId(meterReadingDataaa.getMeterReadingDataId());
			}else {
				meterReadingData.setMeterReadingDataId(UUID.randomUUID().toString());
			}
			
			meterReadingData.setWaterMeterRecordId(str);
			meterReadingData.setMeterReadingPeople(meterReadingProgram.getCurrentExecutor());
			meterReadingData.setSpecifiedDate(meterReadingProgram.getStartTime());
			meterReadingDataMapper.updateMeterReadingData(meterReadingData);
		}

	}
	

	
	/**
	 * 删除抄表计划信息
	 * @return
	 */
	@Override
	public void deleteMeterReadingProgramrest(String meterReadingProgramId) {
		// TODO Auto-generated method stub
		meterReadingProgramMapper.deleteMeterReadingProgram(meterReadingProgramId);
	}
	
	
	/**
	 * 分页查询水表抄表计划
	 * @return
	 */
	/*@Override
	public PageRestful listPageMeterReadingProgram(
			MeterReadingProgram meterReadingProgram) {
		// TODO Auto-generated method stub
		PageRestful pageRestful =new PageRestful();
		List<MeterReadingProgram> meterReadingPrograms=meterReadingProgramMapper.listPageMeterReadingProgram(meterReadingProgram);
		meterReadingPrograms.add(0,null);
		pageRestful.setMeterReadingProgram(meterReadingPrograms);
		pageRestful.setPage(meterReadingProgram.getPage());
		return pageRestful;
	}*/

	/**
	 * 根据项目名称查询抄表计划
	 * @return
	 */
	@Override
	public List<MeterReadingProgram> listMeterReadingProgrambyName(
			String projectName) {
		// TODO Auto-generated method stub
		return meterReadingProgramMapper.listMeterReadingProgrambyName(projectName);
	}

	
	/**
	 * 根据操作日期查询抄表计划
	 * @return
	 */
	@Override
	public List<MeterReadingProgram> listMeterReadingProgrambyDate(Date date) {
		// TODO Auto-generated method stub
		return meterReadingProgramMapper.listMeterReadingProgrambyDate(date);
	}

	
	/**
	 * 根据执行人查询所有抄表计划信息
	 * @return
	 */
	@Override
	public List<MeterReadingProgram> listMeterReadingProgrambyStaff(
			String currentExecutor) {
		// TODO Auto-generated method stub
		return meterReadingProgramMapper.listMeterReadingProgrambyStaff(currentExecutor);
	}

	
	/**
	 * 根据执行团队查询所有抄表计划信息
	 * @return
	 */
	@Override
	public List<MeterReadingProgram> listMeterReadingProgrambyTeam(
			String executiveTeam) {
		// TODO Auto-generated method stub
		return meterReadingProgramMapper.listMeterReadingProgrambyTeam(executiveTeam);
	}

	@Override
	public List<MeterReadingProgram> listMeterReadingProgrambyState(
			byte programExecutionStatus) {
		// TODO Auto-generated method stub
		return meterReadingProgramMapper.listMeterReadingProgrambyState(programExecutionStatus);
	}

	
	/**
	 * 多条件查询抄表计划
	 * @return
	 */
	@Override
	public PageRestful listPageMeterReadingProgram(SearchMeter searchMerter) {
		// TODO Auto-generated method stub
		PageRestful pageRestful =new PageRestful();
		List<MeterReadingProgram> meterReadingPrograms=meterReadingProgramMapper.listPageMeterReadingProgram(searchMerter);
		for (MeterReadingProgram item: meterReadingPrograms) {
			if (item.getCurrentExecutor()!=null) {
				Staff staff = staffMapper.findStaffBystaffId(item.getCurrentExecutor());
				if (staff!=null) {
					if (staff.getStaffName()!=null) {
						item.setCurrentExecutor(staff.getStaffName());
					}
				}
			}
		}
		meterReadingPrograms.add(0,null);
		pageRestful.setMeterReadingProgram(meterReadingPrograms);
		pageRestful.setPage(searchMerter.getPage());
		return pageRestful;
	}

	@Override
	public InputStream exportMeterReadingFile() {
		// TODO Auto-generated method stub
		
/*		List<MeterReadingProgram> meterReadingPrograms=meterReadingProgramMapper.listAllMeterReadingProgram();*/
		//导出到excel
		Excel ex=new Excel();
	    List<ExcelInfo> list=new ArrayList<ExcelInfo>();
		String[] headers = { "计划名称","表数","月结日","项目", "开始日期", "结束日期", "状态"};
		String[] fields = {"projectName","allNum","settlementDay","projectId","startTime","endTime","programExecutionStatus"};
        List<MeterReadingProgram> dataset = meterReadingProgramMapper.listAllMeterReadingProgram();
      
        if(dataset.size() > 0){
        	ExcelInfo exl=new ExcelInfo();
			exl.setFields(fields);
			exl.setTitles(headers);
			exl.setSheetName("抄表计划");
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
	public PageRestful listPageMeterReadingProgramAll(
			MeterReadingProgram meterReadingProgram) {
		// TODO Auto-generated method stub
		PageRestful pageRestful =new PageRestful();
		String colors="write";//正常颜色
		
		List<MeterReadingProgram> meterReadingPrograms=meterReadingProgramMapper.listPageMeterReadingProgramAll(meterReadingProgram);
		for(int i=0;i<meterReadingPrograms.size();i++){
			 colors="write";
		Double ss=Double.parseDouble(meterReadingPrograms.get(i).getReading() );
		Double sl=	 meterReadingPrograms.get(i).getLastMonthReading();
		if(ss!=null && sl!=null){
			 if(ss-sl<0){
				 colors="red";
			 }else
			 if((ss/sl)-1>0.3){
				 colors="yellow"; 
			 }
			 meterReadingPrograms.get(i).setColors(colors);
		   }
		}
		
		
		
		meterReadingPrograms.add(0,null);
		pageRestful.setMeterReadingProgram(meterReadingPrograms);
		pageRestful.setPage(meterReadingProgram.getPage());
		return pageRestful;
	}

	@Override
	public PageRestful listPageMeterReadingProgramById(
			MeterReadingProgram meterReadingProgram) {
		// TODO Auto-generated method stub
		PageRestful pageRestful =new PageRestful();
		String colors="write";//正常颜色
		
		List<MeterReadingProgram> meterReadingPrograms=meterReadingProgramMapper.listPageMeterReadingProgramById(meterReadingProgram);
		for(int i=0;i<meterReadingPrograms.size();i++){
			 colors="write";
		Double ss=Double.parseDouble(meterReadingPrograms.get(i).getReading() );
		Double sl=	 meterReadingPrograms.get(i).getLastMonthReading();
		if(ss!=null && sl!=null){
			 if(ss-sl<0){
				 colors="red";
			 }
			 if((ss/sl)-1>0.3){
				 colors="yellow"; 
			 }
			 meterReadingPrograms.get(i).setColors(colors);
		   }
		}
		meterReadingPrograms.add(0,null);
		pageRestful.setMeterReadingProgram(meterReadingPrograms);
		pageRestful.setPage(meterReadingProgram.getPage());
		return pageRestful;
	}

	@Override
	public String implementProgram(String meterReadingProgramIdJson) {
		try {
			List<String> meterReadingProgramIdList = JSONArray.parseArray(meterReadingProgramIdJson, String.class);
			meterReadingProgramMapper.implementProgram(meterReadingProgramIdList);
			return JsonUtil.success("执行成功", true);
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.failure("执行失败", false);
		}
	}

	@Override
	public PageRestful listPageMeterReadingResult(SearchMeter searchMerter) {
		PageRestful pageRestful = new PageRestful();
		List<MeterReadingProgram> meterReadingPrograms = meterReadingProgramMapper.listPageMeterReadingResult(searchMerter);
		if (meterReadingPrograms != null && meterReadingPrograms.size() > 0) {
			for (int i=0; i<meterReadingPrograms.size(); i++) {
				if(meterReadingPrograms.get(i).getMeterReadingErrorNum()>0){
					meterReadingPrograms.get(i).setProgramExceptionStatus(2);
				}
				else if(meterReadingPrograms.get(i).getMeterReadingWarningNum()>0){
					meterReadingPrograms.get(i).setProgramExceptionStatus(1);
				}
				else {
					meterReadingPrograms.get(i).setProgramExceptionStatus(0);
				}
				
				meterReadingProgramMapper.updateMeterReadingProgram(meterReadingPrograms.get(i));
			}
		}
		
		List<MeterReadingProgram> meterReadingPrograms1 = meterReadingProgramMapper.listPageMeterReadingResult(searchMerter);
		meterReadingPrograms1.add(0, null);
		pageRestful.setMeterReadingProgram(meterReadingPrograms1);
		pageRestful.setPage(searchMerter.getPage());
		return pageRestful;
	}

	@Override
	public InputStream exportMeterReadingDataFile(HttpServletRequest request) {
		Excel ex=new Excel();
	    List<ExcelInfo> list1=new ArrayList<ExcelInfo>();
		String[] headers = { "主键","抄表人","水表编号","区域","上月读数", "本月读数"};
		String[] fields = {"meterReadingDataId","meterReadingPeople","waterMeterNum","fullName","lastMonthReading","reading"};
        List<MeterReadingData> dataset = meterReadingDataMapper.selectMeterReadingDateByMeterReadingProgramId(request.getParameter("meterReadingProgramId"));
      
        if(dataset.size() > 0){
        	ExcelInfo exl=new ExcelInfo();
			exl.setFields(fields);
			exl.setTitles(headers);
			exl.setSheetName(request.getParameter("fileName"));
			exl.setList(dataset);
			list1.add(exl);
        }
		try {
		    return ex.createExcelInputStream(list1);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public InputStream exportWaterLossExcel(HttpServletRequest request) {
		Date date = null;
		if(request.getParameter("queryDate") == null || request.getParameter("queryDate") == ""){
			date = new Date();
		} else {
			SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd");
			try {
				date = sf1.parse(request.getParameter("queryDate"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		List<WaterLoss> waterLossList = waterLossMapper.selectByDate(date);
		/*Integer maxLevel1 = waterLossMapper.selectMaxLevelByDate(new Date());
		int maxLevel =0;
		if (maxLevel1 != null){
			maxLevel = maxLevel1;
		}*/
		int maxLevel = waterLossMapper.selectMaxLevelByDate(new Date());
		
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("水损分析");   //--->创建了一个工作簿  
		
		HSSFRow row = sheet.createRow(0);
		for (short i = 0; i < maxLevel; i++) {
			row.createCell(i).setCellValue("第"+ (i+1) + "级");
		}
        
        row.createCell((short) maxLevel).setCellValue("表用量");
        row.createCell((short) (maxLevel+1)).setCellValue("子表用量");
        row.createCell((short) (maxLevel+2)).setCellValue("水损");
        row.createCell((short) (maxLevel+3)).setCellValue("底层子表总用量");
        row.createCell((short) (maxLevel+4)).setCellValue("损耗率");
        
        for (int i = 0; i < waterLossList.size(); i++) {
        	HSSFRow item = sheet.createRow(i+1);
        	item.createCell((short) (waterLossList.get(i).getLevel()-1)).setCellValue(waterLossList.get(i).getWaterName());
        	item.createCell((short) maxLevel).setCellValue((waterLossList.get(i).getConsumption()));
        	if(waterLossList.get(i).getChildConsumption() != null){
        		item.createCell((short) (maxLevel+1)).setCellValue((waterLossList.get(i).getChildConsumption()));
        	}
        	if((waterLossList.get(i).getWaterLoss() != null)){
        		item.createCell((short) (maxLevel+2)).setCellValue((waterLossList.get(i).getWaterLoss()));
        	}
        	if((waterLossList.get(i).getLossRate() != null)){
        		if (waterLossList.get(i).getBootChildConsumption()!=null) {
        			item.createCell((short) (maxLevel+3)).setCellValue((waterLossList.get(i).getBootChildConsumption()));
				}
        	}
        	if((waterLossList.get(i).getLossRate() != null)){
        		item.createCell((short) (maxLevel+4)).setCellValue((waterLossList.get(i).getLossRate()));
        	}
		}
        
		try {
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			wb.write(os);
			InputStream is = new ByteArrayInputStream(os.toByteArray());
			os.close();
			return is;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public MeterReadingProgram editData(String meterReadingProgramId) {
		return meterReadingProgramMapper.editData(meterReadingProgramId);
	}

	@Override
	public List<MeterReadingProgram> selectMeterChecked(String meterReadingProgramId) {
		// TODO Auto-generated method stub
		return meterReadingProgramMapper.selectMeterChecked(Arrays.asList(meterReadingProgramId.split(",")));
		 
	}

}
