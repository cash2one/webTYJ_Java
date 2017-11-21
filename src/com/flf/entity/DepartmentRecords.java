package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * 部门质量检测记录表
 * @author shaozheng
 * 2015-7-14
 */
@XmlRootElement(name = "DepartmentRecords")
public class DepartmentRecords {
	
	private String recordId;//结果记录id
	private String orderId;//关联工单id
	private String checkObjectId;//检查对象id
	private String checkObjectName;//检查对象姓名
	private String checkTime;//检查日期
	private String score;//得分
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCheckObjectId() {
		return checkObjectId;
	}
	public void setCheckObjectId(String checkObjectId) {
		this.checkObjectId = checkObjectId;
	}
	public String getCheckObjectName() {
		return checkObjectName;
	}
	public void setCheckObjectName(String checkObjectName) {
		this.checkObjectName = checkObjectName;
	}
	public String getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
}
