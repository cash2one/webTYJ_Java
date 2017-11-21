package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 子公司实体类
 * @author Fansensen
 *
 */
@XmlRootElement(name="SubCompany")
public class SubCompany {

	private String subCompanyId;//子公司id
	private String subCompanyName;//子公司名称
	private String companyId;//公司id
	private String createPersonId;//创建人id
	private String createTime;//创建时间
	private String modifiedPersonId;//修改人id
	private String modifiedTime;//修改时间
	
	private List<String> projectIds;//与子公司绑定的项目id	
	private List<String> companyIds;//与子公司绑定的项目id
	private String projectId;//(组织结构显示用)
	private List<String> subCompanyIds;//多个删除子公司id
	private String projectName;//(组织结构显示用)
	
	public List<String> getCompanyIds() {
		return companyIds;
	}
	public void setCompanyIds(List<String> companyIds) {
		this.companyIds = companyIds;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public List<String> getSubCompanyIds() {
		return subCompanyIds;
	}
	public void setSubCompanyIds(List<String> subCompanyIds) {
		this.subCompanyIds = subCompanyIds;
	}
	public List<String> getProjectIds() {
		return projectIds;
	}
	public void setProjectIds(List<String> projectIds) {
		this.projectIds = projectIds;
	}
	private Page page;//分页
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public String getSubCompanyId() {
		return subCompanyId;
	}
	public void setSubCompanyId(String subCompanyId) {
		this.subCompanyId = subCompanyId;
	}
	public String getSubCompanyName() {
		return subCompanyName;
	}
	public void setSubCompanyName(String subCompanyName) {
		this.subCompanyName = subCompanyName;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCreatePersonId() {
		return createPersonId;
	}
	public void setCreatePersonId(String createPersonId) {
		this.createPersonId = createPersonId;
	}
	
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getModifiedPersonId() {
		return modifiedPersonId;
	}
	public void setModifiedPersonId(String modifiedPersonId) {
		this.modifiedPersonId = modifiedPersonId;
	}
	public String getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	
	
	
}
