package com.flf.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.AreaTypeNew;
import com.flf.entity.ImportantEventType;
import com.flf.entity.PageRestful;

/**
 * 重大事项类型表
 * @author shaozheng
 * 2015-8-19
 */
@WebService
@Path("/ImportantEventType")
public interface ImportantEventTypeService {

	/**
	 * 添加重大事类型及重大事项机制
	 * @param importantEventType
	 */
	@POST
	@Path("/insertImportantEventType")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void insertImportantEventType(ImportantEventType importantEventType);
	
	/**
	 * 获取所有重大事项类型
	 * @return
	 */
	@GET
	@Path("/getAllImportantEventType")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ImportantEventType> getAllImportantEventType();
	
	/**
	 * 添加重大事项处理机制
	 * @param importantEventType
	 */
	@POST
	@Path("/insertHandleMechanism")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void insertHandleMechanism(ImportantEventType importantEventType);
	
	/**
	 * 关闭重大事项类型
	 * @param ImportantEventType
	 */
	@PUT
	@Path("/closeImportantEventType")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void closeImportantEventType(ImportantEventType ImportantEventType);

	/*
	 * 分页查询
	 */
    @POST
 	@Path("/listPageImportantEventTypeRes")
  	@Produces(MediaType.APPLICATION_JSON)
    PageRestful listPageImportantEventType(ImportantEventType importantEventType);
	
    /**
     * 查询所有的重大事项类型
     */
    @GET
	@Path("/getAllImportantEventTypes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ImportantEventType> getAllImportantEventTypes();
}
