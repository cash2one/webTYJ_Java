package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.flf.entity.ClosedOrders;
import com.flf.entity.TasksJournal;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.ClosedMapper;
import com.flf.mapper.TasksJournalMapper;
import com.flf.service.ClosedOrdersService;

public class ClosedOrdersServiceImpl implements ClosedOrdersService {
	
	private ClosedMapper closedMapper;
	private TasksJournalMapper tasksJournalMapper;
	private AnnexMapper annexMapper;
	
	
	public ClosedMapper getClosedMapper() {
		return closedMapper;
	}

	public void setClosedMapper(ClosedMapper closedMapper) {
		this.closedMapper = closedMapper;
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
	public List<ClosedOrders> listAllClosedOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClosedOrders getClosedOrdersbyId(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertClosedOrders(ClosedOrders closedOrders) {
		// TODO Auto-generated method stub

		String uuid = UUID.randomUUID().toString();
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()).toString();
		
		if(closedOrders != null){
			closedOrders.setOrderId(uuid);
			closedOrders.setFinishTime(date);
			
			int result = closedMapper.insertClosedOrdersUUID(closedOrders);
			if(result>0){
				//记录日志信息
				TasksJournal journal = new TasksJournal();
				journal.setTaskId(closedOrders.getTasksId());
				journal.setCreOrderId(closedOrders.getOrderId());
				journal.setCreOrderType(closedOrders.getOrderType());
				journal.setChangeOrderState(closedOrders.getOrderState());
				journal.setOperatorId(closedOrders.getOperatorId());
				journal.setRemarks(closedOrders.getRemarks());
				journal.setOperationTime(date);
				tasksJournalMapper.insertTasksJournal(journal);
			}
		}
		return;

	}

	@Override
	public void updateClosedOrders(ClosedOrders closedOrders) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteClosedOrders(String orderId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeClosedOrders(ClosedOrders closedOrders) {
		// TODO Auto-generated method stub
		if(closedOrders != null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date = sdf.format(new Date());
			Integer orderState = closedOrders.getOrderState();
			String closePersonId = closedOrders.getClosePerson();
			
			if(orderState != null && closePersonId != null){
				closedOrders.setOrderState(0);
				closedOrders.setCloseTime(date);
				closedMapper.updateClosedOrders(closedOrders);
			}
		}
		

	}

}
