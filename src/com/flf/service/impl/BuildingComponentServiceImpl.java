/**
 * @Title: BuildingComponentServiceImpl.java
 * @Package com.flf.service.impl
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-6-23 下午4:45:01
 * @version V1.0
 */

package com.flf.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.ctc.wstx.util.StringUtil;
import com.flf.entity.Annex;
import com.flf.entity.AreaTypeNew;
import com.flf.entity.BuildingComponent;
import com.flf.entity.ComponentProperty;
import com.flf.entity.DataDictionarySlave;
import com.flf.entity.Functional;
import com.flf.entity.PageRestful;
import com.flf.entity.PersonCustNew;
import com.flf.entity.Property;
import com.flf.mapper.AreaTypeNewMapper;
import com.flf.mapper.BuildingComponentMapper;
import com.flf.mapper.ComponentPropertyMapper;
import com.flf.mapper.DataDictionarySlaveMapper;
import com.flf.mapper.FunctionalMapper;
import com.flf.mapper.PropertyMapper;
import com.flf.request.ExcelInfo;
import com.flf.request.Info;
import com.flf.service.BuildingComponentService;
import com.flf.util.DateUtil;
import com.flf.util.Excel;
import com.flf.util.ExcelUtils;
import com.flf.util.Tools;

import cn.jpush.api.utils.StringUtils;

/**
 * @ClassName: BuildingComponentServiceImpl
 * @Description: TODO
 * @author wangyong
 * @date 2015-6-23 下午4:45:01
 * @author zhuwei
 * @date 2015-07-01
 */

public class BuildingComponentServiceImpl implements BuildingComponentService {
	
	private BuildingComponentMapper buildingComponentMapper;

	private ComponentPropertyMapper componentPropertyMapper;
	
	private AreaTypeNewMapper areaTypeNewMapper;
	
	private FunctionalMapper functionalMapper;
	
	private PropertyMapper propertyMapper;
	
	private DataDictionarySlaveMapper dataDictionarySlaveMapper;

	public ComponentPropertyMapper getComponentPropertyMapper() {
		return componentPropertyMapper;
	}

	public void setComponentPropertyMapper(
			ComponentPropertyMapper componentPropertyMapper) {
		this.componentPropertyMapper = componentPropertyMapper;
	}

	public BuildingComponentMapper getBuildingComponentMapper() {
		return buildingComponentMapper;
	}

	public void setBuildingComponentMapper(
			BuildingComponentMapper buildingComponentMapper) {
		this.buildingComponentMapper = buildingComponentMapper;
	}

	public AreaTypeNewMapper getAreaTypeNewMapper() {
		return areaTypeNewMapper;
	}

	public void setAreaTypeNewMapper(AreaTypeNewMapper areaTypeNewMapper) {
		this.areaTypeNewMapper = areaTypeNewMapper;
	}

	public FunctionalMapper getFunctionalMapper() {
		return functionalMapper;
	}

	public void setFunctionalMapper(FunctionalMapper functionalMapper) {
		this.functionalMapper = functionalMapper;
	}

	public PropertyMapper getPropertyMapper() {
		return propertyMapper;
	}

	public void setPropertyMapper(PropertyMapper propertyMapper) {
		this.propertyMapper = propertyMapper;
	}

	public DataDictionarySlaveMapper getDataDictionarySlaveMapper() {
		return dataDictionarySlaveMapper;
	}

	public void setDataDictionarySlaveMapper(DataDictionarySlaveMapper dataDictionarySlaveMapper) {
		this.dataDictionarySlaveMapper = dataDictionarySlaveMapper;
	}

	@Override
	public PageRestful listPageBuildingComponent(
			BuildingComponent buildingComponent) {
		PageRestful pagerestful=new PageRestful();
		List<BuildingComponent> buildingComponents =buildingComponentMapper.listPageBuildingComponentAll(buildingComponent);	
		buildingComponents.add(0,null);
		pagerestful.setBuildingComponents(buildingComponents);
		pagerestful.setPage(buildingComponent.getPage());
		return pagerestful;
	}

	/*
	 * <p>Title: listBuildingComponentAll</p>
	 * <p>Description: </p>
	 * @return
	 * @see com.flf.service.BuildingComponentService#listBuildingComponentAll()
	 */

	@Override
	public List<BuildingComponent> listBuildingComponentAll() {
		List<BuildingComponent> blist = buildingComponentMapper.ListselectBuildingComponentAll();
		return blist;
	}

