package com.flf.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
//合同资产建筑结构关系表
@XmlRootElement(name = "ContractPropertyStructure")
public class ContractPropertyStructure {
    private String id;//主键

    private String contractId;//合同id

    private String propertyId;//资产id

    private String buildingStructureId;//建筑结构id
    private String functionalId;//功能区域Id
    private Date startTime;//启动时间
    private Property property;  //资产对象
    private Functional functional; 
    private BuildingStructureNew buildingStructureNew; //建筑结构表
    
    private Page page;

    
    
    public Functional getFunctional() {
		return functional;
	}

	public void setFunctional(Functional functional) {
		this.functional = functional;
	}

	public String getFunctionalId() {
		return functionalId;
	}

	public void setFunctionalId(String functionalId) {
		this.functionalId = functionalId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public BuildingStructureNew getBuildingStructureNew() {
		return buildingStructureNew;
	}

	public void setBuildingStructureNew(BuildingStructureNew buildingStructureNew) {
		this.buildingStructureNew = buildingStructureNew;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
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

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getBuildingStructureId() {
        return buildingStructureId;
    }

    public void setBuildingStructureId(String buildingStructureId) {
        this.buildingStructureId = buildingStructureId;
    }
}