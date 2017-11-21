package com.flf.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.VipProjectStaff;

/**
 * @ClassName: VipProjectStaffService
 * @Description: TODO
 * @author wangzhou
 * @date 2015-4-20 下午4:45:25
 *
 */
@Path(value="/VipProjectStaff")
public interface VipProjectStaffService {
    
	/**
	 * 向VIP客户项目专员表中添加数据
	 * @param vjs
	 */
    @POST
   	@Path("/insertVipProjectStaff")
   	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    void insertVipProjectStaff(VipProjectStaff vjs);
    
    /**
     * 根据vip客户id查询客户是否已经关联项目及专员
     * @param vipId
     * @return list
     */
    @GET
    @Path("/selectVipProStaffByVipid/{vipId}")
    @Produces(MediaType.APPLICATION_JSON)
    List<VipProjectStaff> selectVipProStaffByVipid(@PathParam("vipId") String vipId);
    
    /**
     * 根据vipid删除用户在表中的数据
     * @param vipId
     */
    @GET
    @Path("/deleteVipProStaffByVipid/{vipId}")
    void deleteVipProStaffByVipid(@PathParam("vipId") String vipId);
    
    /**
     * 修改VIP客户在表中的数据
     * @param vps
     */
    @POST
    @Path("/updateVipProStaff")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    void updateVipProjectStaff(VipProjectStaff vps);
    
    /**
     * VIP列表页面根据传入的vipid查询表中的数据
     * @param vipId
     * @return
     */
    @GET
    @Path("/selectallByVipid/{vipId}")
    @Produces(MediaType.APPLICATION_JSON)
    List<VipProjectStaff> listAllByVipid(@PathParam("vipId") String vipId);
}
