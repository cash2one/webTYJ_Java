package com.flf.entity;


import javax.xml.bind.annotation.XmlRootElement;

/**
 * 收费项目详情
 * @author maogaofei
 * @date 2016年6月29日 下午3:40:45
 */
@XmlRootElement(name = "ChargeItemNewDetails")
public class ChargeItemNewDetails {
    private String chargeItemDetailsId;//收费项目详情ID

    private String chargeTypeDetailsId;//收费类型详情ID

    private String chargeItemDetailsNum;//收费项目详情编号
    
    private String chargeItemNewId;//收费项目ID

    private String createUser;//创建人

    private String createTime;//创建时间

    private String updateUser;//修改人

    private String updateTime;//修改时间
    
    /*自定义属性不在数据库中*/
    private String chargeTypeDetailsName;//收费类型详情名称

    private String chargeTypeDetailsNum;//收费类型详情编号
    /*自定义属性不在数据库中*/ 

    public String getChargeItemNewId() {
		return chargeItemNewId;
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

	public void setChargeItemNewId(String chargeItemNewId) {
		this.chargeItemNewId = chargeItemNewId;
	}

	public String getChargeItemDetailsId() {
        return chargeItemDetailsId;
    }

    public void setChargeItemDetailsId(String chargeItemDetailsId) {
        this.chargeItemDetailsId = chargeItemDetailsId == null ? null : chargeItemDetailsId.trim();
    }

    public String getChargeTypeDetailsId() {
        return chargeTypeDetailsId;
    }

    public void setChargeTypeDetailsId(String chargeTypeDetailsId) {
        this.chargeTypeDetailsId = chargeTypeDetailsId == null ? null : chargeTypeDetailsId.trim();
    }

    public String getChargeItemDetailsNum() {
        return chargeItemDetailsNum;
    }

    public void setChargeItemDetailsNum(String chargeItemDetailsNum) {
        this.chargeItemDetailsNum = chargeItemDetailsNum == null ? null : chargeItemDetailsNum.trim();
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