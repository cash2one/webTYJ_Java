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

import com.flf.entity.PostType;
@WebService
@Path("/PostType")
public interface PostTypeService {
	
	
	
	/**
	 * 查询所有岗位类型信息
	 * @return
	 */
	@GET
	@Path("/listPageuser")
	@Produces(MediaType.APPLICATION_JSON)
	List<PostType> listPageuser();
	
	/**
	 * 根据id查询岗位类型信息
	 * @param appuserId
	 * @return
	 */
	@GET
	@Path("/getPostTypeByIdRest/{postTypeId}")
	@Produces(MediaType.APPLICATION_JSON)
	PostType getPostTypeByIdRest(@PathParam("postTypeId") Integer postTypeId);
	
	/**
	 * 添加岗位类型信息
	 * @param appUser
	 * @return
	 */
	@POST
	@Path("/AddPostType")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void AddPostType(PostType postType);
	
	
	/**
	 *修改岗位类型信息
	 * @param appUser
	 * @return
	 */
	@PUT
	@Path("/UpdatePostType")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void UpdatePostType(PostType postType);
	
	/**
	 * 删除岗位类型信息
	 * @param appUserId
	 * @return
	 */
	@DELETE
	@Path("/DeletePostTypeById/{postTypeId}")
	void DeletePostTypeById(@PathParam("postTypeId") Integer postTypeId);
	
	/**
	 * 根据部门id查询岗位类型列表
	 * @return
	 */
	List<PostType> listPostTypeDivisionbyId(int postTypeId);

}
