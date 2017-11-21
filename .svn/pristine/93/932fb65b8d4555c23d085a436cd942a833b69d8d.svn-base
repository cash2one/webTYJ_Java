package com.flf.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.flf.entity.Classes;
import com.flf.entity.Post;
import com.flf.entity.Scheduling;
import com.flf.entity.SchedulingLog;
import com.flf.entity.Staff;
import com.flf.mapper.SchedulingMapper;
import com.flf.mapper.SchedulingLogMapper;
import com.flf.service.SchedulingService;
public class SchedulingServiceImpl implements SchedulingService {

	private SchedulingMapper schedulingMapper;
	
	private SchedulingLogMapper schedulingLogMapper;
	
	
	public SchedulingLogMapper getSchedulingLogMapper() {
		return schedulingLogMapper;
	}

	public void setSchedulingLogMapper(SchedulingLogMapper schedulingLogMapper) {
		this.schedulingLogMapper = schedulingLogMapper;
	}

	public SchedulingMapper getSchedulingMapper() {
		return schedulingMapper;
	}

	public void setSchedulingMapper(SchedulingMapper schedulingMapper) {
		this.schedulingMapper = schedulingMapper;
	}

	@Override
	public List<Scheduling> listAllScheduling() {
		// TODO Auto-generated method stub
		return schedulingMapper.listAllScheduling();
	}

	@Override
	public Scheduling getScheduling(int id) {
		// TODO Auto-generated method stub
		return schedulingMapper.getSchedulingById(id);
	}

	@Override
	public int insertScheduling(Scheduling scheduling) {
		// TODO Auto-generated method stub
		return schedulingMapper.insertScheduling(scheduling);
	}

	@Override
	public int updateScheduling(Scheduling scheduling) {
		// TODO Auto-generated method stub
		return schedulingMapper.updateScheduling(scheduling);
	}

	@Override
	public int deleteScheduling(int id) {
		// TODO Auto-generated method stub
		return schedulingMapper.deleteScheduling(id);
	}


	@Override


	public List<Scheduling> listPagescheduling() {
		// TODO Auto-generated method stub
		return schedulingMapper.listAllScheduling();
	}

	

	@Override
	public void AddScheduling(Scheduling scheduling) {
		// TODO Auto-generated method stub
		schedulingMapper.insertScheduling(scheduling);
	}

	@Override
	public void UpdateScheduling(Scheduling scheduling) {
		// TODO Auto-generated method stub
		schedulingMapper.updateScheduling(scheduling);
	}

	@Override
	public void DeleteSchedulingById(Integer id) {
		// TODO Auto-generated method stub
		schedulingMapper.deleteScheduling(id);
	}


	@Override
	public List<Map> listAllSchedulingBypostIdOrStaffId(Scheduling scheduling) {
		// TODO Auto-generated method stub
		return schedulingMapper.listAllSchedulingBypostIdOrStaffId(scheduling);
	}

	@Override
	public void addScheduLing(HashMap<String,Object> map) {
		// TODO Auto-generated method stub
		/*List<Staff> staffs= (List<Staff>) map.get("staffs");   //员工集合列表
		Post post=(Post) map.get("post");    //岗位信息
		Classes  classes=(Classes) map.get("classes");  //班次信息
		Date currentDate= (Date) map.get("currentDate"); //日期
		for (Staff staff : staffs) {

			Scheduling Scheduling=new Scheduling();
			if(classes!=null)
			{
				Scheduling.setStartDt(classes.getStartTime()); //开始时间
				Scheduling.setEndDt(classes.getEndTime());  //结束时间
				Scheduling.setClassesTypeId(classes.getClassesTypeId()); // 班次类型id
				Scheduling.setClassesTypeName(classes.getClassesTypeName());  //班次类型
				Scheduling.setClassesId(classes.getId());  //班次id
				Scheduling.setClassesName(classes.getClassesName()); //班次名称
			}else
			{
				Scheduling.setClassesTypeName("休");  //班次类型
			}
			Scheduling.setStaffId(staff.getStaffId());  //员工id
			Scheduling.setStaffName(staff.getFirstName()+staff.getLastName());  //员工姓名
			Scheduling.setCurrentdate(currentDate);  //日期
			Scheduling.setPostId(post.getPostId());  //岗位id
			Scheduling.setPostName(post.getNameOfCustom()); //岗位名称
			Scheduling.setDivisionId(staff.getDivisionId()) ; //部门id
			Scheduling.setDivisionName(staff.getDivisionname()); //部门名称
			
			
			schedulingMapper.insertScheduling(Scheduling);  //插入排班信息  
			
			
			SchedulingLog log=new SchedulingLog();
			if(classes!=null)
			{
				log.setCurrentdate(currentDate);  //日期
				log.setStartDt(classes.getStartTime()); //开始时间
				log.setEndDt(classes.getEndTime());  //结束时间
				log.setClassesTypeId(classes.getClassesTypeId()); // 班次类型id
				log.setClassesTypeName(classes.getClassesTypeName());  //班次类型
				log.setClassesId(classes.getId());  //班次id
				log.setClassesName(classes.getClassesName()); //班次名称
			}else
			{
				log.setClassesTypeName("休");  //班次类型
			}
			log.setStaffId(staff.getStaffId());  //员工id
			log.setStaffName(staff.getFirstName()+staff.getLastName());  //员工姓名
			log.setPostId(post.getPostId());  //岗位id
			log.setPostName(post.getNameOfCustom()); //岗位名称
			schedulingLogMapper.insertSchedulingLog(log);// 添加日志
			
		}*/
		
	
	}

	@Override
	public Scheduling getSchedulingByIdRest(Integer id) {
		// TODO Auto-generated method stub
		return schedulingMapper.getSchedulingById(id);
	}
	
	@Override
	public boolean getCountBydivisionIdAndDate(String divisionId, int year,
			int month) {
		// TODO Auto-generated method stub
		boolean bool=true;
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("divisionId",divisionId);
		map.put("year",year);
		map.put("month",month);
		if(schedulingMapper.getCountBydivisionIdAndDate(map)>0)
		{
			bool=false;
		}
		return bool;
	}

	@Override
	public int updateSchedulingByStaffId(Scheduling scheduling) {
		
		return schedulingMapper.updateSchedulingByStaffId(scheduling);
	}

	@Override
	public List<Map> listAllSchedulingBypostIdOrStaffName(Scheduling scheduling) {
		
		return schedulingMapper.listAllSchedulingBypostIdOrStaffName(scheduling);
	}


}
