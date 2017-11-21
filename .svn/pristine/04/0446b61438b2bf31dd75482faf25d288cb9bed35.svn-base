package com.flf.service;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;


/**
 * 工单操作
 * @author shaozheng
 * 2015-6-29
 */
@WebService
@Path("/WorkOrderService")
public interface WorkOrderService {

	@PUT
	@Path("/closeWorkOrderByOrderType/{orderType}/{orderId}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	int closeWorkOrderByOrderType(@PathParam("orderType") Integer orderType ,@PathParam("orderId") String orderId); //根据工单类型关闭工单 0.报价;1.处理;2.验收;3.表扬;4.投诉;5.赔偿给业主;6.向业主索赔;7.装修/施工巡检;8.装修/施工核查;9.装修/施工验收;10.部门质检工单
}
