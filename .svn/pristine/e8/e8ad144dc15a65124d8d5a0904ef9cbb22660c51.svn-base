package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * 电表结果记录表
 * @author shaozheng
 *	2015-8-10
 */
@XmlRootElement(name="MeterReadingRecords")
public class MeterReadingRecords {
	
	private String recordId;//记录id
	private String orderId;//关联工单id
	private String meterId;//电表id
	private Double waterMeterReading;//当前读数
	private Double waterLastReading;//上次读数
	private ElectricityMeter electricityMeter;//电表
	public ElectricityMeter getElectricityMeter() {
		return electricityMeter;
	}
	public void setElectricityMeter(ElectricityMeter electricityMeter) {
		this.electricityMeter = electricityMeter;
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
	public String getMeterId() {
		return meterId;
	}
	public void setMeterId(String meterId) {
		this.meterId = meterId;
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
}
