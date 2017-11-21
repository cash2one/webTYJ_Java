package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 报价项记录表
 * 创建人：邵政
 * 创建时间：2015-7-2
 */
@XmlRootElement(name = "QuoteItemRecords")
public class QuoteItemRecords {
    private String recordId;//报价记录id

    private String orderId;//关联工单id

    private Integer quoteItemType;//报价类型
    
    private String quoteItemId;//报价项id
    
    private String quoteItemName;//报价项名称

    private String quoteItemNum;//报价项数量

    private Double quoteItemTotal;//报价项总价
    
    private Double quoteItemPrice;//报价项单价

    public Double getQuoteItemPrice() {
		return quoteItemPrice;
	}

	public void setQuoteItemPrice(Double quoteItemPrice) {
		this.quoteItemPrice = quoteItemPrice;
	}

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

    public String getQuoteItemName() {
        return quoteItemName;
    }

    public void setQuoteItemName(String quoteItemName) {
        this.quoteItemName = quoteItemName;
    }

    public String getQuoteItemNum() {
        return quoteItemNum;
    }

    public void setQuoteItemNum(String quoteItemNum) {
        this.quoteItemNum = quoteItemNum;
    }


	public Double getQuoteItemTotal() {
		return quoteItemTotal;
	}

	public void setQuoteItemTotal(Double quoteItemTotal) {
		this.quoteItemTotal = quoteItemTotal;
	}

	public Integer getQuoteItemType() {
		return quoteItemType;
	}

	public void setQuoteItemType(Integer quoteItemType) {
		this.quoteItemType = quoteItemType;
	}

	public String getQuoteItemId() {
		return quoteItemId;
	}

	public void setQuoteItemId(String quoteItemId) {
		this.quoteItemId = quoteItemId;
	}
}