package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.flf.entity.Annex;
import com.flf.entity.ComplaintOrders;
import com.flf.entity.TasksJournal;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.ComplaintOrdersMapper;
import com.flf.mapper.TasksJournalMapper;
import com.flf.service.ComplaintOrdersService;

/**
 * 投诉工单表实现类
 * 创建人：倪明
 * 创建时间：2015/8/11
 */
public class ComplaintOrdersServiceImpl implements ComplaintOrdersService{
	
	private ComplaintOrdersMapper complaintOrdersMapper;
	private TasksJournalMapper tasksJournalMapper;
	private AnnexMapper annexMapper;

	public TasksJournalMapper getTasksJournalMapper() {
		return tasksJournalMapper;
	}

	public void setTasksJournalMapper(TasksJournalMapper tasksJournalMapper) {
		this.tasksJournalMapper = tasksJournalMapper;
	}

	public ComplaintOrdersMapper getComplaintOrdersMapper() {
		return complaintOrdersMapper;
	}

	public void setComplaintOrdersMapper(ComplaintOrdersMapper complaintOrdersMapper) {
		this.complaintOrdersMapper = complaintOrdersMapper;
	}

	public AnnexMapper getAnnexMapper() {
		return annexMapper;
	}

	public void setAnnexMapper(AnnexMapper annexMapper) {
		this.annexMapper = annexMapper;
	}

	@Override
	public List<ComplaintOrders> listAllComplaintOrders() {
		// TODO Auto-generated method stub
		return complaintOrdersMapper.listAllComplaintOrders();
	}

	@Override
	public ComplaintOrders getComplaintOrdersbyId(String orderId) {
		// TODO Auto-generated method stub
		return complaintOrdersMapper.getComplaintOrdersbyId(orderId);
	}

	@Override
	public void insertComplaintOrders(ComplaintOrders complaintOrders) {
		// TODO Auto-generated method stub
		String uuid = UUID.randomUUID().toString();
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		if(complaintOrders != null){
			List<Annex> annexList = complaintOrders.getAnnexs();
			complaintOrders.setOrderId(uuid);
			complaintOrders.setFinishTime(new Date());
			Integer result = complaintOrdersMapper.insertComplaintOrdersUUID(complaintOrders);
			if(result>0){
				//附件信息保存
				if(annexList != null && annexList.size()>0){
					for(Annex annex : annexList){
						annex.setRelationId(uuid);
						annex.setAnnexTime(date);
						annexMapper.insertAnnex(annex);
					}
				}
				TasksJournal journal = new TasksJournal();
				journal.setTaskId(complaintOrders.getTaskId());
				journal.setCreOrderId(uuid);
				journal.setCreOrderType(complaintOrders.getOrderType());
				journal.setChangeOrderState(complaintOrders.getOrderState());
				journal.setOperatorId(complaintOrders.getOperatorId());
				journal.setRemarks(complaintOrders.getRemarks());
				journal.setOperationTime(date);
				tasksJournalMapper.insertTasksJournal(journal);
			}
		}
	}

	@Override
	public void updateComplaintOrders(ComplaintOrders complaintOrders) {
		// TODO Auto-generated method stub
		complaintOrdersMapper.updateComplaintOrders(complaintOrders);
	}

	@Override
	public void deleteComplaintOrders(String orderId) {
		// TODO Auto-generated method stub
		complaintOrdersMapper.deleteComplaintOrders(orderId);
	}

	@Override
	public void closeComplaintOrders(ComplaintOrders complaintOrders) {
		// TODO Auto-generated method stub
		if(complaintOrders != null){
			Integer orderState = complaintOrders.getOrderState();
			String closePersonId = complaintOrders.getClosePersonId();
			if(orderState != null && closePersonId != null){
				complaintOrders.setOrderState(0);
				complaintOrders.setCloseTime(new Date());
				complaintOrdersMapper.updateComplaintOrders(complaintOrders);
			}
		}
		return;
	}

}
