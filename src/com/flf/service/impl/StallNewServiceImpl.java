/**
 * @Title: StallNewServiceImpl.java
 * @Package com.flf.service.impl
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-6-16 上午10:19:36
 * @version V1.0
 */

package com.flf.service.impl;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.flf.entity.Annex;
import com.flf.entity.AreaTypeNew;
import com.flf.entity.BuildingStructureNew;
import com.flf.entity.CarInfo;
import com.flf.entity.Caraccesscard;
import com.flf.entity.HouseNew;
import com.flf.entity.PageRestful;
import com.flf.entity.PersonCustNew;
import com.flf.entity.Project;
import com.flf.entity.Search;
import com.flf.entity.StallNew;
import com.flf.mapper.AreaTypeNewMapper;
import com.flf.mapper.BuildingStructureNewMapper;
import com.flf.mapper.ProjectMapper;
import com.flf.mapper.StallNewMapper;
import com.flf.request.ExcelInfo;
import com.flf.request.Info;
import com.flf.service.StallNewService;
import com.flf.util.Excel;
import com.flf.util.ExcelUtils;
import com.flf.util.ExportExcel;
import com.flf.util.Tools;

/**
 * @ClassName: StallNewServiceImpl
 * @Description: TODO
 * @author wangyong
 * @date 2015-6-16 上午10:19:36
 *
 */

public class StallNewServiceImpl implements StallNewService {

	private StallNewMapper stallNewMapper;
	
	private AreaTypeNewMapper areaTypeNewMapper;
	
	private BuildingStructureNewMapper buildingStructureNewMapper;
	
	private ProjectMapper projectMapper;
	/*
	 * <p>Title: listPageStallNew</p>
	 * <p>Description: </p>
	 * @return
	 * @see com.flf.service.StallNewService#listPageStallNew()
	 */

	public StallNewMapper getStallNewMapper() {
		return stallNewMapper;
	}

	public void setStallNewMapper(StallNewMapper stallNewMapper) {
		this.stallNewMapper = stallNewMapper;
	}

	public AreaTypeNewMapper getAreaTypeNewMapper() {
		return areaTypeNewMapper;
	}

	public void setAreaTypeNewMapper(AreaTypeNewMapper areaTypeNewMapper) {
		this.areaTypeNewMapper = areaTypeNewMapper;
	}

	public BuildingStructureNewMapper getBuildingStructureNewMapper() {
		return buildingStructureNewMapper;
	}

	public void setBuildingStructureNewMapper(
			BuildingStructureNewMapper buildingStructureNewMapper) {
		this.buildingStructureNewMapper = buildingStructureNewMapper;
	}

	public ProjectMapper getProjectMapper() {
		return projectMapper;
	}

	public void setProjectMapper(ProjectMapper projectMapper) {
		this.projectMapper = projectMapper;
	}

	@Override
	public List<StallNew> listStallNew() {
		// TODO Auto-generated method stub
		return stallNewMapper.listAllStallNew();
	}

	/*
	 * <p>Title: getStallNewByIdRest</p>
	 * <p>Description: </p>
	 * @param StallNewId
	 * @return
	 * @see com.flf.service.StallNewService#getStallNewByIdRest(java.lang.String)
	 */

	@Override
	public StallNew getStallNewByIdRest(String StallNewId) {
		// TODO Auto-generated method stub
		return stallNewMapper.getStallNewById(StallNewId);
	}

	/*
	 * <p>Title: AddStallNew</p>
	 * <p>Description: </p>
	 * @param StallNew
	 * @see com.flf.service.StallNewService#AddStallNew(com.flf.entity.StallNew)
	 */

	@Override
	public void AddStallNew(StallNew StallNew) {
		// TODO Auto-generated method stub
		stallNewMapper.insertStallNew(StallNew);

	}

	/*
	 * <p>Title: UpdateStallNew</p>
	 * <p>Description: </p>
	 * @param StallNew
	 * @see com.flf.service.StallNewService#UpdateStallNew(com.flf.entity.StallNew)
	 */

	@Override
	public void UpdateStallNew(StallNew StallNew) {
		// TODO Auto-generated method stub
		stallNewMapper.updateStallNew(StallNew);
	}

	/*
	 * <p>Title: DeleteStallNewById</p>
	 * <p>Description: </p>
	 * @param StallNewId
	 * @see com.flf.service.StallNewService#DeleteStallNewById(java.lang.String)
	 */

