package com.flf.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.TeamworkStaffAdd;

@WebService
@Path("/teamworkStaffAdd")
public interface TeamworkStaffAddService {
	
	/**
	 * 添加可加入团队
	 * @param teamworkstaffResult
	 */
	@POST
	@Path("/insertTeamworkStaff")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public int insertTeamworkStaff(TeamworkStaffAdd teamworkStaffSdd);
	
	/**
	 * 移除可加入团队
	 * @return
	 */
	@GET
	@Path("/delTeamworkStaff/{teamworkId}/{staffId}")
	@Produces(MediaType.APPLICATION_JSON)
	public int delTeamworkStaff(@PathParam("teamworkId") String teamworkId, @PathParam("staffId") String staffId); 

	/**
	 * 获取已加入列表
	 * @param staffId
	 * @return
	 */
	@GET
	@Path("/listTeamworkStaffAdd/{staffId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TeamworkStaffAdd> listTeamworkStaffAdd(@PathParam("staffId") String staffId); 
	
}
