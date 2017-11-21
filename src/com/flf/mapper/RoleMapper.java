package com.flf.mapper;

import java.util.List;

import com.flf.entity.Role;

public interface RoleMapper {//角色表
	List<Role> listAllRoles();//查询所有角色
	Role getRoleById(String roleId);//通过Id查询角色
	void insertRole(Role role);//添加角色
	void updateRoleBaseInfo(Role role);//修改角色
	void deleteRoleById(String roleId);//删除角色
	int getCountByName(Role role);//通过名字统计
	void updateRoleRights(Role role);//删除用户
}