	@Override
	public void DeleteStallNewById(String StallNewId) {
		// TODO Auto-generated method stub
		stallNewMapper.deleteStallNew(StallNewId);
	}

	@Override
	public void AddStallNew2(StallNew stallNew) {
		List<StallNew> sList = stallNew.getStallNews();
		for(StallNew  sn : sList){
			StallNew stall = new StallNew();
			stall.setStallId(UUID.randomUUID().toString());
			stall.setBuildingId(sn.getBuildingId());
			stall.setBuildingStructureId(sn.getBuildingStructureId());
			stall.setProjectId(sn.getProjectId());
			stall.setStallProperty(sn.getStallProperty());
			stall.setIsMechanicalStall(sn.getIsMechanicalStall());
			stall.setIntakeDate(sn.getIntakeDate());
			////增加车位新增时的字段  王洲  2016.02.25
			stall.setStallCoding(sn.getStallCoding());
			stall.setStallNumber(sn.getStallNumber());
			stall.setIntakeState(sn.getIntakeState());
			stallNewMapper.insertStallNew(stall);
		}
	}

	@Override
	public List<StallNew> listSearchStall(Search search) {
		// TODO Auto-generated method stub
		List<StallNew> stallNews=stallNewMapper.listSearchStallNew(search);
		return stallNews;
	}
	
	/**
	 * 创建by肖聪 2015/7/10
	 * 通过条件查询办理人和授权人的车位信息
	 * @param search
	 */

	@Override
	public List<StallNew> listSearchStallAu(Search search) {
		// TODO Auto-generated method stub
		List<StallNew> stalls=stallNewMapper.listSearchStallNew(search);
		List<StallNew> stallone=stallNewMapper.listSearchStallNewAu(search);
		
		stalls.addAll(stallone);
		
		return stalls;
	} 
	
	@Override
	public List<StallNew> listStallByPersonCustId(String personCustId) {
		// TODO Auto-generated method stub
		return stallNewMapper.listStallByPersonCustId(personCustId);
	}

	@Override
	public PageRestful listPageStallNewByType(StallNew stallNew) {
		// TODO Auto-generated method stub
		PageRestful pageRestful = new PageRestful();
//		List<StallNew> stallNews = stallNewMapper.listPageStallNewByType(stallNew);
		List<StallNew> stallNews = stallNewMapper.listPageFixedStallNew(stallNew);
		stallNews.add(0, null);
		pageRestful.setStallNews(stallNews);
		pageRestful.setPage(stallNew.getPage());
		return pageRestful;
	}
	
