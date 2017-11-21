package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 施工验收单
 * @author shaozheng
 *	2015-9-1
 */
@XmlRootElement(name="ConstructionAcceptanceOrders")
public class ConstructionAcceptanceOrders {
	
	private String orderId;   //工单id
	private Integer orderType;   //工单类型
	private Integer orderState;   //工单状态
	private String taskId;   //关联任务id
	private String serviceRequestId;   //关联服务请求id
	private String operatorId;   //创建人id
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date finishTime;   //创建时间
	private Integer inspectionNormal;//是否正常
	private String remarks;   //描述
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date closeTime;   //关闭时间
	private String closePersonId;   //关闭人id
	private String closeRemarks;   //关闭原因
	
	private Staff staff;
	private List<Annex> annexs;
	private List<ConstructionAcceptanceRecords> constructionAcceptanceRecords;
	private List<LetterRecords> letterRecords;
	
	public List<LetterRecords> getLetterRecords() {
		return letterRecords;
	}
	public void setLetterRecords(List<LetterRecords> letterRecords) {
		this.letterRecords = letterRecords;
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
	public Date getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}
	public Integer getInspectionNormal() {
		return inspectionNormal;
	}
	public void setInspectionNormal(Integer inspectionNormal) {
		this.inspectionNormal = inspectionNormal;
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
	public List<ConstructionAcceptanceRecords> getConstructionAcceptanceRecords() {
		return constructionAcceptanceRecords;
	}
	public void setConstructionAcceptanceRecords(
			List<ConstructionAcceptanceRecords> constructionAcceptanceRecords) {
		this.constructionAcceptanceRecords = constructionAcceptanceRecords;
	}
}
