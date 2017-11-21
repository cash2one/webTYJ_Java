package com.flf.entity;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="ConpanyTree")
public class ConpanyTree {
	private String id;
	private String pId;	
	private String companyName;
	private List<ConpanyTree> treeList=new ArrayList<ConpanyTree>();
	
	public List<ConpanyTree> getTreeList() {
		return treeList;
	}
	public void setTreeList(List<ConpanyTree> treeList) {
		this.treeList = treeList;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
	
}
