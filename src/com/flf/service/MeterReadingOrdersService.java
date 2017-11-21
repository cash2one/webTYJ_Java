package com.flf.service;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.MeterReadingOrders;
import com.flf.request.Info;

@WebService
@Path("/MeterReadingOrders")
public interface MeterReadingOrdersService {
	/**
	 * 通过Id查询抄电表工单信息
	 * @param orderId
	 * @return
	 */
	@GET
	@Path("/getMeterReadingOrdersbyId/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	MeterReadingOrders getMeterReadingOrdersbyId(@PathParam("orderId") String orderId);
	
	/**
	 * 新增抄电表工单信息
	 * @param acceptanceOrders
	 */
	@POST
	@Path("/insertMeterReadingOrders")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Info insertMeterReadingOrders(MeterReadingOrders meterReadingOrders);
	
	/**
	 * 修改电表工单
	 * @param acceptanceOrders
	 */
	@PUT
	@Path("/updateMeterReadingOrders")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void updateMeterReadingOrders(MeterReadingOrders meterReadingOrders);
	
	/**
	 * 关闭电表工单
	 * @param waterMeterOrders
	 * @return
	 */
	@PUT
	@Path("/closeMeterReadingOrders")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Info closeMeterReadingOrders(MeterReadingOrders meterReadingOrders);
}
