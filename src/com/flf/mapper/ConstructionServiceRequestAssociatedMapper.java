package com.flf.mapper;

import java.util.List;

import com.flf.entity.ConstructionServiceRequestAssociated;

/**
 * 十.	施工服务请求关联表
 * @author 陶勇超
 * 2015-8-31
 */
public interface ConstructionServiceRequestAssociatedMapper {
	int deleteConstructionServiceRequestAssociated(String recordId);//删除业主施工服务请求关联表信息记录

	int insertConstructionServiceRequestAssociated(ConstructionServiceRequestAssociated constructionServiceRequestAssociated);//添加业主施工服务请求关联表信息记录

    List<ConstructionServiceRequestAssociated> listAllConstructionServiceRequestAssociated();//查询所有业主施工服务请求关联表信息记录

    ConstructionServiceRequestAssociated getConstructionServiceRequestAssociatedbyId(String recordId);//通过Id查询业主施工服务请求关联表信息记录

    int updateConstructionServiceRequestAssociated(ConstructionServiceRequestAssociated constructionServiceRequestAssociated);//修改业主施工服务请求关联表信息记录

}
