package com.flf.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 计费方案下收费项目表
 * @author maogaofei
 * @date 2016年6月29日 下午3:18:24
 */
@XmlRootElement(name = "ChargeItemNew")
public class ChargeItemNew {
    private String chargeItemNewId;//收费项目ID

    private String chargeItemNewNum;//收费项目编号

    private String chargeItemNewUnit;//单位

    private Integer houseNum;//户数

    private String schemeId;//计费方案ID

    private String chargeTypeId;//收费类型ID

    private String createUser;//创建人

    private String createTime;//创建时间

    private String updateUser;//修改人

    private String updateTime;//修改时间
    
    private BigDecimal useRangeTotalBuildArea;//使用范围总建筑面积
    
    /*自定义属性不在数据库中*/
    private String chargeTypeName;//收费类型名称
    
    private List<BuildingStructureNew> buildingStructureNewList;//关联建筑结构列表
    
    private String projectId;//项目ID
    /*自定义属性不在数据库中*/

    public String getChargeItemNewId() {
        return chargeItemNewId;
    }

    public BigDecimal getUseRangeTotalBuildArea() {
		return useRangeTotalBuildArea;
	}

	public void setUseRangeTotalBuildArea(BigDecimal useRangeTotalBuildArea) {
		this.useRangeTotalBuildArea = useRangeTotalBuildArea;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public List<BuildingStructureNew> getBuildingStructureNewList() {
		return buildingStructureNewList;
	}

	public void setBuildingStructureNewList(
			List<BuildingStructureNew> buildingStructureNewList) {
		this.buildingStructureNewList = buildingStructureNewList;
	}

	public void setChargeItemNewId(String chargeItemNewId) {
        this.chargeItemNewId = chargeItemNewId == null ? null : chargeItemNewId.trim();
    }

    public String getChargeItemNewNum() {
        return chargeItemNewNum;
    }

    public void setChargeItemNewNum(String chargeItemNewNum) {
        this.chargeItemNewNum = chargeItemNewNum == null ? null : chargeItemNewNum.trim();
    }

    public String getChargeTypeName() {
		return chargeTypeName;
	}

	public void setChargeTypeName(String chargeTypeName) {
		this.chargeTypeName = chargeTypeName;
	}

	public String getChargeItemNewUnit() {
        return chargeItemNewUnit;
    }

    public void setChargeItemNewUnit(String chargeItemNewUnit) {
        this.chargeItemNewUnit = chargeItemNewUnit == null ? null : chargeItemNewUnit.trim();
    }

    public Integer getHouseNum() {
        return houseNum;
    }

    public void setHouseNum(Integer houseNum) {
        this.houseNum = houseNum;
    }

    public String getSchemeId() {
        return schemeId;
    }

    public void setSchemeId(String schemeId) {
        this.schemeId = schemeId == null ? null : schemeId.trim();
    }

    public String getChargeTypeId() {
        return chargeTypeId;
    }

    public void setChargeTypeId(String chargeTypeId) {
        this.chargeTypeId = chargeTypeId == null ? null : chargeTypeId.trim();
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