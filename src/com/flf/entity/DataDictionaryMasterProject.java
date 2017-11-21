package com.flf.entity;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="DataDictionaryMasterProject")
public class DataDictionaryMasterProject {
	
	//主键
    private String id;

    //数据字典主表id
    private String masterId;

    //项目id
    private String projectId;
    
    private String masterName;
    
    private String description;
    
    private String status;
    
    //分页
    private Page page;
    
    //项目
    private Project project;
    
    //数据字典主表
    private DataDictionaryMaster dataDictionaryMaster;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMasterId() {
		return masterId;
	}

	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}

	public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
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

	public DataDictionaryMaster getDataDictionaryMaster() {
		return dataDictionaryMaster;
	}

	public void setDataDictionaryMaster(DataDictionaryMaster dataDictionaryMaster) {
		this.dataDictionaryMaster = dataDictionaryMaster;
	}

	public String getMasterName() {
		return masterName;
	}

	public void setMasterName(String masterName) {
		this.masterName = masterName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}