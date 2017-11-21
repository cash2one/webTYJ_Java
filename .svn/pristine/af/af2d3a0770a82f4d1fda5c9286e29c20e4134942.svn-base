package com.flf.request;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.flf.entity.Property;
import com.flf.entity.PropertyType;

@XmlRootElement(name = "PropertyTypeResult") 
public class PropertyTypeResult {
	private  List<PropertyType> propertyTypes;//专业集合
	
	private Property property;//资产信息
	
	private String propertyTypeParent;//专业名称
	
	private String propertyTypeSon;//分类名称
	
	private String companyId;//公司ID
	
	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public List<PropertyType> getPropertyTypes() {
		return propertyTypes;
	}

	public void setPropertyTypes(List<PropertyType> propertyTypes) {
		this.propertyTypes = propertyTypes;
	}

	public String getPropertyTypeParent() {
		return propertyTypeParent;
	}

	public void setPropertyTypeParent(String propertyTypeParent) {
		this.propertyTypeParent = propertyTypeParent;
	}

	public String getPropertyTypeSon() {
		return propertyTypeSon;
	}

	public void setPropertyTypeSon(String propertyTypeSon) {
		this.propertyTypeSon = propertyTypeSon;
	}
	
	
}
