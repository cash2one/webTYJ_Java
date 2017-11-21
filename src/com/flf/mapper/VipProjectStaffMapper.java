package com.flf.mapper;

import java.util.List;

import com.flf.entity.VipProjectStaff;

public interface VipProjectStaffMapper {
    
	//向VIP客户项目专员关联表中添加数据
    int insertVipProjectStaff(VipProjectStaff vipProjectStaff);
    
    //根据vipId查询此客户是否已经关联vip客户项目专员表
    List<VipProjectStaff> selectVipProStaffByVipid(String vipId);
    
    //根据vipId删除对应客户在表中的数据
    void deleteVipProStaffByVipid(String vipId);
}