package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Role") 
public class Role {//角色
	private String roleId;//角色Id
	private String roleName;//角色名称
	private String rights;//角色类型
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRights() {
		return rights;
	}
	public void setRights(String rights) {
		this.rights = rights;
	}
	
}
