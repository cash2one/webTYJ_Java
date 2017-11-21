package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.flf.entity.ApplicationDelayRecords;
import com.flf.entity.PageRestful;
import com.flf.entity.TasksJournal;
import com.flf.mapper.TasksJournalMapper;
import com.flf.mapper.ApplicationDelayRecordsMapper;
import com.flf.service.ApplicationDelayRecordsService;
import com.flf.util.Tools;

public class ApplicationDelayRecordsServiceImpl implements ApplicationDelayRecordsService {

	private ApplicationDelayRecordsMapper applicationDelayRecordsMapper;//延时对象接口
	private TasksJournalMapper tasksJournalMapper;
	
	
	public TasksJournalMapper getTasksJournalMapper() {
		return tasksJournalMapper;
	}

	public void setTasksJournalMapper(TasksJournalMapper tasksJournalMapper) {
		this.tasksJournalMapper = tasksJournalMapper;
	}

	public ApplicationDelayRecordsMapper getApplicationDelayRecordsMapper() {
		return applicationDelayRecordsMapper;
	}

	public void setApplicationDelayRecordsMapper(ApplicationDelayRecordsMapper applicationDelayRecordsMapper) {
		this.applicationDelayRecordsMapper = applicationDelayRecordsMapper;
	}


	@Override
	public List<ApplicationDelayRecords> listAllApplicationDelayRecords() {
		// TODO Auto-generated method stub
		return applicationDelayRecordsMapper.listAllApplicationDelayRecords();
	}

	@Override
	public ApplicationDelayRecords getApplicationDelayRecordsById(String recordId) {
		// TODO Auto-generated method stub
		return applicationDelayRecordsMapper.getApplicationDelayRecordsById(recordId);
	}

	@Override
	public int insertApplicationDelayRecords(ApplicationDelayRecords applicationDelayRecords) {
		// TODO Auto-generated method stub
		return applicationDelayRecordsMapper.insertApplicationDelayRecords(applicationDelayRecords);
	}

	@Override
	public int deleteApplicationDelayRecordsById(String recordId) {
		// TODO Auto-generated method stub
		return applicationDelayRecordsMapper.deleteApplicationDelayRecordsById(recordId);
	}

	@Override
	public int updateApplicationDelayRecords(ApplicationDelayRecords applicationDelayRecords) {
		// TODO Auto-generated method stub
		return applicationDelayRecordsMapper.updateApplicationDelayRecords(applicationDelayRecords);
	}

	@Override
	public ApplicationDelayRecords FindApplicationDelayRecordsById(String recordId) {
		// TODO Auto-generated method stub
		return applicationDelayRecordsMapper.getApplicationDelayRecordsById(recordId);
	}

	@Override
	public int addApplicationDelayRecords(ApplicationDelayRecords applicationDelayRecords) {
		// TODO Auto-generated method stub
		String uuid = UUID.randomUUID().toString();
		Date date = new Date();
		//判断对象是否为空
		int result = 0;
		if(applicationDelayRecords!=null){
			applicationDelayRecords.setRecordId(uuid);
			applicationDelayRecords.setOperationTime(date);
			//将延时对象保存到数据库
			result = applicationDelayRecordsMapper.insertApplicationDelayRecords(applicationDelayRecords);
			
				TasksJournal journal = new TasksJournal();
				journal.setTasksJournalId(uuid);
				journal.setTaskId(applicationDelayRecords.getTaskId());
				//journal.setOperatorId(applicationDelayRecords.getOperatorId());
				journal.setOperationTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
				journal.setChangeState(12);
				journal.setRemarks(applicationDelayRecords.getRemarks());
				
				tasksJournalMapper.insertTasksJournal(journal);
			
		}
		return result;
	}

	@Override
	public int deleteApplicationDelayRecords(String recordId) {
		// TODO Auto-generated method stub
		return applicationDelayRecordsMapper.deleteApplicationDelayRecordsById(recordId);
	}

	@Override
	public int updateApplicationDelayRecordsInfo(ApplicationDelayRecords applicationDelayRecords) {
		// TODO Auto-generated method stub
		return applicationDelayRecordsMapper.updateApplicationDelayRecords(applicationDelayRecords);
	}

	@Override
	public int getApplicationDelayRecordsCount(String taskId) {
		if(Tools.notEmpty(taskId)){
			List<ApplicationDelayRecords> list = applicationDelayRecordsMapper.getApplicationDelayRecordsbyTaskId(taskId);
			if(list!=null){
				return list.size();
			}
		}
		return 0;
	}

	@Override
	public List<ApplicationDelayRecords> getApplicationDelayRecordsbyTaskId(
			String taskId) {
		if(Tools.notEmpty(taskId)){
			return applicationDelayRecordsMapper.getApplicationDelayRecordsbyTaskId(taskId);
		}
		return null;
	}

	@Override
	public PageRestful listPageApplicationDelayRecordsRestful(
			ApplicationDelayRecords applicationDelayRecords) {
		PageRestful pageRestful = new PageRestful();
		List<ApplicationDelayRecords> recordList = applicationDelayRecordsMapper.listPageApplicationDelayRecords(applicationDelayRecords);
		recordList.add(0,null);
		pageRestful.setApplicationDelayRecords(recordList);
		pageRestful.setPage(applicationDelayRecords.getPage());
		return pageRestful;
	}
}
