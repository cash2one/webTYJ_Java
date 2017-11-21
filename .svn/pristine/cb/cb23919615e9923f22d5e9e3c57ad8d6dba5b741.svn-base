package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 赔偿对象表
 * 创建人：邵政
 * 创建时间：2015/6/25
 */
@XmlRootElement(name = "CompensateObject")
public class CompensateObject {
    private String recordId;//记录id

    private String taskId;//关联任务id

    private String customerId;//客户id（赔偿对象）

    private Long compensateSum;//赔偿金额（赔偿给业主金额、业主索赔金额）
    
    private Tasks tasks;//关联任务表
    
    private PersonCustNew personCustNew;//关联客户基本信息表
    
    private Page page;

    public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Long getCompensateSum() {
        return compensateSum;
    }

    public void setCompensateSum(Long compensateSum) {
        this.compensateSum = compensateSum;
    }

	public Tasks getTasks() {
		return tasks;
	}

	public void setTasks(Tasks tasks) {
		this.tasks = tasks;
	}

	public PersonCustNew getPersonCustNew() {
		return personCustNew;
	}

	public void setPersonCustNew(PersonCustNew personCustNew) {
		this.personCustNew = personCustNew;
	}
    
}