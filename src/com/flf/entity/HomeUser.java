/**
 * @Title: HomeUser.java
 * @Package com.flf.entity
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-5-29 下午2:01:59
 * @version V1.0
 */

package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @ClassName: HomeUser
 * @Description: TODO
 * @author wangyang
 * @date 2015-5-29 下午2:01:59
 *
 */
@XmlRootElement(name = "HomeUser") //家家用户
public class HomeUser {
	private String userId;

    private String loginname;

    private String password;

    private String username;

    private String rights;

    private Integer status;

    private Integer roleId;

    private Date lastLogin;

    private String nickName;

    private String sex;

    private String email;

    private String selfSign;

    private String phone;

    private String photo;

    private String remark;

    private Integer groupId;

    private Integer permission;

    private String personId;
	
    
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getSelfSign() {
		return selfSign;
	}
	public void setSelfSign(String selfSign) {
		this.selfSign = selfSign;
	}
	public Integer getPermission() {
		return permission;
	}
	public void setPermission(Integer permission) {
		this.permission = permission;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	private Role role;
	private Page page;
	private Date lastLoginStart;
	private Date lastLoginEnd;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getRights() {
		return rights;
	}
	public void setRights(String rights) {
		this.rights = rights;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Date getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	public Date getLastLoginStart() {
		return lastLoginStart;
	}
	public void setLastLoginStart(Date lastLoginStart) {
		this.lastLoginStart = lastLoginStart;
	}
	public Date getLastLoginEnd() {
		return lastLoginEnd;
	}
	public void setLastLoginEnd(Date lastLoginEnd) {
		this.lastLoginEnd = lastLoginEnd;
	}
	public Page getPage() {
		if(page==null)
			page = new Page();
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	
}
