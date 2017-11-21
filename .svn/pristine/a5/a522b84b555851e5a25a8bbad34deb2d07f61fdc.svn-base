package com.flf.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.ComponentProperty;
import com.flf.entity.InspectorOrder;
import com.flf.request.Info;

@WebService
@Path("/InspectorOrder")
public interface InspectorOrderService {
	
	/**
	 * 获取所有的验房工单
	 */
	@GET
	@Path("/getAllInspectorOrder")
	@Produces(MediaType.APPLICATION_JSON)
	public List<InspectorOrder> getAllInspectorOrder();
	
	/**
	 * 添加验房工单
	 * @param inspectorOrder
	 * @return
	 */
	@POST
	@Path("/insertInspectorOrder")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Info insertInspectorOrder(InspectorOrder inspectorOrder);
	
	/**
	 * 改变验房工单状态
	 * @param orderId
	 */
	@PUT
	@Path("/closeInspectorOrder")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Info closeInspectorOrder(InspectorOrder inspectorOrder);
	
	/**
	 * 根据工单id获取验房工单信息
	 * @param orderId
	 * @return
	 */
	@GET
	@Path("/getInspectorOrderbyId/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	public InspectorOrder getInspectorOrderbyId(@PathParam("orderId") String orderId);

	/**
	 * 根据建筑结构Id获取验房
	 * @param buildingStructureId
	 * @return
	 */
	@GET
	@Path("/getInspectorOrderBySRId/{buildingStructureId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ComponentProperty> getInspectorOrderBySRId(@PathParam("buildingStructureId") String buildingStructureId);
	
	/**
	 * 根据任务Id获取验房
	 * @param buildingStructureId
	 * @return
	 */
	@GET
	@Path("/getInspectorOrderBytaskId/{taskId}")
	@Produces(MediaType.APPLICATION_JSON)
	public InspectorOrder getInspectorOrderBytaskId(@PathParam("taskId") String taskId);
	
	
}
