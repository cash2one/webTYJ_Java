package com.flf.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

@XmlRootElement(name="ApplicationDelayRecords")
public class ApplicationDelayRecords {

	/**
	 * 记录id	record_id	字符串	50	必填	主键
		 关联任务id	task_id	字符串	50	必填	
		操作人id	operator_id	字符串	50	可选	
		 操作时间	operation_time	Datetime	50	必填	
		 延长到具体时间	delay_time	Datetime		必填	
		 备注	remarks	字符串	300	必填	

	 */
	private String recordId;
	private String taskId;
	private String operatorId;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date operationTime;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date delayTime;
	private String remarks;
	
	private Staff staff;
	private Page page;
	
	public Page getPage() {
		if(this.page==null){
			this.page=new Page();
		}
		return page;
	}
	
	public void setPage(Page page) {
		this.page = page;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
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
	public Date getOperationTime() {
		return operationTime;
	}
	public void setOperationTime(Date operationTime) {
		this.operationTime = operationTime;
	}
	public Date getDelayTime() {
		return delayTime;
	}
	public void setDelayTime(Date delayTime) {
		this.delayTime = delayTime;
	}
}
