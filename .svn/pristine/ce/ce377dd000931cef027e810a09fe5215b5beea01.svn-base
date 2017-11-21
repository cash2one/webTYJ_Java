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

import com.flf.entity.ConstructionInspectionOrders;

@WebService
@Path("/ConstructionInspectionOrders")
public interface ConstructionInspectionOrdersService {
	/**
	 * 查询所有施工巡检单
	 * @return
	 */
	@GET
	@Path("/listAllConstructionInspectionOrders")
	@Produces(MediaType.APPLICATION_JSON)
	List<ConstructionInspectionOrders> listAllConstructionInspectionOrders();
	
	/**
	 * 新建施工巡检单
	 * @param ConstructionInspectionOrders
	 */
	@POST
	@Path("/insertConstructionInspectionOrders")
	@Consumes({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public void insertConstructionInspectionOrders(ConstructionInspectionOrders constructionInspectionOrders);
	
	/**
	 * 根据id查询施工巡检单
	 * @param orderId
	 * @return
	 */
	@GET
	@Path("/getConstructionInspectionOrdersbyId/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	ConstructionInspectionOrders getConstructionInspectionOrdersbyId(@PathParam("orderId") String orderId);
	
	/**
	 * 根据工单类型和任务id查询施工巡检工单
	 * @param orderId
	 * @return
	 */
	@GET
	@Path("/getConstructionInspectionOrdersbyTypeAndTaskId/{orderType}/{taskId}")
	@Produces(MediaType.APPLICATION_JSON)
	ConstructionInspectionOrders getConstructionInspectionOrdersbyTypeAndTaskId(@PathParam("orderType") String orderType,@PathParam("taskId") String taskId);
	
	
	/**
	 * 修改施工巡检单
	 * @param ConstructionInspectionOrders
	 */
	@PUT
	@Path("/updateConstructionInspectionOrders")
	@Consumes({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public void updateConstructionInspectionOrders(ConstructionInspectionOrders constructionInspectionOrders);
	
	/**
	 * 关闭施工巡检单
	 * @param ConstructionInspectionOrders
	 */
	@PUT
	@Path("/closeConstructionInspectionOrders")
	@Consumes({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public void closeConstructionInspectionOrders(ConstructionInspectionOrders constructionInspectionOrders);
}
