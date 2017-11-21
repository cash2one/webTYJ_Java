package com.flf.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.Intake;
import com.flf.entity.IntakeActivity;
import com.flf.entity.PageRestful;

@Path("/IntakeActivity")
public interface IntakeActivityService {
	/**
	 * 入伙新增绑定
	 * @param giftArticle
	 */
	@POST
   	@Path("/insertIntakeActivity")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
   	void insertIntakeActivity(IntakeActivity intakeActivity);
	
	/**
	 * 创建 by yinlei   
	 * date   2015-7-28
	 * 分页条件查询入伙信息
	 */  
	
    @POST
  	@Path("/listPageIntakeActivity")
  	@Produces(MediaType.APPLICATION_JSON)
    PageRestful listPageIntakeActivity(IntakeActivity intakeActivity);
    
    /**
     * 根据项目id获取项目下的建筑基础数据、建筑、客户资产绑定、个人客户、企业客户的数量
     * 王洲
     * 2016.2.1
     * @param projectId
     * @return
     */
    @GET
    @Path("/getAllNumByProjectId/{projectId}")
    @Produces(MediaType.APPLICATION_JSON)
    IntakeActivity getAllNumByProjectId(@PathParam("projectId") String projectId);
}
