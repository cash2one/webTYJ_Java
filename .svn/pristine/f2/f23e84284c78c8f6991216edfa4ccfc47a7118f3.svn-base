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

import com.flf.entity.AcceptanceOrders;
import com.flf.entity.AppealOrders;


@WebService
@Path("/AppealOrders")
public interface AppealOrdersService {
	
	/**
	 * 查询所有申诉单信息
	 * @return
	 */
	@GET
	@Path("/listAllAppealOrders")
	@Produces(MediaType.APPLICATION_JSON)
	List<AppealOrders> listAllAppealOrders();
	/**
	 * 通过Id查询申诉单信息
	 * @param orderId
	 * @return
	 */
	@GET
	@Path("/getAppealOrdersbyId/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	AppealOrders getAppealOrdersbyId(@PathParam("orderId") String orderId);
	
	/**
	 * 新增申诉单信息
	 * @param appealOrders
	 */
	@POST
	@Path("/insertAppealOrders")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void insertAppealOrders(AppealOrders appealOrders);
	
	/**
	 * 修改申诉单信息
	 * @param appealOrders
	 */
	@PUT
	@Path("/updateAppealOrders")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void updateAppealOrders(AppealOrders appealOrders);
	
	/**
	 * 删除申诉单接口
	 * @param orderId
	 */
	@DELETE
	@Path("/deleteAppealOrders/{orderId}")
	public void deleteAppealOrders(@PathParam("orderId") String orderId);
	
	/**
	 * 改变申诉单状态    0.关闭 1.完成
	 * @param orderId
	 */
	@PUT
	@Path("/changeAppealOrders")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void closeAppealOrders(AppealOrders appealOrders);

}
