package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flf.entity.CentralizedProcessingRecords;
import com.flf.entity.CentralizedTreatmentProjects;
import com.flf.entity.CentralizedTreatmentProjectsJournal;
import com.flf.entity.PageRestful;
import com.flf.entity.SpecialRepairProject;
import com.flf.entity.TaskTurnSpecialRecords;
import com.flf.entity.Tasks;
import com.flf.mapper.CentralizedProcessingRecordsMapper;
import com.flf.mapper.CentralizedTreatmentProjectsJournalMapper;
import com.flf.mapper.CentralizedTreatmentProjectsMapper;
import com.flf.mapper.TasksMapper;
import com.flf.request.Info;
import com.flf.service.CentralizedTreatmentProjectsService;
import com.flf.util.JsonUtil;
import com.flf.util.Tools;

import net.sf.json.JSONObject;

public class CentralizedTreatmentProjectsServiceImpl implements CentralizedTreatmentProjectsService{

	private CentralizedTreatmentProjectsMapper centralizedTreatmentProjectsMapper;
	private CentralizedTreatmentProjectsJournalMapper centralizedTreatmentProjectsJournalMapper;
	private CentralizedProcessingRecordsMapper centralizedProcessingRecordsMapper;
	private TasksMapper tasksMapper;
	
	public TasksMapper getTasksMapper() {
		return tasksMapper;
	}

	public void setTasksMapper(TasksMapper tasksMapper) {
		this.tasksMapper = tasksMapper;
	}

	public CentralizedProcessingRecordsMapper getCentralizedProcessingRecordsMapper() {
		return centralizedProcessingRecordsMapper;
	}

	public void setCentralizedProcessingRecordsMapper(
			CentralizedProcessingRecordsMapper centralizedProcessingRecordsMapper) {
		this.centralizedProcessingRecordsMapper = centralizedProcessingRecordsMapper;
	}

	public CentralizedTreatmentProjectsJournalMapper getCentralizedTreatmentProjectsJournalMapper() {
		return centralizedTreatmentProjectsJournalMapper;
	}

	public void setCentralizedTreatmentProjectsJournalMapper(
			CentralizedTreatmentProjectsJournalMapper centralizedTreatmentProjectsJournalMapper) {
		this.centralizedTreatmentProjectsJournalMapper = centralizedTreatmentProjectsJournalMapper;
	}

	public CentralizedTreatmentProjectsMapper getCentralizedTreatmentProjectsMapper() {
		return centralizedTreatmentProjectsMapper;
	}

	public void setCentralizedTreatmentProjectsMapper(
			CentralizedTreatmentProjectsMapper centralizedTreatmentProjectsMapper) {
		this.centralizedTreatmentProjectsMapper = centralizedTreatmentProjectsMapper;
	}

	@Override
	public List<CentralizedTreatmentProjects> getCentralizedTreatmentProjectsbyState(
			String state) {
		
		return centralizedTreatmentProjectsMapper.getCentralizedTreatmentProjectsbyState(state);
	}

	@Override
	public void insertCentralizedTreatmentProjects(
			CentralizedTreatmentProjects centralizedTreatmentProjects) {
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()).toString();
		centralizedTreatmentProjects.setCreateTime(date);
		centralizedTreatmentProjects.setProjectState(1);
		centralizedTreatmentProjectsMapper.insertCentralizedTreatmentProjects(centralizedTreatmentProjects);
	}

	@Override
	public Info changeState(CentralizedTreatmentProjectsJournal journal) {
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		//操作人不能为空
		if(journal != null && journal.getOperationPersonId()!=null && !"".equals(journal.getOperationPersonId())){
			String projectId = journal.getProjectId();
			
			//通过项目id获取集中处理信息
			List<CentralizedProcessingRecords> cprList = centralizedProcessingRecordsMapper.getCentralizedProcessingRecordsbyProjectId(projectId);
			if(cprList != null && cprList.size()>0){
				for(CentralizedProcessingRecords cpr : cprList){
					Tasks t = tasksMapper.getTasksbyId(cpr.getTaskId()) ;
					//项目下的任务中有状态不是完成和关闭状态的不能关闭
					if(t.getTaskState()!= 0 && t.getTaskState() != 2){
						return Tools.msg("项目下有仍在处理的任务!", true);
					}
				}
				//获取要改状态的集中处理项
				CentralizedTreatmentProjects ctp = centralizedTreatmentProjectsMapper.getCentralizedTreatmentProjectsbyId(projectId);
				ctp.setProjectState(journal.getChangeState());
				if(centralizedTreatmentProjectsMapper.updateCentralizedTreatmentProjects(ctp)>0){
					journal.setOperationTime(date);
					//记录修改的集中处理日志
					centralizedTreatmentProjectsJournalMapper.insertCentralizedTreatmentProjectsJournal(journal);
					return Tools.msg("操作成功!", true);
				}
			}else{
				CentralizedTreatmentProjects ctp = centralizedTreatmentProjectsMapper.getCentralizedTreatmentProjectsbyId(projectId);
				ctp.setProjectState(journal.getChangeState());
				if(centralizedTreatmentProjectsMapper.updateCentralizedTreatmentProjects(ctp)>0){
					journal.setOperationTime(date);
					centralizedTreatmentProjectsJournalMapper.insertCentralizedTreatmentProjectsJournal(journal);
					return Tools.msg("操作成功!", true);
				}
			}
		}
		return Tools.msg("操作失败!", false);
	}

	@Override
	public List<Tasks> getTasksbyProjectId(String projectId) {
		
		if(projectId != null && !"".equals(projectId)){
			List<Tasks> tlist = new ArrayList<Tasks>();
			List<CentralizedProcessingRecords> processingRecordsList =
				centralizedProcessingRecordsMapper.getCentralizedProcessingRecordsbyProjectId(projectId);
			if(processingRecordsList!= null && processingRecordsList.size()>0){
				for(CentralizedProcessingRecords processingRecords : processingRecordsList){
					Tasks tasks  = tasksMapper.getTasksbyId(processingRecords.getTaskId());
					if(tasks!= null){
						tlist.add(tasks);
					}
				}
				return tlist;
			}
		}
		return null;
	}

	@Override
	public List<CentralizedTreatmentProjects> getAllCentralizedTreatmentProjects() {
		return centralizedTreatmentProjectsMapper.getAllCentralizedTreatmentProjects();
	}

	@Override
	public List<CentralizedTreatmentProjects> getAllCentralizedTreatmentProjectsAlive() {
		// TODO Auto-generated method stub
		return centralizedTreatmentProjectsMapper.getAllCentralizedTreatmentProjectsAlive();
	}

	@Override
	public PageRestful listPageCentralizedTreatmentProjectsbyState(CentralizedTreatmentProjects project) {
		PageRestful pageRestful = new PageRestful();
		List<CentralizedTreatmentProjects> ctps = new ArrayList<>();
		if(Tools.notEmpty(project.getState())){
			ctps = centralizedTreatmentProjectsMapper.listPageCentralizedTreatmentProjectsbyState(project);
		}
		ctps.add(0, null);
		pageRestful.setCentralizedTreatmentProjects(ctps);
		pageRestful.setPage(project.getPage());
		return pageRestful;
	}

	@Override
	public String getCentralizedTreatmentProjectsCount(String projectState) {
		// TODO Auto-generated method stub
		
		Integer in;
		in = centralizedTreatmentProjectsMapper.getCentralizedTreatmentProjectCountsbyState(projectState);
		return JsonUtil.success(in, true);
	}

}





















