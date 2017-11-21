package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.flf.entity.Annex;
import com.flf.entity.LetterRecords;
import com.flf.entity.RenovationCheckOrders;
import com.flf.entity.RenovationCheckRecords;
import com.flf.entity.TasksJournal;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.LetterRecordsMapper;
import com.flf.mapper.RenovationCheckOrdersMapper;
import com.flf.mapper.RenovationCheckRecordsMapper;
import com.flf.mapper.TasksJournalMapper;
import com.flf.service.RenovationCheckOrdersService;
/**
 * 装修核查单实现类
 * @author Administrator
 * 2015/08/18
 */
public class RenovationCheckOrdersServiceImpl implements RenovationCheckOrdersService {
	
	private RenovationCheckOrdersMapper renovationCheckOrdersMapper;
	private RenovationCheckRecordsMapper renovationCheckRecordsMapper;
	private TasksJournalMapper  tasksJournalMapper;
	private AnnexMapper annexMapper;
	private LetterRecordsMapper letterRecordsMapper;

	public LetterRecordsMapper getLetterRecordsMapper() {
		return letterRecordsMapper;
	}

	public void setLetterRecordsMapper(LetterRecordsMapper letterRecordsMapper) {
		this.letterRecordsMapper = letterRecordsMapper;
	}

	public RenovationCheckOrdersMapper getRenovationCheckOrdersMapper() {
		return renovationCheckOrdersMapper;
	}

	public void setRenovationCheckOrdersMapper(
			RenovationCheckOrdersMapper renovationCheckOrdersMapper) {
		this.renovationCheckOrdersMapper = renovationCheckOrdersMapper;
	}

	public RenovationCheckRecordsMapper getRenovationCheckRecordsMapper() {
		return renovationCheckRecordsMapper;
	}

	public void setRenovationCheckRecordsMapper(
			RenovationCheckRecordsMapper renovationCheckRecordsMapper) {
		this.renovationCheckRecordsMapper = renovationCheckRecordsMapper;
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
	public List<RenovationCheckOrders> listAllRenovationCheckOrders() {
		// TODO Auto-generated method stub
		return renovationCheckOrdersMapper.listAllRenovationCheckOrders();
	}

	@Override
	public RenovationCheckOrders insertRenovationCheckOrders(
			RenovationCheckOrders renovationCheckOrders) {
		// TODO Auto-generated method stub
		String uuid = UUID.randomUUID().toString();
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		if(renovationCheckOrders != null){
			List<RenovationCheckRecords> renovationCheckRecordsList = renovationCheckOrders.getRenovationCheckRecords();
			List<LetterRecords> letterRecordsList = renovationCheckOrders.getLetterRecords();
			List<Annex> annexList = renovationCheckOrders.getAnnexs();
			renovationCheckOrders.setOrderId(uuid);
			renovationCheckOrders.setFinishTime(new Date());
			Integer result = renovationCheckOrdersMapper.insertRenovationCheckOrdersUUID(renovationCheckOrders);
			if(result > 0 && renovationCheckRecordsList != null && renovationCheckRecordsList.size() > 0
					&& letterRecordsList != null && letterRecordsList.size() > 0){
				for(RenovationCheckRecords renovationCheckRecords : renovationCheckRecordsList){
					renovationCheckRecords.setOrderId(uuid);
					renovationCheckRecordsMapper.insertRenovationCheckRecords(renovationCheckRecords);
				}
				for(LetterRecords letterRecords : letterRecordsList){
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
				journal.setTaskId(renovationCheckOrders.getTaskId());
				journal.setCreOrderId(uuid);
				journal.setCreOrderType(renovationCheckOrders.getOrderType());
				journal.setChangeOrderState(renovationCheckOrders.getOrderState());
				journal.setOperatorId(renovationCheckOrders.getOperatorId());
				journal.setRemarks(renovationCheckOrders.getRemarks());
				journal.setOperationTime(date);
				tasksJournalMapper.insertTasksJournal(journal);
				return renovationCheckOrders;
			}
		}
		return null;
	}

	@Override
	public RenovationCheckOrders getRenovationCheckOrdersbyId(String orderId) {
		// TODO Auto-generated method stub
		return renovationCheckOrdersMapper.getRenovationCheckOrdersbyId(orderId);
	}

	@Override
	public void updateRenovationCheckOrders(
			RenovationCheckOrders renovationCheckOrders) {
		// TODO Auto-generated method stub
		renovationCheckOrdersMapper.updateRenovationCheckOrders(renovationCheckOrders);
	}

	@Override
	public void closeRenovationCheckOrders(
			RenovationCheckOrders renovationCheckOrders) {
		// TODO Auto-generated method stub
		if(renovationCheckOrders != null){
			Integer orderState = renovationCheckOrders.getOrderState();
			String closePersonId = renovationCheckOrders.getClosePersonId();
			if(orderState != null && closePersonId != null){
				renovationCheckOrders.setOrderState(0);
				renovationCheckOrders.setCloseTime(new Date());
				renovationCheckOrdersMapper.updateRenovationCheckOrders(renovationCheckOrders);
			}
		}
		return;
	}

	@Override
	public RenovationCheckOrders getRenovationCheckOrdersbyTypeAndTaskId(
			String orderType, String taskId) {
		// TODO Auto-generated method stub
		return renovationCheckOrdersMapper.getRenovationCheckOrdersbyTypeAndTaskId(orderType, taskId);
	}



}
