package com.flf.mapper;

import java.util.Date;
import java.util.List;

import com.flf.entity.ElectricityLoss;

public interface ElectricityLossMapper {

	 	int deleteByPrimaryKey(Integer id);

	    int insert(ElectricityLoss record);

	    int insertSelective(ElectricityLoss record);

	    ElectricityLoss selectByPrimaryKey(Integer id);

	    int updateByPrimaryKeySelective(ElectricityLoss record);

	    int updateByPrimaryKey(ElectricityLoss record);

		List<ElectricityLoss> selectByDate(Date date);

		int selectMaxLevelByDate(Date date);

		int deleteByMeterDate(Date date);
		
		ElectricityLoss selectByElectricityNum(ElectricityLoss record);
}