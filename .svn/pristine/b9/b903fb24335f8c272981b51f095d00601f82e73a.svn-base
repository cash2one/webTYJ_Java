package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;
@XmlRootElement(name = "Billing") //计费表
public class Billing {
    private String billingId; //计费id

    private double currentSum;//本期金额
    
    private double lastSum;//上期金额
    
    private Date billingStartTime; //计费开始时间

    private Date billingEndTime; //计费结束时间

    private Double billingBalance; //计费金额

    private String schemeDatailsId; //方案详情id

    private String chargeItemName; //收费项目名称

    private String buildingId; //建筑结构id
    
    private int billingState; //计费状态(0未过账 1已取消  2已过账)
    
    private String projectId; //项目id    

	private String buildingBillingId;//建筑收费项目计费id
    
    private String billId;//应收款id    

	private String fullName;//房屋全名（计费程序查询用）
    
    private String projectName;//项目名称（计费程序查询用）    
    
    private String ciNum;//收费项目编号
	
    public String getCiNum() {
		return ciNum;
	}

	public void setCiNum(String ciNum) {
		this.ciNum = ciNum;
	}

	private byte isDepositDeduct;//是否为押金扣款
    
	private List<ProjectBilling> projectBillingList;//项目计费集合
	
	private List<ChargeItemNew> chargeItemNewList;//一级收费项目集合
    
	private List<ChargeItemBilling> chargeItemBillingList;//选中的收费项目计费记录
	
	private List<BuildingBilling> buildingBillingList;//选中的建筑收费项目计费记录
	public List<ProjectBilling> getProjectBillingList() {
		return projectBillingList;
	}

	public void setProjectBillingList(List<ProjectBilling> projectBillingList) {
		this.projectBillingList = projectBillingList;
	}

	public List<ChargeItemNew> getChargeItemNewList() {
		return chargeItemNewList;
	}

	public void setChargeItemNewList(List<ChargeItemNew> chargeItemNewList) {
		this.chargeItemNewList = chargeItemNewList;
	}

	public double getCurrentSum() {
		return currentSum;
	}

	public void setCurrentSum(double currentSum) {
		this.currentSum = currentSum;
	}

	public double getLastSum() {
		return lastSum;
	}

	public void setLastSum(double lastSum) {
		this.lastSum = lastSum;
	}

	public byte getIsDepositDeduct() {
		return isDepositDeduct;
	}

	public void setIsDepositDeduct(byte isDepositDeduct) {
		this.isDepositDeduct = isDepositDeduct;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	private Page page;
    
    public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
    
    public String getBuildingBillingId() {
		return buildingBillingId;
	}

	public void setBuildingBillingId(String buildingBillingId) {
		this.buildingBillingId = buildingBillingId;
	}

	public String getBillId() {
		return billId;
	}

	public void setBillId(String billId) {
		this.billId = billId;
	}

    public String getBillingId() {
        return billingId;
    }

    public void setBillingId(String billingId) {
        this.billingId = billingId;
    }

    public Date getBillingStartTime() {
        return billingStartTime;
    }

    public void setBillingStartTime(Date billingStartTime) {
        this.billingStartTime = billingStartTime;
    }

    public Date getBillingEndTime() {
        return billingEndTime;
    }

    public void setBillingEndTime(Date billingEndTime) {
        this.billingEndTime = billingEndTime;
    }

    public Double getBillingBalance() {
        return billingBalance;
    }

    public void setBillingBalance(Double billingBalance) {
        this.billingBalance = billingBalance;
    }

    public String getSchemeDatailsId() {
        return schemeDatailsId;
    }

    public void setSchemeDatailsId(String schemeDatailsId) {
        this.schemeDatailsId = schemeDatailsId;
    }

    public String getChargeItemName() {
        return chargeItemName;
    }

    public void setChargeItemName(String chargeItemName) {
        this.chargeItemName = chargeItemName;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }


	public int getBillingState() {
		return billingState;
	}

	public void setBillingState(int billingState) {
		this.billingState = billingState;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public List<ChargeItemBilling> getChargeItemBillingList() {
		return chargeItemBillingList;
	}

	public void setChargeItemBillingList(List<ChargeItemBilling> chargeItemBillingList) {
		this.chargeItemBillingList = chargeItemBillingList;
	}

	public List<BuildingBilling> getBuildingBillingList() {
		return buildingBillingList;
	}

	public void setBuildingBillingList(List<BuildingBilling> buildingBillingList) {
		this.buildingBillingList = buildingBillingList;
	}
	
}