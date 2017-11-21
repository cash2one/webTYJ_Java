package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 水表工单记录信息表
 * @author shaozheng
 *	2015-8-10
 */
@XmlRootElement(name="WaterMeterOrderRecords")
public class WaterMeterOrderRecords {
	private String recordId;//记录id
	private String orderId;//关联工单id
	private String waterMeterId;//水表id
	private Double waterMeterReading;//当前读数
	private Double waterLastReading;//上次读数
	private String buildingStructureId;//建筑结构id
	private BuildingStructureNew buildingStructureNew;//建筑信息
	public String getBuildingStructureId() {
		return buildingStructureId;
	}
	public void setBuildingStructureId(String buildingStructureId) {
		this.buildingStructureId = buildingStructureId;
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
	public String getWaterMeterId() {
		return waterMeterId;
	}
	public void setWaterMeterId(String waterMeterId) {
		this.waterMeterId = waterMeterId;
	}
	public Double getWaterMeterReading() {
		return waterMeterReading;
	}
	public void setWaterMeterReading(Double waterMeterReading) {
		this.waterMeterReading = waterMeterReading;
	}
	public Double getWaterLastReading() {
		return waterLastReading;
	}
	public void setWaterLastReading(Double waterLastReading) {
		this.waterLastReading = waterLastReading;
	}
	public BuildingStructureNew getBuildingStructureNew() {
		return buildingStructureNew;
	}
	public void setBuildingStructureNew(BuildingStructureNew buildingStructureNew) {
		this.buildingStructureNew = buildingStructureNew;
	}
}
