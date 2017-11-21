package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.flf.entity.DecorateAnnex;
import com.flf.entity.DecorateAssociatedRecords;
import com.flf.entity.DecorateComponentRecords;
import com.flf.entity.DecoratePersonnelAssociated;
import com.flf.entity.DecoreateDiscloseInformation;
import com.flf.entity.DecoreateServiceRequestAssociated;
import com.flf.entity.OwnerRenovationApply;
import com.flf.entity.ServiceRequest;
import com.flf.entity.Tasks;
import com.flf.mapper.DecorateAnnexMapper;
import com.flf.mapper.DecorateAssociatedRecordsMapper;
import com.flf.mapper.DecorateComponentRecordsMapper;
import com.flf.mapper.DecoratePersonnelAssociatedMapper;
import com.flf.mapper.DecoreateDiscloseInformationMapper;
import com.flf.mapper.DecoreateServiceRequestAssociatedMapper;
import com.flf.mapper.OwnerRenovationApplyMapper;
import com.flf.mapper.ServiceRequestMapper;
import com.flf.mapper.TasksMapper;
import com.flf.service.OwnerRenovationApplyService;

public class OwnerRenovationApplyServiceImpl implements OwnerRenovationApplyService{

	private OwnerRenovationApplyMapper ownerRenovationApplyMapper;
	private DecorateAssociatedRecordsMapper decorateAssociatedRecordsMapper;
	private DecorateAnnexMapper decorateAnnexMapper;
	private DecorateComponentRecordsMapper decorateComponentRecordsMapper;
	private DecoratePersonnelAssociatedMapper decoratePersonnelAssociatedMapper;
	private DecoreateDiscloseInformationMapper decoreateDiscloseInformationMapper;
	private DecoreateServiceRequestAssociatedMapper decoreateServiceRequestAssociatedMapper;
	private ServiceRequestMapper serviceRequestMapper;
	private TasksMapper tasksMapper;
	
	public DecoreateServiceRequestAssociatedMapper getDecoreateServiceRequestAssociatedMapper() {
		return decoreateServiceRequestAssociatedMapper;
	}

	public void setDecoreateServiceRequestAssociatedMapper(
			DecoreateServiceRequestAssociatedMapper decoreateServiceRequestAssociatedMapper) {
		this.decoreateServiceRequestAssociatedMapper = decoreateServiceRequestAssociatedMapper;
	}

	public TasksMapper getTasksMapper() {
		return tasksMapper;
	}

	public void setTasksMapper(TasksMapper tasksMapper) {
		this.tasksMapper = tasksMapper;
	}

	public ServiceRequestMapper getServiceRequestMapper() {
		return serviceRequestMapper;
	}

	public void setServiceRequestMapper(ServiceRequestMapper serviceRequestMapper) {
		this.serviceRequestMapper = serviceRequestMapper;
	}

	public OwnerRenovationApplyMapper getOwnerRenovationApplyMapper() {
		return ownerRenovationApplyMapper;
	}

	public void setOwnerRenovationApplyMapper(
			OwnerRenovationApplyMapper ownerRenovationApplyMapper) {
		this.ownerRenovationApplyMapper = ownerRenovationApplyMapper;
	}

	public DecorateAssociatedRecordsMapper getDecorateAssociatedRecordsMapper() {
		return decorateAssociatedRecordsMapper;
	}

	public void setDecorateAssociatedRecordsMapper(
			DecorateAssociatedRecordsMapper decorateAssociatedRecordsMapper) {
		this.decorateAssociatedRecordsMapper = decorateAssociatedRecordsMapper;
	}

	public DecorateAnnexMapper getDecorateAnnexMapper() {
		return decorateAnnexMapper;
	}

	public void setDecorateAnnexMapper(DecorateAnnexMapper decorateAnnexMapper) {
		this.decorateAnnexMapper = decorateAnnexMapper;
	}

	public DecorateComponentRecordsMapper getDecorateComponentRecordsMapper() {
		return decorateComponentRecordsMapper;
	}

	public void setDecorateComponentRecordsMapper(
			DecorateComponentRecordsMapper decorateComponentRecordsMapper) {
		this.decorateComponentRecordsMapper = decorateComponentRecordsMapper;
	}

	public DecoratePersonnelAssociatedMapper getDecoratePersonnelAssociatedMapper() {
		return decoratePersonnelAssociatedMapper;
	}

	public void setDecoratePersonnelAssociatedMapper(
			DecoratePersonnelAssociatedMapper decoratePersonnelAssociatedMapper) {
		this.decoratePersonnelAssociatedMapper = decoratePersonnelAssociatedMapper;
	}

	public DecoreateDiscloseInformationMapper getDecoreateDiscloseInformationMapper() {
		return decoreateDiscloseInformationMapper;
	}

	public void setDecoreateDiscloseInformationMapper(
			DecoreateDiscloseInformationMapper decoreateDiscloseInformationMapper) {
		this.decoreateDiscloseInformationMapper = decoreateDiscloseInformationMapper;
	}

