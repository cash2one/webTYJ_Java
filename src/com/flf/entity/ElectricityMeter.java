package com.flf.entity;

import java.util.List;

/* Created by Administrator on 2015/6/15. 
author:尹磊
修改时间：2015/7/22  修改人：倪明 */
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ElectricityMeter")
public class ElectricityMeter {

	private String electricityMeterId; // 电表id

	private String assetsId; // 资产id

	private String electricityMeterNum; // 电表编号
	
    private Integer state;  //表状态  0.  1.新建 2.使用中 3.停用 4.未使用

	private Double ratio; // 倍率

	private Double max; // 最大数值

	private Double min; // 最小数值

	private Integer whetherRepeatedUse;// 是否循环使用

	private String operator;// 操作人

	private ElectricityMeterRecords electricityMeterRecords; // 电表使用记录
	
	private String id;// 建筑结构的主键


    
    private String propertyNumber;
    
    private String propertySpecification;
    
    private String brand;
    
    private Property property ; //资产信息
    private String fullName;
    private String buildingStructureId; //建筑结构id
    private String electricityMeterRecordsId;
    
    private Page page;
    
    private String custId; //客户Id
    
    private String propertyName;  //资产名称
    
    public String getId() {
    	return id;
    }
    
    public void setId(String id) {
    	this.id = id;
    }
    public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}
    
    public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	public String getPropertyNumber() {
		return propertyNumber;
	}

	public void setPropertyNumber(String propertyNumber) {
		this.propertyNumber = propertyNumber;
	}

	public String getPropertySpecification() {
		return propertySpecification;
	}

	public void setPropertySpecification(String propertySpecification) {
		this.propertySpecification = propertySpecification;
	}
	
	public Integer getWhetherRepeatedUse() {
		return whetherRepeatedUse;
	}

	public void setWhetherRepeatedUse(Integer whetherRepeatedUse) {
		this.whetherRepeatedUse = whetherRepeatedUse;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getBuildingStructureId() {
		return buildingStructureId;
	}

	public void setBuildingStructureId(String buildingStructureId) {
		this.buildingStructureId = buildingStructureId;
	}

	public String getElectricityMeterRecordsId() {
		return electricityMeterRecordsId;
	}

	public void setElectricityMeterRecordsId(String electricityMeterRecordsId) {
		this.electricityMeterRecordsId = electricityMeterRecordsId;
	}

	public String getElectricityMeterId() {
		return electricityMeterId;
	}

	public void setElectricityMeterId(String electricityMeterId) {
		this.electricityMeterId = electricityMeterId;
	}

	public String getAssetsId() {
		return assetsId;
	}

	public void setAssetsId(String assetsId) {
		this.assetsId = assetsId;
	}

	public String getElectricityMeterNum() {
		return electricityMeterNum;
	}

	public void setElectricityMeterNum(String electricityMeterNum) {
		this.electricityMeterNum = electricityMeterNum;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Double getRatio() {
		return ratio;
	}

	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}

	public Double getMax() {
		return max;
	}

	public void setMax(Double max) {
		this.max = max;
	}

	public Double getMin() {
		return min;
	}

	public void setMin(Double min) {
		this.min = min;
	}

	public ElectricityMeterRecords getElectricityMeterRecords() {
		return electricityMeterRecords;
	}

	public void setElectricityMeterRecords(ElectricityMeterRecords electricityMeterRecords) {
		this.electricityMeterRecords = electricityMeterRecords;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

}