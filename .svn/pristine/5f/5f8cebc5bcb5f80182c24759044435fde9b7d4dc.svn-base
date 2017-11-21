package com.flf.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 处理信息记录表
 * 创建人：邵政
 * 创建时间：2015-7-2
 */
@XmlRootElement(name = "DisposeInformationRecords")
public class DisposeInformationRecords {
    private String recordId;//处理记录项id

    private String orderId;//关联工单id
    
    private Integer checkItemType;//处理项类型

    private String checkItemName;//处理项名称

    private String checkItemResult;//处理结果

    private Page page;

    public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

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

    public String getCheckItemName() {
        return checkItemName;
    }

    public void setCheckItemName(String checkItemName) {
        this.checkItemName = checkItemName;
    }

    public String getCheckItemResult() {
        return checkItemResult;
    }

    public void setCheckItemResult(String checkItemResult) {
        this.checkItemResult = checkItemResult;
    }

	public Integer getCheckItemType() {
		return checkItemType;
	}

	public void setCheckItemType(Integer checkItemType) {
		this.checkItemType = checkItemType;
	}
	
}