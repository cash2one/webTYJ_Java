package com.flf.service;
/*Created by Administrator on 2015/6/3. 
author:尹磊
修改时间：2015/6/3  修改人：尹磊 */
import java.io.InputStream;
import java.util.HashMap;
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
import com.flf.entity.Staff;
import com.flf.request.Info;
@WebService
@Path("/staff")
//员工
public interface StaffService {
	
	List<Staff> listPageHouse(Staff staff);//查找所有的员工信息
	Staff getStaffById(String staffId);//根据企业id查询员工信息
	int deleteStaff(String staffId);//删除员工信息
	
	int updateStaff(Staff staff);//更新员工信息
	String selectByid(String id); //根据员工id查询员工信息

	List<Staff> listAllStaff();//查询所有员工信息
	List<Staff> listStaffByHillockId(String hillockId);//根据岗位id查询员工信息
	
	String listStaffHillockId(String hillockId);//根据岗位id查询所有员工
	
	int updateStaffByworkCount(String staffid, int workCount);  //修改员工连续上班的天数
	void updateAllStaffworkCount(List<Staff> staff);  //修改员工连续上班的天数
	int updateStaffworkCount(String postid);  //修改连续上班天数为0的员工连续上班的天数改为
	
	/**
	 * 查询当天没有排班且当前岗位的优先并且按照连续上班天数1234560排序
	 * @param map
	 * @return
	 */
	List<Staff> listStaffByCurrentDateAndPostId(HashMap<String, Object> map);
	
	/**
	 * 查询所有员工信息
	 * @return
	 */
	@GET
  	@Path("/listAllStaffRestful")
  	@Produces(MediaType.APPLICATION_JSON)
    List<Staff> listAllStaffRestful();
	
	/**
	 * 根据岗位id查询经理岗位的人员
	 * @return
	 */
	@GET
  	@Path("/getStaffbyPostType/{postId}")
  	@Produces(MediaType.APPLICATION_JSON)
    List<Staff> getStaffbyPostType(@PathParam("postId") String postId);
	
	/**
	 * 根据项目id查询各个专业人员数量
	 * @return
	 */
	@GET
  	@Path("/getStaffbyProjectId/{projectId}")
  	@Produces(MediaType.APPLICATION_JSON)
    List<Staff> getStaffbyProjectId(@PathParam("projectId") String projectId);
	
	
	/**
	 * 根据实例id查询团队负责人信息
	 * @return
	 *//*
	@GET
  	@Path("/getStaffbyName/{instanceId}")
  	@Produces(MediaType.APPLICATION_JSON)
    List<Staff> getStaffbyName(@PathParam("instanceId") String instanceId);*/
	
	/**
	 * 查询团队负责人信息
	 * @return
	 */
	@GET
  	@Path("/getStaffbyName")
  	@Produces(MediaType.APPLICATION_JSON)
    List<Staff> getStaffbyName();
	
	/**
	 * 根据实例id查询人员信息
	 * @return
	 *//*
	@GET
  	@Path("/getStaffbyInstanceId/{instanceId}")
  	@Produces(MediaType.APPLICATION_JSON)
    List<Staff> getStaffbyInstanceId(@PathParam("instanceId") String instanceId);*/
	
	 /**
	 * 添加人员
	 * 
	 * @param staff
	 */
	@POST
   	@Path("/insertStaff")
   	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void insertStaff(Staff staff);
	
	@POST
   	@Path("/insertStaffRestful")
   	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    void insertStaffRestful(Staff staff);
	
	@GET
	@Path("/listPagestaff")
	@Produces(MediaType.APPLICATION_JSON)
	List<Staff> listPageStaff();
	
	/**
	 * 根据Id查询员工信息
	 * @param staffId
	 * @return
	 */
	@GET
	@Path("/getStaffById/{staffId}")
	@Produces(MediaType.APPLICATION_JSON)
	Staff getStaffByIdRest(@PathParam("staffId") String staffId);
	
