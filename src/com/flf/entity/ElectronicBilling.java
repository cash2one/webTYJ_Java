package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

@XmlRootElement(name="ElectronicBilling")
public class ElectronicBilling {

	/*
	 * electronic_billing_id	varchar
		overdue	double
		billing_sum	double
		bill_date	date
		building_id	varchar
		collect_sum	double
		no_collect_sum	double
		current_sum	double
		last_sum	double
		current_owe_sum	double
		last_owe_sum	double

	 * */
	private String electronicBillingId;//电子账单id
	private String electronicBillingNum;//电子账单编号 
	private double overdue;//滯納金
	private double billingSum;//总金额
	private @DateTimeFormat(pattern="yyyy-MM-dd") Date billDate;//账单生成时间
	private String buildingId;//建筑结构id
	private String fullName;//**建筑地址 即收费对象（用于查询，该实体类对应数据表中无）
	private double collectSum;//已交金额
	private double noCollectSum;//未交金额
	private double currentSum;//本期金额
	private double lastSum;//上期金额
	private double currentOweSum;//本期欠款金额
	private double lastOweSum;//上期欠款金额
	private double lastOverdue;//上期滞纳金
	private double currentOverdue;//本期滞纳金
	private String assetAccountId;//电子账单id
	private List<Bill> bills;//账单
	public List<Bill> getBills() {
		return bills;
	}
	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}
	public double getLastOverdue() {
		return lastOverdue;
	}
	public void setLastOverdue(double lastOverdue) {
		this.lastOverdue = lastOverdue;
	}
	public double getCurrentOverdue() {
		return currentOverdue;
	}
	public void setCurrentOverdue(double currentOverdue) {
		this.currentOverdue = currentOverdue;
	}
	private String custId;//**客户id，用于查询
	
	private String custName;//客户姓名（查询）
	private String cardNum;//客户身份证号（查询）
	
	private Page page;

	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getElectronicBillingNum() {
		return electronicBillingNum;
	}
	public void setElectronicBillingNum(String electronicBillingNum) {
		this.electronicBillingNum = electronicBillingNum;
	}
	public String getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = custId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getElectronicBillingId() {
		return electronicBillingId;
	}
	public void setElectronicBillingId(String electronicBillingId) {
		this.electronicBillingId = electronicBillingId;
	}
	public double getOverdue() {
		return overdue;
	}
	public void setOverdue(double overdue) {
		this.overdue = overdue;
	}
	public double getBillingSum() {
		return billingSum;
	}
	public void setBillingSum(double billingSum) {
		this.billingSum = billingSum;
	}
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	public String getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}
	public double getCollectSum() {
		return collectSum;
	}
	public void setCollectSum(double collectSum) {
		this.collectSum = collectSum;
	}
	public double getNoCollectSum() {
		return noCollectSum;
	}
	public void setNoCollectSum(double noCollectSum) {
		this.noCollectSum = noCollectSum;
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
	public double getCurrentOweSum() {
		return currentOweSum;
	}
	public void setCurrentOweSum(double currentOweSum) {
		this.currentOweSum = currentOweSum;
	}
	public double getLastOweSum() {
		return lastOweSum;
	}
	public void setLastOweSum(double lastOweSum) {
		this.lastOweSum = lastOweSum;
	}
	public String getAssetAccountId() {
		return assetAccountId;
	}
	public void setAssetAccountId(String assetAccountId) {
		this.assetAccountId = assetAccountId;
	}
	
}
