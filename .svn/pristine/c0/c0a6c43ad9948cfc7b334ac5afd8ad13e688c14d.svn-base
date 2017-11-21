package com.flf.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.OwnerRenovationApply;

/**
 * 业主装修申请表
 * @author shaozheng
 *	2015-8-21
 */
@WebService
@Path("/OwnerRenovationApply")
public interface OwnerRenovationApplyService {
	
	/**
	 * 添加业主装修申请
	 */
	@POST
	@Path("/insertOwnerRenovationApply")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public OwnerRenovationApply insertOwnerRenovationApply(OwnerRenovationApply ownerRenovationApply);
	
	/**
	 * 查询所有的主装修申请
	 * @return
	 */
	@GET
	@Path("/getAllOwnerRenovationApply")
	@Produces(MediaType.APPLICATION_JSON)
	public List<OwnerRenovationApply> getAllOwnerRenovationApply();
	/**
	 * 根据服务请求ID查询业主装修申请
	 * @return
	 * serviceId
	 */
	@GET
	@Path("/getOwnerRenovationApplyByServiceId/{serviceId}")
	@Produces(MediaType.APPLICATION_JSON)
	public OwnerRenovationApply getOwnerRenovationApplyByServiceId(@PathParam("serviceId") String serviceId);

	/**
	 * 根据业主id获取业主装修申请
	 * @param custId
	 * @return
	 */
	@GET
	@Path("/getOwnerRenovationApplybyCustId/{custId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<OwnerRenovationApply> getOwnerRenovationApplybyCustId(@PathParam("custId") String custId);
}
