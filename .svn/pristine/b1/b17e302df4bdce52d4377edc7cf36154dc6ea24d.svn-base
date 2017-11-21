package com.flf.service.impl;
/* Created by Administrator on 2015/6/15. 
author:尹磊
修改时间：2015/6/15  修改人：尹磊 */
import java.util.List;
import java.util.UUID;

import com.flf.entity.MeterReadingComplaints;
import com.flf.entity.PageRestful;
import com.flf.mapper.MeterReadingComplaintsMapper;
import com.flf.service.MeterReadingComplaintsService;

public class MeterReadingComplaintsServiceImpl implements
		MeterReadingComplaintsService {
	private MeterReadingComplaintsMapper meterReadingComplaintsMapper;
		
	public MeterReadingComplaintsMapper getMeterReadingComplaintsMapper() {
		return meterReadingComplaintsMapper;
	}

	public void setMeterReadingComplaintsMapper(
			MeterReadingComplaintsMapper meterReadingComplaintsMapper) {
		this.meterReadingComplaintsMapper = meterReadingComplaintsMapper;
	}

	/**
	 * 查询所有抄表投诉信息
	 * @return
	 */
	@Override
	public List<MeterReadingComplaints> listAllMeterReadingComplaints() {
		// TODO Auto-generated method stub
		return meterReadingComplaintsMapper.listAllMeterReadingComplaints();
	}

	/**
	 * 根据id查询所有抄表投诉信息
	 * @return
	 */
	@Override
	public MeterReadingComplaints getUserByIdRest(
			String meterReadingComplaintsId) {
		// TODO Auto-generated method stub
		return meterReadingComplaintsMapper.getMeterReadingComplaintsbyId(meterReadingComplaintsId);
	}

	/**
	 * 新增抄表投诉信息
	 * @return
	 */
	@Override
	public void insertMeterReadingComplaintsrest(
			MeterReadingComplaints meterReadingComplaints) {
		// TODO Auto-generated method stub
		meterReadingComplaintsMapper.insertMeterReadingComplaints(meterReadingComplaints);
	}

	/**
	 * 修改抄表投诉信息
	 * @return
	 */
	@Override
	public void updateMeterReadingComplaintsrest(
			MeterReadingComplaints meterReadingComplaints) {
		// TODO Auto-generated method stub
		meterReadingComplaintsMapper.updateMeterReadingComplaints(meterReadingComplaints);
	}

	/**
	 * 删除抄表投诉信息
	 * @return
	 */
	@Override
	public void deleteMeterReadingComplaintsrest(String meterReadingComplaintsId) {
		// TODO Auto-generated method stub
		meterReadingComplaintsMapper.deleteMeterReadingComplaints(meterReadingComplaintsId);
	}

	@Override
	public PageRestful listPageMeterReadingComplaints(
			MeterReadingComplaints meterReadingComplaints) {
		// TODO Auto-generated method stub
		PageRestful pageRestful= new PageRestful();
		List<MeterReadingComplaints> meterReadingComplaintss =meterReadingComplaintsMapper.listPageMeterReadingComplaints(meterReadingComplaints);
		meterReadingComplaintss.add(0,null);
		pageRestful.setMeterReadingComplaints(meterReadingComplaintss);
		pageRestful.setPage(meterReadingComplaints.getPage());
		return pageRestful;
	}

}
