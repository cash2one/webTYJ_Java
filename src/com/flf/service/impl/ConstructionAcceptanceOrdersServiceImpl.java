package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.flf.entity.Annex;
import com.flf.entity.ConstructionAcceptanceOrders;
import com.flf.entity.ConstructionAcceptanceRecords;
import com.flf.entity.LetterRecords;
import com.flf.entity.TasksJournal;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.ConstructionAcceptanceOrdersMapper;
import com.flf.mapper.ConstructionAcceptanceRecordsMapper;
import com.flf.mapper.LetterRecordsMapper;
import com.flf.mapper.TasksJournalMapper;
import com.flf.service.ConstructionAcceptanceOrdersService;
import com.flf.util.Tools;

public class ConstructionAcceptanceOrdersServiceImpl implements ConstructionAcceptanceOrdersService{

	private ConstructionAcceptanceOrdersMapper constructionAcceptanceOrdersMapper;
	private ConstructionAcceptanceRecordsMapper constructionAcceptanceRecordsMapper;
	private AnnexMapper annexMapper;
	private TasksJournalMapper tasksJournalMapper;
	private LetterRecordsMapper letterRecordsMapper;
	
	public LetterRecordsMapper getLetterRecordsMapper() {
		return letterRecordsMapper;
	}

	public void setLetterRecordsMapper(LetterRecordsMapper letterRecordsMapper) {
		this.letterRecordsMapper = letterRecordsMapper;
	}

	public ConstructionAcceptanceOrdersMapper getConstructionAcceptanceOrdersMapper() {
		return constructionAcceptanceOrdersMapper;
	}

	public void setConstructionAcceptanceOrdersMapper(
			ConstructionAcceptanceOrdersMapper constructionAcceptanceOrdersMapper) {
		this.constructionAcceptanceOrdersMapper = constructionAcceptanceOrdersMapper;
	}

	public ConstructionAcceptanceRecordsMapper getConstructionAcceptanceRecordsMapper() {
		return constructionAcceptanceRecordsMapper;
	}

	public void setConstructionAcceptanceRecordsMapper(
			ConstructionAcceptanceRecordsMapper constructionAcceptanceRecordsMapper) {
		this.constructionAcceptanceRecordsMapper = constructionAcceptanceRecordsMapper;
	}

	public AnnexMapper getAnnexMapper() {
		return annexMapper;
	}

	public void setAnnexMapper(AnnexMapper annexMapper) {
		this.annexMapper = annexMapper;
	}

	public TasksJournalMapper getTasksJournalMapper() {
		return tasksJournalMapper;
	}

	public void setTasksJournalMapper(TasksJournalMapper tasksJournalMapper) {
		this.tasksJournalMapper = tasksJournalMapper;
	}

	@Override
	public void closeConstructionAcceptanceOrders(
			ConstructionAcceptanceOrders constructionAcceptanceOrders) {
		if(constructionAcceptanceOrders != null){
			Integer orderState = constructionAcceptanceOrders.getOrderState();
			String closePersonId = constructionAcceptanceOrders.getClosePersonId();
			if(orderState != null && closePersonId != null){
				constructionAcceptanceOrders.setOrderState(0);
				constructionAcceptanceOrders.setCloseTime(new Date());
				constructionAcceptanceOrdersMapper.updateConstructionAcceptanceOrders(constructionAcceptanceOrders);
			}
		}
		return;
	}

	@Override
	public ConstructionAcceptanceOrders getConstructionAcceptanceOrdersbyId(
			String orderId) {
		if(Tools.notEmpty(orderId)){
			return constructionAcceptanceOrdersMapper.getConstructionAcceptanceOrdersbyId(orderId);
		}
		return null;
	}

	@Override
	public ConstructionAcceptanceOrders insertConstructionAcceptanceOrders(
			ConstructionAcceptanceOrders constructionAcceptanceOrders) {
		String uuid = UUID.randomUUID().toString();
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		if(constructionAcceptanceOrders != null){
			List<ConstructionAcceptanceRecords> constructionAcceptanceRecordsList = constructionAcceptanceOrders.getConstructionAcceptanceRecords();
			List<Annex> annexList = constructionAcceptanceOrders.getAnnexs();
			List<LetterRecords> letterRecordsList  = constructionAcceptanceOrders.getLetterRecords();
			constructionAcceptanceOrders.setOrderId(uuid);
			constructionAcceptanceOrders.setFinishTime(new Date());
			Integer result = constructionAcceptanceOrdersMapper.insertConstructionAcceptanceOrdersUUID(constructionAcceptanceOrders);
			if(result > 0 && constructionAcceptanceRecordsList != null && constructionAcceptanceRecordsList.size() > 0){
				for(ConstructionAcceptanceRecords records : constructionAcceptanceRecordsList){
					records.setOrderId(uuid);
					constructionAcceptanceRecordsMapper.insertConstructionAcceptanceRecords(records);
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
				journal.setTaskId(constructionAcceptanceOrders.getTaskId());
				journal.setCreOrderId(uuid);
				journal.setCreOrderType(constructionAcceptanceOrders.getOrderType());
				journal.setChangeOrderState(constructionAcceptanceOrders.getOrderState());
				journal.setOperatorId(constructionAcceptanceOrders.getOperatorId());
				journal.setRemarks(constructionAcceptanceOrders.getRemarks());
				journal.setOperationTime(date);
				tasksJournalMapper.insertTasksJournal(journal);
				return constructionAcceptanceOrders;
			}
		}
		return null;
	}

	@Override
	public List<ConstructionAcceptanceOrders> listAllConstructionAcceptanceOrders() {
		return constructionAcceptanceOrdersMapper.listAllConstructionAcceptanceOrders();
	}

	@Override
	public void updateConstructionAcceptanceOrders(
			ConstructionAcceptanceOrders constructionAcceptanceOrders) {
		constructionAcceptanceOrdersMapper.updateConstructionAcceptanceOrders(constructionAcceptanceOrders);
	}

	@Override
	public ConstructionAcceptanceOrders getConstructionAcceptanceOrdersbyTypeAndTaskId(
			String orderType, String taskId) {
		// TODO Auto-generated method stub
		return constructionAcceptanceOrdersMapper.getConstructionAcceptanceOrdersbyTypeAndTaskId(orderType, taskId);
	}

}