	@GET
	@Path("/getStaffNameById/{staffId}")
	@Produces(MediaType.APPLICATION_JSON)
	String getStaffNameById(@PathParam("staffId") String staffId);
	
	/**
	 * 根据团队工作Id查询员工信息
	 * @param staffId
	 * @return
	 */
	@GET
	@Path("/listStaffByteamworkId/{teamworkId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<Staff> listStaffByteamworkId(@PathParam("teamworkId") String teamworkId);
	
	/**
	 * 根据岗位Id查询员工信息
	 * @param staffId
	 * @return
	 */
	@GET
	@Path("/listStaffBypostId/{postId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<Staff> listStaffBypostId(@PathParam("postId") String postId);
	
	/**
	 * 添加员工信息
	 * @param staff
	 */
	@POST
	@Path("/AddStaff")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void AddStaff(Staff staff);
	
	/**
	 * 修改员工信息
	 * @param staff
	 */
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("/UpdateStaff")
	public void UpdateStaff(Staff staff);
	
	@GET
	@Path("/listStaffprojectManager")
	@Produces(MediaType.APPLICATION_JSON)
	List<Staff> listStaffprojectManager();//查询核心岗位人员
	
	/**
	 * 删除员工信息
	 * @param staffId
	 */
	@DELETE
	@Path("/DeleteStaffById/{staffId}")
	public void DeleteStaffById(@PathParam("staffId") String staffId);
	
	/**
	 * 修改员工连续上班的天数
	 * @param staffId
	 * @return
	 */
	public int updateStaffByworkCount(String staffId);
	
	    @POST
	  	@Path("/listPageStaffRestful")
	  	@Produces(MediaType.APPLICATION_JSON)
	    PageRestful listPageStaffRestful(Staff staff);
	    @POST
	    @Path("/listPageAllStaff_Unckeck")
	    @Produces(MediaType.APPLICATION_JSON)
	    PageRestful listPageAllStaff_Unckeck(Staff staff);
	 
	 /**
	  * 查询所有未分配的员工信息
	  * 创建by肖聪
	  */
		@GET
		@Path("/listAllStaffNoAllot/{id}/{companyId}")
		@Produces(MediaType.APPLICATION_JSON)
		List<Staff> listAllStaffNoAllot(@PathParam("id") String id, @PathParam("companyId")String companyId);
		
		/**
		 * 添加从Excel文件导入
		 */
		@POST
	  	@Path("/importDataFromExcelFile")
	  	@Produces(MediaType.APPLICATION_JSON)
	  	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
		Info importDataFromExcelFile(Annex annex);
		
		
		/**
		 * 分页查询所有没有分配为管理员的员工
		 * @param staff
		 * @return
		 */
		@POST
		@Path("/listPageStaffForUser")
		@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
		@Produces(MediaType.APPLICATION_JSON)
		PageRestful listPageStaffForUser(Staff staff);
		
		/*删除--改状态0**/
		@PUT
		@Path("/updateStaffStateById")
		@Produces(MediaType.APPLICATION_JSON)
		@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
		void updateStaffStateById(Staff staff);
		
		@GET
	  	@Path("/listAllStaff")
	  	@Produces(MediaType.APPLICATION_JSON)
	    List<Staff> listAllStaffList();
		
		 /**
		 *导入模板
		 */
		InputStream importStaffTemplet();
		
		 /**
		 *导入模板
		 */
		InputStream exportStaffTemplet();
		
		/**
		* 导出数据
		*/
		InputStream exportStaffFile(Staff staff);
		
		@GET
	  	@Path("/listStaffList")
	  	@Produces(MediaType.APPLICATION_JSON)
	    List<Staff> listStaffList(Staff staff);
		
		@POST
	  	@Path("/findUserInfoByUserAppId")
	    List<Staff> findUserInfoByUserAppId(@org.springframework.web.bind.annotation.RequestBody Staff staff);
	}