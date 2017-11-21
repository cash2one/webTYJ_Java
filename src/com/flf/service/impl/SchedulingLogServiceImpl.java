package com.flf.service.impl;

import java.util.List;

import com.flf.entity.SchedulingLog;
import com.flf.mapper.SchedulingLogMapper;
import com.flf.service.SchedulingLogService;

public class SchedulingLogServiceImpl implements SchedulingLogService {

	private SchedulingLogMapper schedulingLogMapper;
	
	public SchedulingLogMapper getSchedulingLogMapper() {
		return schedulingLogMapper;
	}

	public void setSchedulingLogMapper(SchedulingLogMapper schedulingLogMapper) {
		this.schedulingLogMapper = schedulingLogMapper;
	}

	@Override
	public List<SchedulingLog> listAllSchedulingLog() {
		// TODO Auto-generated method stub
		return schedulingLogMapper.listAllSchedulingLog();
	}

	@Override
	public SchedulingLog getSchedulingLog(int id) {
		// TODO Auto-generated method stub
		return schedulingLogMapper.getSchedulingLogById(id);
	}

	@Override
	public int insertSchedulingLog(SchedulingLog schedulingLog) {
		// TODO Auto-generated method stub
		return schedulingLogMapper.insertSchedulingLog(schedulingLog);
	}

	@Override
	public int updateSchedulingLog(SchedulingLog schedulingLog) {
		// TODO Auto-generated method stub
		return schedulingLogMapper.updateSchedulingLog(schedulingLog);
	}

	@Override
	public int deleteSchedulingLog(int id) {
		// TODO Auto-generated method stub
		return schedulingLogMapper.deleteSchedulingLog(id);
	}
	
	//-----------------------------------------------------------//

	@Override
	public List<SchedulingLog> listPageschedulingLog() {
		// TODO Auto-generated method stub
		return schedulingLogMapper.listAllSchedulingLog();
	}

	@Override
	public SchedulingLog getSchedulingLogByIdRest(Integer id) {
		// TODO Auto-generated method stub
		return schedulingLogMapper.getSchedulingLogById(id);
	}

	@Override
	public void AddSchedulingLog(SchedulingLog schedulingLog) {
		// TODO Auto-generated method stub
		schedulingLogMapper.insertSchedulingLog(schedulingLog);
	}

	@Override
	public void UpdateSchedulingLog(SchedulingLog schedulingLog) {
		// TODO Auto-generated method stub
		schedulingLogMapper.updateSchedulingLog(schedulingLog);
	}

	@Override
	public void DeleteSchedulingLogById(Integer id) {
		// TODO Auto-generated method stub
		schedulingLogMapper.deleteSchedulingLog(id);
	}
	
	//-----------------------------------------------------------//

}
