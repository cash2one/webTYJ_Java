package com.flf.entity;
import java.util.List;



/* Created by Administrator on 2015/6/15. 
author:尹磊
修改时间：2015/6/15  修改人：尹磊 */
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "WaterMeter")
public class WaterMeter {
	
    private String waterMeterId;//水表表

    private String assetsId; //资产id 

    private String waterMeterNum; //水表编号

    private Integer state;  //表状态  0.  1.新建 2.使用中 3.停用 4.未使用

    private Double ratio;  //倍率

    private Double max; //最大数值

    private Double min;  //最小数值
    
    private WaterMeterRecords waterMeterRecords; // 水表使用记录
    
    private String propertyNumber;
    
    private String propertySpecification;
    
    private String brand;
    
    private Property property ; //资产信息
    
    private Integer whetherRepeatedUse;//是否循环使用
    
    private String operator;//操作人

    private String propertyName;  //资产名称
    private Double expirationDate;//保质期
    private String producingArea;//产地

    private String manufacturer;//厂商

    private String manufacturerPhone;//厂商电话
    
    private String fullName;
    
    private Page page;
    
    private List<WaterMeterRecords> waterMeterRecord;//
    
    private String buildingStructureId; //建筑结构id
    
    private String waterMeterRecordsId; // 水表使用记录id
    
    private String custId;//客户id
    
    private String id;//建筑结构的主键
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

    private String publicWater;//是否公共用水表 0否 1是
    
    public String getBuildingStructureId() {
		return buildingStructureId;
	}

	public void setBuildingStructureId(String buildingStructureId) {
		this.buildingStructureId = buildingStructureId;
	}

	public String getWaterMeterRecordsId() {
		return waterMeterRecordsId;
	}

	public void setWaterMeterRecordsId(String waterMeterRecordsId) {
		this.waterMeterRecordsId = waterMeterRecordsId;
	}

	public List<WaterMeterRecords> getWaterMeterRecord() {
		return waterMeterRecord;
	}

	public void setWaterMeterRecord(List<WaterMeterRecords> waterMeterRecord) {
		this.waterMeterRecord = waterMeterRecord;
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

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public Double getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Double expirationDate) {
		this.expirationDate = expirationDate;
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

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public WaterMeterRecords getWaterMeterRecords() {
		return waterMeterRecords;
	}

	public void setWaterMeterRecords(WaterMeterRecords waterMeterRecords) {
		this.waterMeterRecords = waterMeterRecords;
	}

	public String getWaterMeterId() {
        return waterMeterId;
    }

    public void setWaterMeterId(String waterMeterId) {
        this.waterMeterId = waterMeterId;
    }

    public String getAssetsId() {
        return assetsId;
    }

    public void setAssetsId(String assetsId) {
        this.assetsId = assetsId;
    }

    public String getWaterMeterNum() {
        return waterMeterNum;
    }

    public void setWaterMeterNum(String waterMeterNum) {
        this.waterMeterNum = waterMeterNum;
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

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getPublicWater() {
		return publicWater;
	}

	public void setPublicWater(String publicWater) {
		this.publicWater = publicWater;
	}
}