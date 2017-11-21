package com.flf.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 向客户索赔方案表
 * @author shaozheng
 *	2015-8-12
 */
@XmlRootElement(name="ClaimToCustomerRethods")
public class ClaimToCustomerRethods {
	
	private String recordId;//	记录
	private String orderId;//	关联工单
	private Double claimMoney;//	赔付金额
	private Integer claimState;//	赔付方式
	private Integer claimCycle;//	赔付周期	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date startTime;//	赔付开始时间
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")//	赔付结束时间
	private Date endTime;
	
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
	public Double getClaimMoney() {
		return claimMoney;
	}
	public void setClaimMoney(Double claimMoney) {
		this.claimMoney = claimMoney;
	}
	public Integer getClaimState() {
		return claimState;
	}
	public void setClaimState(Integer claimState) {
		this.claimState = claimState;
	}
	public Integer getClaimCycle() {
		return claimCycle;
	}
	public void setClaimCycle(Integer claimCycle) {
		this.claimCycle = claimCycle;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}
