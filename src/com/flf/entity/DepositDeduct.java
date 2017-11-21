package com.flf.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;
@XmlRootElement(name="DepositDeduct")
public class DepositDeduct {

	//押金扣款项
	private String depositDeductId;//押金扣款项id
	private @DateTimeFormat(pattern="yyyy-MM-dd") Date deductionsDate;//扣款日期
	private String deductionsName;//扣款项名称
	private double deductionsSum;//扣款金额
	private String billId;//应收款id
	
	public String getDepositDeductId() {
		return depositDeductId;
	}
	public void setDepositDeductId(String depositDeductId) {
		this.depositDeductId = depositDeductId;
	}
	public Date getDeductionsDate() {
		return deductionsDate;
	}
	public void setDeductionsDate(Date deductionsDate) {
		this.deductionsDate = deductionsDate;
	}
	public String getDeductionsName() {
		return deductionsName;
	}
	public void setDeductionsName(String deductionsName) {
		this.deductionsName = deductionsName;
	}
	public double getDeductionsSum() {
		return deductionsSum;
	}
	public void setDeductionsSum(double deductionsSum) {
		this.deductionsSum = deductionsSum;
	}
	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
	
	
}
