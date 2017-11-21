package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 验房工单
 * @author shaozheng
 *	2015-8-3
 */
@XmlRootElement(name = "InspectorOrder")
public class InspectorOrder {
	
	private String orderId;// 验房工单id
	private Integer orderType;// 工单类型
	private Integer orderState; // 工单状态
	private String taskId;// 关联任务id
	private String serviceRequestId;// 关联服务请求id
	private String createPersonId;//创建人id
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date finishTime;// 完成时间
	private Integer inspectorSituation;//验房情况
	private String remarks;// 备注
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date closeTime;//关闭时间
	private String closePerson; //关闭操作人
	private String closeRemarks;//关闭原因
	
	private String changeStateRemarks; //修改状态备注
	
	private Staff staff;// 关联员工表
	private List<InspectorRecord> recordList;//工单结果记录
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

	public String getCreatePersonId() {
		return createPersonId;
	}

	public void setCreatePersonId(String createPersonId) {
		this.createPersonId = createPersonId;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public Integer getInspectorSituation() {
		return inspectorSituation;
	}

	public void setInspectorSituation(Integer inspectorSituation) {
		this.inspectorSituation = inspectorSituation;
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

	public List<InspectorRecord> getRecordList() {
		return recordList;
	}

	public void setRecordList(List<InspectorRecord> recordList) {
		this.recordList = recordList;
	}

	public List<Annex> getAnnexs() {
		return annexs;
	}

	public void setAnnexs(List<Annex> annexs) {
		this.annexs = annexs;
	}
}
