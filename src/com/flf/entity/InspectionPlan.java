package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

//巡检方案表
@XmlRootElement(name = "InspectionPlan")
public class InspectionPlan {
    private String inspectionPlanId;//巡检方案id

    private String planCycle;//巡检周期

    private String departmentId;//部门id

    private String inspectionPlanName;//巡检方案名称

    private Byte state;//状态(0失效1有效)

    private String remarks;//巡检方案描述

    private Date createTime;//创建时间

    private String createPersonId;//创建人id

    private Date closeTime;//失效时间

    private String closePersonId;//失效操作人id

    private String closeRemarks;//失效说明    

	private List<InspectionPropertyCheckItem> tList;//巡检目标巡检项表
	
	private Page page;//分页

	public List<InspectionPropertyCheckItem> gettList() {
		return tList;
	}

	public void settList(List<InspectionPropertyCheckItem> tList) {
		this.tList = tList;
	}

    public String getInspectionPlanId() {
        return inspectionPlanId;
    }

    public void setInspectionPlanId(String inspectionPlanId) {
        this.inspectionPlanId = inspectionPlanId;
    }

    public String getPlanCycle() {
        return planCycle;
    }

    public void setPlanCycle(String planCycle) {
        this.planCycle = planCycle;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getInspectionPlanName() {
        return inspectionPlanName;
    }

    public void setInspectionPlanName(String inspectionPlanName) {
        this.inspectionPlanName = inspectionPlanName;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreatePersonId() {
        return createPersonId;
    }

    public void setCreatePersonId(String createPersonId) {
        this.createPersonId = createPersonId;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public String getClosePersonId() {
        return closePersonId;
    }

    public void setClosePersonId(String closePersonId) {
        this.closePersonId = closePersonId;
    }

    public String getCloseRemarks() {
        return closeRemarks;
    }

    public void setCloseRemarks(String closeRemarks) {
        this.closeRemarks = closeRemarks;
    }

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
}