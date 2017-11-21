package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * 装修巡检记录表
 * @author taoyongchao
 * 2015-8-18
 */

@XmlRootElement(name="DecoreateInspectionRecords")
public class DecoreateInspectionRecords {
	private String recordId; //记录ID
	private String applyId;  //装修申请关联Id
	private String orderId;   //巡检工单Id
	
	
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getApplyId() {
		return applyId;
	}
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	

}
