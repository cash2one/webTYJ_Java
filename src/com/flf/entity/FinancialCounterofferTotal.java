package com.flf.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

//金融联回盘总结文件表
@XmlRootElement(name = "FinancialCounterofferTotal")
public class FinancialCounterofferTotal {
	
	//回盘总结文件id
	private String financialCounterofferTotalId;
	
	//代办银行号
	private String agencyBankNum;
	
	//收付单位代码
	private String paymentUnitCode;
	
	//币种(0人民币1港币)
	private int coinType;
	
	//收付标志(1收0付)
	private int paymentState;
	
	//收付代码
	private String collectionTotalNum;
	
	//交易文件名称
	private String collectionTotalName;
	
	//户数
	private int houseNumber;
	
	//总金额
	private double sum;
	
	//已划款户数
	private int deductionsHouseNumber;
	
	//已划款金额
	private double deductionsSum;
	
	//送银行日期
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date tobankDate;

	//应划款日期
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date prepareDeductionsDate;
	
	//划款日期
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date deductionsDate;
	
	//批次号
	private String batchNumber;
	
	//回盘导入状态(0-未回盘，1-已回盘)
	private String offerState;
	
	private List<FinancialCounterofferTotal> financialCounterofferTotals;
	
	private Page page;//分页
	
	private String createTime;//创建时间
	
	private String projectId;//项目id
	
	private int proposeNum;//提出笔数
	
	private BigDecimal proposeAmount;//提出金额
	
	private int successNum;//成功笔数
	
	private BigDecimal successAmount;//成功金额
	
	private int failNum;//失败笔数
	
	private BigDecimal failAmount;//失败金额

	public int getProposeNum() {
		return proposeNum;
	}

	public void setProposeNum(int proposeNum) {
		this.proposeNum = proposeNum;
	}

	public BigDecimal getProposeAmount() {
		return proposeAmount;
	}

	public void setProposeAmount(BigDecimal proposeAmount) {
		this.proposeAmount = proposeAmount;
	}

	public int getSuccessNum() {
		return successNum;
	}

	public void setSuccessNum(int successNum) {
		this.successNum = successNum;
	}

	public BigDecimal getSuccessAmount() {
		return successAmount;
	}

	public void setSuccessAmount(BigDecimal successAmount) {
		this.successAmount = successAmount;
	}

	public int getFailNum() {
		return failNum;
	}

	public void setFailNum(int failNum) {
		this.failNum = failNum;
	}

	public BigDecimal getFailAmount() {
		return failAmount;
	}

	public void setFailAmount(BigDecimal failAmount) {
		this.failAmount = failAmount;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getOfferState() {
		return offerState;
	}

	public void setOfferState(String offerState) {
		this.offerState = offerState;
	}

	public List<FinancialCounterofferTotal> getFinancialCounterofferTotals() {
		return financialCounterofferTotals;
	}

	public void setFinancialCounterofferTotals(
			List<FinancialCounterofferTotal> financialCounterofferTotals) {
		this.financialCounterofferTotals = financialCounterofferTotals;
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

	public String getFinancialCounterofferTotalId() {
		return financialCounterofferTotalId;
	}

	public void setFinancialCounterofferTotalId(String financialCounterofferTotalId) {
		this.financialCounterofferTotalId = financialCounterofferTotalId;
	}

	public String getAgencyBankNum() {
		return agencyBankNum;
	}

	public void setAgencyBankNum(String agencyBankNum) {
		this.agencyBankNum = agencyBankNum;
	}

	public String getPaymentUnitCode() {
		return paymentUnitCode;
	}

	public void setPaymentUnitCode(String paymentUnitCode) {
		this.paymentUnitCode = paymentUnitCode;
	}

	public int getCoinType() {
		return coinType;
	}

	public void setCoinType(int coinType) {
		this.coinType = coinType;
	}

	public int getPaymentState() {
		return paymentState;
	}

	public void setPaymentState(int paymentState) {
		this.paymentState = paymentState;
	}

	public String getCollectionTotalNum() {
		return collectionTotalNum;
	}

	public void setCollectionTotalNum(String collectionTotalNum) {
		this.collectionTotalNum = collectionTotalNum;
	}

	public String getCollectionTotalName() {
		return collectionTotalName;
	}

	public void setCollectionTotalName(String collectionTotalName) {
		this.collectionTotalName = collectionTotalName;
	}

	public int getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public int getDeductionsHouseNumber() {
		return deductionsHouseNumber;
	}

	public void setDeductionsHouseNumber(int deductionsHouseNumber) {
		this.deductionsHouseNumber = deductionsHouseNumber;
	}

	public double getDeductionsSum() {
		return deductionsSum;
	}

	public void setDeductionsSum(double deductionsSum) {
		this.deductionsSum = deductionsSum;
	}

	public Date getTobankDate() {
		return tobankDate;
	}

	public void setTobankDate(Date tobankDate) {
		this.tobankDate = tobankDate;
	}

	public Date getPrepareDeductionsDate() {
		return prepareDeductionsDate;
	}

	public void setPrepareDeductionsDate(Date prepareDeductionsDate) {
		this.prepareDeductionsDate = prepareDeductionsDate;
	}

	public Date getDeductionsDate() {
		return deductionsDate;
	}

	public void setDeductionsDate(Date deductionsDate) {
		this.deductionsDate = deductionsDate;
	}
}