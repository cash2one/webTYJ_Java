package com.flf.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.flf.entity.BuildingStructureNew;
import com.flf.entity.DataDictionarySlave;
import com.flf.mapper.BuildingStructureNewMapper;
import com.flf.mapper.DataDictionaryMasterMapper;
import com.flf.mapper.DataDictionarySlaveMapper;
import com.flf.service.DataDictionarySlaveService;

public class DataDictionarySlaveServiceImpl implements DataDictionarySlaveService{

	private DataDictionarySlaveMapper dataDictionarySlaveMapper;
	private BuildingStructureNewMapper buildingStructureNewMapper;
	private DataDictionaryMasterMapper dataDictionaryMasterMapper;
	
	public DataDictionaryMasterMapper getDataDictionaryMasterMapper() {
		return dataDictionaryMasterMapper;
	}


	public void setDataDictionaryMasterMapper(DataDictionaryMasterMapper dataDictionaryMasterMapper) {
		this.dataDictionaryMasterMapper = dataDictionaryMasterMapper;
	}


	public BuildingStructureNewMapper getBuildingStructureNewMapper() {
		return buildingStructureNewMapper;
	}


	public void setBuildingStructureNewMapper(
			BuildingStructureNewMapper buildingStructureNewMapper) {
		this.buildingStructureNewMapper = buildingStructureNewMapper;
	}


	public DataDictionarySlaveMapper getDataDictionarySlaveMapper() {
		return dataDictionarySlaveMapper;
	}


	public void setDataDictionarySlaveMapper(
			DataDictionarySlaveMapper dataDictionarySlaveMapper) {
		this.dataDictionarySlaveMapper = dataDictionarySlaveMapper;
	}

	@Override
	public List<DataDictionarySlave> getDataDictionarySlave(String masterName,
			String buildingId) {
		BuildingStructureNew structureNew = buildingStructureNewMapper.getBuildingStructureNewbyId(buildingId);
		if(structureNew!=null){
			String projectId = structureNew.getProjectId();
			return 	dataDictionarySlaveMapper.getDropboxList(masterName, projectId);
		}
		return null;
	}


	@Override
	public List<DataDictionarySlave> getDataDictionarySlaveRes(
			String masterName, String projectId) {
		List<DataDictionarySlave> dataDictionarySlaves = dataDictionarySlaveMapper.getDropboxList(masterName, projectId);
		if(dataDictionarySlaves.size() == 0){
			dataDictionarySlaves = dataDictionarySlaveMapper.getDefaultByMasterName(masterName);
		}
		return 	dataDictionarySlaves;
		
	}

}
