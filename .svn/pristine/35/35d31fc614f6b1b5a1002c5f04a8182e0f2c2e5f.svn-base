package com.flf.mapper;

import java.util.List;

import com.flf.entity.AreaTypeNew;

/**
 * 面积名称mapper
 * @author niming
 *
 */
public interface AreaTypeNewMapper {
	List<AreaTypeNew> listPageAreaTypeNew(AreaTypeNew areaType);   //分页查询面积管理列表
	
	List<AreaTypeNew> listAllAreaTypeNew();   //获取所有面积管理列表
	
	AreaTypeNew getAreaTypeNewById(String id);  //根据id查询面积管理
	
    int insertAreaTypeNew(AreaTypeNew areaType);   //新增一条面积管理
    
    int updateAreaTypeNew(AreaTypeNew areaType);  //修改一条面积管理

    int deleteAreaTypeNew(String id);  //删除一条面积管理
    
    AreaTypeNew getAreaTypeNewByareaTypeId(String areaTypeId);  
    
    int getAreaTypeNewAreaName(String areaTypeName);  //根据面积名称查看面积名称是否重复
}