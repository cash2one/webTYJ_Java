package com.flf.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 检测项结果记录表
 * 
 * @author 邵政 
 * 2015-7-2
 */
@XmlRootElement(name = "CheckItemRecords")
public class CheckItemRecords {
	
	private String recordId;// 检测记录id

	private String orderId;// 关联工单id

	private Integer checkItemType;// 检测项类型

	private String checkItemName;// 检测项名称

	private String checkItemResult;// 检测说明
	
	private int isThroughInsurance;//是否过保
	
	private int isAbnormal;//检测结果是否异常
	
	private int isAftermarket;//是否售后
	
	private List<CheckOrders> checkOrders; //检测单

	public int getIsThroughInsurance() {
		return isThroughInsurance;
	}

	public void setIsThroughInsurance(int isThroughInsurance) {
		this.isThroughInsurance = isThroughInsurance;
	}

	public int getIsAbnormal() {
		return isAbnormal;
	}

	public void setIsAbnormal(int isAbnormal) {
		this.isAbnormal = isAbnormal;
	}

	public int getIsAftermarket() {
		return isAftermarket;
	}

	public void setIsAftermarket(int isAftermarket) {
		this.isAftermarket = isAftermarket;
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

	public Integer getCheckItemType() {
		return checkItemType;
	}

	public void setCheckItemType(Integer checkItemType) {
		this.checkItemType = checkItemType;
	}

	public String getCheckItemName() {
		return checkItemName;
	}

	public void setCheckItemName(String checkItemName) {
		this.checkItemName = checkItemName;
	}

	public String getCheckItemResult() {
		return checkItemResult;
	}

	public void setCheckItemResult(String checkItemResult) {
		this.checkItemResult = checkItemResult;
	}

	public List<CheckOrders> getCheckOrders() {
		return checkOrders;
	}

	public void setCheckOrders(List<CheckOrders> checkOrders) {
		this.checkOrders = checkOrders;
	}

}
