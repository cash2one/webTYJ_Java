package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.flf.entity.ConstructionAnnex;
import com.flf.entity.ConstructionAssociatedRecord;
import com.flf.entity.ConstructionComponentRecords;
import com.flf.entity.ConstructionDiscloseInformation;
import com.flf.entity.ConstructionPersonnelAssociated;
import com.flf.entity.ConstructionServiceRequestAssociated;
import com.flf.entity.OwnerConstructionApply;
import com.flf.entity.ServiceRequest;
import com.flf.entity.Tasks;
import com.flf.mapper.ConstructionAnnexMapper;
import com.flf.mapper.ConstructionAssociatedRecordMapper;
import com.flf.mapper.ConstructionComponentRecordsMapper;
import com.flf.mapper.ConstructionDiscloseInformationMapper;
import com.flf.mapper.ConstructionPersonnelAssociatedMapper;
import com.flf.mapper.ConstructionServiceRequestAssociatedMapper;
import com.flf.mapper.OwnerConstructionApplyMapper;
import com.flf.mapper.ServiceRequestMapper;
import com.flf.mapper.TasksMapper;
import com.flf.service.OwnerConstructionApplyService;
/**
 * 施工申请
 * @author 陶勇超
 *  2015-8-31
 */
public class OwnerConstructionApplyServiceImpl implements OwnerConstructionApplyService{
	private OwnerConstructionApplyMapper ownerConstructionApplyMapper;
	private ConstructionAssociatedRecordMapper constructionAssociatedRecordMapper;
	private ConstructionAnnexMapper constructionAnnexMapper;
	private ConstructionComponentRecordsMapper constructionComponentRecordsMapper;
	private ConstructionPersonnelAssociatedMapper constructionPersonnelAssociatedMapper;
	private ConstructionDiscloseInformationMapper constructionDiscloseInformationMapper;
	private ConstructionServiceRequestAssociatedMapper constructionServiceRequestAssociatedMapper;
	private ServiceRequestMapper serviceRequestMapper;
	private TasksMapper tasksMapper;

	public OwnerConstructionApplyMapper getOwnerConstructionApplyMapper() {
		return ownerConstructionApplyMapper;
	}

	public void setOwnerConstructionApplyMapper(
			OwnerConstructionApplyMapper ownerConstructionApplyMapper) {
		this.ownerConstructionApplyMapper = ownerConstructionApplyMapper;
	}

	public ConstructionAssociatedRecordMapper getConstructionAssociatedRecordMapper() {
		return constructionAssociatedRecordMapper;
	}

	public void setConstructionAssociatedRecordMapper(
			ConstructionAssociatedRecordMapper constructionAssociatedRecordMapper) {
		this.constructionAssociatedRecordMapper = constructionAssociatedRecordMapper;
	}

	public ConstructionAnnexMapper getConstructionAnnexMapper() {
		return constructionAnnexMapper;
	}

	public void setConstructionAnnexMapper(
			ConstructionAnnexMapper constructionAnnexMapper) {
		this.constructionAnnexMapper = constructionAnnexMapper;
	}

	public ConstructionComponentRecordsMapper getConstructionComponentRecordsMapper() {
		return constructionComponentRecordsMapper;
	}

	public void setConstructionComponentRecordsMapper(
			ConstructionComponentRecordsMapper constructionComponentRecordsMapper) {
		this.constructionComponentRecordsMapper = constructionComponentRecordsMapper;
	}

	public ConstructionPersonnelAssociatedMapper getConstructionPersonnelAssociatedMapper() {
		return constructionPersonnelAssociatedMapper;
	}

	public void setConstructionPersonnelAssociatedMapper(
			ConstructionPersonnelAssociatedMapper constructionPersonnelAssociatedMapper) {
		this.constructionPersonnelAssociatedMapper = constructionPersonnelAssociatedMapper;
	}

	public ConstructionDiscloseInformationMapper getConstructionDiscloseInformationMapper() {
		return constructionDiscloseInformationMapper;
	}

	public void setConstructionDiscloseInformationMapper(
			ConstructionDiscloseInformationMapper constructionDiscloseInformationMapper) {
		this.constructionDiscloseInformationMapper = constructionDiscloseInformationMapper;
	}

	public ConstructionServiceRequestAssociatedMapper getConstructionServiceRequestAssociatedMapper() {
		return constructionServiceRequestAssociatedMapper;
	}

