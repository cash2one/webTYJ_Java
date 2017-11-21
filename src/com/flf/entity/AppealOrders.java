package com.flf.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * 申诉工单
 * @author taoyongchao
 *2015-8-11
 */

@XmlRootElement(name = "AppealOrders")
public class AppealOrders {
	private String orderId;	//申诉工单id
	
	private Integer orderType;//工单类型
	
	private Integer orderState;//工单状态   0关闭  1完成
	
	private String tasksId;//关联任务id
	
	private String serviceRequestId;//关联服务请求id
	
	private String operatorId;//操作人id
	
	private String finishTime;//完成时间
	
	private String remarks;//申诉说明
	
	private String closeTime;//关闭时间
	
	private String closePerson;//关闭操作人id
	
	private String closeRemarks;//关闭原因

	private List<Annex> annexs;//附件表
	

	public String getTasksId() {
		return tasksId;
	}

	public void setTasksId(String tasksId) {
		this.tasksId = tasksId;
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

	public Integer getOrderState() {
		return orderState;
	}

	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
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

	public List<Annex> getAnnexs() {
		return annexs;
	}

	public void setAnnexs(List<Annex> annexs) {
		this.annexs = annexs;
	}
	
	

}
