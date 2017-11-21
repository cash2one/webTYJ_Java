package com.flf.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

@XmlRootElement(name = "PaymentRecords")// (收款记录表)
public class PaymentRecords {
		private String paymentRecordsId;	//收款记录id		
		private @DateTimeFormat(pattern="yyyy-MM-dd") Date paymentDate;//收款日期
		private double cashSum;	//现金金额
		private double creditCardSum	;//刷卡金额
		private double wechatSum;	//微信金额
		private double totalSum;	//总金额
		private String financialStaffId;//财务人员id
		private double refundSum;//退款金额
		private double noHandedSum;	//未上交金额
		private double handedSum;//已上交金额
		private Page page;
		
		public Page getPage() {
			return page;
		}
		public void setPage(Page page) {
			this.page = page;
		}
		public String getPaymentRecordsId() {
			return paymentRecordsId;
		}
		public void setPaymentRecordsId(String paymentRecordsId) {
			this.paymentRecordsId = paymentRecordsId;
		}
		public Date getPaymentDate() {
			return paymentDate;
		}
		public void setPaymentDate(Date paymentDate) {
			this.paymentDate = paymentDate;
		}
		public double getCashSum() {
			return cashSum;
		}
		public void setCashSum(double cashSum) {
			this.cashSum = cashSum;
		}
		public double getCreditCardSum() {
			return creditCardSum;
		}
		public void setCreditCardSum(double creditCardSum) {
			this.creditCardSum = creditCardSum;
		}
		public double getWechatSum() {
			return wechatSum;
		}
		public void setWechatSum(double wechatSum) {
			this.wechatSum = wechatSum;
		}
		public double getTotalSum() {
			return totalSum;
		}
		public void setTotalSum(double totalSum) {
			this.totalSum = totalSum;
		}
		public String getFinancialStaffId() {
			return financialStaffId;
		}
		public void setFinancialStaffId(String financialStaffId) {
			this.financialStaffId = financialStaffId;
		}
		public double getRefundSum() {
			return refundSum;
		}
		public void setRefundSum(double refundSum) {
			this.refundSum = refundSum;
		}
		public double getNoHandedSum() {
			return noHandedSum;
		}
		public void setNoHandedSum(double noHandedSum) {
			this.noHandedSum = noHandedSum;
		}
		public double getHandedSum() {
			return handedSum;
		}
		public void setHandedSum(double handedSum) {
			this.handedSum = handedSum;
		}
		
}
