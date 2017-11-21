package com.flf.service.impl;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.ws.rs.PathParam;

import com.flf.entity.Annex;
import com.flf.entity.BuildingStructureNew;
import com.flf.entity.Log;
import com.flf.entity.MeterReadingData;
import com.flf.entity.PageRestful;
import com.flf.entity.Search;
import com.flf.entity.SearchMeter;
import com.flf.entity.Staff;
import com.flf.entity.WaterLoss;
import com.flf.entity.WaterMeter;
import com.flf.entity.WaterMeterOrderRecords;
import com.flf.entity.WaterMeterProject;
import com.flf.entity.WaterMeterRecords;
import com.flf.mapper.BuildingStructureNewMapper;
import com.flf.mapper.MeterMapper;
import com.flf.mapper.MeterProjectMapper;
import com.flf.mapper.MeterReadingDataMapper;
import com.flf.mapper.MeterRecordsMapper;
import com.flf.mapper.PropertyMapper;
import com.flf.mapper.StaffMapper;
import com.flf.mapper.WaterLossMapper;
import com.flf.request.ExcelInfo;
import com.flf.request.Info;
import com.flf.service.LogService;
import com.flf.service.LogTypeService;
import com.flf.service.WaterMeterRecordsService;
import com.flf.util.Excel;
import com.flf.util.ExcelUtils;
import com.flf.util.Tools;
/* Created by Administrator on 2015/6/15. 
author:尹磊
修改时间：2015/6/15  修改人：尹磊*/ 
public class WaterMeterRecordsServiceImpl implements WaterMeterRecordsService {
	private MeterRecordsMapper meterRecordsMapper;
	
	private MeterMapper meterMapper;

	private PropertyMapper propertyMapper;
	private LogService logService;
	
	private LogTypeService logTypeService;
	
	private MeterReadingDataMapper meterReadingDataMapper;
	
	//private PlanLinkBuildingStructureMapper planLinkBuildingStructureMapper;
	
	private MeterProjectMapper meterProjectMapper;
	
	private  BuildingStructureNewMapper buildingStructureNewMapper;
	
	private WaterLossMapper waterLossMapper;
	
	private StaffMapper staffMapper;
	
	public BuildingStructureNewMapper getBuildingStructureNewMapper() {
		return buildingStructureNewMapper;
	}


