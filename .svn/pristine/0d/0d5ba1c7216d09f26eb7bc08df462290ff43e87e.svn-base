package com.flf.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;
@XmlRootElement(name = "Communtitnotice") 	// 小区公告
public class Communtitnotice {
   

	private String id;

    private String title;

    private String briefContent;

    private String detailedInformation;

    private String founder;

    private @DateTimeFormat(pattern="yyyy-MM-dd")Date creationTime;

    private String finalModifier;

    private @DateTimeFormat(pattern="yyyy-MM-dd")Date lastModificationTime;
    
    private String abstracts;//摘要
    
    private String department;//所属部门
    
    private String project;//发布项目
    
    private Project projects;//项目
    
    public Project getProjects() {
		return projects;
	}

	public void setProjects(Project projects) {
		this.projects = projects;
	}

	public String getAbstracts() {
		return abstracts;
	}

	public void setAbstracts(String abstracts) {
		this.abstracts = abstracts;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	private Page page;
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

    public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBriefContent() {
        return briefContent;
    }

    public void setBriefContent(String briefContent) {
        this.briefContent = briefContent;
    }

    public String getDetailedInformation() {
        return detailedInformation;
    }

    public void setDetailedInformation(String detailedInformation) {
        this.detailedInformation = detailedInformation;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getFinalModifier() {
        return finalModifier;
    }

    public void setFinalModifier(String finalModifier) {
        this.finalModifier = finalModifier;
    }

    public Date getLastModificationTime() {
        return lastModificationTime;
    }

    public void setLastModificationTime(Date lastModificationTime) {
        this.lastModificationTime = lastModificationTime;
    }
}