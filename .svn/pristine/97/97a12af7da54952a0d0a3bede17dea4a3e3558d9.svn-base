package com.flf.mapper;

import java.util.List;

import com.flf.entity.UrgeTaskRecords;

public interface UrgeTaskRecordsMapper {

	List<UrgeTaskRecords> getUrgeTaskRecordsbyTaskId(String taskId);//通过任务id获取催办任务记录表
	void insertUrgeTaskRecords(UrgeTaskRecords urgeTaskRecords);//添加催办任务记录表
	List<UrgeTaskRecords> listPageUrgeTaskRecordsRestful(UrgeTaskRecords urgeTaskRecords);//通过任务id分页
	int getUrgeTaskRecordsCount(String taskId); //通过任务Id查询催促次数
	String getUrgeTaskRidicule(int urgeSum);//通过催促次数 查询 调侃对应的语句
}
