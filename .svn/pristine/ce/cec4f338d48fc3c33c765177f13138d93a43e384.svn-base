package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.cxf.binding.corba.wsdl.Array;

import net.sf.json.JSON;

import com.flf.entity.Annex;
import com.flf.entity.ArticleRelease;
import com.flf.entity.PageRestful;
import com.flf.entity.SpecialRepairProject;
import com.flf.entity.SpecialRepairProjectJournal;
import com.flf.entity.TaskTurnSpecialRecords;
import com.flf.entity.Tasks;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.SpecialRepairProjectJournalMapper;
import com.flf.mapper.SpecialRepairProjectMapper;
import com.flf.mapper.TaskTurnSpecialRecordsMapper;
import com.flf.mapper.TasksMapper;
import com.flf.request.Info;
import com.flf.service.SpecialRepairProjectService;
import com.flf.util.JsonUtil;
import com.flf.util.Tools;

public class SpecialRepairProjectServiceImpl implements SpecialRepairProjectService{

	private SpecialRepairProjectMapper specialRepairProjectMapper;
	private TaskTurnSpecialRecordsMapper taskTurnSpecialRecordsMapper;
	private SpecialRepairProjectJournalMapper specialRepairProjectJournalMapper;
	private TasksMapper tasksMapper;
	private AnnexMapper annexMapper;
	
	public TasksMapper getTasksMapper() {
		return tasksMapper;
	}

	public void setTasksMapper(TasksMapper tasksMapper) {
		this.tasksMapper = tasksMapper;
	}

	public TaskTurnSpecialRecordsMapper getTaskTurnSpecialRecordsMapper() {
		return taskTurnSpecialRecordsMapper;
	}

	public void setTaskTurnSpecialRecordsMapper(
			TaskTurnSpecialRecordsMapper taskTurnSpecialRecordsMapper) {
		this.taskTurnSpecialRecordsMapper = taskTurnSpecialRecordsMapper;
	}

	public AnnexMapper getAnnexMapper() {
		return annexMapper;
	}

	public void setAnnexMapper(AnnexMapper annexMapper) {
		this.annexMapper = annexMapper;
	}

	public SpecialRepairProjectJournalMapper getSpecialRepairProjectJournalMapper() {
		return specialRepairProjectJournalMapper;
	}

	public void setSpecialRepairProjectJournalMapper(
			SpecialRepairProjectJournalMapper specialRepairProjectJournalMapper) {
		this.specialRepairProjectJournalMapper = specialRepairProjectJournalMapper;
	}

	public SpecialRepairProjectMapper getSpecialRepairProjectMapper() {
		return specialRepairProjectMapper;
	}

	public void setSpecialRepairProjectMapper(
			SpecialRepairProjectMapper specialRepairProjectMapper) {
		this.specialRepairProjectMapper = specialRepairProjectMapper;
	}

	@Override
	public List<SpecialRepairProject> getAllSpecialRepairProject() {
		return specialRepairProjectMapper.getAllSpecialRepairProject();
	}

	@Override
	public SpecialRepairProject getSpecialRepairProjectbyId(String specialId) {
		return specialRepairProjectMapper.getSpecialRepairProjectbyId(specialId);
	}

	@Override
	public void insertSpecialRepairProject(SpecialRepairProject project) {
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		String uuid = UUID.randomUUID().toString();
		if(project != null){
			List<Annex> annexList = project.getAnnexs();
			
			project.setSpecialId(uuid);
			project.setSpecialState(1);//启用状态
			project.setCreateTime(date);
			specialRepairProjectMapper.insertSpecialRepairProjectUUID(project);
			
			//附件信息保存
			if(annexList != null && annexList.size()>0){
				for(Annex annex :annexList){
					annex.setRelationId(uuid);
					annex.setAnnexTime(date);
					annexMapper.insertAnnex(annex);
				}
			}
		}
	}

	@Override
	public Info changeState(SpecialRepairProjectJournal journal) {
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		//操作人不能为空
		if(journal != null && journal.getOperationPersonId()!=null && !"".equals(journal.getOperationPersonId())){
			String specialId = journal.getSpecialId();
			
			//通过专项id获取转专项记录信息
			List<TaskTurnSpecialRecords> ttsrList = taskTurnSpecialRecordsMapper.getTaskTurnSpecialRecordsbyProjectId(specialId);
			if(ttsrList != null && ttsrList.size()>0){
				for(TaskTurnSpecialRecords ttsr : ttsrList){
					Tasks t = tasksMapper.getTasksbyId(ttsr.getTaskId()) ;
					//项目下的任务中有状态不是完成和关闭状态的不能关闭
					if(t.getTaskState()!= 0 && t.getTaskState() != 2){
						return Tools.msg("项目下有仍在处理的任务!", true);
					}
				}
				//获取要改状态的专项
				SpecialRepairProject srp = specialRepairProjectMapper.getSpecialRepairProjectbyId(specialId);
				srp.setSpecialState(journal.getChangeState());
				if(specialRepairProjectMapper.updateSpecialRepairProject(srp)>0){
					journal.setOperationTime(date);
					//记录修改专项日志
					specialRepairProjectJournalMapper.insertSpecialRepairProjectJournal(journal);
					return Tools.msg("操作成功!", true);
				}
			}else{
				SpecialRepairProject srp = specialRepairProjectMapper.getSpecialRepairProjectbyId(specialId);
				srp.setSpecialState(journal.getChangeState());
				if(specialRepairProjectMapper.updateSpecialRepairProject(srp)>0){
					journal.setOperationTime(date);
					specialRepairProjectJournalMapper.insertSpecialRepairProjectJournal(journal);
					return Tools.msg("操作成功!", true);
				}
			}
		}
		return Tools.msg("操作失败!", false);
	}

	@Override
	public List<SpecialRepairProject> getSpecialRepairProjectbyState(String state) {
		if(Tools.notEmpty(state)){
			return specialRepairProjectMapper.getSpecialRepairProjectbyState(state);
		}
		return null;
	}
	
	@Override
	public PageRestful listPageSpecialRepairProjectbyState(SpecialRepairProject project) {
		PageRestful pageRestful = new PageRestful();
		List<SpecialRepairProject> srps = new ArrayList<>();
		if(Tools.notEmpty(project.getState())){
			srps = specialRepairProjectMapper.listPageSpecialRepairProjectbyState(project);
		}
		srps.add(0, null);
		pageRestful.setSpecialRepairProject(srps);
		pageRestful.setPage(project.getPage());
		return pageRestful;
	}

	@Override
	public String getSpecialRepairProjectCountbyState(String specialState) {
		// TODO Auto-generated method stub
		Integer in;
		in = specialRepairProjectMapper.getSpecialRepairProjectCountbyState(specialState);
		return JsonUtil.success(in, true);
	}
}
	
