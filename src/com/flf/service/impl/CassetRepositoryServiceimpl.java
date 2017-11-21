package com.flf.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import com.flf.entity.BuildingComponent;
import com.flf.entity.BuildingStructureNew;
import com.flf.entity.CassetRepository;
import com.flf.entity.ComponentProperty;
import com.flf.entity.ComponentStructure;
import com.flf.entity.Functional;
import com.flf.entity.PageRestful;
import com.flf.entity.PersonBuildingNew;
import com.flf.entity.Property;
import com.flf.entity.PropertyType;
import com.flf.mapper.BuildingStructureNewMapper;
import com.flf.mapper.CassetRepositoryMapper;
import com.flf.mapper.ComponentStructureMapper;
import com.flf.mapper.PropertyMapper;
import com.flf.request.CassetRepositoryReault;
import com.flf.request.CassetRepositoryRequest;
import com.flf.request.PropertyResult;
import com.flf.request.Info;
import com.flf.service.CassetRepositoryService;
import com.flf.util.JsonUtil;

public class CassetRepositoryServiceimpl implements CassetRepositoryService {

	private Logger log = Logger.getLogger(CassetRepositoryServiceimpl.class);
	
	private CassetRepositoryMapper cassetRepositoryMapper;
	
	private PropertyMapper propertyMapper;
	
	private BuildingStructureNewMapper buildingStructureNewMapper;
	private ComponentStructureMapper componentStructureMapper;
	
	
	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

	public ComponentStructureMapper getComponentStructureMapper() {
		return componentStructureMapper;
	}

	public void setComponentStructureMapper(
			ComponentStructureMapper componentStructureMapper) {
		this.componentStructureMapper = componentStructureMapper;
	}

	public PropertyMapper getPropertyMapper() {
		return propertyMapper;
	}

	public void setPropertyMapper(PropertyMapper propertyMapper) {
		this.propertyMapper = propertyMapper;
	}

	public CassetRepositoryMapper getCassetRepositoryMapper() {
		return cassetRepositoryMapper;
	}

	public void setCassetRepositoryMapper(
			CassetRepositoryMapper cassetRepositoryMapper) {
		this.cassetRepositoryMapper = cassetRepositoryMapper;
	}
	
	public BuildingStructureNewMapper getBuildingStructureNewMapper() {
		return buildingStructureNewMapper;
	}

	public void setBuildingStructureNewMapper(
			BuildingStructureNewMapper buildingStructureNewMapper) {
		this.buildingStructureNewMapper = buildingStructureNewMapper;
	}

	@Override
	public PageRestful listPageCassetRepository(
			CassetRepository CassetRepository) {
		// TODO Auto-generated method stub
		PageRestful pagerestful=new PageRestful();
		List<CassetRepository> cassetRepositorys =cassetRepositoryMapper.ListPageCassetRepository(CassetRepository);	
		cassetRepositorys.add(0,null);
		pagerestful.setCassetRepositorys(cassetRepositorys);
		pagerestful.setPage(CassetRepository.getPage());
		return pagerestful;
	}

	@Override
	public List<CassetRepository> listCassetRepositoryAll() {
		// TODO Auto-generated method stub
		return cassetRepositoryMapper.ListCassetRepositoryAll();
	}

	@Override
	public CassetRepository getCassetRepositoryByIdRest(
			String CassetRepositoryId) {
		// TODO Auto-generated method stub
		return cassetRepositoryMapper.selectCassetRepositoryById(CassetRepositoryId);
	}

	@Override
	public void AddCassetRepository(CassetRepository CassetRepository) {
		// TODO Auto-generated method stub
		for (String bs : CassetRepository.getBuildingStructureIds()) {
							
			CassetRepository cassetRepository=new CassetRepository();
			cassetRepository.setBuildingStructureId(bs);

			cassetRepositoryMapper.insertCassetRepository(CassetRepository);
		}
		
	}

	@Override
	public void UpdateCassetRepository(CassetRepository CassetRepository) {
		// TODO Auto-generated method stub
		cassetRepositoryMapper.updateCassetRepository(CassetRepository);
	}

	@Override
	public void DeleteCassetRepositoryById(String CassetRepositoryId) {
		// TODO Auto-generated method stub
		cassetRepositoryMapper.deleteCassetRepository(CassetRepositoryId);

	}

	@Override
	public void AddCassetRepositoryList(BuildingComponent buildingComponent) {
		// TODO Auto-generated method stub
		for (BuildingStructureNew bs : buildingComponent.getBuildingStructureNews()) {
			
			for (ComponentProperty cp  :  buildingComponent.getComponentPropertys()) {
				CassetRepository cr=new CassetRepository();
				cr.setBuildingComponentId(buildingComponent.getComponentId()); //设置主键id
				cr.setBuildingStructureId(bs.getBuildingId()); //设置建筑结构id
				cr.setFunctionalId(cp.getFunctionalId());  //设置功能区id
			}
		}
		
	}

	public List<CassetRepository> listCassetRepositoryAllBybuildingStructureId(
			String buildingStructures) {
		// TODO Auto-generated method stub
		PropertyResult propertyResult=new PropertyResult();
		 
	    String[] buils=buildingStructures.split(",");
	    System.out.println(buils.length);
		List<String> list=new ArrayList<String>();
		for (int i = 0; i < buils.length; i++) {
			list.add(buils[i]);  //添加入集合
		}
		propertyResult.setBuildingStructureNews(list);
		System.out.println(propertyResult);
		return cassetRepositoryMapper.listCassetRepositoryAllBybuildingStructureId(propertyResult);
	}


