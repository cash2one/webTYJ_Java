package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * 业主装修服务请求关联表
 * @author taoyongchao
 *  2015-8-18
 */
@XmlRootElement(name="DecoreateServiceRequestAssociated")
public class DecoreateServiceRequestAssociated {
	private String recordId; //记录Id
	private String applyId;  //装修关联申请Id
	private String serviceRequestId; //业主装修服务请求关联ID
	
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
	public String getServiceRequestId() {
		return serviceRequestId;
	}
	public void setServiceRequestId(String serviceRequestId) {
		this.serviceRequestId = serviceRequestId;
	}
}
