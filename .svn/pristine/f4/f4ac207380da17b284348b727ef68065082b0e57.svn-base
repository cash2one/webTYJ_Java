package com.flf.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 服务请求日志表
 * 创建人：邵政
 * 创建时间:2015/6/23
 */
@XmlRootElement(name = "ServiceRequestJournal")
public class ServiceRequestJournal {
    private String serviceRequestJournalId;//服务请求日志id

    private String serviceRequestId;//服务请求id

    private String operatorId;//操作人id
    private String userId;//超级管理员操作人id
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date operationTime;//操作时间

    private String creTaskId;//创建任务id

    private Integer creTaskType;//创建的任务类型

    private Integer changeState;//状态修改

    private String remarks;//备注描述
      
    private Page page;

    public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

    public String getServiceRequestJournalId() {
        return serviceRequestJournalId;
    }

    public void setServiceRequestJournalId(String serviceRequestJournalId) {
        this.serviceRequestJournalId = serviceRequestJournalId;
    }

    public String getServiceRequestId() {
        return serviceRequestId;
    }

    public void setServiceRequestId(String serviceRequestId) {
        this.serviceRequestId = serviceRequestId;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    public String getCreTaskId() {
        return creTaskId;
    }

    public void setCreTaskId(String creTaskId) {
        this.creTaskId = creTaskId;
    }

    public Integer getCreTaskType() {
		return creTaskType;
	}

	public void setCreTaskType(Integer creTaskType) {
		this.creTaskType = creTaskType;
	}

	public Integer getChangeState() {
		return changeState;
	}

	public void setChangeState(Integer changeState) {
		this.changeState = changeState;
	}

	public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}