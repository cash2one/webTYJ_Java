package com.flf.mapper;

import com.flf.entity.WaterMeterTypes;
import com.flf.entity.WaterMeterTypes;

import java.util.List;
import org.apache.ibatis.annotations.Param;
/* Created by Administrator on 2015/6/15. 
author:尹磊
修改时间：2015/6/15  修改人：尹磊 */
public interface MeterTypesMapper {
	int deleteWaterMeterTypes(String waterMeterTypesId);// 删除水表所属建筑类型id信息

    int insertWaterMeterTypes(WaterMeterTypes waterMeterTypes); //新增水表所属建筑类型id信息

    List<WaterMeterTypes> listPageWaterMeterTypes(WaterMeterTypes waterMeterTypes); // 分页查询水表所属建筑类型id信息
    
    List<WaterMeterTypes> listAllWaterMeterTypes();  // 查询所有水表所属建筑类型id信息

    WaterMeterTypes getWaterMeterTypesbyId(String waterMeterTypesId);  //根据水表所属建筑类型idid查询水表所属建筑类型id信息

    int updateWaterMeterTypes(WaterMeterTypes waterMeterTypes); // 修改水表所属建筑类型id信息
}