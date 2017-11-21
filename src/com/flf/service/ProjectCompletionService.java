package com.flf.service;

import javax.jws.WebService;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.request.Info;

/**
 * 项目入伙前置任务完成情况记录
 * @author 王洲
 *
 */

@WebService
@Path("/projectCompletion")
public interface ProjectCompletionService {
	
	/**
	 * 根据项目id和参数分类修改对应的记录
	 * 王洲
	 * 2016.03.04
	 * @param projectId
	 * @param paramTypes
	 * @return
	 */
	@POST
	@Path("/changeStateByProjectIdAndParamTypes/{projectId}/{paramTypes}")
	@Produces(MediaType.APPLICATION_JSON)
	public Info changeStateByProjectIdAndParamTypes(@PathParam("projectId") String projectId, @PathParam("paramTypes") String paramTypes);
	
}
