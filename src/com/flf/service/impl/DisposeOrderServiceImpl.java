package com.flf.service.impl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.jws.WebService;

import com.flf.entity.Annex;
import com.flf.entity.DisposeInformationRecords;
import com.flf.entity.DisposeOrder;
import com.flf.entity.TasksJournal;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.DisposeInformationRecordsMapper;
import com.flf.mapper.DisposeOrderMapper;
import com.flf.mapper.TasksJournalMapper;
import com.flf.service.DisposeOrderService;
/**
 * 处理工单表
 * 创建人：邵政
 * 创建时间：2015/6/24
 */
@WebService
public class DisposeOrderServiceImpl implements DisposeOrderService {
	
	private DisposeOrderMapper disposeOrderMapper;
	private DisposeInformationRecordsMapper disposeInformationRecordsMapper;
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

	public DisposeInformationRecordsMapper getDisposeInformationRecordsMapper() {
		return disposeInformationRecordsMapper;
	}

	public void setDisposeInformationRecordsMapper(
			DisposeInformationRecordsMapper disposeInformationRecordsMapper) {
		this.disposeInformationRecordsMapper = disposeInformationRecordsMapper;
	}

	public DisposeOrderMapper getDisposeOrderMapper() {
		return disposeOrderMapper;
	}

	public void setDisposeOrderMapper(DisposeOrderMapper disposeOrderMapper) {
		this.disposeOrderMapper = disposeOrderMapper;
	}

	@Override
	public List<DisposeOrder> listPageDisposeOrder(
			DisposeOrder disposeOrder) {
		// TODO Auto-generated method stub
		return disposeOrderMapper.listPageDisposeOrder(disposeOrder);
	}

	@Override
	public List<DisposeOrder> listAllDisposeOrder() {
		// TODO Auto-generated method stub
		return disposeOrderMapper.listAllDisposeOrder();
	}

	@Override
	public DisposeOrder getDisposeOrderbyId(String orderId) {
		// TODO Auto-generated method stub
		return disposeOrderMapper.getDisposeOrderbyId(orderId);
	}

	@Override
	public void insertDisposeOrder(DisposeOrder disposeOrder) {
		
		UUID uuid = UUID.randomUUID();
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		
		if(disposeOrder != null){
			disposeOrder.setOrderType(1);
			List<DisposeInformationRecords> informationRecords = disposeOrder.getInformationRecords();
			List<Annex> annexList = disposeOrder.getAnnexs();
			
			disposeOrder.setOrderId(uuid.toString());
			int result = disposeOrderMapper.insertDisposeOrderUUID(disposeOrder);
			if(result>0 && informationRecords.size()>0){
				for(DisposeInformationRecords records : informationRecords){
					records.setRecordId(UUID.randomUUID().toString());
					records.setOrderId(uuid.toString());
					disposeInformationRecordsMapper.insertDisposeInformationRecords(records);
				}
				
				//附件信息保存
				if(annexList!=null && annexList.size()>0){
					for(Annex annex :annexList){
						annex.setRelationId(uuid.toString());
						annex.setAnnexTime(date);
						annexMapper.insertAnnex(annex);
					}
				}
				
				TasksJournal journal = new TasksJournal();
				journal.setTaskId(disposeOrder.getTaskId());
				journal.setCreOrderId(uuid.toString());
				journal.setCreOrderType(disposeOrder.getOrderType());
				journal.setChangeOrderState(disposeOrder.getOrderState());
				journal.setOperatorId(disposeOrder.getOperatorId());
				journal.setRemarks(disposeOrder.getRemarks());
				journal.setOperationTime(date);
				tasksJournalMapper.insertTasksJournal(journal);
			}
		}
		return;
	}

	@Override
	public void updateDisposeOrder(DisposeOrder disposeOrder) {
		// TODO Auto-generated method stub
		disposeOrderMapper.updateDisposeOrder(disposeOrder);
	}

	@Override
	public void deleteDisposeOrder(String orderId) {
		// TODO Auto-generated method stub
		disposeOrderMapper.deleteDisposeOrder(orderId);
	}

	@Override
	public void closeDisposeOrder(DisposeOrder disposeOrder) {
		// TODO Auto-generated method stub
		if(disposeOrder != null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date = sdf.format(new Date());
			Integer orderState = disposeOrder.getOrderState();
			String closePersonId = disposeOrder.getClosePerson();
			
			//关闭操作
			//if(orderState != null && closePersonId!=null){
				disposeOrder.setOrderState(0);
				disposeOrder.setCloseTime(date);
				disposeOrderMapper.updateDisposeOrder(disposeOrder);
			//}
		}
		return;
	}
}
