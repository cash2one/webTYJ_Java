package com.flf.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.HrAuthority;
import com.flf.entity.HrPermissions;
import com.flf.entity.PageRestful;
import com.flf.entity.Staff;
import com.flf.entity.TUser;
import com.flf.entity.TUserPermissions;
import com.flf.entity.TUserRole;
import com.flf.entity.TeamworkStaffRole;
/**
 * 系统设置HR管理员设置
 * @author wangzhou
 * @date 2015-10-26
 */
@WebService
@Path("/Admin")
public interface AdminService {
	
	/**
	 * 获取角色为HR管理员的用户
	 * @return
	 */
	@GET
	@Path("/getTUserAsHrAdmin")
	@Produces(MediaType.APPLICATION_JSON)
	List<TUser> getTUserAsHrAdmin();

	/**
	 * 新增管理员
	 * @param staff
	 */
	@POST
	@Path("/insertTUserByStaff")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void insertAdminByStaff(Staff staff);
	
	/**
	 * 根据角色和员工查询用户信息
	 * 朱琪 2016.03.02
	 * @param staff
	 */
	@POST
	@Path("/getStateByRole")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public int getStateByRole(Staff staff);
	
	/**
	 * 新增管理员
	 * @param staff
	 */
	@POST
	@Path("/insertAdminByStaffone")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void insertAdminByStaffone(Staff staff);
	
	/**
	 * 获取权限表所有数据
	 * @return
	 */
	@GET
	@Path("/listHrPermissions")
	@Produces(MediaType.APPLICATION_JSON)
	List<HrPermissions> listHrPermissions();
	
	/**
	 * 向角色权限表中添加数据
	 * @param tUserPermissions
	 */
	@GET
	@Path("/insertTUserPermissions/{userId}/{permissionsId}")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	void insertTUserPermissions(@PathParam("userId") String userId, @PathParam("permissionsId") String permissionsId);
	
