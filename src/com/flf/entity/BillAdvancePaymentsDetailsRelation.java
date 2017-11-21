package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * 应收款预收款支付关系表
 * @author 陶勇超
 *2015-10-10
 */
@XmlRootElement(name="BillAdvancePaymentsDetailsRelation")
public class BillAdvancePaymentsDetailsRelation {

	private String billAdvancePaymentsDetailsRelationId;//主键ID
	private String  billId; //应收款id
	private String advancePaymentsDetailsId; //预付款明细id
	public String getBillAdvancePaymentsDetailsRelationId() {
		return billAdvancePaymentsDetailsRelationId;
	}
	public void setBillAdvancePaymentsDetailsRelationId(
			String billAdvancePaymentsDetailsRelationId) {
		this.billAdvancePaymentsDetailsRelationId = billAdvancePaymentsDetailsRelationId;
	}
	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
	public String getAdvancePaymentsDetailsId() {
		return advancePaymentsDetailsId;
	}
	public void setAdvancePaymentsDetailsId(String advancePaymentsDetailsId) {
		this.advancePaymentsDetailsId = advancePaymentsDetailsId;
	}
	
	
}
