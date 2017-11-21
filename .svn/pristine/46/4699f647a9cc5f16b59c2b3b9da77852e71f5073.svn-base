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

import com.flf.entity.CentralizedTreatmentProjects;
import com.flf.entity.CentralizedTreatmentProjectsJournal;
import com.flf.entity.PageRestful;
import com.flf.entity.SpecialRepairProject;
import com.flf.entity.Tasks;
import com.flf.request.Info;

@WebService
@Path("/CentralizedTreatmentProjects")
public interface CentralizedTreatmentProjectsService {

	
	/**
	 * 添加集中处理项目
	 * @param centralizedTreatmentProjects
	 */
	@POST
	@Path("/insertCentralizedTreatmentProjects")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void insertCentralizedTreatmentProjects(CentralizedTreatmentProjects centralizedTreatmentProjects);
	
	/**
	 * 根据状态查询集中处理项目
	 * @param state
	 * @return
	 */
	@GET
	@Path("/getCentralizedTreatmentProjectsbyState/{state}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CentralizedTreatmentProjects> getCentralizedTreatmentProjectsbyState(@PathParam("state") String state);
	
	/**
	 * 通过projectState获取集中处理项个数
	 * @param projectState
	 * @return
	 */
	@GET
	@Path("/getCentralizedTreatmentProjectsCount/{projectState}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCentralizedTreatmentProjectsCount(@PathParam("projectState")String projectState);
	
	/**
	 * 修改状态  0关闭 1完成
	 * @param projectId
	 */
	@PUT
	@Path("/changeState")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Info changeState(CentralizedTreatmentProjectsJournal journal);
	
	/**
	 * 根据集中处理项目id获取任务
	 * @param projectsJournal
	 * @return
	 */
	@GET
	@Path("/getTasksbyProjectId/{projectId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Tasks> getTasksbyProjectId(@PathParam("projectId")String projectId);
	
	/**
	 * 获取所有的集中处理项
	 * @return
	 */
	@GET
	@Path("/getAllCentralizedTreatmentProjects")	
	@Produces(MediaType.APPLICATION_JSON)
	public List<CentralizedTreatmentProjects> getAllCentralizedTreatmentProjects();
	
	/**
	 * 获取所有的启动的集中处理项
	 */
	@GET
	@Path("/getAllCentralizedTreatmentProjectsAlive")
	@Produces(MediaType.APPLICATION_JSON)
	List<CentralizedTreatmentProjects> getAllCentralizedTreatmentProjectsAlive();
	
	
	
	
	/**
  	 * 根据集中处理项状态分页查询集中处理项信息
  	 */
  	@POST
	@Path("/listPageCentralizedTreatmentProjectsbyState")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public PageRestful listPageCentralizedTreatmentProjectsbyState(CentralizedTreatmentProjects project);
	
	
	
}
