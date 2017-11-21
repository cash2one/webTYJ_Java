package com.flf.mapper;

import java.util.List;
import java.util.Map;

import com.flf.entity.AfterSale;
import com.flf.entity.AfterSaleQuery;
import com.flf.entity.Project;
import com.flf.entity.PropertyType;


public interface AfterSaleMapper {
    List<AfterSale> listAllAfterSale();
    
    //售后管理列表展示及条件查询
    List<AfterSale> listPageAfterSale(AfterSaleQuery afterSaleQuery);
    //售后管理列表展示及条件查询(使用propertyTypeName查询)
    AfterSale listPageAfterSaleSingle(AfterSaleQuery afterSaleQuery);
    
    
    //售后管理列表页面查询所有项目名放入下拉框
    List<Project> listProjectName();
    
    //售后管理列表页面从资产类型表查询专业查询
    List<PropertyType> listPropertyType();
    
    //根据传入的id修改对应记录标修字段的值
    int updateGuaranteeById(String id);
    
    AfterSale getAfterSaleById(String id);
    int deleteAfterSale(String id);
    int insertAfterSale(AfterSale afterSale);
    int updateAfterSale(AfterSale afterSale);
    //根据processId改变售后管理信息的状态
    int updateAfterSaleProcessStateByProcessId(AfterSale afterSale);
    
    int updateAfterSaleRelationIdById(AfterSale afterSale);
    
    List<AfterSale> listPageAfterSaleByProcessId(AfterSale afterSale);
    
    //根据projectId获取售后管理信息
    List<AfterSale> getAfterSaleInfoByProjectId(String projectId);
}