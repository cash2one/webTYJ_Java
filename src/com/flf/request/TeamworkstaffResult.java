package com.flf.request;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.flf.entity.Teamworkstaff;
@XmlRootElement(name = "TeamworkstaffResult") 
public class TeamworkstaffResult {
	List<Teamworkstaff> teamworkstaffs;
	private String prepareId;//编制Id

	public String getPrepareId() {
		return prepareId;
	}

	public void setPrepareId(String prepareId) {
		this.prepareId = prepareId;
	}

	public List<Teamworkstaff> getTeamworkstaffs() {
		return teamworkstaffs;
	}

	public void setTeamworkstaffs(List<Teamworkstaff> teamworkstaffs) {
		this.teamworkstaffs = teamworkstaffs;
	}
	
}
