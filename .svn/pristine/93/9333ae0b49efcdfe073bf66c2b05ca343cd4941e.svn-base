package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 装修巡检单
 * @author 倪明
 * 2015/08/18
 */
@XmlRootElement(name = "RenovationInspectionOrders")
public class RenovationInspectionOrders {
	private String orderId;   //装修巡检工单id
	private Integer orderType;   //工单类型
	private Integer orderState;   //工单状态
	private String taskId;   //关联任务id
	private String serviceRequestId;   //关联服务请求id
	private String operatorId;   //创建人id
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date finishTime;   //创建时间
	private Integer normal;   //是否正常
	private String remarks;   //描述
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date closeTime;   //关闭时间
	private String closePersonId;   //关闭人id
	private String closeRemarks;   //关闭原因
	private double wallArea;   //拆墙面积
	
	private Staff staff;   //员工
	private List<Annex> annexs;   //附件
	private List<RenovationInspectionRecords> renovationInspectionRecords;
	private List<LetterRecords> letterRecords;
	
	public List<LetterRecords> getLetterRecords() {
		return letterRecords;
	}
	public void setLetterRecords(List<LetterRecords> letterRecords) {
		this.letterRecords = letterRecords;
	}
	public double getWallArea() {
		return wallArea;
	}
	public void setWallArea(double wallArea) {
		this.wallArea = wallArea;
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
	public Integer getNormal() {
		return normal;
	}
	public void setNormal(Integer normal) {
		this.normal = normal;
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
	public List<RenovationInspectionRecords> getRenovationInspectionRecords() {
		return renovationInspectionRecords;
	}
	public void setRenovationInspectionRecords(
			List<RenovationInspectionRecords> renovationInspectionRecords) {
		this.renovationInspectionRecords = renovationInspectionRecords;
	}
}
