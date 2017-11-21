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

import com.flf.entity.WaterMeterProject;
/* Created by Administrator on 2015/6/15. 
author:尹磊
修改时间：2015/6/15  修改人：尹磊 */
@WebService
@Path("/WaterMeterProject")
public interface WaterMeterProjectService {

	/**
	 * 查询所有水表使用记录抄表计划关系信息
	 * @return
	 */
	@GET
	@Path("/listAllWaterMeterProject")
	@Produces(MediaType.APPLICATION_JSON)
	List<WaterMeterProject> listAllWaterMeterProject();

	
	/**
	 * 根据id查询所有水表使用记录抄表计划关系信息
	 * @return
	 */
	@GET
	@Path("/getWaterMeterProjectbyId/{waterMeterProjectId}")
	@Produces(MediaType.APPLICATION_JSON)
	WaterMeterProject getUserByIdRest(@PathParam("waterMeterProjectId") String waterMeterProjectId);

	
	/**
	 * 新增水表使用记录抄表计划关系信息
	 * @return
	 */
	@POST
	@Path("/insertWaterMeterProject")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void insertWaterMeterProjectrest(WaterMeterProject waterMeterProject);

	
	/**
	 * 修改水表使用记录抄表计划关系信息
	 * @return
	 */
	@PUT
	@Path("/updateWaterMeterProject")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void updateWaterMeterProjectrest(WaterMeterProject waterMeterProject);

	
	/**
	 * 删除水表使用记录抄表计划关系信息
	 * @return
	 */
	@DELETE
	@Path("/deleteWaterMeterProject/{waterMeterProjectId}")
	void deleteWaterMeterProjectrest(@PathParam("waterMeterProjectId") String waterMeterProjectId);

}
