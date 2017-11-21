package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 专项日志记录表
 * @author shaozheng
 *	2015-7-17
 */
@XmlRootElement(name = "SpecialRepairProjectJournal")
public class SpecialRepairProjectJournal {
	
	private String specialJournalId;//专项日志id
	private String specialId;//专项项目id
	private String operationTime;//操作时间
	private String operationPersonId;//操作人Id
	private Integer changeState;//修改状态(0关闭 1 完成)
	private String remarks;//备注
	
	public String getSpecialJournalId() {
		return specialJournalId;
	}
	public void setSpecialJournalId(String specialJournalId) {
		this.specialJournalId = specialJournalId;
	}
	public String getSpecialId() {
		return specialId;
	}
	public void setSpecialId(String specialId) {
		this.specialId = specialId;
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
