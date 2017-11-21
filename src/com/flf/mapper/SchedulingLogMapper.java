package com.flf.mapper;

import java.util.List;

import com.flf.entity.SchedulingLog;

public interface SchedulingLogMapper {//调度日志表
	List<SchedulingLog> listAllSchedulingLog();//获取所有调度日志
	SchedulingLog getSchedulingLogById(int id);//通过Id调度日志
	int insertSchedulingLog(SchedulingLog schedulingLog);//添加调度日志
	int updateSchedulingLog(SchedulingLog schedulingLog);//修改调度日志
	int deleteSchedulingLog(int id);//删除调度日志
}
