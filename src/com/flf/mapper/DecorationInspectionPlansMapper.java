package com.flf.mapper;

import java.util.List;

import com.flf.entity.DecorationInspectionPlans;

public interface DecorationInspectionPlansMapper {
    int deleteByPrimaryKey(String decorationInspectionPlanId);

    int insert(DecorationInspectionPlans record);

    int insertSelective(DecorationInspectionPlans record);

    DecorationInspectionPlans selectByPrimaryKey(String decorationInspectionPlanId);
    //修改
    int updateByPrimaryKeySelective(DecorationInspectionPlans record);

    int updateByPrimaryKey(DecorationInspectionPlans record);
    
    DecorationInspectionPlans getDecorationInspectionPlansbyId(String decorationInspectionPlanId);//通过方案Id查询方案信息
      //分页查询方案列表
    List<DecorationInspectionPlans> listPageDecorationInspectionPlans(DecorationInspectionPlans decorationInspectionPlans);
     //新建方案
    int AddDecorationInspectionPlans(DecorationInspectionPlans decorationInspectionPlans);
    int AddDecorationInspectionPlansUUID(DecorationInspectionPlans decorationInspectionPlans);
    //有效巡检
   List<DecorationInspectionPlans>getDecorationInspectionPlans();
   
    
}