/**
 * @Title: StoreNewService.java
 * @Package com.flf.service
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-6-10 上午10:19:35
 * @version V1.0
 */

package com.flf.service;

import java.io.InputStream;
import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.Annex;
import com.flf.entity.PageRestful;
import com.flf.entity.Search;
import com.flf.entity.StoreNew;
import com.flf.request.Info;




/**
 * @ClassName: StoreNewService
 * @Description: TODO
 * @author wangyong
 * @date 2015-6-10 上午10:19:35
 *
 */
@WebService
@Path("/StoreNew")
public interface StoreNewService {

	/**
	 * 根据Id查询商铺信息
	 * @param roleId
	 * @return
	 */
	@GET
	@Path("/getStoreNewRest/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	StoreNew getStoreNewRest(@PathParam("id") String id);
	
	
	/**
	 *添加商铺信息
	 * @param roleId
	 * @return
	 */
	 @POST
	 @Path("/insertStoreNewRestful")
	 @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	 void insertStoreNewRestful(StoreNew StoreNew);
	 
	 /**
	 *添加商铺信息
	 * @param roleId
	 * @return
	 */
	 @POST
	 @Path("/addStoreNew")
	 @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	 void addStoreNew(StoreNew storeNew);
	 
	 /**
	 *添加商铺信息
	 * @param roleId
	 * @return
	 */
	 @POST
	 @Path("/listSearchStoreNew")
	 @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	 List<StoreNew> listSearchStoreNew(Search search);
	 
	 /**
     * 将需要进行EXCEL导入的数据先写入模板并导出到本地
     */
     InputStream exportStoreNewFile(String projectId);
	    
     /**
  	  * 导入Excel数据文档
  	  * @param annex
      * @return
  	 */
  	 @POST
  	 @Path("/importExcelFile")
  	 @Produces(MediaType.APPLICATION_JSON)
  	 @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
  	 Info importExcelFile(Annex annex);
  	 
  	 /**
  	  * 导出所有商铺信息
  	  * 王洲
  	  * 2016.1.8
  	  * @return
  	  */
  	 InputStream exportAllStoreNew();
  	 
  	 /**
  	  * 修改商铺数据
  	  * @author 王洲
  	  * @date 2016.03.11
  	  * @param storeNew
  	  */
  	 @POST
  	 @Path("/updateStoreNew")
  	 @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  	 void updateStoreNew(StoreNew storeNew);
  	 
  	/**
  	  * 根据项目id分页查询项目下所有商铺信息
  	  * @author wangzhou
  	  * @date 2016-03-24
  	  * @param storeNew
  	  * @return
  	  */
  	 @POST
  	 @Path("listPageStoreByProjectId")
  	 @Produces(MediaType.APPLICATION_JSON)
  	 PageRestful listPageStoreByProjectId(StoreNew storeNew);


  	 /**
  	  * 修改单条商铺数据
  	  * @author 王洲
  	  * @date 2016.03.24
  	  * @param storeNew
  	  */
  	 @POST
  	 @Path("/updateStore")
  	 @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  	 void updateStore(StoreNew storeNew);
  	 
   	/**
  	  * 根据建筑结构id分页查询项目下所有商铺信息
  	  * @author ylq
  	  * @date 2016-07-05
  	  * @param storeNew
  	  * @return
  	  */
  	 @POST
  	 @Path("listPageStoreByBuildingStructureId")
  	 @Produces(MediaType.APPLICATION_JSON)
  	 PageRestful listPageStoreByBuildingStructureId(StoreNew storeNew);
  	
}
