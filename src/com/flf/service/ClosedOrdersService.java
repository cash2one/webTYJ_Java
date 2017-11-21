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



import com.flf.entity.ClosedOrders;
@WebService
@Path("ClosedOrders")
public interface ClosedOrdersService {
	/**
	 * 查询所有失效单信息
	 * @return
	 */
	@GET
	@Path("/listAllClosedOrders")
	@Produces(MediaType.APPLICATION_JSON)
	List<ClosedOrders> listAllClosedOrders();
	/**
	 * 通过Id查询失效单信息
	 * @param orderId
	 * @return
	 */
	@GET
	@Path("/getClosedOrdersbyId/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	ClosedOrders getClosedOrdersbyId(@PathParam("orderId") String orderId);
	
	/**
	 * 新增失效单信息
	 * @param appealOrders
	 */
	@POST
	@Path("/insertClosedOrders")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void insertClosedOrders(ClosedOrders closedOrders);
	
	/**
	 * 修改失效单信息
	 * @param appealOrders
	 */
	@PUT
	@Path("/updateClosedOrders")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void updateClosedOrders(ClosedOrders closedOrders);
	
	/**
	 * 删除失效单接口
	 * @param orderId
	 */
	@DELETE
	@Path("/deleteClosedOrders/{orderId}")
	public void deleteClosedOrders(@PathParam("orderId") String orderId);
	
	/**
	 * 改变失效单状态    0.关闭 1.完成
	 * @param orderId
	 */
	@PUT
	@Path("/changeClosedOrders")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void closeClosedOrders(ClosedOrders closedOrders);


}
