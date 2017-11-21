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

import com.flf.entity.CompensateObject;
@WebService
@Path("/CompensateObject")
/**
 * 赔偿对象表
 * 创建人：邵政
 * 创建时间：2015/6/25
 */
public interface CompensateObjectService {

    List<CompensateObject> listPageCompensateObject(CompensateObject compensateObject);//分页查询赔偿对象信息
	
	/**
	 * 查询所有赔偿对象信息
	 * @return
	 */
	@GET
	@Path("/listAllCompensateObject")
	@Produces(MediaType.APPLICATION_JSON)
	List<CompensateObject> listAllCompensateObject();
	
	/**
	 * 通过Id查询赔偿对象信息
	 * @param serverId
	 * @return
	 */
	@GET
	@Path("/getCompensateObjectbyId/{recordId}")
	@Produces(MediaType.APPLICATION_JSON)
	CompensateObject getCompensateObjectbyId(@PathParam("recordId") String recordId);
	
	/**
	 * 添加赔偿对象信息
	 * @param compensateObject
	 */
	@POST
	@Path("/insertCompensateObject")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void insertCompensateObject(CompensateObject compensateObject);
	
	/**
	 * 修改赔偿对象信息
	 * @param compensateObject
	 */
	@PUT
	@Path("/updateCompensateObject")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void updateCompensateObject(CompensateObject compensateObject);
	
	/**
	 * 删除赔偿对象信息/
	 * @param serverId
	 */
	@DELETE
	@Path("/deleteCompensateObject/{recordId}")
	public void deleteCompensateObject(@PathParam("recordId") String recordId);
	
}





