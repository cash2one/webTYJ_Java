/**
 * @Title: StoreNewServiceImpl.java
 * @Package com.flf.service.impl
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-6-10 上午10:21:52
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
import com.flf.entity.PageRestful;
import com.flf.entity.Project;
import com.flf.entity.Search;
import com.flf.entity.StallNew;
import com.flf.entity.StoreNew;
import com.flf.mapper.AreaTypeNewMapper;
import com.flf.mapper.BuildingStructureNewMapper;
import com.flf.mapper.ProjectMapper;
import com.flf.mapper.StoreNewMapper;
import com.flf.request.ExcelInfo;
import com.flf.request.Info;
import com.flf.service.StoreNewService;
import com.flf.util.Excel;
import com.flf.util.ExcelUtils;
import com.flf.util.ExportExcel;
import com.flf.util.Tools;

/**
 * @ClassName: StoreNewServiceImpl
 * @Description: TODO
 * @author wangyong
 * @date 2015-6-10 上午10:21:52
 *
 */

public class StoreNewServiceImpl implements StoreNewService {

	private  StoreNewMapper  storeNewMapper;
	
	private BuildingStructureNewMapper buildingStructureNewMapper;
	
	private AreaTypeNewMapper areaTypeNewMapper;
	
	private ProjectMapper projectMapper;
	
	/*
	 * <p>Title: getStoreNewRest</p>
	 * <p>Description: </p>
	 * @param id
	 * @return
	 * @see com.flf.service.StoreNewService#getStoreNewRest(java.lang.String)
	 */

	public StoreNewMapper getStoreNewMapper() {
		return storeNewMapper;
	}

	public void setStoreNewMapper(StoreNewMapper storeNewMapper) {
		this.storeNewMapper = storeNewMapper;
	}

	/*
	  * <p>Title: getStoreNewRest</p>
	  * <p>Description: </p>
	  * @param id
	  * @return
	  * @see com.flf.service.StoreNewService#getStoreNewRest(java.lang.String)
	  */
	
	
	public BuildingStructureNewMapper getBuildingStructureNewMapper() {
		return buildingStructureNewMapper;
	}

	public void setBuildingStructureNewMapper(
			BuildingStructureNewMapper buildingStructureNewMapper) {
		this.buildingStructureNewMapper = buildingStructureNewMapper;
	}

	public AreaTypeNewMapper getAreaTypeNewMapper() {
		return areaTypeNewMapper;
	}

	public void setAreaTypeNewMapper(AreaTypeNewMapper areaTypeNewMapper) {
		this.areaTypeNewMapper = areaTypeNewMapper;
	}

	public ProjectMapper getProjectMapper() {
		return projectMapper;
	}

	public void setProjectMapper(ProjectMapper projectMapper) {
		this.projectMapper = projectMapper;
	}

	@Override
	public StoreNew getStoreNewRest(String id) {
		// TODO Auto-generated method stub
		return storeNewMapper.selectStoreNew(id);
	}

	/*
	  * <p>Title: insertStoreNewRestful</p>
	  * <p>Description: </p>
	  * @param StoreNew
	  * @see com.flf.service.StoreNewService#insertStoreNewRestful(com.flf.entity.StoreNew)
	  */
	
	
	@Override
	public void insertStoreNewRestful(StoreNew StoreNew) {
		// TODO Auto-generated method stub
		storeNewMapper.insert(StoreNew);
		
	}
//intakeDate buildingArea insideArea commonalityArea completionArea
	@Override
	public void addStoreNew(StoreNew storeNew) {
		// TODO Auto-generated method stub
		List<StoreNew> snList = storeNew.getStoreList();
		for(StoreNew s : snList){
			StoreNew store = new StoreNew();
			store.setBuildingId(s.getBuildingId());
			store.setBuildingStructureId(s.getBuildingStructureId());
			store.setProjectId(s.getProjectId());
			store.setStoreNumber(s.getStoreNumber().trim() == ""?"":s.getStoreNumber());
			store.setIntakeDate(s.getIntakeDate());
			store.setInsideArea(s.getInsideArea());
			store.setBuildingArea(s.getBuildingArea());
			store.setCommonalityArea(s.getCommonalityArea());
			store.setCompletionArea(s.getCommonalityArea());
			store.setStoreTyoe(s.getStoreTyoe().trim() ==""?"":s.getStoreTyoe());
			//增加商铺新增时的字段  王洲  2016.02.25
			store.setIntakeState(s.getIntakeState());
			store.setStoreCode(s.getStoreCode());
			storeNewMapper.insert(store);
		}
	}

