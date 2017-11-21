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

import com.flf.entity.TasksMerge;
@WebService
@Path("/TasksMerge")
/**
 * 合并任务表
 * 创建人：邵政
 * 创建时间：2015-7-7
 */
public interface TasksMergeService {

	/**
	 * 查询所有合并任务信息
	 * @return
	 */
	@GET
	@Path("/listAllTasksMerge")
	@Produces(MediaType.APPLICATION_JSON)
	List<TasksMerge> listAllTasksMerge();
	
	/**
	 * 通过Id查询合并任务信息
	 * @param serverId
	 * @return
	 */
	@GET
	@Path("/getTasksMergebyId/{tasksMergeId}")
	@Produces(MediaType.APPLICATION_JSON)
	TasksMerge getTasksMergebyId(@PathParam("tasksMergeId") String tasksMergeId);
	
	/**
	 * 添加合并任务信息
	 * @param tasksMerge
	 */
	@POST
	@Path("/insertTasksMerge")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public String insertTasksMerge(TasksMerge tasksMerge);
	
	
	/**
	 * 修改合并任务信息
	 * @param tasksMerge
	 */
	@PUT
	@Path("/updateTasksMerge")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void updateTasksMerge(TasksMerge tasksMerge);
	
	/**
	 * 删除合并任务信息
	 * @param serverId
	 */
	@DELETE
	@Path("/deleteTasksMerge/{tasksMergeId}/{operatorId}")
	public String deleteTasksMerge(@PathParam("tasksMergeId") String tasksMergeId, @PathParam("operatorId") String operatorId);
	
}





