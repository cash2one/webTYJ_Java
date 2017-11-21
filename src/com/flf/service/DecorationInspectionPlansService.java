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

import com.flf.entity.DecorationInspectionPlans;
import com.flf.entity.FrequencyRecord;
import com.flf.entity.InspectionPlan;
import com.flf.entity.PageRestful;

@WebService
@Path("/DecorationInspectionPlans")
public interface DecorationInspectionPlansService {
/**
 * 新增装修巡检方案
 * @param decorationInspectionPlans
 */
	@POST
	@Path("/AddDecorationInspectionPlans")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void AddDecorationInspectionPlans(DecorationInspectionPlans decorationInspectionPlans);
	/**
	 * 状态分页条件查寻显示装修巡检方案
	 * @param decorationInspectionPlans
	 * @return
	 */
	@POST
	@Path("/listPageDecorationInspectionPlans")
	@Produces(MediaType.APPLICATION_JSON)
	PageRestful listPageDecorationInspectionPlans(DecorationInspectionPlans decorationInspectionPlans);
	/**
	 * 通过装修巡检方案Id查询装修巡检方案
	 * @param decorationInspectionPlanId
	 * @return
	 */
	    @GET
	    @Path("/getDecorationInspectionPlansbyId/{decorationInspectionPlanId}")
	    @Produces(MediaType.APPLICATION_JSON)
	   DecorationInspectionPlans getDecorationInspectionPlansbyId(@PathParam("decorationInspectionPlanId") String decorationInspectionPlanId);

    /**
	 * 修改状态
	 * @param decorationInspectionPlanId
	 */
	@PUT
	@Path("/UpdateDecorationInspectionPlans")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void UpdateDecorationInspectionPlans(DecorationInspectionPlans decorationInspectionPlans);
	
	
	/**
	 * 所有有效装修巡检方案
	 * @param decorationInspectionPlans
	 * @return
	 */
	@GET
	@Path("/getDecorationInspectionPlans")
	@Produces(MediaType.APPLICATION_JSON)
	List<DecorationInspectionPlans> getDecorationInspectionPlans();
	
	
	/**
	 * 装修巡检方案id查询执行频率
	 * @param FrequencyRecord
	 * @return
	 */
	@GET
	@Path("/getDecorationFrequencyRecord/{relationId}")
	@Produces(MediaType.APPLICATION_JSON)
	FrequencyRecord getDecorationFrequencyRecord(@PathParam("relationId") String relationId);
}
