package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "BillPaymentRelation") //账单收支明细关系表
public class BillPaymentRelation {
    private String billPaymentRelationId; //关系id

    private String billId; //账单id

    private String paymentDetailsId;//收支明细id

    public String getBillPaymentRelationId() {
        return billPaymentRelationId;
    }

    public void setBillPaymentRelationId(String billPaymentRelationId) {
        this.billPaymentRelationId = billPaymentRelationId;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getPaymentDetailsId() {
        return paymentDetailsId;
    }

    public void setPaymentDetailsId(String paymentDetailsId) {
        this.paymentDetailsId = paymentDetailsId;
    }
}