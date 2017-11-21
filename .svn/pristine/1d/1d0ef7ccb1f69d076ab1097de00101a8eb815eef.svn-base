package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

@XmlRootElement(name = "AdvancePaymentsDetails") //预收款明细表
public class AdvancePaymentsDetails {
	
	private String advancePaymentsDetailsId;  //预收款明细id
	
	private int isOutIn;   //收支类别(0收入1支出4回盘)
	
	private String assetAccountNum;  //资产账户编号
	
	private String billId;   //计费id
	
	private int paymentType;   //支付类型（0现金1刷卡2微信）
	
	private double transactionAmount;   //交易金额（在押金中为押金金额）
	
	private @DateTimeFormat(pattern="yyyy-MM-dd") Date transactionDate;  //交易时间
	
	private double accountBalance;   //账户余额
	
	private String note;    //说明
	
	private String assetAccountId;//资产账户id
	
	private double refundableDepositAmount;//可退还押金金额
	
	private double refundMoneySum;//退款金额
	
	private String chargeTypeId;//可抵扣项目Id
	
	private String chargeTypeName;//可抵扣项目名称
	
	private String depositNum;//押金编号
	
	private List<Annex> annexs; // 上传附件
	
	private List<ChargeItem> chargeItem;
	
	private List<Bill> bills;
	
	private Page page;

	private String type;//前台传入的判断条件 1：表示现金 2：表示预付款
	
	private String financialStaffId;
	
	private String financialStaffName;
	
	public String getFinancialStaffId() {
		return financialStaffId;
	}

	public void setFinancialStaffId(String financialStaffId) {
		this.financialStaffId = financialStaffId;
	}

	public String getFinancialStaffName() {
		return financialStaffName;
	}

	public void setFinancialStaffName(String financialStaffName) {
		this.financialStaffName = financialStaffName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDepositNum() {
		return depositNum;
	}
	
	public void setDepositNum(String depositNum) {
		this.depositNum = depositNum;
	}
	
	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	public double getRefundableDepositAmount() {
		return refundableDepositAmount;
	}

	public void setRefundableDepositAmount(double refundableDepositAmount) {
		this.refundableDepositAmount = refundableDepositAmount;
	}

	public String getAssetAccountId() {
		return assetAccountId;
	}

	public void setAssetAccountId(String assetAccountId) {
		this.assetAccountId = assetAccountId;
	}

	public String getAdvancePaymentsDetailsId() {
		return advancePaymentsDetailsId;
	}

	public void setAdvancePaymentsDetailsId(String advancePaymentsDetailsId) {
		this.advancePaymentsDetailsId = advancePaymentsDetailsId;
	}

	public int getIsOutIn() {
		return isOutIn;
	}

	public void setIsOutIn(int isOutIn) {
		this.isOutIn = isOutIn;
	}

	public String getAssetAccountNum() {
		return assetAccountNum;
	}

	public void setAssetAccountNum(String assetAccountNum) {
		this.assetAccountNum = assetAccountNum;
	}

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public int getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(int paymentType) {
		this.paymentType = paymentType;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getChargeTypeId() {
		return chargeTypeId;
	}

	public void setChargeTypeId(String chargeTypeId) {
		this.chargeTypeId = chargeTypeId;
	}

	public String getChargeTypeName() {
		return chargeTypeName;
	}

	public void setChargeTypeName(String chargeTypeName) {
		this.chargeTypeName = chargeTypeName;
	}

	public List<ChargeItem> getChargeItem() {
		return chargeItem;
	}

	public void setChargeItem(List<ChargeItem> chargeItem) {
		this.chargeItem = chargeItem;
	}

	public double getRefundMoneySum() {
		return refundMoneySum;
	}

	public void setRefundMoneySum(double refundMoneySum) {
		this.refundMoneySum = refundMoneySum;
	}

	public List<Annex> getAnnexs() {
		return annexs;
	}

	public void setAnnexs(List<Annex> annexs) {
		this.annexs = annexs;
	}

	
}
