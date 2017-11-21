package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.flf.entity.Annex;
import com.flf.entity.ClaimToCustomerOrders;
import com.flf.entity.ClaimToCustomerRethods;
import com.flf.entity.TasksJournal;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.ClaimToCustomerOrdersMapper;
import com.flf.mapper.ClaimToCustomerRethodsMapper;
import com.flf.mapper.TasksJournalMapper;
import com.flf.request.Info;
import com.flf.service.ClaimToCustomerOrdersService;
import com.flf.util.Tools;

public class ClaimToCustomerOrdersServiceImpl implements ClaimToCustomerOrdersService{

	private ClaimToCustomerOrdersMapper claimToCustomerOrdersMapper;
	private ClaimToCustomerRethodsMapper claimToCustomerRethodsMapper;
	private AnnexMapper annexMapper;
	private TasksJournalMapper tasksJournalMapper;
	
	
	public ClaimToCustomerOrdersMapper getClaimToCustomerOrdersMapper() {
		return claimToCustomerOrdersMapper;
	}

	public void setClaimToCustomerOrdersMapper(
			ClaimToCustomerOrdersMapper claimToCustomerOrdersMapper) {
		this.claimToCustomerOrdersMapper = claimToCustomerOrdersMapper;
	}

	public ClaimToCustomerRethodsMapper getClaimToCustomerRethodsMapper() {
		return claimToCustomerRethodsMapper;
	}

	public void setClaimToCustomerRethodsMapper(
			ClaimToCustomerRethodsMapper claimToCustomerRethodsMapper) {
		this.claimToCustomerRethodsMapper = claimToCustomerRethodsMapper;
	}

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

	@Override
	public void closeClaimToCustomerOrders(
			ClaimToCustomerOrders claimToCustomerOrders) {
		if(claimToCustomerOrders != null){
			Integer orderState = claimToCustomerOrders.getOrderState();
			String closePersonId = claimToCustomerOrders.getClosePersonId();
			if(Tools.notEmpty(closePersonId) && orderState!=null){
				claimToCustomerOrders.setOrderState(0);
				claimToCustomerOrders.setCloseTime(new Date());
				claimToCustomerOrdersMapper.updateClaimToCustomerOrders(claimToCustomerOrders);
			}
		}
	}

	@Override
	public ClaimToCustomerOrders getClaimToCustomerOrdersbyId(String orderId) {
		if(Tools.notEmpty(orderId)){
			return claimToCustomerOrdersMapper.getClaimToCustomerOrdersbyId(orderId);
		}
		return null;
	}

	@Override
	public Info insertClaimToCustomerOrders(
			ClaimToCustomerOrders claimToCustomerOrders) {
		String uuid = UUID.randomUUID().toString();
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		
		if(claimToCustomerOrders != null){
			ClaimToCustomerRethods rethod = claimToCustomerOrders.getClaimToCustomerRethods();
			List<Annex> annexList = claimToCustomerOrders.getAnnexs();
			
			claimToCustomerOrders.setOrderId(uuid);
			claimToCustomerOrders.setFinishTime(new Date());
			if(claimToCustomerOrdersMapper.insertClaimToCustomerOrdersUUID(claimToCustomerOrders)>0 && rethod!=null){
				rethod.setOrderId(uuid);
				claimToCustomerRethodsMapper.insertClaimToCustomerRethods(rethod);
				
				//附件信息保存
				if(annexList!=null && annexList.size()>0){
					for(Annex annex :annexList){
						annex.setRelationId(uuid);
						annex.setAnnexTime(date);
						annexMapper.insertAnnex(annex);
					}
				}
				
				TasksJournal journal = new TasksJournal();
				journal.setTaskId(claimToCustomerOrders.getTaskId());
				journal.setCreOrderId(uuid);
				journal.setCreOrderType(claimToCustomerOrders.getOrderType());
				journal.setChangeOrderState(claimToCustomerOrders.getOrderState());
				journal.setOperatorId(claimToCustomerOrders.getOperatorId());
				journal.setRemarks(claimToCustomerOrders.getRemarks());
				journal.setOperationTime(date);
				tasksJournalMapper.insertTasksJournal(journal);
				return Tools.msg("创建成功!", true);
			}
			return Tools.msg("添加数据失败或记录信息为空!", false);
		}
		return Tools.msg("创建失败!", false);
	}

	@Override
	public void updateClaimToCustomerOrders(
			ClaimToCustomerOrders claimToCustomerOrders) {
		claimToCustomerOrdersMapper.updateClaimToCustomerOrders(claimToCustomerOrders);
	}
	
	@Override
	public List<ClaimToCustomerOrders> getClaimToCustomerOrders() {
		// TODO Auto-generated method stub
		return claimToCustomerOrdersMapper.getClaimToCustomerOrders();
	}


}
