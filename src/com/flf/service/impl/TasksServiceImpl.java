package com.flf.service.impl;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.ws.rs.PathParam;

import net.sf.json.JSONObject;

import com.flf.entity.AfterSale;
import com.flf.entity.Annex;
import com.flf.entity.CentralizedProcessingRecords;
import com.flf.entity.CompensateObject;
import com.flf.entity.InspectorOrder;
import com.flf.entity.PageRestful;
import com.flf.entity.ServiceObjectRecords;
import com.flf.entity.ServiceRequest;
import com.flf.entity.Staff;
import com.flf.entity.TaskTurnSpecialRecords;
import com.flf.entity.Tasks;
import com.flf.entity.TasksJournal;
import com.flf.mapper.AfterSaleMapper;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.CentralizedProcessingRecordsMapper;
import com.flf.mapper.CompensateObjectMapper;
import com.flf.mapper.InspectorOrderMapper;
import com.flf.mapper.ScoreCriteriaMapper;
import com.flf.mapper.ServiceObjectRecordsMapper;
import com.flf.mapper.ServiceRequestMapper;
import com.flf.mapper.StaffMapper;
import com.flf.mapper.TaskTurnSpecialRecordsMapper;
import com.flf.mapper.TasksJournalMapper;
import com.flf.mapper.TasksMapper;
import com.flf.mapper.TasksMergeMapper;
import com.flf.service.TasksService;
import com.flf.util.JsonUtil;
import com.flf.util.Tools;
/**
 * 任务表
 * 创建人：邵政
 * 创建时间：2015/6/23
 */
public class TasksServiceImpl implements TasksService {
	
	private TasksMapper tasksMapper;
	private TasksJournalMapper tasksJournalMapper;
	private TaskTurnSpecialRecordsMapper taskTurnSpecialRecordsMapper;
	private CentralizedProcessingRecordsMapper centralizedProcessingRecordsMapper;
	private TasksMergeMapper tasksMergeMapper;
	private ServiceObjectRecordsMapper serviceObjectRecordsMapper;
	private ScoreCriteriaMapper scoreCriteriaMapper;
	private CompensateObjectMapper compensateObjectMapper;
	private AnnexMapper annexMapper;
	private ServiceRequestMapper serviceRequestMapper;
	private InspectorOrderMapper inspectorOrderMapper;		//验房工单Mapper
	private AfterSaleMapper afterSaleMapper;				//售后管理Mapper
	private StaffMapper staffMapper;

	public ServiceRequestMapper getServiceRequestMapper() {
		return serviceRequestMapper;
	}

	public void setServiceRequestMapper(ServiceRequestMapper serviceRequestMapper) {
		this.serviceRequestMapper = serviceRequestMapper;
	}

	public AnnexMapper getAnnexMapper() {
		return annexMapper;
	}

	public void setAnnexMapper(AnnexMapper annexMapper) {
		this.annexMapper = annexMapper;
	}

	public CompensateObjectMapper getCompensateObjectMapper() {
		return compensateObjectMapper;
	}

	public void setCompensateObjectMapper(
			CompensateObjectMapper compensateObjectMapper) {
		this.compensateObjectMapper = compensateObjectMapper;
	}

	public ScoreCriteriaMapper getScoreCriteriaMapper() {
		return scoreCriteriaMapper;
	}

	public void setScoreCriteriaMapper(ScoreCriteriaMapper scoreCriteriaMapper) {
		this.scoreCriteriaMapper = scoreCriteriaMapper;
	}

	public ServiceObjectRecordsMapper getServiceObjectRecordsMapper() {
		return serviceObjectRecordsMapper;
	}

	public void setServiceObjectRecordsMapper(
			ServiceObjectRecordsMapper serviceObjectRecordsMapper) {
		this.serviceObjectRecordsMapper = serviceObjectRecordsMapper;
	}

	public TasksMergeMapper getTasksMergeMapper() {
		return tasksMergeMapper;
	}

