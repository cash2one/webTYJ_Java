package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 向客户索赔工单表
 * @author shaozheng
 *	2015-8-12
 */
@XmlRootElement(name="ClaimToCustomerOrders")
public class ClaimToCustomerOrders {
	
	private String orderId;//工单id
	private Integer orderType;//工单类型
	private Integer orderState;//工单状态
	private String taskId;//任务id
	private String serviceRequestId;//服务请求id
	private String operatorId;//创建人id
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:dd")
	private Date finishTime;//完成时间
	private String customerObjectId;//	索赔对象id
	private String customerObjectName;//	索赔对象姓名
	private String customerObjectPhonenum;//	索赔对象电话
	private String remarks;//备注描述
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:dd")
	private Date closeTime;//关闭时间
	private String closePersonId;//关闭操作人
	private String closeRemarks;//关闭说明
	private String signature;//签字人
	
	private Staff staff;//员工 
	private List<Annex> annexs;//附件
	private ClaimToCustomerRethods claimToCustomerRethods;//赔偿方案
	
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
	public String getCustomerObjectId() {
		return customerObjectId;
	}
	public void setCustomerObjectId(String customerObjectId) {
		this.customerObjectId = customerObjectId;
	}
	public String getCustomerObjectName() {
		return customerObjectName;
	}
	public void setCustomerObjectName(String customerObjectName) {
		this.customerObjectName = customerObjectName;
	}
	public String getCustomerObjectPhonenum() {
		return customerObjectPhonenum;
	}
	public void setCustomerObjectPhonenum(String customerObjectPhonenum) {
		this.customerObjectPhonenum = customerObjectPhonenum;
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
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public List<Annex> getAnnexs() {
		return annexs;
	}
	public void setAnnexs(List<Annex> annexs) {
		this.annexs = annexs;
	}
	public ClaimToCustomerRethods getClaimToCustomerRethods() {
		return claimToCustomerRethods;
	}
	public void setClaimToCustomerRethods(
			ClaimToCustomerRethods claimToCustomerRethods) {
		this.claimToCustomerRethods = claimToCustomerRethods;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
}
