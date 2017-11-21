package com.flf.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Company")
public class Company {
	
	private String companyId; //公司ID
	
	private String companyAddress;  //公司地址
	
	private String companyLocation;  //公司所在地
	
	private String zipCode;    //公司邮编
	
	private String companyName;  //公司名称
	 
	private String companyPhone;  //公司电话
	
	private List<Project> projectList;//项目集合
	
	private List<Staff> staffList;//员工集合
	
	private double projectArea;//项目总面积
	
	private int projectNum;//项目总数
	
	private int staffNum;//员工总数

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getCompanyLocation() {
		return companyLocation;
	}

	public void setCompanyLocation(String companyLocation) {
		this.companyLocation = companyLocation;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyPhone() {
		return companyPhone;
	}

	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}

	public List<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}

	public List<Staff> getStaffList() {
		return staffList;
	}

	public void setStaffList(List<Staff> staffList) {
		this.staffList = staffList;
	}

	public double getProjectArea() {
		return projectArea;
	}

	public void setProjectArea(double projectArea) {
		this.projectArea = projectArea;
	}

	public int getProjectNum() {
		return projectNum;
	}

	public void setProjectNum(int projectNum) {
		this.projectNum = projectNum;
	}

	public int getStaffNum() {
		return staffNum;
	}

	public void setStaffNum(int staffNum) {
		this.staffNum = staffNum;
	}
	
	

}
