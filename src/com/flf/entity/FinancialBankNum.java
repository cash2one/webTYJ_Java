package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 金融联银行行别表
 * @author maogaofei
 * @date 2016年6月13日 下午5:25:27
 */
@XmlRootElement(name = "FinancialBankNum")
public class FinancialBankNum {
	
	private String financialBankNumId;//主键ID
	
	private String bankNum;//行别
	
	private String unionpayBankNum;//银联银行行号
	
	private String bankName;//银行名称
	
	private String bankNameSeq;//银行名称前三个汉字首字母缩写
	
	private Page page;
	
	public String getUnionpayBankNum() {
		return unionpayBankNum;
	}

	public void setUnionpayBankNum(String unionpayBankNum) {
		this.unionpayBankNum = unionpayBankNum;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getFinancialBankNumId() {
		return financialBankNumId;
	}

	public void setFinancialBankNumId(String financialBankNumId) {
		this.financialBankNumId = financialBankNumId;
	}

	public String getBankNum() {
		return bankNum;
	}

	public void setBankNum(String bankNum) {
		this.bankNum = bankNum;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankNameSeq() {
		return bankNameSeq;
	}

	public void setBankNameSeq(String bankNameSeq) {
		this.bankNameSeq = bankNameSeq;
	}
	
}
