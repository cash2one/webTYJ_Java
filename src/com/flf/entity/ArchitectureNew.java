package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ArchitectureNew") 
public class ArchitectureNew {
    private String architectureId;  //公建信息id

    private String architectureName; //公建名称

    private String description; //位置描述

    private Double usableArea; //实用面积

    private String buildingId; //建筑id

    private String buildingStructureId; //建筑结构id

    public String getArchitectureId() {
        return architectureId;
    }

    public void setArchitectureId(String architectureId) {
        this.architectureId = architectureId;
    }

    public String getArchitectureName() {
        return architectureName;
    }

    public void setArchitectureName(String architectureName) {
        this.architectureName = architectureName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(Double usableArea) {
        this.usableArea = usableArea;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(String buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingStructureId() {
        return buildingStructureId;
    }

    public void setBuildingStructureId(String buildingStructureId) {
        this.buildingStructureId = buildingStructureId;
    }
}