	@Override
	public List<OwnerRenovationApply> getAllOwnerRenovationApply() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public OwnerRenovationApply insertOwnerRenovationApply(OwnerRenovationApply ownerRenovationApply) {
		if(ownerRenovationApply !=null){
			
			String uuid = UUID.randomUUID().toString();
			Date date = new Date();
			
			ServiceRequest serviceRequest = ownerRenovationApply.getServiceRequest();
			DecorateAssociatedRecords associatedRecords  = ownerRenovationApply.getDecorateAssociatedRecords();
			List<DecorateAnnex> annexList = ownerRenovationApply.getDecorateAnnexList();
			List<DecorateComponentRecords> componentRecordsList = ownerRenovationApply.getDecorateComponentRecordsList();
			List<DecoratePersonnelAssociated> personnelAssociatedList = ownerRenovationApply.getDecoratePersonnelAssociatedList();
			List<DecoreateDiscloseInformation> discloseInformationList = ownerRenovationApply.getDecoreateDiscloseInformationList();
			
			if(associatedRecords!=null && annexList!=null && componentRecordsList!=null 
					&& personnelAssociatedList!=null && discloseInformationList!=null && serviceRequest!=null){
				
				//装修图纸附件
				if(annexList.size()>0){
					for(DecorateAnnex annex : annexList){
						annex.setApplyId(uuid);
						decorateAnnexMapper.insertDecorateAnnex(annex);
					}
				}
				//装修组件记录表
				if(componentRecordsList.size()>0){
					for(DecorateComponentRecords compoent : componentRecordsList){
						compoent.setApplyId(uuid);
						decorateComponentRecordsMapper.insertDecorateComponentRecords(compoent);
					}
				}
				//装修单位提交资料记录表
				if(discloseInformationList.size()>0){
					for(DecoreateDiscloseInformation discloseInformation : discloseInformationList){
						discloseInformation.setApplyId(uuid);
						decoreateDiscloseInformationMapper.insertDecoreateDiscloseInformation(discloseInformation);
					}
				}
				associatedRecords.setApplyId(uuid);
				decorateAssociatedRecordsMapper.insertDecorateAssociatedRecords(associatedRecords);
				//装修类型 0.自装 1.工装
				if(personnelAssociatedList.size()>0 && ownerRenovationApply.getDecorateType() == 1){
					//装修单位关联记录
				
					//if(decorateAssociatedRecordsMapper.insertDecorateAssociatedRecords(associatedRecords)>0){
						//装修人员关联表
						for(DecoratePersonnelAssociated personnelAssociated : personnelAssociatedList){
							personnelAssociated.setApplyId(uuid);
							decoratePersonnelAssociatedMapper.insertDecoratePersonnelAssociated(personnelAssociated);
						}
					//}
				}
				
				String serviceUUID = UUID.randomUUID().toString();
//				String tasksUUID = UUID.randomUUID().toString();
				Tasks tasks = serviceRequest.getTasks();
//				tasks.setTaskId(tasksUUID);
				tasks.setServerId(serviceUUID);
				tasks.setTaskDescription("业主装修核查");
				tasks.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
				tasks.setTaskState(4);//未接受
				
				serviceRequest.setServiceRequestId(serviceUUID);
				serviceRequest.setRequestTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
				serviceRequest.setServiceRequestState(2);//处理状态
				
				if(serviceRequestMapper.insertServiceRequestUUID(serviceRequest)>0 && tasksMapper.insertTasks(tasks)>0){
					ownerRenovationApply.setApplyId(uuid);
					ownerRenovationApply.setApplyTime(date);
					ownerRenovationApply.setApplyType(2);
					ownerRenovationApply.setServiceId(serviceUUID);
					
					Integer result = ownerRenovationApplyMapper.insertOwnerRenovationApplyUUID(ownerRenovationApply);
					
					if(result>0){
						//将申请id和服务请求id插入服务请求关联表 ts_decoreate_service_request_associated
						DecoreateServiceRequestAssociated dsra = new DecoreateServiceRequestAssociated();
						dsra.setApplyId(uuid);
						dsra.setServiceRequestId(serviceUUID);
						decoreateServiceRequestAssociatedMapper.insertDecoreateServiceRequestAssociated(dsra);
						return ownerRenovationApply;
					}
				}
			}
		}
		return null;
	}

	@Override
	public List<OwnerRenovationApply> getOwnerRenovationApplybyCustId(
			String custId) {
		// TODO Auto-generated method stub
		return ownerRenovationApplyMapper.getOwnerRenovationApplybyId(custId);
	}

	@Override
	public OwnerRenovationApply getOwnerRenovationApplyByServiceId(
			String serviceId) {
		// TODO Auto-generated method stub
		return ownerRenovationApplyMapper.getOwnerRenovationApplyByServiceId(serviceId);
	}
}