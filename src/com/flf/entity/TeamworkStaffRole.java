package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="TeamworkStaffRole")
public class TeamworkStaffRole {
    private String id;

    private String teamworkStaffId;

    private String userRoleId;
    
    private Teamworkstaff teamworkStaff;

    public Teamworkstaff getTeamworkStaff() {
		return teamworkStaff;
	}

	public void setTeamworkStaff(Teamworkstaff teamworkStaff) {
		this.teamworkStaff = teamworkStaff;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTeamworkStaffId() {
        return teamworkStaffId;
    }

    public void setTeamworkStaffId(String teamworkStaffId) {
        this.teamworkStaffId = teamworkStaffId == null ? null : teamworkStaffId.trim();
    }

    public String getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId == null ? null : userRoleId.trim();
    }
}