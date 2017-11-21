package com.flf.mapper;

import java.util.List;

import com.flf.entity.DecorateAnnex;
import com.flf.entity.DecorateComponentRecords;

/**
 * 装修组件记录表
 * @author taoyongchao
 * 
 * 2015-8-17
 */

public interface DecorateComponentRecordsMapper {
	
	int deleteDecorateComponentRecords(String recordId);//删除装修组件记录表信息记录

	int insertDecorateComponentRecords(DecorateComponentRecords decorateComponentRecords);//添加装修组件记录表信息记录

    List<DecorateComponentRecords> listAllDecorateComponentRecords();//查询所有装修组件记录表信息记录

    DecorateComponentRecords getDecorateComponentRecordsbyId(String recordId);//通过Id查询装修组件记录表信息记录

    int updateDecorateComponentRecords(DecorateComponentRecords decorateComponentRecords);//修改装修组件记录表信息记录

    List<DecorateComponentRecords> getDecorateComponentRecordsbyApplyId(String applyId);//根据申请id获取装修组件记录
}
