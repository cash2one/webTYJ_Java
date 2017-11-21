package com.flf.mapper;

import java.util.List;

import com.flf.entity.ArchitectureNew;





public interface ArchitectureNewMapper {
	
	List<ArchitectureNew> listPageArchitectureNew(ArchitectureNew architectureNew); //分页显示公建信息
	
	List<ArchitectureNew> listArchitectureNew(); //查询所有公建信息
	
	ArchitectureNew selectArchitectureNewById(String id); //根据id查询公建信息
	
    int insertArchitectureNew(ArchitectureNew architectureNew); //添加公建信息
      
    int updateArchitectureNew(ArchitectureNew architectureNew); //修改公建信息

    int deleteArchitectureNewById(String id);//删除公建信息
    
    ArchitectureNew listArchitectureByBuildingStructureId(String buildingStructureId) ; ////根据建筑结构id查询公建信息集合
   
}