	public void setTasksMergeMapper(TasksMergeMapper tasksMergeMapper) {
		this.tasksMergeMapper = tasksMergeMapper;
	}

	public CentralizedProcessingRecordsMapper getCentralizedProcessingRecordsMapper() {
		return centralizedProcessingRecordsMapper;
	}

	public void setCentralizedProcessingRecordsMapper(
			CentralizedProcessingRecordsMapper centralizedProcessingRecordsMapper) {
		this.centralizedProcessingRecordsMapper = centralizedProcessingRecordsMapper;
	}

	public TaskTurnSpecialRecordsMapper getTaskTurnSpecialRecordsMapper() {
		return taskTurnSpecialRecordsMapper;
	}

	public void setTaskTurnSpecialRecordsMapper(
			TaskTurnSpecialRecordsMapper taskTurnSpecialRecordsMapper) {
		this.taskTurnSpecialRecordsMapper = taskTurnSpecialRecordsMapper;
	}

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

	public InspectorOrderMapper getInspectorOrderMapper() {
		return inspectorOrderMapper;
	}

	public void setInspectorOrderMapper(InspectorOrderMapper inspectorOrderMapper) {
		this.inspectorOrderMapper = inspectorOrderMapper;
	}
	
	public AfterSaleMapper getAfterSaleMapper() {
		return afterSaleMapper;
	}

	public void setAfterSaleMapper(AfterSaleMapper afterSaleMapper) {
		this.afterSaleMapper = afterSaleMapper;
	}

	@Override
	public List<Tasks> listAllTasks() {
		// TODO Auto-generated method stub
		return tasksMapper.listAllTasks();
	}

	@Override
	public Tasks getTasksbyId(String taskId) {
		// TODO Auto-generated method stub
		return tasksMapper.getTasksbyId(taskId);
	}

	public StaffMapper getStaffMapper() {
		return staffMapper;
	}

	public void setStaffMapper(StaffMapper staffMapper) {
		this.staffMapper = staffMapper;
	}

