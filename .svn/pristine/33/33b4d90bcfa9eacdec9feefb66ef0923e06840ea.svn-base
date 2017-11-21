/**
 * @Title: ComponentStructureService.java
 * @Package com.flf.service
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-6-23 下午5:27:34
 * @version V1.0
 */

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

import com.flf.entity.ComponentStructure;
import com.flf.entity.PageRestful;

/**
 * @ClassName: ComponentStructureService
 * @Description: TODO
 * @author wangyong
 * @date 2015-6-23 下午5:27:34
 *
 */
@WebService
@Path("/ComponentStructure")
public interface ComponentStructureService {
	

	/**
	 * 分页显示建筑组件与建筑结构信息
	 * 
	 * @return
	 */
	@POST
   	@Path("/listPageComponentStructure")
   	@Produces(MediaType.APPLICATION_JSON)
	PageRestful listPageComponentStructure(ComponentStructure ComponentStructure) ; 
	
	/**
	 * 查询所有建筑组件与建筑结构信息
	 * 
	 * @return
	 */
	@GET
	@Path("/listComponentStructureAll")
	@Produces(MediaType.APPLICATION_JSON)
	List<ComponentStructure> listComponentStructureAll();

	/**
	 * 根据id查询建筑组件与建筑结构信息
	 * 
	 * @param ComponentStructureId
	 * @return
	 */
	@GET
	@Path("/getComponentStructureByIdRest/{ComponentStructureId}")
	@Produces(MediaType.APPLICATION_JSON)
	ComponentStructure getComponentStructureByIdRest(@PathParam("ComponentStructureId") String ComponentStructureId);

	/**
	 * 添加建筑组件与建筑结构信息
	 * 
	 * @param ComponentStructure
	 * @return
	 */
	@POST
	@Path("/AddComponentStructure")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void AddComponentStructure(ComponentStructure ComponentStructure);

	/**
	 * 修改建筑组件与建筑结构信息
	 * 
	 * @param ComponentStructure
	 * @return
	 */
	@PUT
	@Path("/UpdateComponentStructure")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void UpdateComponentStructure(ComponentStructure ComponentStructure);

	/**
	 * 删除建筑组件与建筑结构信息
	 * 
	 * @param ComponentStructureId
	 * @return
	 */
	@DELETE
	@Path("/DeleteComponentStructureById/{ComponentStructureId}")
	void DeleteComponentStructureById(@PathParam("ComponentStructureId") String ComponentStructureId);


}