	@Override
	public List<StoreNew> listSearchStoreNew(Search search) {
		// TODO Auto-generated method stub
		return storeNewMapper.listSearchStoreNew(search);
	}

	/**
	 * 将需要excel导入的数据先写入excel模板并导出到本地
	 */
	@Override
	public InputStream exportStoreNewFile(String projectId){
		
		//获取所有面积类型
		List<AreaTypeNew> areaTypeNewList = areaTypeNewMapper.listAllAreaTypeNew();
		Map<String, String> areaTypeMap = new HashMap<String, String>();
		for (AreaTypeNew areaTypeNew : areaTypeNewList) {
			areaTypeMap.put(areaTypeNew.getAreaTypeCode(), areaTypeNew.getId());
		}
		
		//根据传入的projectId获取该项目下所有的类型为住宅的建筑结构
		BuildingStructureNew bsn = new BuildingStructureNew();
		bsn.setAreaId(areaTypeMap.get("store"));
		bsn.setProjectId(projectId);
		List<BuildingStructureNew> bsnList = buildingStructureNewMapper.listBuildingStructureByProjectIdAndAreaId(bsn);
		
		//根据传入的projectId获取该项目下的所有house数据
		List<StoreNew> snList = storeNewMapper.listStoreByProjectId(projectId);
		
		//生成需要写入的建筑结构数据集合
		List<BuildingStructureNew> _snList = new ArrayList<BuildingStructureNew>();
		for(BuildingStructureNew buildingStructureNew : bsnList){
			int i = 0;
			for (StoreNew storeNew : snList) {
				if(!buildingStructureNew.getId().toString().equals(storeNew.getBuildingStructureId().toString())){
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
	    String[] headers = { "建筑结构归属编号","建筑归属编号","项目归属编号","商铺名称","商业属性", "商铺编码", "商铺号", "建筑面积", "套内面积","分摊面积","竣工面积","竣工日期", "销售状态"};
		String[] fields = {"buildingStructureId","buildingId","projectId","fullName"};
		List<StoreNew> dataset = new ArrayList<StoreNew>();
        for(BuildingStructureNew bsns : _snList){
        	StoreNew sn = new StoreNew();
        	sn.setBuildingStructureId(bsns.getId());
        	sn.setBuildingId(bsns.getBuildingId());
        	sn.setProjectId(bsns.getProjectId());
        	sn.setFullName(bsns.getFullName());
        	dataset.add(sn);
        }
        if(dataset.size() > 0){
        	ExcelInfo exl=new ExcelInfo();
			exl.setFields(fields);
			exl.setTitles(headers);
			exl.setSheetName("商铺记录模板");
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
		
		//查询出现有的商铺信息，用于判断是否有重复数据
		List<StoreNew> storeList = storeNewMapper.listAllStoreNew();
		
		String filePath = annex.getAnnexAddress();
		if(Tools.notEmpty(filePath)){
			try {
				List<Map<Short, String>> dataList = new ExcelUtils().readExcel(filePath);
				if(dataList != null && dataList.size() > 0){
					for(Map<Short, String> t : dataList){
						int count = 0;
						for(int i = 0; i < storeList.size(); i++){
							if(t.get((short)0) == storeList.get(i).getBuildingStructureId()){
								count++;
							}
						}
						if(count == 0){
							StoreNew storeNew = new StoreNew();
							storeNew.setStoreId(UUID.randomUUID().toString());
							storeNew.setBuildingStructureId(t.get((short)0));//建筑结构id
							storeNew.setBuildingId(t.get((short)1));//建筑id
							storeNew.setProjectId(t.get((short)2));//项目id
							storeNew.setStoreTyoe(t.get((short)4));//商铺属性
							storeNew.setStoreCode(t.get(5));//商铺编码
							storeNew.setStoreNumber(t.get((short)6).trim());//商铺号
							storeNew.setBuildingArea(Double.parseDouble(t.get((short)7)));//建筑面积
							storeNew.setInsideArea(Double.parseDouble(t.get((short)8)));//套内面积
							storeNew.setCommonalityArea(Double.parseDouble(t.get((short)9)));//分摊面积
							storeNew.setCompletionArea(Double.parseDouble(t.get((short)10)));//竣工面积
							storeNew.setIntakeDate(sdf.parse(t.get((short)11)));//竣工日期
							storeNew.setIntakeState((byte) (t.get((short)12).trim().toString().equals("未售") ? 0 : 1));//销售状态
							storeNewMapper.insert(storeNew);
							storeList.add(storeNew);
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
	 * 导出所有商铺信息
	 * 王洲
	 * 2016.1.8
	 */
	@Override
	public InputStream exportAllStoreNew(){
		//获取所有面积类型
 		List<AreaTypeNew> areaTypeNewList = areaTypeNewMapper.listAllAreaTypeNew();
		Map<String, String> areaTypeMap = new HashMap<String, String>();
		for (AreaTypeNew areaTypeNew : areaTypeNewList) {
			areaTypeMap.put(areaTypeNew.getAreaTypeCode(), areaTypeNew.getId());
		}
		
		//获取所有商铺的信息
		List<StoreNew> snList = storeNewMapper.listAllStoreNew();
		
		//循环设置商铺用于导出的竣工时间并存放到导出的list中
		List<StoreNew> dataset = new ArrayList<StoreNew>();
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		for(StoreNew sn : snList){
			if(sn.getBuildingStructureNew() != null){
				sn.setFullName(sn.getBuildingStructureNew().getFullName());				
			}
			if(sn.getIntakeDate() != null){
				sn.setE_intakeDate(sdf.format(sn.getIntakeDate()));				
			}else{
				sn.setE_intakeDate("");
			}
			if(sn.getIntakeState() != null){
				if(sn.getIntakeState() == 0){
					sn.setIntakeStates("未售");
				}else{
					sn.setIntakeStates("已售");
				}
			}else{
				sn.setIntakeStates("未售");
			}
			dataset.add(sn);
		}
		
		//导出到excel
		Excel ex=new Excel();
	    List<ExcelInfo> list=new ArrayList<ExcelInfo>();
		//String[] headers = {"所属项目","商铺名称","商铺属性","商铺号","建筑面积", "套内面积", "分摊面积", "竣工面积", "竣工日期"};
		String[] headers = {"名称","商业属性","商铺编码","商铺号","建筑面积","公摊面积","套内面积","竣工面积","竣工日期","销售状态"};
	    String[] fields = {"fullName","storeTyoe","storeCode","storeNumber","buildingArea","commonalityArea","insideArea","completionArea","e_intakeDate","intakeStates"};
        
        if(dataset.size() > 0){
        	ExcelInfo exl=new ExcelInfo();
			exl.setFields(fields);
			exl.setTitles(headers);
			exl.setSheetName("商铺记录");
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
	public void updateStoreNew(StoreNew storeNew){
		List<StoreNew> storeList = storeNew.getStoreList();
		if(storeList != null && storeList.size() > 0){
			for(StoreNew store : storeList){
				storeNewMapper.updateStoreNew(store);
			}
		}
	}
	
	@Override
	public PageRestful listPageStoreByProjectId(StoreNew storeNew){
		PageRestful pageRestful = new PageRestful();
		List<StoreNew> storeNews = storeNewMapper.listPageStoreByProjectId(storeNew);
		for(StoreNew sn : storeNews){
			if(sn.getIntakeState() != null){
				if(sn.getIntakeState().equals((byte)1)){
					sn.setIntakeStates("已售");
				}else{
					sn.setIntakeStates("未售");
				}				
			}else{
				sn.setIntakeStates("未售");
			}
		}
		storeNews.add(0, null);
		pageRestful.setStoreNews(storeNews);
		pageRestful.setPage(storeNew.getPage());
		return pageRestful;
	}

	@Override
	public void updateStore(StoreNew storeNew){
		storeNewMapper.updateStoreNew(storeNew);
	}
	
	@Override
	public PageRestful listPageStoreByBuildingStructureId(StoreNew storeNew){
		PageRestful pageRestful = new PageRestful();
		List<StoreNew> storeNews = storeNewMapper.listPageStoreByBuildingStructureId(storeNew);
		for(StoreNew sn : storeNews){
			if(sn.getIntakeState() != null){
				if(sn.getIntakeState().equals((byte)1)){
					sn.setIntakeStates("已售");
				}else{
					sn.setIntakeStates("未售");
				}				
			}else{
				sn.setIntakeStates("未售");
			}
		}
		storeNews.add(0, null);
		pageRestful.setStoreNews(storeNews);
		pageRestful.setPage(storeNew.getPage());
		return pageRestful;
	}
	
}
