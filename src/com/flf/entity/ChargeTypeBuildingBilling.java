package com.flf.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * 收费类型建筑计费表
 * @author maogaofei
 * @date 2016年7月9日 下午2:34:16
 */
@XmlRootElement(name = "ChargeTypeBuildingBilling")
public class ChargeTypeBuildingBilling {
    private String chargeTypeBuildingBillingId;//收费类型建筑计费ID

    private String chargeTypeProjectBillingId;//收费类型项目计费ID

    private String chargeTypeId;//收费类型ID

    private String buildingId;//建筑结构ID

    private String billingMonth;//计费日期
    
    private String billingTime;//计费时间

    private BigDecimal amount;//总金额

    private String status;//出账状态

    private String createUser;//创建人

    private String createTime;//创建时间

    private String updateUser;//修改人

    private String updateTime;//修改时间
    
    /*自定义属性不在数据库中*/
    private List<ChargeTypeBuildingBilling> chargeTypeBuildingBillings;
	
	private Page page;//分页
	
	private String fullName;//建筑结构全称
	
	private String chargeTypeName;//收费类型名称
    /*自定义属性不在数据库中 END*/
    
    public String getChargeTypeBuildingBillingId() {
        return chargeTypeBuildingBillingId;
    }

    public String getBillingTime() {
		return billingTime;
	}

	public void setBillingTime(String billingTime) {
		this.billingTime = billingTime;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getChargeTypeName() {
		return chargeTypeName;
	}

	public void setChargeTypeName(String chargeTypeName) {
		this.chargeTypeName = chargeTypeName;
	}

	public List<ChargeTypeBuildingBilling> getChargeTypeBuildingBillings() {
		return chargeTypeBuildingBillings;
	}

	public void setChargeTypeBuildingBillings(
			List<ChargeTypeBuildingBilling> chargeTypeBuildingBillings) {
		this.chargeTypeBuildingBillings = chargeTypeBuildingBillings;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public void setChargeTypeBuildingBillingId(String chargeTypeBuildingBillingId) {
        this.chargeTypeBuildingBillingId = chargeTypeBuildingBillingId == null ? null : chargeTypeBuildingBillingId.trim();
    }

    public String getChargeTypeProjectBillingId() {
        return chargeTypeProjectBillingId;
    }

    public void setChargeTypeProjectBillingId(String chargeTypeProjectBillingId) {
        this.chargeTypeProjectBillingId = chargeTypeProjectBillingId == null ? null : chargeTypeProjectBillingId.trim();
    }

    public String getChargeTypeId() {
        return chargeTypeId;
    }

    public void setChargeTypeId(String chargeTypeId) {
        this.chargeTypeId = chargeTypeId == null ? null : chargeTypeId.trim();
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId == null ? null : buildingId.trim();
    }

    public String getBillingMonth() {
        return billingMonth;
    }

    public void setBillingMonth(String billingMonth) {
        this.billingMonth = billingMonth == null ? null : billingMonth.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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