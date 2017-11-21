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

import com.flf.entity.QuoteOrders;
@WebService
@Path("/QuoteOrders")
/**
 * 报价工单表
 * 创建人：邵政
 * 创建时间：2015/6/24
 */
public interface QuoteOrdersService {

//    List<QuoteOrders> listPageQuoteOrders(QuoteOrders quoteOrders);//分页查询报价信息
	
	/**
	 * 查询所有报价信息
	 * @return
	 */
	@GET
	@Path("/listAllQuoteOrders")
	@Produces(MediaType.APPLICATION_JSON)
	List<QuoteOrders> listAllQuoteOrders();
	
	/**
	 * 通过Id查询报价信息
	 * @param orderId
	 * @return
	 */
	@GET
	@Path("/getQuoteOrdersbyId/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	QuoteOrders getQuoteOrdersbyId(@PathParam("orderId") String orderId);
	
	/**
	 * 添加报价信息
	 * @param quoteOrders
	 */
	@POST
	@Path("/insertQuoteOrders")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void insertQuoteOrders(QuoteOrders quoteOrders);
	
	/**
	 * 修改报价信息
	 * @param quoteOrders
	 */
	@PUT
	@Path("/updateQuoteOrders")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void updateQuoteOrders(QuoteOrders quoteOrders);
	
	/**
	 * 删除报价信息
	 * @param serverId
	 */
	@DELETE
	@Path("/deleteQuoteOrders/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteQuoteOrders(@PathParam("orderId") String orderId);
	
	/**
	 * 修改工单状态
	 * @param orderId
	 */
	@PUT
	@Path("/changeOrderState")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void closeOrderState(QuoteOrders quoteOrders);
	
	/**
	 * 通过任务id获取所有的报价单
	 * @param tasksId
	 * @return
	 */
	@GET
	@Path("/getQuoteOrdersbyTasksId/{tasksId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<QuoteOrders> getQuoteOrdersbyTasksId(@PathParam("tasksId") String tasksId);
	
}





