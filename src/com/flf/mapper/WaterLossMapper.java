package com.flf.mapper;

import java.util.Date;
import java.util.List;

import com.flf.entity.WaterLoss;

public interface WaterLossMapper {
    int deleteByPrimaryKey(Integer id);
    
    int deleteByMeterDate(Date date);

    int insert(WaterLoss record);

    int insertSelective(WaterLoss record);

    WaterLoss selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WaterLoss record);

    int updateByPrimaryKey(WaterLoss record);

	List<WaterLoss> selectByDate(Date date);

	int selectMaxLevelByDate(Date date);
	
	WaterLoss selectByWaterNum(WaterLoss record);
}