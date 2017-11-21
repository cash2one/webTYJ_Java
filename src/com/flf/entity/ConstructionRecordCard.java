package com.flf.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 施工备案证 
 * @author taoyongchao
 * 2015-8-19
 */
@XmlRootElement(name="ConstructionRecordCard")
public class ConstructionRecordCard {
	
	
	private String recordId; //记录Id
	private String applyId; //关联装修申请Id
	private String propertyId;//物业公司id
	private String propertyName;//物业公司名称
	private String cardId;//证件号
	private String custId;//业主id
	private String addressId;//装修地址id
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date constructionStarTime;//施工开工时间
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date constructionFinishTime;//施工结束时间
	private String decorateId;//装修单位id
	private String headId;//现场负责人id
	private String fireApproval;//消防批文号
	private String decorateProject;//装修项目
	private String angentId;  //签发人id
	private String constructionScope; //施工范围  1.装修施工  2.装饰施工 3.临时施工
	private String registrationTime;//办证时间
	private Date dailyStarTime;//每日施工开始时间
	private Date dailyFinishTime;//每日施工结束时间
	private Staff staff;
	
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
	public String getApplyId() {
		return applyId;
	}
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}
	public String getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(String propertyId) {
		this.propertyId = propertyId;
	}

	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}
	
	public Date getConstructionStarTime() {
		return constructionStarTime;
	}
	public void setConstructionStarTime(Date constructionStarTime) {
		this.constructionStarTime = constructionStarTime;
	}
	public Date getConstructionFinishTime() {
		return constructionFinishTime;
	}
	public void setConstructionFinishTime(Date constructionFinishTime) {
		this.constructionFinishTime = constructionFinishTime;
	}

	public String getRegistrationTime() {
		return registrationTime;
	}
	public void setRegistrationTime(String registrationTime) {
		this.registrationTime = registrationTime;
	}
	public void setDailyStarTime(Date dailyStarTime) {
		this.dailyStarTime = dailyStarTime;
	}
	public void setDailyFinishTime(Date dailyFinishTime) {
		this.dailyFinishTime = dailyFinishTime;
	}
	public String getDecorateId() {
		return decorateId;
	}
	public void setDecorateId(String decorateId) {
		this.decorateId = decorateId;
	}
	public String getHeadId() {
		return headId;
	}
	public void setHeadId(String headId) {
		this.headId = headId;
	}
	public String getFireApproval() {
		return fireApproval;
	}
	public void setFireApproval(String fireApproval) {
		this.fireApproval = fireApproval;
	}
	public String getDecorateProject() {
		return decorateProject;
	}
	public void setDecorateProject(String decorateProject) {
		this.decorateProject = decorateProject;
	}
	public String getAngentId() {
		return angentId;
	}
	public void setAngentId(String angentId) {
		this.angentId = angentId;
	}
	public String getConstructionScope() {
		return constructionScope;
	}
	public void setConstructionScope(String constructionScope) {
		this.constructionScope = constructionScope;
	}
	
	public Date getDailyStarTime() {
		return dailyStarTime;
	}
	public Date getDailyFinishTime() {
		return dailyFinishTime;
	}
	
	
	

}
