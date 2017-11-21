package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.flf.entity.AcceptanceHouse;
import com.flf.entity.AcceptanceHouseRelation;
import com.flf.entity.PageRestful;
import com.flf.entity.PropertyType;
import com.flf.entity.ServiceRequest;
import com.flf.entity.Tasks;
import com.flf.mapper.AcceptanceHouseMapper;
import com.flf.mapper.AcceptanceHouseRelationMapper;
import com.flf.mapper.ServiceRequestMapper;
import com.flf.mapper.TasksMapper;
import com.flf.service.AcceptanceHouseService;

public class AcceptanceHouseServiceImpl implements AcceptanceHouseService {
	private AcceptanceHouseMapper acceptanceHouseMapper;
	private AcceptanceHouseRelationMapper acceptanceHouseRelationMapper;
	private ServiceRequestMapper serviceRequestMapper;//服务请求mapper
	private TasksMapper tasksMapper;//服务请求任务mapper
	
	@Override
	public List<AcceptanceHouse> listAllAcceptanceHouse() {
		return acceptanceHouseMapper.listAllAcceptanceHouse();
	}
	
	@Override
	public AcceptanceHouse getAcceptanceHousebyId(String id) {
		AcceptanceHouse ah = acceptanceHouseMapper.getAcceptanceHouseById(id);
		List<AcceptanceHouseRelation> ahrList = acceptanceHouseRelationMapper.getAcceptanceHouseRelationByAcceptanceHouseId(id);
		if(ahrList != null && ahrList.size() > 0){
			ah.setAhrList(ahrList);
		}
		return ah;
	}
	
	/**
	 * 修改新增房屋初验方法，在新增的同时一起新增服务请求，有几栋房屋变新增几个任务
	 * 王洲
	 * 2015.12.30
	 */
	@Override
	public void insertAcceptanceHouse(AcceptanceHouse acceptanceHouse) {
		String uuid= UUID.randomUUID().toString();	//房屋初验uuid
		String uuids = UUID.randomUUID().toString();	//验房服务请求id
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//格式化时间
		acceptanceHouse.setId(uuid);
		acceptanceHouse.setIssuerDate(new Date());
		acceptanceHouse.setServiceRequestId(uuids);
		acceptanceHouseMapper.insertAcceptanceHouse(acceptanceHouse);//生成房屋初验数据
		//判断是否存在关联数据，将对应的关联数据存入数据库
		if(acceptanceHouse.getAhrList() != null && acceptanceHouse.getAhrList().size() > 0){
			for(AcceptanceHouseRelation ahr :acceptanceHouse.getAhrList()){
				ahr.setAcceptanceHouseId(uuid);
				acceptanceHouseRelationMapper.insertAcceptanceHouseRelation(ahr);
			}
		}
		
		//创建对应的验房服务请求
		ServiceRequest sr = new ServiceRequest();
		sr.setServiceRequestId(uuids);
		sr.setRequestTime(sdf.format(new Date()));
		sr.setRequestSource("验房");
		sr.setServiceRequestState(2);
		sr.setDirectionType(0);
		sr.setServiceRequestType(3);
		sr.setImportantEvent(0);
		sr.setAnxious(0);
		serviceRequestMapper.insertServiceRequestUUID(sr);
		Tasks tasks = null;
		//判断房屋初验是否存在关联数据，根据关联数据生成服务请求的任务
		if(acceptanceHouse.getAhrList() != null && acceptanceHouse.getAhrList().size() > 0){
			for(AcceptanceHouseRelation ahr : acceptanceHouse.getAhrList()){
				//当管理按数据中建筑结构不为空时，创建任务
				if(ahr.getBuildingStructureId() != null){
					tasks = new Tasks();
					tasks.setTaskId(UUID.randomUUID().toString());
					tasks.setServerId(uuids);
					tasks.setTaskType(14);
					tasks.setTaskState(3);
					tasks.setAddressId(ahr.getBuildingStructureId());
					tasks.setEstimatedTime(acceptanceHouse.getEndDate());
					tasks.setCreateTime(sdf.format(new Date()));
					tasks.setPrincipal(ahr.getStaffId());
					tasksMapper.insertTasksUUID(tasks);
				}
			}			
		}
	}

	
	@Override
	public PageRestful listPageAcceptanceHouse(AcceptanceHouse acceptanceHouse) {
		PageRestful pageRestful = new PageRestful();
		List<AcceptanceHouse> acceptanceHouses = acceptanceHouseMapper.listPageAcceptanceHouse(acceptanceHouse);
		acceptanceHouses.add(0, null);
		pageRestful.setAcceptanceHouses(acceptanceHouses);
		pageRestful.setPage(acceptanceHouse.getPage());
		return pageRestful;
	}
	
	
	public AcceptanceHouseMapper getAcceptanceHouseMapper() {
		return acceptanceHouseMapper;
	}
	public void setAcceptanceHouseMapper(AcceptanceHouseMapper acceptanceHouseMapper) {
		this.acceptanceHouseMapper = acceptanceHouseMapper;
	}
	public AcceptanceHouseRelationMapper getAcceptanceHouseRelationMapper() {
		return acceptanceHouseRelationMapper;
	}
	public void setAcceptanceHouseRelationMapper(
			AcceptanceHouseRelationMapper acceptanceHouseRelationMapper) {
		this.acceptanceHouseRelationMapper = acceptanceHouseRelationMapper;
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

}
