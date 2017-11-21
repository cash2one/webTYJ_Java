/**
 * @Title: PropertyTypeService.java
 * @Package com.flf.service
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-5-5 上午10:45:03
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

import com.flf.entity.PageRestful;
import com.flf.entity.PropertyType;
import com.flf.request.Tree;

/**
 * @ClassName: PropertyTypeService
 * @Description: TODO
 * @author wangyong
 * @date 2015-5-5 上午10:45:03
 *
 */

/**
 * @ClassName: PropertyTypeService
 * @Description: TODO
 * @author wangyang
 * @date 2015-6-9
 *
 */
@WebService
@Path("/PropertyType")
public interface PropertyTypeService {
	
	/**
	 * 查询所有专业资产分类信息
	 * @return
	 */
	@GET
	@Path("/listPropertyType")
	@Produces(MediaType.APPLICATION_JSON)
	List<PropertyType> listPropertyType();
	
	@GET
	@Path("/treePropertyType")
	@Produces(MediaType.APPLICATION_JSON)
	List<Tree> treePropertyType();
	
	
	@GET
	@Path("/treeProperty")
	@Produces(MediaType.APPLICATION_JSON)
	List<Tree> treeProperty();
	
	/**
	 * 查询所有父级专业资产列表
	 * @author wangyang
	 * @return
	 */
	@GET
	@Path("/listParentPropertyType")
	@Produces(MediaType.APPLICATION_JSON)
	List<PropertyType> listParentPropertyType();

	/**
	 * 分页查询父级专业资产列表
	 * @author fansensen
	 * 2015-08-26
	 */
	
	@POST
	@Path("listPageParentPropertyType")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	PageRestful listPageParentPropertyType(PropertyType propertyType);
	
	/**
	 * 根据id专业资产分类信息
	 * @param id
	 * @return
	 */
	@GET
	@Path("/getPropertyTypeByIdRest/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	PropertyType getPropertyTypeByIdRest(@PathParam("id") String id);
	
	/**
	 * 查询所有分类
	 * @param id
	 * @return
	 */
	@GET
	@Path("/listClassifyPropertyType")
	@Produces(MediaType.APPLICATION_JSON)
	List<PropertyType> listClassifyPropertyType();
	
	/**
	 * 分页查询所有分类
	 * @author fansensen
	 * 2015-08-26
	 */
	
	@POST
	@Path("/listPageClassifyPropertyType")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	PageRestful listPageClassifyPropertyType(PropertyType propertyType);
	
	/**
	 * 添加专业资产分类信息
	 * @param PropertyType
	 * @author wangyang
	 * @return
	 */
	@POST
	@Path("/AddPropertyType")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void AddPropertyType(PropertyType propertyType);
	
	
	/**
	 *修改专业资产分类信息
	 * @param appPropertyType
	 * @return
	 */
	@PUT
	@Path("/UpdatePropertyType")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void UpdatePropertyType(PropertyType propertyType);
	
	/**
	 * 删除专业资产分类信息
	 * @param id
	 * @return
	 */
	@DELETE
	@Path("/DeletePropertyTypeById/{id}")
	void DeletePropertyTypeById(@PathParam("id") String id);

	/**查询父级节点下的子节点 **/
	@GET
	@Path("/selectByIds/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	List<PropertyType> getPropertyTypeByIds(@PathParam("id") String id);
	
	
	/***
	 * 
	 */

	@GET
	@Path("/trees")
	@Produces(MediaType.APPLICATION_JSON)
	List<Tree> treePropertyTypess();

}
