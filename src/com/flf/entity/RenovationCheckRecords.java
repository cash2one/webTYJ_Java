package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 装修核查记录
 * @author 倪明
 *2015/08/18
 */
@XmlRootElement(name = "RenovationCheckRecords")
public class RenovationCheckRecords {
	
	private String recordId;   //装修核查记录id
	
	private String orderId;   //关联工单id
	
	private String inspectId;   //核查项id
	
	private String inspectName;   //核查项名称
	
	private Integer normal;   //核查项是否正常
	
	private Integer conduct;   //核查项是否进行
	
	private String remarks;   //备注说明

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
	
	public Integer getConduct() {
		return conduct;
	}

	public void setConduct(Integer conduct) {
		this.conduct = conduct;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
