package com.flf.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

//金融联回盘明细文件表
@XmlRootElement(name = "FinancialCounterofferDetail")
public class FinancialCounterofferDetail {
	
	//托收明细文件id
	private String financialCounterofferDetailId;
	
	private String contractNumber;//合同号
	
	//行别
	private String bankType;
	
	//开户行号
	private String bankNum;
	
	private String bankAccount;//银行账号
	
	private double sum;//金额
	
	//扣款标记
	private String deductionsTag;
	
	//回盘总结文件id
	private String financialCounterofferTotalId;
	
	private String custName;//用户名
	
	private String message;//留言
	
	//批次号
	private String batchNumber;
	
	//回盘导入状态(0-未回盘，1-已回盘)
	private String offerState;
	
	public String getOfferState() {
		return offerState;
	}

	public void setOfferState(String offerState) {
		this.offerState = offerState;
	}

	private List<FinancialCounterofferDetail> financialCounterofferDetails;
	
	private Page page;
	
	public List<FinancialCounterofferDetail> getFinancialCounterofferDetails() {
		return financialCounterofferDetails;
	}

	public void setFinancialCounterofferDetails(
			List<FinancialCounterofferDetail> financialCounterofferDetails) {
		this.financialCounterofferDetails = financialCounterofferDetails;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public String getFinancialCounterofferDetailId() {
		return financialCounterofferDetailId;
	}

	public void setFinancialCounterofferDetailId(
			String financialCounterofferDetailId) {
		this.financialCounterofferDetailId = financialCounterofferDetailId;
	}

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	public String getBankType() {
		return bankType;
	}

	public void setBankType(String bankType) {
		this.bankType = bankType;
	}

	public String getBankNum() {
		return bankNum;
	}

	public void setBankNum(String bankNum) {
		this.bankNum = bankNum;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public String getDeductionsTag() {
		return deductionsTag;
	}

	public void setDeductionsTag(String deductionsTag) {
		this.deductionsTag = deductionsTag;
	}

	public String getFinancialCounterofferTotalId() {
		return financialCounterofferTotalId;
	}

	public void setFinancialCounterofferTotalId(String financialCounterofferTotalId) {
		this.financialCounterofferTotalId = financialCounterofferTotalId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}
	
}