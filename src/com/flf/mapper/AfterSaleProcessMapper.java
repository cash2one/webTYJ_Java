package com.flf.mapper;

import java.util.List;

import com.flf.entity.AfterSaleProcess;

public interface AfterSaleProcessMapper {
    int deleteByPrimaryKey(String id);

    int insert(AfterSaleProcess record);

    int insertSelective(AfterSaleProcess record);

    AfterSaleProcess selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AfterSaleProcess record);

    int updateByPrimaryKey(AfterSaleProcess record);
    
    List<AfterSaleProcess> listPageAfterSaleProcess(AfterSaleProcess afterSaleProcess);//分页
    
    List<AfterSaleProcess> listAllAfterSaleProcess();//获取所有售后处理信息
    
    AfterSaleProcess getAfterSaleProcessById(String id);//根据id获取售后信息
    
    int deleteAfterSaleProcessById(String id);//根据id删除售后处理信息
    
    int insertAfterSaleProcess(AfterSaleProcess afterSaleProcess);//插入售后处理信息
    
    int insertAfterSaleProcessSelective(AfterSaleProcess afterSaleProcess);//有选择性的插入售后处理信息
    
    int updateAfterSaleProcess(AfterSaleProcess afterSaleProcess);//更新售后处理信息
    
    int updateAfterSaleProcessSelective(AfterSaleProcess afterSaleProcess);//有选择性的更新售后处理信息
}