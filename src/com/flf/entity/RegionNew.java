package com.flf.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
//区域表表
@XmlRootElement(name = "RegionNew")
public class RegionNew {
    private String id;  //区域id

    private String projectId; //项目id

    private String regionName; //区域名称
    
    private List<BuildingNew> buildingNews;  //建筑对象集合 加入分区后的楼栋
    
    
    private Page page;
    
    public List<BuildingNew> getBuildingNews() {
		return buildingNews;
	}

	public void setBuildingNews(List<BuildingNew> buildingNews) {
		this.buildingNews = buildingNews;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
    
}