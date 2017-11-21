package com.flf.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;
@XmlRootElement(name = "ChargeItemBilling") //收费项目计费
public class ChargeItemBilling {
    private String chargeItemBillingId; //收费项目计费id

    private String projectBillingId; //项目计费id

    private String projectName; //项目名称

    private String chargeItemName; // 收费项目名称
    
    private @DateTimeFormat(pattern="yyyy-MM-dd") Date billingStartTime;// 计费开始日期
    
    private @DateTimeFormat(pattern="yyyy-MM-dd") Date billingEndTime;// 计费结束日期

    private Double sum; //总金额

    private int billingType; //计费状态（0已完成1已取消）
    
    private String projectId; //项目id
    
    private String chargeItemId; //收费项目id    

	private double currentSum;//本期金额
	
	private double lastSum;//上期金额
	
	private String buildingBillingId;//建筑收费项目计费id（查询用）
	
	public String getBuildingBillingId() {
		return buildingBillingId;
	}

	public void setBuildingBillingId(String buildingBillingId) {
		this.buildingBillingId = buildingBillingId;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	private Page page;

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

    public String getChargeItemBillingId() {
        return chargeItemBillingId;
    }

    public void setChargeItemBillingId(String chargeItemBillingId) {
        this.chargeItemBillingId = chargeItemBillingId;
    }

    public String getProjectBillingId() {
        return projectBillingId;
    }

    public void setProjectBillingId(String projectBillingId) {
        this.projectBillingId = projectBillingId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getChargeItemName() {
        return chargeItemName;
    }

    public void setChargeItemName(String chargeItemName) {
        this.chargeItemName = chargeItemName;
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

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

	public int getBillingType() {
		return billingType;
	}

	public void setBillingType(int billingType) {
		this.billingType = billingType;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getChargeItemId() {
		return chargeItemId;
	}

	public void setChargeItemId(String chargeItemId) {
		this.chargeItemId = chargeItemId;
	}
}