	@Override
	public void insertTasks(Tasks tasks) {
		// TODO Auto-generated method stub
		String uuid = UUID.randomUUID().toString();
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		if(tasks != null){
			String serviceRequestId = tasks.getServerId();
			Integer type = tasks.getTaskType();
			List<Annex> annexList = tasks.getAnnexs();
			//服务请求id不能为空
			if(serviceRequestId !=null && !"".equals(serviceRequestId)){
				tasks.setTaskId(uuid);
				tasks.setCreateTime(date);
				tasks.setTaskState(4);
				int result= tasksMapper.insertTasksUUID(tasks);
				
				//赔偿给业主
				if(result>0 && type == 9){
					CompensateObject copens = tasks.getCompensateObject();
					if(copens!=null){
						copens.setTaskId(uuid);
						compensateObjectMapper.insertCompensateObject(copens);
					}
				}
								
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
		return;
	}
	
	@Override
	public void insertTasksList(Tasks tasks) {
		// TODO Auto-generated method stub
		if(tasks != null){
			String serviceRequestId = tasks.getServerId();
			String customerId = tasks.getCustomerId();
			//服务请求id不能为空
			if(serviceRequestId !=null && !"".equals(serviceRequestId)){
				for (Tasks tasks1: tasks.getTasks()) {
					tasks1.setTaskId(UUID.randomUUID().toString());
					tasks1.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
					tasks1.setTaskState(4);
					tasks1.setServerId(serviceRequestId);
					tasks1.setCustomerId(customerId);
					int result= tasksMapper.insertTasksUUID(tasks1);
				}
			}
		}
		return;
	}

	@Override
	public void updateTasks(Tasks tasks) {
		// TODO Auto-generated method stub
		tasksMapper.updateTasks(tasks);
	}

	@Override
	public void deleteTasks(String taskId) {
		// TODO Auto-generated method stub
		tasksMapper.deleteTasks(taskId);
	}

	@Override
	public List<Tasks> getTasksbyServiceRequestId(
			String getTasksbyServiceRequestId) {
		// TODO Auto-generated method stub
		return tasksMapper.getTasksbyServiceRequestId(getTasksbyServiceRequestId);
	}

	@Override
	public String changeTaskState(Tasks tasks) {
		// TODO Auto-generated method stub
		
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		if(tasks != null && Tools.notEmpty(tasks.getTaskId())){
			Integer state = tasks.getTaskState();
			Integer outType = tasks.getTaskOutType();
			//String staffName = tasks.getPrincipal();
			if(tasks.getStaff()!=null && tasks.getPrincipal()==null){
				if(tasks.getStaff().getStaffId()!=null&&!tasks.getStaff().getStaffId().equals("")){
					tasks.setPrincipal(tasks.getStaff().getStaffId());
				}
			}			
			if(state != null && state == 8 && tasks.getTurnSpecialRecordsId()!=null && !"".equals(tasks.getTurnSpecialRecordsId())){//合并
				TaskTurnSpecialRecords tsr = new TaskTurnSpecialRecords();
				tsr.setTaskId(tasks.getTaskId());
				tsr.setTurnSpecialRecordsId(tasks.getTurnSpecialRecordsId());
				Integer result = taskTurnSpecialRecordsMapper.insertTaskTurnSpecialRecords(tsr);
				if(result>0){
					TasksJournal journal = new TasksJournal();
					journal.setTaskId(tasks.getTaskId());
					journal.setOperatorId(tasks.getPrincipal());
					journal.setOperationTime(date);
					journal.setChangeState(state);
					journal.setRemarks(tasks.getRemarks());
					tasksJournalMapper.insertTasksJournal(journal);
					return JsonUtil.success("操作成功!", true);
				}
			}else if(state != null && state == 9 && tasks.getTurnSpecialRecordsId()!=null && !"".equals(tasks.getTurnSpecialRecordsId())){//转专项
				TaskTurnSpecialRecords ttsr = new TaskTurnSpecialRecords();
				ttsr.setTaskId(tasks.getTaskId());
				ttsr.setTurnSpecialRecordsId(tasks.getTurnSpecialRecordsId());
				
				tasks.setPrincipal(null);//
				tasks.setSubordinateId(tasks.getTurnSpecialRecordsId());
				tasks.setSubordinateType(1);
				tasks.setSubordinateTime(new Date());
				
				if(tasksMapper.updateTasks(tasks)>0 && taskTurnSpecialRecordsMapper.insertTaskTurnSpecialRecords(ttsr) > 0){
					TasksJournal journal = new TasksJournal();
					journal.setTaskId(tasks.getTaskId());
					journal.setOperatorId(tasks.getSubordinateOperation());
					journal.setOperationTime(date);
					journal.setChangeState(state);
					journal.setRemarks(tasks.getRemarks());
					tasksJournalMapper.insertTasksJournal(journal);
					return JsonUtil.success("操作成功!", true);
				}
			}else if(state != null && state == 10 && tasks.getProjectId()!= null && !"".equals(tasks.getProjectId())){//转集中处理
				CentralizedProcessingRecords cpr = new CentralizedProcessingRecords();
				cpr.setTaskId(tasks.getTaskId());
				cpr.setProjectId(tasks.getProjectId());
				
				tasks.setPrincipal(null);
				tasks.setSubordinateId(tasks.getProjectId());
				tasks.setSubordinateType(2);
				tasks.setSubordinateTime(new Date());
				
				if(tasksMapper.updateTasks(tasks)>0 && centralizedProcessingRecordsMapper.insertCentralizedProcessingRecords(cpr)>0){
					TasksJournal journal = new TasksJournal();
					journal.setTaskId(tasks.getTaskId());
					journal.setOperatorId(tasks.getSubordinateOperation());
					journal.setOperationTime(date);
					journal.setChangeState(state);
					journal.setRemarks(tasks.getRemarks());
					tasksJournalMapper.insertTasksJournal(journal);
					return JsonUtil.success("操作成功!", true);
				}
			}else if(state !=null && state == 2){
				tasks.setFinishTime(new Date());
				if(tasksMapper.updateTasks(tasks)>0){
					TasksJournal journal = new TasksJournal();
					journal.setTaskId(tasks.getTaskId());
					journal.setOperatorId(tasks.getPrincipal());
					journal.setOperationTime(date);
					journal.setChangeState(state);
					journal.setRemarks(tasks.getRemarks());
					tasksJournalMapper.insertTasksJournal(journal);
					return JsonUtil.success("操作成功!", true);
				}
			}else{
				if(state !=null && state == 3){
					tasks.setTransferPrincipal(null);
				}
				if(tasksMapper.updateTasks(tasks)>0){
					TasksJournal journal = new TasksJournal();
					journal.setTaskId(tasks.getTaskId());
					journal.setOperatorId(tasks.getPrincipal());
					journal.setOperationTime(date);
					journal.setChangeState(state);
					journal.setRemarks(tasks.getRemarks());
					journal.setTaskOutType(outType);
					tasksJournalMapper.insertTasksJournal(journal);
					
					if(state !=null && state == 0){
						List<Tasks> tasksList = new ArrayList<>();
						tasksList = tasksMapper.getTasksbyServiceRequestId(tasks.getServerId());
						int i = 0, j = 0;
						for (; i < tasksList.size(); i++) {
							//任务不等于已完成状态
							if(tasksList.get(i).getTaskState()!=2&&tasksList.get(i).getTaskState()!=0){
								break;
							}
							if(tasksList.get(i).getTaskState()==2){
								j++;
							}
						}
						//任务已是失效以及有完成的任务
						if(i==tasksList.size()){
							ServiceRequest serviceRequest = new ServiceRequest();
							if(serviceRequest.getServiceRequestIds()==null){
								serviceRequest.setServiceRequestIds(new ArrayList<String>());
							}
							serviceRequest.getServiceRequestIds().add(tasks.getServerId());
							//有无完成任务
							if(j==0){
								serviceRequest.setServiceRequestState(0);//无需回访
							}else{
								serviceRequest.setServiceRequestState(1);//待回访
							}
							serviceRequestMapper.changeServiceRequestStateByIds(serviceRequest);
						}
					}
					
					return JsonUtil.success("操作成功!", true);
				}
			}
		}
		return JsonUtil.failure("任务不能为空!", true);
	}
	
	@Override
	public void changeTasksStateById(String taskId, String tasksState, String Type){
		Tasks tasks = new Tasks();
		if(tasks.getTasksIds()==null){
			tasks.setTasksIds(new ArrayList<String>());
		}
		tasks.getTasksIds().add(taskId);
		tasks.setTaskState(Integer.parseInt(tasksState));
		tasksMapper.changeTasksStateByIds(tasks);
		
		TasksJournal journal = new TasksJournal();
		journal.setTaskId(taskId);
		//journal.setOperatorId(tasks.getPrincipal());
		journal.setOperationTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		journal.setChangeState(Integer.parseInt(tasksState));
		if(Type.equals("visit")){
			journal.setRemarks("回访不通过");
		}else if(Type.equals("rollOut")){
			journal.setRemarks("负责人撤销转出");
		}else if(Type.equals("merge")){
			tasksMergeMapper.deleteTasksMergeByLesser(taskId);
			journal.setRemarks("负责人撤销合并");
		}else if(Type.equals("shiftSpecial")){
			journal.setRemarks("负责人转专项");
		}else if(Type.equals("centralized")){
			journal.setRemarks("负责人转集中");
		}
		tasksJournalMapper.insertTasksJournal(journal);
	}

	@Override
	public List<Tasks> getDepartTasksbyServiceRequestId(String serviceRequestId) {
		// TODO Auto-generated method stub
		if(serviceRequestId != null && !"".equals(serviceRequestId)){
			
			List<Tasks> tasksList = new ArrayList<Tasks>();
			
			List<Tasks> tList = tasksMapper.getTasksbyServiceRequestId(serviceRequestId);
			List<ServiceObjectRecords> sorList = serviceObjectRecordsMapper.getServiceObjectRecordsbyServicereId(serviceRequestId);
			
			if(tList != null && tList.size()>0){
				for(Tasks t : tList){
					t.setObjectRecordsList(sorList);
					tasksList.add(t);
				}
				return tasksList;
			}
		}
		return null;
	}

	@Override
	public Tasks getDepartTasksbyTaskId(String taskId) {
		
		if(taskId != null && !"".equals(taskId)){
			Tasks tasks = tasksMapper.getTasksbyId(taskId);
			if(tasks != null){
				
				List<ServiceObjectRecords> sorList = 
					serviceObjectRecordsMapper.getServiceObjectRecordsbyServicereId(tasks.getServerId());
				tasks.setObjectRecordsList(sorList);
				return tasks;
			}
		}
		return null;
	}

	@Override
	public String getTaskCount(String loginId) {
		Map<String,Integer> data = new HashMap<String, Integer>();
		//int[] state = new int[]{3,4,7,2,0};//3,4 待处理    7正在处理 2,0 历史任务
		int[] state = new int[]{4,5,3,2,0};
		Tasks t = new Tasks();
		
		t.setPrincipal(loginId);				//!!!!
		for(int i=0;i<state.length;i++){
			t.setTaskState(state[i]);
			List<Tasks> temp = tasksMapper.getTasksbyLoginId(t);
			data.put("count"+i, temp == null? 0:temp.size());
		}
		return JSONObject.fromObject(data).toString();
	}

	@Override
	public List<Tasks> getTasksbyState(String loginId, String state1,
			String state2) {
		return tasksMapper.getTasksbyLoginIdAndState(loginId, state1, state2);
	}
	
	public String getWebTasksbyState(String loginId, String state1,
			String state2) {
		try {
			List<Tasks> taskList =  tasksMapper.getTasksbyLoginIdAndState(loginId, state1, state2);
			return JsonUtil.success(taskList, true);
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	        return JsonUtil.failure("查询失败", false);
	    } 
	}
	
	@Override
	public PageRestful listPageTasksbyState(Tasks tasks) {
		PageRestful pageRestful = new PageRestful();
		List<Tasks> taskslist = new ArrayList<>();
		taskslist = tasksMapper.listPageTasksbyLoginIdAndState(tasks);
		taskslist.add(0,null);
		pageRestful.setTasks(taskslist);
		pageRestful.setPage(tasks.getPage());
		return pageRestful;
	}

	@Override
	public List<Tasks> getTasksbyTaskTypeAndServiceId(String tasksType , String serviceId) {
		if(Tools.notEmpty(tasksType) && Tools.notEmpty(serviceId)){
			Tasks tasks = new Tasks();
			tasks.setTaskType((Integer.parseInt(tasksType)));
			tasks.setServerId(serviceId);
			return tasksMapper.getTasksbyTaskTypeAndServiceId(tasks);
		}
		return null;
	}

	@Override
	public List<Tasks> getTasksbyProjectId(String projectId) {
		return tasksMapper.getTasksbyProjectId(projectId);
	}

	@Override
	public List<Tasks> getTaskbySubordinateIdAndType1(String type,
			String projectId) {
		return tasksMapper.getTaskbySubordinateIdAndType1(type, projectId);
	}

	@Override
	public List<Tasks> getTaskbySubordinateIdAndType2(String type,
			String projectId) {
		return tasksMapper.getTaskbySubordinateIdAndType2(type, projectId);
	}

	/**
	 * 从售后服务接受数据转换成Tasks对象并存入数据库表
	 */
	@Override
	public void createTasksFromAfterSale(AfterSale afterSale){
		//根据工单id在验房工单表中获取server_id
		InspectorOrder inspectorOrder = inspectorOrderMapper.getInspectorOrderbyId(afterSale.getOrderId());
		//将资产名称和问题描述合成为任务描述taskDescription
		String taskdescription = afterSale.getPropertyName() + afterSale.getDescribe();
		//定义一个Tasks类型的对象，将aftersale中的值放入
		Tasks tasks = new Tasks();
		/***start将服务id，客户id，任务类型，任务状态，任务描述，创建时间放入实例***/
		tasks.setServerId(inspectorOrder.getServiceRequestId());    //服务id
		tasks.setCustomerId(afterSale.getClientId());               //客户id
		tasks.setTaskState(4);										//任务状态
		tasks.setTaskType(1);										//任务类型
		tasks.setTaskDescription(taskdescription);					//任务描述
		tasks.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())); 	//创建时间
		/***end将服务id，客户id，任务类型，任务状态，任务描述，创建时间放入实例***/
		//支持插入操作将数据存入tasks表
		tasksMapper.insertTasks(tasks);
		//修改售后管理表中的对应数据的保修单位值
		afterSaleMapper.updateGuaranteeById(afterSale.getId());
	}

