package com.flf.entity;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ProductBs")
public class ProductBs {
    private String productBsId;//主键id

    private String productId;//产品id

    private String buildingStructureId;//建筑结构主键id

    private Integer state;//状态(0启用，1弃用)
    
    private Product product;//产品
    
    private BuildingStructureNew buildingStruct;//建筑结构
    
    private Page page;
    
    private String projectId;//条件查询
    
    private Integer buildingAreaA;//面积a
    
    private Integer buildingAreaB;//面积b
    
    private Integer averagePriceA;//均价a
    
    private Integer averagePriceB;//均价b
    
    private String buildingTypes;//建筑类型
    
    private List<Annex> annexs; //用于文件上传
   
    public List<Annex> getAnnexs() {
		return annexs;
	}

	public void setAnnexs(List<Annex> annexs) {
		this.annexs = annexs;
	}

	public String getBuildingTypes() {
		return buildingTypes;
	}

	public void setBuildingTypes(String buildingTypes) {
		this.buildingTypes = buildingTypes;
	}

	public Integer getBuildingAreaA() {
		return buildingAreaA;
	}

	public void setBuildingAreaA(Integer buildingAreaA) {
		this.buildingAreaA = buildingAreaA;
	}

	public Integer getBuildingAreaB() {
		return buildingAreaB;
	}

	public void setBuildingAreaB(Integer buildingAreaB) {
		this.buildingAreaB = buildingAreaB;
	}

	public Integer getAveragePriceA() {
		return averagePriceA;
	}

	public void setAveragePriceA(Integer averagePriceA) {
		this.averagePriceA = averagePriceA;
	}

	public Integer getAveragePriceB() {
		return averagePriceB;
	}

	public void setAveragePriceB(Integer averagePriceB) {
		this.averagePriceB = averagePriceB;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public BuildingStructureNew getBuildingStruct() {
		return buildingStruct;
	}

	public void setBuildingStruct(BuildingStructureNew buildingStruct) {
		this.buildingStruct = buildingStruct;
	}

	public String getProductBsId() {
        return productBsId;
    }

    public void setProductBsId(String productBsId) {
        this.productBsId = productBsId == null ? null : productBsId.trim();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getBuildingStructureId() {
        return buildingStructureId;
    }

    public void setBuildingStructureId(String buildingStructureId) {
        this.buildingStructureId = buildingStructureId == null ? null : buildingStructureId.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}