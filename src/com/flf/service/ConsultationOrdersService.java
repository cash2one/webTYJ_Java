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

import com.flf.entity.ConsultationOrders;

/**
 * 咨询工单表Service
 * 创建人：倪明
 * 创建时间：2015/8/12
 */
@WebService
@Path("/ConsultationOrders")
public interface ConsultationOrdersService {
	
	/**
	 * 查询所有咨询工单信息
	 * @return
	 */
	@GET
	@Path("/listAllConsultationOrders")
	@Produces(MediaType.APPLICATION_JSON)
	List<ConsultationOrders> listAllConsultationOrders();
	
	/**
	 * 新增一条咨询工单信息
	 * @param consultationOrders
	 */
	@POST
	@Path("/insertConsultationOrders")
	@Consumes({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public void insertConsultationOrders(ConsultationOrders consultationOrders);
	
	/**
	 * 删除一条咨询工单信息
	 * @param orderId
	 */
	@DELETE
	@Path("/deleteConsultationOrders/{orderId}")
	public void deleteConsultationOrders(@PathParam("orderId") String orderId);
	
	/**
	 * 根据咨询id查询咨询工单信息
	 * @param orderId
	 * @return
	 */
	@GET
	@Path("/getConsultationOrdersbyId/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	ConsultationOrders getConsultationOrdersbyId(@PathParam("orderId") String orderId);
	
	/**
	 * 修改一条咨询工单信息
	 * @param consultationOrders
	 */
	@PUT
	@Path("/updateConsultationOrders")
	@Consumes({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public void updateConsultationOrders(ConsultationOrders consultationOrders);
	
	/**
	 * 关闭咨询工单信息
	 * @param consultationOrders
	 */
	@PUT
	@Path("/closeConsultationOrders")
	@Consumes({MediaType.APPLICATION_ATOM_XML,MediaType.APPLICATION_JSON})
	public void closeConsultationOrders(ConsultationOrders consultationOrders);
}
