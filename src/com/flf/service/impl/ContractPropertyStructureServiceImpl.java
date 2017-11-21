package com.flf.service.impl;

import java.util.List;

import com.flf.entity.ContractPropertyStructure;
import com.flf.mapper.ContractPropertyStructureMapper;
import com.flf.service.ContractPropertyStructureService;

public class ContractPropertyStructureServiceImpl implements ContractPropertyStructureService{
	
	private ContractPropertyStructureMapper contractPropertyStructureMapper;

	public ContractPropertyStructureMapper getContractPropertyStructureMapper() {
		return contractPropertyStructureMapper;
	}

	public void setContractPropertyStructureMapper(
			ContractPropertyStructureMapper contractPropertyStructureMapper) {
		this.contractPropertyStructureMapper = contractPropertyStructureMapper;
	}

	@Override
	public List<ContractPropertyStructure> listAllContractPropertyStructureByContractId(
			String contractId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContractPropertyStructure> listAllByContractId(String id) {
		// TODO Auto-generated method stub
		return contractPropertyStructureMapper.listAllContractPropertyStructureByContractId(id);
	}

	@Override
	public List<ContractPropertyStructure> selectBuildingByIdRes(
			ContractPropertyStructure contractPropertyStructure) {
		// TODO Auto-generated method stub
		return contractPropertyStructureMapper.selectBuildingById(contractPropertyStructure);
	}
}
