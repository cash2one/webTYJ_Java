package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.flf.entity.Annex;
import com.flf.entity.FixedParkingOrders;
import com.flf.entity.TasksJournal;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.FixedParkingOrdersMapper;
import com.flf.mapper.TasksJournalMapper;
import com.flf.service.FixedParkingOrdersService;

public class FixedParkingOrdersServiceImpl implements FixedParkingOrdersService {
	
	private FixedParkingOrdersMapper fixedParkingOrdersMapper;
	private TasksJournalMapper tasksJournalMapper;
	private AnnexMapper annexMapper; 

	public FixedParkingOrdersMapper getFixedParkingOrdersMapper() {
		return fixedParkingOrdersMapper;
	}

	public void setFixedParkingOrdersMapper(
			FixedParkingOrdersMapper fixedParkingOrdersMapper) {
		this.fixedParkingOrdersMapper = fixedParkingOrdersMapper;
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
	public List<FixedParkingOrders> listAllFixedParkingOrders() {
		// TODO Auto-generated method stub
		return fixedParkingOrdersMapper.listAllFixedParkingOrders();
	}

	@Override
	public void insertFixedParkingOrders(FixedParkingOrders fixedParkingOrders) {
		// TODO Auto-generated method stub
		String uuid = UUID.randomUUID().toString();
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		if(fixedParkingOrders != null){
			List<Annex> annexList = fixedParkingOrders.getAnnexs();
			fixedParkingOrders.setOrderId(uuid);
			fixedParkingOrders.setFinishTime(new Date());
			Integer result = fixedParkingOrdersMapper.insertFixedParkingOrdersUUID(fixedParkingOrders);
			if(result>0){
				//附件保存
				if(annexList != null && annexList.size()>0){
					for(Annex annex : annexList){
						annex.setRelationId(uuid);
						annex.setAnnexTime(date);
						annexMapper.insertAnnex(annex);
					}
				}
				TasksJournal journal = new TasksJournal();
				journal.setTaskId(fixedParkingOrders.getTaskId());
				journal.setCreOrderId(uuid);
				journal.setCreOrderType(fixedParkingOrders.getOrderType());
				journal.setChangeOrderState(fixedParkingOrders.getOrderState());
				journal.setOperatorId(fixedParkingOrders.getOperatorId());
				journal.setRemarks(fixedParkingOrders.getRemarks());
				journal.setOperationTime(date);
				tasksJournalMapper.insertTasksJournal(journal);
			}
		}
	}

	@Override
	public void deleteFixedParkingOrders(String orderId) {
		// TODO Auto-generated method stub
		fixedParkingOrdersMapper.deleteFixedParkingOrders(orderId);
	}

	@Override
	public FixedParkingOrders getFixedParkingOrdersbyId(String orderId) {
		// TODO Auto-generated method stub
		return fixedParkingOrdersMapper.getFixedParkingOrdersbyId(orderId);
	}

	@Override
	public void updateFixedParkingOrders(FixedParkingOrders fixedParkingOrders) {
		// TODO Auto-generated method stub
		fixedParkingOrdersMapper.updateFixedParkingOrders(fixedParkingOrders);
	}

	@Override
	public void closeFixedParkingOrders(FixedParkingOrders fixedParkingOrders) {
		// TODO Auto-generated method stub
		if(fixedParkingOrders != null){
			Integer orderState = fixedParkingOrders.getOrderState();
			String closePersonId = fixedParkingOrders.getClosePersonId();
			if(orderState != null && closePersonId !=null){
				fixedParkingOrders.setOrderState(0);
				fixedParkingOrders.setCloseTime(new Date());
				fixedParkingOrdersMapper.updateFixedParkingOrders(fixedParkingOrders);
			}
		}
	}

}
