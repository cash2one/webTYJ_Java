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

import com.flf.entity.ConstructionAcceptanceOrders;

@WebService
@Path("/ConstructionAcceptanceOrders")
public interface ConstructionAcceptanceOrdersService {

	/**
	 * 查询所有施工验收单
	 * @return
	 */
	@GET
	@Path("/listAllConstructionAcceptanceOrders")
	@Produces(MediaType.APPLICATION_JSON)
	List<ConstructionAcceptanceOrders> listAllConstructionAcceptanceOrders();
	
	/**
	 * 新建施工验收单
	 * @param ConstructionAcceptanceOrders
	 */
	@POST
	@Path("/insertConstructionAcceptanceOrders")
	@Consumes({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public ConstructionAcceptanceOrders insertConstructionAcceptanceOrders(ConstructionAcceptanceOrders constructionAcceptanceOrders);
	
	/**
	 * 根据id查询施工验收单
	 * @param orderId
	 * @return
	 */
	@GET
	@Path("/getConstructionAcceptanceOrdersbyId/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	ConstructionAcceptanceOrders getConstructionAcceptanceOrdersbyId(@PathParam("orderId") String orderId);
	
	/**
	 * 根据工单类型和任务id查询施工验收工单
	 * @param orderId
	 * @return
	 */
	@GET
	@Path("/getConstructionAcceptanceOrdersbyTypeAndTaskId/{orderType}/{taskId}")
	@Produces(MediaType.APPLICATION_JSON)
	ConstructionAcceptanceOrders getConstructionAcceptanceOrdersbyTypeAndTaskId(@PathParam("orderType") String orderType,@PathParam("taskId") String taskId);
	
	
	/**
	 * 修改施工验收单
	 * @param ConstructionAcceptanceOrders
	 */
	@PUT
	@Path("/updateConstructionAcceptanceOrders")
	@Consumes({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public void updateConstructionAcceptanceOrders(ConstructionAcceptanceOrders constructionAcceptanceOrders);
	
	/**
	 * 关闭施工验收单
	 * @param ConstructionAcceptanceOrders
	 */
	@PUT
	@Path("/closeConstructionAcceptanceOrders")
	@Consumes({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public void closeConstructionAcceptanceOrders(ConstructionAcceptanceOrders constructionAcceptanceOrders);
}