	public void setConstructionServiceRequestAssociatedMapper(
			ConstructionServiceRequestAssociatedMapper constructionServiceRequestAssociatedMapper) {
		this.constructionServiceRequestAssociatedMapper = constructionServiceRequestAssociatedMapper;
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

	@Override
	public OwnerConstructionApply insertOwnerConstructionApply(
			OwnerConstructionApply ownerConstructionApply) {
		if(ownerConstructionApply !=null){

			String uuid = UUID.randomUUID().toString();
			Date date = new Date();

			ServiceRequest serviceRequest = ownerConstructionApply.getServiceRequest();
			ConstructionAssociatedRecord associatedRecords  = ownerConstructionApply.getConstructionAssociatedRecord();
			List<ConstructionAnnex> annexList = ownerConstructionApply.getConstructionAnnexList();
			List<ConstructionComponentRecords> componentRecordsList = ownerConstructionApply.getConstructionComponentRecordsList();
			List<ConstructionPersonnelAssociated> personnelAssociatedList = ownerConstructionApply.getConstructionPersonnelAssociatedList();
			List<ConstructionDiscloseInformation> discloseInformationList = ownerConstructionApply.getConstructionDiscloseInformationList();

			if(associatedRecords!=null && annexList!=null && componentRecordsList!=null 
					&& personnelAssociatedList!=null && discloseInformationList!=null && serviceRequest!=null){

				//装修图纸附件
				if(annexList.size()>0){
					for(ConstructionAnnex annex : annexList){
						annex.setApplyId(uuid);
						constructionAnnexMapper.insertConstructionAnnex(annex);
					}
				}
				//装修组件记录表
				if(componentRecordsList.size()>0){
					for(ConstructionComponentRecords compoent : componentRecordsList){
						compoent.setApplyId(uuid);
						constructionComponentRecordsMapper.insertConstructionComponentRecords(compoent);
					}
				}
				//装修单位提交资料记录表
				if(discloseInformationList.size()>0){
					for(ConstructionDiscloseInformation discloseInformation : discloseInformationList){
						discloseInformation.setApplyId(uuid);
						constructionDiscloseInformationMapper.insertConstructionDiscloseInformation(discloseInformation);
					}
				}
				associatedRecords.setApplyId(uuid);
				constructionAssociatedRecordMapper.insertConstructionAssociatedRecord(associatedRecords);
				//装修类型 0.自装 1.工装
				if(personnelAssociatedList.size()>0 && ownerConstructionApply.getConstructionType() == 1){
					//装修单位关联记录
					//if(constructionAssociatedRecordMapper.insertConstructionAssociatedRecord(associatedRecords)>0){
						//装修人员关联表
						for(ConstructionPersonnelAssociated personnelAssociated : personnelAssociatedList){
							personnelAssociated.setApplyId(uuid);
							constructionPersonnelAssociatedMapper.insertConstructionPersonnelAssociated(personnelAssociated);
						//}
					}
				}

				String serviceUUID = UUID.randomUUID().toString();
				String tasksUUID = UUID.randomUUID().toString();
				Tasks tasks = serviceRequest.getTasks();
				tasks.setTaskId(tasksUUID);
				tasks.setServerId(serviceUUID);
				tasks.setTaskState(4);//未接受

				serviceRequest.setServiceRequestId(serviceUUID);
				serviceRequest.setRequestTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
				serviceRequest.setServiceRequestState(2);//处理状态

				if(serviceRequestMapper.insertServiceRequestUUID(serviceRequest)>0 && tasksMapper.insertTasks(tasks)>0){
					ownerConstructionApply.setApplyId(uuid);
					ownerConstructionApply.setApplyTime(date);
					ownerConstructionApply.setApplyType(2);
					ownerConstructionApply.setServiceId(serviceUUID);
					Integer result = ownerConstructionApplyMapper.insertOwnerConstructionApplyUUID(ownerConstructionApply);
					if(result>0){
						//将申请id和服务请求id插入服务请求关联表 ts_decoreate_service_request_associated
						ConstructionServiceRequestAssociated dsra = new ConstructionServiceRequestAssociated();
						dsra.setApplyId(uuid);
						dsra.setServiceRequestId(serviceUUID);
						constructionServiceRequestAssociatedMapper.insertConstructionServiceRequestAssociated(dsra);
						return ownerConstructionApply;
					}
				}
			}
		}
		return null;
	}

	@Override
	public List<OwnerConstructionApply> getAllOwnerConstructionApply() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OwnerConstructionApply> getOwnerConstructionApplybyCustId(
			String custId) {
		// TODO Auto-generated method stub
		return ownerConstructionApplyMapper.getOwnerConstructionApplybyId(custId);
	}

	@Override
	public OwnerConstructionApply getOwnerConstructionApplyByServiceId(
			String serviceId) {
		// TODO Auto-generated method stub
		return ownerConstructionApplyMapper.getOwnerConstructionApplyByServiceId(serviceId);
	}

}
