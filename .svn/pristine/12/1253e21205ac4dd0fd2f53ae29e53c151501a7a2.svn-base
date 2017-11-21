package com.flf.service.impl;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.flf.entity.Annex;
import com.flf.entity.AppealOrders;
import com.flf.entity.TasksJournal;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.AppealOrdersMapper;
import com.flf.mapper.TasksJournalMapper;
import com.flf.service.AppealOrdersService;

public class AppealOrdersServiceImpl implements AppealOrdersService {
	
	private AppealOrdersMapper appealOrdersMapper;
	private TasksJournalMapper tasksJournalMapper;
	private AnnexMapper annexMapper;
	
	
	
	public AppealOrdersMapper getAppealOrdersMapper() {
		return appealOrdersMapper;
	}
	public void setAppealOrdersMapper(AppealOrdersMapper appealOrdersMapper) {
		this.appealOrdersMapper = appealOrdersMapper;
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
	public AppealOrders getAppealOrdersbyId(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void insertAppealOrders(AppealOrders appealOrders) {
		// TODO Auto-generated method stub

		String uuid = UUID.randomUUID().toString();
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()).toString();
		
		if(appealOrders != null){
			
			List<Annex> annexList = appealOrders.getAnnexs();
			appealOrders.setOrderId(uuid);
			appealOrders.setFinishTime(date);
			
			int result = appealOrdersMapper.insertAppealOrdersUUID(appealOrders);
			if(result>0){
				
				//附件信息保存
				if(annexList!=null && annexList.size()>0){
					for(Annex annex :annexList){
						annex.setRelationId(uuid.toString());
						annex.setAnnexTime(date);
						annexMapper.insertAnnex(annex);
					}
				}
				//记录日志信息
				TasksJournal journal = new TasksJournal();
				journal.setTaskId(appealOrders.getTasksId());
				journal.setCreOrderId(appealOrders.getOrderId());
				journal.setCreOrderType(appealOrders.getOrderType());
				journal.setChangeOrderState(appealOrders.getOrderState());
				journal.setOperatorId(appealOrders.getOperatorId());
				journal.setRemarks(appealOrders.getRemarks());
				journal.setOperationTime(date);
				tasksJournalMapper.insertTasksJournal(journal);
				
			}
		}
		return;
		
		
	}
	@Override
	public void updateAppealOrders(AppealOrders appealOrders) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAppealOrders(String orderId) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void closeAppealOrders(AppealOrders appealOrders) {
		// TODO Auto-generated method stub
		if(appealOrders != null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date = sdf.format(new Date());
			Integer orderState = appealOrders.getOrderState();
			String closePersonId = appealOrders.getClosePerson();
			
			if(orderState != null && closePersonId != null){
				appealOrders.setOrderState(0);
				appealOrders.setCloseTime(date);
				appealOrdersMapper.updateAppealOrders(appealOrders);
			}
		}
		return ;
	}
	@Override
	public List<AppealOrders> listAllAppealOrders() {
		// TODO Auto-generated method stub
		return null;
	}

}
