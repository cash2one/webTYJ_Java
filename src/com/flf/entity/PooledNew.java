package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="PooledNew") 
public class PooledNew {
    private String pooledId;  //公摊id

    private String pooledName;//公摊名称

    private String description;//描述

    private Double usableArea;//实用面积

    private String buildingId;//建筑id

    private String buildingStructureId;//建筑结构id

    public String getPooledId() {
        return pooledId;
    }

    public void setPooledId(String pooledId) {
        this.pooledId = pooledId;
    }

    public String getPooledName() {
        return pooledName;
    }

    public void setPooledName(String pooledName) {
        this.pooledName = pooledName;
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