package com.flf.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 咨询工单表
 * 创建人：倪明
 * 创建时间：2015/8/12
 */
@XmlRootElement(name = "ConsultationOrders")
public class ConsultationOrders {
	
	private String orderId;  //咨询工单id
	
	private Integer orderType;   //工单类型
	
	private Integer orderState;   //工单状态
	
	private String taskId;   //关联任务id
	
	private String serviceRequestId;   //关联服务请求id
	
	private String operatorId;   //创建人id
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date finishTime;   //创建时间
	
	private Integer problemType;   //客户问题类型
	
	private Integer problemProfessional;   //客户问题专业
	
	private String problemRemarks;   //客户问题描述
	
	private String remarks;   //查询说明
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date closeTime;   //关闭时间
	
	private String closePersonId;   //关闭人id
	
	private String closeRemarks;   //关闭原因
	
	private Staff staff;   //关联员工表
	
	private String orderNum;	//工单编号
	
	private String faqQuestionId;	//引用FAQid
	
	private Faqs faqs;	//关联faqs实体
	
	private String personId;//客户Id

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

	public Integer getProblemType() {
		return problemType;
	}

	public void setProblemType(Integer problemType) {
		this.problemType = problemType;
	}

	public Integer getProblemProfessional() {
		return problemProfessional;
	}

	public void setProblemProfessional(Integer problemProfessional) {
		this.problemProfessional = problemProfessional;
	}

	public String getProblemRemarks() {
		return problemRemarks;
	}

	public void setProblemRemarks(String problemRemarks) {
		this.problemRemarks = problemRemarks;
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

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getFaqQuestionId() {
		return faqQuestionId;
	}

	public void setFaqQuestionId(String faqQuestionId) {
		this.faqQuestionId = faqQuestionId;
	}

	public Faqs getFaqs() {
		return faqs;
	}

	public void setFaqs(Faqs faqs) {
		this.faqs = faqs;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

}
