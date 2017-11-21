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

import com.flf.entity.AreaNew;
import com.flf.entity.AreaTypeNew;
import com.flf.entity.InspectionPlan;
import com.flf.entity.PageRestful;
import com.flf.entity.Scheme;


@WebService
@Path("/InspectionPlan")
public interface InspectionPlanService {
	/**
	 * 新增
	 * @param 
	 * @return
	 */
	@POST
	@Path("/insertInspectionPlan")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void insert(InspectionPlan inspectionPlan);
	/***
	 * 查询所有的巡检方案
	 * @return
	 */
	@GET
	@Path("/listAllInspectionPlan")
	@Produces(MediaType.APPLICATION_JSON)
	List<InspectionPlan> listAllInspectionPlan();
	/***
	 * 根据状态查询巡检方案   杨升权 7.20
	 * @return
	 */
	@GET
	@Path("/listAllInspectionPlan1/{state}")
	@Produces(MediaType.APPLICATION_JSON)
	List<InspectionPlan> listAllInspectionPlan1(@PathParam("state")String state);
	
	/***
	 * 分页显示有效的巡检方案
	*/
    @POST
 	@Path("/listPageInspectionPlanByState")
  	@Produces(MediaType.APPLICATION_JSON)
    PageRestful listPageInspectionPlanByStateRestful(InspectionPlan inspectionPlan);
	/**
	 * 修改
	 * @param inspectionPlan
	 */
	@PUT
	@Path("/updateByPrimary")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void updateByPrimaryKeySelective(InspectionPlan inspectionPlan);
	
	@GET
	@Path("/getInspectionPlan1/{inspectionPlanId}")
	@Produces(MediaType.APPLICATION_JSON)
	InspectionPlan getInspectionPlan1(@PathParam("inspectionPlanId")String inspectionPlanId);
	
	
}