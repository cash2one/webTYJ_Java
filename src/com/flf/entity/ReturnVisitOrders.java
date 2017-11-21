package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 回访工单
 * @author 陶勇超
 *  2015-8-7
 */
@XmlRootElement(name = "ReturnVisitOrders")
public class ReturnVisitOrders {
	private String orderId;//工单id
	private Integer orderType;//工单类型   7.回访工单
	private String taskId;//任务id
	private String serviceRequestId;//服务请求id
	private Integer orderState;//工单状态
	private String orderWriter;//工单负责人
	private String finishTime;//完成时间
	private String remarks;//备注说明
	private String closeTime;//关闭时间
	private String closePerson;//关闭操作人id
	private String closeRemarks;//关闭原因
	private Integer attitude;   //处理态度评分
	private Integer completion; //完成情况评分
	private Integer processing;  //处理时间评分
	private String operatorId;  //操作人ID
	
	
	
	
	public String getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
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
	public Integer getOrderState() {
		return orderState;
	}
	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
	}
	public String getOrderWriter() {
		return orderWriter;
	}
	public void setOrderWriter(String orderWriter) {
		this.orderWriter = orderWriter;
	}
	public String getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	public Integer getAttitude() {
		return attitude;
	}
	public void setAttitude(Integer attitude) {
		this.attitude = attitude;
	}
	public Integer getCompletion() {
		return completion;
	}
	public void setCompletion(Integer completion) {
		this.completion = completion;
	}
	public Integer getProcessing() {
		return processing;
	}
	public void setProcessing(Integer processing) {
		this.processing = processing;
	}
	
	
	

}
