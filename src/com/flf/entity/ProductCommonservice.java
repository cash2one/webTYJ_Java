package com.flf.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ProductCommonservice")// 
public class ProductCommonservice {
	//普通服务id
    private String commonserviceId;
    //普通服务名称
    private String commonserviceName;
    //普通服务类型  1 为人工   2为物资
    private String productServicetype;
    //普通服务单位
    private String productUnit;
    //普通服务价格
    private String productPrice;
    //普通服务启用时间
    private String productBeginDate;
    //普通服务失效时间
    private String productEndDate;
    //产品类型   普通服务为后增 所以固定为6   之前有五个产品存放在tc_product表中
    private String productType;
    //产品编号 按规格生成
    private String productCode;

    public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getCommonserviceId() {
        return commonserviceId;
    }

    public void setCommonserviceId(String commonserviceId) {
        this.commonserviceId = commonserviceId;
    }

    public String getCommonserviceName() {
        return commonserviceName;
    }

    public void setCommonserviceName(String commonserviceName) {
        this.commonserviceName = commonserviceName;
    }

    public String getProductServicetype() {
        return productServicetype;
    }

    public void setProductServicetype(String productServicetype) {
        this.productServicetype = productServicetype;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductBeginDate() {
        return productBeginDate;
    }

    public void setProductBeginDate(String productBeginDate) {
        this.productBeginDate = productBeginDate;
    }

    public String getProductEndDate() {
        return productEndDate;
    }

    public void setProductEndDate(String productEndDate) {
        this.productEndDate = productEndDate;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}