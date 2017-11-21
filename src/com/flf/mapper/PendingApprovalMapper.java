package com.flf.mapper;

import java.util.List;

import com.flf.entity.PendingApproval;

public interface PendingApprovalMapper {
    int deleteByPrimaryKey(String pendingApprovalId);

    int insert(PendingApproval record);

    int insertSelective(PendingApproval record);

    PendingApproval selectByPrimaryKey(String pendingApprovalId);

    int updateByPrimaryKeySelective(PendingApproval record);

    int updateByPrimaryKey(PendingApproval record);
    
    List<PendingApproval> listPagePendingApproval(PendingApproval pending);
    
    List<PendingApproval> selectAllPendingApproval();//查询所有的代办记录(待审核的)
}