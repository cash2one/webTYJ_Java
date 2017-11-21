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

import com.flf.entity.CompensateMethods;
@WebService
@Path("/CompensateMethods")
/**
 * 赔偿方案
 * 创建人：邵政
 * 创建时间：2015/6/25
 */
public interface CompensateMethodsService {

    List<CompensateMethods> listPageCompensateMethods(CompensateMethods compensateMethods);//分页查询赔偿方案信息
	
	/**
	 * 查询所有赔偿方案信息
	 * @return
	 */
	@GET
	@Path("/listAllCompensateMethods")
	@Produces(MediaType.APPLICATION_JSON)
	List<CompensateMethods> listAllCompensateMethods();
	
	/**
	 * 通过Id查询赔偿方案信息
	 * @param serverId
	 * @return
	 */
	@GET
	@Path("/getCompensateMethodsbyId/{compensateMethodId}")
	@Produces(MediaType.APPLICATION_JSON)
	CompensateMethods getCompensateMethodsbyId(@PathParam("compensateMethodId") String compensateMethodId);
	
	/**
	 * 添加赔偿方案信息
	 * @param compensateMethods
	 */
	@POST
	@Path("/insertCompensateMethods")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void insertCompensateMethods(CompensateMethods compensateMethods);
	
	/**
	 * 修改赔偿方案信息
	 * @param compensateMethods
	 */
	@PUT
	@Path("/updateCompensateMethods")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void updateCompensateMethods(CompensateMethods compensateMethods);
	
	/**
	 * 删除赔偿方案信息/
	 * @param serverId
	 */
	@DELETE
	@Path("/deleteCompensateMethods/{compensateMethodId}")
	public void deleteCompensateMethods(@PathParam("compensateMethodId") String compensateMethodId);
	
}