	/**
	 * 将需要excel导入的数据先写入excel模板并导出到本地
	 */
	@Override
	public InputStream exportStallNewFile(String projectId){
		
		//获取所有面积类型
		List<AreaTypeNew> areaTypeNewList = areaTypeNewMapper.listAllAreaTypeNew();
		Map<String, String> areaTypeMap = new HashMap<String, String>();
		for (AreaTypeNew areaTypeNew : areaTypeNewList) {
			areaTypeMap.put(areaTypeNew.getAreaTypeCode(), areaTypeNew.getId());
		}
		
		//根据传入的projectId获取该项目下所有的类型为住宅的建筑结构
		BuildingStructureNew bsn = new BuildingStructureNew();
		bsn.setAreaId(areaTypeMap.get("parkspace"));
		bsn.setProjectId(projectId);
		List<BuildingStructureNew> bsnList = buildingStructureNewMapper.listBuildingStructureByProjectIdAndAreaId(bsn);
		
		//根据传入的projectId获取该项目下的所有车位数据
		List<StallNew> snList = stallNewMapper.listStallByProjectId(projectId);
		
		//生成需要写入的建筑结构数据集合
		List<BuildingStructureNew> _snList = new ArrayList<BuildingStructureNew>();
		for(BuildingStructureNew buildingStructureNew : bsnList){
			int i = 0;
			for (StallNew stallNew : snList) {
				if(!buildingStructureNew.getId().toString().equals(stallNew.getBuildingStructureId().toString())){
					i++;
				}
			}
			if(i == snList.size()){
				_snList.add(buildingStructureNew);
			}
		}
		//导出到excel
		Excel ex=new Excel();
	    List<ExcelInfo> list=new ArrayList<ExcelInfo>();
	    String[] headers = { "建筑结构归属编号","建筑归属编号","项目归属编号","车位名称", "车位编码", "车位属性", "车位号", "是否机械车位", "竣工日期", "销售状态"};
		String[] fields = {"buildingStructureId","buildingId","projectId","stallPosition"};
        List<StallNew> dataset = new ArrayList<StallNew>();
        for(BuildingStructureNew bsns : _snList){
        	StallNew sn = new StallNew();
        	sn.setBuildingStructureId(bsns.getId());
        	sn.setBuildingId(bsns.getBuildingId());
        	sn.setProjectId(bsns.getProjectId());
        	sn.setStallPosition(bsns.getFullName());
        	dataset.add(sn);
        }
        if(dataset.size() > 0){
        	ExcelInfo exl=new ExcelInfo();
			exl.setFields(fields);
			exl.setTitles(headers);
			exl.setSheetName("车位记录模板");
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
	public Info importExcelFile(Annex annex){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		//查询车位表中的所有数据,用于判断是否有重复数据
		List<StallNew> stallList = stallNewMapper.listAllStallNew();
		
		String filePath = annex.getAnnexAddress();
		if(Tools.notEmpty(filePath)){
			try {
				List<Map<Short, String>> dataList = new ExcelUtils().readExcel(filePath);
				if(dataList != null && dataList.size() > 0){
					for(Map<Short, String> t : dataList){
						int count = 0;
						for(int i = 0; i < stallList.size(); i++){
							if(t.get((short)0) == stallList.get(i).getBuildingStructureId()){
								count++;
							}
						}
						if(count == 0){
							StallNew stallNew = new StallNew();
							stallNew.setStallId(UUID.randomUUID().toString());
							stallNew.setBuildingStructureId(t.get((short)0));//建筑结构id
							stallNew.setBuildingId(t.get((short)1));//建筑id
							stallNew.setProjectId(t.get((short)2));//项目id
							stallNew.setStallCoding(t.get((short)4));//车位编码
							stallNew.setStallProperty(t.get((short)5));//车位属性
							stallNew.setStallNumber(t.get((short)6));//车位号
							stallNew.setIsMechanicalStall(t.get((short)7).trim().toString().equals("是") ? "1" : "0");//机械车位
							stallNew.setIntakeDate(sdf.parse(t.get((short)8)));//竣工日期
							stallNew.setIntakeState((byte) (t.get((short)9).trim().toString().equals("未售") ? 0 : 1));//销售状态
							
							stallNewMapper.insertStallNew(stallNew);
							stallList.add(stallNew);
						}
					}
					return Tools.msg("数据导入成功！", true);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return Tools.msg("数据导入失败！", false);
	}
	
	/**
	 * 导出所有车位记录
	 * 王洲
	 * 2016.1.8
	 */
	@Override
	public InputStream exportAllStallNew(){
		//获取所有面积类型
		List<AreaTypeNew> areaTypeNewList = areaTypeNewMapper.listAllAreaTypeNew();
		Map<String, String> areaTypeMap = new HashMap<String, String>();
		for (AreaTypeNew areaTypeNew : areaTypeNewList) {
			areaTypeMap.put(areaTypeNew.getAreaTypeCode(), areaTypeNew.getId());
		}
		
		//获取所有车位的信息
		List<StallNew> snList = stallNewMapper.listAllStallNew();
		
		//循环设置车位用于导出的竣工时间并存放到导出的list中
		List<StallNew> dataset = new ArrayList<StallNew>();
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		for(StallNew sn : snList){
			if(sn.getBuildingStructureNew() != null){
				sn.setFullName(sn.getBuildingStructureNew().getFullName());				
			}else{
				sn.setFullName("");
			}
			if(sn.getIsMechanicalStall().equals("1")){
				sn.setIsMechanicalStall("机械车位");
			}else{
				sn.setIsMechanicalStall("非机械车位");
			}
			if(sn.getIntakeDate() != null){
				sn.setE_intakeDate(sdf.format(sn.getIntakeDate()));				
			}else{
				sn.setE_intakeDate("");
			}
			if(sn.getIntakeState() != null){
				if(sn.getIntakeState() == 1){
					sn.setIntakeStates("已售");
				}else{
					sn.setIntakeStates("未售");
				}
			}else{
				sn.setIntakeStates("未售");
			}
			dataset.add(sn);
		}
		
		//导出到excel
		Excel ex=new Excel();
	    List<ExcelInfo> list=new ArrayList<ExcelInfo>();
		//String[] headers = {"所属项目","车位名称","车位类型", "是否机械车位", "是否固定车位", "竣工日期"};
		String[] headers = {"名称","车位编码","车位属性","车位号","机械车位","竣工日期","销售状态"};
	    String[] fields = {"fullName","stallCoding","stallProperty","stallNumber","isMechanicalStall","e_intakeDate","intakeStates"};
        
        if(dataset.size() > 0){
        	ExcelInfo exl=new ExcelInfo();
			exl.setFields(fields);
			exl.setTitles(headers);
			exl.setSheetName("车位记录");
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
	public List<StallNew> listStallByStallType(String stallType) {
		// TODO Auto-generated method stub
		return stallNewMapper.listStallByStallType(stallType);
	}
	
	@Override
	public void updateStallNew(StallNew stallNew){
		List<StallNew> stallList = stallNew.getStallNews();
		if(stallList != null && stallList.size() > 0){
			for(StallNew stall : stallList){
				stallNewMapper.updateStallNew(stall);
			}
		}
	}
	
	@Override
	public PageRestful listPageStallByProjectId(StallNew stallNew){
		PageRestful pageRestful = new PageRestful();
		List<StallNew> stallNews = stallNewMapper.listPageStallByProjectId(stallNew);
		for(StallNew sn : stallNews){
			if(sn.getIntakeState() != null){
				if(sn.getIntakeState().equals((byte)1)){
					sn.setIntakeStates("已售");
				}else{
					sn.setIntakeStates("未售");
				}
			}else{
				sn.setIntakeStates("未售");
			}
			if(sn.getIsMechanicalStall() != null){
				if(sn.getIsMechanicalStall().equals((byte)1)){
					sn.setIsMechanicalStall("是");
				}else{
					sn.setIsMechanicalStall("否");
				}
			}else{
				sn.setIsMechanicalStall("否");
			}
		}
		stallNews.add(0, null);
		pageRestful.setStallNews(stallNews);
		pageRestful.setPage(stallNew.getPage());
		return pageRestful;
	}
	
	
	

	@Override
	public void updateStall(StallNew stallNew){
		//bug1771 朱琪 2016.05.18  
		StallNew sn = stallNewMapper.getStallNewById(stallNew.getStallId());
		//修改为未出售初始化
		if(stallNew.getStallState() == (byte)0){
			sn = stallNew;
		}else{
			//销售状态
			if(sn.getStallState() == (byte)0){
				sn.setStallState(stallNew.getStallState());
			}
			//车位编码
			if(stallNew.getStallCoding()!=null){
				sn.setStallCoding(stallNew.getStallCoding());
			}
			//车位属性
			if(stallNew.getStallProperty()!=null){
				sn.setStallProperty(stallNew.getStallProperty());
			}
			//车位号
			if(stallNew.getStallNumber()!=null){
				sn.setStallNumber(stallNew.getStallNumber());
			}
			//机械车位
			if(stallNew.getIsMechanicalStall()!=null){
				sn.setIsMechanicalStall(stallNew.getIsMechanicalStall());
			}
			//竣工日期
			if(stallNew.getIntakeDate()!=null){
				sn.setIntakeDate(stallNew.getIntakeDate());
			}
		}
		stallNewMapper.updateStallNew(sn);
	}
	
	//
	@Override
	public PageRestful listPageStallByBuildingStructureId(StallNew stallNew){
		PageRestful pageRestful = new PageRestful();
		List<StallNew> stallNews = stallNewMapper.listPageStallByBuildingStructureId(stallNew);
		for(StallNew sn : stallNews){
			if(sn.getIntakeState() != null){
				if(sn.getIntakeState().equals((byte)1)){
					sn.setIntakeStates("已售");
				}else{
					sn.setIntakeStates("未售");
				}
			}else{
				sn.setIntakeStates("未售");
			}
			if(sn.getIsMechanicalStall() != null){
				if(sn.getIsMechanicalStall().equals((byte)1)){
					sn.setIsMechanicalStall("是");
				}else{
					sn.setIsMechanicalStall("否");
				}
			}else{
				sn.setIsMechanicalStall("否");
			}
		}
		stallNews.add(0, null);
		pageRestful.setStallNews(stallNews);
		pageRestful.setPage(stallNew.getPage());
		return pageRestful;
	}
}