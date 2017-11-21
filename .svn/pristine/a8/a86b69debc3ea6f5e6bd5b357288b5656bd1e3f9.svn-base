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

import com.flf.entity.DisposeOrder;
@WebService
@Path("/DisposeOrder")
/**
 * 处理工单表
 * 创建人：邵政
 * 创建时间：2015/6/24
 */
public interface DisposeOrderService {

    List<DisposeOrder> listPageDisposeOrder(DisposeOrder disposeOrder);//分页查询处理信息
	
	/**
	 * 查询所有处理信息
	 * @return
	 */
	@GET
	@Path("/listAllDisposeOrder")
	@Produces(MediaType.APPLICATION_JSON)
	List<DisposeOrder> listAllDisposeOrder();
	
	/**
	 * 通过Id查询处理信息
	 * @param orderId
	 * @return
	 */
	@GET
	@Path("/getDisposeOrderbyId/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	DisposeOrder getDisposeOrderbyId(@PathParam("orderId") String orderId);
	
	/**
	 * 添加处理信息
	 * @param disposeOrder
	 */
	@POST
	@Path("/insertDisposeOrder")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void insertDisposeOrder(DisposeOrder disposeOrder);
	
	/**
	 * 修改处理信息
	 * @param disposeOrder
	 */
	@PUT
	@Path("/updateDisposeOrder")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void updateDisposeOrder(DisposeOrder disposeOrder);
	
	/**
	 * 删除处理信息
	 * @param serverId
	 */
	@DELETE
	@Path("/deleteDisposeOrder/{orderId}")
	public void deleteDisposeOrder(@PathParam("orderId") String orderId);
	
	/**
	 * 改变处理单状态
	 * @param orderId
	 */
	@PUT
	@Path("/closeDisposeOrder")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void closeDisposeOrder(DisposeOrder disposeOrder);
	
}





