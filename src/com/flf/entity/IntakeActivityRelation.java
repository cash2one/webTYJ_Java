package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "IntakeActivityRelation") //入伙活动人员关系表
public class IntakeActivityRelation {
    private String intakeActivityRelationId;  // 入伙活动关系表id

    private String staffId;   //  人员id

    private String intakeActivityId; //  入伙活动id

    public String getIntakeActivityRelationId() {
        return intakeActivityRelationId;
    }

    public void setIntakeActivityRelationId(String intakeActivityRelationId) {
        this.intakeActivityRelationId = intakeActivityRelationId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getIntakeActivityId() {
        return intakeActivityId;
    }

    public void setIntakeActivityId(String intakeActivityId) {
        this.intakeActivityId = intakeActivityId;
    }
}