package com.flf.mapper;

import java.util.List;

import com.flf.entity.ComponentStructure;



public interface ComponentStructureMapper {
	
	List<ComponentStructure> ListPageComponentStructure(ComponentStructure componentStructure);//分页查询建筑组件与建筑结构
	
	List<ComponentStructure> ListComponentStructureAll();//查询所有建筑组件与建筑结构信息
	
	ComponentStructure selectComponentStructureById(String componentStructureId);//根据id查询建筑组件与建筑结构信息
	
    int insertComponentStructure(ComponentStructure componentStructure); //添加建筑组件与建筑结构信息
    
    int updateComponentStructure(ComponentStructure componentStructure);//修改建筑组件与建筑结构信息

    int deleteComponentStructure(String componentStructureId);//删除建筑组件与建筑结构信息
    
    List<ComponentStructure> getComponentStructurebyBuildingStructureId(String buildingStructureId);//根据建筑结构id查询组件与建筑结构信息
}