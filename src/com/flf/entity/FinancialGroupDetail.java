package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

//托收明细文件表
@XmlRootElement(name = "FinancialGroupDetail")
public class FinancialGroupDetail {
	
	//托收明细文件id
	private String financialGroupDetailId;
	
	//行别
	private String bankType;
	
	//开户行号
	private String bankNum;
	
	//托收管理id
	private String collectionManegeId;
	
	//账单id
	private String billId;
	
	//扣款标记
	private String deductionsTag;
	
	//托收状态（0未托收1已托收2已回盘）
	private int collectionState;
	
	//生成日期
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthDate;
	
	//托收类型(0托收1回盘)
	private int collectionType;
	
	//项目id
	private String projectId;
	
	//金融联托收总结文件id
	private String financialGroupTotalId;
	
	private String buildingId;//建筑结构ID
	
	private String chargeTypeId;//收费类型ID
	
	private List<FinancialGroupDetail> financialGroupDetails;//用于将excel导入的结果存储到数据库
	
	/*以下属性用于前台显示  start*/
	private String contractNumber;//合同号
	
	private String message;//留言
	
	private String custName;//用户名
	
	private String bankAccount;//银行账号
	
	private double sum;//金额
	
	private Page page;
	
	/*以下属性用于前台显示  end*/
	
	private String houseNum;//资产编号
	
	private String houseAddress;//资产地址
	
	private String batchNumber;//批次号
	
	public String getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}

	public String getChargeTypeId() {
		return chargeTypeId;
	}

	public void setChargeTypeId(String chargeTypeId) {
		this.chargeTypeId = chargeTypeId;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}

	public String getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}

	public String getHouseAddress() {
		return houseAddress;
	}

	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
	}

	public String getContractNumber() {
		return contractNumber;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<FinancialGroupDetail> getFinancialGroupDetails() {
		return financialGroupDetails;
	}

	public void setFinancialGroupDetails(
			List<FinancialGroupDetail> financialGroupDetails) {
		this.financialGroupDetails = financialGroupDetails;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
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

	public String getFinancialGroupDetailId() {
		return financialGroupDetailId;
	}

	public void setFinancialGroupDetailId(String financialGroupDetailId) {
		this.financialGroupDetailId = financialGroupDetailId;
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

	public String getCollectionManegeId() {
		return collectionManegeId;
	}

	public void setCollectionManegeId(String collectionManegeId) {
		this.collectionManegeId = collectionManegeId;
	}

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

	public String getDeductionsTag() {
		return deductionsTag;
	}

	public void setDeductionsTag(String deductionsTag) {
		this.deductionsTag = deductionsTag;
	}

	public int getCollectionState() {
		return collectionState;
	}

	public void setCollectionState(int collectionState) {
		this.collectionState = collectionState;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
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

	public String getFinancialGroupTotalId() {
		return financialGroupTotalId;
	}

	public void setFinancialGroupTotalId(String financialGroupTotalId) {
		this.financialGroupTotalId = financialGroupTotalId;
	}
	
}