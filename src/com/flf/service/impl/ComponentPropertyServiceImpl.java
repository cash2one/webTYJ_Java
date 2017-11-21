/**
 * @Title: ComponentPropertyServiceImpl.java
 * @Package com.flf.service.impl
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-6-23 下午5:00:47
 * @version V1.0
 */

package com.flf.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.flf.entity.BuildingComponent;
import com.flf.entity.ComponentProperty;
import com.flf.entity.DataDictionarySlave;
import com.flf.entity.Functional;
import com.flf.entity.PageRestful;
import com.flf.entity.Property;
import com.flf.entity.PropertyType;
import com.flf.mapper.ComponentPropertyMapper;
import com.flf.mapper.DataDictionarySlaveMapper;
import com.flf.mapper.FunctionalMapper;
import com.flf.mapper.PropertyMapper;
import com.flf.mapper.PropertyTypeMapper;
import com.flf.service.ComponentPropertyService;
import com.flf.service.DataDictionaryService;

/**
 * @ClassName: ComponentPropertyServiceImpl
 * @Description: TODO
 * @author wangyong
 * @date 2015-6-23 下午5:00:47
 * @author zhuwei
 * @date 2015-7-1
 */

/**
 * @author zhuqi
 *
 */
public class ComponentPropertyServiceImpl implements ComponentPropertyService {

	private ComponentPropertyMapper componentPropertyMapper;
	
	private FunctionalMapper functionalMapper;
	
	private PropertyMapper propertyMapper;
	
	private PropertyTypeMapper propertyTypeMapper;
	
	private DataDictionarySlaveMapper dataDictionarySlaveMapper;
	
	/*
	 * <p>Title: listPageComponentProperty</p>
	 * <p>Description: </p>
	 * @param ComponentProperty
	 * @return
	 * @see com.flf.service.ComponentPropertyService#listPageComponentProperty(com.flf.entity.ComponentProperty)
	 */

	public ComponentPropertyMapper getComponentPropertyMapper() {
		return componentPropertyMapper;
	}

