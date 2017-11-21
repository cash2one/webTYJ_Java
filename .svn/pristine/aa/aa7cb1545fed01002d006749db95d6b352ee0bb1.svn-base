package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

//托收总结文件表
@XmlRootElement(name = "FinancialGroupTotal")
public class FinancialGroupTotal {
	
	//托收总结文件id
	private String financialGroupTotalId;
	
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
	
	//总户数
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
	
	//托收状态（0未托收1已托收2已回盘）
	private int collectionState;
	
	//托收类型（0托收1回盘）
	private int collectionType;
	
	//项目id
	private String projectId;
	
	//批次号
	private String batchNumber;
	
	private String projectName;//**项目名称
	//excel导出时间处理
	private String preDateString;
	private String bankDateString;
	private String deduDateString;
	
	private List<FinancialGroupTotal> financialGroupTotals;//用于将回盘文件数据存入数据库
	private List<FinancialGroupDetail> financialGroupDetails;//用于将明细文件
	
	private String fileNames;
	
	private String createTime;//创建时间

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	public String getFileNames() {
		return fileNames;
	}

	public void setFileNames(String fileNames) {
		this.fileNames = fileNames;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public String getPreDateString() {
		return preDateString;
	}

	public void setPreDateString(String preDateString) {
		this.preDateString = preDateString;
	}

	public String getBankDateString() {
		return bankDateString;
	}

	public void setBankDateString(String bankDateString) {
		this.bankDateString = bankDateString;
	}

	public String getDeduDateString() {
		return deduDateString;
	}

	public void setDeduDateString(String deduDateString) {
		this.deduDateString = deduDateString;
	}

	public List<FinancialGroupDetail> getFinancialGroupDetails() {
		return financialGroupDetails;
	}

	public void setFinancialGroupDetails(List<FinancialGroupDetail> financialGroupDetails) {
		this.financialGroupDetails = financialGroupDetails;
	}

	public List<FinancialGroupTotal> getFinancialGroupTotals() {
		return financialGroupTotals;
	}

	public void setFinancialGroupTotals(
			List<FinancialGroupTotal> financialGroupTotals) {
		this.financialGroupTotals = financialGroupTotals;
	}

	private Page page;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getFinancialGroupTotalId() {
		return financialGroupTotalId;
	}

	public void setFinancialGroupTotalId(String financialGroupTotalId) {
		this.financialGroupTotalId = financialGroupTotalId;
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

	public int getCollectionState() {
		return collectionState;
	}

	public void setCollectionState(int collectionState) {
		this.collectionState = collectionState;
	}

	public int getCollectionType() {
		return collectionType;
	}

	public void setCollectionType(int collectionType) {
		this.collectionType = collectionType;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}