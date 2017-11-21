package com.flf.mapper;

import java.util.List;

import com.flf.entity.AreaDivision;
import com.flf.entity.ServiceProject;

public interface ServiceProjectMapper {
	
	//通过ID删除
	 int deleteByProductId(String productId);
        //新增
    int insert(ServiceProject record);
       //修改
    int updateServiceProject(ServiceProject record);
    /**
     * 根据产品id查询关联的面积划分表数据
     * @param productId
     * @return list
     */
    List<ServiceProject> listServiceProjectByProductId(String productId);
    
    
    
}