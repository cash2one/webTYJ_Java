package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

//产品表
@XmlRootElement(name = "Product")
public class Product {
	
	//产品id
    private String productId;

    //产品名称
    private String productName;

    //产品编号
    private String productNum;

    //生效日期
    private Date effectDate;
    
	//失效日期
    private Date expiryDate;

    //产品属性
    /**
     * 增加产品属性注释：分为房屋租赁产品属性和广告租赁产品属性
     * 1、房屋租赁：0-架空层、1-人防、2-地下室、3-临建、4-设备间、5-走廊、6-广场、7-道路、8-住宅、9-商铺
     * 2、广告租赁：10-电梯、11-广告牌、12-墙体、13-灯箱、14其他
     * 
     * 王洲
     * 2015.12.25
     */
    private String productAttributes;

    //价格
    private Double price;

    //均价
    private Double averagePrice;

    //产品类型
    //0、建筑租赁；1、停车月卡；2、门禁卡；3、装修服务；4、固定车位；5、广告租赁；6、停车
    private String productType;
    
    //停车位使用月数
    private int month;

    //押金方式
    /**
     * 增加押金方式注释说明：
     * 0-无、1-押一、2-押二、3-押三、4-押四
     * 
     * 王洲
     * 2015.12.25
     */
    private String depositWay;

    //支付方式
    private String payWay;

    //预付日期
    private Date prepaidDate;

    //租金递增
    private Byte increasingRent;

    //递增比例
    private String rentProportion;

    //递增类型
    /**
     * 增加递增类型注释说明：
     * 1-半年递增、2-逐年递增、3-两年递增、4、三年递增
     * 
     * 王洲
     * 2015.12.25
     */
    private String rentType;

    //简介
    private String lntroduction;

    //车位id
    private String stallId;
    
    //是否失效；0有效，1失效
    private String state;
    
    //分页
    private Page page;
    
    //最低价格
    private Double startPrice;
    
    //最高价格
    private Double endPrice;
    
    //关联面积划分表
    private List<AreaDivision> areadivisionlist;
    
    
    private List<ServiceProject> serviceprojectlist;  //关联装修服务表


	//关联附件表
    private List<Annex> annexs;
    
    //关联知识库子表
    private DataDictionarySlave pay;//支付类型 存在知识库子表中
    
    //关联知识库子表
    private DataDictionarySlave rent;//支付类型 存在知识库子表中
    
    //关联建筑结构表
    private List<BuildingStructureNew> buildingstructruenewlist;
    
    //关联建筑结构表主键id集合
    private List<String> buildingstructrueIds;
    
    //增加关联产品建筑关联表集合   王洲   2015.12.25
    private List<ProductBs> productBSList;
    
    //增加字段是否有免租期  王洲 2015.12.26
    private String isRentFree;
    
    //增加字段免租期时长 王洲 2015.12.26
    private String freeTime;
    
    //增加字段，修改时间，用于进行查询排序  王洲  2016.04.15
    private Date modifyTime;
    
    //产品总面积  王洲  2016.04.15
    private String totalArea;
    
    //固定车位  2016.04.29
    private List<Product> products;
    
    //车位类型
    private String stallType;
    
    //单位：供前台显示用
    private String unit;
    
    //排序专用 
    private String odbstate;
    
    
    
    
    

	
	public String getOdbstate() {
		return odbstate;
	}

	public void setOdbstate(String odbstate) {
		this.odbstate = odbstate;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getStallType() {
		return stallType;
	}

	public void setStallType(String stallType) {
		this.stallType = stallType;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<String> getBuildingstructrueIds() {
		return buildingstructrueIds;
	}

	public void setBuildingstructrueIds(List<String> buildingstructrueIds) {
		this.buildingstructrueIds = buildingstructrueIds;
	}

	public DataDictionarySlave getPay() {
		return pay;
	}

	public void setPay(DataDictionarySlave pay) {
		this.pay = pay;
	}

	public DataDictionarySlave getRent() {
		return rent;
	}

	public void setRent(DataDictionarySlave rent) {
		this.rent = rent;
	}

	public List<ServiceProject> getServiceprojectlist() {
		return serviceprojectlist;
	}

	public void setServiceprojectlist(List<ServiceProject> serviceprojectlist) {
		this.serviceprojectlist = serviceprojectlist;
	}

	public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public Date getEffectDate() {
        return effectDate;
    }

    public void setEffectDate(Date effectDate) {
        this.effectDate = effectDate;
    }

    public String getProductAttributes() {
        return productAttributes;
    }

    public void setProductAttributes(String productAttributes) {
        this.productAttributes = productAttributes;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getDepositWay() {
        return depositWay;
    }

    public void setDepositWay(String depositWay) {
        this.depositWay = depositWay;
    }

    public String getPayWay() {
        return payWay;
    }

    public void setPayWay(String payWay) {
        this.payWay = payWay;
    }

    public Date getPrepaidDate() {
        return prepaidDate;
    }

    public void setPrepaidDate(Date prepaidDate) {
        this.prepaidDate = prepaidDate;
    }

    public Byte getIncreasingRent() {
        return increasingRent;
    }

    public void setIncreasingRent(Byte increasingRent) {
        this.increasingRent = increasingRent;
    }

    public String getRentProportion() {
        return rentProportion;
    }

    public void setRentProportion(String rentProportion) {
        this.rentProportion = rentProportion;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public String getLntroduction() {
        return lntroduction;
    }

    public void setLntroduction(String lntroduction) {
        this.lntroduction = lntroduction;
    }

    public String getStallId() {
        return stallId;
    }

    public void setStallId(String stallId) {
        this.stallId = stallId;
    }

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Double getStartPrice() {
		return startPrice;
	}

	public void setStartPrice(Double startPrice) {
		this.startPrice = startPrice;
	}

	public Double getEndPrice() {
		return endPrice;
	}

	public void setEndPrice(Double endPrice) {
		this.endPrice = endPrice;
	}

	public List<AreaDivision> getAreadivisionlist() {
		return areadivisionlist;
	}

	public void setAreadivisionlist(List<AreaDivision> areadivisionlist) {
		this.areadivisionlist = areadivisionlist;
	}

	public List<Annex> getAnnexs() {
		return annexs;
	}

	public void setAnnexs(List<Annex> annexs) {
		this.annexs = annexs;
	}

	public List<BuildingStructureNew> getBuildingstructruenewlist() {
		return buildingstructruenewlist;
	}

	public void setBuildingstructruenewlist(
			List<BuildingStructureNew> buildingstructruenewlist) {
		this.buildingstructruenewlist = buildingstructruenewlist;
	}

	public List<ProductBs> getProductBSList() {
		return productBSList;
	}

	public void setProductBSList(List<ProductBs> productBSList) {
		this.productBSList = productBSList;
	}

	public String getIsRentFree() {
		return isRentFree;
	}

	public void setIsRentFree(String isRentFree) {
		this.isRentFree = isRentFree;
	}

	public String getFreeTime() {
		return freeTime;
	}

	public void setFreeTime(String freeTime) {
		this.freeTime = freeTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getTotalArea() {
		return totalArea;
	}

	public void setTotalArea(String totalArea) {
		this.totalArea = totalArea;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}


}