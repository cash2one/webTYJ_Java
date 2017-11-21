package com.flf.mapper;

import java.util.List;

import com.flf.entity.Contract;

public interface ContractMapper {
    List<Contract> listPageContract(Contract contract);
    List<Contract> listAllContract();
    Contract getContractById(String id);
    int insertContract(Contract contract);
    int insertContractUUID(Contract contract);  //新增合同UUID
    int updateContract(Contract contract);
    int deleteContract(String id);
    
    List<Contract> getContractDataById(String propertyId);//根据资产id查询合同信息

    

}