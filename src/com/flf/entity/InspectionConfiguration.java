package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "InspectionConfiguration")
//巡检配置信息表
public class InspectionConfiguration {
    private String reordId;//记录id

    private String serviceRequestId;//关联服务请求id

    private String principalId;//巡检负责人id

    private String inspectionPropertyId;//巡检目标id

    private String inspectionPlanId;//巡检方案id

    public String getReordId() {
        return reordId;
    }

    public void setReordId(String reordId) {
        this.reordId = reordId;
    }

    public String getServiceRequestId() {
        return serviceRequestId;
    }

    public void setServiceRequestId(String serviceRequestId) {
        this.serviceRequestId = serviceRequestId;
    }

    public String getPrincipalId() {
        return principalId;
    }

    public void setPrincipalId(String principalId) {
        this.principalId = principalId;
    }

    public String getInspectionPropertyId() {
        return inspectionPropertyId;
    }

    public void setInspectionPropertyId(String inspectionPropertyId) {
        this.inspectionPropertyId = inspectionPropertyId;
    }

    public String getInspectionPlanId() {
        return inspectionPlanId;
    }

    public void setInspectionPlanId(String inspectionPlanId) {
        this.inspectionPlanId = inspectionPlanId;
    }
}