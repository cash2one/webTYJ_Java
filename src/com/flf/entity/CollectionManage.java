package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

//托收管理
@XmlRootElement(name = "CollectionManage")
public class CollectionManage {
	
	//托收id
	private String collectionManageId;
	
	//客户id
	private String custId;
	
	//客户姓名
	private String custName;
	
	//银行行别
	private String bankName;
	
	//金融联银行行别信息
	private FinancialBankNum financialBankNum; 
	
	//银行账户
	private String bankAccount;
	
	//启用时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date startTime;
	
	//结束时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date endTime;
	
	//省
	private String province;
	
	//市
	private String city;
	
	//托收类型(0银联托收1金融联托收)
	private int collectionType;
	
	//留言
	private String message;
	
	//账号类型(0银行卡号1存折号)
	private int accountType;
	
	private String contractNumber;  //合同号
	
	private String id;  //建筑结构id
	
	private String fullName;  //房屋全名
	
	private List<Annex> annexs;   //上传文件
	
	private Page page;  //分页
	
	private List<String> ids;  //房屋id集合
	
	private PersonCustNew person;//办理客户对象
	
	private BuildingStructureNew buildingStructure;//建筑结构信息
	
	private String collectionState;//使用状态(0-启用 1-停用 2-暂停)
	
	private String createTime;//创建时间
	
	private PaymentDetails paymentDetails;//收支明细
	
	public PaymentDetails getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(PaymentDetails paymentDetails) {
		this.paymentDetails = paymentDetails;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public FinancialBankNum getFinancialBankNum() {
		return financialBankNum;
	}

	public void setFinancialBankNum(FinancialBankNum financialBankNum) {
		this.financialBankNum = financialBankNum;
	}

	public String getCollectionState() {
		return collectionState;
	}

	public void setCollectionState(String collectionState) {
		this.collectionState = collectionState;
	}

	public PersonCustNew getPerson() {
		return person;
	}

	public void setPerson(PersonCustNew person) {
		this.person = person;
	}

	public BuildingStructureNew getBuildingStructure() {
		return buildingStructure;
	}

	public void setBuildingStructure(BuildingStructureNew buildingStructure) {
		this.buildingStructure = buildingStructure;
	}

	public String getCollectionManageId() {
		return collectionManageId;
	}

	public void setCollectionManageId(String collectionManageId) {
		this.collectionManageId = collectionManageId;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getCollectionType() {
		return collectionType;
	}

	public void setCollectionType(int collectionType) {
		this.collectionType = collectionType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getAccountType() {
		return accountType;
	}

	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Annex> getAnnexs() {
		return annexs;
	}

	public void setAnnexs(List<Annex> annexs) {
		this.annexs = annexs;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}
	
}