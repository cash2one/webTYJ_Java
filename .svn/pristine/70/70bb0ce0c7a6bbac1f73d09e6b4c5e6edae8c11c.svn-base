package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.flf.entity.Annex;
import com.flf.entity.RepairOrders;
import com.flf.entity.TasksJournal;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.RepairOrdersMapper;
import com.flf.mapper.TasksJournalMapper;
import com.flf.service.RepairOrdersService;

public class RepairOrdersServiceImpl implements RepairOrdersService {

	private RepairOrdersMapper repairOrdersMapper;
	
	private TasksJournalMapper tasksJournalMapper;
	
	private AnnexMapper annexMapper;
	
	/**
	 * 查询所有维修单信息
	 */
	@Override
	public List<RepairOrders> listAllRepairOrders() {
		return repairOrdersMapper.listAllRepairOrders();
	}

	//新增维修单
	@Override
	public void insertRepairOrders(RepairOrders repairOrders) {
		String uuid = UUID.randomUUID().toString();
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		if(repairOrders != null){
			repairOrders.setOrderId(uuid);
			repairOrders.setFinishTime(new Date());
			Integer result = repairOrdersMapper.insert(repairOrders);
			List<Annex> annexList = repairOrders.getAnnexs();
			if(annexList != null && annexList.size() > 0){
				for(Annex annex : annexList){
					annex.setRelationId(uuid.toString());
					annex.setAnnexTime(date);
					annexMapper.insertAnnex(annex);
				}
			}
			if(result>0){
				TasksJournal journal = new TasksJournal();
				journal.setTaskId(repairOrders.getTaskId());
				journal.setCreOrderId(uuid);
				journal.setCreOrderType((int)repairOrders.getOrderType());
				journal.setChangeOrderState((int)repairOrders.getOrderState());
				journal.setOperatorId(repairOrders.getOperatorId());
				journal.setRemarks(repairOrders.getRemarks());
				journal.setOperationTime(date);
				tasksJournalMapper.insertTasksJournal(journal);
			}
		}
	}

	/**
	 * 删除维修单
	 */
	@Override
	public void deleteRepairOrders(String orderId) {
		repairOrdersMapper.deleteByPrimaryKey(orderId);
	}

	/**
	 * 根据维修单id查询
	 */
	@Override
	public RepairOrders getRepairOrdersbyId(String orderId) {
		return repairOrdersMapper.selectByPrimaryKey(orderId);
	}

	/**
	 * 修改维修单
	 */
	@Override
	public void updateConsultationOrders(RepairOrders repairOrders) {
		repairOrdersMapper.updateByPrimaryKey(repairOrders);
	}

	/**
	 * 关闭维修单
	 */
	@Override
	public void closeConsultationOrders(RepairOrders repairOrders) {
		if(repairOrders != null){
			Integer orderState = (int)repairOrders.getOrderState();
			String closePersonId = repairOrders.getClosePersonId();
			if(orderState != null && closePersonId != null){
				repairOrders.setOrderState((byte) 0);
				repairOrders.setCloseTime(new Date());
				repairOrdersMapper.updateByPrimaryKey(repairOrders);
			}
		}
	}

	
	
	
	public RepairOrdersMapper getRepairOrdersMapper() {
		return repairOrdersMapper;
	}

	public void setRepairOrdersMapper(RepairOrdersMapper repairOrdersMapper) {
		this.repairOrdersMapper = repairOrdersMapper;
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

}
