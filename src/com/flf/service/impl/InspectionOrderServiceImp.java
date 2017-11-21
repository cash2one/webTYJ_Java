package com.flf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.flf.entity.InspectionOrder;
import com.flf.entity.ServiceRequest;
import com.flf.entity.Tasks;
import com.flf.mapper.InspectionOrderMapper;
import com.flf.mapper.TasksMapper;
import com.flf.service.InspectionOrderService;

public class InspectionOrderServiceImp implements InspectionOrderService {
	
	@Autowired
	private InspectionOrderMapper inspectionOrderMapper;
	@Autowired
	private TasksMapper tasksMapper;
	
	
	public InspectionOrderMapper getInspectionOrderMapper() {
		return inspectionOrderMapper;
	}


	public void setInspectionOrderMapper(InspectionOrderMapper inspectionOrderMapper) {
		this.inspectionOrderMapper = inspectionOrderMapper;
	}


	@Override
	public void submitInspectionOrder(String orderId) {
		inspectionOrderMapper.submitInspectionOrder(orderId);
		InspectionOrder inspectionOrder = inspectionOrderMapper.getInspectionOrderById(orderId);
		String taskId = inspectionOrder.getTaskId();
		Tasks tasks = new Tasks();
		tasks.setTaskState(2);
		tasksMapper.changeTaskStateById(taskId);
	}

	

}
