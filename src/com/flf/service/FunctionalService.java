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

import com.flf.entity.Functional;
import com.flf.entity.PageRestful;
@WebService
@Path("/Functional")
public interface FunctionalService {
	
	/**
	 * 分页显示功能区信息
	 * 
	 * @return
	 */
	@POST
   	@Path("/listPageFunctional")
   	@Produces(MediaType.APPLICATION_JSON)
    PageRestful listPageFunctional(Functional functional);  
	
	/**
	 * 查询所有功能区信息
	 * 
	 * @return
	 */
	@GET
	@Path("/listFunctionalAll")
	@Produces(MediaType.APPLICATION_JSON)
	List<Functional> listFunctionalAll();

	/**
	 * 根据id查询功能区信息
	 * 
	 * @param FunctionalId
	 * @return
	 */
	@GET
	@Path("/getFunctionalByIdRest/{functionalId}")
	@Produces(MediaType.APPLICATION_JSON)
	Functional getFunctionalByIdRest(@PathParam("functionalId") String functionalId);

	/**
	 * 添加功能区信息
	 * 
	 * @param Functional
	 * @return
	 */
	@POST
	@Path("/AddFunctional")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void AddFunctional(Functional functional);

	/**
	 * 修改功能区信息
	 * 
	 * @param Functional
	 * @return
	 */
	@PUT
	@Path("/UpdateFunctional")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void UpdateFunctional(Functional functional);

	/**
	 * 删除功能区信息
	 * 
	 * @param FunctionalId
	 * @return
	 */
	@DELETE
	@Path("/DeleteFunctionalById/{functionalId}")
	void DeleteFunctionalById(@PathParam("functionalId") String functionalId);
	
	/**
	 * 根据编号和名称查询数据库中是否已存在相同数据
	 * @param functional
	 * @return
	 */
	@POST
	@Path("/getCountByNoOrName")
	@Produces(MediaType.APPLICATION_JSON)
	int getCountByNoOrName(Functional functional);

}
