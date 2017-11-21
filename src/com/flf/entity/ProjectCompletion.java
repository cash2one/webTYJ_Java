package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 项目完成情况记录表
 * @author 王洲
 *
 */

@XmlRootElement(name = "ProjectCompletion")
public class ProjectCompletion {

	//id
	private String id;
	
	//项目id
	private String projectId;
	
	//公司id
	private String companyId;
	
	//面积类型完成情况
	private Integer areaType;
	
	//建筑完成情况
	private Integer building;
	
	//个人客户完成情况
	private Integer person;
	
	//企业客户完成情况
	private Integer enterprise;
	
	//资产绑定完成情况
	private Integer assetbinding;
	
	//设置传入参数的类型
	private String paramTypes;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public Integer getAreaType() {
		return areaType;
	}

	public void setAreaType(Integer areaType) {
		this.areaType = areaType;
	}

	public Integer getBuilding() {
		return building;
	}

	public void setBuilding(Integer building) {
		this.building = building;
	}

	public Integer getPerson() {
		return person;
	}

	public void setPerson(Integer person) {
		this.person = person;
	}

	public Integer getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Integer enterprise) {
		this.enterprise = enterprise;
	}

	public Integer getAssetbinding() {
		return assetbinding;
	}

	public void setAssetbinding(Integer assetbinding) {
		this.assetbinding = assetbinding;
	}

	public String getParamTypes() {
		return paramTypes;
	}

	public void setParamTypes(String paramTypes) {
		this.paramTypes = paramTypes;
	}

}
