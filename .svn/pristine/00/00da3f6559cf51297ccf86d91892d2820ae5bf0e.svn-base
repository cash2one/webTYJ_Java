package com.flf.service;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.DepartmentOrders;

/**
 * 部门质检工单
 * @author shaozheng
 * 2015-7-14
 */
@WebService
@Path("/DepartmentOrders")
public interface DepartmentOrdersService {
	/**
	 * 添加部门质检工单
	 * @param departmentOrders
	 */
	@POST
	@Path("/insertDepartmentOrders")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void insertDepartmentOrders(DepartmentOrders departmentOrders);
	
	/**
	 * 通过工单id获取部门质检工单
	 * @param orderId
	 * @return
	 */
	@GET
	@Path("/getDepartmentOrdersbyId/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	public DepartmentOrders getDepartmentOrdersbyId(String orderId);
	
	/**
	 * 通过任务id获取部门质检工单
	 * @param taskId
	 * @return
	 */
	@GET
	@Path("/getDepartmentOrdersbyTaskId/{taskId}")
	@Produces(MediaType.APPLICATION_JSON)
	public DepartmentOrders getDepartmentOrdersbyTaskId(String taskId);
	
	/**
	 * 关闭部门质检工单
	 * @param departmentOrders
	 */
	@PUT
	@Path("/closeDepartmentOrders")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void closeDepartmentOrders(DepartmentOrders departmentOrders);
}
