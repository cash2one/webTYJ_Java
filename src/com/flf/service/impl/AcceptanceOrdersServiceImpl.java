package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.PathParam;

import com.flf.entity.AcceptanceOrders;
import com.flf.entity.Annex;
import com.flf.entity.ServiceRequest;
import com.flf.entity.Tasks;
import com.flf.entity.TasksJournal;
import com.flf.mapper.AcceptanceOrdersMapper;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.ServiceRequestMapper;
import com.flf.mapper.TasksJournalMapper;
import com.flf.mapper.TasksMapper;
import com.flf.service.AcceptanceOrdersService;

public class AcceptanceOrdersServiceImpl implements AcceptanceOrdersService {

	private AcceptanceOrdersMapper acceptanceOrdersMapper;
	private TasksJournalMapper tasksJournalMapper;
	private AnnexMapper annexMapper;
	private TasksMapper tasksMapper;
	private ServiceRequestMapper serviceRequestMapper;
	
	public ServiceRequestMapper getServiceRequestMapper() {
		return serviceRequestMapper;
	}

	public void setServiceRequestMapper(ServiceRequestMapper serviceRequestMapper) {
		this.serviceRequestMapper = serviceRequestMapper;
	}

	public TasksMapper getTasksMapper() {
		return tasksMapper;
	}

	public void setTasksMapper(TasksMapper tasksMapper) {
		this.tasksMapper = tasksMapper;
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

	public AcceptanceOrdersMapper getAcceptanceOrdersMapper() {
		return acceptanceOrdersMapper;
	}

	public void setAcceptanceOrdersMapper(
			AcceptanceOrdersMapper acceptanceOrdersMapper) {
		this.acceptanceOrdersMapper = acceptanceOrdersMapper;
	}

	@Override
	public void deleteAcceptanceOrders(String orderId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AcceptanceOrders getAcceptanceOrdersbyId(String orderId) {
		// TODO Auto-generated method stub
		return acceptanceOrdersMapper.getAcceptanceOrdersbyId(orderId);
	}

	@Override
	public void insertAcceptanceOrders(AcceptanceOrders acceptanceOrders) {

//		String uuid = UUID.randomUUID().toString();
//		List<AcceptanceInformationRecords>  acceptanceInformation = acceptanceOrders.getAcceptanceInformation();
//		
//		if(acceptanceOrders != null){
//			acceptanceOrders.setOrderId(uuid);
//			int result = acceptanceOrdersMapper.insertAcceptanceOrdersUUID(acceptanceOrders);
//			if(result>0 && acceptanceInformation.size()>0){
//				for(AcceptanceInformationRecords records : acceptanceInformation){
//					records.setOrderId(uuid);
//					acceptanceInformationRecordsMapper.insertAcceptanceInformationRecords(records);
//				}
//			}
//		}
		
		String uuid = UUID.randomUUID().toString();
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()).toString();
		String serviceRequestId = acceptanceOrders.getServiceRequestId();
		
		if(acceptanceOrders != null){
			
			List<Annex> annexList = acceptanceOrders.getAnnexs();
			acceptanceOrders.setOrderId(uuid);
			acceptanceOrders.setFinishTime(date);
			
			int result = acceptanceOrdersMapper.insertAcceptanceOrdersUUID(acceptanceOrders);
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
				journal.setTaskId(acceptanceOrders.getTaskId());
				journal.setCreOrderId(acceptanceOrders.getOrderId());
				journal.setCreOrderType(acceptanceOrders.getOrderType());
				journal.setChangeOrderState(acceptanceOrders.getOrderState());
				journal.setOperatorId(acceptanceOrders.getOperatorId());
				journal.setRemarks(acceptanceOrders.getRemarks());
				journal.setOperationTime(date);
				tasksJournalMapper.insertTasksJournal(journal);
				
				//修改任务状态为已完成
				int tmp = tasksMapper.finishTasks(acceptanceOrders.getTaskId());
				if(tmp>0){
					//记录日志信息
					TasksJournal journal2 = new TasksJournal();
					journal2.setTaskId(acceptanceOrders.getTaskId());
					journal2.setCreOrderId(acceptanceOrders.getOrderId());
					journal2.setChangeOrderState(acceptanceOrders.getOrderState());
					journal2.setChangeState(2);	
					journal2.setOperatorId(acceptanceOrders.getOperatorId());
					journal2.setRemarks("完成确认");
					journal2.setOperationTime(date);
					tasksJournalMapper.insertTasksJournal(journal2);
				}
				
				List<Tasks> tasksList = new ArrayList<>();
				tasksList = tasksMapper.getTasksbyServiceRequestId(serviceRequestId);
				int i = 0;
				for (; i < tasksList.size(); i++) {
					//任务不等于已完成状态
					if(tasksList.get(i).getTaskState()!=2||tasksList.get(i).getTaskState()!=0){
						break;
					}
				}
				if(i==tasksList.size()){
					ServiceRequest serviceRequest = new ServiceRequest();
					if(serviceRequest.getServiceRequestIds()==null){
						serviceRequest.setServiceRequestIds(new ArrayList<String>());
					}
					serviceRequest.getServiceRequestIds().add(serviceRequestId);
					serviceRequest.setServiceRequestState(1);//待回访
					serviceRequestMapper.changeServiceRequestStateByIds(serviceRequest);
				}
			}
		}
		return;
		
	}
	
	@Override
	public List<AcceptanceOrders> getAcceptanceOrdersbyServiceRequestId(String serviceRequestId){
		List<AcceptanceOrders> acceptanceOrdersList = new ArrayList<>();
		acceptanceOrdersList = acceptanceOrdersMapper.getAcceptanceOrdersbyServiceRequsetId(serviceRequestId);
		//acceptanceOrdersList.add(0, null);
		return acceptanceOrdersList;
	}

	@Override
	public List<AcceptanceOrders> listAllAcceptanceOrders() {
		// TODO Auto-generated method stub
		return acceptanceOrdersMapper.listAllAcceptanceOrders();
	}

	@Override
	public void updateAcceptanceOrders(AcceptanceOrders acceptanceOrders) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void closeAcceptanceOrders(AcceptanceOrders acceptanceOrders) {
		// TODO Auto-generated method stub
		if(acceptanceOrders != null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date = sdf.format(new Date());
			Integer orderState = acceptanceOrders.getOrderState();
			String closePersonId = acceptanceOrders.getClosePerson();
			
			if(orderState != null && closePersonId != null){
				acceptanceOrders.setOrderState(0);
				acceptanceOrders.setCloseTime(date);
				acceptanceOrdersMapper.updateAcceptanceOrders(acceptanceOrders);
			}
		}
		return ;
	}

}
