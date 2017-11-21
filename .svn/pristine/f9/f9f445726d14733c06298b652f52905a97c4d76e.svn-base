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

import com.flf.entity.ElectricityMeterProject;
/* Created by Administrator on 2015/7/6. 
author:尹磊
修改时间：2015/7/6  修改人：尹磊 */
@WebService
@Path("/ElectricityMeterProject")
public interface ElectricityMeterProjectService {

	/**
	 * 查询所有电表使用记录抄表计划关系信息
	 * @return
	 */
	@GET
	@Path("/listAllElectricityMeterProject")
	@Produces(MediaType.APPLICATION_JSON)
	List<ElectricityMeterProject> listAllElectricityMeterProject();

	
	/**
	 * 根据id查询所有电表使用记录抄表计划关系信息
	 * @return
	 */
	@GET
	@Path("/getElectricityMeterProjectbyId/{electricityMeterProjectId}")
	@Produces(MediaType.APPLICATION_JSON)
	ElectricityMeterProject getUserByIdRest(@PathParam("electricityMeterProjectId") String electricityMeterProjectId);

	
	/**
	 * 新增电表使用记录抄表计划关系信息
	 * @return
	 */
	@POST
	@Path("/insertElectricityMeterProject")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void insertElectricityMeterProjectrest(ElectricityMeterProject electricityMeterProject);

	
	/**
	 * 修改电表使用记录抄表计划关系信息
	 * @return
	 */
	@PUT
	@Path("/updateElectricityMeterProject")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void updateElectricityMeterProjectrest(ElectricityMeterProject electricityMeterProject);

	
	/**
	 * 删除电表使用记录抄表计划关系信息
	 * @return
	 */
	@DELETE
	@Path("/deleteElectricityMeterProject/{electricityMeterProjectId}")
	void deleteElectricityMeterProjectrest(@PathParam("electricityMeterProjectId") String electricityMeterProjectId);

}
