package com.flf.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "VipProjectStaff") 
public class VipProjectStaff {
	/*
	 * t_vip_project_staff	VIP客户项目专员关联表
	 */
    
	private String id;//主键
	
	private String vipId;//关联VipId
	
	private String projectId;//关联项目id
	
	private String staffId;//关联专员ID
	
	private List<String> projectIds;//关联项目id集合
	
	private String projectName;//关联项目表项目名称
	
	private List<String> projectNames;//关联项目表项目名称集合
	
	private String staffName;//关联员工表员工名

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVipId() {
		return vipId;
	}

	public void setVipId(String vipId) {
		this.vipId = vipId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public List<String> getProjectIds() {
		return projectIds;
	}

	public void setProjectIds(List<String> projectIds) {
		this.projectIds = projectIds;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<String> getProjectNames() {
		return projectNames;
	}

	public void setProjectNames(List<String> projectNames) {
		this.projectNames = projectNames;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	
}