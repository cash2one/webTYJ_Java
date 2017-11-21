package com.flf.service;
/*Created by Administrator on 2015/6/3. 
author:尹磊
修改时间：2015/6/3  修改人：尹磊 */
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

import org.apache.ibatis.annotations.Param;

import com.flf.entity.PageRestful;
import com.flf.entity.Search;
import com.flf.entity.Staff;
import com.flf.entity.Teamwork;
import com.flf.entity.Teamworkstaff;
import com.flf.request.TeamworkResult;
@WebService
@Path("/Teamwork")
//团队工作
public interface TeamworkService {
    
   
	
	/**
	 * 团队工作表表增删改查
	 * @return
	 */
		@GET
		@Path("/listPageTeamwork")
		@Produces(MediaType.APPLICATION_JSON)
		List<Teamwork> listPageTeamwork(); 

	
	/**
	 * 根据实例id查询团队信息 尹磊
	 * @param instanceId
	 * @return
	 */
	@GET
	@Path("/listTeamworkbyinstanceId/{instanceId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<Teamwork> listTeamworkbyinstanceId(@PathParam("instanceId") String instanceId);
	
	/**
	 * 根据负责人查询团队信息 尹磊
	 * @param instanceId
	 * @return
	 */
	@GET
	@Path("/getTeamworkbyLeader/{leader}")
	@Produces(MediaType.APPLICATION_JSON)
	List<Teamwork> getTeamworkbyLeader(@PathParam("leader") String leader);
	
	
	@GET
	@Path("/getTeamworkById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	Teamwork getTeamworkByIdRest(@PathParam("id") String id);
	
	@POST
	@Path("/AddTeamwork")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void AddTeamwork(Teamwork teamwork);
	
	@PUT
	@Path("/UpdateTeamwork")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void UpdateTeamwork(Teamwork teamwork);
	
	@DELETE
	@Path("/DeleteTeamworkById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void DeleteTeamworkById(@PathParam("id") String id);
	
	/**
	 * 查询所有团队
	 * @return
	 */
	@GET
	@Path("/listAllTeamwork")
	@Produces(MediaType.APPLICATION_JSON)
	List<Teamwork> listAllTeamwork();
	
	/**
	 * 根据员工id查询我的团队
	 * @param staffId
	 * @return
	 */
	@GET
	@Path("/myTeamProfession/{staffId}/{employId}")
	@Produces(MediaType.APPLICATION_JSON)
	TeamworkResult myTeamProfession(@PathParam("staffId")String staffId, @PathParam("employId")String employId); 
	/**
	 * 通过条件查询团队id
	 * @return
	 */
	@GET
	@Path("/getTeamworkIdBySearch/{projectId}/{specialtyId}")
	@Produces(MediaType.APPLICATION_JSON)
	Teamwork getTeamworkIdBySearch(@PathParam("projectId")String projectId,@PathParam("specialtyId")String specialtyId);

	@GET
	@Path("/myTeamProfessionone")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	TeamworkResult myTeamProfessionone();

	
	@POST
	@Path("/listPageTeamworks")
	@Produces(MediaType.APPLICATION_JSON)
	PageRestful listPageTeamworksRestful(Teamwork teamwork);
	
	/**
	 * 新增团队并将团队信息返回前端
	 * @param teamwork
	 * @return
	 */
	@POST
	@Path("/insertTeamwork")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	Teamwork insertTeamwork(Teamwork teamwork);
	
	/**
	 * 删除子团队
	 * zhuqi 2016.03.08
	 * @param staffId
	 * @return
	 */
	@POST
	@Path("/delTeamwork/{teamworkId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	void delTeamwork(@PathParam("teamworkId") String teamworkId);
	
	/**
	 * 根据子团队Id查询子团队信息
	 * zhuqi 2016.03.09
	 * @param teamworkId
	 * @return Teamwork
	 */
	@GET
	@Path("/getChildTeamById/{teamworkId}")
	@Produces(MediaType.APPLICATION_JSON)
	Teamworkstaff getChildTeamById(@PathParam("teamworkId") String teamworkId);
	
	/**
	 * 查询所有子团队信息
	 * @return
	 */
	@GET
	@Path("/getChildTeam")
	@Produces(MediaType.APPLICATION_JSON)
	List<Teamwork> getChildTeam();
}