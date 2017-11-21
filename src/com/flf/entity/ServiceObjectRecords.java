package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 服务对象记录表
 * 创建人：邵政
 * 创建时间：2015/6/23
 */
@XmlRootElement(name = "ServiceObjectRecords")
public class ServiceObjectRecords {
    private String recordId;//记录

    private String serviceRequestId;//服务请求id

    private Integer serviceObjectType;//服务对象类型

    private String serviceObjectId;//服务对象id
    
//    private ServiceRequest serviceRequest;//关联服务请求表
    
    private String criteriaId; //评分标准ID
    
    private ScoreCriteria scoreCriteria; //评分标准
    
    private Staff staff;//员工列表
    
    public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public ScoreCriteria getScoreCriteria() {
		return scoreCriteria;
	}

	public void setScoreCriteria(ScoreCriteria scoreCriteria) {
		this.scoreCriteria = scoreCriteria;
	}

	public String getCriteriaId() {
		return criteriaId;
	}

	public void setCriteriaId(String criteriaId) {
		this.criteriaId = criteriaId;
	}

	public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getServiceRequestId() {
        return serviceRequestId;
    }

    public void setServiceRequestId(String serviceRequestId) {
        this.serviceRequestId = serviceRequestId;
    }

    public Integer getServiceObjectType() {
		return serviceObjectType;
	}

	public void setServiceObjectType(Integer serviceObjectType) {
		this.serviceObjectType = serviceObjectType;
	}

	public String getServiceObjectId() {
		return serviceObjectId;
	}

	public void setServiceObjectId(String serviceObjectId) {
		this.serviceObjectId = serviceObjectId;
	}

//	public ServiceRequest getServiceRequest() {
//		return serviceRequest;
//	}
//
//	public void setServiceRequest(ServiceRequest serviceRequest) {
//		this.serviceRequest = serviceRequest;
//	}
    
    
}