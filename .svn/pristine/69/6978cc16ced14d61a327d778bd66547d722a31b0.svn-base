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

import com.flf.entity.PraiseOrders;


/**
 * 
 * @author fansensen
 * 最近更改日期：2015-08-19
 *
 */
@WebService
@Path("/PraiseOrders")
public interface PraiseOrdersService {

	/** 基本方法，与mapper同 **/
	List<PraiseOrders> listAllPraiseOrder();
	PraiseOrders getPraiseOrderById(String id);
	int insertPraiseOrder(PraiseOrders order);
	int deletePraiseOrder(String id);
	int updatePraiseOrder(PraiseOrders order);
	
	/** 实际实现的方法 **/
	/* 通过Id获取表扬表对象 */
	@GET
	@Path("/getPraiseOrderById/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	PraiseOrders FindPraiseOrderById(@PathParam("orderId") String orderId);//依据id获取对象
	
	/* 添加表扬表对象 */
	@POST
	@Path("/addPraiseOrder")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	void addPraiseOrder(PraiseOrders order);//添加对象
	
	/* 删除表扬表对象 */
	@DELETE
	@Path("/deletePraiseOrder/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	void deletePraiseOrderById(@PathParam("orderId") String id);
	
	/* 更新表扬表对象 */
	@PUT
	@Path("/updatePraiseOrder")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	void updatePraiseOrderInfo(PraiseOrders order);
	
	/* 关闭表扬表closedPraiseOrders */
	@PUT
	@Path("/closePraiseOrders")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	void closePraiseOrder(PraiseOrders order);
}
