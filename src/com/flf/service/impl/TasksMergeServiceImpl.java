package com.flf.service.impl;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebService;

import com.flf.entity.Tasks;
import com.flf.entity.TasksJournal;
import com.flf.entity.TasksMerge;
import com.flf.mapper.TasksJournalMapper;
import com.flf.mapper.TasksMapper;
import com.flf.mapper.TasksMergeMapper;
import com.flf.service.TasksMergeService;
import com.flf.util.JsonUtil;
/**
 * 合并任务表
 * 创建人：邵政
 * 创建时间：2015-7-2
 */
@WebService
public class TasksMergeServiceImpl implements TasksMergeService {
	
	private TasksMergeMapper tasksMergeMapper;
	private TasksMapper tasksMapper;
	private TasksJournalMapper tasksJournalMapper;
	

	public TasksJournalMapper getTasksJournalMapper() {
		return tasksJournalMapper;
	}

	public void setTasksJournalMapper(TasksJournalMapper tasksJournalMapper) {
		this.tasksJournalMapper = tasksJournalMapper;
	}

	public TasksMapper getTasksMapper() {
		return tasksMapper;
	}

	public void setTasksMapper(TasksMapper tasksMapper) {
		this.tasksMapper = tasksMapper;
	}

	public TasksMergeMapper getTasksMergeMapper() {
		return tasksMergeMapper;
	}

	public void setTasksMergeMapper(TasksMergeMapper tasksMergeMapper) {
		this.tasksMergeMapper = tasksMergeMapper;
	}

	@Override
	public List<TasksMerge> listAllTasksMerge() {
		// TODO Auto-generated method stub
		return tasksMergeMapper.listAllTasksMerge();
	}

	@Override
	public TasksMerge getTasksMergebyId(String tasksMergeId) {
		// TODO Auto-generated method stub
		return tasksMergeMapper.getTasksMergebyId(tasksMergeId);
	}

	@Override
	public String insertTasksMerge(TasksMerge tasksMerge) {
		// TODO Auto-generated method stub
		
		//合并任务
		int tmp = tasksMergeMapper.insertTasksMerge(tasksMerge);
		
		if(tmp==0){
			return JsonUtil.failure("操作失败", false);
		}
		
		Tasks tasks = new Tasks();
		//被合并任务id
		tasks.setTasksIds(new ArrayList<String>());
		tasks.getTasksIds().add(tasksMerge.getLesserTaskId());
		//合并状态
		tasks.setTaskState(8);
		//修改被合并任务状态
		tasksMapper.changeTasksStateByIds(tasks);
		
		//日志
		TasksJournal journal = new TasksJournal();
		journal.setTaskId(tasks.getTasksIds().get(0));
		journal.setOperatorId(tasksMerge.getOperatorId());
		journal.setOperationTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		journal.setChangeState(8);
		journal.setRemarks(tasksMerge.getRemarks());
		tasksJournalMapper.insertTasksJournal(journal);
		return JsonUtil.success("操作成功!", true);
		
	}

	@Override
	public void updateTasksMerge(TasksMerge tasksMerge) {
		// TODO Auto-generated method stub
		tasksMergeMapper.updateTasksMerge(tasksMerge);
	}

	@Override
	public String deleteTasksMerge(String tasksMergeId, String operatorId) {
		// TODO Auto-generated method stub
		
		TasksMerge tasksMerge = tasksMergeMapper.getTasksMergebyId(tasksMergeId);	
		Tasks tasks = new Tasks();
		//被合并任务id
		tasks.getTasksIds().add(tasksMerge.getLesserTaskId());
		//合并状态
		tasks.setTaskState(7);
		//修改被合并任务状态
		tasksMapper.changeTasksStateByIds(tasks);
		
		//删除合并
		int tmp = tasksMergeMapper.deleteTasksMerge(tasksMergeId);
		if(tmp == 0){
			return JsonUtil.failure("操作失败", false);
		}
		
		//日志
		TasksJournal journal = new TasksJournal();	
		journal.setTaskId(tasks.getTasksIds().get(0));
		journal.setOperatorId(operatorId);
		journal.setOperationTime(new Date().toString());
		journal.setChangeState(7);
		tasksJournalMapper.insertTasksJournal(journal);
		return JsonUtil.success("操作成功!", true);
	}

	
}
