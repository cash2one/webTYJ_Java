package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ElectricityMeterTypes") // 电表类型
public class ElectricityMeterTypes {
    private String electricityMeterTypesId;  //电表类型id

    private String electricityMeterTypesName; // 电表类型名称

    private String electricityMeterDescribed; //表描述

    public String getElectricityMeterTypesId() {
        return electricityMeterTypesId;
    }

    public void setElectricityMeterTypesId(String electricityMeterTypesId) {
        this.electricityMeterTypesId = electricityMeterTypesId;
    }

    public String getElectricityMeterTypesName() {
        return electricityMeterTypesName;
    }

    public void setElectricityMeterTypesName(String electricityMeterTypesName) {
        this.electricityMeterTypesName = electricityMeterTypesName;
    }

    public String getElectricityMeterDescribed() {
        return electricityMeterDescribed;
    }

    public void setElectricityMeterDescribed(String electricityMeterDescribed) {
        this.electricityMeterDescribed = electricityMeterDescribed;
    }
}