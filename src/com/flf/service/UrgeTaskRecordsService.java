package com.flf.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.PageRestful;
import com.flf.entity.UrgeTaskRecords;

/**
 * 催办记录
 * @author shaozheng
 *	2015-8-26
 */
@WebService
@Path("/UrgeTaskRecords")
public interface UrgeTaskRecordsService {
	/**
	 * 通过任务id获取催办任务记录表
	 * @param taskId
	 * @return
	 */
	@GET
	@Path("/getUrgeTaskRecordsbyTaskId/{taskId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UrgeTaskRecords> getUrgeTaskRecordsbyTaskId(@PathParam("taskId") String taskId);
	
	/**
	 * 添加催办任务记录表
	 * @param urgeTaskRecords
	 */
	@POST
	@Path("/insertUrgeTaskRecords")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void insertUrgeTaskRecords(UrgeTaskRecords urgeTaskRecords);
	
	/**
	 * 通过任务id获取催办记录个数
	 * @param taskId
	 * @return
	 */
	@GET
	@Path("/getUrgeTaskRecordsCount/{taskId}")
	@Produces(MediaType.APPLICATION_JSON)
	public int getUrgeTaskRecordsCount(@PathParam("taskId") String taskId);
	
	/**
	 * 催办任务分页
	 * @param urgeTaskRecords
	 * @return
	 */
	@POST
	@Path("/listPageUrgeTaskRecordsRestful")
	@Produces(MediaType.APPLICATION_JSON)
	PageRestful listPageUrgeTaskRecordsRestful(UrgeTaskRecords urgeTaskRecords);
	
	
	
	/**
	 * 催办次数调侃语句
	 * @param urgeSum
	 * @return
	 */
	@POST
	@Path("/getUrgeTaskRidicule/{urgeSum}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getUrgeTaskRidicule(@PathParam("urgeSum") int urgeSum);
}
