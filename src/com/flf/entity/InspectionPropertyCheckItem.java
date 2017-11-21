package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;

//巡检目标巡检项表
@XmlRootElement(name = "InspectionPropertyCheckItem")
public class InspectionPropertyCheckItem {
    private String inspectionCheckItemId;//巡检项目id

    private String inspectionPlanId;//关联巡检方案id

    private String num;//巡检项序号

    private String checkItemName;//巡检项名称

    private String checkItemUnit;//巡检项单位	

    private String checkItemReference;//巡检项默认值

    private Byte inputType;//输入类型(0填写输入1选择输入)

    public String getInspectionCheckItemId() {
        return inspectionCheckItemId;
    }

    public void setInspectionCheckItemId(String inspectionCheckItemId) {
        this.inspectionCheckItemId = inspectionCheckItemId;
    }

    public String getInspectionPlanId() {
        return inspectionPlanId;
    }

    public void setInspectionPlanId(String inspectionPlanId) {
        this.inspectionPlanId = inspectionPlanId;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getCheckItemName() {
        return checkItemName;
    }

    public void setCheckItemName(String checkItemName) {
        this.checkItemName = checkItemName;
    }

    public String getCheckItemUnit() {
        return checkItemUnit;
    }

    public void setCheckItemUnit(String checkItemUnit) {
        this.checkItemUnit = checkItemUnit;
    }

    public String getCheckItemReference() {
        return checkItemReference;
    }

    public void setCheckItemReference(String checkItemReference) {
        this.checkItemReference = checkItemReference;
    }

    public Byte getInputType() {
        return inputType;
    }

    public void setInputType(Byte inputType) {
        this.inputType = inputType;
    }
}