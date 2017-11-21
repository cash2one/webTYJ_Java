package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "BuildingComponent") 
public class BuildingComponent {
    private String componentId;  //建筑组件id

    private String componentNum; //建筑组件编码

    private String componentName; //建筑组件名称

    private String componentType; //建筑组件类型id(建筑面积属性)

    private String createId; //创建人id 王洲 2016.1.6

    private Date createrDate; //创建时间

    private String updateId; //修改人id 王洲 2016.1.6

    private Date updateDate; //修改时间
    
    private Date sortDate;
    
    private List<ComponentProperty> componentPropertys;  //组件与资产信息集合
    
    private List<BuildingStructureNew> buildingStructureNews;//建筑结构对象集合
    
    private Page page;  //分页

    private String areaTypeName; //建筑组件类型名称
    
    private String propertyNum;//资产编号
    
    private String propertyNumber;//资产数量
    
    private String propertyArea;//资产单位
    
    private String functionalName;//功能区名称
    
    private String cId;//导入时判断根据
    
    private TUser createUser;//关联创建人id
    
    private TUser updateUser;//关联修改人id
    
    //关联功能区编号、资产名称、资产规格、一级专业分类编号及名称、二级专业分类编号及名称用于导出 start    王洲   2016.1.11
    
    private String functionalNo;
    
    private String propertyName;
    
    private String propertySpecification;
    
    private String propertyTypeNumber;
    
    private String propertyTypeNumbers;
    
    private String propertyTypeName;
    
    private String propertyTypeNames;
    
    private String createrName;
    
  //关联功能区编号、资产名称、资产规格、一级专业分类编号及名称、二级专业分类编号及名称用于导出 end    王洲   2016.1.11

    
	public List<BuildingStructureNew> getBuildingStructureNews() {
		return buildingStructureNews;
	}


	public String getCreaterName() {
		return createrName;
	}


	public void setCreaterName(String createrName) {
		this.createrName = createrName;
	}


	public void setBuildingStructureNews(
			List<BuildingStructureNew> buildingStructureNews) {
		this.buildingStructureNews = buildingStructureNews;
	}

	public List<ComponentProperty> getComponentPropertys() {
		return componentPropertys;
	}

	public void setComponentPropertys(List<ComponentProperty> componentPropertys) {
		this.componentPropertys = componentPropertys;
	}

	public Page getPage() {
		if(this.page==null){
			this.page=new Page();
		}
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId;
    }

    public String getComponentNum() {
        return componentNum;
    }

    public void setComponentNum(String componentNum) {
        this.componentNum = componentNum;
    }

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public String getComponentType() {
        return componentType;
    }

    public void setComponentType(String componentType) {
        this.componentType = componentType;
    }

    public String getCreateId() {
		return createId;
	}

	public void setCreateId(String createId) {
		this.createId = createId;
	}

	public Date getCreaterDate() {
        return createrDate;
    }

    public void setCreaterDate(Date createrDate) {
        this.createrDate = createrDate;
    }

    public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

	public String getAreaTypeName() {
		return areaTypeName;
	}

	public void setAreaTypeName(String areaTypeName) {
		this.areaTypeName = areaTypeName;
	}

	public String getPropertyNum() {
		return propertyNum;
	}

	public void setPropertyNum(String propertyNum) {
		this.propertyNum = propertyNum;
	}

	public String getPropertyNumber() {
		return propertyNumber;
	}

	public void setPropertyNumber(String propertyNumber) {
		this.propertyNumber = propertyNumber;
	}

	public String getPropertyArea() {
		return propertyArea;
	}

	public void setPropertyArea(String propertyArea) {
		this.propertyArea = propertyArea;
	}

	public String getFunctionalName() {
		return functionalName;
	}

	public void setFunctionalName(String functionalName) {
		this.functionalName = functionalName;
	}

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	

	public Date getSortDate() {
		return sortDate;
	}

	public void setSortDate(Date sortDate) {
		this.sortDate = sortDate;
	}

	public TUser getCreateUser() {
		return createUser;
	}

	public void setCreateUser(TUser createUser) {
		this.createUser = createUser;
	}

	public TUser getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(TUser updateUser) {
		this.updateUser = updateUser;
	}

	public String getFunctionalNo() {
		return functionalNo;
	}

	public void setFunctionalNo(String functionalNo) {
		this.functionalNo = functionalNo;
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

	public String getPropertyTypeNumber() {
		return propertyTypeNumber;
	}

	public void setPropertyTypeNumber(String propertyTypeNumber) {
		this.propertyTypeNumber = propertyTypeNumber;
	}

	public String getPropertyTypeNumbers() {
		return propertyTypeNumbers;
	}

	public void setPropertyTypeNumbers(String propertyTypeNumbers) {
		this.propertyTypeNumbers = propertyTypeNumbers;
	}

	public String getPropertyTypeName() {
		return propertyTypeName;
	}

	public void setPropertyTypeName(String propertyTypeName) {
		this.propertyTypeName = propertyTypeName;
	}

	public String getPropertyTypeNames() {
		return propertyTypeNames;
	}

	public void setPropertyTypeNames(String propertyTypeNames) {
		this.propertyTypeNames = propertyTypeNames;
	}
    
    
}