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

import com.flf.entity.Role;
@WebService
@Path("/Role")
public interface RoleService {//角色表
	List<Role> listAllRoles();//查询所有角色信息
	Role getRoleById(String roleId);//根据Id查询角色信息
	boolean insertRole(Role role);//添加角色表
	boolean updateRoleBaseInfo(Role role);//修改角色表信息
	void deleteRoleById(String roleId);//删除角色信息
	void updateRoleRights(Role role);//修改角色信息
	
	/**
	 * 查询所有角色信息
	 * @return
	 */
	@GET
	@Path("/listPagerole")
	@Produces(MediaType.APPLICATION_JSON)
	List<Role> listPagerole();
	
	/**
	 * 根据Id查询角色信息
	 * @param roleId
	 * @return
	 */
	@GET
	@Path("/getRoleById/{roleId}")
	@Produces(MediaType.APPLICATION_JSON)
	Role getRoleByIdRest(@PathParam("roleId") String roleId);
	
	/**
	 * 添加角色
	 * @param role
	 */
	@POST
	@Path("/AddRole")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void AddRole(Role role);
	
	/**
	 * 修改角色信息
	 * @param role
	 */
	@PUT
	@Path("/UpdateRole")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void UpdateRole(Role role);
	
	/**
	 * 删除角色信息
	 * @param roleId
	 */
	@DELETE
	@Path("/DeleteRoleById/{roleId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void DeleteRoleById(@PathParam("roleId") String roleId);
	
	
}
