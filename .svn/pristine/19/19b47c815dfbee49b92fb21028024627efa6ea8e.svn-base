package com.flf.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 评分标准
 * @author shaozheng
 *	2015-7-8
 */
@XmlRootElement(name = "ScoreCriteria")
public class ScoreCriteria {
	
	private String criteriaId;//评分标准id
	private String criteriaName;//评分标准名称
	private Integer cycle;//周期类型 0.日检 1.周捡 2.半月检 3.月检
	private Integer criteriaType;//评分标准类型 0园林 1清洁 2安保 3维修
	private Integer criteriaState;//评分标准状态   0关闭  1
	private Integer post;//岗位
	private Integer department;//部门
	private String remarks;//描述
	private String createTime;//创建时间
	private String createPerson;//创建人id
	private String closeTime;//关闭时间
	private String closePerson;//关闭人id
	private String closeRemarks;//关闭备注
	
	private List<ScoreCriteriaItems> scoreCriteriaItemsList;
	
	
	public List<ScoreCriteriaItems> getScoreCriteriaItemsList() {
		return scoreCriteriaItemsList;
	}
	public void setScoreCriteriaItemsList(
			List<ScoreCriteriaItems> scoreCriteriaItemsList) {
		this.scoreCriteriaItemsList = scoreCriteriaItemsList;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getCreatePerson() {
		return createPerson;
	}
	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
	}
	public String getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}
	public String getClosePerson() {
		return closePerson;
	}
	public void setClosePerson(String closePerson) {
		this.closePerson = closePerson;
	}
	public String getCloseRemarks() {
		return closeRemarks;
	}
	public void setCloseRemarks(String closeRemarks) {
		this.closeRemarks = closeRemarks;
	}
	public String getCriteriaId() {
		return criteriaId;
	}
	public void setCriteriaId(String criteriaId) {
		this.criteriaId = criteriaId;
	}
	public String getCriteriaName() {
		return criteriaName;
	}
	public void setCriteriaName(String criteriaName) {
		this.criteriaName = criteriaName;
	}
	public Integer getCycle() {
		return cycle;
	}
	public void setCycle(Integer cycle) {
		this.cycle = cycle;
	}
	public Integer getCriteriaType() {
		return criteriaType;
	}
	public void setCriteriaType(Integer criteriaType) {
		this.criteriaType = criteriaType;
	}
	public Integer getCriteriaState() {
		return criteriaState;
	}
	public void setCriteriaState(Integer criteriaState) {
		this.criteriaState = criteriaState;
	}
	public Integer getPost() {
		return post;
	}
	public void setPost(Integer post) {
		this.post = post;
	}
	public Integer getDepartment() {
		return department;
	}
	public void setDepartment(Integer department) {
		this.department = department;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
