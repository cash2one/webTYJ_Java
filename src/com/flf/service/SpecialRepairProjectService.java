package com.flf.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.Billing;
import com.flf.entity.PageRestful;
import com.flf.entity.PersonCustNew;
import com.flf.entity.SpecialRepairProject;
import com.flf.entity.SpecialRepairProjectJournal;
import com.flf.entity.Tasks;
import com.flf.request.Info;

/**
 * 专项表
 * @author shaozheng
 *	2015-7-17
 */
@WebService
@Path("/SpecialRepairProject")
public interface SpecialRepairProjectService {

	/**
	 * 添加專項信息
	 * @param project
	 */
	@POST
	@Path("/insertSpecialRepairProject")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void insertSpecialRepairProject(SpecialRepairProject project);
	
	/**
	 * 查询所有的专项信息
	 */
	@GET
	@Path("/getAllSpecialRepairProject")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SpecialRepairProject> getAllSpecialRepairProject();
	
	/**
	 * 根据专项id获取专项信息
	 */
	@GET
	@Path("/getSpecialRepairProjectbyId/{specialId}")
	@Produces(MediaType.APPLICATION_JSON)
	public SpecialRepairProject getSpecialRepairProjectbyId(@PathParam("specialId") String specialId);
	
	/**
	 * 修改状态  0关闭 1启用 2 完成
	 * @param projectId
	 */
	@PUT
	@Path("/changeState")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Info changeState(SpecialRepairProjectJournal journal);
	
	/**
	 * 根据专项状态查询专项信息
	 * @return
	 */
	@GET
	@Path("/getSpecialRepairProjectbyState/{state}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SpecialRepairProject> getSpecialRepairProjectbyState(@PathParam("state") String state);
	
	/**
  	 * 根据专项状态分页查询专项信息
  	 */
/*  @GET
	@Path("/listPageSpecialRepairProjectbyState")
	@Produces(MediaType.APPLICATION_JSON)
  	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  	public PageRestful listPageSpecialRepairProjectbyState(SpecialRepairProject project);*/
  	
  	@POST
	@Path("/listPageSpecialRepairProjectbyState")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public PageRestful listPageSpecialRepairProjectbyState(SpecialRepairProject project);
  	
  	/**
	 * 通过specialState获取专项处理项个数
	 * @param specialState
	 * @return
	 */
	@GET
	@Path("/getSpecialRepairProjectCountbyState/{specialState}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getSpecialRepairProjectCountbyState(@PathParam("specialState")String specialState);

}
