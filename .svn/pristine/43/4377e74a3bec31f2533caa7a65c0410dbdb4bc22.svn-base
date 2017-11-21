package com.flf.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.TUser;

/**
 * 用户操作接口
 * @author Administrator
 *
 */
public interface UserServiceNew {
	/*
	 * 根据登录名获取用户
	 */
	@GET
	@Path("/getTUserbyLoginName/{loginName}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public TUser getTUserbyLoginName(@PathParam("loginName") String loginName);
}
