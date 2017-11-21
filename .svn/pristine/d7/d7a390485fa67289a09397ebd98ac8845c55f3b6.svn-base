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

import com.flf.entity.CompensateOwner;

@WebService
@Path("/CompensateOwnerService")
public interface CompensateOwnerService {
	/**
	 * 新增赔偿给业主工单
	 * @param compensateOwner
	 */
	@POST
	@Path("/insertCompensateOwner")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void insertCompensateOwner(CompensateOwner compensateOwner);
	
	/**
	 * 关闭赔偿给业主工单
	 * @param orderId
	 */
	@PUT
	@Path("/closeCompensateOwner")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void closeCompensateOwner(CompensateOwner compensateOwner);
	
	/**
	 * 通过工单id获取赔偿给业主信息
	 * @param orderId
	 * @return
	 */
	@GET
	@Path("/getCompensateOwnerbyId/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	public CompensateOwner getCompensateOwnerbyId(@PathParam("orderId") String orderId);
}