	public void setBuildingStructureNewMapper(
			BuildingStructureNewMapper buildingStructureNewMapper) {
		this.buildingStructureNewMapper = buildingStructureNewMapper;
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


	public void setMeterReadingDataMapper(
			MeterReadingDataMapper meterReadingDataMapper) {
		this.meterReadingDataMapper = meterReadingDataMapper;
	}


	public LogService getLogService() {
		return logService;
	}


	public void setLogService(LogService logService) {
		this.logService = logService;
	}


	public LogTypeService getLogTypeService() {
		return logTypeService;
	}


	public void setLogTypeService(LogTypeService logTypeService) {
		this.logTypeService = logTypeService;
	}


	public MeterMapper getMeterMapper() {
		return meterMapper;
	}


	public void setMeterMapper(MeterMapper meterMapper) {
		this.meterMapper = meterMapper;
	}


	public PropertyMapper getPropertyMapper() {
		return propertyMapper;
	}


	public void setPropertyMapper(PropertyMapper propertyMapper) {
		this.propertyMapper = propertyMapper;
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
	 * 查询所有水表使用记录信息
	 * @return
	 */
	@Override
	public List<WaterMeterRecords> listAllWaterMeterRecords() {
		// TODO Auto-generated method stub
		return meterRecordsMapper.listAllWaterMeterRecords();
	}

	
	/**
	 * 根据id查询所有水表使用记录信息
	 * @return
	 */
	@Override
	public WaterMeterRecords getUserByIdRest(String waterMeterRecordsId) {
		// TODO Auto-generated method stub
		return meterRecordsMapper.getWaterMeterRecordsbyId(waterMeterRecordsId);
	}

	
	/**
	 * 新增水表使用记录信息
	 * @return
	 */
	@Override
	public void insertWaterMeterRecordsrest(WaterMeterRecords waterMeterRecords) {
		// TODO Auto-generated method stub
		String uuid=UUID.randomUUID().toString();
		waterMeterRecords.setWaterMeterRecordsId(uuid);
		WaterMeter waterMeter=meterMapper.getWaterMeterbyParentNum(waterMeterRecords.getParentNum());
		if(waterMeter!=null){
			waterMeterRecords.setParentId(waterMeter.getWaterMeterId());
		}
			meterRecordsMapper.insertWaterMeterRecords(waterMeterRecords);
			meterMapper.updateWaterMeter(waterMeterRecords.getWaterMeter());
			propertyMapper.updateByPrimaryKey(waterMeterRecords.getProperty());		
	}

	
	/**
	 * 修改水表使用记录信息
	 * @return
	 */
	@Override
	public void updateWaterMeterRecordsrest(WaterMeterRecords waterMeterRecords) {
		// TODO Auto-generated method stub
		meterRecordsMapper.updateWaterMeterRecords(waterMeterRecords);
	}

	
	/**
	 * 删除水表使用记录信息
	 * @return
	 */
	@Override
	public void deleteWaterMeterRecordsrest(String waterMeterRecordsId) {
		// TODO Auto-generated method stub
		meterRecordsMapper.deleteWaterMeterRecords(waterMeterRecordsId);
	}

	
	/**
	 * 根据水表id查询水表使用记录信息
	 * @return
	 */
	@Override
	public List<WaterMeterRecords> listWaterMeterRecordsbyWaterId(
			String waterMeterId) {
		// TODO Auto-generated method stub
		return meterRecordsMapper.listWaterMeterRecordsbyWaterId(waterMeterId);
	}


/*	@Override
	public PageRestful listPageWaterMeterRecords(
			WaterMeterRecords waterMeterRecords) {
		// TODO Auto-generated method stub
		PageRestful pageRestful =new PageRestful();
		List<WaterMeterRecords> WaterMeterRecordss=meterRecordsMapper.listPageWaterMeterRecords(waterMeterRecords);
		pageRestful.setWaterMeterRecords(WaterMeterRecordss);
		pageRestful.setPage(waterMeterRecords.getPage());
		return pageRestful;
	}*/

	/**
	 * 多条件查询水表接口	
	 * @return
	 */
	@Override
	public PageRestful listWaterMeterRecords(SearchMeter searchMeter) {
		// TODO Auto-generated method stub
		PageRestful pageRestful =new PageRestful();
		List<WaterMeterRecords> WaterMeterRecordss=meterRecordsMapper.listPageWaterMeterRecords(searchMeter);
		WaterMeterRecordss.add(0,null);
		pageRestful.setWaterMeterRecords(WaterMeterRecordss);
		pageRestful.setPage(searchMeter.getPage());
		return pageRestful;
	}

	/**
	 * 停用水表
	 */
	@Override
	public void updateWaterMeterRecordsrestbyNum(
			WaterMeterRecords waterMeterRecords) {
		// TODO Auto-generated method stub
	        Date date =new Date();
		if(meterRecordsMapper.updateWaterMeterRecordsbyNum(waterMeterRecords)>0){
			Log log=new Log();
			log.setOperation("停用");//操作
			log.setService("水表停用");//业务
			log.setThing("停用水表："+waterMeterRecords.getWaterMeterNum());
			log.setStaff(waterMeterRecords.getMeterReadingPeople());//操作人
			log.setTable("t_water_meter_records");//操作的表名
			log.setTime(date);
			log.setRelevanceId(waterMeterRecords.getWaterMeterRecordsId());//关联id
			logService.insertWaterLog(log);//记录日志
			
		}
		WaterMeter waterMeter=meterMapper.getWaterMeterbyId(waterMeterRecords.getWaterMeterId());
		if(waterMeter!=null){
			waterMeter.setState(3);
		}
		meterMapper.updateWaterMeter(waterMeter);
		meterRecordsMapper.updateWaterMeterRecordsbyNum(waterMeterRecords);
	}


	@Override
	public List<WaterMeterRecords> listWaterMeterRecordsbybuildigIds(
			List<String> ids) {
		List<WaterMeterRecords> waterMeterRecords=new ArrayList<WaterMeterRecords>();
		for (String id : ids) {
			WaterMeterRecords waterMeterRecord=meterRecordsMapper.listWaterMeterRecordsbybuildigIds(id);
			waterMeterRecords.add(waterMeterRecord);
		}
		return waterMeterRecords;
	}


	@Override
	public WaterMeterRecords waterMeterRecordsbybuildigIds(String buldingId) {
		if(Tools.notEmpty(buldingId)){
			return meterRecordsMapper.listWaterMeterRecordsbybuildigIds(buldingId);
		}
		return null;
	}
	
	@Override
	public WaterMeterRecords getWaterMeterRecordsbybuildigId(String buldingId){
		return meterRecordsMapper.getWaterMeterRecordsbyBuildigId(buldingId);
	}

	@Override
	public void insertWaterMeterRecords(WaterMeterRecords waterMeterRecords) {
		// TODO Auto-generated method stub
		String uuid=UUID.randomUUID().toString();
		
		waterMeterRecords.setWaterMeterRecordsId(uuid);
		WaterMeter waterMeter=meterMapper.getWaterMeterbyId(waterMeterRecords.getWaterMeterId());
		if(waterMeter!=null){
			waterMeter.setState(waterMeterRecords.getState());
		    waterMeterRecords.setAssetsId(waterMeter.getAssetsId());
			waterMeterRecords.setParentId(waterMeter.getWaterMeterId());
		
//			propertyMapper.updateByPrimaryKey(waterMeterRecords.getProperty());		
		}
		WaterMeterRecords waterMeterRecord=meterRecordsMapper.selectByBuildingStructureId(waterMeterRecords.getBuildingStructureId());
		if (waterMeterRecord!=null) {
			waterMeterRecords.setWaterMeterDescribed(waterMeterRecord.getFullName());
		}
		meterRecordsMapper.insertWaterMeterRecords(waterMeterRecords);
		meterMapper.updateWaterMeter(waterMeter);
	}


	@Override
	public PageRestful listPageWaterMeterRecordsById(
			WaterMeterRecords waterMeterRecords) {
		// TODO Auto-generated method stub
		PageRestful pageRestful =new PageRestful();
		List<WaterMeterRecords> WaterMeterRecordss=meterRecordsMapper.listPageWaterMeterRecordsById(waterMeterRecords);
		WaterMeterRecordss.add(0,null);
		pageRestful.setWaterMeterRecords(WaterMeterRecordss);
		pageRestful.setPage(waterMeterRecords.getPage());
		return pageRestful;
	}

	/**
	 * 2015-12-24
	 * 陶勇超
	 * 水表管理-抄表结果
	 * 抄表结果详情导入模版下载
	 */
	@Override
	public InputStream exportMeterRecords() {
		// TODO Auto-generated method stub
		//定义导入模版对象并加空对象
		  List<WaterMeterRecords> listMeter=new ArrayList<WaterMeterRecords>();
		  listMeter.add(null);
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Excel ex=new Excel();
	    List<ExcelInfo> list=new ArrayList<ExcelInfo>();
		String[] headers = { "抄表人","水表编号","区域", "上月读数","本月读数"};
		String[] fields = {"meterReadingPeople","waterMeterNum","fullName","lastMonthReading","reading"};
      List<WaterMeterRecords> dataset = new ArrayList<WaterMeterRecords>();
   
      	ExcelInfo exl=new ExcelInfo();
			exl.setFields(fields);
			exl.setTitles(headers);
			exl.setSheetName("抄表结果详情");
			exl.setList(dataset);
			list.add(exl);
    
		try {
		    return ex.createExcelInputStream(list);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	/**
	 * 2015-12-24
	 * 陶勇超
	 * 水表管理-抄表结果
	 * 抄表结果导入
	 */
	@Override
	public Info importExcelFileMeterRecords(Annex annex) {
		// TODO Auto-generated method stub
		String filePath = annex.getAnnexAddress();
		String UUID1=java.util.UUID.randomUUID().toString();
		String UUID2=java.util.UUID.randomUUID().toString();
		String meterReadingProgramId =annex.getRelationId();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		WaterMeterRecords wmr = null;
		MeterReadingData mrd =null;
		WaterMeterProject pbs=null;
		BuildingStructureNew bsn=null;
		if (Tools.notEmpty(filePath)) {
			try {
				//导入数据插入数据库
				List<Map<Short, String>> dataList = new ExcelUtils().readExcel(filePath);
				if (dataList != null && dataList.size() > 0) {
					for (Map<Short, String> t : dataList) {
						//获取水表ID
						WaterMeter wm=new WaterMeter();
						int db =(int) Double.parseDouble(t.get((short)1));
						String waterId=Integer.toString(db);
						wm=meterMapper.getWaterMeterbyParentNum(t.get((short)1));
						bsn=new BuildingStructureNew();
						bsn=buildingStructureNewMapper.getBuildingStructureNewByFullName(t.get((short) 2));
						//从表格获取数据
						wmr=new WaterMeterRecords(); 
					    wmr.setWaterMeterId(wm.getWaterMeterId());
						wmr.setWaterMeterRecordsId(UUID1);
						wmr.setWaterMeterNum(t.get((short)1));
						wmr.setBuildingStructureId(bsn.getId());
						
						pbs=new WaterMeterProject();
						pbs.setWaterMeterRecordsId(UUID1);
						pbs.setReadingProgramId(meterReadingProgramId);
						//从表格获取数据
						mrd=new MeterReadingData();
						mrd.setMeterExecutiveId(UUID2);
						mrd.setWaterMeterRecordId(UUID1);
					    mrd.setReading(Double.parseDouble(t.get((short) 4)));
					    mrd.setLastMonthReading(Double.parseDouble(t.get((short) 3)));
						mrd.setMeterReadingPeople(t.get((short) 0));
				        mrd.setBuildingStructureId(bsn.getId()); 
						meterRecordsMapper.insertWaterMeterRecords(wmr);
						meterProjectMapper.insertWaterMeterProject(pbs);
						meterReadingDataMapper.insertMeterReadingData(mrd);
					}
					
					return Tools.msg("数据导入成功!",true);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return Tools.msg("数据导入失败!", false);
	}


	@Override
	public List<WaterMeterRecords> listWaterMeterRecordsBybuildigIds(
			String buildingStructureId) {
		// TODO Auto-generated method stub
		return meterRecordsMapper.listWaterMeterRecordsBybuildigIds(buildingStructureId);
	}


	@Override
	public List<WaterMeterRecords> listWaterMeterRecordsByIds(
			String buildingStructureId) {
		// TODO Auto-generated method stub
		return meterRecordsMapper.listWaterMeterRecordsByIds(buildingStructureId);
	}


	@Override
	public List<WaterMeterRecords> listWaterMeterRecordsByWaterMeterId(
			String waterMeterId,Integer year) {
		// TODO Auto-generated method stub
		//List<WaterMeterRecords> list=meterRecordsMapper.listWaterMeterRecordsByWaterMeterId(waterMeterId,year);
		
		List<WaterMeterRecords> listWaterMeterRecords = meterRecordsMapper.listWaterMeterRecordsByWaterMeterId(waterMeterId,year);
		for (WaterMeterRecords item : listWaterMeterRecords) {
			if (item.getMeterReadingPeople()!=null) {
				Staff staff=staffMapper.findStaffBystaffId(item.getMeterReadingPeople());
				if (staff!=null) {
					if (staff.getStaffName()!=null) {
						item.setMeterReadingPeople(staff.getStaffName());
					}
				}
			}
		}
		return meterRecordsMapper.listWaterMeterRecordsByWaterMeterId(waterMeterId,year);
	}

	@Override
	public PageRestful getWaterDamage(WaterMeterRecords waterMeterRecords) {
		Date nowDate = new Date();
		List<WaterMeterRecords> waterMeterRecordList = meterRecordsMapper.listPageWaterDamage(waterMeterRecords); //查询所有父表编号为空的水表
		for (WaterMeterRecords item : waterMeterRecordList) {
			item.setChildMeterReading(0.0);
			Double sumReading = meterRecordsMapper.selectSumReadingByParentNum(item.getWaterMeterNum(), waterMeterRecords.getQueryDate());//主表的子表总量
			if(sumReading != null){
				item.setChildMeterReading(sumReading + item.getChildMeterReading());
			}
			
			item.setChildConsumption(0.0);
			Double sumConsumption = meterRecordsMapper.selectSumConsumptionByParentNum(item.getWaterMeterNum(), waterMeterRecords.getQueryDate(),"0");//主表的子表用水总量
			if(sumConsumption != null){
				item.setChildConsumption(sumConsumption + item.getChildConsumption());
			}
			
			/*if(item.getWaterMeterNum()!=item.getMainNum()){
				item.setFromNum(item.getWaterMeterNum());
			}*/
			
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
			WaterLoss waterLoss1=new WaterLoss();
			waterLoss1.setQueryDate(nowDate);
			waterLoss1.setWaterNum(item.getWaterMeterNum());
			waterLoss1=waterLossMapper.selectByWaterNum(waterLoss1);
			if (waterLoss1!=null) {
				item.setWaterMeterNum(waterLoss1.getWaterNum());
				item.setWaterMeterDescribed(waterLoss1.getWaterName());
				item.setConsumption(waterLoss1.getConsumption());
				item.setChildConsumption(waterLoss1.getChildConsumption());
				item.setWaterLoss(waterLoss1.getWaterLoss());
				item.setLossRate(waterLoss1.getLossRate());
				item.setBootChildConsumption(waterLoss1.getBootChildConsumption());
			}
		}
		PageRestful pageRestful =new PageRestful();
		List<WaterMeterRecords> WaterMeterRecordss = waterMeterRecordList;
		WaterMeterRecordss.add(0,null);
		pageRestful.setWaterMeterRecords(WaterMeterRecordss);
		pageRestful.setPage(waterMeterRecords.getPage());
		return pageRestful;
	}


	@Override
	public PageRestful getWaterDamageTwo(WaterMeterRecords waterMeterRecords) {
		Date nowDate = new Date();
		List<WaterMeterRecords> waterMeterRecordList = meterRecordsMapper.listPageWaterDamageTwo(waterMeterRecords); 
		for (WaterMeterRecords item : waterMeterRecordList) {
			item.setChildMeterReading(0.0);
			Double sumReading = meterRecordsMapper.selectSumReadingByParentNum(item.getWaterMeterNum(), waterMeterRecords.getQueryDate());//主表的子表总量
			if(sumReading != null){
				item.setChildMeterReading(sumReading + item.getChildMeterReading());
			}
			
			item.setChildConsumption(0.0);
			Double sumConsumption = meterRecordsMapper.selectSumConsumptionByParentNum(item.getWaterMeterNum(), waterMeterRecords.getQueryDate(),"0");//公共用水量
			if(sumConsumption != null){
				item.setChildConsumption(sumConsumption + item.getChildConsumption());
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
			WaterLoss waterLoss1=new WaterLoss();
			waterLoss1.setQueryDate(nowDate);
			waterLoss1.setWaterNum(item.getWaterMeterNum());
			waterLoss1=waterLossMapper.selectByWaterNum(waterLoss1);
			if (waterLoss1!=null) {
				item.setWaterMeterNum(waterLoss1.getWaterNum());
				item.setWaterMeterDescribed(waterLoss1.getWaterName());
				item.setConsumption(waterLoss1.getConsumption());
				item.setChildConsumption(waterLoss1.getChildConsumption());
				item.setWaterLoss(waterLoss1.getWaterLoss());
				item.setLossRate(waterLoss1.getLossRate());
				item.setBootChildConsumption(waterLoss1.getBootChildConsumption());
			}
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("queryDate", waterMeterRecords.getQueryDate());
			map.put("parentNumList", Arrays.asList(item.getWaterMeterNum()));
			List<WaterMeterRecords> itemList = meterRecordsMapper.getWaterDamageTwo(map);
			if(itemList != null && itemList.size() > 0){
				item.setHasChird("1");
			} else {
				item.setHasChird("0");
			}
		}
		PageRestful pageRestful =new PageRestful();
		List<WaterMeterRecords> WaterMeterRecordss = waterMeterRecordList;
		WaterMeterRecordss.add(0,null);
		pageRestful.setWaterMeterRecords(WaterMeterRecordss);
		pageRestful.setPage(waterMeterRecords.getPage());
		return pageRestful;
	}

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
			waterLossMapper.deleteByMeterDate(waterMeterRecords.getQueryDate());
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
			
			Double bootReading = 0.0;
			
			
				java.util.List<String> pnList = new java.util.ArrayList<String>();
				String s[]=item.getWaterMeterNum().split(",");
				for(String b : s){
					pnList.add(b);
				}
				
				Map<String, Object> bootMap = new HashMap<String, Object>();
				bootMap.put("queryDate", waterMeterRecords.getQueryDate());
				bootMap.put("parentNumList", pnList);
				List<WaterMeterRecords> bootWaterMeterRecordList = meterRecordsMapper.getWaterDamageTwo(bootMap);
				

//				Double bootReading_child = 0.0;
//				Double bootReading_childs = 0.0;
				for(WaterMeterRecords bootItem : bootWaterMeterRecordList){
//					if("0".equals(bootItem.getIsBilling())){
					Double tmp=meterRecordsMapper.selectSumReadingByParentNum_AndIsBilling1(bootItem.getWaterMeterNum(), waterMeterRecords.getQueryDate());//子表的子表总量

					if(tmp!=null){
						bootReading += tmp;
					}
//					}
//					pnList = new java.util.ArrayList<String>();
//					String f[]=bootItem.getWaterMeterNum().split(",");
//					for(String b : f){
//						pnList.add(b);
//					}
//					Map<String, Object> bootMap_child = new HashMap<String, Object>();
//					bootMap_child.put("queryDate", waterMeterRecords.getQueryDate());
//					bootMap_child.put("parentNumList", pnList);
//					List<WaterMeterRecords> bootWaterMeterRecordList_child = meterRecordsMapper.getWaterDamageTwo(bootMap_child);
//					for(WaterMeterRecords bootItem_child : bootWaterMeterRecordList_child){
//						//计费表才算底层子表用量总和
//						if("0".equals(bootItem_child.getIsBilling())){
//							bootReading += meterRecordsMapper.selectSumReadingByParentNum(bootItem_child.getWaterMeterNum(), waterMeterRecords.getQueryDate());//主表的子表总量
//						}
//					}
						//计费表才算底层子表用量总和
//						if("0".equals(bootItem.getIsBilling())){
//							bootReading += meterRecordsMapper.selectSumReadingByParentNum(item.getWaterMeterNum(), waterMeterRecords.getQueryDate());//主表的子表总量
//							WaterMeterRecords meterRecords = meterRecordsMapper.selectReadingById(bootItem.getFromNum(), waterMeterRecords.getQueryDate()); //查询从表读数
//							
//							if(bootItem.getReading()!=null&&!"".equals(bootItem.getReading())){
//								try{
//									bootReading_child=Double.parseDouble(bootItem.getReading());
//								}catch(NumberFormatException e){
//									bootReading_child=0.0;
//								}
//							}
//							
//							
//							if(meterRecords.getReading()!=null&&!"".equals(meterRecords.getReading())){
//								try{
//									bootReading_childs=Double.parseDouble(meterRecords.getReading());
//								}catch(NumberFormatException e){
//									bootReading_childs=0.0;
//								}
//							}
//							
//							if(meterRecords.getReading() != null && !"".equals(meterRecords.getReading())){
//								bootReading += bootReading_childs + bootReading_child;//主从表读数相加
//							}
//					}
				}
			
			item.setParentNumList(Arrays.asList(item.getWaterMeterNum().split(",")));
			item.setQueryDate(waterMeterRecords.getQueryDate());
			WaterLoss waterLoss = new WaterLoss();
			waterLoss.setWaterNum(item.getWaterMeterNum());
			waterLoss.setWaterName(item.getWaterMeterDescribed());
			waterLoss.setLevel(count);
			if (item.getReading()==null) {
				waterLoss.setConsumption(0.0);
			}else{
				waterLoss.setConsumption(Double.parseDouble(item.getReading()));
			}			
			if(item.getChildMeterReading() != 0.0){
				waterLoss.setChildConsumption(item.getChildMeterReading());
				waterLoss.setBootChildConsumption(bootReading);
				waterLoss.setWaterLoss(waterLoss.getConsumption() - waterLoss.getChildConsumption());
				DecimalFormat df = new DecimalFormat("#.00");
				waterLoss.setLossRate(df.format((waterLoss.getConsumption() - waterLoss.getChildConsumption())/waterLoss.getConsumption()*100) + "%");
			}
			waterLoss.setMeterDate(item.getQueryDate());
			waterLossMapper.insertSelective(waterLoss);
			qwer(item,count + 1);
		}
		
		return null;
	}


	@Override
	public List<WaterMeterOrderRecords> listWaterMeterRecordsByProjectIdAndBuildingStructureId(Search search) {
		// listWaterMeterRecordsByProjectIdAndBuildingStructureId
		return meterRecordsMapper.listWaterMeterRecordsByProjectIdAndBuildingStructureId(search);
	}


	public StaffMapper getStaffMapper() {
		return staffMapper;
	}


	public void setStaffMapper(StaffMapper staffMapper) {
		this.staffMapper = staffMapper;
	}
}