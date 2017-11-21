package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;

//面积�?
@XmlRootElement(name = "AreaNew") 
public class AreaNew {
    private String id;
    private String buildingId;//建筑id
    private String areaTypeId;//面积类型id
    private Double buildingArea;//建筑面积
    private Double commonalityArea;//公摊面积
    private Double insideArea;//套内面积

    private Double utilityRatio;//实用率
    
    private AreaTypeNew areaTypeNew;
    
    private Page page;

    public AreaTypeNew getAreaTypeNew() {
		return areaTypeNew;
	}

	public void setAreaTypeNew(AreaTypeNew areaTypeNew) {
		this.areaTypeNew = areaTypeNew;
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

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public String getAreaTypeId() {
        return areaTypeId;
    }

    public void setAreaTypeId(String areaTypeId) {
        this.areaTypeId = areaTypeId;
    }

    public Double getBuildingArea() {
        return buildingArea;
    }

    public void setBuildingArea(Double buildingArea) {
        this.buildingArea = buildingArea;
    }

    public Double getCommonalityArea() {
        return commonalityArea;
    }

    public void setCommonalityArea(Double commonalityArea) {
        this.commonalityArea = commonalityArea;
    }

    public Double getInsideArea() {
        return insideArea;
    }

    public void setInsideArea(Double insideArea) {
        this.insideArea = insideArea;
    }

    public Double getUtilityRatio() {
        return utilityRatio;
    }

    public void setUtilityRatio(Double utilityRatio) {
        this.utilityRatio = utilityRatio;
    }
}