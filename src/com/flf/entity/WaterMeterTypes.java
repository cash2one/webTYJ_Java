package com.flf.entity;
/* Created by Administrator on 2015/6/15. 
author:尹磊
修改时间：2015/6/15  修改人：尹磊 */
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "WaterMeterTypes")  //水表所有人类型表
public class WaterMeterTypes {
    private String waterMeterTypesId;  // 水表所有人类型id

    private String waterMeterTypesName;  //水表所有人类型名称

    private String waterMeterDescribed;  //水表描述

    public String getWaterMeterTypesId() {
        return waterMeterTypesId;
    }

    public void setWaterMeterTypesId(String waterMeterTypesId) {
        this.waterMeterTypesId = waterMeterTypesId;
    }

    public String getWaterMeterTypesName() {
        return waterMeterTypesName;
    }

    public void setWaterMeterTypesName(String waterMeterTypesName) {
        this.waterMeterTypesName = waterMeterTypesName;
    }

    public String getWaterMeterDescribed() {
        return waterMeterDescribed;
    }

    public void setWaterMeterDescribed(String waterMeterDescribed) {
        this.waterMeterDescribed = waterMeterDescribed;
    }
}