/**
 * @Title: AuthorizationService.java
 * @Package com.flf.service
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author 肖聪
 * @date 2015-6-4 下午4:01:46
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

import com.flf.entity.AreaTypeNew;
import com.flf.entity.Authorization;
import com.flf.entity.PageRestful;
import com.flf.entity.Search;

/**
 * @ClassName: AuthorizationService
 * @Description: TODO
 * @author wangyong
 * @date 2015-5-20 下午4:01:46
 *
 */
@WebService
@Path("/Authorization")
public interface AuthorizationService {
	
	
	 /**
     * 查询所有授权信息
     * @return
     */
    @GET
	@Path("/listAllAuthorization")
	@Produces(MediaType.APPLICATION_JSON)
    List<Authorization> listAllAuthorization();
    /**
     * 根据id查询授权信息
     * @param authorizationId
     * @return Authorization 
     */
    @GET
  	@Path("/getAuthorizationbyId/{authorizationId}")
  	@Produces(MediaType.APPLICATION_JSON)
    Authorization getAuthorizationbyId(@PathParam("authorizationId")String authorizationId);
    
    /**
     * 根据被授权人id查询授权信息
     * @param authorizationId
     * @return List<Authorization>
     */
    @GET
  	@Path("/getAuthorizedbyId/{authorizedPersonId}")
  	@Produces(MediaType.APPLICATION_JSON)
   List<Authorization> getAuthorizedbyId(@PathParam("authorizedPersonId")String authorizedPersonid);

    /**
     * 新增授权信息
     * @param Authorization
     */
    
    @POST
	@Path("/AddAuthorization")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
	 void AddAuthorization(Authorization authorization);
	/**
	 *  修改授权信息
	 * @param Authorization
	 */
	@PUT
	@Path("/UpdateAuthorizationbyId")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void UpdateAuthorizationbyId(Authorization authorization);
	/**
	 *  删除授权信息
	 * @param authorizationId
	 */
	@DELETE
	@Path("/DeleteAuthorizationbyId/{authorizationId}")
	void DeleteAuthorizationbyId(@PathParam("authorizationId") String authorizationId);
	
	/**	 
	 *肖聪 添加mapper方法
	 *根据
	 *creat 2015/5/29
	 */
	 @GET
	  	@Path("/getAuthorizedbyIdLease/{authorizedPersonid}")
	  	@Produces(MediaType.APPLICATION_JSON)
	   List<Authorization> getAuthorizedbyIdLease(@PathParam("authorizedPersonid")String authorizedPersonid);

	 /**	 
		 *肖聪 添加mapper方法
		 *更据对象集合在mybaits中用foreach标签进行条件查询集合中人的房屋信息	
		 *creat 2015/5/29
		 */
	 @GET
	  	@Path("/getAuthorizedbyIdLeaseAndHouse/{authorizedPersonid}")
	  	@Produces(MediaType.APPLICATION_JSON)
	   List<Authorization> getAuthorizedbyIdLeaseAndHouse(@PathParam("authorizedPersonid")String authorizedPersonid);
	 /**	 
		 *肖聪 添加mapper方法
		 *通过被授权人查询授权了的车位
		 *creat 2015/6/4
		 */
	 @GET
	  	@Path("/getAuthorizedbyIdLeaseAndStall/{authorizedPersonid}")
	  	@Produces(MediaType.APPLICATION_JSON)
	   List<Authorization> getAuthorizedbyIdLeaseAndStall(@PathParam("authorizedPersonid")String authorizedPersonid);
	 
	 /**
	     * 根据条件查询出授权记录   
	     */
	    
	    @POST
	   	@Path("listAllAuthorizationBySearch")
	    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	   	@Produces(MediaType.APPLICATION_JSON)
	    List<Authorization>   listAllAuthorizationBySearch(Search search);
	    
	    /*
		 * 分页查询
		 */
	    @POST
	 	@Path("/listPageAuthorizationRestful")
	  	@Produces(MediaType.APPLICATION_JSON)
	    PageRestful listPageAuthorization(Authorization authorization);
	    
	    @POST
		@Path("/insertAuthorization")
	    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	    @Produces(MediaType.APPLICATION_JSON)
		void AddAuthorizationRes(Authorization authorization);
}
