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

import com.flf.entity.RepairOrders;

/**
 * 维修单
 * @author wangzhou
 *
 */
@WebService
@Path("/RepairOrders")
public interface RepairOrdersService {

	/**
	 * 查询所有维修单
	 * @return
	 */
	@GET
	@Path("/listAllRepairOrders")
	@Produces(MediaType.APPLICATION_JSON)
	List<RepairOrders> listAllRepairOrders();
	
	/**
	 * 新增维修单
	 * @param repairOrders
	 * @return
	 */
	@POST
	@Path("/insertRepairOrders")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void insertRepairOrders(RepairOrders repairOrders);
	
	/**
	 * 删除一条维修单信息
	 * @param orderId
	 */
	@DELETE
	@Path("/deleteRepairOrders/{orderId}")
	public void deleteRepairOrders(@PathParam("orderId") String orderId);
	
	/**
	 * 根据维修id查询维修单信息
	 * @param orderId
	 * @return
	 */
	@GET
	@Path("/getRepairOrdersbyId/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	RepairOrders getRepairOrdersbyId(@PathParam("orderId") String orderId);
	
	/**
	 * 修改一条维修单信息
	 * @param repairOrders
	 */
	@PUT
	@Path("/updateConsultationOrders")
	@Consumes({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public void updateConsultationOrders(RepairOrders repairOrders);
	
	/**
	 * 关闭维修单信息
	 * @param repairOrders
	 */
	@PUT
	@Path("/closeConsultationOrders")
	@Consumes({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public void closeConsultationOrders(RepairOrders repairOrders);
}
