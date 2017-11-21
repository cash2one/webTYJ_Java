package com.flf.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.flf.entity.Staff;
import com.flf.entity.Teamwork;

@XmlRootElement(name = "TeamworkResult") 
public class TeamworkResult {
	private String data;
	private List<Staff> staffs;//团队下的员工
	private Teamwork teamwork;//团队信息	

	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public List<Staff> getStaffs() {
		return staffs;
	}
	public void setStaffs(List<Staff> staffs) {
		this.staffs = staffs;
	}
	public Teamwork getTeamwork() {
		return teamwork;
	}
	public void setTeamwork(Teamwork teamwork) {
		this.teamwork = teamwork;
	}
}
