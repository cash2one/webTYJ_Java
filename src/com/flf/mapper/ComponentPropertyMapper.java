package com.flf.mapper;

import java.util.List;

import com.flf.entity.ComponentProperty;





public interface ComponentPropertyMapper {
	
	List<ComponentProperty> ListPageComponentProperty(ComponentProperty componentProperty);//分页查询建筑组件与资产关系
	
	List<ComponentProperty> ListComponentPropertyAll();//查询所有建筑组件与资产关系
	
	ComponentProperty selectComponentPropertyById(String id);//根据id查询建筑组件与资产关系信息
	
    int insertComponentProperty(ComponentProperty componentProperty); //添加建筑组件与资产关系信息
    
    int updateComponentProperty(ComponentProperty componentProperty);//修改建筑组件与资产关系信息

    int deleteComponentProperty(String id);//删除建筑组件与资产关系信息
    
    int deleteComponentPropertyByBuildingComponentId(String componentId);//根据组件id删除组件与资产关系信息
    
    List<ComponentProperty> getComponentPropertyByComponentIdRest(String componentId);
    
    List<ComponentProperty> getPropertyById(String buildingStructureId);    //根据建筑结构查询资产信息 
    
    List<ComponentProperty> getComponentPropertyByBSId(String buildingStructureId);//获取建筑结构信息
    
    List<ComponentProperty> selectComponentAndProperty(String id);//根据组件id联查功能，组件信息
    
    List<ComponentProperty>selectComProById(String componentPropertyId);//根据id查询组件和资产关系
    
    void  updateComponentPropertyById(ComponentProperty ComponentProperty);//根据id修改资产和组价关系
    
}