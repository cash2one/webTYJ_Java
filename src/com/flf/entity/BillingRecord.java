package com.flf.entity;

import java.math.BigDecimal;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 计费记录表
 * @author maogaofei
 * @date 2016年7月12日 下午4:25:49
 */
@XmlRootElement(name = "BillingRecord")
public class BillingRecord {
    private String billingRecordId;//计费记录ID

    private String projectId;//项目ID

    private String buildingId;//建筑ID

    private String chargeTypeDetailsId;//收费类型详情ID

    private String chargeTypeDetailsBuildingBillingId;//收费类型详情建筑计费ID

    private String billingTime;//计费时间

    private BigDecimal amount;//金额

    private String createUser;//创建人

    private String createTime;//创建时间

    private String updateUser;//修改人

    private String updateTime;//修改时间
    
    /*自定义属性不在数据库中*/
    private List<BillingRecord> billingRecords;
	
	private Page page;//分页
	
	private String projectName;//项目名称
	
	private String fullName;//建筑全名
	
	private String chargeTypeDetailsName;//收费类型详情名称
	
	private String chargeTypeName;//违约金的详情
	
	private String billingStartTime;//计费开始时间
	
	private String billingEndTime;//计费结束时间
    /*自定义属性不在数据库中 END*/

    public String getBillingRecordId() {
        return billingRecordId;
    }

    public String getBillingStartTime() {
		return billingStartTime;
	}

	public void setBillingStartTime(String billingStartTime) {
		this.billingStartTime = billingStartTime;
	}

	public String getBillingEndTime() {
		return billingEndTime;
	}

	public void setBillingEndTime(String billingEndTime) {
		this.billingEndTime = billingEndTime;
	}

	public List<BillingRecord> getBillingRecords() {
		return billingRecords;
	}

	public void setBillingRecords(List<BillingRecord> billingRecords) {
		this.billingRecords = billingRecords;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getChargeTypeDetailsName() {
		return chargeTypeDetailsName;
	}

	public void setChargeTypeDetailsName(String chargeTypeDetailsName) {
		this.chargeTypeDetailsName = chargeTypeDetailsName;
	}

	public String getChargeTypeName() {
		return chargeTypeName;
	}

	public void setChargeTypeName(String chargeTypeName) {
		this.chargeTypeName = chargeTypeName;
	}

	public void setBillingRecordId(String billingRecordId) {
        this.billingRecordId = billingRecordId == null ? null : billingRecordId.trim();
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId == null ? null : buildingId.trim();
    }

    public String getChargeTypeDetailsId() {
        return chargeTypeDetailsId;
    }

    public void setChargeTypeDetailsId(String chargeTypeDetailsId) {
        this.chargeTypeDetailsId = chargeTypeDetailsId == null ? null : chargeTypeDetailsId.trim();
    }

    public String getChargeTypeDetailsBuildingBillingId() {
        return chargeTypeDetailsBuildingBillingId;
    }

    public void setChargeTypeDetailsBuildingBillingId(String chargeTypeDetailsBuildingBillingId) {
        this.chargeTypeDetailsBuildingBillingId = chargeTypeDetailsBuildingBillingId == null ? null : chargeTypeDetailsBuildingBillingId.trim();
    }

    public String getBillingTime() {
        return billingTime;
    }

    public void setBillingTime(String billingTime) {
        this.billingTime = billingTime == null ? null : billingTime.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }
}