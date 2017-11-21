package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 专项表
 * @author shaozheng
 *	2015-7-17
 */
@XmlRootElement(name = "SpecialRepairProject")
public class SpecialRepairProject {

	private String specialId;//专项id
	private String specialName;//专项名称
	private String specialType;//专项类型
	private Integer specialState;//专项状态(0关闭 1启动  2完成)
	private String createTime;//创建时间
	private String specialWriter;//创建人
	@DateTimeFormat(pattern ="yyyy-MM-dd HH:mm")
	private Date startTime;//启动时间
	private String remarks;//备注
	
	private List<Annex> annexs;//附件
	private Staff staff;//人员表
	private String state;//状态 专项查询
	private String specialPrincipal;//负责人
	private Date endTime;//结束时间
	private double specialEstimateMoney;//预计金额
	
	
	private Page page;
	
	public String getSpecialId() {
		return specialId;
	}
	public void setSpecialId(String specialId) {
		this.specialId = specialId;
	}
	public String getSpecialName() {
		return specialName;
	}
	public void setSpecialName(String specialName) {
		this.specialName = specialName;
	}
	public String getSpecialType() {
		return specialType;
	}
	public void setSpecialType(String specialType) {
		this.specialType = specialType;
	}
	public Integer getSpecialState() {
		return specialState;
	}
	public void setSpecialState(Integer specialState) {
		this.specialState = specialState;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getSpecialWriter() {
		return specialWriter;
	}
	public void setSpecialWriter(String specialWriter) {
		this.specialWriter = specialWriter;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public List<Annex> getAnnexs() {
		return annexs;
	}
	public void setAnnexs(List<Annex> annexs) {
		this.annexs = annexs;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public String getSpecialPrincipal() {
		return specialPrincipal;
	}
	public void setSpecialPrincipal(String specialPrincipal) {
		this.specialPrincipal = specialPrincipal;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public double getSpecialEstimateMoney() {
		return specialEstimateMoney;
	}
	public void setSpecialEstimateMoney(double specialEstimateMoney) {
		this.specialEstimateMoney = specialEstimateMoney;
	}
	
}