	/**
	 * 根据用户id查询关联的权限
	 * @param userId
	 * @return
	 */
	@GET
	@Path("/listTUserPermissionsByuserId/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<TUserPermissions> listTUserPermissionsByuserId(@PathParam("userId") String userId); 
	
	/**
	 * 删除用户和功能权限的关联
	 * @param tUserPermissions
	 */
	@POST
	@Path("/deleteTUserPermissions/{userId}/{permissionsId}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void deleteTUserPermissions(@PathParam("userId") String userId, @PathParam("permissionsId") String permissionsId);
	
	/**
	 * 取消团队操作员权限
	 * @param staffId
	 */
	@GET
	@Path("/delHrAuthority/{staffId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void delHrAuthority(@PathParam("staffId") String staffId);
	
	/**
	 * 向操作权限表中添加数据
	 * @param hrAuthority
	 */
	@POST
	@Path("/insertHrAuthority/{tUserId}/{corePositionId}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void insertHrAuthority(@PathParam("tUserId") String tUserId, @PathParam("corePositionId") String corePositionId);
	
	/**
	 * 获取管理员关联的操作权限
	 * @param tUserId
	 * @return
	 */
	@GET
	@Path("/listAuthorityByuserId/{tUserId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<HrAuthority> listAuthorityByuserId(@PathParam("tUserId") String tUserId);
	
	/**
	 * 删除管理员关联的操作权限
	 * @param hrAuthority
	 */
	@POST
	@Path("/deleteHrAuthority/{tUserId}/{corePositionId}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void deleteHrAuthority(@PathParam("tUserId") String tUserId, @PathParam("corePositionId") String corePositionId);
	
	/**
	 * 判断管理员是否可以操作团队
	 * @param tUserId
	 * @return
	 */
	@GET
	@Path("ifOderToAuthorityByuserId/{userId}/{description}")
	@Produces(MediaType.APPLICATION_JSON)
	public String ifOderToAuthorityByuserId(@PathParam("userId") String userId,@PathParam("description") String description);
	
	/**
	 * 分页查询所有HR管理员
	 * @param tUserRole
	 * @return
	 */
	@POST
	@Path("listPageAdmin")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	PageRestful listPageAdmin(TUserRole tUserRole);
	
	/**
	 * 判断员工在用户表中是否存在
	 * @param tUser
	 * @return
	 */
	@POST
	@Path("/getCountByTUser")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCountByTUser(TUser tUser);
	
	/**
	 * 根据员工id获取对应的TUser对象
	 * @param staffId
	 * @return
	 */
	@GET
	@Path("/getTUserByStaffId/{staffId}")
	@Produces(MediaType.APPLICATION_JSON)
	TUser getTUserByStaffId(@PathParam("staffId") String staffId);
	
	/**
	 * 根据用户id查询关联的团队信息
	 * @param userId
	 * @return
	 */
	@GET
	@Path("/listAuthorityForTeam/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<HrAuthority> listAuthorityForTeam(@PathParam("userId") String userId); 
	
	/**
	 * 根据用户id查询关联的项目信息
	 * @param userId
	 * @return
	 */
	@GET
	@Path("/listAuthorityForProject/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<HrAuthority> listAuthorityForProject(@PathParam("userId") String userId); 
	
	/**
	 * 根据用户id查询关联的权限信息
	 * @param userId
	 * @return
	 */
	@GET
	@Path("/listAuthorityForPower/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<HrAuthority> listAuthorityForPower(@PathParam("userId") String userId); 
	
	/**
	 * 向用户团队关联表中添加信息
	 * @param hrAuthority
	 * @return
	 */
	@POST
	@Path("/insertAuthority")
	@Produces(MediaType.APPLICATION_JSON)
	public int insertAuthority(HrAuthority hrAuthority);
	
	/**
	 * 改变传入的用户的角色关联
	 * @param tUser
	 */
	@POST
	@Path("/changeRoleByUser")
	@Produces(MediaType.APPLICATION_JSON)
	public void changeRoleByUser(TUser tUser);
	
	/**
	 * 是否为其他团队操作员
	 * @param userId
	 * @return
	 */
	@POST
	@Path("/getTUserRoleByUserId/{staffId}")
	@Produces(MediaType.APPLICATION_JSON)
	public int getTUserRoleByUserId(@PathParam("staffId") String staffId);
	
	/**
	 * 查询团队操作员信息
	 * @param staffId
	 * @return
	 */
	@POST
	@Path("/getTeamwoekStaffByStaffId/{staffId}")
	@Produces(MediaType.APPLICATION_JSON)
	public TeamworkStaffRole getTeamwoekStaffByStaffId(@PathParam("staffId") String staffId);

	/**
	 * 删除用户团队关系
	 * @param hrAuthority
	 */
	@POST
	@Path("/deleteAuthority")
	@Produces(MediaType.APPLICATION_JSON)
	void deleteAuthority(HrAuthority hrAuthority);
	
	/**
	 * 删除hr和或系统管理员的权限
	 * 朱琪 2016.03.03
	 * @param hrAuthority
	 */
	@POST
	@Path("/deletePermissions")
	@Produces(MediaType.APPLICATION_JSON)
	void deletePermissions(HrAuthority hrAuthority);
	
	/**
	 * 删除hr和或系统管理员的权限
	 * 朱琪 2016.03.07
	 * @param hrAuthority
	 */
	@POST
	@Path("/deleteAdmin")
	@Produces(MediaType.APPLICATION_JSON)
	void deleteAdmin(Staff staff);
	
	/**
	 * 根据用户id查询用户信息，及包括的权限
	 * 王洲
	 * 2016.1.30
	 * @param userId
	 * @return
	 */
	@GET
	@Path("/getTUserByUserId/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	TUser getTUserByUserId(@PathParam("userId") String userId);
	
	/**
	 * 根据岗位、姓名、工号查询员工信息
	 * @param staff
	 * @return
	 */
	@POST
	@Path("/listPageFindUserByPost")
	@Produces(MediaType.APPLICATION_JSON)
	PageRestful listPageFindUserByPost(Staff staff);
	
	/**
	 * 根据id修改审批状态
	 * @param tUser
	 */
	@POST
	@Path("/updateAccountForStatus")
	@Produces(MediaType.APPLICATION_JSON)
	int updateAccountForStatus(TUser tUser);
}
