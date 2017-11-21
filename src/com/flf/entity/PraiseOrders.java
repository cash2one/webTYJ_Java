package com.flf.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * 
 * @author fansensen
 *	最后更改时间：2015-08-19
 */
@XmlRootElement(name="PraiseOrders")
public class PraiseOrders {

	/**
	 * 工单id	order_id	字符串	36	必填	主键
		工单类型	order_type	TINYINT	4	必填	
		工单状态	order_state	TINYINT	4	必填	0关闭；1完成；
		关联任务id	task_id	字符串	36	必填	
		关联服务请求id	service_request_id	字符串	36	必填	
		创建人id	operator_id	字符串	36	必填	
		创建时间	finish_time	Datetime		必填	
		表扬对象id	praise_object_id	字符串	36		
		表扬对象姓名	praise_object_name	字符串	50		
		表扬说明	remarks	字符串	300	可选	
		关闭时间	close_time	Datetime		可选	
		关闭人id	close_person_id	字符串	36	可选	
		关闭原因	close_remarks	字符串	300	可选	
	 */
	private String orderId;
	private Integer orderType;
	private Integer orderState;
	private String taskId;
	private String serviceRequestId;
	private String operatorId;
	private String finishTime;
	private String praiseObjectId;
	private String praiseObjectName;
	private String remarks;
	private String closeTime;
	private String closePersonId;
	private String closeRemarks;
	private List<Annex> annexs;
	
	private List<Staff> staffList;
	
	private List<PraiseStaff> praiseStaffs;
	
	public List<PraiseStaff> getPraiseStaffs() {
		return praiseStaffs;
	}
	public void setPraiseStaffs(List<PraiseStaff> praiseStaffs) {
		this.praiseStaffs = praiseStaffs;
	}
	
	public List<Staff> getStaffList() {
		return staffList;
	}
	public void setStaffList(List<Staff> staffList) {
		this.staffList = staffList;
	}
	public List<Annex> getAnnexs() {
		return annexs;
	}
	public void setAnnexs(List<Annex> annexs) {
		this.annexs = annexs;
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
	public void setOperatorId(String operatorID) {
		this.operatorId = operatorID;
	}
	public String getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}
	public String getPraiseObjectId() {
		return praiseObjectId;
	}
	public void setPraiseObjectId(String praiseObjectId) {
		this.praiseObjectId = praiseObjectId;
	}
	public String getPraiseObjectName() {
		return praiseObjectName;
	}
	public void setPraiseObjectName(String praiseObjectName) {
		this.praiseObjectName = praiseObjectName;
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
	
	
}