	@Override
	public List<Tasks> getGoingTaskbyStateAndType(String type) {
		if(Tools.notEmpty(type)){
			return tasksMapper.getGoingTaskbyStateAndType(type);
		}
		return null;
	}

	@Override
	public List<Tasks> getHistoryTaskbyStateAndType(String type) {
		if(Tools.notEmpty(type)){
			return tasksMapper.getHistoryTaskbyStateAndType(type);
		}
		return null;
	}
	
	@Override
	public PageRestful listPageTasksByType(Tasks tasks){
		PageRestful pageRestful = new PageRestful();
		List<Tasks> tlist = tasksMapper.listPageTasksByType(tasks);
		tlist.add(0,null);
		pageRestful.setTasks(tlist);
		pageRestful.setPage(tasks.getPage());
		return pageRestful;
	}

	@Override
	public List<Tasks> getTasksbyStaffId(String staffId) {
		if(Tools.notEmpty(staffId)){
			return tasksMapper.getTasksbyStaffId(staffId);
		}
		return null;
	}

	@Override
	public List<Tasks> getTasksbyAddressIdAndType(String type, String addressId) {
		// TODO Auto-generated method stub
		return tasksMapper.getTasksbyAddressIdAndType(type, addressId);
	}

	@Override
	public PageRestful listPageTasksbyStateRestful(Tasks tasks) {
		PageRestful pageRestful = new PageRestful();
		List<Tasks> tlist = tasksMapper.listPageTasksbyState(tasks);
		tlist.add(0,null);
		pageRestful.setTasks(tlist);
		pageRestful.setPage(tasks.getPage());
		return pageRestful;
	}
	/**
	 * 根据服务请求ID查询任务（分页）
	 */

