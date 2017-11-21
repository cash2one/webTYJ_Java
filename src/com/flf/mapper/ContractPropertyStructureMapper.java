package com.flf.mapper;

import java.util.List;

import com.flf.entity.ContractPropertyStructure;

public interface ContractPropertyStructureMapper {
	List<ContractPropertyStructure> listPageContractPropertyStructure(ContractPropertyStructure contractPropertyStructure);
    List<ContractPropertyStructure> listAllContractPropertyStructure();
    ContractPropertyStructure getContractPropertyStructureById(String id);
    int insertContractPropertyStructure(ContractPropertyStructure contractPropertyStructure);
    int updateContractPropertyStructure(ContractPropertyStructure contractPropertyStructure);
    int deleteContractPropertyStructure(String id);
    
    List<ContractPropertyStructure> listAllContractPropertyStructureByContractId(String contractId); //根据合同查询合同详情
    
    List<ContractPropertyStructure> selectBuildingById(ContractPropertyStructure contractPropertyStructure);//根据 合同资产 查询 建筑信息
}