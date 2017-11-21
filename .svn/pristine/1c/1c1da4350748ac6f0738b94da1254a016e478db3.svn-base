package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 验房记录表
 * @author shaozheng
 *	2015-8-13
 */
@XmlRootElement(name = "InspectorRecord")
public class InspectorRecord {
	
    private String recordId;//记录id
    private String orderId;//关联工单id
    private String checkItemsId;//检验项id
    private String checkItemsName;//检验项名称
    private Integer checkItemsNormal;//检验项是否正常  0不正常 1正常
    private Integer guaranteePeriod;//检验项是否过保 		0过保 1未过保
    private Integer ifAfterSale;//检验项是否转售后	0否 1是
    private String remarks;//备注说明

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCheckItemsId() {
        return checkItemsId;
    }

    public void setCheckItemsId(String checkItemsId) {
        this.checkItemsId = checkItemsId;
    }

    public String getCheckItemsName() {
        return checkItemsName;
    }

    public void setCheckItemsName(String checkItemsName) {
        this.checkItemsName = checkItemsName;
    }
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

	public Integer getCheckItemsNormal() {
		return checkItemsNormal;
	}

	public void setCheckItemsNormal(Integer checkItemsNormal) {
		this.checkItemsNormal = checkItemsNormal;
	}

	public Integer getGuaranteePeriod() {
		return guaranteePeriod;
	}

	public void setGuaranteePeriod(Integer guaranteePeriod) {
		this.guaranteePeriod = guaranteePeriod;
	}

	public Integer getIfAfterSale() {
		return ifAfterSale;
	}

	public void setIfAfterSale(Integer ifAfterSale) {
		this.ifAfterSale = ifAfterSale;
	}
}