package com.flf.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 巡检工单
 * @author yangshengquan
 *	2016-7-27
 */
@XmlRootElement(name="InspectionOrder")
public class InspectionOrder {
	private String orderId;//工单id
	private Integer orderType;//工单类型
	private Integer orderState;//工单状态
	private String taskId;//任务id
	private String serviceRequestId;//服务请求id
	private String operatorId;//创建人id
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:dd")
	private Date finishTime;//完成时间
	private String remarks;//备注描述
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:dd")
	private Date closeTime;//关闭时间
	private String closePersonId;//关闭操作人
	private String closeRemarks;//关闭说明
	private String state;//提交状态
	private Staff staff;//员工 
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Integer getOrderType() {
		return orderType;
	}
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}
	public Integer getOrderState() {
		return orderState;
	}
	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getServiceRequestId() {
		return serviceRequestId;
	}
	public void setServiceRequestId(String serviceRequestId) {
		this.serviceRequestId = serviceRequestId;
	}
	public String getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Date getCloseTime() {
		return closeTime;
	}
	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}
	public String getClosePersonId() {
		return closePersonId;
	}
	public void setClosePersonId(String closePersonId) {
		this.closePersonId = closePersonId;
	}
	public String getCloseRemarks() {
		return closeRemarks;
	}
	public void setCloseRemarks(String closeRemarks) {
		this.closeRemarks = closeRemarks;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
	
}
