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

import com.flf.entity.RenovationAcceptanceOrders;

/**
 * 装修验收单Service
 * @author 倪明
 * 2015/08/18
 */
@WebService
@Path("/RenovationAcceptanceOrders")
public interface RenovationAcceptanceOrdersService {

	/**
	 * 查询所有装修验收单
	 * @return
	 */
	@GET
	@Path("/listAllRenovationAcceptanceOrders")
	@Produces(MediaType.APPLICATION_JSON)
	List<RenovationAcceptanceOrders> listAllRenovationAcceptanceOrders();
	
	/**
	 * 新建装修验收单
	 * @param renovationInspectionOrders
	 */
	@POST
	@Path("/insertRenovationAcceptanceOrders")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public RenovationAcceptanceOrders insertRenovationAcceptanceOrders(RenovationAcceptanceOrders renovationAcceptanceOrders);
	
	/**
	 * 根据id查询装修验收单
	 * @param orderId
	 * @return
	 */
	@GET
	@Path("/getRenovationAcceptanceOrdersbyId/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	RenovationAcceptanceOrders getRenovationAcceptanceOrdersbyId(@PathParam("orderId") String orderId);
	/**
	 * 根据工单类型和任务id查询装修验收单
	 * @param orderId
	 * @return
	 */
	@GET
	@Path("/getRenovationAcceptanceOrdersbyTypeAndTaskId/{orderType}/{taskId}")
	@Produces(MediaType.APPLICATION_JSON)
	RenovationAcceptanceOrders getRenovationAcceptanceOrdersbyTypeAndTaskId(@PathParam("orderType") String orderType,@PathParam("taskId") String taskId);
	/**
	 * 修改装修验收单
	 * @param renovationInspectionOrders
	 */
	@PUT
	@Path("/updateRenovationAcceptanceOrders")
	@Consumes({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public void updateRenovationAcceptanceOrders(RenovationAcceptanceOrders renovationAcceptanceOrders);
	
	/**
	 * 关闭装修验收单
	 * @param renovationInspectionOrders
	 */
	@PUT
	@Path("/closeRenovationAcceptanceOrders")
	@Consumes({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public void closeRenovationAcceptanceOrders(RenovationAcceptanceOrders renovationAcceptanceOrders);
	
}

