package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

@XmlRootElement(name = "AccountRecord")//(交账记录表) 
public class AccountRecord {
	
	private String accountRecordId;//交账记录id	
	private int accountTotalNum;//交账笔数
	private double cashSum;//现金金额
	private double creditCardSum;//刷卡金额
	private double wechatSum;//微信金额
	private double refundSum;//退款金额
    private @DateTimeFormat(pattern="yyyy-MM-dd") Date accountTime;//交账时间
	private String accountState;//收账账状态（0待确认  1已完成  2已退回   这三个是交账中的状态;0待确认  1或2 已确认 这两个是交账列表的状态;2已退回，0待确认为未交帐;3已交账 的权限属于组长）
	private	double totalSum;//总金额
	private String financialStaffId;//交账人id
	private String financialStaffName;//财务人员名称	
    private String staffId;//收账人id
    private String staffName;//收账人姓名
	private String batchNum ;//批次
	private byte accountType;//交账类型（0现金交账 1结算）
	private String parentId;//父级id
	private String backState;//判断退回的人员（0本人退回，1上级退回）
	private String backPerosn;// 判断退回人员(0.收银员 1.收银组长 2.出纳 )
	private String postId;//岗位id
	private String nameOfCustom;//职位名（传参用）
	private String projectId;//项目id
	
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getNameOfCustom() {
		return nameOfCustom;
	}
	public void setNameOfCustom(String nameOfCustom) {
		this.nameOfCustom = nameOfCustom;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public String getBackPerosn() {
		return backPerosn;
	}
	public void setBackPerosn(String backPerosn) {
		this.backPerosn = backPerosn;
	}
	public String getBackState() {
		return backState;
	}
	public void setBackState(String backState) {
		this.backState = backState;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	private List<AccountRecord> accountRecordList;//交账记录列表
	
	public List<AccountRecord> getAccountRecordList() {
		return accountRecordList;
	}
	public void setAccountRecordList(List<AccountRecord> accountRecordList) {
		this.accountRecordList = accountRecordList;
	}
	public byte getAccountType() {
		return accountType;
	}
	public void setAccountType(byte accountType) {
		this.accountType = accountType;
	}
	public String getAccountState() {
			return accountState;
		}
	public void setAccountState(String accountState) {
		this.accountState = accountState;
	}
	public double getCreditCardSum() {
		return creditCardSum;
	}
	public void setCreditCardSum(double creditCardSum) {
		this.creditCardSum = creditCardSum;
	}
	

	public String getBatchNum() {
		return batchNum;
	}
	public void setBatchNum(String batchNum) {
		this.batchNum = batchNum;
	}
	private List<BankDeposit> bList;////银行存单列表
	
	public List<BankDeposit> getbList() {
		return bList;
	}
	public void setbList(List<BankDeposit> bList) {
		this.bList = bList;
	}
   
	public String getFinancialStaffName() {
		return financialStaffName;
	}
	public void setFinancialStaffName(String financialStaffName) {
		this.financialStaffName = financialStaffName;
	}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	private Page page;
		public String getAccountRecordId() {
		return accountRecordId;
	}
	public void setAccountRecordId(String accountRecordId) {
		this.accountRecordId = accountRecordId;
	}
	public int getAccountTotalNum() {
		return accountTotalNum;
	}
	public void setAccountTotalNum(int accountTotalNum) {
		this.accountTotalNum = accountTotalNum;
	}
	public double getCashSum() {
		return cashSum;
	}
	public void setCashSum(double cashSum) {
		this.cashSum = cashSum;
	}

	public double getWechatSum() {
		return wechatSum;
	}
	public void setWechatSum(double wechatSum) {
		this.wechatSum = wechatSum;
	}
	public double getRefundSum() {
		return refundSum;
	}
	public void setRefundSum(double refundSum) {
		this.refundSum = refundSum;
	}
	public String getFinancialStaffId() {
		return financialStaffId;
	}
	public void setFinancialStaffId(String financialStaffId) {
		this.financialStaffId = financialStaffId;
	}
	public Date getAccountTime() {
		return accountTime;
	}
	public void setAccountTime(Date accountTime) {
		this.accountTime = accountTime;
	}

	public double getTotalSum() {
		return totalSum;
	}
	public void setTotalSum(double totalSum) {
		this.totalSum = totalSum;
	}

}
