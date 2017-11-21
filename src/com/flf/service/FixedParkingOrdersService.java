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

import com.flf.entity.FixedParkingOrders;

/**
 * 固定车位工单Service
 * 创建人：倪明
 * 创建时间：2015/8/13
 * @author Administrator
 *
 */
@WebService
@Path("/FixedParkingOrders")
public interface FixedParkingOrdersService {

	/**
	 * 查询所有固定车位工单信息
	 * @return
	 */
	@GET
	@Path("/listAllFixedParkingOrders")
	@Produces(MediaType.APPLICATION_JSON)
	List<FixedParkingOrders> listAllFixedParkingOrders();
	
	/**
	 * 新增一条固定车位工单信息
	 * @param fixedParkingOrders
	 */
	@POST
	@Path("/insertFixedParkingOrders")
	@Consumes({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public void insertFixedParkingOrders(FixedParkingOrders fixedParkingOrders);
	
	/**
	 * 删除一条固定车位工单信息
	 * @param orderId
	 */
	@DELETE
	@Path("/deleteFixedParkingOrders/{orderId}")
	public void deleteFixedParkingOrders(@PathParam("orderId") String orderId);
	
	/**
	 * 根据id获取一条固定车位工单信息
	 * @param orderId
	 * @return
	 */
	@GET
	@Path("/getFixedParkingOrdersbyId/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	FixedParkingOrders getFixedParkingOrdersbyId(@PathParam("orderId") String orderId);
	
	/**
	 * 修改一条固定车位工单信息
	 * @param fixedParkingOrders
	 */
	@PUT
	@Path("/updateFixedParkingOrders")
	@Consumes({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public void updateFixedParkingOrders(FixedParkingOrders fixedParkingOrders);
	
	/**
	 * 关闭固定车位工单信息
	 * @param fixedParkingOrders
	 */
	@PUT
	@Path("/closeFixedParkingOrders")
	@Consumes({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public void closeFixedParkingOrders(FixedParkingOrders fixedParkingOrders);
}
