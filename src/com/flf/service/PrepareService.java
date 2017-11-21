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

import com.flf.entity.Prepare;
import com.flf.request.PrepareResult;
/*Created by Administrator on 2015/6/3. 
author:尹磊
修改时间：2015/6/3  修改人：尹磊 */
@WebService
@Path("/Prepare")
public interface PrepareService {

	/**
	 * 查询所有编制信息
	 * @return
	 */
	@GET
	@Path("/listAllPrepare")
	@Produces(MediaType.APPLICATION_JSON)
	List<Prepare> listAllPrepare();

	
	/**
	 * 根据编制id查询所有编制信息
	 * @return
	 */
	@GET
	@Path("/getPreparebyId/{prepareId}")
	@Produces(MediaType.APPLICATION_JSON)
	Prepare getUserByIdRest(@PathParam("prepareId") String prepareId);
	
	/**
	 * 根据团队id查询所有编制信息
	 * @return
	 */
	@GET
	@Path("/getPreparebyteamworkId/{teamworkId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<Prepare> getPreparebyteamworkId(@PathParam("teamworkId") String teamworkId);
	
	/**
	 * 根据项目id查询编制信息
	 * @return
	 */
	@GET
	@Path("/getPreparebyprojectId/{projectId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<Prepare> getPreparebyprojectId(@PathParam("projectId") String projectId);

	
	/**
	 * 新增编制信息
	 * @return
	 */
	@POST
	@Path("/insertPrepare")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void insertPreparerest(Prepare prepare);

	
	/**
	 * 修改编制信息
	 * @return
	 */
	@PUT
	@Path("/updatePrepare")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void updatePreparerest(Prepare prepare);

	
	/**
	 * 删除编制信息
	 * @return
	 */
	@DELETE
	@Path("/deletePrepare/{prepareId}")
	void deletePreparerest(@PathParam("prepareId") String prepareId);	
	
	/**
	 * 通过专业线id和项目id查询编制集合
	 * @return
	 */
	@GET
	@Path("/listAllSearchPrepare/{projectId}/{specialtyId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<Prepare> listAllSearchPrepare(@PathParam("projectId")String projectId,@PathParam("specialtyId")String specialtyId);
}
