package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;
@XmlRootElement(name = "PropertyType") 
public class PropertyType {    //专业资产信息表
    private String propertyTypeId;  // 资产类型id

    private String propertyTypeNumber;// 资产类型编号

    private String propertyTypeName;// 资产类型名称

    private String founder;// 创建人

    private @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")Date founderTime;// 创建时间

    private String modifier;// 修改人

    private @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")Date modifyTime;// 修改时间
    
    private String operator;//操作人
    
    private String parentId;//父节点id
    
    private PropertyType propertyType;
    
    private List<Property> propertys;//资产集合
    
    private List<PropertyType> propertyTypes;	//分类集合
    
    private PropertyType propertyTypeParent;//父类
    
    private String companyId; 

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public PropertyType getPropertyTypeParent() {
		return propertyTypeParent;
	}

	public void setPropertyTypeParent(PropertyType propertyTypeParent) {
		this.propertyTypeParent = propertyTypeParent;
	}

	private Page page;
    public Page getPage() {
    	if(this.page==null){
    		this.page=new Page();
    	}
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<Property> getPropertys() {
		return propertys;
	}

	public void setPropertys(List<Property> propertys) {
		this.propertys = propertys;
	}

	public PropertyType getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getPropertyTypeId() {
        return propertyTypeId;
    }

    public void setPropertyTypeId(String propertyTypeId) {
        this.propertyTypeId = propertyTypeId;
    }

    public String getPropertyTypeNumber() {
        return propertyTypeNumber;
    }

    public void setPropertyTypeNumber(String propertyTypeNumber) {
        this.propertyTypeNumber = propertyTypeNumber;
    }

    public String getPropertyTypeName() {
        return propertyTypeName;
    }

    public void setPropertyTypeName(String propertyTypeName) {
        this.propertyTypeName = propertyTypeName;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public Date getFounderTime() {
        return founderTime;
    }

    public void setFounderTime(Date founderTime) {
        this.founderTime = founderTime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

	public List<PropertyType> getPropertyTypes() {
		return propertyTypes;
	}

	public void setPropertyTypes(List<PropertyType> propertyTypes) {
		this.propertyTypes = propertyTypes;
	}
}