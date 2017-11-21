package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.flf.entity.Annex;
import com.flf.entity.LetterRecords;
import com.flf.entity.RenovationAcceptanceOrders;
import com.flf.entity.RenovationAcceptanceRecords;
import com.flf.entity.TasksJournal;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.LetterRecordsMapper;
import com.flf.mapper.RenovationAcceptanceOrdersMapper;
import com.flf.mapper.RenovationAcceptanceRecordsMapper;
import com.flf.mapper.TasksJournalMapper;
import com.flf.service.RenovationAcceptanceOrdersService;

public class RenovationAcceptanceOrdersServiceImpl implements RenovationAcceptanceOrdersService {

	private RenovationAcceptanceOrdersMapper renovationAcceptanceOrdersMapper;
	private RenovationAcceptanceRecordsMapper renovationAcceptanceRecordsMapper;
	private TasksJournalMapper  tasksJournalMapper;
	private AnnexMapper annexMapper;
	private LetterRecordsMapper letterRecordsMapper;
	
	public LetterRecordsMapper getLetterRecordsMapper() {
		return letterRecordsMapper;
	}

	public void setLetterRecordsMapper(LetterRecordsMapper letterRecordsMapper) {
		this.letterRecordsMapper = letterRecordsMapper;
	}

	public RenovationAcceptanceOrdersMapper getRenovationAcceptanceOrdersMapper() {
		return renovationAcceptanceOrdersMapper;
	}

	public void setRenovationAcceptanceOrdersMapper(
			RenovationAcceptanceOrdersMapper renovationAcceptanceOrdersMapper) {
		this.renovationAcceptanceOrdersMapper = renovationAcceptanceOrdersMapper;
	}

	public RenovationAcceptanceRecordsMapper getRenovationAcceptanceRecordsMapper() {
		return renovationAcceptanceRecordsMapper;
	}

	public void setRenovationAcceptanceRecordsMapper(
			RenovationAcceptanceRecordsMapper renovationAcceptanceRecordsMapper) {
		this.renovationAcceptanceRecordsMapper = renovationAcceptanceRecordsMapper;
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

	@Override
	public List<RenovationAcceptanceOrders> listAllRenovationAcceptanceOrders() {
		// TODO Auto-generated method stub
		return renovationAcceptanceOrdersMapper.listAllRenovationAcceptanceOrders();
	}

	@Override
	public RenovationAcceptanceOrders insertRenovationAcceptanceOrders(
			RenovationAcceptanceOrders renovationAcceptanceOrders) {
		// TODO Auto-generated method stub
		String uuid = UUID.randomUUID().toString();
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		if(renovationAcceptanceOrders != null){
			List<RenovationAcceptanceRecords> renovationAcceptanceRecordsList = renovationAcceptanceOrders.getRenovationAcceptanceRecords();
			List<Annex> annexList = renovationAcceptanceOrders.getAnnexs();
			List<LetterRecords> letterRecordsList  = renovationAcceptanceOrders.getLetterRecords();
			renovationAcceptanceOrders.setOrderId(uuid);
			renovationAcceptanceOrders.setFinishTime(new Date());
			Integer result = renovationAcceptanceOrdersMapper.insertRenovationAcceptanceOrdersUUID(renovationAcceptanceOrders);
			if(result > 0 && renovationAcceptanceRecordsList != null && renovationAcceptanceRecordsList.size() > 0
					&& letterRecordsList != null && letterRecordsList.size() >0){
				for(RenovationAcceptanceRecords records : renovationAcceptanceRecordsList){
					records.setOrderId(uuid);
					renovationAcceptanceRecordsMapper.insertRenovationAcceptanceRecords(records);
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
				journal.setTaskId(renovationAcceptanceOrders.getTaskId());
				journal.setCreOrderId(uuid);
				journal.setCreOrderType(renovationAcceptanceOrders.getOrderType());
				journal.setChangeOrderState(renovationAcceptanceOrders.getOrderState());
				journal.setOperatorId(renovationAcceptanceOrders.getOperatorId());
				journal.setRemarks(renovationAcceptanceOrders.getRemarks());
				journal.setOperationTime(date);
				tasksJournalMapper.insertTasksJournal(journal);
				return renovationAcceptanceOrders;
			}
		}
		return null;
	}

	@Override
	public RenovationAcceptanceOrders getRenovationAcceptanceOrdersbyId(
			String orderId) {
		// TODO Auto-generated method stub
		return renovationAcceptanceOrdersMapper.getRenovationAcceptanceOrdersbyId(orderId);
	}

	@Override
	public void updateRenovationAcceptanceOrders(
			RenovationAcceptanceOrders renovationAcceptanceOrders) {
		// TODO Auto-generated method stub
		renovationAcceptanceOrdersMapper.updateRenovationAcceptanceOrders(renovationAcceptanceOrders);
	}

	@Override
	public void closeRenovationAcceptanceOrders(
			RenovationAcceptanceOrders renovationAcceptanceOrders) {
		// TODO Auto-generated method stub
		if(renovationAcceptanceOrders != null){
			Integer orderState = renovationAcceptanceOrders.getOrderState();
			String closePersonId = renovationAcceptanceOrders.getClosePersonId();
			if(orderState != null && closePersonId != null){
				renovationAcceptanceOrders.setOrderState(0);
				renovationAcceptanceOrders.setCloseTime(new Date());
				renovationAcceptanceOrdersMapper.updateRenovationAcceptanceOrders(renovationAcceptanceOrders);
			}
		}
	}

	@Override
	public RenovationAcceptanceOrders getRenovationAcceptanceOrdersbyTypeAndTaskId(
			String orderType, String taskId) {
		// TODO Auto-generated method stub
		return renovationAcceptanceOrdersMapper.getRenovationAcceptanceOrdersbyTypeAndTaskId(orderType, taskId);
	}

}
