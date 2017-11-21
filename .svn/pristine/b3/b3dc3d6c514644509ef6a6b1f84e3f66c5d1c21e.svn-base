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
import com.flf.entity.ReturnVisitOrders;


/**
 * 回访工单
 * @author taoyongchao
 * 2015-8-7
 */
@WebService
@Path("/ReturnVisitOrders")
public interface ReturnVisitOrdersService {

	/**
	 * 查询所有回访单信息
	 * @return
	 */
	@GET
	@Path("/listAllReturnVisitOrders")
	@Produces(MediaType.APPLICATION_JSON)
	List<ReturnVisitOrders> listAllReturnVisitOrders();
	
	/**
	 * 通过Id查询回访单信息
	 * @param orderId
	 * @return
	 */
	@GET
	@Path("/getReturnVisitOrdersbyId/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	ReturnVisitOrders getReturnVisitOrdersbyId(@PathParam("orderId") String orderId);
	
	/**
	 * 新增回访单信息
	 * @param returnVisitOrders
	 */
	@POST
	@Path("/insertReturnVisitOrders")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void insertReturnVisitOrders(ReturnVisitOrders returnVisitOrders);
	
	/**
	 * 修改回访单信息
	 * @param returnVisitOrders
	 */
	@PUT
	@Path("/updateReturnVisitOrders")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void updateReturnVisitOrders(ReturnVisitOrders returnVisitOrders);
	
	/**
	 * 删除回访单接口
	 * @param orderId
	 */
	@DELETE
	@Path("/deleteReturnVisitOrders/{orderId}")
	public void deleteReturnVisitOrders(@PathParam("orderId") String orderId);
	
	/**
	 * 改变回访单状态    0.关闭 1.完成
	 * @param orderId
	 */
	@PUT
	@Path("/changeReturnVisitOrders")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void closeReturnVisitOrders(ReturnVisitOrders returnVisitOrders);
}
