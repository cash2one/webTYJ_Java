package com.flf.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * 验收项记录表
 * @author shaozheng
 *	2015-7-2
 */
@XmlRootElement(name = "AcceptanceInformationRecords")
public class AcceptanceInformationRecords {

	private String recordId;// 验收记录id

	private String orderId;// 关联验收工单id

	private Integer acceptanceItemType;// 验收项类型

	private String acceptanceItemName;// 验收项名称

	private String acceptanceItemResult;//验收结果
	
	private List<AcceptanceOrders> acceptanceOrders; //验收单

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

	public Integer getAcceptanceItemType() {
		return acceptanceItemType;
	}

	public void setAcceptanceItemType(Integer acceptanceItemType) {
		this.acceptanceItemType = acceptanceItemType;
	}

	public String getAcceptanceItemName() {
		return acceptanceItemName;
	}

	public void setAcceptanceItemName(String acceptanceItemName) {
		this.acceptanceItemName = acceptanceItemName;
	}

	public String getAcceptanceItemResult() {
		return acceptanceItemResult;
	}

	public void setAcceptanceItemResult(String acceptanceItemResult) {
		this.acceptanceItemResult = acceptanceItemResult;
	}

	public List<AcceptanceOrders> getAcceptanceOrders() {
		return acceptanceOrders;
	}

	public void setAcceptanceOrders(List<AcceptanceOrders> acceptanceOrders) {
		this.acceptanceOrders = acceptanceOrders;
	}
}
