package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.jws.WebService;

import com.flf.entity.ReturnVisitOrders;
import com.flf.entity.TasksJournal;
import com.flf.mapper.ReturnVisitOrdersMapper;
import com.flf.mapper.TasksJournalMapper;
import com.flf.service.ReturnVisitOrdersService;

@WebService
public class ReturnVisitOrdersServiceImpl implements ReturnVisitOrdersService {
	private ReturnVisitOrdersMapper returnVisitOrdersMapper;
	private TasksJournalMapper tasksJournalMapper;

	public ReturnVisitOrdersMapper getReturnVisitOrdersMapper() {
		return returnVisitOrdersMapper;
	}

	public void setReturnVisitOrdersMapper(
			ReturnVisitOrdersMapper returnVisitOrdersMapper) {
		this.returnVisitOrdersMapper = returnVisitOrdersMapper;
	}

	public TasksJournalMapper getTasksJournalMapper() {
		return tasksJournalMapper;
	}

	public void setTasksJournalMapper(TasksJournalMapper tasksJournalMapper) {
		this.tasksJournalMapper = tasksJournalMapper;
	}

	@Override
	public void deleteReturnVisitOrders(String orderId) {
		// TODO Auto-generated method stub
		returnVisitOrdersMapper.deleteReturnVisitOrders(orderId);
	}

	@Override
	public void insertReturnVisitOrders(ReturnVisitOrders returnVisitOrders) {
		
		String uuid = UUID.randomUUID().toString();
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()).toString();
		
		if(returnVisitOrders != null){
			
	
			returnVisitOrders.setOrderId(uuid);
			returnVisitOrders.setFinishTime(date);
			
			int result = returnVisitOrdersMapper.insertReturnVisitOrdersUUID(returnVisitOrders);
			if(result>0){
			
				//记录日志信息
				TasksJournal journal = new TasksJournal();
				journal.setTaskId(returnVisitOrders.getTaskId());
				journal.setCreOrderId(returnVisitOrders.getOrderId());
				journal.setCreOrderType(returnVisitOrders.getOrderType());
				journal.setChangeOrderState(returnVisitOrders.getOrderState());
				journal.setOperatorId(returnVisitOrders.getOperatorId());
				journal.setRemarks(returnVisitOrders.getRemarks());
				journal.setOperationTime(date);
				tasksJournalMapper.insertTasksJournal(journal);
			}
		}
		return;
		
	}

	@Override
	public void updateReturnVisitOrders(ReturnVisitOrders returnVisitOrders) {
		// TODO Auto-generated method stub
		returnVisitOrdersMapper.updateReturnVisitOrders(returnVisitOrders);
	}

	@Override
	public void closeReturnVisitOrders(ReturnVisitOrders returnVisitOrders) {
		// TODO Auto-generated method stub
		if(returnVisitOrders != null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date = sdf.format(new Date());
			Integer orderState = returnVisitOrders.getOrderState();
			String closePersonId = returnVisitOrders.getClosePerson();
			
			if(orderState != null && closePersonId != null){
				returnVisitOrders.setOrderState(0);
				returnVisitOrders.setCloseTime(date);
				returnVisitOrdersMapper.updateReturnVisitOrders(returnVisitOrders);
			}
		}
		return ;
	}

	public void insertReturnVisitOrdersUUID(ReturnVisitOrders returnVisitOrders) {
		// TODO Auto-generated method stub
		returnVisitOrdersMapper.insertReturnVisitOrdersUUID(returnVisitOrders);
	}

	@Override
	public ReturnVisitOrders getReturnVisitOrdersbyId(String orderId) {
		// TODO Auto-generated method stub
		return returnVisitOrdersMapper.getReturnVisitOrdersbyId(orderId);
	}

	public ReturnVisitOrders getReturnVisitOrdersbyOrderId(String orderId) {
		// TODO Auto-generated method stub
		return returnVisitOrdersMapper.getReturnVisitOrdersbyOrderId(orderId);
	}

	@Override
	public List<ReturnVisitOrders> listAllReturnVisitOrders() {
		// TODO Auto-generated method stub
		return returnVisitOrdersMapper.listAllReturnVisitOrders();
	}

}
