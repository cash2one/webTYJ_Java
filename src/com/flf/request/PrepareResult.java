package com.flf.request;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.flf.entity.Post;
import com.flf.entity.Staff;

@XmlRootElement(name = "PrepareResult") 
public class PrepareResult {
	private String projectId;//项目id
	 private Post post;//岗位
	 private List<Staff> staffs;//员工

	 private String teamworkId;//团队id

	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	public List<Staff> getStaffs() {
		return staffs;
	}
	public void setStaffs(List<Staff> staffs) {
		this.staffs = staffs;
	}
	public String getTeamworkId() {
		return teamworkId;
	}
	public void setTeamworkId(String teamworkId) {
		this.teamworkId = teamworkId;
	}
}
