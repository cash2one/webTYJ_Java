package com.flf.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.TasksJournal;
@WebService
@Path("/TasksJournal")
/**
 * 任务日志表
 * 创建人：邵政
 * 创建时间：2015/6/23
 */
public interface TasksJournalService {

    List<TasksJournal> listPageTasksJournal(TasksJournal tasksJournal);//分页查询任务日志信息
	
	/**
	 * 查询所有任务日志信息
	 * @return
	 */
	@GET
	@Path("/listAllTasksJournal")
	@Produces(MediaType.APPLICATION_JSON)
	List<TasksJournal> listAllTasksJournal();
	
	/**
	 * 通过Id查询任务日志信息
	 * @param serverId
	 * @return
	 */
	@GET
	@Path("/getTasksJournalbyId/{tasksJournalId}")
	@Produces(MediaType.APPLICATION_JSON)
	TasksJournal getTasksJournalbyId(@PathParam("tasksJournalId") String tasksJournalId);
	
	/**
	 * 添加任务日志信息
	 * @param tasksJournal
	 */
	@POST
	@Path("/insertTasksJournal")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void insertTasksJournal(TasksJournal tasksJournal);
	
	/**
	 * 修改任务日志信息
	 * @param tasksJournal
	 */
	@PUT
	@Path("/updateTasksJournal")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void updateTasksJournal(TasksJournal tasksJournal);
	
	/**
	 * 删除任务日志信息
	 * @param serverId
	 */
	@DELETE
	@Path("/deleteTasksJournal/{tasksJournalId}")
	public void deleteTasksJournal(@PathParam("tasksJournalId") String tasksJournalId);
	
	/**
	 * 通过任务Id查询任务日志信息
	 * @param tasksId
	 * @return
	 */
	@GET
	@Path("/getTasksJournalbyTasksId/{tasksId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TasksJournal> getTasksJournalbyTasksId(@PathParam("tasksId") String tasksId);
	
	/**
	 * 通过时间和类型查询任务日志
	 * 0.报价单 1.处理 2.验收  3.检测  4.结算 5.赔偿给业主
	 * @param creOrderType
	 * @param operationTime
	 * @return
	 */
	@GET
	@Path("/getTasksJournalbyDateandType/{creOrderType}/{operationTime}")
	@Produces(MediaType.APPLICATION_JSON)
	public TasksJournal getTasksJournalbyDateandType(@PathParam("creOrderType") String creOrderType,@PathParam("operationTime") String operationTime);
	
}





