package com.flf.mapper;


import com.flf.entity.AreaNew;

import java.util.List;

import javax.ws.rs.PathParam;


public interface AreaNewMapper {

	List<AreaNew> listPageAreaNew(AreaNew area);
	
	List<AreaNew> listAllAreaNew();
	
	AreaNew getAreaNewById(String id);
	
    int insertAreaNew(AreaNew area);
    
    int updateAreaNew(AreaNew area);

    int deleteAreaNew(String id);
    
    List<AreaNew> listAllAreaNewByBuildingId(String buildingId); //根据建筑id查询建筑属性信息
    
    int insertList(List<AreaNew> list);//批量插入面积信息
}