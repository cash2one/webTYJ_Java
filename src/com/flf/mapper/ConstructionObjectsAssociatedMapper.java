package com.flf.mapper;

import java.util.List;

import com.flf.entity.ConstructionObjectsAssociated;

/**
 * 二.	施工对象关联表 
 * @author taoyongchao
 *   2015-8-31
 */
public interface ConstructionObjectsAssociatedMapper {
	int deleteOwnerConstructionApply(String recordId);//删除施工对象关联表 信息记录

	int insertConstructionObjectsAssociated(ConstructionObjectsAssociated constructionObjectsAssociated);//添加施工对象关联表 信息记录
	int insertConstructionObjectsAssociatedUUID(ConstructionObjectsAssociated constructionObjectsAssociated);//添加施工对象关联表 信息记录
    List<ConstructionObjectsAssociated> listAllConstructionObjectsAssociated();//查询所有施工对象关联表 信息记录
    int updateConstructionObjectsAssociated(ConstructionObjectsAssociated constructionObjectsAssociated);//修改施工对象关联表 息记录

}
