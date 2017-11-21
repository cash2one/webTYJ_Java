package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 巡检管理记录信息表
 * @author yangshengquan
 *	2015-7-27
 */
@XmlRootElement(name="InspectionRecords")
public class InspectionRecords {

private String recordId; //记录id
private String orderId;//关联工单id
private String inspectionPropertyId;//巡检目标id
private String checkItemName;//巡检项名称
private String checkItemUnit;//巡检项单位
private String inspectionResult;//巡检结果
private String inspectionPlanId; //关联巡检方案id

public String getInspectionPlanId() {
	return inspectionPlanId;
}
public void setInspectionPlanId(String inspectionPlanId) {
	this.inspectionPlanId = inspectionPlanId;
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
public String getInspectionPropertyId() {
	return inspectionPropertyId;
}
public void setInspectionPropertyId(String inspectionPropertyId) {
	this.inspectionPropertyId = inspectionPropertyId;
}
public String getCheckItemName() {
	return checkItemName;
}
public void setCheckItemName(String checkItemName) {
	this.checkItemName = checkItemName;
}
public String getCheckItemUnit() {
	return checkItemUnit;
}
public void setCheckItemUnit(String checkItemUnit) {
	this.checkItemUnit = checkItemUnit;
}
public String getInspectionResult() {
	return inspectionResult;
}
public void setInspectionResult(String inspectionResult) {
	this.inspectionResult = inspectionResult;
}



}
