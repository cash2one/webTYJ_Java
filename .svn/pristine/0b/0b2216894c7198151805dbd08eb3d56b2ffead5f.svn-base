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

import com.flf.entity.ConstructionCheckOrders;

@WebService
@Path("/ConstructionCheckOrders")
public interface ConstructionCheckOrdersService {
	/**
	 * 查询所有施工核查工单
	 * @return
	 */
	@GET
	@Path("/listAllConstructionCheckOrders")
	@Produces(MediaType.APPLICATION_JSON)
	List<ConstructionCheckOrders> listAllConstructionCheckOrders();
	
	/**
	 * 新增施工核查工单
	 * @param ConstructionCheckOrders
	 */
	@POST
	@Path("/insertConstructionCheckOrders")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public ConstructionCheckOrders insertConstructionCheckOrders(ConstructionCheckOrders constructionCheckOrders);
	
	/**
	 * 根据id查询施工核查工单
	 * @param orderId
	 * @return
	 */
	@GET
	@Path("/getConstructionCheckOrdersbyId/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	ConstructionCheckOrders getConstructionCheckOrdersbyId(@PathParam("orderId") String orderId);
	
	/**
	 * 根据工单类型和任务id查询施工核查工单
	 * @param orderId
	 * @return
	 */
	@GET
	@Path("/getConstructionCheckOrdersbyTypeAndTaskId/{orderType}/{taskId}")
	@Produces(MediaType.APPLICATION_JSON)
	ConstructionCheckOrders getConstructionCheckOrdersbyTypeAndTaskId(@PathParam("orderType") String orderType,@PathParam("taskId") String taskId);
	
	/**
	 * 修改施工核查工单
	 * @param ConstructionCheckOrders
	 */
	@PUT
	@Path("/updateConstructionCheckOrders")
	@Consumes({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public void updateConstructionCheckOrders(ConstructionCheckOrders constructionCheckOrders);
	
	/**
	 * 关闭施工核查工单
	 * @param ConstructionCheckOrders
	 */
	@PUT
	@Path("/closeConstructionCheckOrders")
	@Consumes({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public void closeConstructionCheckOrders(ConstructionCheckOrders constructionCheckOrders);
}