	@Override
	public PageRestful listPageTasksbyServiceRequestId(Tasks tasks) {
		// TODO Auto-generated method stub
		PageRestful pageRestful = new PageRestful();
		List<Tasks> tlist = tasksMapper.listPageTasksbyServiceRequestId(tasks);
		tlist.add(0,null);
		pageRestful.setTasks(tlist);
		pageRestful.setPage(tasks.getPage());
		return pageRestful;
	}
	@Override
	public String changeTasksStateByIds(Tasks tasks) {
		// TODO Auto-generated method stub
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		List<String> tasksIds = tasks.getTasksIds();
		if(tasks != null && tasksIds.size()>0){
			Integer state = tasks.getTaskState();
			if(state != null && state == 8 && tasks.getTurnSpecialRecordsId()!=null && !"".equals(tasks.getTurnSpecialRecordsId())){//合并
				for (String tId : tasksIds) {
					TaskTurnSpecialRecords tsr = new TaskTurnSpecialRecords();
					tsr.setTaskId(tId); 
					tsr.setTurnSpecialRecordsId(tasks.getTurnSpecialRecordsId());
					taskTurnSpecialRecordsMapper.insertTaskTurnSpecialRecords(tsr);
				}
				tasksMapper.changeTasksStateByIds(tasks);
			}else if(state != null && state == 9 && tasks.getTurnSpecialRecordsId()!=null && !"".equals(tasks.getTurnSpecialRecordsId())){//转专项
				for (String tId : tasksIds) {
					TaskTurnSpecialRecords ttsr = new TaskTurnSpecialRecords();
					ttsr.setTaskId(tId);
					ttsr.setTurnSpecialRecordsId(tasks.getTurnSpecialRecordsId());
					
					tasks.setPrincipal(null);//
					tasks.setSubordinateId(tasks.getTurnSpecialRecordsId());
					tasks.setSubordinateType(1);
					tasks.setSubordinateTime(new Date());
					
					tasksMapper.updateTasks(tasks);
					taskTurnSpecialRecordsMapper.insertTaskTurnSpecialRecords(ttsr);
				}
			}else if(state != null && state == 10 && tasks.getProjectId()!= null && !"".equals(tasks.getProjectId())){//转集中处理
				for (String tId : tasksIds) {
					CentralizedProcessingRecords cpr = new CentralizedProcessingRecords();
					cpr.setTaskId(tId);
					cpr.setProjectId(tasks.getProjectId());
					
					tasks.setPrincipal(null);
					tasks.setSubordinateId(tasks.getProjectId());
					tasks.setSubordinateType(2);
					tasks.setSubordinateTime(new Date());
					
					tasksMapper.updateTasks(tasks);
					centralizedProcessingRecordsMapper.insertCentralizedProcessingRecords(cpr);
				}
			}else if(state != null && state == 2){
				tasks.setFinishTime(new Date());
				tasksMapper.changeTasksStateByIds(tasks);
			}else{
				tasksMapper.changeTasksStateByIds(tasks);
			}
			for (String tId : tasksIds) {
				TasksJournal journal = new TasksJournal();
				journal.setTasksJournalId(UUID.randomUUID().toString());
				journal.setTaskId(tasks.getTaskId());
				journal.setOperatorId(tasks.getPrincipal());
				journal.setOperationTime(date);
				journal.setChangeState(state);
				journal.setRemarks(tasks.getRemarks());
				tasksJournalMapper.insertTasksJournal(journal);
			}
			return JsonUtil.success("操作成功!", true); 
		}
		return JsonUtil.failure("任务不能为空!", true);
	}

