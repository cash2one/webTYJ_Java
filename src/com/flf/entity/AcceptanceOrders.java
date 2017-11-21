package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * 验收单
 * @author 邵政
 * 2015-6-25
 */

@XmlRootElement(name = "AcceptanceOrders")
public class AcceptanceOrders {
	private String orderId;	//验收工单id
	
	private Integer orderType;//工单类型
	
	private Integer orderState;//工单状态   0关闭  1完成
	
	private String taskId;//关联任务id
	
	private String serviceRequestId;//关联服务请求id
	
	private String operatorId;//操作人id
	
	private Integer acceptanceItemResult;//验收结果  0.合格 1不合格  2 好 3 非常好
	
	private String finishTime;//完成时间
	
	private String remarks;//备注
	
	private String closeTime;//关闭时间
	
	private String closePerson;//关闭操作人id
	
	private String closeRemarks;//关闭原因
	
	private String changeStateRemarks; //修改状态备注
	
	private String satisfaction;//满意度（满分五颗星）
	
	private String signatory;//签字人
	
	private Staff staff;//员工对象
	
	private List<AcceptanceInformationRecords> acceptanceInformation; // 验收单信息对象
	
	private List<Annex> annexs;//附件表
	
//	private ServiceRequest serviceRequest;
//	
//	private Tasks tasks;

	public String getOrderId() {
		return orderId;
	}


	public String getSignatory() {
		return signatory;
	}

	public void setSignatory(String signatory) {
		this.signatory = signatory;
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

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

//	public ServiceRequest getServiceRequest() {
//		return serviceRequest;
//	}
//
//	public void setServiceRequest(ServiceRequest serviceRequest) {
//		this.serviceRequest = serviceRequest;
//	}
//
//	public Tasks getTasks() {
//		return tasks;
//	}
//
//	public void setTasks(Tasks tasks) {
//		this.tasks = tasks;
//	}

	public Integer getOrderState() {
		return orderState;
	}

	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
	}

	public List<AcceptanceInformationRecords> getAcceptanceInformation() {
		return acceptanceInformation;
	}

	public void setAcceptanceInformation(
			List<AcceptanceInformationRecords> acceptanceInformation) {
		this.acceptanceInformation = acceptanceInformation;
	}
	public Integer getAcceptanceItemResult() {
		return acceptanceItemResult;
	}

	public void setAcceptanceItemResult(Integer acceptanceItemResult) {
		this.acceptanceItemResult = acceptanceItemResult;
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


	public String getSatisfaction() {
		return satisfaction;
	}


	public void setSatisfaction(String satisfaction) {
		this.satisfaction = satisfaction;
	}
}
