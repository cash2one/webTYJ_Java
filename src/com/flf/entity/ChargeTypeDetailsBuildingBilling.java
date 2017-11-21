package com.flf.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * 收费类型详情建筑计费表
 * @author maogaofei
 * @date 2016年7月9日 下午2:34:16
 */
@XmlRootElement(name = "ChargeTypeDetailsBuildingBilling")
public class ChargeTypeDetailsBuildingBilling {
    private String chargeTypeDetailsBuildingBillingId;//收费类型详情建筑计费ID

    private String chargeTypeBuildingBillingId;//收费类型建筑计费ID

    private String chargeTypeDetailsId;//收费类型详情ID
    
    private String chargeItemDetailsId;//收费项目详情ID
    
    private String billingTime;//计费时间

    private BigDecimal amount;//金额

    private String status;//出账状态

    private String createUser;//创建人

    private String createTime;//创建时间

    private String updateUser;//修改人

    private String updateTime;//修改时间

    /*自定义属性不在数据库中*/
    private List<ChargeTypeDetailsBuildingBilling> chargeTypeDetailsBuildingBillings;
	
	private Page page;//分页
	
	private String chargeTypeDetailsName;//收费类型详情名称

    private String chargeTypeDetailsNum;//收费类型详情编号
    /*自定义属性不在数据库中 END*/

    public String getChargeTypeDetailsBuildingBillingId() {
        return chargeTypeDetailsBuildingBillingId;
    }

	public String getBillingTime() {
		return billingTime;
	}

	public void setBillingTime(String billingTime) {
		this.billingTime = billingTime;
	}

	public String getChargeItemDetailsId() {
		return chargeItemDetailsId;
	}

	public void setChargeItemDetailsId(String chargeItemDetailsId) {
		this.chargeItemDetailsId = chargeItemDetailsId;
	}

	public String getChargeTypeDetailsName() {
		return chargeTypeDetailsName;
	}

	public void setChargeTypeDetailsName(String chargeTypeDetailsName) {
		this.chargeTypeDetailsName = chargeTypeDetailsName;
	}

	public String getChargeTypeDetailsNum() {
		return chargeTypeDetailsNum;
	}

	public void setChargeTypeDetailsNum(String chargeTypeDetailsNum) {
		this.chargeTypeDetailsNum = chargeTypeDetailsNum;
	}

	public List<ChargeTypeDetailsBuildingBilling> getChargeTypeDetailsBuildingBillings() {
		return chargeTypeDetailsBuildingBillings;
	}

	public void setChargeTypeDetailsBuildingBillings(
			List<ChargeTypeDetailsBuildingBilling> chargeTypeDetailsBuildingBillings) {
		this.chargeTypeDetailsBuildingBillings = chargeTypeDetailsBuildingBillings;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public void setChargeTypeDetailsBuildingBillingId(String chargeTypeDetailsBuildingBillingId) {
        this.chargeTypeDetailsBuildingBillingId = chargeTypeDetailsBuildingBillingId == null ? null : chargeTypeDetailsBuildingBillingId.trim();
    }

    public String getChargeTypeBuildingBillingId() {
        return chargeTypeBuildingBillingId;
    }

    public void setChargeTypeBuildingBillingId(String chargeTypeBuildingBillingId) {
        this.chargeTypeBuildingBillingId = chargeTypeBuildingBillingId == null ? null : chargeTypeBuildingBillingId.trim();
    }

    public String getChargeTypeDetailsId() {
        return chargeTypeDetailsId;
    }

    public void setChargeTypeDetailsId(String chargeTypeDetailsId) {
        this.chargeTypeDetailsId = chargeTypeDetailsId == null ? null : chargeTypeDetailsId.trim();
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