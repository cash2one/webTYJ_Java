package com.flf.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 催办任务记录表
 * @author shaozheng
 *	2015-8-26
 */
@XmlRootElement(name="UrgeTaskRecords")
public class UrgeTaskRecords {
	private String recordId;//	记录
	private String taskId;//关联任务
	private String operatorId;//操作人id
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date urgeTime;//催促时间
	private String urgeRemarks;//催促备注
	private int urgeSum; //催促次数
	
	private Staff staff;
	private Page page;
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	public Date getUrgeTime() {
		return urgeTime;
	}
	public void setUrgeTime(Date urgeTime) {
		this.urgeTime = urgeTime;
	}
	public String getUrgeRemarks() {
		return urgeRemarks;
	}
	public void setUrgeRemarks(String urgeRemarks) {
		this.urgeRemarks = urgeRemarks;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public int getUrgeSum() {
		return urgeSum;
	}
	public void setUrgeSum(int urgeSum) {
		this.urgeSum = urgeSum;
	}

	
}
