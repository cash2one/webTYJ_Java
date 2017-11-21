package com.flf.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.RenovationInspectionOrders;

/**
 * 装修巡检单Service
 * @author 倪明
 * 2015/08/18
 */
@WebService
@Path("/RenovationInspectionOrders")
public interface RenovationInspectionOrdersService {

	/**
	 * 查询所有装修巡检单
	 * @return
	 */
	@GET
	@Path("/listAllRenovationInspectionOrders")
	@Produces(MediaType.APPLICATION_JSON)
	List<RenovationInspectionOrders> listAllRenovationInspectionOrders();
	
	/**
	 * 新建装修巡检单
	 * @param renovationInspectionOrders
	 */
	@POST
	@Path("/insertRenovationInspectionOrders")
	@Consumes({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public void insertRenovationInspectionOrders(RenovationInspectionOrders renovationInspectionOrders);
	
	/**
	 * 根据id查询装修巡检单
	 * @param orderId
	 * @return
	 */
	@GET
	@Path("/getRenovationInspectionOrdersbyId/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	RenovationInspectionOrders getRenovationInspectionOrdersbyId(@PathParam("orderId") String orderId);
	
	/**
	 * 根据工单类型和任务id查询装修巡检单
	 * @param orderId
	 * @return
	 */
	@GET
	@Path("/getRenovationInspectionOrdersbyTypeAndTaskId/{orderType}/{taskId}")
	@Produces(MediaType.APPLICATION_JSON)
	RenovationInspectionOrders getRenovationInspectionOrdersbyTypeAndTaskId(@PathParam("orderType") String orderType,@PathParam("taskId") String taskId);
	
	/**
	 * 修改装修巡检单
	 * @param renovationInspectionOrders
	 */
	@PUT
	@Path("/updateRenovationInspectionOrders")
	@Consumes({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public void updateRenovationInspectionOrders(RenovationInspectionOrders renovationInspectionOrders);
	
	/**
	 * 关闭装修巡检单
	 * @param renovationInspectionOrders
	 */
	@PUT
	@Path("/closeRenovationInspectionOrders")
	@Consumes({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public void closeRenovationInspectionOrders(RenovationInspectionOrders renovationInspectionOrders);
	
}
