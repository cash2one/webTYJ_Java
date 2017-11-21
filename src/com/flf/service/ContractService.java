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
import com.flf.entity.Contract;
import com.flf.entity.PageRestful;
import com.flf.request.PropertyResult;

/**
 * @ClassName: ContractService
 * @Description: TODO
 * @author wangyang
 * @date 2015-6-11 下午4:03:14
 *
 */
//合同表
@Path("/Contract")
public interface ContractService {
    List<Contract> listAllContract();
    Contract getContractById(String id);
    int insertContract(Contract contract);
    int updateContract(Contract contract);
    int deleteContract(String id);
    
    
    /**
      * listAllContractRest(获取所有合同列表)
      * TODO(这里描述这个方法适用条件 – 可选)
      * TODO(这里描述这个方法的执行流程 – 可选)
      * TODO(这里描述这个方法的使用方法 – 可选)
      * TODO(这里描述这个方法的注意事项 – 可选)
      *
      * @Title: listAllContractRest
      * @Description: TODO
      * @param @return    设定文件
      * @return List<Contract>    返回类型
      * @throws
      */
    
    /**
	 * 分页查询项目表
	 * @return
	 */
	@POST
	@Path("/listPageContract")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	PageRestful listPageContract(Contract contract);
    
    
    @GET
  	@Path("/listAllContract")
  	@Produces(MediaType.APPLICATION_JSON)
    List<Contract> listAllContractRest();
    
    /**
      * getContractByIdRest(根据主键获取合同详细信息)
      * TODO(这里描述这个方法适用条件 – 可选)
      * TODO(这里描述这个方法的执行流程 – 可选)
      * TODO(这里描述这个方法的使用方法 – 可选)
      * TODO(这里描述这个方法的注意事项 – 可选)
      *
      * @Title: getContractByIdRest
      * @Description: TODO
      * @param @param id
      * @param @return    设定文件
      * @return Contract    返回类型
      * @throws
      */
    
    
    @GET
    @Path("/getContractById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Contract getContractByIdRest(@PathParam("id")String id);
    
    /**
      * insertContractRest(新增合同)
      * TODO(这里描述这个方法适用条件 – 可选)
      * TODO(这里描述这个方法的执行流程 – 可选)
      * TODO(这里描述这个方法的使用方法 – 可选)
      * TODO(这里描述这个方法的注意事项 – 可选)
      *
      * @Title: insertContractRest
      * @Description: TODO
      * @param @param contract    设定文件
      * @return void    返回类型
      * @throws
      */
    
    
    @POST
   	@Path("/insertContractRest")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
   	void insertContractRest(Contract contract);
    
    /**
      * updateContractRest(修改合同信息)
      * TODO(这里描述这个方法适用条件 – 可选)
      * TODO(这里描述这个方法的执行流程 – 可选)
      * TODO(这里描述这个方法的使用方法 – 可选)
      * TODO(这里描述这个方法的注意事项 – 可选)
      *
      * @Title: updateContractRest
      * @Description: TODO
      * @param @param contract    设定文件
      * @return void    返回类型
      * @throws
      */
    
    
    @PUT
   	@Path("/updateContractRest")
   	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
   	void updateContractRest(Contract contract);
    
    /**
      * DeleteAccountById(根据主键删除合同)
      * TODO(这里描述这个方法适用条件 – 可选)
      * TODO(这里描述这个方法的执行流程 – 可选)
      * TODO(这里描述这个方法的使用方法 – 可选)
      * TODO(这里描述这个方法的注意事项 – 可选)
      *
      * @Title: DeleteAccountById
      * @Description: TODO
      * @param @param id    设定文件
      * @return void    返回类型
      * @throws
      */
    
    
    @DELETE
   	@Path("/deleteContract/{id}")
   	void DeleteAccountById(@PathParam("id")String id);
    
    
    
   
    
    
    
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
	@Path("/insertInitializeProperty")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public void insertInitializeProperty(PropertyResult propertyResult);

	  /**
	   * 根据资产id得到合同信息
	   * @param id
	   * @return
	   */
	  @GET
	  @Path("/getContractDataByIdRest/{id}")
	  @Produces(MediaType.APPLICATION_JSON)
	  List<Contract> getContractDataByIdRest(@PathParam("id")String id);
	
}
