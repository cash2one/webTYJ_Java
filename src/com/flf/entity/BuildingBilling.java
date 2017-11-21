package com.flf.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

@XmlRootElement(name = "BuildingBilling") 

public class BuildingBilling {
	
	private String buildingBillingId;//建筑收费项目计费id
 
	private @DateTimeFormat(pattern="yyyy-MM-dd ") Date billingStartTime;//计费开始时间
	private double currentSum;//本期金额
	private double lastSum;//上期金额
	private @DateTimeFormat(pattern="yyyy-MM-dd ") Date billingEndTime;//计费结束时间
	private double billingBalance;//计费金额
	private String chargeItemName;//收费项目名称
	private int billingState;//计费状态（0已完成1已取消）
	private String chargeItemBillingId;//收费项目计费id
	private String buildingId;//建筑结构id
	private String chargeItemId;//收费项目id
	
	private String fullName;//房屋全名
	
	private Page page;
	
	public Date getBillingStartTime() {
		return billingStartTime;
	}
	public void setBillingStartTime(Date billingStartTime) {
		this.billingStartTime = billingStartTime;
	}
	public Date getBillingEndTime() {
		return billingEndTime;
	}
	public void setBillingEndTime(Date billingEndTime) {
		this.billingEndTime = billingEndTime;
	}	
	  
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullNanme(String fullName) {
		this.fullName = fullName;
	}
	public void setChargeItemBillingId(String chargeItemBillingId) {
		this.chargeItemBillingId = chargeItemBillingId;
	}
	public String getBuildingBillingId() {
		return buildingBillingId;
	}
	public void setBuildingBillingId(String buildingBillingId) {
		this.buildingBillingId = buildingBillingId;
	}

	public double getCurrentSum() {
		return currentSum;
	}
	public void setCurrentSum(double currentSum) {
		this.currentSum = currentSum;
	}
	public double getLastSum() {
		return lastSum;
	}
	public void setLastSum(double lastSum) {
		this.lastSum = lastSum;
	}

	public double getBillingBalance() {
		return billingBalance;
	}
	public void setBillingBalance(double billingBalance) {
		this.billingBalance = billingBalance;
	}
	public String getChargeItemName() {
		return chargeItemName;
	}
	public void setChargeItemName(String chargeItemName) {
		this.chargeItemName = chargeItemName;
	}
	public int getBillingState() {
		return billingState;
	}
	public void setBillingState(int billingState) {
		this.billingState = billingState;
	}
	public String getChargeItemBillingId() {
		return chargeItemBillingId;
	}
	public void setChargeItemBilling(String chargeItemBillingId) {
		this.chargeItemBillingId = chargeItemBillingId;
	}
	public String getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}
	public String getChargeItemId() {
		return chargeItemId;
	}
	public void setChargeItemId(String chargeItemId) {
		this.chargeItemId = chargeItemId;
	}
	
}
