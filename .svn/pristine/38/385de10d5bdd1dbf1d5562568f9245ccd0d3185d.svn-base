package com.flf.service.impl;

import java.util.List;

import com.flf.entity.ElectricityMeterReadingComplaints;
import com.flf.entity.PageRestful;
import com.flf.mapper.ElectricityMeterReadingComplaintsMapper;
import com.flf.service.ElectricityMeterReadingComplaintsService;

public class ElectricityMeterReadingComplaintsServiceImpl implements
		ElectricityMeterReadingComplaintsService {
	private ElectricityMeterReadingComplaintsMapper electricityMeterReadingComplaintsMapper;
	

	public ElectricityMeterReadingComplaintsMapper getElectricityMeterReadingComplaintsMapper() {
		return electricityMeterReadingComplaintsMapper;
	}

	public void setElectricityMeterReadingComplaintsMapper(
			ElectricityMeterReadingComplaintsMapper electricityMeterReadingComplaintsMapper) {
		this.electricityMeterReadingComplaintsMapper = electricityMeterReadingComplaintsMapper;
	}

	@Override
	public List<ElectricityMeterReadingComplaints> listAllElectricityMeterReadingComplaints() {
		// TODO Auto-generated method stub
		return electricityMeterReadingComplaintsMapper.listAllElectricityMeterReadingComplaints();
	}

	@Override
	public PageRestful listPageElectricityMeterReadingComplaints(
			ElectricityMeterReadingComplaints electricityMeterReadingComplaints) {
		// TODO Auto-generated method stub
		PageRestful pageRestful = new PageRestful();
		List<ElectricityMeterReadingComplaints> electricityMeterReadingComplaintss=electricityMeterReadingComplaintsMapper.listPageElectricityMeterReadingComplaints(electricityMeterReadingComplaints);
		electricityMeterReadingComplaintss.add(0,null);
		pageRestful.setElectricityMeterReadingComplaints(electricityMeterReadingComplaintss);
		pageRestful.setPage(electricityMeterReadingComplaints.getPage());
		return pageRestful;
	}

	@Override
	public ElectricityMeterReadingComplaints getUserByIdRest(
			String electricityMeterReadingComplaintsId) {
		// TODO Auto-generated method stub
		return electricityMeterReadingComplaintsMapper.getElectricityMeterReadingComplaintsbyId(electricityMeterReadingComplaintsId);
	}

	@Override
	public void insertElectricityMeterReadingComplaintsrest(
			ElectricityMeterReadingComplaints electricityMeterReadingComplaints) {
		// TODO Auto-generated method stub
		electricityMeterReadingComplaintsMapper.insertElectricityMeterReadingComplaints(electricityMeterReadingComplaints);
	}

	@Override
	public void updateElectricityMeterReadingComplaintsrest(
			ElectricityMeterReadingComplaints electricityMeterReadingComplaints) {
		// TODO Auto-generated method stub
		electricityMeterReadingComplaintsMapper.updateElectricityMeterReadingComplaints(electricityMeterReadingComplaints);
	}

	@Override
	public void deleteElectricityMeterReadingComplaintsrest(
			String electricityMeterReadingComplaintsId) {
		// TODO Auto-generated method stub
		electricityMeterReadingComplaintsMapper.deleteElectricityMeterReadingComplaints(electricityMeterReadingComplaintsId);
	}

}
