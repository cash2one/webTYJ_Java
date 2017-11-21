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

import com.flf.entity.OwnerConstructionApply;
/**
 * 业主施工申请表
 * @author taoyongchao
 *  2015-8-31
 */
@WebService
@Path("/OwnerConstructionApply")
public interface OwnerConstructionApplyService {

	/**
	 * 添加业主施工申请
	 */
	@POST
	@Path("/insertOwnerConstructionApply")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public OwnerConstructionApply insertOwnerConstructionApply(OwnerConstructionApply ownerConstructionApply);
	
	/**
	 * 查询所有的主施工申请
	 * @return
	 */
	@GET
	@Path("/getAllOwnerConstructionApply")
	@Produces(MediaType.APPLICATION_JSON)
	public List<OwnerConstructionApply> getAllOwnerConstructionApply();
	
	/**
	 * 根据业主id获取业主施工申请
	 * @param custId
	 * @return
	 */
	@GET
	@Path("/getOwnerConstructionApplybyCustId/{custId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<OwnerConstructionApply> getOwnerConstructionApplybyCustId(@PathParam("custId") String custId);
	/**
	 * 根据服务请求ID查询业主装修申请
	 * @return
	 * serviceId
	 */
	@GET
	@Path("/getOwnerConstructionApplyByServiceId/{serviceId}")
	@Produces(MediaType.APPLICATION_JSON)
	public OwnerConstructionApply getOwnerConstructionApplyByServiceId(@PathParam("serviceId") String serviceId);

}

