package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.flf.entity.Annex;
import com.flf.entity.LetterRecords;
import com.flf.entity.RenovationInspectionOrders;
import com.flf.entity.RenovationInspectionRecords;
import com.flf.entity.TasksJournal;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.LetterRecordsMapper;
import com.flf.mapper.RenovationInspectionOrdersMapper;
import com.flf.mapper.RenovationInspectionRecordsMapper;
import com.flf.mapper.TasksJournalMapper;
import com.flf.service.RenovationInspectionOrdersService;
/**
 * 装修巡检单实现类
 * @author Administrator
 *
 */
public class RenovationInspectionOrdersServiceImpl implements RenovationInspectionOrdersService {

	private RenovationInspectionOrdersMapper renovationInspectionOrdersMapper;
	private RenovationInspectionRecordsMapper renovationInspectionRecordsMapper;
	private TasksJournalMapper  tasksJournalMapper;
	private AnnexMapper annexMapper;
	private LetterRecordsMapper letterRecordsMapper;
	
	public LetterRecordsMapper getLetterRecordsMapper() {
		return letterRecordsMapper;
	}

	public void setLetterRecordsMapper(LetterRecordsMapper letterRecordsMapper) {
		this.letterRecordsMapper = letterRecordsMapper;
	}

	public RenovationInspectionOrdersMapper getRenovationInspectionOrdersMapper() {
		return renovationInspectionOrdersMapper;
	}

	public void setRenovationInspectionOrdersMapper(
			RenovationInspectionOrdersMapper renovationInspectionOrdersMapper) {
		this.renovationInspectionOrdersMapper = renovationInspectionOrdersMapper;
	}

	public RenovationInspectionRecordsMapper getRenovationInspectionRecordsMapper() {
		return renovationInspectionRecordsMapper;
	}

	public void setRenovationInspectionRecordsMapper(
			RenovationInspectionRecordsMapper renovationInspectionRecordsMapper) {
		this.renovationInspectionRecordsMapper = renovationInspectionRecordsMapper;
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
	public List<RenovationInspectionOrders> listAllRenovationInspectionOrders() {
		// TODO Auto-generated method stub
		return renovationInspectionOrdersMapper.listAllRenovationInspectionOrders();
	}

	@Override
	public void insertRenovationInspectionOrders(
			RenovationInspectionOrders renovationInspectionOrders) {
		// TODO Auto-generated method stub
		String uuid = UUID.randomUUID().toString();
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		if(renovationInspectionOrders != null){
			List<RenovationInspectionRecords> renovationInspectionRecordsList = renovationInspectionOrders.getRenovationInspectionRecords();
			List<Annex> annexList = renovationInspectionOrders.getAnnexs();
			List<LetterRecords> letterRecordsList = renovationInspectionOrders.getLetterRecords();
			renovationInspectionOrders.setOrderId(uuid);
			renovationInspectionOrders.setFinishTime(new Date());
			Integer result = renovationInspectionOrdersMapper.insertRenovationInspectionOrdersUUID(renovationInspectionOrders);
			if(result > 0 && renovationInspectionRecordsList != null && renovationInspectionRecordsList.size() > 0
					&& letterRecordsList != null && letterRecordsList.size() > 0){
				for(RenovationInspectionRecords records : renovationInspectionRecordsList){
					records.setOrderId(uuid);
					renovationInspectionRecordsMapper.insertRenovationInspectionRecords(records);
				}
				for(LetterRecords letterRecords : letterRecordsList){
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
				journal.setTaskId(renovationInspectionOrders.getTaskId());
				journal.setCreOrderId(uuid);
				journal.setCreOrderType(renovationInspectionOrders.getOrderType());
				journal.setChangeOrderState(renovationInspectionOrders.getOrderState());
				journal.setOperatorId(renovationInspectionOrders.getOperatorId());
				journal.setRemarks(renovationInspectionOrders.getRemarks());
				journal.setOperationTime(date);
				tasksJournalMapper.insertTasksJournal(journal);
			}
		}
		
	}

	@Override
	public RenovationInspectionOrders getRenovationInspectionOrdersbyId(
			String orderId) {
		// TODO Auto-generated method stub
		return renovationInspectionOrdersMapper.getRenovationInspectionOrdersbyId(orderId);
	}

	@Override
	public void updateRenovationInspectionOrders(
			RenovationInspectionOrders renovationInspectionOrders) {
		// TODO Auto-generated method stub
		renovationInspectionOrdersMapper.updateRenovationInspectionOrders(renovationInspectionOrders);
	}

	@Override
	public void closeRenovationInspectionOrders(
			RenovationInspectionOrders renovationInspectionOrders) {
		// TODO Auto-generated method stub
		if(renovationInspectionOrders != null){
			Integer orderState = renovationInspectionOrders.getOrderState();
			String closePersonId = renovationInspectionOrders.getClosePersonId();
			if(orderState !=null && closePersonId != null){
				renovationInspectionOrders.setOrderState(0);
				renovationInspectionOrders.setCloseTime(new Date());
				renovationInspectionOrdersMapper.updateRenovationInspectionOrders(renovationInspectionOrders);
			}
		}
		return;
	}

	@Override
	public RenovationInspectionOrders getRenovationInspectionOrdersbyTypeAndTaskId(
			String orderType, String taskId) {
		// TODO Auto-generated method stub
		return renovationInspectionOrdersMapper.getRenovationInspectionOrdersbyTypeAndTaskId(orderType, taskId);
	}

}
