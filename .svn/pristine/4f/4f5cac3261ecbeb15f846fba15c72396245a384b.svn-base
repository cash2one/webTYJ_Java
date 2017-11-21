package com.flf.service.impl;

import java.util.List;

import com.flf.entity.ElectricityMeterProject;
import com.flf.mapper.ElectricityMeterProjectMapper;
import com.flf.service.ElectricityMeterProjectService;

public class ElectricityMeterProjectServiceImpl implements
		ElectricityMeterProjectService {
	private ElectricityMeterProjectMapper electricityMeterProjectMapper;
	

	public ElectricityMeterProjectMapper getElectricityMeterProjectMapper() {
		return electricityMeterProjectMapper;
	}

	public void setElectricityMeterProjectMapper(
			ElectricityMeterProjectMapper electricityMeterProjectMapper) {
		this.electricityMeterProjectMapper = electricityMeterProjectMapper;
	}

	@Override
	public List<ElectricityMeterProject> listAllElectricityMeterProject() {
		// TODO Auto-generated method stub
		return electricityMeterProjectMapper.listAllElectricityMeterProject();
	}

	@Override
	public ElectricityMeterProject getUserByIdRest(
			String electricityMeterProjectId) {
		// TODO Auto-generated method stub
		return electricityMeterProjectMapper.getElectricityMeterProjectbyId(electricityMeterProjectId);
	}

	@Override
	public void insertElectricityMeterProjectrest(
			ElectricityMeterProject electricityMeterProject) {
		// TODO Auto-generated method stub
		electricityMeterProjectMapper.insertElectricityMeterProject(electricityMeterProject);
	}

	@Override
	public void updateElectricityMeterProjectrest(
			ElectricityMeterProject electricityMeterProject) {
		// TODO Auto-generated method stub
		electricityMeterProjectMapper.updateElectricityMeterProject(electricityMeterProject);
	}

	@Override
	public void deleteElectricityMeterProjectrest(
			String electricityMeterProjectId) {
		// TODO Auto-generated method stub
		electricityMeterProjectMapper.deleteElectricityMeterProject(electricityMeterProjectId);
	}

}
