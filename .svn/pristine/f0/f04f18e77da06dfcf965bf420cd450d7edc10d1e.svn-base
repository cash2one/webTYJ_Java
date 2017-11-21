package com.flf.mapper;

import java.util.List;

import com.flf.entity.RegionNew;

public interface RegionNewMapper {
	List<RegionNew> listPageRegionNew(RegionNew region);//分页查询所有区域信息
	
	List<RegionNew> listAllRegionNew();//查询所有区域信息
	
	RegionNew getRegionNewById(String id);//根据区域id查询区域信息
	
    int insertRegionNew(RegionNew region);//添加区域信息
    
    int updateRegionNew(RegionNew region);  //修改区域信息

    int deleteRegionNew(String id);  //删除区域信息
    
    
    List<RegionNew> getRegionNewprojectIdRest(String projectId); //根据项目id查询区域信息
    
    RegionNew getRegionNewByStallNewId(String stallId);//更据车位id查询区信息
    
    RegionNew getRegionNewByHouseId(String houseId);//根据房屋id查询区信息
    
}