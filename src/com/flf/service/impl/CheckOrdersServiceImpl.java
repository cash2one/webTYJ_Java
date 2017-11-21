package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.flf.entity.Annex;
import com.flf.entity.CheckItemRecords;
import com.flf.entity.CheckOrders;
import com.flf.entity.TasksJournal;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.CheckItemRecordsMapper;
import com.flf.mapper.CheckOrdersMapper;
import com.flf.mapper.TasksJournalMapper;
import com.flf.service.CheckOrdersService;

/**
 * 检测单
 * @author 邵政
 *	2015-6-30
 */

public class CheckOrdersServiceImpl implements CheckOrdersService{
	
	private CheckOrdersMapper checkOrdersMapper;
	private CheckItemRecordsMapper checkItemRecordsMapper;
	private TasksJournalMapper tasksJournalMapper;
	private AnnexMapper annexMapper;
	
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

	public CheckItemRecordsMapper getCheckItemRecordsMapper() {
		return checkItemRecordsMapper;
	}

	public void setCheckItemRecordsMapper(
			CheckItemRecordsMapper checkItemRecordsMapper) {
		this.checkItemRecordsMapper = checkItemRecordsMapper;
	}

	public CheckOrdersMapper getCheckOrdersMapper() {
		return checkOrdersMapper;
	}

	public void setCheckOrdersMapper(CheckOrdersMapper checkOrdersMapper) {
		this.checkOrdersMapper = checkOrdersMapper;
	}

	@Override
	public void deleteCheckOrders(String orderId) {
		// TODO Auto-generated method stub
		checkOrdersMapper.deleteCheckOrders(orderId);
	}

	@Override
	public CheckOrders getCheckOrdersbyId(String orderId) {
		// TODO Auto-generated method stub
		return checkOrdersMapper.getCheckOrdersbyId(orderId);
	}

	@Override
	public void insertCheckOrders(CheckOrders checkOrders) {
		// TODO Auto-generated method stub
		
		String uuid = UUID.randomUUID().toString();
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		
		if(checkOrders != null){
			List<CheckItemRecords> itemRecords = checkOrders.getCheckItemRecords();
			List<Annex> annexList = checkOrders.getAnnexs();
			
			checkOrders.setOrderId(uuid);
			checkOrders.setFinishTime(date);
			Integer result = checkOrdersMapper.insertCheckOrdersUUID(checkOrders);
			if(result > 0 && itemRecords!= null && itemRecords.size()>0){
				for(CheckItemRecords checkItemRecords : itemRecords){
					checkItemRecords.setOrderId(uuid);
					checkItemRecordsMapper.insertCheckItemRecords(checkItemRecords);
				}
				
				//附件信息保存
				if(annexList!=null && annexList.size()>0){
					for(Annex annex :annexList){
						annex.setRelationId(uuid);
						annex.setAnnexTime(date);
						annexMapper.insertAnnex(annex);
					}
				}
				
				TasksJournal journal = new TasksJournal();
				journal.setTaskId(checkOrders.getTaskId());
				journal.setCreOrderId(uuid);
				journal.setCreOrderType(checkOrders.getOrderType());
				journal.setChangeOrderState(checkOrders.getOrderState());
				journal.setOperatorId(checkOrders.getOperatorId());
				journal.setRemarks(checkOrders.getRemarks());
				journal.setOperationTime(date);
				tasksJournalMapper.insertTasksJournal(journal);
			}
		}
		return;
	}

	@Override
	public List<CheckOrders> listAllCheckOrders() {
		// TODO Auto-generated method stub
		return checkOrdersMapper.listAllCheckOrders();
	}

	@Override
	public void updateCheckOrders(CheckOrders checkOrders) {
		// TODO Auto-generated method stub
		checkOrdersMapper.updateCheckOrders(checkOrders);
	}

	@Override
	public void closeCheckOrders(CheckOrders checkOrders) {
		// TODO Auto-generated method stub
		if(checkOrders != null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date = sdf.format(new Date());
			Integer orderState = checkOrders.getOrderState();
			String closePersonId = checkOrders.getClosePerson();
			if(orderState != null && closePersonId != null){
				checkOrders.setOrderState(0);
				checkOrders.setCloseTime(date);
				checkOrdersMapper.updateCheckOrders(checkOrders);
			}
		}
		return;
	}
	
}
