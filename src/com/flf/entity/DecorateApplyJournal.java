package com.flf.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * 三.	装修申请日志
 * @author taoyongchao
 *   2015-8-20
 */
@XmlRootElement(name="DecorateApplyJournal")
public class DecorateApplyJournal {
	private String  recordId; //记录id
	private String  applyId; //装修申请关联Id
	private String operatorId; //操作人id
	private Date  operationTime; //操作时间
	private Integer  changeState; //变更状态
	private String  remarks;  //备注
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getApplyId() {
		return applyId;
	}
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}
	public String getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public Date getOperationTime() {
		return operationTime;
	}
	public void setOperationTime(Date operationTime) {
		this.operationTime = operationTime;
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
