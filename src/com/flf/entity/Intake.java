package com.flf.entity;
/**
 * 创建 by xiaocong   
 * date   2015-6-16
 */

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Intake")
// 入伙表
public class Intake {
	private String intakeId;//入伙id

	private String houseId;//建筑结构id

	private Date startDate;//入伙开始时间

	private Date endDate;//入伙结束时间

	private Integer intakeState;//入伙状态

	private Double intakeAmount;//缴纳总金额

	private Double intakePrice;//入伙单价

	private String staffId;//员工id

	private String transActor;//办理人
	
	private Page page;
	
	 private Date operateDate;//操作时间
	 
	 private List<String> buildingStructureId;//建筑结构id集合
	 
	 private List<HouseArticle> houseArticle; //房屋入伙物品集合
	
	private String fullName; //房屋全名
	
	private String projectName ; //项目名称
	
	private String buildingType ; //房屋类型
	
	private String staffName ; //员工姓名

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getBuildingType() {
		return buildingType;
	}

	public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public List<String> getBuildingStructureId() {
		return buildingStructureId;
	}

	public void setBuildingStructureId(List<String> buildingStructureId) {
		this.buildingStructureId = buildingStructureId;
	}

	public List<HouseArticle> getHouseArticle() {
		return houseArticle;
	}

	public void setHouseArticle(List<HouseArticle> houseArticle) {
		this.houseArticle = houseArticle;
	}

		public Date getOperateDate() {
			return operateDate;
		}

		public void setOperateDate(Date operateDate) {
			this.operateDate = operateDate;
		}
	

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getTransActor() {
		return transActor;
	}

	public void setTransActor(String transActor) {
		this.transActor = transActor;
	}

	public String getIntakeId() {
		return intakeId;
	}

	public void setIntakeId(String intakeId) {
		this.intakeId = intakeId;
	}

	public String getHouseId() {
		return houseId;
	}

	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getIntakeState() {
		return intakeState;
	}

	public void setIntakeState(Integer intakeState) {
		this.intakeState = intakeState;
	}

	public Double getIntakeAmount() {
		return intakeAmount;
	}

	public void setIntakeAmount(Double intakeAmount) {
		this.intakeAmount = intakeAmount;
	}

	public Double getIntakePrice() {
		return intakePrice;
	}

	public void setIntakePrice(Double intakePrice) {
		this.intakePrice = intakePrice;
	}
}