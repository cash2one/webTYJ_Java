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

import com.flf.entity.ElectricityMeterTypes;
/* Created by Administrator on 2015/7/6. 
author:尹磊
修改时间：2015/7/6  修改人：尹磊 */
@WebService
@Path("/ElectricityMeterTypes")
public interface ElectricityMeterTypesService {

	/**
	 * 查询所有水表所在建筑类型信息
	 * @return
	 */
	@GET
	@Path("/listAllElectricityMeterTypes")
	@Produces(MediaType.APPLICATION_JSON)
	List<ElectricityMeterTypes> listAllElectricityMeterTypes();

	
	/**
	 * 根据id查询所有水表所在建筑类型信息
	 * @return
	 */
	@GET
	@Path("/getElectricityMeterTypesbyId/{electricityMeterTypesId}")
	@Produces(MediaType.APPLICATION_JSON)
	ElectricityMeterTypes getUserByIdRest(@PathParam("electricityMeterTypesId") String electricityMeterTypesId);

	
	/**
	 * 新增水表所在建筑类型信息
	 * @return
	 */
	@POST
	@Path("/insertElectricityMeterTypes")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void insertElectricityMeterTypesrest(ElectricityMeterTypes electricityMeterTypes);

	
	/**
	 * 修改水表所在建筑类型信息
	 * @return
	 */
	@PUT
	@Path("/updateElectricityMeterTypes")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void updateElectricityMeterTypesrest(ElectricityMeterTypes electricityMeterTypes);

	
	/**
	 * 删除水表所在建筑类型信息
	 * @return
	 */
	@DELETE
	@Path("/deleteElectricityMeterTypes/{electricityMeterTypesId}")
	void deleteElectricityMeterTypesrest(@PathParam("electricityMeterTypesId") String electricityMeterTypesId);

}
