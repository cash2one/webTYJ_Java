package com.flf.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.PostAuthority;

@WebService
@Path("/PostAuthority")
public interface PostAuthorityService {

	/**
	 *根据交账记录id查询银行存单表
	 * @param accountRecordId
	 * @return
	 */
	@GET
	@Path("/selectActionPermissions/{postId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<PostAuthority> selectActionPermissions(@PathParam("postId") String postId);

	/**
	 * 根据用户id获取岗位权限信息
	 * @param userId
	 * @return
	 */
	@GET
	@Path("/getPostAuthorityByUserId/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<PostAuthority> getPostAuthorityByUserId(@PathParam("userId") String userId);
} 
