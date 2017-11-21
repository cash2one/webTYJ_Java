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

import com.flf.entity.ComplaintOrders;

/**
 * 投诉工单表Service
 * 创建人：倪明
 * 创建时间：2015/8/11
 */
@WebService
@Path("/ComplaintOrders")
public interface ComplaintOrdersService {

	/**
	 * 查询所有投诉工单信息
	 * @return
	 */
	@GET
	@Path("/listAllComplaintOrders")
	@Produces(MediaType.APPLICATION_JSON)
	List<ComplaintOrders> listAllComplaintOrders();
	
	/**
	 * 根据id查询投诉工单信息
	 * @param orderId
	 * @return
	 */
	@GET
	@Path("/getComplaintOrdersbyId/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	ComplaintOrders getComplaintOrdersbyId(@PathParam("orderId") String orderId);
	
	/**
	 * 新增一条投诉工单信息
	 * @param complaintOrders
	 */
	@POST
	@Path("/insertComplaintOrders")
	@Consumes({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public void insertComplaintOrders(ComplaintOrders complaintOrders);
	
	/**
	 * 修改一条投诉工单信息
	 * @param complaintOrders
	 */
	@PUT
	@Path("/updateComplaintOrders")
	@Consumes({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public void updateComplaintOrders(ComplaintOrders complaintOrders);
	
	/**
	 * 删除一条投诉工单信息
	 * @param orderId
	 */
	@DELETE
	@Path("/deleteComplaintOrders/{orderId}")
	public void deleteComplaintOrders(@PathParam("orderId") String orderId);
	
	/**
	 * 关闭投诉工单信息
	 * @param orderId
	 */
	@PUT
	@Path("/closeComplaintOrders")
	@Consumes({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public void closeComplaintOrders(ComplaintOrders complaintOrders);
}
