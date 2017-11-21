/**
 * @ClassName: NewLeaseService
 * @Description: TODO
 * @author xiaocong
 * @date 2015-5-26 
 *
 */
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

import com.flf.entity.CarInfo;
import com.flf.entity.NewLease;
import com.flf.entity.PageRestful;
import com.flf.entity.Search;

@WebService
@Path(value = "/NewLease")
public interface NewLeaseService {

	/**
	 * 分页查询租赁记录
	 * 
	 * @param NewLease
	 * @return PageRestful
	 */
	@POST
	@Path("/listPageNewLeaseRestful")
	@Produces(MediaType.APPLICATION_JSON)
	PageRestful listPageNewLeaseRestful(NewLease newLease);

	/**
	 * 查询租赁记录
	 * 
	 * @param
	 * @return List<NewLease>
	 */
	@GET
	@Path("/listAllNewLeaseRestful")
	@Produces(MediaType.APPLICATION_JSON)
	List<NewLease> listAllNewLeaseRestful(NewLease newLease);

	/**
	 * 查询租赁记录
	 * 
	 * @param
	 * @return List<NewLease>
	 */
	@GET
	@Path("/getNewLeaseByIdRestful/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	List<NewLease> getNewLeaseByIdRestful(@PathParam("id") String id);

	/**
	 * 通过租赁id号删除租赁记录（逻辑删除）
	 * 新增同时删除租客关系 陈浪 2016-04-27 14:33:17
	 * @param id
	 * @return
	 */
	@PUT
	@Path("/deleteNewLeaseRestful/{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void deleteNewLeaseRestful(@PathParam("id") String id);

	/**
	 * 插入租赁记录
	 * 
	 * @param NewLease
	 * @return
	 */
	@POST
	@Path("/insertNewLeaseRestful")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void insertNewLeaseRestful(NewLease newLease);

	/**
	 * 通过租赁id修改租赁记录
	 * 
	 * @param id
	 * @return
	 */
	@PUT
	@Path("/updateNewLeaseRestful")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void updateNewLeaseRestful(NewLease newLease);
	
	/**
	 * 通过租客id查询租赁记录 
	 * @param personId
	 * @return
	 */
	@GET
	@Path("/getNewLeaseByleasePersonRestful/{leasePersonId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<NewLease> getNewLeaseByleasePersonRestful(@PathParam("leasePersonId") String leasePersonId);
	
	@GET
	@Path("/getNewLeaseByContract/{contractNumber}")
	@Produces(MediaType.APPLICATION_JSON)
	List<NewLease> getNewLeaseByContract(@PathParam("contractNumber") String contractNumber);
	
	/**
     * 根据搜索条件查询租赁信息
     * @param Search
     * @return
     */
    @POST
  	@Path("/listSearchLease")
  	@Produces(MediaType.APPLICATION_JSON)
    List<NewLease> listSearchLease(Search search);
    
    
    
    /**
     * 根据搜索条件查询租赁信息
     * @param Search
     * @return
     */
    @POST
  	@Path("/listSearchLeaseone")
  	@Produces(MediaType.APPLICATION_JSON)
    List<NewLease> listSearchLeaseone(Search search);
    
    /**
     * 根据搜索条件查询办理人和授权人的租赁信息
     * @param Search
     * @return
     */
    @POST
  	@Path("/listSearchLeaseAu")
  	@Produces(MediaType.APPLICATION_JSON)
    List<NewLease> listSearchLeaseAu(Search search);
    
    /**
     * 分页查询客户下的所有租赁
     */
    @POST
  	@Path("/listPageListSearchLease")
  	@Produces(MediaType.APPLICATION_JSON)
    PageRestful listPageListSearchLease(NewLease newLease);
    
    /**
     * 根据房屋id分页获取租赁信息
     */
    @POST
  	@Path("/listPagegetNewLeasesByHonseId")
  	@Produces(MediaType.APPLICATION_JSON)
   PageRestful listPagegetNewLeasesByHonseId(NewLease newLease);
    
    @POST
  	@Path("/listPageNewLeaseByContion")
  	@Produces(MediaType.APPLICATION_JSON)
    PageRestful listPageNewLeaseByContion(NewLease newLease);
    
    /**
     * 家家客户端使用 房屋出租备案
     * @param jsonStr
     * @param fileUrl
     * @return
     */
    String addNewLease(String jsonStr, String fileUrl);
}
