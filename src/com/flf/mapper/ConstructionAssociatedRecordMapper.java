package com.flf.mapper;

import java.util.List;

import com.flf.entity.ConstructionAssociatedRecord;

/**
 * 六.	施工单位关联表
 * @author 陶勇超
 *  2015-8-31
 */
public interface ConstructionAssociatedRecordMapper {
	int deleteConstructionAssociatedRecord(String recordId);//删除施工单位关联记录

	int insertConstructionAssociatedRecord(ConstructionAssociatedRecord constructionAssociatedRecord);//添加装修单位关联记录

    List<ConstructionAssociatedRecord> listAllConstructionAssociatedRecord();//查询所有施工单位关联记录

    ConstructionAssociatedRecord getConstructionAssociatedRecordbyId(String recordId);//通过Id查询施工单位关联记录

    int updateConstructionAssociatedRecord(ConstructionAssociatedRecord constructionAssociatedRecord);//修改施工位关联记录
    
    ConstructionAssociatedRecord getConstructionAssociatedRecordbyApplyId(String applyId);//根据申请id获取施工单位关联记录

}
