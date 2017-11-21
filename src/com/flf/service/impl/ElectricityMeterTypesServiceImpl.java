package com.flf.service.impl;

import java.util.List;

import com.flf.entity.ElectricityMeterTypes;
import com.flf.mapper.ElectricityMeterTypesMapper;
import com.flf.service.ElectricityMeterTypesService;

public class ElectricityMeterTypesServiceImpl implements
		ElectricityMeterTypesService {
	private ElectricityMeterTypesMapper electricityMeterTypesMapper;
	

	public ElectricityMeterTypesMapper getElectricityMeterTypesMapper() {
		return electricityMeterTypesMapper;
	}

	public void setElectricityMeterTypesMapper(
			ElectricityMeterTypesMapper electricityMeterTypesMapper) {
		this.electricityMeterTypesMapper = electricityMeterTypesMapper;
	}

	@Override
	public List<ElectricityMeterTypes> listAllElectricityMeterTypes() {
		// TODO Auto-generated method stub
		return electricityMeterTypesMapper.listAllElectricityMeterTypes();
	}

	@Override
	public ElectricityMeterTypes getUserByIdRest(String electricityMeterTypesId) {
		// TODO Auto-generated method stub
		return electricityMeterTypesMapper.getElectricityMeterTypesbyId(electricityMeterTypesId);
	}

	@Override
	public void insertElectricityMeterTypesrest(
			ElectricityMeterTypes electricityMeterTypes) {
		// TODO Auto-generated method stub
		electricityMeterTypesMapper.insertElectricityMeterTypes(electricityMeterTypes);
	}

	@Override
	public void updateElectricityMeterTypesrest(
			ElectricityMeterTypes electricityMeterTypes) {
		// TODO Auto-generated method stub
		electricityMeterTypesMapper.updateElectricityMeterTypes(electricityMeterTypes);
	}

	@Override
	public void deleteElectricityMeterTypesrest(String electricityMeterTypesId) {
		// TODO Auto-generated method stub
		electricityMeterTypesMapper.deleteElectricityMeterTypes(electricityMeterTypesId);
	}

}
