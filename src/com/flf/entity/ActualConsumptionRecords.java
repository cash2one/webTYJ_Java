package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 实际消耗资源记录
 * @author wangzhou
 *
 */
@XmlRootElement(name="ActualConsumptionRecords")
public class ActualConsumptionRecords {
	
	//id
    private String consumptionRecordId;

    //关联工单id
    private String orderId;

    //产品类型
    private String productType;

    //产品id
    private String productId;

    //产品名称
    private String productName;

    //数量
    private Byte num;

    public String getConsumptionRecordId() {
        return consumptionRecordId;
    }

    public void setConsumptionRecordId(String consumptionRecordId) {
        this.consumptionRecordId = consumptionRecordId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Byte getNum() {
        return num;
    }

    public void setNum(Byte num) {
        this.num = num;
    }
}