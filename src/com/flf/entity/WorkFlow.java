package com.flf.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "WorkFlow")
public class WorkFlow {
    private String workflowId;//工作流ID

    private String workflowName;//工作流名称

    private String status;//状态--0不可配置--1可以配置

    private String comments;//解释

    private String createId;//创建人ID

    private Date createTime;//创建时间

    private String updateId;//修改人ID

    private Date updateTime;//修改时间
    
    private Page page;
    

    public Page getPage() {
		if(this.page==null){
    		this.page=new Page();
		}
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(String workflowId) {
        this.workflowId = workflowId;
    }

    public String getWorkflowName() {
        return workflowName;
    }

    public void setWorkflowName(String workflowName) {
        this.workflowName = workflowName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}