package com.flf.entity;
/**
 * 创建 by 肖聪 2015/6/4
 * 添加产权变更实体类
 */
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
//产权变更
@XmlRootElement(name = "ChangeTitle") 

public class ChangeTitle {
   

	private String id;          //产权变更id

    private String houseId;      //房屋id

    private String pactId;    //合同编号
 
    private Date buyDate;       //认购时间

    private Date signContractDate;  //签约时间

    private String custName;   //原产权归属人名字

    private String newCustName;//新产权归属人名字

    private String custId;//原产权归属人id

    private String newCustId;//新产权归属人id

    private Float registrationPrice;//登记价

    private Float houseAfterFoldingPrice;//房屋折后实价

    private Float buildingAreaPrice;//建筑面积价格

    private Float setinBuildingPrice;//套内面积单价

    private String dealType;//交易类型

    private String paymentType;//付款方式

    private Float downPaymentPrice;//首付金额

    private String propertyType;//产权类型  1为车位，2为房屋

    private String pactScan;//上传合同扫描

    private String propertyScan;//上传房产扫描

    private String stallId;// 车位id
    
    private Integer arrearagePay;// 欠费承担人

	private Page page;
	
    private Date operateDate;//操作时间
    
    private  PersonBuildingNew personBuildingNew;//人员建筑关系对象
    
    

	private String storeId;//商铺id
	
	private String fullName;//全名
	
	private Byte state;//状态
	
	private Double buildingArea;//建筑面积
	
	private String houseNum;//房屋编号
	
	private String garageNumber;//车位编号
	
	private String storeNumber;//商铺编号
	
	private String buildingType;//建筑类型
	
	private Byte joinGangState;//
	
	private Byte storeIntakeState;
	
	private Byte stallIntakeState;
	
	private String stallCoding;
	
	private String stallType;
	
	public String getStallCoding() {
		return stallCoding;
	}

	public void setStallCoding(String stallCoding) {
		this.stallCoding = stallCoding;
	}

	public String getStallType() {
		return stallType;
	}

	public void setStallType(String stallType) {
		this.stallType = stallType;
	}

	public Byte getJoinGangState() {
		return joinGangState;
	}

	public void setJoinGangState(Byte joinGangState) {
		this.joinGangState = joinGangState;
	}

	public Byte getStoreIntakeState() {
		return storeIntakeState;
	}

	public void setStoreIntakeState(Byte storeIntakeState) {
		this.storeIntakeState = storeIntakeState;
	}

	public Byte getStallIntakeState() {
		return stallIntakeState;
	}

	public void setStallIntakeState(Byte stallIntakeState) {
		this.stallIntakeState = stallIntakeState;
	}

	public String getBuildingType() {
		return buildingType;
	}

	public void setBuildingType(String buildingType) {
		this.buildingType = buildingType;
	}

	public String getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}

	public String getGarageNumber() {
		return garageNumber;
	}

	public void setGarageNumber(String garageNumber) {
		this.garageNumber = garageNumber;
	}

	public String getStoreNumber() {
		return storeNumber;
	}

	public void setStoreNumber(String storeNumber) {
		this.storeNumber = storeNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Byte getState() {
		return state;
	}

	public void setState(Byte state) {
		this.state = state;
	}

	public Double getBuildingArea() {
		return buildingArea;
	}

	public void setBuildingArea(Double buildingArea) {
		this.buildingArea = buildingArea;
	}

	public String getStoreId() {
		return storeId;
	}

	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
   
    public PersonBuildingNew getPersonBuildingNew() {
		return personBuildingNew;
	}

	public void setPersonBuildingNew(PersonBuildingNew personBuildingNew) {
		this.personBuildingNew = personBuildingNew;
	}

	public Date getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}
	
    public Integer getArrearagePay() {
		return arrearagePay;
	}

	public void setArrearagePay(Integer arrearagePay) {
		this.arrearagePay = arrearagePay;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHouseId() {
		return houseId;
	}

	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getNewCustId() {
		return newCustId;
	}

	public void setNewCustId(String newCustId) {
		this.newCustId = newCustId;
	}

	public String getStallId() {
		return stallId;
	}

	public void setStallId(String stallId) {
		this.stallId = stallId;
	}

    public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	
    public String getPactId() {
        return pactId;
    }

    public void setPactId(String pactId) {
        this.pactId = pactId;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public Date getSignContractDate() {
        return signContractDate;
    }

    public void setSignContractDate(Date signContractDate) {
        this.signContractDate = signContractDate;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getNewCustName() {
        return newCustName;
    }

    public void setNewCustName(String newCustName) {
        this.newCustName = newCustName;
    }

    

    public Float getRegistrationPrice() {
        return registrationPrice;
    }

    public void setRegistrationPrice(Float registrationPrice) {
        this.registrationPrice = registrationPrice;
    }

    public Float getHouseAfterFoldingPrice() {
        return houseAfterFoldingPrice;
    }

    public void setHouseAfterFoldingPrice(Float houseAfterFoldingPrice) {
        this.houseAfterFoldingPrice = houseAfterFoldingPrice;
    }

    public Float getBuildingAreaPrice() {
        return buildingAreaPrice;
    }

    public void setBuildingAreaPrice(Float buildingAreaPrice) {
        this.buildingAreaPrice = buildingAreaPrice;
    }

    public Float getSetinBuildingPrice() {
        return setinBuildingPrice;
    }

    public void setSetinBuildingPrice(Float setinBuildingPrice) {
        this.setinBuildingPrice = setinBuildingPrice;
    }

    public String getDealType() {
        return dealType;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Float getDownPaymentPrice() {
        return downPaymentPrice;
    }

    public void setDownPaymentPrice(Float downPaymentPrice) {
        this.downPaymentPrice = downPaymentPrice;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getPactScan() {
        return pactScan;
    }

    public void setPactScan(String pactScan) {
        this.pactScan = pactScan;
    }

    public String getPropertyScan() {
        return propertyScan;
    }

    public void setPropertyScan(String propertyScan) {
        this.propertyScan = propertyScan;
    }

   
}