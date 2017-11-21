/**
 * @Title: AfterSaleServiceProcess.java
 * @Package com.flf.serviceProcess
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author chenrui
 * @date 2016-7-28
 * @version V1.0
 */

package com.flf.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.AfterSale;
import com.flf.entity.AfterSaleProcess;
import com.flf.entity.AfterSaleQuery;
import com.flf.entity.PageRestful;
import com.flf.entity.Project;
import com.flf.entity.PropertyType;
import com.flf.entity.TUser;

/**
 * @ClassName: AfterSaleProcessService
 * @Description: TODO
 * @author chenrui
 * @date 2016-7-28
 *
 */
@WebService
@Path(value="/AfterSaleProcess")
public interface AfterSaleProcessService {

	//分页查询售后处理表所有数据
    @POST
  	@Path("/listPageAfterSaleProcess")
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    PageRestful listPageAfterSaleProcess(AfterSaleProcess afterSaleProcess);
    
    @GET
  	@Path("/listAllAfterSaleProcessRestful")
  	@Produces(MediaType.APPLICATION_JSON)
    List<AfterSaleProcess> listAllAfterSaleProcessRestful();
    
    @GET
  	@Path("/getAfterSaleProcessByIdRestful/{id}")
  	@Produces(MediaType.APPLICATION_JSON)
    AfterSaleProcess getAfterSaleProcessByIdRestful(@PathParam("id") String id);
    
    @DELETE
   	@Path("/deleteAfterSaleProcessRestful/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    void deleteAfterSaleProcessRestful(@PathParam("id") String id);
    
    @POST
   	@Path("/insertAfterSaleProcessRestful")
   	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    void insertAfterSaleProcessRestful(AfterSaleProcess afterSaleProcess);
    
    @PUT
   	@Path("/updateAfterSaleProcessRestful")
   	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    void updateAfterSaleRestful(AfterSaleProcess afterSaleProcess);
    
    @PUT
    @Path("/updateAfterSaleProcessSelectiveRestful")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    void updateAfterSaleProcessSelectiveRestful(AfterSaleProcess afterSaleProcess);
    
    @GET
  	@Path("/getUserNameByUserId/{id}")
  	@Produces(MediaType.APPLICATION_JSON)
    TUser getUserNameByUserId(@PathParam("id") String id);
}
