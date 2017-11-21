package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.flf.entity.Annex;
import com.flf.entity.DepartmentOrders;
import com.flf.entity.DepartmentRecords;
import com.flf.entity.TasksJournal;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.DepartmentOrdersMapper;
import com.flf.mapper.DepartmentRecordsMapper;
import com.flf.mapper.TasksJournalMapper;
import com.flf.service.DepartmentOrdersService;

public class DepartmentOrdersServiceImpl implements DepartmentOrdersService{

	private DepartmentOrdersMapper departmentOrdersMapper;
	private DepartmentRecordsMapper departmentRecordsMapper;
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

	public DepartmentRecordsMapper getDepartmentRecordsMapper() {
		return departmentRecordsMapper;
	}

	public void setDepartmentRecordsMapper(
			DepartmentRecordsMapper departmentRecordsMapper) {
		this.departmentRecordsMapper = departmentRecordsMapper;
	}

	public DepartmentOrdersMapper getDepartmentOrdersMapper() {
		return departmentOrdersMapper;
	}

	public void setDepartmentOrdersMapper(
			DepartmentOrdersMapper departmentOrdersMapper) {
		this.departmentOrdersMapper = departmentOrdersMapper;
	}

	@Override
	public DepartmentOrders getDepartmentOrdersbyId(String orderId) {
		// TODO Auto-generated method stub
		return departmentOrdersMapper.getDepartmentOrdersbyId(orderId);
	}

	@Override
	public void insertDepartmentOrders(DepartmentOrders departmentOrders) {
		// TODO Auto-generated method stub
		String uuid = UUID.randomUUID().toString();
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		
		if(departmentOrders != null){
			List<DepartmentRecords> drList = departmentOrders.getDepartmentRecordsList();
			List<Annex> annexList = departmentOrders.getAnnexs();
			
			departmentOrders.setOrderId(uuid);
			departmentOrders.setFinishTime(date);
			Integer result = departmentOrdersMapper.insertDepartmentOrdersUUID(departmentOrders);
			
			if(result> 0){
				TasksJournal journal = new TasksJournal();
				journal.setTaskId(departmentOrders.getTasksId());
				journal.setCreOrderId(uuid);
				journal.setCreOrderType(departmentOrders.getOrderType());
				journal.setChangeOrderState(departmentOrders.getOrderState());
				journal.setRemarks(departmentOrders.getRemarks());
				journal.setOperationTime(date);
				if(tasksJournalMapper.insertTasksJournal(journal)>0){
					if(drList!=null){
						for(DepartmentRecords dr : drList){
							dr.setOrderId(uuid);
							dr.setCheckTime(date);
							departmentRecordsMapper.insertDepartmentRecords(dr);
						}
					}
					
					
					//附件信息保存
					if(annexList!=null && annexList.size()>0){
						for(Annex annex :annexList){
							annex.setRelationId(uuid);
							annex.setAnnexTime(date);
							annexMapper.insertAnnex(annex);
						}
					}
				}
			}
		}
	}

	@Override
	public DepartmentOrders getDepartmentOrdersbyTaskId(String taskId) {
		// TODO Auto-generated method stub
		return departmentOrdersMapper.getDepartmentOrdersbyTaskId(taskId);
	}

	@Override
	public void closeDepartmentOrders(DepartmentOrders departmentOrders) {
		String date = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(new Date());
		if(departmentOrders != null){
			Integer orderState = departmentOrders.getOrderState();
			String closePersonId = departmentOrders.getClosePersonId();
			if(orderState != null && closePersonId!= null){
				departmentOrders.setOrderState(0);
				departmentOrders.setCloseTime(date);
				departmentOrdersMapper.updateDepartmentOrders(departmentOrders);
			}
		}
	}

}
