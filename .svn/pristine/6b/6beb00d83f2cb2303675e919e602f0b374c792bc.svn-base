package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

@XmlRootElement(name = "CassetRepository")
public class CassetRepository {
    private String assetRepositoryId;  //资产库id

    private String propertyId; //资产id

    private String propertyNumber; //资产编号

    private String propertyName;  //资产名称

    private String propertySpecification; //资产规格/型号
    
    private String propertyTypeId; //资产分类id
    
    private Double expirationDate;//保质期
    
    private String brand;//品牌
    
    private String producingArea;//产地
    
    private String manufacturer;//厂商
    
    private String manufacturerPhone;//厂商电话
    
    private Double propertyCount;//数量

    private String propertyArea;//面积

    private String buildingStructureId;//建筑结构id

    private String buildingComponentId;//组件id

    private String functionalId;//功能区id
    
    private String functionalName;//功能区名称
    
    private String buildingId;//建筑id
    
    private String projectId;//项目id
    
    private Integer assetOperationState;//资产运行状态  0停用 1正常 2维修
    
    private String contractId;//合同id
    
    private @DateTimeFormat(pattern="yyyy-MM-dd")Date productionDate;//资产生产日期（合同初始化用）
    
    private Double contractExpirationDate;//合同资产质保期（合同初始化用）
    
    private  @DateTimeFormat(pattern="yyyy-MM-dd")Date startUsingDate;//资产启用日期（合同初始化用）
    
    private BuildingComponent buildingComponent;//建筑组件对象
    
    private List<ComponentProperty> componentPropertys;//组件与资产信息集合
    
    private String buildingStructureString;//建筑结构字符串    
    
    public List<String> getBuildingStructureIds() {
		return buildingStructureIds;
	}

	public void setBuildingStructureIds(List<String> buildingStructureIds) {
		this.buildingStructureIds = buildingStructureIds;
	}


	private List<String> buildingStructureIds;//建筑结构

	private Contract contract;  //合同对象
    
    public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

    
    private Page page;  

    public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getAssetRepositoryId() {
        return assetRepositoryId;
    }

    public void setAssetRepositoryId(String assetRepositoryId) {
        this.assetRepositoryId = assetRepositoryId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyArea() {
        return propertyArea;
    }

    public void setPropertyArea(String propertyArea) {
        this.propertyArea = propertyArea;
    }

    public String getBuildingStructureId() {
        return buildingStructureId;
    }

    public void setBuildingStructureId(String buildingStructureId) {
        this.buildingStructureId = buildingStructureId;
    }

    public String getBuildingComponentId() {
        return buildingComponentId;
    }

    public void setBuildingComponentId(String buildingComponentId) {
        this.buildingComponentId = buildingComponentId;
    }

    public String getFunctionalId() {
        return functionalId;
    }

    public void setFunctionalId(String functionalId) {
        this.functionalId = functionalId;
    }

	public String getPropertyNumber() {
		return propertyNumber;
	}

	public void setPropertyNumber(String propertyNumber) {
		this.propertyNumber = propertyNumber;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getPropertySpecification() {
		return propertySpecification;
	}

	public void setPropertySpecification(String propertySpecification) {
		this.propertySpecification = propertySpecification;
	}

	public Double getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Double expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getProducingArea() {
		return producingArea;
	}

	public void setProducingArea(String producingArea) {
		this.producingArea = producingArea;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getManufacturerPhone() {
		return manufacturerPhone;
	}

	public void setManufacturerPhone(String manufacturerPhone) {
		this.manufacturerPhone = manufacturerPhone;
	}

	public String getFunctionalName() {
		return functionalName;
	}

	public void setFunctionalName(String functionalName) {
		this.functionalName = functionalName;
	}

	public void setPropertyCount(Double propertyCount) {
		this.propertyCount = propertyCount;
	}

	public BuildingComponent getBuildingComponent() {
		return buildingComponent;
	}

	public void setBuildingComponent(BuildingComponent buildingComponent) {
		this.buildingComponent = buildingComponent;
	}

	public List<ComponentProperty> getComponentPropertys() {
		return componentPropertys;
	}

	public void setComponentPropertys(List<ComponentProperty> componentPropertys) {
		this.componentPropertys = componentPropertys;
	}

	public String getBuildingStructureString() {
		return buildingStructureString;
	}

	public void setBuildingStructureString(String buildingStructureString) {
		this.buildingStructureString = buildingStructureString;
	}

	public String getPropertyTypeId() {
		return propertyTypeId;
	}

	public void setPropertyTypeId(String propertyTypeId) {
		this.propertyTypeId = propertyTypeId;
	}

	public Double getPropertyCount() {
		return propertyCount;
	}

	public String getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public Date getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(Date productionDate) {
		this.productionDate = productionDate;
	}

	public Double getContractExpirationDate() {
		return contractExpirationDate;
	}

	public void setContractExpirationDate(Double contractExpirationDate) {
		this.contractExpirationDate = contractExpirationDate;
	}

	public Date getStartUsingDate() {
		return startUsingDate;
	}

	public void setStartUsingDate(Date startUsingDate) {
		this.startUsingDate = startUsingDate;
	}

	public Integer getAssetOperationState() {
		return assetOperationState;
	}

	public void setAssetOperationState(Integer assetOperationState) {
		this.assetOperationState = assetOperationState;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}
}