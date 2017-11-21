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

import com.flf.entity.WaterMeterTypes;
/* Created by Administrator on 2015/6/15. 
author:尹磊
修改时间：2015/6/15  修改人：尹磊 */
@WebService
@Path("/WaterMeterTypes")
public interface WaterMeterTypesService {

	/**
	 * 查询所有水表所在建筑类型信息
	 * @return
	 */
	@GET
	@Path("/listAllWaterMeterTypes")
	@Produces(MediaType.APPLICATION_JSON)
	List<WaterMeterTypes> listAllWaterMeterTypes();

	
	/**
	 * 根据id查询所有水表所在建筑类型信息
	 * @return
	 */
	@GET
	@Path("/getWaterMeterTypesbyId/{waterMeterTypesId}")
	@Produces(MediaType.APPLICATION_JSON)
	WaterMeterTypes getUserByIdRest(@PathParam("waterMeterTypesId") String waterMeterTypesId);

	
	/**
	 * 新增水表所在建筑类型信息
	 * @return
	 */
	@POST
	@Path("/insertWaterMeterTypes")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void insertWaterMeterTypesrest(WaterMeterTypes waterMeterTypes);

	
	/**
	 * 修改水表所在建筑类型信息
	 * @return
	 */
	@PUT
	@Path("/updateWaterMeterTypes")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void updateWaterMeterTypesrest(WaterMeterTypes waterMeterTypes);

	
	/**
	 * 删除水表所在建筑类型信息
	 * @return
	 */
	@DELETE
	@Path("/deleteWaterMeterTypes/{waterMeterTypesId}")
	void deleteWaterMeterTypesrest(@PathParam("waterMeterTypesId") String waterMeterTypesId);

}
