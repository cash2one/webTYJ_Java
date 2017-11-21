package com.flf.mapper;


import java.util.List;

import com.flf.entity.CompensateObject;
/**
 * 赔偿对象表
 * 创建人：邵政
 * 创建时间：2015/6/25
 */
public interface CompensateObjectMapper {
	int deleteCompensateObject(String recordId);//删除赔偿对象信息

	int insertCompensateObject(CompensateObject compensateObject);//添加赔偿对象信息

    List<CompensateObject> listPageCompensateObject(CompensateObject compensateObject);//分页查询赔偿对象信息
    
    List<CompensateObject> listAllCompensateObject();//查询所有赔偿对象信息

    CompensateObject getCompensateObjectbyId(String recordId);//通过Id查询赔偿对象信息

    int updateCompensateObject(CompensateObject compensateObject);//修改赔偿对象信息

    
}