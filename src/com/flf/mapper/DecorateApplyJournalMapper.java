package com.flf.mapper;

import java.util.List;

import com.flf.entity.DecorateApplyJournal;
/**
 * 三.	装修申请日志 
 * @author 陶勇超
 * 2015-8-20
 */
public interface DecorateApplyJournalMapper {
	
	int deleteDecorateApplyJournal(String fileId);//删除装修申请日志 信息记录

	int insertDecorateApplyJournal(DecorateApplyJournal decorateApplyJournal);//添加装修申请日志 信息记录

    List<DecorateApplyJournal> listAllDecorateApplyJournal();//查询所有装修申请日志 信息记录

    DecorateApplyJournal getDecorateApplyJournalbyId(String fileId);//通过Id查询装修申请日志 信息记录

    int updateDecorateApplyJournal(DecorateApplyJournal decorateApplyJournal);//修改装修申请日志 信息记录


}
