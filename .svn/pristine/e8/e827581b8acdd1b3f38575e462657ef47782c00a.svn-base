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

import com.flf.entity.CheckItemRecords;

/**
 * 检测项结果记录表
 * 
 * @author 邵政 
 * 2015-7-2
 */
@WebService
@Path("/CheckItemRecords")
public interface CheckItemRecordsService {
	
	
	/**
	 * 查询所有检测信息记录
	 * @return
	 */
	@GET
	@Path("/listAllCheckItemRecords")
	@Produces(MediaType.APPLICATION_JSON)
	List<CheckItemRecords> listAllCheckItemRecords();
	
	/**
	 * 修改检测信息记录
	 * @param disposeInformationRecords
	 */
	@PUT
	@Path("/updateCheckItemRecords")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void updateCheckItemRecords(CheckItemRecords checkItemRecords);
	
	/**
	 * 删除检测信息记录
	 * @param serverId
	 */
	@DELETE
	@Path("/deleteCheckItemRecords/{recordId}")
	public void deleteCheckItemRecords(@PathParam("recordId") String recordId);
	
	
	/**
	 * 添加检测信息记录
	 * @param checkItemRecords
	 */
	@POST
	@Path("/insertCheckItemRecords")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void insertCheckItemRecords(CheckItemRecords checkItemRecords);
	
	/**
	 * 通过Id查询检测信息记录
	 * @param orderId
	 * @return
	 */
	@GET
	@Path("/getCheckItemRecordsbyId/{recordId}")
	@Produces(MediaType.APPLICATION_JSON)
	CheckItemRecords getCheckItemRecordsbyId(@PathParam("recordId") String recordId);
}
