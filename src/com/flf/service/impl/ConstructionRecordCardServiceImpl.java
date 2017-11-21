package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import com.flf.entity.ConstructionRecordCard;
import com.flf.mapper.ConstructionRecordCardMapper;
import com.flf.service.ConstructionRecordCardService;
/**
 * 施工备案证
 * @author 陶勇超
 *  2015-8-19
 */

public class ConstructionRecordCardServiceImpl implements ConstructionRecordCardService{

	private ConstructionRecordCardMapper constructionRecordCardMapper;
	
	public ConstructionRecordCardMapper getConstructionRecordCardMapper() {
		return constructionRecordCardMapper;
	}

	public void setConstructionRecordCardMapper(
			ConstructionRecordCardMapper constructionRecordCardMapper) {
		this.constructionRecordCardMapper = constructionRecordCardMapper;
	}

	@Override
	public ConstructionRecordCard getConstructionRecordCardbyId(String recordId) {
		// TODO Auto-generated method stub
		return constructionRecordCardMapper.getConstructionRecordCardbyId(recordId);
	}

	@Override
	public void insertConstructionRecordCard(
			ConstructionRecordCard constructionRecordCard) {
		String uuid = UUID.randomUUID().toString();
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()).toString();
		if(constructionRecordCard != null){
			
			
			constructionRecordCard.setRecordId(uuid);
			constructionRecordCard.setRegistrationTime(date);
			
			int result = constructionRecordCardMapper.insertConstructionRecordCard(constructionRecordCard);
			if(result>0){
			
				//记录日志信息
//				TasksJournal journal = new TasksJournal();
//				journal.setTaskId(returnVisitOrders.getTaskId());
//				journal.setCreOrderId(returnVisitOrders.getOrderId());
//				journal.setCreOrderType(returnVisitOrders.getOrderType());
//				journal.setChangeOrderState(returnVisitOrders.getOrderState());
//				journal.setOperatorId(returnVisitOrders.getOperatorId());
//				journal.setRemarks(returnVisitOrders.getRemarks());
//				journal.setOperationTime(date);
//				tasksJournalMapper.insertTasksJournal(journal);
			}
		}
		return;
		
	}

	@Override
	public void updateConstructionRecordCard(
			ConstructionRecordCard constructionRecordCard) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteConstructionRecordCard(String recordId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ConstructionRecordCard getConstructionRecordCardbyApplyId(
			String applyId) {
		// TODO Auto-generated method stub
		return constructionRecordCardMapper.getConstructionRecordCardbyApplyId(applyId);
	}

}
