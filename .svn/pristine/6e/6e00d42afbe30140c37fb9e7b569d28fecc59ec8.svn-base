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

import com.flf.entity.RenovationCheckOrders;

/**
 * 装修核查单Service
 * @author 倪明
 * 2015/08/18
 */
@WebService
@Path("/RenovationCheckOrders")
public interface RenovationCheckOrdersService {
	/**
	 * 查询所有装修核查工单
	 * @return
	 */
	@GET
	@Path("/listAllRenovationCheckOrders")
	@Produces(MediaType.APPLICATION_JSON)
	List<RenovationCheckOrders> listAllRenovationCheckOrders();
	
	/**
	 * 新增装修核查工单
	 * @param renovationCheckOrders
	 */
	@POST
	@Path("/insertRenovationCheckOrders")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public RenovationCheckOrders insertRenovationCheckOrders(RenovationCheckOrders renovationCheckOrders);
	
	/**
	 * 根据id查询装修核查工单
	 * @param orderId
	 * @return
	 */
	@GET
	@Path("/getRenovationCheckOrdersbyId/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	RenovationCheckOrders getRenovationCheckOrdersbyId(@PathParam("orderId") String orderId);
	
	/**
	 * 根据任务id和类型查询装修核查工单
	 * @param orderId
	 * @return
	 */
	@GET
	@Path("/getRenovationCheckOrdersbyTypeAndTaskId/{orderType}/{taskId}")
	@Produces(MediaType.APPLICATION_JSON)
	RenovationCheckOrders getRenovationCheckOrdersbyTypeAndTaskId(@PathParam("orderType") String orderType,@PathParam("taskId") String taskId);
	
	/**
	 * 修改装修核查工单
	 * @param renovationCheckOrders
	 */
	@PUT
	@Path("/updateRenovationCheckOrders")
	@Consumes({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public void updateRenovationCheckOrders(RenovationCheckOrders renovationCheckOrders);
	
	/**
	 * 关闭装修核查工单
	 * @param renovationCheckOrders
	 */
	@PUT
	@Path("/closeRenovationCheckOrders")
	@Consumes({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public void closeRenovationCheckOrders(RenovationCheckOrders renovationCheckOrders);
}
