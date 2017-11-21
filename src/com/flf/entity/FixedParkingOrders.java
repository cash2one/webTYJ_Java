package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 固定车位工单
 * 创建人：倪明
 * 创建时间：2015/8/13
 * @author Administrator
 *
 */
@XmlRootElement(name = "FixedParkingOrders")
public class FixedParkingOrders {
	
	private String orderId;   //工单id
	
	private Integer orderType;   //工单类型
	
	private Integer orderState;   //工单状态
	
	private String taskId;   //关联任务id
	
	private String serviceRequestId;   //关联服务请求id
	
	private String operatorId;   //创建人id
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date finishTime;   //创建时间
	
	private Integer parkingOperation;   //固定车位取消和开启操作
	
	private String remarks;   //备注
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date closeTime;   //关闭时间
	
	private String closePersonId;   //关闭人id
	
	private String closeRemarks;   //关闭原因
	
	private Staff staff;   //关联员工表
	
	private List<Annex> annexs;   //附件表

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

	public Integer getParkingOperation() {
		return parkingOperation;
	}

	public void setParkingOperation(Integer parkingOperation) {
		this.parkingOperation = parkingOperation;
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
	
}
