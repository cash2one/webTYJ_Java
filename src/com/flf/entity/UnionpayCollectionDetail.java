package com.flf.entity;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 银联托收明细文件
 * 
 * @author 倪明 创建时间：2015/9/22
 * 
 */
@XmlRootElement(name = "UnionpayCollectionDetail")
public class UnionpayCollectionDetail {
	private String unionpayCollectionDetaiId; // 主键id

	private String unionpayCollectionTotallId;// 银联托收总结文件

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date merchantsDate; // 商户日期

	private String custNum; // 客户号

	private String bankAccount; // 银行账号

	private Integer accountType; // 账号类型(0银行卡1存折)

	private Long sum; // 金额

	private String privateDomain; // 私有域

	private String projectId; // 项目id

	private String unionpayCounterofferDetaiId; // 银联回盘明细文件id

	private UnionpayCollectionTotall unionpayCollectionTotall;// 节点文件

	private String billId;// 应收款id

	private String custName;// 户主名字

	private Integer collectionState;// 托收状态（0未托收1已托收）
	
	private String orderNum;	//订单号
	
	private String bankNum;	//开户行号
	
	private String cardIDType;	//证件类型
	
	private String cardIDNum;	//证件号码
	
	private String purpose;	//用途
	
	private String houseNum;//房屋编号
	
	private String houseAddress;//房屋地址
	
	private String buildingId;//建筑结构ID
	
	private String chargeTypeId;//收费类型ID	
	
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

	private Page page;

	private String merchDateToString;//excel导出时间处理，别名
	
	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getBankNum() {
		return bankNum;
	}

	public void setBankNum(String bankNum) {
		this.bankNum = bankNum;
	}

	public String getCardIDType() {
		return cardIDType;
	}

	public void setCardIDType(String cardIDType) {
		this.cardIDType = cardIDType;
	}

	public String getCardIDNum() {
		return cardIDNum;
	}

	public void setCardIDNum(String cardIDNum) {
		this.cardIDNum = cardIDNum;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	
	
	public String getMerchDateToString() {
		return merchDateToString;
	}

	public void setMerchDateToString(String merchDateToString) {
		this.merchDateToString = merchDateToString;
	}

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId == null ? null : billId.trim();
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName == null ? null : custName.trim();
	}

	public Integer getCollectionState() {
		return collectionState;
	}

	public void setCollectionState(Integer collectionState) {
		this.collectionState = collectionState;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public UnionpayCollectionTotall getUnionpayCollectionTotall() {
		return unionpayCollectionTotall;
	}

	public void setUnionpayCollectionTotall(
			UnionpayCollectionTotall unionpayCollectionTotall) {
		this.unionpayCollectionTotall = unionpayCollectionTotall;
	}

	public String getUnionpayCollectionTotallId() {
		return unionpayCollectionTotallId;
	}

	public void setUnionpayCollectionTotallId(String unionpayCollectionTotallId) {
		this.unionpayCollectionTotallId = unionpayCollectionTotallId;
	}

	public String getUnionpayCollectionDetaiId() {
		return unionpayCollectionDetaiId;
	}

	public void setUnionpayCollectionDetaiId(String unionpayCollectionDetaiId) {
		this.unionpayCollectionDetaiId = unionpayCollectionDetaiId;
	}

	public Date getMerchantsDate() {
		return merchantsDate;
	}

	public void setMerchantsDate(Date merchantsDate) {
		this.merchantsDate = merchantsDate;
	}

	public String getCustNum() {
		return custNum;
	}

	public void setCustNum(String custNum) {
		this.custNum = custNum;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public Integer getAccountType() {
		return accountType;
	}

	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}

	public Long getSum() {
		return sum;
	}

	public void setSum(Long sum) {
		this.sum = sum;
	}

	public String getPrivateDomain() {
		return privateDomain;
	}

	public void setPrivateDomain(String privateDomain) {
		this.privateDomain = privateDomain;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getUnionpayCounterofferDetaiId() {
		return unionpayCounterofferDetaiId;
	}

	public void setUnionpayCounterofferDetaiId(
			String unionpayCounterofferDetaiId) {
		this.unionpayCounterofferDetaiId = unionpayCounterofferDetaiId;
	}

}
