package com.flf.mapper;

import java.util.List;
import com.flf.entity.DecorateAssociatedRecords;
/**
 * 装修单位关联记录
 * @author taoyongchao
 * 2015-8-17
 */

public interface DecorateAssociatedRecordsMapper {
	
	int deleteDecorateAssociatedRecords(String recordId);//删除装修单位关联记录

	int insertDecorateAssociatedRecords(DecorateAssociatedRecords decorateAssociatedRecords);//添加装修单位关联记录

    List<DecorateAssociatedRecords> listAllDecorateAssociatedRecords();//查询所有装修单位关联记录

    DecorateAssociatedRecords getDecorateAssociatedRecordsbyId(String recordId);//通过Id查询装修单位关联记录

    int updateDecorateAssociatedRecords(DecorateAssociatedRecords decorateAssociatedRecords);//修改装修单位关联记录
    
    DecorateAssociatedRecords getDecorateAssociatedRecordsbyApplyId(String applyId);//根据申请id获取装修单位关联记录

}