	/*
	 * <p>Title: getBuildingComponentByIdRest</p>
	 * <p>Description: </p>
	 * @param BuildingComponentId
	 * @return
	 * @see com.flf.service.BuildingComponentService#getBuildingComponentByIdRest(java.lang.String)
	 */

	@Override
	public BuildingComponent getBuildingComponentByIdRest(
			String BuildingComponentId) {
		BuildingComponent bc = null;
		bc = buildingComponentMapper.selectBuildingComponentById(BuildingComponentId);
		AreaTypeNew atn = areaTypeNewMapper.getAreaTypeNewByareaTypeId(bc.getComponentType());
		if(atn != null){
		bc.setAreaTypeName(atn.getAreaTypeName());
		}
		return bc;
	}

	/*
	 * <p>Title: AddBuildingComponent</p>
	 * <p>Description: </p>
	 * @param BuildingComponent
	 * @see com.flf.service.BuildingComponentService#AddBuildingComponent(com.flf.entity.BuildingComponent)
	 */

	@Override
	public int AddBuildingComponent(BuildingComponent buildingComponent) {
		
		//组件名是否重复
		if(buildingComponentMapper.findDataByName(buildingComponent).size() != 0){
			return 0;
		}
		
		String uuid =UUID.randomUUID().toString();  //生成主键id
		buildingComponent.setComponentId(uuid); //设置组件id
		//BuildingComponent.setCreaterName("");;//设置创建人
		buildingComponent.setCreaterDate(DateUtil.currentDate());//设置创建时间
		buildingComponent.setSortDate(DateUtil.currentDate());//设置排序时间
		
		//生成编号 朱琪 2016.02.23
		String number=buildingComponentMapper.selectComCode();
		if(number==null||number.equals("")){
			number="10000";			
		}else{
			number=String.valueOf(Integer.parseInt(number)+1);
		}
		buildingComponent.setComponentNum(number);

		buildingComponentMapper.insertBuildingComponentUUID(buildingComponent);
		if(buildingComponent.getComponentPropertys() != null)
		{
		for (ComponentProperty componentProperty : buildingComponent.getComponentPropertys()) {  //获取资产信息与组件关系列表
			componentProperty.setComponentId(uuid); //设置关联组件信息
			componentPropertyMapper.insertComponentProperty(componentProperty);  //添加关联表信息
		}
		}
		return 1;

	}

	/*
	 * <p>Title: UpdateBuildingComponent</p>
	 * <p>Description: </p>
	 * @param BuildingComponent
	 * @see com.flf.service.BuildingComponentService#UpdateBuildingComponent(com.flf.entity.BuildingComponent)
	 */

	@Override
	public void UpdateBuildingComponent(BuildingComponent BuildingComponent) {
		 
		BuildingComponent.setUpdateDate(DateUtil.currentDate());
		BuildingComponent.setSortDate(DateUtil.currentDate());//设置组件排序时间
		buildingComponentMapper.updateBuildingComponent(BuildingComponent);

	}


	@Override
	public void DeleteBuildingComponentById(String BuildingComponentId) {
		int num = buildingComponentMapper.deleteBuildingComponent(BuildingComponentId);
		if(num >0){
		componentPropertyMapper.deleteComponentPropertyByBuildingComponentId(BuildingComponentId);
		}
	}
	//存放不符条件的数据
		public BuildingComponent noLoad(Map<Short, String> t){
			BuildingComponent buildingComponent=new BuildingComponent();
			buildingComponent.setComponentNum(t.get((short)0));
			buildingComponent.setComponentName(t.get((short)1));
			buildingComponent.setAreaTypeName(t.get((short)2));
			buildingComponent.setPropertyNum(t.get((short)3));
			buildingComponent.setPropertyNumber(t.get((short)4));
			buildingComponent.setPropertyArea(t.get((short)5));
			buildingComponent.setFunctionalName(t.get((short)6));
			return buildingComponent;
		}
	
