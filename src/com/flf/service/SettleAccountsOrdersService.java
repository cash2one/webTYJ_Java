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

import com.flf.entity.QuoteItemRecords;
import com.flf.entity.SettleAccountsOrders;
import com.flf.entity.TasksJournal;

@WebService
@Path("/SettleAccountsOrders")
public interface SettleAccountsOrdersService {
	/**
	 * 新增结算单
	 * @param acceptanceOrders
	 */
	@POST
	@Path("/insertSettleAccountsOrders")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void insertSettleAccountsOrders(SettleAccountsOrders settleAccountsOrders);
	
	/**
	 * 通过Id查询结算单信息
	 * @param orderId
	 * @return
	 */
	@GET
	@Path("/getSettleAccountsOrdersbyId/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	SettleAccountsOrders getSettleAccountsOrdersbyId(@PathParam("orderId") String orderId);
	
	/**
	 * 修改结算单状态
	 * @param settleAccountsOrders
	 */
	@PUT
	@Path("/closeSettleAccountsOrdersState")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void closeSettleAccountsOrdersState(SettleAccountsOrders settleAccountsOrders);
	
	/**
	 * 修改结算单
	 * @param settleAccountsOrders
	 */
	@PUT
	@Path("/changeSettleAccountsOrdersState")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void updateSettleAccountsOrders(SettleAccountsOrders settleAccountsOrders);
	
	/**
	 * 获取结算单结算信息
	 * @param tasksJournal
	 */
	@POST
	@Path("/insertTasksJournal")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void insertTasksJournal(TasksJournal tasksJournal);
}
