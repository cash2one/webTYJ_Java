package com.flf.entity;

public class ZTree {
	
	private String id;  //节点id
	private String name;  //节点名称
	private String pId;  //上级节点id
	private String fullName; //当前节点与上级节点名称拼接
	private String isParent;  //是否有父节点
	
	public String getIsParent() {
		return isParent;
	}
	public void setIsParent(String isParent) {
		this.isParent = isParent;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}

}