	@Override
	public Info importExcelFile(Annex annex) {
/*
		Map<String, String> areaMap = new HashMap<String, String>();	//存放面积类型
		Map<String, String> functionalMap = new HashMap<String, String>();	//存放功能区间
		Map<String, String> propertyMap = new HashMap<String, String>();	//存放资产
		Map<String ,String> slaveMap=new HashMap<String ,String>();// 单位
		//获取面积类型，功能区间，资产并放入对应的map
		List<AreaTypeNew> areaTypes = areaTypeNewMapper.listAllAreaTypeNew();
		List<Functional> functionals = functionalMapper.listFunctionalAll();
		List<Property> propertys = propertyMapper.listPropertyAll();
		List<DataDictionarySlave> list = dataDictionarySlaveMapper.listSlaveByName("unit");//查询所有单位
		for(AreaTypeNew atn : areaTypes){
			areaMap.put(atn.getAreaTypeName(), atn.getId());
		}
		for(Functional functional : functionals){
			functionalMap.put(functional.getFunctionalName(), functional.getFunctionalId());
		}
		for(Property property : propertys){
			propertyMap.put(property.getPropertyNumber(), property.getPropertyId());
		}
		for(int i=0;i<list.size();i++){
			slaveMap.put(list.get(i).getDescription(), list.get(i).getSlaveId());
		}
		String number=buildingComponentMapper.selectComCode();
		if(number==null||number.equals("")){
			number="10000";			
		}else{
			number=String.valueOf(Integer.parseInt(number)+1);
		}
		
		String filePath = annex.getAnnexAddress();
		List<BuildingComponent> temp = new ArrayList<BuildingComponent>();
		BuildingComponent buildingComponent = null;
		if (Tools.notEmpty(filePath)) {
			try {
				List<Map<Short, String>> dataList = new ExcelUtils().readExcel(filePath);
				if (dataList != null && dataList.size() > 0) {
					for (Map<Short, String> t : dataList) {
						buildingComponent = new BuildingComponent();
						buildingComponent.setComponentId(t.get((short)0));
						//buildingComponent.setComponentNum(t.get((short)1));
						buildingComponent.setComponentName(t.get((short)1));
						if(areaMap.containsKey(t.get((short)2))){
							buildingComponent.setAreaTypeName(t.get((short)2));
						}else{
							continue;
						}
						//buildingComponent.setAreaTypeName(t.get((short)2));
						if(propertyMap.containsKey(t.get((short)3))){
							buildingComponent.setPropertyNum(t.get((short)3));
						}else{
							continue;
						}
						buildingComponent.setPropertyNumber(t.get((short)4));
						if(slaveMap.containsKey(t.get((short)5))){
							buildingComponent.setPropertyArea(t.get((short)5));
						}else{
						
							continue;
						}
						
						if(functionalMap.containsKey(t.get((short)6))){
							buildingComponent.setFunctionalName(t.get((short)6));
						}else{
							continue;
						}
						
						buildingComponent.setcId(t.get((short)0));
						//获取对应的单位ID
						if (buildingComponent.getPropertyArea() != null){
							for (int i = 0; i < list.size(); i++) {
								if(buildingComponent.getPropertyArea().equals(list.get(i).getDescription())){
									buildingComponent.setPropertyArea(list.get(i).getSlaveId());
									break;
									}
							}
						}
						temp.add(buildingComponent);
					}
					//将获取的集合转换为包含关联对象集合的集合
					List<BuildingComponent> bcList = new ArrayList<BuildingComponent>();
					BuildingComponent bcs = null;
					ComponentProperty cp = null;
					for(int i = 0; i < temp.size(); i ++){
						bcs = temp.get(i);
						int t = 0;
						for(BuildingComponent bctemp : bcList){
							if(bcs.getcId().equals(bctemp.getcId())){
								bcs = bctemp;
								t++;
							}
						}
						if(t == 0){
							bcs.setComponentId(UUID.randomUUID().toString());
							bcs.setComponentName(temp.get(i).getComponentName());
							bcs.setComponentNum(number);
							bcs.setComponentType(areaMap.get(temp.get(i).getAreaTypeName()));
							bcs.setCreaterDate(new Date());
							bcs.setcId(temp.get(i).getcId());
							cp = new ComponentProperty();
							cp.setComponentPropertyId(UUID.randomUUID().toString());
							cp.setComponentId(bcs.getComponentId());
							cp.setPropertyId(propertyMap.get(temp.get(i).getPropertyNum()));
							cp.setPropertyNumber(Double.parseDouble(temp.get(i).getPropertyNumber()));
							cp.setPropertyArea(temp.get(i).getPropertyArea());
							cp.setFunctionalId(functionalMap.get(temp.get(i).getFunctionalName()));
							List<ComponentProperty> cpList = new ArrayList<ComponentProperty>();
							cpList.add(cp);
							bcs.setComponentPropertys(cpList);
							bcList.add(bcs);
						}else{
							cp = new ComponentProperty();
							cp.setComponentPropertyId(UUID.randomUUID().toString());
							cp.setComponentId(bcs.getComponentId());
							cp.setPropertyId(propertyMap.get(temp.get(i).getPropertyNum()));
							cp.setPropertyNumber(Double.parseDouble(temp.get(i).getPropertyNumber()));
							cp.setPropertyArea(temp.get(i).getPropertyArea());
							cp.setFunctionalId(functionalMap.get(temp.get(i).getFunctionalName()));
							List<ComponentProperty> cpList = new ArrayList<ComponentProperty>();
							if(bcs.getComponentPropertys() != null){
								cpList = bcs.getComponentPropertys();
							}
							cpList.add(cp);
							for(BuildingComponent tempbc : bcList){
								if(tempbc.getComponentId().equals(bcs.getComponentId())){
									tempbc.setComponentPropertys(cpList);
								}
							}
						}
					}
					for(BuildingComponent addbc : bcList){
						buildingComponentMapper.insertBuildingComponentUUID(addbc);
						if(addbc.getComponentPropertys() != null){
							for (ComponentProperty componentProperty : addbc.getComponentPropertys()) {  //获取资产信息与组件关系列表
								componentPropertyMapper.insertComponentProperty(componentProperty);  //添加关联表信息
							}
						}
					}
					return Tools.msg("数据导入成功!",true);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		*/
		
		String number="";
		int addSuccess=0;
		String fileName="";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfForFile = new SimpleDateFormat("yyyyMMddHHmmss");// 用于给导入进来的excel文件命令
		String filePath = annex.getAnnexAddress();
		//定义三个，面积，功能，资产，map用key来存放id
		Map<String, String> areaMap = new HashMap<String, String>();	//存放面积类型
		Map<String, String> functionalMap = new HashMap<String, String>();	//存放功能区间
		Map<String, String> propertyMap = new HashMap<String, String>();	//存放资产
		Map<String ,String> slaveMap=new HashMap<String ,String>();// 单位
		//查出面积，功能，资产的list
		List<AreaTypeNew> areaTypes = areaTypeNewMapper.listAllAreaTypeNew();
		List<Functional> functionals = functionalMapper.listFunctionalAll();
		List<Property> propertys = propertyMapper.listPropertyAll();
		List<DataDictionarySlave> list = dataDictionarySlaveMapper.listSlaveByName("unit");//查询所有单位
		//把三个list放入map中
		for(int i=0;i<list.size();i++){
			slaveMap.put(list.get(i).getDescription(), list.get(i).getSlaveId());
		}
		for(Functional functional : functionals){
		functionalMap.put(functional.getFunctionalName(), functional.getFunctionalId());
		}
		for(Property property : propertys){
		propertyMap.put(property.getPropertyNumber(), property.getPropertyId());
		}
		for(AreaTypeNew atn : areaTypes){
		areaMap.put(atn.getAreaTypeName(), atn.getId());
		}
		//定义Map用，key存放组件对象，value存放list
		Map<String,List<BuildingComponent>> map=new HashMap<String,List<BuildingComponent>>();
		//定义list来存放不符合的数据
		List <BuildingComponent> bcsNo=new ArrayList<BuildingComponent>();
		//存放符合的数据
		List<BuildingComponent> bcsLoad=new ArrayList<BuildingComponent>();
		BuildingComponent buildingComponent = null;
		if (Tools.notEmpty(filePath)) {
			try {
				List<Map<Short, String>> dataList = new ExcelUtils().readExcel(filePath);
					if (dataList != null && dataList.size() > 0) {
						for (Map<Short, String> t : dataList) {
							
							buildingComponent = new BuildingComponent();
							if(!StringUtils.isEmpty(t.get((short)0).trim())){
								buildingComponent.setcId(t.get((short)0));//代号
							}else{
								bcsNo.add(noLoad(t));
								continue;
							}
							if(!StringUtils.isEmpty(t.get((short)1).trim())){
								
								buildingComponent.setComponentName(t.get((short)1));
								if(buildingComponentMapper.findDataByName(buildingComponent).size() != 0){
									bcsNo.add(noLoad(t));
									continue;
								}
							}else{
								bcsNo.add(noLoad(t));
								continue;
							}
							
							if(!StringUtils.isEmpty(t.get((short)2).trim())){
								if(areaMap.containsKey(t.get((short)2))){
									buildingComponent.setComponentType(areaMap.get(t.get((short)2)));
								}else{
									bcsNo.add(noLoad(t));
									continue;
									
								}
							}else{
								bcsNo.add(noLoad(t));
								continue;
							}
							if(!StringUtils.isEmpty(t.get((short)3).trim())){
								if(propertyMap.containsKey(t.get((short)3))){
									buildingComponent.setPropertyNum(propertyMap.get(t.get((short)3)));
								}else{
									bcsNo.add(noLoad(t));
									continue;
									
								}
							}else{
								buildingComponent.setPropertyNum(propertyMap.get(t.get((short)3)));
//								bcsNo.add(noLoad(t));
//								continue;
							}
							buildingComponent.setPropertyNumber(t.get((short)4).trim());
							if(!StringUtils.isEmpty(t.get((short)5).trim())){
								if(slaveMap.containsKey(t.get((short)5).trim())){
									buildingComponent.setPropertyArea(slaveMap.get(t.get((short)5)));
								}else{
									
									bcsNo.add(noLoad(t));
									continue;
								}
							}else{
								buildingComponent.setPropertyArea(slaveMap.get(t.get((short)5)));
//								bcsNo.add(noLoad(t));
//								continue;
							}
							
							if(!StringUtils.isEmpty(t.get((short)6).trim())){
								if(functionalMap.containsKey(t.get((short)6))){
									buildingComponent.setFunctionalNo(functionalMap.get(t.get((short)6)));
								}else{
									bcsNo.add(noLoad(t));
									continue;
								}
							}else{
								buildingComponent.setFunctionalNo(functionalMap.get(t.get((short)6)));
//								bcsNo.add(noLoad(t));
//								continue;
							}
						
							if(map.containsKey(t.get((short)0).trim().substring(0, 3))){
								map.get(t.get((short)0).substring(0, 3)).add(buildingComponent);
							}else{
								bcsLoad=new ArrayList<BuildingComponent>();
								bcsLoad.add(buildingComponent);
								map.put(t.get((short)0).substring(0, 3) ,bcsLoad);
							}
						}
					}
					
					 for (Map.Entry<String, List<BuildingComponent>> entry : map.entrySet()) {
						 List<BuildingComponent> bcLists=entry.getValue();
						 if(bcLists.size()>0){
							 number=buildingComponentMapper.selectComCode();
								if(number==null||number.equals("")){
									number="10000";			
								}else{
									number=String.valueOf(Integer.parseInt(number)+1);
								}
							 buildingComponent=bcLists.get(0);
							 String uuid =UUID.randomUUID().toString();  //生成主键id
							 buildingComponent.setComponentId(uuid);
							 buildingComponent.setComponentNum(number);
							 buildingComponent.setCreaterDate(DateUtil.currentDate());
							 buildingComponent.setCreateId(annex.getCompanyId());
							 
							 buildingComponentMapper.insertBuildingComponent(buildingComponent);
							 if(buildingComponent.getPropertyNumber().length()!=0){
								for(int i=0;i<bcLists.size();i++){ 
									ComponentProperty cp=new ComponentProperty();
									buildingComponent=bcLists.get(i);
									cp.setPropertyNumber(Double.valueOf(buildingComponent.getPropertyNumber()));
									cp.setPropertyId(buildingComponent.getPropertyNum());
									cp.setPropertyArea(buildingComponent.getPropertyArea());
									cp.setFunctionalId(buildingComponent.getFunctionalNo());
									cp.setComponentId(uuid);
									cp.setComponentPropertyId(UUID.randomUUID().toString());
									componentPropertyMapper.insertComponentProperty(cp);
									addSuccess++;
								}
							 }else{
								 addSuccess++; 
							 }
						 }
						  
						  }
					Excel ex=new Excel();
				    List<ExcelInfo> listInfo=new ArrayList<ExcelInfo>();
				    String[] headers = {"代号","组件名称","组件类型","资产编号","资产数量","资产单位","功能区名称"};
					String[] fields = {"componentNum","componentName","areaTypeName","propertyNum","propertyNumber","propertyArea","functionalName"};
			        if(bcsNo.size() > 0){        	
			        	ExcelInfo exl=new ExcelInfo();
						exl.setFields(fields);
						exl.setTitles(headers);
						exl.setSheetName("组件未导入记录");
						exl.setList(bcsNo);
						listInfo.add(exl);
			        }
			        InputStream is = ex.createExcelInputStream(listInfo);
			        String excelName = "组件未导入记录.xls";

			        String str = getClass().getClassLoader().getResource("").toURI().getPath();
					 fileName = sdfForFile.format(new Date()) + ".xls";
					String fileRealPath = str.substring(str.indexOf("/", 0) + 1, str.lastIndexOf("WEB-INF/"))+ fileName;
					fileRealPath = fileRealPath.replace("\\", "/");
					File f = new File(fileRealPath);
					FileOutputStream fos = new FileOutputStream(f);
					byte[] buffer = new byte[1024];
					int num1 = -1;
					while (true) {
						num1= is.read(buffer);
						if (num1 == -1) {// 是否知道了返回-1的作用了?
							break;
						}
						fos.write(buffer, 0, num1);
					}
					is.close();
					fos.close();
					
				}catch(Exception e){
					e.printStackTrace();
				}
		}
		//读取文件
		//对资产编号进行查询，是否存在否则放入list中
		//对功能区间进行查询，是否存在，否则放入list中
		//符合的数据放入list中
		return Tools.msg(addSuccess + "|" + bcsNo.size() + "|" + fileName, true);
	}
	
