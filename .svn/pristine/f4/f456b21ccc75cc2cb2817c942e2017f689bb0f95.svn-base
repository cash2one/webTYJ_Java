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

import com.flf.entity.AreaNew;


@WebService
@Path("/AreaNewNew")
public interface AreaNewService {
	

    
	  /**
     *查询所有建筑的面积类型  
     * @Title: listAllAreaNewByState
     * @Description: TODO
     * @param @return    设定文件
     * @return List<AreaNew>    返回类型
     * @throws
    */
	@GET
	@Path("/listAllAreaNewByState")
	@Produces(MediaType.APPLICATION_JSON)
	List<AreaNew> listAllAreaNewByState();
	/**
	 * 根据id查询建筑面积类型信息
	 * @param AreaNewId
	 * @return
	 */
	@GET
	@Path("/getAreaNewByIdRest/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	AreaNew getAreaNewByIdRest(@PathParam("id") String id);
	
	/**
	 * 建筑面积类型
	 * @param AreaNew
	 * @return
	 */
	@POST
	@Path("/AddAreaNew")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void AddAreaNew(AreaNew AreaNew);
	
	
	/**
	 *修改建筑面积类型
	 * @param AreaNew
	 * @return
	 */
	@PUT
	@Path("/UpdateAreaNew")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void UpdateAreaNew(AreaNew AreaNew);
	
	/**
	 * 删除建筑面积类型
	 * @param id
	 * @return
	 */
	@DELETE
	@Path("/DeleteAreaNewById/{id}")
	void DeleteAreaNewById(@PathParam("id") String id);
    
    
}
