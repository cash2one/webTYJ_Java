package com.flf.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

//服务项目表
@XmlRootElement(name = "ServiceProject")
public class ServiceProject {
	
    private String serviceProjectId;  //服务项目ID

    private Double unitPrice;     //单价

    private String unit;         //单位
    
    private Byte onsiteVerification;   //现场核实
    

    private String serviceProjectName;   //服务项目名称

    private String productId;           //产品ID
    
   

	public String getServiceProjectId() {
        return serviceProjectId;
    }

    public void setServiceProjectId(String serviceProjectId) {
        this.serviceProjectId = serviceProjectId;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Byte getOnsiteVerification() {
        return onsiteVerification;
    }

    public void setOnsiteVerification(Byte onsiteVerification) {
        this.onsiteVerification = onsiteVerification;
    }

    public String getServiceProjectName() {
        return serviceProjectName;
    }

    public void setServiceProjectName(String serviceProjectName) {
        this.serviceProjectName = serviceProjectName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}