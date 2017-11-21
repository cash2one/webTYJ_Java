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

import com.flf.entity.CheckOrders;

/**
 * 检测单
 * @author 邵政
 * 2015-6-30
 */
@WebService
@Path("/CheckOrdersService")
public interface CheckOrdersService {
	/**
	 * 查询所有检测单信息
	 * @return
	 */
	@GET
	@Path("/listAllCheckOrders")
	@Produces(MediaType.APPLICATION_JSON)
	List<CheckOrders> listAllCheckOrders();
	
	/**
	 * 通过Id查询检测单信息
	 * @param orderId
	 * @return
	 */
	@GET
	@Path("/getCheckOrdersbyId/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	CheckOrders getCheckOrdersbyId(@PathParam("orderId") String orderId);
	
	/**
	 * 新增检测单信息
	 * @param acceptanceOrders
	 */
	@POST
	@Path("/insertCheckOrders")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void insertCheckOrders(CheckOrders checkOrders);
	
	/**
	 * 修检测收单信息
	 * @param acceptanceOrders
	 */
	@PUT
	@Path("/updateCheckOrders")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void updateCheckOrders(CheckOrders checkOrders);
	
	/**
	 * 删除检测单接口
	 * @param orderId
	 */
	@DELETE
	@Path("/deleteCheckOrders/{orderId}")
	public void deleteCheckOrders(@PathParam("orderId") String orderId);
	
	@PUT
	@Path("/changeCheckOrders")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void closeCheckOrders(CheckOrders checkOrders);
}
