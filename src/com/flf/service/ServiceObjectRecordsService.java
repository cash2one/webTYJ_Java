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

import com.flf.entity.ServiceObjectRecords;
@WebService
@Path("/ServiceObjectRecords")
/**
 * 服务对象记录表
 * 创建人：邵政
 * 创建时间：2015/6/25
 */
public interface ServiceObjectRecordsService {

	/**
	 * 查询所有服务对象记录
	 * @return
	 */
	@GET
	@Path("/listAllServiceObjectRecords")
	@Produces(MediaType.APPLICATION_JSON)
	List<ServiceObjectRecords> listAllServiceObjectRecords();
	
	/**
	 * 通过Id查询服务对象记录
	 * @param serverId
	 * @return
	 */
	@GET
	@Path("/getServiceObjectRecordsbyId/{recordId}")
	@Produces(MediaType.APPLICATION_JSON)
	ServiceObjectRecords getServiceObjectRecordsbyId(@PathParam("recordId") String recordId);
	
	/**
	 * 添加服务对象记录
	 * @param serviceObjectRecords
	 */
	@POST
	@Path("/insertServiceObjectRecords")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void insertServiceObjectRecords(ServiceObjectRecords serviceObjectRecords);
	
	/**
	 * 修改服务对象记录
	 * @param serviceObjectRecords
	 */
	@PUT
	@Path("/updateServiceObjectRecords")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void updateServiceObjectRecords(ServiceObjectRecords serviceObjectRecords);
	
	/**
	 * 删除服务对象记录
	 * @param serverId
	 */
	@DELETE
	@Path("/deleteServiceObjectRecords/{recordId}")
	public void deleteServiceObjectRecords(@PathParam("recordId") String recordId);
	
	/**
	 * 根据员工id和服务请求id查询服务对象信息
	 * @param serviceId
	 * @param staffId
	 * @return
	 */
	@GET
	@Path("/getServiceObjectRecordsbyRequestAndStaff/{serviceId}/{staffId}")
	@Produces(MediaType.APPLICATION_JSON)
	public ServiceObjectRecords getServiceObjectRecordsbyRequestAndStaff(
			@PathParam("serviceId") String serviceId,@PathParam("staffId") String staffId);
}





