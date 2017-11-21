package com.flf.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.flf.request.Tree;

//建筑�?
@XmlRootElement(name = "BuildingNew") 
public class BuildingNew {
    private String id; //建筑主键
    private String buildingNum;//建筑编号
    private String buildingName;//建筑名称
    private String regionId;//区域id
    private String stageId;//期id
    private Double buildingArea;//总建筑面积  王洲  2016.1.7
    private Double totalArea;//总用地面积
    private Double commonalityArea;//公摊面积
    private Double insideArea;//套内面积
    private Double completionArea;//竣工面积
    private Double utilityRatio;//实用率
    private String projectId;//项目id
    
    private String parcelId;//关联宗地id  王洲   2016.2.2
    
    private List<BuildingStructureNew> buildingStructureNews; //建筑结构集合
    
    private List<AreaNew> areaNew;
    
    private List<Tree> treeList;//建筑结构树
    
    private String isFinish;//建筑初始化，数据迁移使用字段  0新数据/1迁移数据  王洲  2016.03.24
	
	public String getIsFinish() {
		return isFinish;
	}
	public void setIsFinish(String isFinish) {
		this.isFinish = isFinish;
	}

	public List<BuildingStructureNew> getBuildingStructureNews() {
		return buildingStructureNews;
	}

	public void setBuildingStructureNews(
			List<BuildingStructureNew> buildingStructureNews) {
		this.buildingStructureNews = buildingStructureNews;
	}

	public List<AreaNew> getAreaNew() {
		return areaNew;
	}

	public void setAreaNew(List<AreaNew> areaNew) {
		this.areaNew = areaNew;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	private Page page;
    
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

    public String getBuildingNum() {
        return buildingNum;
    }

    public void setBuildingNum(String buildingNum) {
        this.buildingNum = buildingNum;
    }
    
    public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getStageId() {
        return stageId;
    }

    public void setStageId(String stageId) {
        this.stageId = stageId;
    }

    public Double getBuildingArea() {
        return buildingArea;
    }

    public void setBuildingArea(Double buildingArea) {
        this.buildingArea = buildingArea;
    }

    public Double getTotalArea() {
		return totalArea;
	}

	public void setTotalArea(Double totalArea) {
		this.totalArea = totalArea;
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

    public Double getCompletionArea() {
        return completionArea;
    }

    public void setCompletionArea(Double completionArea) {
        this.completionArea = completionArea;
    }

    public Double getUtilityRatio() {
        return utilityRatio;
    }

    public void setUtilityRatio(Double utilityRatio) {
        this.utilityRatio = utilityRatio;
    }

	public List<Tree> getTreeList() {
		return treeList;
	}

	public void setTreeList(List<Tree> treeList) {
		this.treeList = treeList;
	}

	public String getParcelId() {
		return parcelId;
	}

	public void setParcelId(String parcelId) {
		this.parcelId = parcelId;
	}
    
    
}