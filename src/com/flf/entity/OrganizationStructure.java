package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * 组织结构
 * @author shaozheng
 *	2015-7-28
 */
@XmlRootElement(name="OrganizationStructure")
public class OrganizationStructure {

	private String organizationId;
	private String organizationName;
	private String parentsId;
	private String leaderName;
	private String leaderId;
	public String getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getParentsId() {
		return parentsId;
	}
	public void setParentsId(String parentsId) {
		this.parentsId = parentsId;
	}
	public String getLeaderName() {
		return leaderName;
	}
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}
	public String getLeaderId() {
		return leaderId;
	}
	public void setLeaderId(String leaderId) {
		this.leaderId = leaderId;
	}
}