	@Override
	public PageRestful listPageGetTasksbyServiceRequestId(Tasks tasks) {
		// TODO Auto-generated method stub
		PageRestful pageRestful = new PageRestful();
		List<Tasks> list = tasksMapper.listPageGetTasksbyServiceRequestId(tasks);
		list.add(0, tasks);
		pageRestful.setTasks(list);
		pageRestful.setPage(tasks.getPage());
		return pageRestful;
	}

	@Override
	public void insertTasksRes(Tasks tasks) {
		// TODO Auto-generated method stub
		String uuid = UUID.randomUUID().toString();
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		if(tasks != null){
			String serviceRequestId = tasks.getServerId();
			Integer type = tasks.getTaskType();
			//服务请求id不能为空
			if(serviceRequestId !=null && !"".equals(serviceRequestId)){
				tasks.setTaskId(uuid);
				tasks.setCreateTime(date);
				tasks.setTaskState(4);
				tasks.setTaskType(type);
				tasksMapper.insertTasksUUID(tasks);
				
			}
		}
		
	}
	
	@Override
	public List<Tasks> getTasksbyUserIdAndState() {
		return tasksMapper.getTasksbyUserIdAndState();
	}

	@Override
	public void insertTasksAll(Tasks tasks) {
		// TODO Auto-generated method stub
		String uuid = UUID.randomUUID().toString();
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		List<Tasks> task =tasks.getTasks();
		if (tasks !=null) {
		
			if ( task !=null && task.size()>0) {
			
				for (Tasks tis : task) {
					String serviceRequestId = tis.getServerId();
					if(serviceRequestId !=null && !"".equals(serviceRequestId)){
					Integer type = tis.getTaskType();
					tis.setTaskId(uuid);
					tis.setCreateTime(date);
					tis.setTaskState(4);
					Integer result = tasksMapper.insertTasks(tis);
					//赔偿给业主
					if(result>0 && type == 9){
						CompensateObject copens = tis.getCompensateObject();
						if(copens!=null){
							copens.setTaskId(uuid);
							compensateObjectMapper.insertCompensateObject(copens);
						}
					}
				}
			}
		  }
		}
	}

