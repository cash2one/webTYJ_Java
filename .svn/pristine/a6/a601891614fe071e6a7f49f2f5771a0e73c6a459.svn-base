package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.flf.entity.Annex;
import com.flf.entity.CompensateMethods;
import com.flf.entity.CompensateOwner;
import com.flf.entity.TasksJournal;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.CompensateMethodsMapper;
import com.flf.mapper.CompensateOwnerMapper;
import com.flf.mapper.TasksJournalMapper;
import com.flf.service.CompensateOwnerService;

public class CompensateOwnerServiceImpl implements CompensateOwnerService{

	private CompensateOwnerMapper compensateOwnerMapper;
	private CompensateMethodsMapper compensateMethodsMapper;
	private TasksJournalMapper tasksJournalMapper;
	private AnnexMapper annexMapper;
	
	public TasksJournalMapper getTasksJournalMapper() {
		return tasksJournalMapper;
	}

	public void setTasksJournalMapper(TasksJournalMapper tasksJournalMapper) {
		this.tasksJournalMapper = tasksJournalMapper;
	}

	public CompensateMethodsMapper getCompensateMethodsMapper() {
		return compensateMethodsMapper;
	}

	public void setCompensateMethodsMapper(
			CompensateMethodsMapper compensateMethodsMapper) {
		this.compensateMethodsMapper = compensateMethodsMapper;
	}

	public AnnexMapper getAnnexMapper() {
		return annexMapper;
	}

	public void setAnnexMapper(AnnexMapper annexMapper) {
		this.annexMapper = annexMapper;
	}

	public CompensateOwnerMapper getCompensateOwnerMapper() {
		return compensateOwnerMapper;
	}

	public void setCompensateOwnerMapper(CompensateOwnerMapper compensateOwnerMapper) {
		this.compensateOwnerMapper = compensateOwnerMapper;
	}

	@Override
	public void closeCompensateOwner(CompensateOwner compensateOwner) {
		if(compensateOwner != null){
			Integer orderState = compensateOwner.getOrderState();
			String closePersonId = compensateOwner.getClosePerson();
			if(orderState != null && closePersonId!= null){
				compensateOwner.setOrderState(0);
				compensateOwner.setCloseTime(new Date());
				compensateOwnerMapper.updateCompensateOwner(compensateOwner);
			}
		}
		return;
	}

	@Override
	public void insertCompensateOwner(CompensateOwner compensateOwner) {
		String uuid = UUID.randomUUID().toString();
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		if(compensateOwner!=null && compensateOwner.getCompensateMethods() != null){
			List<CompensateMethods> methods = compensateOwner.getCompensateMethods();
			List<Annex> annexList = compensateOwner.getAnnexs();
			
			compensateOwner.setOrderId(uuid);
			compensateOwner.setFinishTime(new Date());
			int result = compensateOwnerMapper.insertCompensateOwnerUUID(compensateOwner);
			if(result>0 && methods!=null && methods.size()>0){
				for(CompensateMethods method:methods){
					method.setOrderId(uuid);
					compensateMethodsMapper.insertCompensateMethods(method);
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
				journal.setTaskId(compensateOwner.getTaskId());
				journal.setCreOrderId(uuid);
				journal.setCreOrderType(compensateOwner.getOrderType());
				journal.setChangeOrderState(compensateOwner.getOrderState());
				journal.setOperatorId(compensateOwner.getOperatorId());
				journal.setRemarks(compensateOwner.getRemarks());
				journal.setOperationTime(date);
				tasksJournalMapper.insertTasksJournal(journal);
			}
		}
	}

	@Override
	public CompensateOwner getCompensateOwnerbyId(String orderId) {
		return compensateOwnerMapper.getCompensateOwnerbyId(orderId);
	}

}
