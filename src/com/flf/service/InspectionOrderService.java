package com.flf.service;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.InspectionOrder;


/**
 * 巡检
 * @author yangshengquan
 *	2016-7-27
 */
@WebService
@Path("/InspectionOrderService")
public interface InspectionOrderService {
	
	/**
	 * 巡检单提交
	 * @param orderId
	 * @return
	 */ 
	@GET
	@Path("/submitInspectionOrder/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	void submitInspectionOrder(@PathParam("orderId") String orderId);
	
}
