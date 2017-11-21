package com.flf.mapper;

import com.flf.entity.LeaseContract;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface LeaseContractMapper {
    
    int deleteByPrimaryKey(String contractId);

    int insert(LeaseContract record);

    int insertSelective(LeaseContract record);

    LeaseContract selectByPrimaryKey(String contractId);

    int updateByPrimaryKeySelective(LeaseContract record);

    int updateByPrimaryKey(LeaseContract record);

	List<LeaseContract> listAllLeaseContract();//查询所有的合同列表

	List<LeaseContract> listPageLeaseContracts(LeaseContract leaseContract);//分页查询列表
}