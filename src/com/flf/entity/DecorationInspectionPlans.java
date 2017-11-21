package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="DecorationInspectionPlans")
public class DecorationInspectionPlans {
    private String decorationInspectionPlanId;//装修巡检方案id

    private String decorationInspectionPlanNum;//巡检方案id

    private String decorationInspectionPlanName;//装修巡检方案名称

    private String decorationInspectionPlanRemarks;//装修巡检方案说明

    private Byte state;//状态（0失效、1有效）

    private String creUserId;//创建人id

    private Date creTme;//创建时间

    private Date effectiveTime;//生效时间

    private Date failureTime;//失效时间
    
    private Page page;//页面分页
    
    private FrequencyRecord frequencyRecord;//频率记录表
    
    private List<ExecutionTimeRecords> executionTimeRecords;//执行次数与时间记录表
    
    private String closeRemarks;//失效时间（主动）
    
  

	public String getCloseRemarks() {
		return closeRemarks;
	}

	public void setCloseRemarks(String closeRemarks) {
		this.closeRemarks = closeRemarks;
	}

	public List<ExecutionTimeRecords> getExecutionTimeRecords() {
		return executionTimeRecords;
	}

	public void setExecutionTimeRecords(List<ExecutionTimeRecords> executionTimeRecords) {
		this.executionTimeRecords = executionTimeRecords;
	}

	public FrequencyRecord getFrequencyRecord() {
		return frequencyRecord;
	}

	public void setFrequencyRecord(FrequencyRecord frequencyRecord) {
		this.frequencyRecord = frequencyRecord;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getDecorationInspectionPlanId() {
        return decorationInspectionPlanId;
    }

    public void setDecorationInspectionPlanId(String decorationInspectionPlanId) {
        this.decorationInspectionPlanId = decorationInspectionPlanId;
    }

    public String getDecorationInspectionPlanNum() {
        return decorationInspectionPlanNum;
    }

    public void setDecorationInspectionPlanNum(String decorationInspectionPlanNum) {
        this.decorationInspectionPlanNum = decorationInspectionPlanNum;
    }

    public String getDecorationInspectionPlanName() {
        return decorationInspectionPlanName;
    }

    public void setDecorationInspectionPlanName(String decorationInspectionPlanName) {
        this.decorationInspectionPlanName = decorationInspectionPlanName;
    }

    public String getDecorationInspectionPlanRemarks() {
        return decorationInspectionPlanRemarks;
    }

    public void setDecorationInspectionPlanRemarks(String decorationInspectionPlanRemarks) {
        this.decorationInspectionPlanRemarks = decorationInspectionPlanRemarks;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getCreUserId() {
        return creUserId;
    }

    public void setCreUserId(String creUserId) {
        this.creUserId = creUserId;
    }

    public Date getCreTme() {
        return creTme;
    }

    public void setCreTme(Date creTme) {
        this.creTme = creTme;
    }

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public Date getFailureTime() {
        return failureTime;
    }

    public void setFailureTime(Date failureTime) {
        this.failureTime = failureTime;
    }
}