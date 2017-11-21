package com.flf.entity;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Constant")// 常量表
public class Constant {
    private String constantId;  //常量id

    private String constantName; //常量名称

    private String chargeTypeId;  // 收费类型id

    private BigDecimal value;  // 常量值

    private String constantNum;  //常量编号
    
    private String commonValue;//通用常量值
    
    private String parentsId; //父级ID
   
    private Page page;

    public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getConstantId() {
        return constantId;
    }

    public void setConstantId(String constantId) {
        this.constantId = constantId;
    }

    public String getConstantName() {
        return constantName;
    }

    public void setConstantName(String constantName) {
        this.constantName = constantName;
    }

    public String getChargeTypeId() {
		return chargeTypeId;
	}

	public void setChargeTypeId(String chargeTypeId) {
		this.chargeTypeId = chargeTypeId;
	}

    public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public String getConstantNum() {
        return constantNum;
    }

    public void setConstantNum(String constantNum) {
        this.constantNum = constantNum;
    }

	public String getCommonValue() {
		return commonValue;
	}

	public void setCommonValue(String commonValue) {
		this.commonValue = commonValue;
	}

	public String getParentsId() {
		return parentsId;
	}

	public void setParentsId(String parentsId) {
		this.parentsId = parentsId;
	}
}