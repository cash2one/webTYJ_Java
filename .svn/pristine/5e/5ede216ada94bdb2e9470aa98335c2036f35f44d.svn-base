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

import com.flf.entity.LogType;


@WebService
@Path(value = "/LogType")
public interface LogTypeService {
	
    
    
    
    /**
     * 查询所有日志类型
     * @return
     */
    @GET
	@Path("/listAllLogType")
	@Produces(MediaType.APPLICATION_JSON)
    List<LogType> listAllLogTypeeRestful();
    
    /**
     * 根据id查询日志类型
     * @return
     */
    @GET
	@Path("/selectLogTypeById/{logTypeId}")
	@Produces(MediaType.APPLICATION_JSON)
    LogType selectLogTypeById(@PathParam("logTypeId") String logTypeId);
    
	/**
	 * 新增日志类型
	 * @return
	 */
	@POST
	@Path("/insertLogType")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void insertLogTypeRestful(LogType logType);

	
	/**
	 * 修改日志类型
	 * @return
	 */
	@PUT
	@Path("/updateArticleRelease")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void updateArticleReleaserestRestful(LogType logType);
	
}
