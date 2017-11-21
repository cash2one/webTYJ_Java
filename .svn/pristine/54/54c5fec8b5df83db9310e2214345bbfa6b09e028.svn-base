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

import com.flf.entity.AreaTypeNew;
import com.flf.entity.ClaimToCustomerOrders;
import com.flf.request.Info;

/**
 * 向客户索赔工单
 * @author shaozheng
 *	2015-8-12
 */

@WebService
@Path("/ClaimToCustomerOrders")
public interface ClaimToCustomerOrdersService {
	/**
	 * 通过Id查询向客户索赔工单
	 * @param orderId
	 * @return
	 */
	@GET
	@Path("/getClaimToCustomerOrdersbyId/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	ClaimToCustomerOrders getClaimToCustomerOrdersbyId(@PathParam("orderId") String orderId);
	
	/**
	 * 新增向客户索赔工单信息
	 * @param acceptanceOrders
	 */
	@POST
	@Path("/insertClaimToCustomerOrders")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Info insertClaimToCustomerOrders(ClaimToCustomerOrders claimToCustomerOrders);
	
	/**
	 * 修改向客户索赔工单
	 * @param acceptanceOrders
	 */
	@PUT
	@Path("/updateClaimToCustomerOrders")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void updateClaimToCustomerOrders(ClaimToCustomerOrders claimToCustomerOrders);
	
	/**
	 * 关闭向客户索赔工单
	 * @param ClaimToCustomerOrders
	 * @return
	 */
	@PUT
	@Path("/closeClaimToCustomerOrders")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void closeClaimToCustomerOrders(ClaimToCustomerOrders claimToCustomerOrders);
	
	@GET
	@Path("/getClaimToCustomerOrders")
	@Produces(MediaType.APPLICATION_JSON)
	List<ClaimToCustomerOrders> getClaimToCustomerOrders();
	
}