	@Override
	public InputStream importExcelBuildingComponent(){
		Excel ex = new Excel();
		List<ExcelInfo> list=new ArrayList<ExcelInfo>();
		String[] headers = {"代号","组件名称","组件类型","资产编号","资产数量","资产单位","功能区名称"};
		String[] fields = {"componentNum","componentName","areaTypeName","propertyNum","propertyNumber","propertyArea","functionalName"};
		BuildingComponent buildingComponent = new BuildingComponent();
		buildingComponent.setComponentNum("同一组件如有多个资产，请保持前3个数值相同");
		buildingComponent.setComponentName("请填写组件名称");
		buildingComponent.setAreaTypeName("请保持此值与单位类型中的数据一致");
		buildingComponent.setPropertyNum("请填写资产编号");
		buildingComponent.setPropertyNumber("请填写资产数量");
		buildingComponent.setPropertyArea("请填写资产单位");
		buildingComponent.setFunctionalName("请填写功能区名称，提交之前请删除此行！");
		List<BuildingComponent> dataset = new ArrayList<BuildingComponent>();
		dataset.add(buildingComponent);
		if(dataset.size() > 0){
        	ExcelInfo exl=new ExcelInfo();
			exl.setFields(fields);
			exl.setTitles(headers);
			exl.setSheetName("建筑组件导入模版");
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
	
	/**
	 * 导出组件数据到本地  王洲  2016.1.11 
	 * 调整导出 朱琪 2016.02.29
	 */
	@Override
	public InputStream createExcelBuildingComponent(BuildingComponent buildingComponent){
		//生成文件类
		Excel ex = new Excel();
		List<ExcelInfo> list=new ArrayList<ExcelInfo>();
		//反射确定列名及对应的属性名
		String[] headers = {"组件编号","组件名称","组件类型","功能区编号","功能区类型","资产编号","资产名称","资产规格","资产数量","资产单位","所属子专业编号","所属子专业名称","所属专业编号","所属专业名称"};
		String[] fields = {"componentNum","componentName","areaTypeName","functionalNo","functionalName","propertyNumber","propertyName","propertySpecification","propertyNumber","propertyArea","propertyTypeNumber","propertyTypeName","propertyTypeNumbers","propertyTypeNames"};
		//获取数据并写入excel文档
		List<BuildingComponent> dataset = buildingComponentMapper.selectDataForExport(buildingComponent);
		
		//查询所有单位
		List<DataDictionarySlave> list1 = dataDictionarySlaveMapper.listAllSlave();
		for(int x =0; x < dataset.size(); x ++){
			//根据id获取单位信息 朱琪 2016.02.24
			if (dataset.get(x).getPropertyArea() != null){
				for (int i = 0; i < list1.size(); i++) {
					if(dataset.get(x).getPropertyArea().equals(list1.get(i).getSlaveId())){
						dataset.get(x).setPropertyArea(list1.get(i).getDescription());
					}
				}
			}
		}
		
		if(dataset.size() > 0){
        	ExcelInfo exl=new ExcelInfo();
			exl.setFields(fields);
			exl.setTitles(headers);
			exl.setSheetName("建筑组件数据");
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

	
	//根据建筑结构id查询建筑组件信息
	@Override
	public List<BuildingComponent> getBuildingComponentBybuildingStructureId(String buildingStructureId) {
		
		return buildingComponentMapper.getBuildingComponentBybuildingStructureId(buildingStructureId);
	}
}