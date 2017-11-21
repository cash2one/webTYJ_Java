/**
 * @Title: EnterpriseCustNewService.java
 * @Package com.flf.service
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-5-27 上午9:49:00
 * @version V1.0
 */

package com.flf.service;

import java.io.InputStream;
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

import com.flf.entity.Annex;
import com.flf.entity.EnterpriseCustNew;
import com.flf.entity.PageRestful;
import com.flf.entity.PersonCustNew;
import com.flf.entity.Search;
import com.flf.request.Info;

/**
 * @ClassName: EnterpriseCustNewService
 * @Description: TODO
 * @author wangyong
 * @date 2015-5-27 上午9:49:00
 *
 */
@WebService
@Path("/EnterpriseCustNew")//客户基本信息表
public interface EnterpriseCustNewService {
	
	
	  	@GET
		@Path("/listAllEnterpriseCustNewRestful")
		@Produces({MediaType.APPLICATION_JSON})
	    List<EnterpriseCustNew> listAllEnterpriseCustNewRestful();  //查询所有企业客户信息
	    
	    /**
	     * 根据id查询企业客户基本信息
	     * @param id
	     * @return
	     */
	    @GET
		@Path("/getEnterpriseCustNewByIdRestful/{enterpriseId}")
		@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	    EnterpriseCustNew getEnterpriseCustNewByIdRestful(@PathParam("enterpriseId") String enterpriseId);
	    
	    /**
	     * 添加企业客户基本信息
	     * @param EnterpriseCustNew
	     */
	    @POST
		@Path("/insertEnterpriseCustNew")
	    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	    void insertEnterpriseCustNew( EnterpriseCustNew EnterpriseCustNew);
	    
	    /**
	     * 添加企业客户基本信息
	     * @param EnterpriseCustNew
	     */
	    @POST
		@Path("/insertEnterpriseCustNewRestful/{ids}")
	    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	    void insertEnterpriseCustNewRestful(@PathParam("ids") String ids, EnterpriseCustNew EnterpriseCustNew);
	    
	    /**
	     * 修改企业客户基本信息
	     * @param EnterpriseCustNew
	     */
	    @PUT
		@Path("/updateEnterpriseCustNewRestful")
		@Consumes( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	    void updateEnterpriseCustNewRestful(EnterpriseCustNew enterpriseCustNew);
	    
	    /**
	     * 根据id删除企业客户基本信息
	     * @param id
	     */
	    /*
	     * Bug 747 陈浪 2016.3.7
	     * enterpriseId
	     */
	    @DELETE
		@Path("/deleteEnterpriseCustNewRestful/{enterpriseId}")
	    void deleteEnterpriseCustNewRestful(@PathParam("enterpriseId") String enterpriseId);
	
	    @POST
	   	@Path("/listPageEnterpriseCustNewRestful")
	   	@Produces(MediaType.APPLICATION_JSON)
	    PageRestful listPageEnterpriseCustNewRestful(EnterpriseCustNew EnterpriseCustNew);  //分页显示所有企业客户信息
	    
	    /**
	     * 根据条件查询企业客户信息
	     * @param EnterpriseCustNew
	     */
	    @POST
		@Path("/findEnterpriseCustNewRestful")
		@Consumes( {MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	 	@Produces(MediaType.APPLICATION_JSON)
	    List<EnterpriseCustNew> findEnterpriseCustNewRestful(EnterpriseCustNew enterpriseCustNew);
	    
	    /**
	     * 根据条件查询出公司信息    
	     */
	    
	    @POST
	   	@Path("listAllEnterpriseBySearch")
	    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	   	@Produces(MediaType.APPLICATION_JSON)
	    List<PersonCustNew>   listAllEnterpriseBySearch(Search search);
	    
	    /**
	     * 通过企业名称 ，编号地址等条件查询业主的信息
	     * @param personCust
	     */
	    @POST
		@Path("/listEnterpriseCustNewByCondition")
	    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	    List<EnterpriseCustNew>  listEnterpriseCustNewByCondition(EnterpriseCustNew enterpriseCustNew);
	    

		/**
	  	 * 导入Excel数据文档
	  	 * @param annex
	  	 * @return
	  	 */
	  	@POST
	  	@Path("/importExcelFiles")
	  	@Produces(MediaType.APPLICATION_JSON)
	  	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	  	Info importExcelFileRes(Annex annex);
	  	
	    
	    /**
	     * 通过企业名称 ，编号地址等条件查询业主的信息 分页
	     * @param personCust
	     */
	    @POST
		@Path("/listPageEnterpriseCustNewByCondition")
	    @Produces(MediaType.APPLICATION_JSON)
	    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	    PageRestful  listPageEnterpriseCustNewByCondition(EnterpriseCustNew enterpriseCustNew);
	   

		 /**
	    * 将需要进行EXCEL导入的数据先写入模板并导出到本地
	    */
	   InputStream exportEnterperiseFile(EnterpriseCustNew enterpriseCustNew);
	   
	   /**
	    *导入模板
	    */
	   InputStream importEnterpriseExcelTemplet();
	    
}
