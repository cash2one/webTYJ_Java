package com.flf.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 数据字典表--从表
 * @author wangzhou
 *
 */
@XmlRootElement(name="DataDictionarySlave")
public class DataDictionarySlave {
	
	//类型属性id
    private String slaveId;

    //类型属性名称
    private String slaveName;

    //关联类型id
    private String masterId;
    
    //项目id
    private String projectId;
    
    //数据字典表
    private DataDictionaryMaster dataDictionaryMaster;

    //状态
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
    
    //项目表关联
    private Project project;
    
    //查询条件从表值
    private String sName;
    
    //查询条件从表描述
    private String desc;
    
    //创建人对象
    private TUser createStaff;  
    
    //修改人对象
    private TUser updateStaff;

    public String getSlaveId() {
        return slaveId;
    }

    public void setSlaveId(String slaveId) {
        this.slaveId = slaveId;
    }

    public String getSlaveName() {
        return slaveName;
    }

    public void setSlaveName(String slaveName) {
        this.slaveName = slaveName;
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
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

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
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

	public DataDictionaryMaster getDataDictionaryMaster() {
		return dataDictionaryMaster;
	}

	public void setDataDictionaryMaster(DataDictionaryMaster dataDictionaryMaster) {
		this.dataDictionaryMaster = dataDictionaryMaster;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
}