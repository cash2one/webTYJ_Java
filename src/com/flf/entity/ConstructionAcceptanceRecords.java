package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 施工验收记录表
 * @author shaozheng
 * 2015-9-1
 */
@XmlRootElement(name="ConstructionAcceptanceRecords")
public class ConstructionAcceptanceRecords {
	
	private String recordId;   //记录id
	private String orderId;   //关联工单id
	private String inspectId;   //验收项id
	private String inspectName;   //验收项名称
	private Integer normal;   //验收项是否正常
	private String remarks;   //备注说明
	private Integer conduct;   //验收项是否进行
	
	public Integer getConduct() {
		return conduct;
	}
	public void setConduct(Integer conduct) {
		this.conduct = conduct;
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
	public String getInspectId() {
		return inspectId;
	}
	public void setInspectId(String inspectId) {
		this.inspectId = inspectId;
	}
	public String getInspectName() {
		return inspectName;
	}
	public void setInspectName(String inspectName) {
		this.inspectName = inspectName;
	}
	public Integer getNormal() {
		return normal;
	}
	public void setNormal(Integer normal) {
		this.normal = normal;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
