package com.flf.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *  部门质检工单
 * @author shaozheng
 *	2015-7-14
 */
@XmlRootElement(name = "DepartmentOrders")
public class DepartmentOrders {
	
	private String orderId;//工单id
	private Integer orderType;//工单类型   5.部门质检工单
	private String tasksId;//任务id
	private String serviceRequestId;//服务请求id
	private Integer orderState;//工单状态
	private String orderWriter;//工单负责人
	private String finishTime;//完成时间
	private String remarks;//备注说明
	private String closeTime;//关闭时间
	private String closePersonId;//关闭操作人id
	private String closeRemarks;//关闭原因
	
	private List<DepartmentRecords> departmentRecordsList;//部门质检工单记录信息
	private List<Annex> annexs;//附件
	
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
	public String getTasksId() {
		return tasksId;
	}
	public void setTasksId(String tasksId) {
		this.tasksId = tasksId;
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
	public List<DepartmentRecords> getDepartmentRecordsList() {
		return departmentRecordsList;
	}
	public void setDepartmentRecordsList(
			List<DepartmentRecords> departmentRecordsList) {
		this.departmentRecordsList = departmentRecordsList;
	}
	public List<Annex> getAnnexs() {
		return annexs;
	}
	public void setAnnexs(List<Annex> annexs) {
		this.annexs = annexs;
	}
}
