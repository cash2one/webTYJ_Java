package com.flf.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;



/**
 * 检测单
 * @author 邵政
 *	2015-6-30
 */
@XmlRootElement(name = "CheckOrders")
public class CheckOrders {
	private String orderId;// 处理工单id

	private Integer orderType;// 工单类型

	private Integer orderState; // 工单状态

	private String taskId;// 关联任务id

	private String serviceRequestId;// 关联服务请求id

	private String operatorId;// 操作人id

	private String remarks;// 备注
	
	private String finishTime;// 完成时间

	private String closeTime;//关闭时间
	
	private String closePerson; // 关闭操作人
	
	private String closeRemarks;//关闭原因
	
	private String changeStateRemarks; //修改状态备注
	
	private String signatory;//签字人
	
	private Staff staff;// 关联员工表
	
	private List<CheckItemRecords> checkItemRecords; //检测项结果记录表
	
	private List<Annex> annexs;//附件表
	
	public String getSignatory() {
		return signatory;
	}

	public void setSignatory(String signatory) {
		this.signatory = signatory;
	}

	public List<CheckItemRecords> getCheckItemRecords() {
		return checkItemRecords;
	}

	public void setCheckItemRecords(List<CheckItemRecords> checkItemRecords) {
		this.checkItemRecords = checkItemRecords;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
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

	public String getChangeStateRemarks() {
		return changeStateRemarks;
	}

	public void setChangeStateRemarks(String changeStateRemarks) {
		this.changeStateRemarks = changeStateRemarks;
	}

	public List<Annex> getAnnexs() {
		return annexs;
	}

	public void setAnnexs(List<Annex> annexs) {
		this.annexs = annexs;
	}
}
