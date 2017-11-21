package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="ExecutionTimeRecords")
public class ExecutionTimeRecords {
    private String executiveNumId;//执行次数id

    private String serviceRequestId;//关联服务请求id

    private String executionFrequencyId;//关联服务请求执行频率率id

    private Byte executiveNum;//执行次数序号

    private String executiveNumTime;//执行时间
    
    private Date nextExecutiveTime; //下次执行时间
    private Page page;//页面分页
    
    
    public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getExecutiveNumId() {
        return executiveNumId;
    }

    public void setExecutiveNumId(String executiveNumId) {
        this.executiveNumId = executiveNumId;
    }

    public String getServiceRequestId() {
        return serviceRequestId;
    }

    public void setServiceRequestId(String serviceRequestId) {
        this.serviceRequestId = serviceRequestId;
    }

    public String getExecutionFrequencyId() {
		return executionFrequencyId;
	}

	public void setExecutionFrequencyId(String executionFrequencyId) {
		this.executionFrequencyId = executionFrequencyId;
	}

	public Byte getExecutiveNum() {
        return executiveNum;
    }

    public void setExecutiveNum(Byte executiveNum) {
        this.executiveNum = executiveNum;
    }



	public String getExecutiveNumTime() {
		return executiveNumTime;
	}

	public void setExecutiveNumTime(String executiveNumTime) {
		this.executiveNumTime = executiveNumTime;
	}

	public Date getNextExecutiveTime() {
		return nextExecutiveTime;
	}

	public void setNextExecutiveTime(Date nextExecutiveTime) {
		this.nextExecutiveTime = nextExecutiveTime;
	}
    
}