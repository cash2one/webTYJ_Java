/**
 * @Title: PropertyService.java
 * @Package com.flf.service
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-5-5 上午10:04:54
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
import com.flf.entity.PageRestful;
import com.flf.entity.Property;
import com.flf.entity.PropertyType;
import com.flf.entity.Staff;
import com.flf.request.Info;
import com.flf.request.PropertyResult;
import com.flf.request.PropertyTypeResult;

/**
 * @ClassName: PropertyService
 * @Description: TODO
 * @author wangyong
 * @date 2015-5-5 上午10:04:54
 * @author zhuwei
 * @date 2015-06-29
 */
@WebService
@Path("/Property")
public interface PropertyService {
	
	/**
	 * 查询所有资产信息
	 * @return
	 */
	@POST
	@Path("/listProperty")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	List<Property> listProperty(Property property);
	
	/**
	 * 查询所有资产信息
	 * @return
	 */
	@GET
	@Path("/listPropertyAll")
	@Produces(MediaType.APPLICATION_JSON)
	List<Property> listPropertyAll();
	
	
	/**
	 * 根据id查询资产信息
	 * @param id
	 * @return
	 */
	@GET
	@Path("/getPropertyByIdRest/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	Property getPropertyByIdRest(@PathParam("id") String id);
	
	/**
	 * 根据父节点id查询专业资产列表
	 * @param id
	 * @return
	 */
	@GET
	@Path("/getPropertyByparentIdRest/{parentId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<Property> getPropertyByparentIdRest(@PathParam("parentId") String parentId);
	
	/**
	 * 添加资产信息
	 * @param Property
	 * @return
	 */
	@POST
	@Path("/AddProperty")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void AddProperty(Property property);
	
	
	/**
	 *修改资产信息
	 * @param appProperty
	 * @return
	 */
	@PUT
	@Path("/UpdateProperty")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void UpdateProperty(Property property);
	
	/**
	 * 删除资产信息
	 * @param id
	 * @return
	 */
	@DELETE
	@Path("/DeletePropertyById/{id}")
	void DeletePropertyById(@PathParam("id") String id);
	
	/**
	  * initializeProperty(合同初始化)
	  * TODO(这里描述这个方法适用条件 – 可选)
	  * TODO(这里描述这个方法的执行流程 – 可选)
	  * TODO(这里描述这个方法的使用方法 – 可选)
	  * TODO(这里描述这个方法的注意事项 – 可选)
	  *
	  * @Title: initializeProperty
	  * @Description: TODO
	  * @param @param propertyResult
	  * @param @return    设定文件
	  * @return List<Property>    返回类型
	  * @throws
	  */
	
	
	@POST
	@Path("/initializeProperty")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void initializeProperty(PropertyResult propertyResult);
	
	
	
	/**
	 * 根据条件查询资产信息
	 * @param propertyTypeResult
	 * @return
	 */
	@POST
	@Path("/listPropertyByPropertyTypes")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	List<PropertyType> listPropertyByPropertyTypes(PropertyTypeResult propertyTypeResult);
	
	/**
	 * 根据条件查询资产信息分页
	 * 朱琪 2016年2月22日
	 * @param propertyTypeResult
	 * @return
	 */
	@POST
	@Path("/listPageProperty")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	PageRestful listPageProperty(Property property);
	
	@POST
	@Path("/listPropertys")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	List<PropertyType> listPropertys(PropertyTypeResult propertyTypeResult);
	


	@GET
	@Path("/getPropertyDataByIdRest/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	List<Property> getPropertyDataByIdRest(@PathParam("id") String id);
	
	/**
  	 * 导入Excel数据文档
  	 * 朱琪 2016年2月23日
  	 * @param annex
  	 * @return
  	 */
  	@POST
  	@Path("/importExcelFileProperty")
  	@Produces(MediaType.APPLICATION_JSON)
  	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
  	Info importExcelFileProperty(Annex annex);
  	
  	/**
	 *导入模板
	 *朱琪 2016年2月22日
	 */
	InputStream importPropertyTemplet();
	
	/**
	* 导出数据
	* 朱琪 2016年2月23日
	*/
	InputStream exportPropertyFile(Property property);
}
