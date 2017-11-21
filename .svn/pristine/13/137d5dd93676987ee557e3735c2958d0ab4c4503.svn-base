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

import com.flf.entity.DisposeInformationRecords;
@WebService
@Path("/DisposeInformationRecords")
/**
 * 处理信息记录表
 * 创建人：邵政
 * 创建时间：2015-7-2
 */
public interface DisposeInformationRecordsService {

    List<DisposeInformationRecords> listPageDisposeInformationRecords(DisposeInformationRecords disposeInformationRecords);//分页查询处理信息记录
	
	/**
	 * 查询所有处理信息记录
	 * @return
	 */
	@GET
	@Path("/listAllDisposeInformationRecords")
	@Produces(MediaType.APPLICATION_JSON)
	List<DisposeInformationRecords> listAllDisposeInformationRecords();
	
	/**
	 * 通过Id查询处理信息记录
	 * @param orderId
	 * @return
	 */
	@GET
	@Path("/getDisposeInformationRecordsbyId/{recordId}")
	@Produces(MediaType.APPLICATION_JSON)
	DisposeInformationRecords getDisposeInformationRecordsbyId(@PathParam("recordId") String recordId);
	
	/**
	 * 添加处理信息记录
	 * @param disposeInformationRecords
	 */
	@POST
	@Path("/insertDisposeInformationRecords")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void insertDisposeInformationRecords(DisposeInformationRecords disposeInformationRecords);
	
	/**
	 * 修改处理信息记录
	 * @param disposeInformationRecords
	 */
	@PUT
	@Path("/updateDisposeInformationRecords")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void updateDisposeInformationRecords(DisposeInformationRecords disposeInformationRecords);
	
	/**
	 * 删除处理信息记录
	 * @param serverId
	 */
	@DELETE
	@Path("/deleteDisposeInformationRecords/{recordId}")
	public void deleteDisposeInformationRecords(@PathParam("recordId") String recordId);
	
}





