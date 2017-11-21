/**
 * @Title: Pet.java
 * @Package com.flf.entity
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author gengxiaojiang
 * @date 2015-4-24 上午10:28:35
 * @version V1.0
 */

package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @ClassName: PetRegistration
 * @Description: <p>宠物信息实体类</p>
 * @author 朱伟
 * @date 2015-11-17 下午20:55:35
 * 
 */
@XmlRootElement(name = "PetRegistration")
public class PetRegistration {
	private String petId;//主键ID
	
	private String petName;// 宠物姓名

	private String petType;// 宠物类型

	private String petNo;// 宠物证件号

	private String petSex;// 宠物性别

	private String petDescribe;// 宠物描述

	private String custId;// 登记人

	private String personBuildingId;// 客户房屋关系表id

	private @DateTimeFormat(pattern = "yyyy-MM-dd")
	 Date registrationTime;// 登记时间
	
    private String petPic; //宠物图片
	
    private String petStatus;//宠物删除状态
    
    private Page page;
    
    private BuildingStructureNew buildingStructureNew;//关联建筑结构
    
    private PersonCustNew personCustNew;
    
	private String name;//登记人姓名（查询用）
    
    private String phone;//登记人号码（查询用）
    
    private String petBreeds;//宠物品种
    
    private List<Annex> annexs;//
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPetId() {
		return petId;
	}

	public void setPetId(String petId) {
		this.petId = petId;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getPetType() {
		return petType;
	}

	public void setPetType(String petType) {
		this.petType = petType;
	}

	public String getPetNo() {
		return petNo;
	}

	public void setPetNo(String petNo) {
		this.petNo = petNo;
	}

	public String getPetSex() {
		return petSex;
	}

	public void setPetSex(String petSex) {
		this.petSex = petSex;
	}

	public String getPetDescribe() {
		return petDescribe;
	}

	public void setPetDescribe(String petDescribe) {
		this.petDescribe = petDescribe;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getPersonBuildingId() {
		return personBuildingId;
	}

	public void setPersonBuildingId(String personBuildingId) {
		this.personBuildingId = personBuildingId;
	}

	public Date getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(Date registrationTime) {
		this.registrationTime = registrationTime;
	}

	public String getPetPic() {
		return petPic;
	}

	public void setPetPic(String petPic) {
		this.petPic = petPic;
	}

	public String getPetStatus() {
		return petStatus;
	}

	public void setPetStatus(String petStatus) {
		this.petStatus = petStatus;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public BuildingStructureNew getBuildingStructureNew() {
		return buildingStructureNew;
	}

	public void setBuildingStructureNew(BuildingStructureNew buildingStructureNew) {
		this.buildingStructureNew = buildingStructureNew;
	}

	public PersonCustNew getPersonCustNew() {
		return personCustNew;
	}

	public void setPersonCustNew(PersonCustNew personCustNew) {
		this.personCustNew = personCustNew;
	}

	public String getPetBreeds() {
		return petBreeds;
	}

	public void setPetBreeds(String petBreeds) {
		this.petBreeds = petBreeds;
	}

	public List<Annex> getAnnexs() {
		return annexs;
	}

	public void setAnnexs(List<Annex> annexs) {
		this.annexs = annexs;
	}
    

}
