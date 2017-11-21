package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.flf.entity.ApplicationDelayRecords;
import com.flf.entity.PageRestful;
import com.flf.entity.TasksJournal;
import com.flf.mapper.TasksJournalMapper;
import com.flf.entity.UrgeTaskRecords;
import com.flf.mapper.UrgeTaskRecordsMapper;
import com.flf.service.UrgeTaskRecordsService;
import com.flf.util.Tools;


public class UrgeTaskRecordsServiceImpl implements UrgeTaskRecordsService{

	private UrgeTaskRecordsMapper urgeTaskRecordsMapper;
	private TasksJournalMapper tasksJournalMapper;
	
	public TasksJournalMapper getTasksJournalMapper() {
		return tasksJournalMapper;
	}

	public void setTasksJournalMapper(TasksJournalMapper tasksJournalMapper) {
		this.tasksJournalMapper = tasksJournalMapper;
	}

	public UrgeTaskRecordsMapper getUrgeTaskRecordsMapper() {
		return urgeTaskRecordsMapper;
	}

	public void setUrgeTaskRecordsMapper(UrgeTaskRecordsMapper urgeTaskRecordsMapper) {
		this.urgeTaskRecordsMapper = urgeTaskRecordsMapper;
	}

	@Override
	public List<UrgeTaskRecords> getUrgeTaskRecordsbyTaskId(String taskId) {
		if(Tools.notEmpty(taskId)){
			return urgeTaskRecordsMapper.getUrgeTaskRecordsbyTaskId(taskId);
		}
		return null;
	}

	@Override
	public void insertUrgeTaskRecords(UrgeTaskRecords urgeTaskRecords) {
		
		Date date = new Date();
		urgeTaskRecords.setUrgeTime(date);
		urgeTaskRecordsMapper.insertUrgeTaskRecords(urgeTaskRecords);
		String uuid = UUID.randomUUID().toString();
		TasksJournal journal = new TasksJournal();
		journal.setTasksJournalId(uuid);
		journal.setTaskId(urgeTaskRecords.getTaskId());
		//journal.setOperatorId(urgeTaskRecords.getOperatorId());
		journal.setOperationTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
		journal.setChangeState(13);
		journal.setRemarks(urgeTaskRecords.getUrgeRemarks());
		
		tasksJournalMapper.insertTasksJournal(journal);
		
	}

	@Override
	public int getUrgeTaskRecordsCount(String taskId) {
		if(Tools.notEmpty(taskId)){
			
			return urgeTaskRecordsMapper.getUrgeTaskRecordsCount(taskId);	
		}
		return 0;
	}

	@Override
	public PageRestful listPageUrgeTaskRecordsRestful(
			UrgeTaskRecords urgeTaskRecords) {
		PageRestful pageRestful = new PageRestful();
		List<UrgeTaskRecords> recordList = urgeTaskRecordsMapper.listPageUrgeTaskRecordsRestful(urgeTaskRecords);
		recordList.add(0,null);
		pageRestful.setUrgeTaskRecords(recordList);
		pageRestful.setPage(urgeTaskRecords.getPage());
		return pageRestful;
	}

	@Override
	public String getUrgeTaskRidicule(int urgeSum) {
		
			if(urgeSum !=0 && urgeSum>0){
			
				return urgeTaskRecordsMapper.getUrgeTaskRidicule(urgeSum);	
			}
		
		return null;
	}

}