	public Info bindingCassetRepository(CassetRepository cassetRepository) {
		Info info=new Info();
		List<String> crStringList = new ArrayList<String>();
		Map<String,String> bsnMap = new HashMap<String,String>();
		
		//根据项目id获取该项目建筑结构
		if(cassetRepository.getProjectId() != null){
		List<BuildingStructureNew> bsnList = buildingStructureNewMapper.listAllBuildingStructureNew(cassetRepository.getProjectId());
		 if(bsnList != null && bsnList.size() > 0){
			 for(BuildingStructureNew bsn : bsnList){
				 bsnMap.put(bsn.getId(), bsn.getAreaId()==null?null:bsn.getAreaId());
			 }
		 }
		}
		//获取已经添加过的资产库
		List<CassetRepository> crList = cassetRepositoryMapper.ListCassetRepositoryAll();
		if(crList != null && crList.size() > 0){
		for(CassetRepository cr:crList){
			crStringList.add(cr.getBuildingStructureId());
		}
		}
		//获取组件对象
		BuildingComponent bc = cassetRepository.getBuildingComponent();
		//获取组件资产列表
		List<ComponentProperty> cpsList = cassetRepository.getComponentPropertys();
		//获取建筑结构id字符串
		String bsString = cassetRepository.getBuildingStructureString();
		//分割建筑结构id
		String[] bss = bsString.split(",");
		if(bc != null){
		for(int i=0;i<bss.length;i++){
			if(!crStringList.contains(bss[i])){
			if(bsnMap.get(bss[i])!= null){
			if(cpsList != null && cpsList.size() > 0)
			{
			for(ComponentProperty cp : cpsList){
			
				Functional Ft= cp.getFunctionals();
				List<PropertyType> listPt = cp.getPropertytype();
				if(listPt!=null && listPt.size()>0){
					for(int j=1;j<listPt.size();j++){
						PropertyType pt1 =listPt.get(j);
						List<PropertyType> listPt2 = pt1.getPropertyTypes();
						if(listPt2!=null && listPt2.size()>0){
							for(int g=1;g<listPt2.size();g++){
								PropertyType pt2 =listPt2.get(g);
								List<Property> proerty = pt2.getPropertys();
								if(proerty!=null && proerty.size()>0){
									for(Property property:proerty){
										if(property != null){
											cassetRepository.setPropertyId(property.getPropertyId());
											cassetRepository.setPropertyName(property.getPropertyName());
											cassetRepository.setPropertyNumber(property.getPropertyNumber());
											cassetRepository.setPropertySpecification(property.getPropertySpecification());
											cassetRepository.setPropertyTypeId(property.getPropertyId());
											cassetRepository.setProducingArea(property.getProducingArea());
											cassetRepository.setExpirationDate(property.getExpirationDate());
											cassetRepository.setBrand(property.getBrand());
											cassetRepository.setManufacturer(property.getManufacturer());
											cassetRepository.setManufacturerPhone(property.getManufacturerPhone());
											cassetRepository.setFunctionalId(Ft.getFunctionalId());
											cassetRepository.setFunctionalName(Ft.getFunctionalName());
											cassetRepository.setPropertyCount(property.getNum());
											cassetRepository.setPropertyArea(property.getArea());
											cassetRepository.setBuildingStructureId(bss[i]);
											cassetRepository.setBuildingComponentId(bc.getComponentId());
											//数据存储数据库
											try {
												ComponentStructure cst=new ComponentStructure();
												cst.setBuildingStructureId(bss[i]);
												cst.setComponentPropertyId(bc.getComponentId());
												componentStructureMapper.insertComponentStructure(cst);
												cassetRepositoryMapper.insertCassetRepository(cassetRepository);
												info.setState("success");
											} catch (Exception e) {
												log.error("建筑组件绑定资产库异常",e);
												info.setState("failure");
											}
											
											}
									}
								}
								
							}
						}
					}
				}
				
				/*Property property = null;
				property = propertyMapper.selectByPrimaryKey(cp.getPropertyId());*/
	
			}
			}
			}
			}else{
				System.out.println("已经绑定");
			}
		}
		}
		
		
		return info;
	}

	@Override
	public void ListCassetRepositoryList(
			CassetRepositoryRequest CassetRepositoryRequest) {
		// TODO Auto-generated method stub

		if (CassetRepositoryRequest.getCassetRepositorys().size()>0) {
			for (CassetRepository cassetRepository : CassetRepositoryRequest.getCassetRepositorys()) {
				cassetRepositoryMapper.updateCassetRepository(cassetRepository);
			}
			
		}
		
		
	}

	@Override
	public List<CassetRepository> getCassetRepositorybyCondition(
			CassetRepository cassetRepository) {
		return cassetRepositoryMapper.getCassetRepositorybyCondition(cassetRepository);
	}

	@Override
	public PageRestful listPageSpecialAndClassifyRes(
			CassetRepository cassetRepository) {
		// TODO Auto-generated method stub
		PageRestful pagerestful=new PageRestful();
		List<CassetRepositoryReault> cassetRepositorys =cassetRepositoryMapper.listPageSpecialAndClassify(cassetRepository);	
		cassetRepositorys.add(0,null);
		pagerestful.setCassetRepositoryReault(cassetRepositorys);
		pagerestful.setPage(cassetRepository.getPage());
		return pagerestful;
	}

	@Override
	public CassetRepository getCassetRepositoryDatils(String id) {
		// TODO Auto-generated method stub
		return cassetRepositoryMapper.getCassetRepositoryDatils(id);
	}

	
}
