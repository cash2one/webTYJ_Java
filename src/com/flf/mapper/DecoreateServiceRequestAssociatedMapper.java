package com.flf.mapper;

import java.util.List;

import com.flf.entity.DecoreateServiceRequestAssociated;

/**
 * 业主装修服务请求关联表
 * @author taoyongchao
 *  2015-8-18
 */
public interface DecoreateServiceRequestAssociatedMapper {
	
	int deleteDecoreateServiceRequestAssociated(String recordId);//删除业主装修服务请求关联表信息记录

	int insertDecoreateServiceRequestAssociated(DecoreateServiceRequestAssociated decoreateServiceRequestAssociated);//添加业主装修服务请求关联表信息记录

    List<DecoreateServiceRequestAssociated> listAllDecoreateServiceRequestAssociated();//查询所有业主装修服务请求关联表信息记录

    DecoreateServiceRequestAssociated getDecoreateServiceRequestAssociatedbyId(String recordId);//通过Id查询业主装修服务请求关联表信息记录

    int updateDecoreateServiceRequestAssociated(DecoreateServiceRequestAssociated decoreateServiceRequestAssociated);//修改业主装修服务请求关联表信息记录


}
