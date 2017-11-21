package com.flf.mapper;

import java.util.List;

import com.flf.entity.InspectionPropertyCheckItem;

public interface InspectionPropertyCheckItemMapper {
    int deleteByPrimaryKey(String inspectionCheckItemId);

    int insert(InspectionPropertyCheckItem record);

    int insertSelective(InspectionPropertyCheckItem record);

    InspectionPropertyCheckItem selectByPrimaryKey(String inspectionCheckItemId);

    int updateByPrimaryKeySelective(InspectionPropertyCheckItem record);

    int updateByPrimaryKey(InspectionPropertyCheckItem record);
    
    
    List<InspectionPropertyCheckItem> selectInspectionPropertyCheckItem(String inspectionPlanId);
}