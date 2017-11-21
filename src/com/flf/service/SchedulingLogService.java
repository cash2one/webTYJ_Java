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

import com.flf.entity.SchedulingLog;

@WebService
@Path("/SchedulingLog")

public interface SchedulingLogService {//排班日志表
	List<SchedulingLog> listAllSchedulingLog();//查询所有排班日志表
	SchedulingLog getSchedulingLog(int id);//根据Id查询排班日志表
	int insertSchedulingLog(SchedulingLog schedulingLog);//添加排班日志表信息
	int updateSchedulingLog(SchedulingLog schedulingLog);//修改排班日志表信息
	int deleteSchedulingLog(int id);//删除排班日志表信息

	/**
	 * 查询所有排班日志
	 * @return
	 */
	@GET
	@Path("/listPageschedulingLog")
	@Produces(MediaType.APPLICATION_JSON)
	List<SchedulingLog> listPageschedulingLog();

	/**
	 * 根据Id查询排班日志
	 * @param id
	 * @return
	 */
	@GET
	@Path("/getSchedulingLogById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	SchedulingLog getSchedulingLogByIdRest(@PathParam("id") Integer id);

	/**
	 * 添加排班日志
	 * @param schedulingLog
	 */
	@POST
	@Path("/AddSchedulingLog")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void AddSchedulingLog(SchedulingLog schedulingLog);
	
	/**
	 * 修改排班日志
	 * @param schedulingLog
	 */
	@PUT
	@Path("/UpdateSchedulingLog")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void UpdateSchedulingLog(SchedulingLog schedulingLog);
	
	/**
	 * 删除排班日志
	 * @param id
	 */
	@DELETE
	@Path("/DeleteSchedulingLogById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void DeleteSchedulingLogById(@PathParam("id") Integer id);
	
}
