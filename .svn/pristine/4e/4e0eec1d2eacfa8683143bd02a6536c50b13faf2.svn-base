package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.flf.entity.Annex;
import com.flf.entity.ConstructionInspectionOrders;
import com.flf.entity.ConstructionInspectionRecords;
import com.flf.entity.LetterRecords;
import com.flf.entity.TasksJournal;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.ConstructionInspectionOrdersMapper;
import com.flf.mapper.ConstructionInspectionRecordsMapper;
import com.flf.mapper.LetterRecordsMapper;
import com.flf.mapper.TasksJournalMapper;
import com.flf.service.ConstructionInspectionOrdersService;
import com.flf.util.Tools;

public class ConstructionInspectionOrdersServiceImpl implements ConstructionInspectionOrdersService{

	private ConstructionInspectionOrdersMapper constructionInspectionOrdersMapper;
	private ConstructionInspectionRecordsMapper constructionInspectionRecordsMapper;
	private AnnexMapper annexMapper;
	private TasksJournalMapper tasksJournalMapper;
	private LetterRecordsMapper letterRecordsMapper;
	
	public LetterRecordsMapper getLetterRecordsMapper() {
		return letterRecordsMapper;
	}

	public void setLetterRecordsMapper(LetterRecordsMapper letterRecordsMapper) {
		this.letterRecordsMapper = letterRecordsMapper;
	}

	public TasksJournalMapper getTasksJournalMapper() {
		return tasksJournalMapper;
	}

	public void setTasksJournalMapper(TasksJournalMapper tasksJournalMapper) {
		this.tasksJournalMapper = tasksJournalMapper;
	}

	public ConstructionInspectionRecordsMapper getConstructionInspectionRecordsMapper() {
		return constructionInspectionRecordsMapper;
	}

	public void setConstructionInspectionRecordsMapper(
			ConstructionInspectionRecordsMapper constructionInspectionRecordsMapper) {
		this.constructionInspectionRecordsMapper = constructionInspectionRecordsMapper;
	}

	public AnnexMapper getAnnexMapper() {
		return annexMapper;
	}

	public void setAnnexMapper(AnnexMapper annexMapper) {
		this.annexMapper = annexMapper;
	}

	public ConstructionInspectionOrdersMapper getConstructionInspectionOrdersMapper() {
		return constructionInspectionOrdersMapper;
	}

	public void setConstructionInspectionOrdersMapper(
			ConstructionInspectionOrdersMapper constructionInspectionOrdersMapper) {
		this.constructionInspectionOrdersMapper = constructionInspectionOrdersMapper;
	}

	@Override
	public void closeConstructionInspectionOrders(
			ConstructionInspectionOrders constructionInspectionOrders) {
		if(constructionInspectionOrders != null){
			Integer orderState = constructionInspectionOrders.getOrderState();
			String closePersonId = constructionInspectionOrders.getClosePersonId();
			if(orderState != null && closePersonId != null){
				constructionInspectionOrders.setOrderState(0);
				constructionInspectionOrders.setCloseTime(new Date());
				constructionInspectionOrdersMapper.updateConstructionInspectionOrders(constructionInspectionOrders);
			}
		}
		return;
	}

	@Override
	public ConstructionInspectionOrders getConstructionInspectionOrdersbyId(
			String orderId) {
		if(Tools.notEmpty(orderId)){
			return constructionInspectionOrdersMapper.getConstructionInspectionOrdersbyId(orderId);
		}
		return null;
	}

	@Override
	public void insertConstructionInspectionOrders(
			ConstructionInspectionOrders constructionInspectionOrders) {
		String uuid = UUID.randomUUID().toString();
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		if(constructionInspectionOrders != null){
			List<ConstructionInspectionRecords> constructionInspectionRecordsList = constructionInspectionOrders.getConstructionInspectionRecords();
			List<Annex> annexList = constructionInspectionOrders.getAnnexs();
			List<LetterRecords> letterRecordsList  = constructionInspectionOrders.getLetterRecords();
			constructionInspectionOrders.setOrderId(uuid);
			constructionInspectionOrders.setFinishTime(new Date());
			Integer result = constructionInspectionOrdersMapper.insertConstructionInspectionOrdersUUID(constructionInspectionOrders);
			if(result > 0 && constructionInspectionRecordsList != null && constructionInspectionRecordsList.size() > 0){
				for(ConstructionInspectionRecords records : constructionInspectionRecordsList){
					records.setOrderId(uuid);
					constructionInspectionRecordsMapper.insertConstructionInspectionRecords(records);
				}
				for(LetterRecords letterRecords :letterRecordsList){
					letterRecords.setOrderId(uuid);
					letterRecordsMapper.insertLetterRecords(letterRecords);
				}
				if(annexList != null && annexList.size() > 0){
					for(Annex annex : annexList){
						annex.setRelationId(uuid);
						annex.setAnnexTime(date);
						annexMapper.insertAnnex(annex);
					}
				}
				TasksJournal journal = new TasksJournal();
				journal.setTaskId(constructionInspectionOrders.getTaskId());
				journal.setCreOrderId(uuid);
				journal.setCreOrderType(constructionInspectionOrders.getOrderType());
				journal.setChangeOrderState(constructionInspectionOrders.getOrderState());
				journal.setOperatorId(constructionInspectionOrders.getOperatorId());
				journal.setRemarks(constructionInspectionOrders.getRemarks());
				journal.setOperationTime(date);
				tasksJournalMapper.insertTasksJournal(journal);
			}
		}
	}

	@Override
	public List<ConstructionInspectionOrders> listAllConstructionInspectionOrders() {
		return constructionInspectionOrdersMapper.listAllConstructionInspectionOrders();
	}

	@Override
	public void updateConstructionInspectionOrders(
			ConstructionInspectionOrders constructionInspectionOrders) {
		constructionInspectionOrdersMapper.updateConstructionInspectionOrders(constructionInspectionOrders);
	}

	@Override
	public ConstructionInspectionOrders getConstructionInspectionOrdersbyTypeAndTaskId(
			String orderType, String taskId) {
		// TODO Auto-generated method stub
		return constructionInspectionOrdersMapper.getConstructionInspectionOrdersbyTypeAndTaskId(orderType, taskId);
	}

}
