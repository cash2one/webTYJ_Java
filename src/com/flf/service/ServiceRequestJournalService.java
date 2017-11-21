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

import com.flf.entity.ServiceRequestJournal;
@WebService
@Path("/ServiceRequestJournal")
/**
 * 服务请求日志表
 * 创建人：邵政
 * 创建时间：2015/6/23
 */
public interface ServiceRequestJournalService {

    List<ServiceRequestJournal> listPageServiceRequestJournal(ServiceRequestJournal serviceRequestJournal);//分页查询服务请求日志
	
	/**
	 * 查询所有服务请求日志
	 * @return
	 */
	@GET
	@Path("/listAllServiceRequestJournal")
	@Produces(MediaType.APPLICATION_JSON)
	List<ServiceRequestJournal> listAllServiceRequestJournal();
	
	/**
	 * 通过Id查询服务请求日志
	 * @param serverId
	 * @return
	 */
	@GET
	@Path("/getServiceRequestJournalbyId/{serviceRequestJournalId}")
	@Produces(MediaType.APPLICATION_JSON)
	ServiceRequestJournal getServiceRequestJournalbyId(@PathParam("serviceRequestJournalId") String serviceRequestJournalId);
	
	/**
	 * 添加服务请求日志
	 * @param serviceRequestJournal
	 */
	@POST
	@Path("/insertServiceRequestJournal")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void insertServiceRequestJournal(ServiceRequestJournal serviceRequestJournal);
	
	/**
	 * 修改服务请求日志
	 * @param serviceRequestJournal
	 */
	@PUT
	@Path("/updateServiceRequestJournal")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void updateServiceRequestJournal(ServiceRequestJournal serviceRequestJournal);
	
	/**
	 * 删除服务请求日志
	 * @param serverId
	 */
	@DELETE
	@Path("/deleteServiceRequestJournal/{serviceRequestJournalId}")
	public void deleteServiceRequestJournal(@PathParam("serviceRequestJournalId") String serviceRequestJournalId);
	
}





