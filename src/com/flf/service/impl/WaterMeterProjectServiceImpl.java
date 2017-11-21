package com.flf.service.impl;

import java.util.List;

import com.flf.entity.WaterMeterProject;
import com.flf.mapper.MeterProjectMapper;
import com.flf.service.WaterMeterProjectService;
/* Created by Administrator on 2015/6/15. 
author:尹磊
修改时间：2015/6/15  修改人：尹磊 */
public class WaterMeterProjectServiceImpl implements WaterMeterProjectService {
	private MeterProjectMapper meterProjectMapper;


	
	public MeterProjectMapper getMeterProjectMapper() {
		return meterProjectMapper;
	}


	public void setMeterProjectMapper(MeterProjectMapper meterProjectMapper) {
		this.meterProjectMapper = meterProjectMapper;
	}


	/**
	 * 查询所有水表使用记录抄表计划关系信息
	 * @return
	 */
	@Override
	public List<WaterMeterProject> listAllWaterMeterProject() {
		// TODO Auto-generated method stub
		return meterProjectMapper.listAllWaterMeterProject();
	}

	
	/**
	 * 根据id查询所有水表使用记录抄表计划关系信息
	 * @return
	 */
	@Override
	public WaterMeterProject getUserByIdRest(String waterMeterProjectId) {
		// TODO Auto-generated method stub
		return meterProjectMapper.getWaterMeterProjectbyId(waterMeterProjectId);
	}

	
	/**
	 * 新增水表使用记录抄表计划关系信息
	 * @return
	 */
	@Override
	public void insertWaterMeterProjectrest(WaterMeterProject waterMeterProject) {
		// TODO Auto-generated method stub
		meterProjectMapper.insertWaterMeterProject(waterMeterProject);
	}

	/**
	 * 修改水表使用记录抄表计划关系信息
	 * @return
	 */
	@Override
	public void updateWaterMeterProjectrest(WaterMeterProject waterMeterProject) {
		// TODO Auto-generated method stub
		meterProjectMapper.updateWaterMeterProject(waterMeterProject);
	}

	/**
	 * 删除水表使用记录抄表计划关系信息
	 * @return
	 */
	@Override
	public void deleteWaterMeterProjectrest(String waterMeterProjectId) {
		// TODO Auto-generated method stub
		meterProjectMapper.deleteWaterMeterProject(waterMeterProjectId);
	}

}
