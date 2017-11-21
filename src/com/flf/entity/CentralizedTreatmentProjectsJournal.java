package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 集中处理项目日志表
 * @author shaozheng
 *	2015-7-16
 */
@XmlRootElement(name = "CentralizedTreatmentProjectsJournal")
public class CentralizedTreatmentProjectsJournal {
	private String projectJournalId;//项目日志id
	private String projectId;//项目id
	private String operationTime;//操作时间
	private String operationPersonId;//操作人Id
	private Integer changeState;//修改状态(0关闭 1 完成)
	private String remarks;//备注
	
	public String getProjectJournalId() {
		return projectJournalId;
	}
	public void setProjectJournalId(String projectJournalId) {
		this.projectJournalId = projectJournalId;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getOperationTime() {
		return operationTime;
	}
	public void setOperationTime(String operationTime) {
		this.operationTime = operationTime;
	}
	public String getOperationPersonId() {
		return operationPersonId;
	}
	public void setOperationPersonId(String operationPersonId) {
		this.operationPersonId = operationPersonId;
	}
	public Integer getChangeState() {
		return changeState;
	}
	public void setChangeState(Integer changeState) {
		this.changeState = changeState;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
