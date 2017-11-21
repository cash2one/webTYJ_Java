package com.flf.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.HrAuthority;

@WebService
@Path("/hrAuthority")
public interface HrAuthorityService {
	
	/**
	 * 通过用户id获取用户团队信息
	 * @param userId
	 * @return
	 */
	@GET
	@Path("/getHrAuthorityByUserId/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<HrAuthority> getHrAuthorityByUserId(@PathParam("userId") String userId);
	
}
