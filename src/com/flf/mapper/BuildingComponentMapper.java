package com.flf.mapper;

import java.util.List;

import com.flf.entity.BuildingComponent;



public interface BuildingComponentMapper {
  
	List<BuildingComponent> listPageBuildingComponentAll(BuildingComponent buildingComponent);//分页查询建筑组件
	
	List<BuildingComponent> ListselectBuildingComponentAll();//查询所有建筑组件
	
	BuildingComponent selectBuildingComponentById(String id);//根据id查询建筑组件信息
	
    int insertBuildingComponent(BuildingComponent buildingComponent); //添加建筑组件信息
    
    int insertBuildingComponentUUID(BuildingComponent buildingComponent); //添加建筑组件信息主键手动添加
    
    List<BuildingComponent> findDataByName(BuildingComponent buildingComponent); //根据条件查询
    
    int updateBuildingComponent(BuildingComponent buildingComponent);//修改建筑组件信息

    int deleteBuildingComponent(String id);//删除建筑组件信息
    
    List<BuildingComponent> selectDataForExport(BuildingComponent buildingComponent);//查询建筑组件及关联信息用于导出  王洲  2016.1.11
    
    String selectComCode();
    List<BuildingComponent> getBuildingComponentBybuildingStructureId(String buildingStructureId);//根据建筑id查询建筑组件信息
}