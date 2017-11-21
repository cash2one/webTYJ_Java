package com.flf.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 数据字典表--主表
 * @author wangzhou
 *
 */
@XmlRootElement(name="DataDictionaryMaster")
public class DataDictionaryMaster {
	
	//主键id
    private String masterId;

    //类型名称
    private String masterName;

    //状态；0/启用，1禁用
    private String status;
    
    //描述
    private String description;

    //创建人id
    private String createId;

    //创建时间
    private Date createTime;

    //修改人id
    private String updateId;

    //修改时间
    private Date updateTime;
    
    //分页属性
    private Page page;
    
    //关联项目
    private Project project;
    
    private TUser createStaff;
    
    private TUser updateStaff;

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public TUser getCreateStaff() {
		return createStaff;
	}

	public void setCreateStaff(TUser createStaff) {
		this.createStaff = createStaff;
	}

	public TUser getUpdateStaff() {
		return updateStaff;
	}

	public void setUpdateStaff(TUser updateStaff) {
		this.updateStaff = updateStaff;
	}

	
}