	public void setComponentPropertyMapper(
			ComponentPropertyMapper componentPropertyMapper) {
		this.componentPropertyMapper = componentPropertyMapper;
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

	public PropertyTypeMapper getPropertyTypeMapper() {
		return propertyTypeMapper;
	}

	public void setPropertyTypeMapper(PropertyTypeMapper propertyTypeMapper) {
		this.propertyTypeMapper = propertyTypeMapper;
	}
	
	public DataDictionarySlaveMapper getDataDictionarySlaveMapper() {
		return dataDictionarySlaveMapper;
	}

	public void setDataDictionarySlaveMapper(DataDictionarySlaveMapper dataDictionarySlaveMapper) {
		this.dataDictionarySlaveMapper = dataDictionarySlaveMapper;
	}

	@Override
	public PageRestful listPageComponentProperty(
			ComponentProperty ComponentProperty) {
		// TODO Auto-generated method stub
		PageRestful pagerestful=new PageRestful();
		List<ComponentProperty> componentPropertys =componentPropertyMapper.ListPageComponentProperty(ComponentProperty);	
		componentPropertys.add(0,null);
		pagerestful.setComponentPropertys(componentPropertys);
		pagerestful.setPage(ComponentProperty.getPage());
		return pagerestful;
	}

	/*
	 * <p>Title: listComponentPropertyAll</p>
	 * <p>Description: </p>
	 * @return
	 * @see com.flf.service.ComponentPropertyService#listComponentPropertyAll()
	 */

	@Override
	public List<ComponentProperty> listComponentPropertyAll() {
		// TODO Auto-generated method stub
		return componentPropertyMapper.ListComponentPropertyAll();
	}

	/*
	 * <p>Title: getComponentPropertyByIdRest</p>
	 * <p>Description: </p>
	 * @param ComponentPropertyId
	 * @return
	 * @see com.flf.service.ComponentPropertyService#getComponentPropertyByIdRest(java.lang.String)
	 */

	@Override
	public ComponentProperty getComponentPropertyByIdRest(
			String ComponentPropertyId) {
		// TODO Auto-generated method stub
		return componentPropertyMapper.selectComponentPropertyById(ComponentPropertyId);
	}

	/*
	 * <p>Title: AddComponentProperty</p>
	 * <p>Description: </p>
	 * @param ComponentProperty
	 * @see com.flf.service.ComponentPropertyService#AddComponentProperty(com.flf.entity.ComponentProperty)
	 */

	@Override
	public void AddComponentProperty(ComponentProperty ComponentProperty) {
		// TODO Auto-generated method stub
		componentPropertyMapper.insertComponentProperty(ComponentProperty);
	}

	/*
	 * <p>Title: UpdateComponentProperty</p>
	 * <p>Description: </p>
	 * @param ComponentProperty
	 * @see com.flf.service.ComponentPropertyService#UpdateComponentProperty(com.flf.entity.ComponentProperty)
	 */

	@Override
	public void UpdateComponentProperty(ComponentProperty ComponentProperty) {
		// TODO Auto-generated method stub
		componentPropertyMapper.updateComponentProperty(ComponentProperty);
	}

	/*
	 * <p>Title: DeleteComponentPropertyById</p>
	 * <p>Description: </p>
	 * @param ComponentPropertyId
	 * @see com.flf.service.ComponentPropertyService#DeleteComponentPropertyById(java.lang.String)
	 */

	@Override
	public void DeleteComponentPropertyById(String ComponentPropertyId) {
		// TODO Auto-generated method stub
		componentPropertyMapper.deleteComponentProperty(ComponentPropertyId);
	}

	@Override
	public void DeleteComponentPropertyByBuildingComponentId(
			String componentId) {
		componentPropertyMapper.deleteComponentPropertyByBuildingComponentId(componentId);
		
	}

	@Override
	public List<ComponentProperty> getComponentPropertyByComponentIdRest(
			String componentId) {
		//获取组件关联的功能区、资产
		List<ComponentProperty> cpList = componentPropertyMapper.getComponentPropertyByComponentIdRest(componentId);
		//查询所有单位
		List<DataDictionarySlave> list = dataDictionarySlaveMapper.listAllSlave();
		for(int x =0; x < cpList.size(); x ++){
	//		cpList.get(x).getProperty().setArea(cpList.get(x).getPropertyArea());			cpList.get(x).getProperty().setNum(cpList.get(x).getPropertyNumber());
			//根据id获取单位信息 朱琪 2016.02.24
			for (int i = 0; i < list.size(); i++) {
				if (cpList.get(x).getPropertyArea() != null){
					if(cpList.get(x).getPropertyArea().equals(list.get(i).getSlaveId())){
						cpList.get(x).getProperty().setArea(list.get(i).getDescription());
					}
				}
			}
		}
		//获取所有专业及专业分类
		List<PropertyType> ptList = propertyTypeMapper.listPropertyType();
		List<PropertyType> temp = new ArrayList<PropertyType>();
		//获取组件关联资产的专业分类
		for(int i = 0; i < cpList.size(); i ++){
			if(null != cpList.get(i).getProperty()){
				for(int i1 = 0; i1 < ptList.size(); i1 ++){
					if(cpList.get(i).getProperty().getPropertyTypeId().toString().equals(ptList.get(i1).getPropertyTypeId().toString())){
						temp.add(ptList.get(i1));
					}
				}
			}
		}
		//生成组件关联资产的专业集合
		List<PropertyType> temps = new ArrayList<PropertyType>();
		for(int j = 0; j < ptList.size(); j ++){
			if(null == ptList.get(j).getParentId()){
				for(int j1 = 0; j1< temp.size(); j1 ++){
					if(ptList.get(j).getPropertyTypeId().toString().equals(temp.get(j1).getParentId().toString())){
						if(temps.size() == 0){
							temps.add(ptList.get(j));
						}else{
							int num = 0;
							for(int j2 = 0; j2 < temps.size(); j2 ++){
								if(!temps.get(j2).getPropertyTypeId().toString().equals(ptList.get(j).getPropertyTypeId().toString())){
									num++;
								}
							}
							if(num == temps.size()){
								temps.add(ptList.get(j));
							}
						}
					}
				}
			}
		}
		//生成关联资产的专业及分类层级结构
		for(int k = 0; k < temps.size(); k ++){
			List<PropertyType> temps1 = new ArrayList<PropertyType>();
			for(int k1 = 0; k1 < temp.size(); k1 ++){
				if(temps.get(k).getPropertyTypeId().toString().equals(temp.get(k1).getParentId().toString())){
					if(temps1.size() == 0){
						temps1.add(temp.get(k1));
					}else{
						for(int k2 = 0; k2 < temps1.size(); k2 ++){
							if(!temp.get(k1).getPropertyTypeId().toString().equals(temps1.get(k2).getPropertyTypeId().toString())){
								temps1.add(temp.get(k1));
							}
						}
					}
				}
			}
			temps.get(k).setPropertyTypes(temps1);
		}
		//将资产绑定到对应专业分类下，并合并关联
		//1、循环专业
		for(int l = 0; l < temps.size(); l ++){
		//2、循环专业分类
			for(int l1 = 0; l1 < temps.get(l).getPropertyTypes().size(); l1 ++){
		//3、循环资产，关联到对应的分类
				List<Property> ptemp = new ArrayList<Property>();
				for(int l2 = 0; l2 < cpList.size(); l2 ++){
					if(cpList.get(l2).getProperty().getPropertyTypeId().toString().equals(temps.get(l).getPropertyTypes().get(l1).getPropertyTypeId().toString())){
						ptemp.add(cpList.get(l2).getProperty());
					}
				}
				temps.get(l).getPropertyTypes().get(l1).setPropertys(ptemp);
			}
		}
		//将功能区及专业、分类、资产进行绑定
		//1、创建用于返回的ComponentProperty类型集合
		List<ComponentProperty> requestCPList = new ArrayList<ComponentProperty>();
		//2、将功能区放入集合
		for(int m = 0; m < cpList.size(); m ++){
			ComponentProperty cp = new ComponentProperty();
			cp.setFunctionals(cpList.get(m).getFunctionals());
			int nums = 0;
			for(int m1 = 0; m1 < requestCPList.size(); m1 ++){
				if(!cpList.get(m).getFunctionals().getFunctionalId().toString().equals(requestCPList.get(m1).getFunctionals().getFunctionalId().toString())){
					nums++;
				}
			}
			if(nums == requestCPList.size()){
				requestCPList.add(cp);
			}
		}
		//3、将专业资产等于功能区绑定
		String pid;
		List<PropertyType> pttemp;
		String funcId;
		for(int n = 0; n < requestCPList.size(); n ++){
			funcId = requestCPList.get(n).getFunctionals().getFunctionalId().toString();
			String fid = null;
			int fnum = 0;
			pttemp = new ArrayList<PropertyType>();
			for (PropertyType propertyType1 : temps) {
				for (PropertyType propertyType2 : propertyType1.getPropertyTypes()) {
					for (Property property : propertyType2.getPropertys()) {
						pid=property.getPropertyId().toString();
						fnum = 0;
						for (ComponentProperty componentProperty : cpList) {
							if(pid.equals(componentProperty.getPropertyId().toString())){
								fid = componentProperty.getFunctionalId().toString();
								if(fid.equals(funcId)){
									fnum++;									
								}
							}
						}
					}
				}
				if(fnum != 0){
					pttemp.add(propertyType1);
				}
			}
//			for(int n1 = 0; n1 < temps.size(); n1 ++){	//循环专业
//				for(int n2 = 0; n2 < temps.get(n1).getPropertyTypes().size(); n2 ++){	//循环专业分类
//					for(int n3 = 0; n3 < temps.get(n1).getPropertyTypes().get(n2).getPropertys().size(); n3 ++){	//循环资产
//						String pid = temps.get(n1).getPropertyTypes().get(n2).getPropertys().get(n3).getPropertyId().toString();
//						fnum = 0;
//						for(int n4 = 0; n4 < cpList.size(); n4 ++){
//							if(pid.equals(cpList.get(n4).getPropertyId().toString())){
//								fid = cpList.get(n4).getFunctionalId().toString();
//								if(fid.equals(funcId)){
//									fnum++;									
//								}
//							}
//						}
//					}
//				}
//				if(fnum != 0){
//					pttemp.add(temps.get(n1));
//				}
//			}
			requestCPList.get(n).setPropertytype(pttemp);
		}
		for (ComponentProperty componentProperty : requestCPList) {
			if(componentProperty.getPropertytype().size()==1){
				componentProperty.getPropertytype().add(0,null);
			}
			for (PropertyType propertyType : componentProperty.getPropertytype()) {
				if(propertyType!=null){
					if(propertyType.getPropertyTypes().size()==1){
						propertyType.getPropertyTypes().add(0,null);
					}
					for (PropertyType propertyType1 : propertyType.getPropertyTypes()) {
						if(propertyType1!=null){
							if(propertyType1.getPropertys().size()==1){
								propertyType1.getPropertys().add(0,null);
							}
						}
					}
				}
				
			}
		}
//		for(int y = 0; y < requestCPList.size(); y ++){
//			for(int y1 = 0; y1 < requestCPList.get(y).getPropertytype().size(); y1++){
//				for(int y2 = 0; y2 < requestCPList.get(y).getPropertytype().get(y1).getPropertyTypes().size(); y2++){
//					for(int y3 = 0; y3 < requestCPList.get(y).getPropertytype().get(y1).getPropertyTypes().get(y2).getPropertys().size(); y3++){
//						if(requestCPList.get(y).getPropertytype().get(y1).getPropertyTypes().get(y2).getPropertys().size() < 2){}
//					}
//				}
//			}
//		}
		System.out.println(temp);
		System.out.println(temps);
		System.out.println(requestCPList);
		
		return requestCPList;
	}

	/**
	 * 根据建筑结构查询资产信息
	 */
	@Override
	public List<ComponentProperty> getPropertyByIdRes(String buildingStructureId) {
		// TODO Auto-generated method stub
		return componentPropertyMapper.getComponentPropertyByBSId(buildingStructureId);
	}
	public List<ComponentProperty> selectComponentAndProperty(String componentId){
		return componentPropertyMapper.selectComponentAndProperty(componentId);
	}
	
	public List<ComponentProperty>selectComProById(String componentPropertyId){
		return componentPropertyMapper.selectComProById(componentPropertyId);
	}
	public void  updateComponentPropertyById(ComponentProperty ComponentProperty){
		componentPropertyMapper.updateComponentPropertyById(ComponentProperty);
	}



}