	@Override
	public String getTasksByLoginName(String loginName, String taskState) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("loginName", loginName);
		if(taskState != null && !"".equals(taskState)){
			map.put("taskState", taskState);
		}
		List<Tasks> tasksList = tasksMapper.getTasksByLoginNameAndState(map);
		if(tasksList != null && tasksList.size()>0){
			return JsonUtil.success(tasksList, true);
		}
		return JsonUtil.failure("查询失败", false);
	}

	@Override
	public String getTasksPool() {
		List<Tasks> tasksList = tasksMapper.getTasksPool();
		if(tasksList != null && tasksList.size()>0){
			return JsonUtil.success(tasksList, true);
		}
		return JsonUtil.failure("查询失败", false);
	}

	@Override
	public String getTasksInfoByTasksId(String tasksId) {
		Tasks tasks = tasksMapper.getTasksInfoByTasksId(tasksId);
		if(tasks != null){
			return JsonUtil.success(tasks, true);
		}
		return JsonUtil.failure("查询失败", false);
	}

	@Override
	public String acceptTasks(String loginName, String tasksId) {
		try {
			Tasks tasks = tasksMapper.getTasksbyId(tasksId);
			if(tasks.getTaskState() == 7){
				tasks.setTaskState(3);
				tasksMapper.updateTasks(tasks);
			} else {
				tasks.setTaskState(3);
				Staff staff = staffMapper.selectStaffByLoginName(loginName); 
				tasks.setPrincipal(staff.getStaffId());
				tasksMapper.updateTasks(tasks);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JsonUtil.failure("接受失败", false);
		}
		return JsonUtil.success("接受成功", true);
	}
	
	@Override
	public PageRestful listPageTaskbySubordinateIdAndType1(Tasks tasks) {
		PageRestful pageRestful = new PageRestful();
		List<Tasks> taskslist = new ArrayList<>();
		taskslist = tasksMapper.listPageTaskbySubordinateIdAndType1(tasks);
		taskslist.add(0,null);
		pageRestful.setTasks(taskslist);
		pageRestful.setPage(tasks.getPage());
		return pageRestful;
	}


	@Override
	public PageRestful listPageTaskbySubordinateIdAndType2(Tasks tasks) {
		PageRestful pageRestful = new PageRestful();
		List<Tasks> taskslist = new ArrayList<>();
		taskslist = tasksMapper.listPageTaskbySubordinateIdAndType2(tasks);
		taskslist.add(0,null);
		pageRestful.setTasks(taskslist);
		pageRestful.setPage(tasks.getPage());
		return pageRestful;
	}

	@Override
	public String getTaskPoolsCountBytaskType(String taskType) {
		// TODO Auto-generated method stub
		Integer in;
		in = tasksMapper.getTaskPoolsCountBytaskType(taskType);
		return JsonUtil.success(in, true);
	}

	@Override
	public java.util.List<Tasks> getInspectionTasksbyId(String taskId) {
		
		return tasksMapper.getInspectionTasksbyId(taskId);
	}

}
