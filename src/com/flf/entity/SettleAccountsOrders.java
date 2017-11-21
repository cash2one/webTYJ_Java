package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * 结算单
 * @author shaozheng
 * 2015-7-3
 */
@XmlRootElement(name = "SettleAccountsOrders")
public class SettleAccountsOrders {
	
	private String orderId;// 结算工单id

	private Integer orderType;// 工单类型

	private Integer orderState; // 工单状态

	private String taskId;// 任务id

	private String serviceRequestId;// 服务请求id
	
	private String buildingStructureId;//建筑结构Id
	
	private String projectId;//收费项目id
	
	private String settleAccountsItemId;//结算单id
	
	private String buildingNum;//建筑编号
	
	private PersonCustNew personCustNew;//客户信息
	
	private Double allTotal;//全部总价

	private String operatorId;// 操作人id

	private String remarks;// 备注

	private String finishTime;// 完成时间

	private String closeTime;//关闭时间
	
	private String closePerson; // 关闭操作人
	
	private String closeRemarks;//关闭原因
	
	private String changeStateRemarks; //修改状态备注
	
	private Staff staff;// 关联员工表
	
	private List<SettleAccountsItemRecords> saiRecords;//结算项记录表
	
	private List<Annex> annexs;//附件表
	
	private String signature; //签字人

	
	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
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

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public List<SettleAccountsItemRecords> getSaiRecords() {
		return saiRecords;
	}

	public void setSaiRecords(List<SettleAccountsItemRecords> saiRecords) {
		this.saiRecords = saiRecords;
	}

	public Double getAllTotal() {
		return allTotal;
	}

	public void setAllTotal(Double allTotal) {
		this.allTotal = allTotal;
	}

	public List<Annex> getAnnexs() {
		return annexs;
	}

	public void setAnnexs(List<Annex> annexs) {
		this.annexs = annexs;
	}

	public String getSettleAccountsItemId() {
		return settleAccountsItemId;
	}

	public void setSettleAccountsItemId(String settleAccountsItemId) {
		this.settleAccountsItemId = settleAccountsItemId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public PersonCustNew getPersonCustNew() {
		return personCustNew;
	}

	public void setPersonCustNew(PersonCustNew personCustNew) {
		this.personCustNew = personCustNew;
	}

	public String getBuildingNum() {
		return buildingNum;
	}

	public void setBuildingNum(String buildingNum) {
		this.buildingNum = buildingNum;
	}

	public String getBuildingStructureId() {
		return buildingStructureId;
	}

	public void setBuildingStructureId(String buildingStructureId) {
		this.buildingStructureId = buildingStructureId;
	}
}
