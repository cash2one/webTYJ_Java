package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.flf.entity.AfterSale;
import com.flf.entity.Annex;
import com.flf.entity.ComponentProperty;
import com.flf.entity.InspectorOrder;
import com.flf.entity.InspectorRecord;
import com.flf.entity.ServiceRequest;
import com.flf.entity.Tasks;
import com.flf.entity.TasksJournal;
import com.flf.mapper.AfterSaleMapper;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.ComponentPropertyMapper;
import com.flf.mapper.InspectorOrderMapper;
import com.flf.mapper.InspectorRecordMapper;
import com.flf.mapper.ServiceRequestMapper;
import com.flf.mapper.TasksJournalMapper;
import com.flf.mapper.TasksMapper;
import com.flf.request.Info;
import com.flf.service.InspectorOrderService;
import com.flf.util.Tools;

public class InspectorOrderServiceImpl implements InspectorOrderService{

	private InspectorOrderMapper inspectorOrderMapper;
	private InspectorRecordMapper inspectorRecordMapper;
	private AnnexMapper annexMapper;
	private TasksJournalMapper tasksJournalMapper;
	private TasksMapper tasksMapper;
	private ServiceRequestMapper serviceRequestMapper;
	private AfterSaleMapper afterSaleMapper;
	private ComponentPropertyMapper componentPropertyMapper;
	
	
	public ComponentPropertyMapper getComponentPropertyMapper() {
		return componentPropertyMapper;
	}

	public void setComponentPropertyMapper(
			ComponentPropertyMapper componentPropertyMapper) {
		this.componentPropertyMapper = componentPropertyMapper;
	}

	public AfterSaleMapper getAfterSaleMapper() {
		return afterSaleMapper;
	}

	public void setAfterSaleMapper(AfterSaleMapper afterSaleMapper) {
		this.afterSaleMapper = afterSaleMapper;
	}

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

	public InspectorRecordMapper getInspectorRecordMapper() {
		return inspectorRecordMapper;
	}

	public void setInspectorRecordMapper(InspectorRecordMapper inspectorRecordMapper) {
		this.inspectorRecordMapper = inspectorRecordMapper;
	}

	public InspectorOrderMapper getInspectorOrderMapper() {
		return inspectorOrderMapper;
	}

	public void setInspectorOrderMapper(InspectorOrderMapper inspectorOrderMapper) {
		this.inspectorOrderMapper = inspectorOrderMapper;
	}

	@Override
	public Info closeInspectorOrder(InspectorOrder inspectorOrder) {
		if(inspectorOrder != null){
			Integer orderState = inspectorOrder.getOrderState();
			String closePersonId = inspectorOrder.getClosePerson();
			if(orderState != null && closePersonId != null){
				inspectorOrder.setOrderState(0);
				inspectorOrder.setCloseTime(new Date());
				inspectorOrderMapper.updateInspectorOrder(inspectorOrder);
				return Tools.msg("关闭操作成功!", true);
			}
		}
		return Tools.msg("关闭操作失败!", false);
	}

	@Override
	public Info insertInspectorOrder(InspectorOrder inspectorOrder) {
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		String uuid = UUID.randomUUID().toString();
		
		if (inspectorOrder != null) {
			List<InspectorRecord> inspectorRecordList = inspectorOrder.getRecordList();
			List<Annex> annexList = inspectorOrder.getAnnexs();
			String taskId = inspectorOrder.getTaskId();
			Tasks tasks = tasksMapper.getTasksbyId(taskId);	
			ServiceRequest serviceRequest = serviceRequestMapper.getServiceRequest(tasks.getServerId());
			
			inspectorOrder.setOrderId(uuid);
			inspectorOrder.setFinishTime(new Date());
			int result = inspectorOrderMapper
					.insertInspectorOrderUUID(inspectorOrder);
			if (result > 0 && inspectorRecordList.size() > 0) {
				for (InspectorRecord record : inspectorRecordList) {
					record.setOrderId(uuid);
					// 检验项是异常并且未过保修期才可以转售后
					if (record.getCheckItemsNormal() != null && record.getGuaranteePeriod() != null
							&& record.getCheckItemsNormal() == 0 && record.getGuaranteePeriod() == 1) {
						AfterSale afterSale = new AfterSale();
						
						afterSale.setHomeId(tasks.getAddressId());
						afterSale.setClientId(tasks.getCustomerId());
						afterSale.setSource(serviceRequest.getRequestSource());
						afterSale.setDescribe(record.getRemarks());
						afterSale.setPropertyId(record.getCheckItemsId());
						afterSale.setOrderId(uuid);
						afterSale.setOrderType(inspectorOrder.getOrderType());
						afterSaleMapper.insertAfterSale(afterSale);
					}
					inspectorRecordMapper.insertInspectorRecord(record);
				}
			}

			// 附件信息保存
			if (annexList != null && annexList.size() > 0) {
				for (Annex annex : annexList) {
					annex.setRelationId(uuid);
					annex.setAnnexTime(date);
					annexMapper.insertAnnex(annex);
				}
			}

			TasksJournal journal = new TasksJournal();
			journal.setTaskId(inspectorOrder.getTaskId());
			journal.setCreOrderId(uuid);
			journal.setCreOrderType(inspectorOrder.getOrderType());
			journal.setChangeOrderState(inspectorOrder.getOrderState());
			journal.setOperatorId(inspectorOrder.getCreatePersonId());
			journal.setRemarks(inspectorOrder.getRemarks());
			journal.setOperationTime(date);
			tasksJournalMapper.insertTasksJournal(journal);
			return Tools.msg("添加成功!", true);
		}
		return Tools.msg("添加失败!", false);
	}

	@Override
	public List<InspectorOrder> getAllInspectorOrder() {
		return inspectorOrderMapper.listAllInspectorOrder();
	}

	@Override
	public InspectorOrder getInspectorOrderbyId(String orderId) {
		return inspectorOrderMapper.getInspectorOrderbyId(orderId);
	}
	
	@Override
	public List<ComponentProperty> getInspectorOrderBySRId(String buildingStructureId){
		List<ComponentProperty> componentProperties = componentPropertyMapper.getComponentPropertyByBSId(buildingStructureId);
		return componentProperties;
	}

	@Override
	public InspectorOrder getInspectorOrderBytaskId(String taskId) {
		// TODO Auto-generated method stub
		return inspectorOrderMapper.getInspectorOrderBytaskId(taskId);
	}



}
