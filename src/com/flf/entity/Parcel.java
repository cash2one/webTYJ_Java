package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Parcel")
public class Parcel {
    private String parcelId;//宗地ID

    private String projectId;//关联项目ID

    private String parcelNum;//宗地编号

    private Double stallMatching;//车位配比

    private Double parcelArea;//宗地面积

    private Double civilAirDefenceArea;//人防面积

    private Double floorArea;//占地面积

    private Double buildArea;//建筑面积

    private Double roadArea;//道路面积

    private Double greeningArea;//绿化面积

    private Integer groundParkingSpace;//地面车位

    private Integer undergroundParkingSpace;//地下车位

    private Double plotRatio;//容积率
    
    private Project project;// 关联项目表
    private double basementArea;//实际地下室面积
    
    public double getBasementArea() {
		return basementArea;
	}

	public void setBasementArea(double basementArea) {
		this.basementArea = basementArea;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getParcelId() {
        return parcelId;
    }

    public void setParcelId(String parcelId) {
        this.parcelId = parcelId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getParcelNum() {
        return parcelNum;
    }

    public void setParcelNum(String parcelNum) {
        this.parcelNum = parcelNum;
    }

    public Double getStallMatching() {
        return stallMatching;
    }

    public void setStallMatching(Double stallMatching) {
        this.stallMatching = stallMatching;
    }

    public Double getParcelArea() {
        return parcelArea;
    }

    public void setParcelArea(Double parcelArea) {
        this.parcelArea = parcelArea;
    }

    public Double getCivilAirDefenceArea() {
        return civilAirDefenceArea;
    }

    public void setCivilAirDefenceArea(Double civilAirDefenceArea) {
        this.civilAirDefenceArea = civilAirDefenceArea;
    }

    public Double getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Double floorArea) {
        this.floorArea = floorArea;
    }

    public Double getBuildArea() {
        return buildArea;
    }

    public void setBuildArea(Double buildArea) {
        this.buildArea = buildArea;
    }

    public Double getRoadArea() {
        return roadArea;
    }

    public void setRoadArea(Double roadArea) {
        this.roadArea = roadArea;
    }

    public Double getGreeningArea() {
        return greeningArea;
    }

    public void setGreeningArea(Double greeningArea) {
        this.greeningArea = greeningArea;
    }

    public Integer getGroundParkingSpace() {
        return groundParkingSpace;
    }

    public void setGroundParkingSpace(Integer groundParkingSpace) {
        this.groundParkingSpace = groundParkingSpace;
    }

    public Integer getUndergroundParkingSpace() {
        return undergroundParkingSpace;
    }

    public void setUndergroundParkingSpace(Integer undergroundParkingSpace) {
        this.undergroundParkingSpace = undergroundParkingSpace;
    }

    public Double getPlotRatio() {
        return plotRatio;
    }

    public void setPlotRatio(Double plotRatio) {
        this.plotRatio = plotRatio;
    }
}