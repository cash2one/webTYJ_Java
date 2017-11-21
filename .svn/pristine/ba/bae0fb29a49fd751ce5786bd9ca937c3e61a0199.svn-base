package com.flf.mapper;

import java.util.List;

import com.flf.entity.ApplicationDelayRecords;

public interface ApplicationDelayRecordsMapper {

	List<ApplicationDelayRecords> listAllApplicationDelayRecords();//获取所有延时对象
	ApplicationDelayRecords getApplicationDelayRecordsById(String recordId);//根据记录Id获取延时对象
	int insertApplicationDelayRecords(ApplicationDelayRecords applicationDelayRecords);//添加延时对象
	int deleteApplicationDelayRecordsById(String recordId);//根据记录Id删除延时对象
	int updateApplicationDelayRecords(ApplicationDelayRecords applicationDelayRecords);//更新延时对象
	List<ApplicationDelayRecords> getApplicationDelayRecordsbyTaskId(String taskId);//通过任务id获取延时记录
	List<ApplicationDelayRecords> listPageApplicationDelayRecords(ApplicationDelayRecords applicationDelayRecords);//根据任务id分页查询
}
