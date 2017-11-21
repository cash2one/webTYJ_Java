package com.flf.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 重大事项类型日志记录表
 * @author shaozheng
 *	2015-8-21
 */
@XmlRootElement(name="ImportantEventTypeJournal")
public class ImportantEventTypeJournal {

	private String recordId;//记录
	private String eventTypeId;//关联重大事项类型
	private String operatatorId;//操作人
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date operatorTime;//操作时间
	private Integer changeState;//状态变更
	private String remarks;//操作说明
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getEventTypeId() {
		return eventTypeId;
	}
	public void setEventTypeId(String eventTypeId) {
		this.eventTypeId = eventTypeId;
	}
	public String getOperatatorId() {
		return operatatorId;
	}
	public void setOperatatorId(String operatatorId) {
		this.operatatorId = operatatorId;
	}
	public Date getOperatorTime() {
		return operatorTime;
	}
	public void setOperatorTime(Date operatorTime) {
		this.operatorTime = operatorTime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Integer getChangeState() {
		return changeState;
	}
	public void setChangeState(Integer changeState) {
		this.changeState = changeState;
	}
}
