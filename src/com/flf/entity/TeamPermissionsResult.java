package com.flf.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "TeamPermissionsResult")
public class TeamPermissionsResult {
	
	private List<TeamPermissions> teamPermissions;//权限管理集合

	public List<TeamPermissions> getTeamPermissions() {
		return teamPermissions;
	}

	public void setTeamPermissions(List<TeamPermissions> teamPermissions) {
		this.teamPermissions = teamPermissions;
	}
	

}
