/**
 * @Title: ComponentPropertyService.java
 * @Package com.flf.service
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-6-23 下午4:56:34
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

import com.flf.entity.ComponentProperty;
import com.flf.entity.PageRestful;

/**
 * @ClassName: ComponentPropertyService
 * @Description: TODO
 * @author wangyong
 * @date 2015-6-23 下午4:56:34
 *
 */
@WebService
@Path("/ComponentProperty")
public interface ComponentPropertyService {
	
	/**
	 * 分页显示建筑组件与资产关系信息
	 * 
	 * @return
	 */
	@POST
   	@Path("/listPageComponentProperty")
   	@Produces(MediaType.APPLICATION_JSON)
    PageRestful listPageComponentProperty(ComponentProperty ComponentProperty);  
	
	/**
	 * 查询所有建筑组件与资产关系信息
	 * 
	 * @return
	 */
	@GET
	@Path("/listComponentPropertyAll")
	@Produces(MediaType.APPLICATION_JSON)
	List<ComponentProperty> listComponentPropertyAll();

	/**
	 * 根据id查询建筑组件与资产关系信息
	 * 
	 * @param ComponentPropertyId
	 * @return
	 */
	@GET
	@Path("/getComponentPropertyByIdRest/{ComponentPropertyId}")
	@Produces(MediaType.APPLICATION_JSON)
	ComponentProperty getComponentPropertyByIdRest(@PathParam("ComponentPropertyId") String ComponentPropertyId);
	
	/**
	 * 根据组件id查询建筑组件与资产关系信息
	 * 
	 * @param ComponentPropertyId
	 * @return
	 */
	@GET
	@Path("/getComponentPropertyByComponentIdRest/{componentId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<ComponentProperty> getComponentPropertyByComponentIdRest(@PathParam("componentId") String componentId);

	/**
	 * 添加建筑组件与资产关系信息
	 * 
	 * @param ComponentProperty
	 * @return
	 */
	@POST
	@Path("/AddComponentProperty")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void AddComponentProperty(ComponentProperty ComponentProperty);

	/**
	 * 修改建筑组件与资产关系信息
	 * 
	 * @param ComponentProperty
	 * @return
	 */
	@PUT
	@Path("/UpdateComponentProperty")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void UpdateComponentProperty(ComponentProperty ComponentProperty);

	/**
	 * 删除建筑组件与资产关系信息
	 * 
	 * @param ComponentPropertyId
	 * @return
	 */
	@GET
	@DELETE
	@Path("/DeleteComponentPropertyById/{ComponentPropertyId}")
	void DeleteComponentPropertyById(@PathParam("ComponentPropertyId") String ComponentPropertyId);
	
	/**
	 * 根据组件id删除建筑组件与资产关系信息
	 * @param ComponentPropertyId
	 * @return
	 */
	@GET
	@Path("/DeleteComponentPropertyByBuildingComponentId/{componentId}")
	void DeleteComponentPropertyByBuildingComponentId(@PathParam("componentId") String componentId);

	/**
	 * 根据建筑结构查询资产信息
	 * @param buildingStructureId
	 * @return
	 */
	@GET
	@Path("/getComponentPropertyByBSId/{buildingStructureId}")
	List<ComponentProperty> getPropertyByIdRes(@PathParam("buildingStructureId") String buildingStructureId);
	
	/**
	 * 根据组件id联查功能，组件信息
	 * @param componentId
	 * @return
	 */
	@GET
	@Path("/selectComponentAndProperty/{componentId}")
	List<ComponentProperty> selectComponentAndProperty(@PathParam("componentId") String componentId);
	/**
	 * //根据id查询组件和资产关系
	 * @param componentId
	 * @return
	 */
	@GET
	@Path("/selectComProById/{componentPropertyId}")
	List<ComponentProperty>selectComProById(@PathParam("componentPropertyId")String componentPropertyId);
	/**
	 * 通过id修改组件关联的资产
	 * @param ComponentProperty
	 */
	@PUT
	@Path("/updateComponentPropertyById")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void  updateComponentPropertyById(ComponentProperty ComponentProperty);

}