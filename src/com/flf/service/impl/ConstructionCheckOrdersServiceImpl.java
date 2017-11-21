package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.flf.entity.Annex;
import com.flf.entity.ConstructionCheckOrders;
import com.flf.entity.ConstructionCheckRecords;
import com.flf.entity.LetterRecords;
import com.flf.entity.TasksJournal;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.ConstructionCheckOrdersMapper;
import com.flf.mapper.ConstructionCheckRecordsMapper;
import com.flf.mapper.LetterRecordsMapper;
import com.flf.mapper.TasksJournalMapper;
import com.flf.service.ConstructionCheckOrdersService;
import com.flf.util.Tools;

public class ConstructionCheckOrdersServiceImpl implements ConstructionCheckOrdersService{

	private ConstructionCheckOrdersMapper constructionCheckOrdersMapper;
	private ConstructionCheckRecordsMapper constructionCheckRecordsMapper;
	private TasksJournalMapper tasksJournalMapper;
	private AnnexMapper annexMapper;
	private LetterRecordsMapper letterRecordsMapper;
	
	public LetterRecordsMapper getLetterRecordsMapper() {
		return letterRecordsMapper;
	}

	public void setLetterRecordsMapper(LetterRecordsMapper letterRecordsMapper) {
		this.letterRecordsMapper = letterRecordsMapper;
	}

	public ConstructionCheckRecordsMapper getConstructionCheckRecordsMapper() {
		return constructionCheckRecordsMapper;
	}

	public void setConstructionCheckRecordsMapper(
			ConstructionCheckRecordsMapper constructionCheckRecordsMapper) {
		this.constructionCheckRecordsMapper = constructionCheckRecordsMapper;
	}

	public TasksJournalMapper getTasksJournalMapper() {
		return tasksJournalMapper;
	}

	public void setTasksJournalMapper(TasksJournalMapper tasksJournalMapper) {
		this.tasksJournalMapper = tasksJournalMapper;
	}

	public AnnexMapper getAnnexMapper() {
		return annexMapper;
	}

	public void setAnnexMapper(AnnexMapper annexMapper) {
		this.annexMapper = annexMapper;
	}

	public ConstructionCheckOrdersMapper getConstructionCheckOrdersMapper() {
		return constructionCheckOrdersMapper;
	}

	public void setConstructionCheckOrdersMapper(
			ConstructionCheckOrdersMapper constructionCheckOrdersMapper) {
		this.constructionCheckOrdersMapper = constructionCheckOrdersMapper;
	}

	@Override
	public void closeConstructionCheckOrders(
			ConstructionCheckOrders constructionCheckOrders) {
		if(constructionCheckOrders != null){
			Integer orderState = constructionCheckOrders.getOrderState();
			String closePersonId = constructionCheckOrders.getClosePersonId();
			if(orderState != null && closePersonId != null){
				constructionCheckOrders.setOrderState(0);
				constructionCheckOrders.setCloseTime(new Date());
				constructionCheckOrdersMapper.updateConstructionCheckOrders(constructionCheckOrders);
			}
		}
		return;		
	}

	@Override
	public ConstructionCheckOrders getConstructionCheckOrdersbyId(String orderId) {
		if(Tools.notEmpty(orderId)){
			return constructionCheckOrdersMapper.getConstructionCheckOrdersbyId(orderId);
		}
		return null;
	}

	@Override
	public ConstructionCheckOrders insertConstructionCheckOrders(
			ConstructionCheckOrders constructionCheckOrders) {
		String uuid = UUID.randomUUID().toString();
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		if(constructionCheckOrders != null){
			List<ConstructionCheckRecords> constructionCheckRecordsList = constructionCheckOrders.getConstructionCheckRecords();
			List<Annex> annexList = constructionCheckOrders.getAnnexs();
			List<LetterRecords> letterRecordsList  = constructionCheckOrders.getLetterRecords();
			constructionCheckOrders.setOrderId(uuid);
			constructionCheckOrders.setFinishTime(new Date());
			Integer result = constructionCheckOrdersMapper.insertConstructionCheckOrdersUUID(constructionCheckOrders);
			if(result > 0 && constructionCheckRecordsList != null && constructionCheckRecordsList.size() > 0){
				for(ConstructionCheckRecords constructionCheckRecords : constructionCheckRecordsList){
					constructionCheckRecords.setOrderId(uuid);
					constructionCheckRecordsMapper.insertConstructionCheckRecords(constructionCheckRecords);
				}
				for(LetterRecords letterRecords :letterRecordsList){
					letterRecords.setOrderId(uuid);
					letterRecordsMapper.insertLetterRecords(letterRecords);
				}
				if(annexList != null && annexList.size()>0){
					for(Annex annex : annexList){
						annex.setRelationId(uuid);
						annex.setAnnexTime(date);
						annexMapper.insertAnnex(annex);
					}
				}
				TasksJournal journal = new TasksJournal();
				journal.setTaskId(constructionCheckOrders.getTaskId());
				journal.setCreOrderId(uuid);
				journal.setCreOrderType(constructionCheckOrders.getOrderType());
				journal.setChangeOrderState(constructionCheckOrders.getOrderState());
				journal.setOperatorId(constructionCheckOrders.getOperatorId());
				journal.setRemarks(constructionCheckOrders.getRemarks());
				journal.setOperationTime(date);
				tasksJournalMapper.insertTasksJournal(journal);
				return constructionCheckOrders;
			}
		}
		return null;
	}

	@Override
	public List<ConstructionCheckOrders> listAllConstructionCheckOrders() {
		return constructionCheckOrdersMapper.listAllConstructionCheckOrders();
	}

	@Override
	public void updateConstructionCheckOrders(
			ConstructionCheckOrders constructionCheckOrders) {
		if(constructionCheckOrders!=null){
			constructionCheckOrdersMapper.updateConstructionCheckOrders(constructionCheckOrders);
		}
	}

	@Override
	public ConstructionCheckOrders getConstructionCheckOrdersbyTypeAndTaskId(
			String orderType, String taskId) {
		// TODO Auto-generated method stub
		return constructionCheckOrdersMapper.getConstructionCheckOrdersbyTypeAndTaskId(orderType, taskId);
	}



}
