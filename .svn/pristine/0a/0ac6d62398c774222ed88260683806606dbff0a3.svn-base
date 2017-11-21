package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 银联回盘总结文件
 * 
 * @author wangzaimiao 2015-9-21
 */

@XmlRootElement(name = "UnionpayCounterofferTotal")
public class UnionpayCounterofferTotal {
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String unionpayCounterofferCotalId; // 主键id
	private String projectId;//项目id
	private String fileName; // 文件名称
	private Long totalSum; // 总金额
	private Long successSum; // 成功金额
	private Date upDate; // 上传时间
	private Page page; // 分页
	private Integer totalTradeNum;// 总笔数
	private Integer successTradeNum;// 成功笔数
	private String batchNum;//批次号
	private Integer offerState;//回盘状态

	private Date minStaTime;// 开始时间
	private Date maxStaTime;// 结束时间
	
	private List<UnionpayCounterofferTotal> unionpayCounterofferTotals;

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public Integer getOfferState() {
		return offerState;
	}

	public void setOfferState(Integer offerState) {
		this.offerState = offerState;
	}

	public String getBatchNum() {
		return batchNum;
	}

	public void setBatchNum(String batchNum) {
		this.batchNum = batchNum;
	}

	public Date getMinStaTime() {
		return minStaTime;
	}

	public void setMinStaTime(Date minStaTime) {
		this.minStaTime = minStaTime;
	}

	public Date getMaxStaTime() {
		return maxStaTime;
	}

	public void setMaxStaTime(Date maxStaTime) {
		this.maxStaTime = maxStaTime;
	}

	public List<UnionpayCounterofferTotal> getUnionpayCounterofferTotals() {
		return unionpayCounterofferTotals;
	}

	public void setUnionpayCounterofferTotals(
			List<UnionpayCounterofferTotal> unionpayCounterofferTotals) {
		this.unionpayCounterofferTotals = unionpayCounterofferTotals;
	}

	public Integer getTotalTradeNum() {
		return totalTradeNum;
	}

	public void setTotalTradeNum(Integer totalTradeNum) {
		this.totalTradeNum = totalTradeNum;
	}

	public Integer getSuccessTradeNum() {
		return successTradeNum;
	}

	public void setSuccessTradeNum(Integer successTradeNum) {
		this.successTradeNum = successTradeNum;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Date getUpDate() {
		return upDate;
	}

	public void setUpDate(Date upDate) {
		this.upDate = upDate;
	}

	public String getUnionpayCounterofferCotalId() {
		return unionpayCounterofferCotalId;
	}

	public void setUnionpayCounterofferCotalId(
			String unionpayCounterofferCotalId) {
		this.unionpayCounterofferCotalId = unionpayCounterofferCotalId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Long getTotalSum() {
		return totalSum;
	}

	public void setTotalSum(Long totalSum) {
		this.totalSum = totalSum;
	}

	public Long getSuccessSum() {
		return successSum;
	}

	public void setSuccessSum(Long successSum) {
		this.successSum = successSum;
	}

/*	public String getUnionpayCollectionOfferDetaiId() {
		return unionpayCollectionOfferDetaiId;
	}

	public void setUnionpayCollectionOfferDetaiId(
			String unionpayCollectionOfferDetaiId) {
		this.unionpayCollectionOfferDetaiId = unionpayCollectionOfferDetaiId;
	}*/

}