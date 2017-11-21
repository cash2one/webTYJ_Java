/**
 * @Title: ArchitectureNewService.java
 * @Package com.flf.service
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-6-15 上午11:54:27
 * @version V1.0
 */

package com.flf.service;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.ArchitectureNew;

/**
 * @ClassName: ArchitectureNewService
 * @Description: TODO
 * @author wangyong
 * @date 2015-6-15 上午11:54:27
 *
 */
@WebService
@Path("/ArchitectureNew")
public interface ArchitectureNewService {

	/**
	 * 根据Id查询公摊信息
	 * @param roleId
	 * @return
	 */
	@GET
	@Path("/getArchitectureNewRest/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	ArchitectureNew getArchitectureNewRest(@PathParam("id") String id);
	
	
	/**
	 *添加商铺信息
	 * @param roleId
	 * @return
	 */
	 @POST
	 @Path("/insertArchitectureNewRestful")
	 @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	 void insertArchitectureNewRestful(ArchitectureNew ArchitectureNew);

}
