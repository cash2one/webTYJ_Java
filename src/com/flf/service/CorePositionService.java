/**
 * @Title: ContractService.java
 * @Package com.flf.service
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-6-11 下午4:03:14
 * @version V1.0
 */

package com.flf.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.AreaTypeNew;
import com.flf.entity.Contract;
import com.flf.entity.ContractPropertyStructure;
import com.flf.entity.CorePosition;
import com.flf.entity.Corporatenews;
import com.flf.entity.PageRestful;
import com.flf.request.Info;
import com.flf.request.PropertyResult;

/**
 * @ClassName: ContractService
 * @Description: TODO
 * @author yinlei
 * @date 2015-7-29 
 *s
 */
//核心岗位
@Path("/CorePosition")
public interface CorePositionService {
		
		
	/**
	 * 任命核心岗位
	 * @param corePosition
	 */
	@POST
	@Path("/AddCorePosition")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void AddCorePosition(CorePosition corePosition);
	
	/**
	 * 查询各个专业线经理
	 * @param corePosition
	 */
	@GET
	@Path("/listCorePost")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	List<CorePosition> listCorePost();
	
	/**
	 * 查询核心岗位经理
	 * @param corePosition
	 */
	@GET
	@Path("/listAllCorePost")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	List<CorePosition> listAllCorePost();
	
	/**
	 * 查询所有项目经理
	 * @param corePosition
	 */
	@GET
	@Path("/listCorePostbyState")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	List<CorePosition> listCorePostbyState();
	
	
	/*
	 * 分页查询
	 */
    @POST
 	@Path("/listPageCorePosition")
  	@Produces(MediaType.APPLICATION_JSON)
    PageRestful listPageCorePositionRestful(CorePosition corePosition);
    
    /**
	 * 查询所有的核心岗位信息
	 * @param corePosition
	 */
	@GET
	@Path("/listAllCorePositionRes")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	List<CorePosition> listAllCorePositionRes();
	
	
	
	/**
	 * 宋佳
	 * 查询所有的核心岗位信息
	 * @param corePosition
	 */
	@POST
	@Path("/listAllCorePositionByCore")
 	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	List<CorePosition> listAllCorePositionByCore(CorePosition corePosition);
	
	
	/**
	 * 通过专业线id查找相关专业线的核心团队信息
	 * @param specialtyId
	 * @return
	 */
	@GET
	@Path("/listCorePositionBySid/{specialtyId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	List<CorePosition> listCorePositionBySid(@PathParam("specialtyId")String specialtyId);
	
	/**
	 *  删除核心岗位人员信息
	 * @param corePosition
	 */
	@PUT
	@Path("/deleteCorePositionRes/{coreId}")
	void deleteCorePositionRes(@PathParam("coreId") String coreId);
	
	/**
	 * 根据员工id查询此员工是否有核心岗位，是否是专业线经理，是否是项目经理
	 * 王洲
	 * 2016.1.26
	 * @param staffId
	 * @return
	 */
	@GET
	@Path("/checkCorePositionByStaffId/{staffId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_JSON, })
	Info checkCorePositionByStaffId(@PathParam("staffId") String staffId);
}
