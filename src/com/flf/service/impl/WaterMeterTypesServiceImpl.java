package com.flf.service.impl;

import java.util.List;

import com.flf.entity.WaterMeterTypes;
import com.flf.mapper.MeterTypesMapper;
import com.flf.service.WaterMeterTypesService;
 /*Created by Administrator on 2015/6/15. 
author:尹磊
修改时间：2015/6/15  修改人：尹磊 */
public class WaterMeterTypesServiceImpl implements WaterMeterTypesService {
	
	private MeterTypesMapper meterTypesMapper;



	
	public MeterTypesMapper getMeterTypesMapper() {
		return meterTypesMapper;
	}


	public void setMeterTypesMapper(MeterTypesMapper meterTypesMapper) {
		this.meterTypesMapper = meterTypesMapper;
	}


	/**
	 * 查询所有水表所在建筑类型信息
	 * @return
	 */
	@Override
	public List<WaterMeterTypes> listAllWaterMeterTypes() {
		// TODO Auto-generated method stub
		return meterTypesMapper.listAllWaterMeterTypes();
	}

	
	/**
	 * 根据id查询所有水表所在建筑类型信息
	 * @return
	 */
	@Override
	public WaterMeterTypes getUserByIdRest(String waterMeterTypesId) {
		// TODO Auto-generated method stub
		return meterTypesMapper.getWaterMeterTypesbyId(waterMeterTypesId);
	}

	
	/**
	 * 新增水表所在建筑类型信息
	 * @return
	 */
	@Override
	public void insertWaterMeterTypesrest(WaterMeterTypes waterMeterTypes) {
		// TODO Auto-generated method stub
		meterTypesMapper.insertWaterMeterTypes(waterMeterTypes);
	}

	
	/**
	 * 修改水表所在建筑类型信息
	 * @return
	 */
	@Override
	public void updateWaterMeterTypesrest(WaterMeterTypes waterMeterTypes) {
		// TODO Auto-generated method stub
		meterTypesMapper.updateWaterMeterTypes(waterMeterTypes);
	}

	
	/**
	 * 删除水表所在建筑类型信息
	 * @return
	 */
	@Override
	public void deleteWaterMeterTypesrest(String waterMeterTypesId) {
		// TODO Auto-generated method stub
		meterTypesMapper.deleteWaterMeterTypes(waterMeterTypesId);
	}

}
