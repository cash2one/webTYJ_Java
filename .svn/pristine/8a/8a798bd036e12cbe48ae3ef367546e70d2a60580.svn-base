package com.flf.mapper;

import java.util.List;

import com.flf.entity.OwnerConstructionApply;
/**
 * 业主施工申请表
 * @author taoyongchao
 *  2015-8-31
 */
public interface OwnerConstructionApplyMapper {
	
	int deleteOwnerConstructionApply(String recordId);//删除业主施工申请表信息记录

	int insertOwnerConstructionApply(OwnerConstructionApply ownerConstructionApply);//添加业主施工申请表信息记录
	int insertOwnerConstructionApplyUUID(OwnerConstructionApply ownerConstructionApply);//添加业主施工申请表信息记录
    List<OwnerConstructionApply> listAllOwnerConstructionApply();//查询所有业主装修申请表信息记录

    List<OwnerConstructionApply> getOwnerConstructionApplybyId(String custId);//通过Id查询业主施工申请表信息记录
    OwnerConstructionApply getOwnerConstructionApplyByServiceId(String serviceId);//通过服务请求ID查询施工申请申请

    int updateOwnerConstructionApply(OwnerConstructionApply ownerConstructionApply);//修改业主施工申请表信息记录


}
