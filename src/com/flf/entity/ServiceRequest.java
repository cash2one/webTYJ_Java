package com.flf.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * 服务请求表
 * 创建人：邵政
 * 创建时间：2015/6/23
 */
@XmlRootElement(name = "ServiceRequest")
public class ServiceRequest {
	private String serviceRequestId;//服务请求id

    private String requestTime;//请求时间

    private String requestSource;//请求来源

    private Integer serviceRequestState;//服务请求状态   0不需回访 1待回访 2处理中 3已回访    4已完成（巡检管理） 5关闭（巡检管理）
    
    private String serviceRequestName;//服务请求名称

    private String customerId;//客户id

    private Integer directionType;//服务请求类型（0内部服务请求，1外部服务请求）

    private Integer serviceRequestType;//服务请求类型(判断报事类型)0业主报事； 1业主装修； 2部门质检； 3验房；4 施工；5查抄水表； 6.查抄电表；7员工报事；8.向业主索赔；9.巡检；10.固定车位；11申诉

    private String reviewId;//回访对象id
    
    private String satisfaction;//满意度
    
    private String feedback;//回访反馈
    
    private List<AcceptanceOrders> acceptanceOrdersList;

    private Integer importantEvent;//是否重大事项  0：否   1是

    private String importantEventTypeId;//重大事项类型id
    
    private ImportantEventType importantEventType;

    private String writerId;//创建人id
    
    private Staff writer;//创建人 

    private String remarks;//备注描述

    private Integer anxious;//加急   0.false 1.true

    private String accessPhone;//接入电话
    
    private Integer qualityCompanyType;//质检下级单位
    
    private Tasks tasks; //任务对象
    
    private List<Tasks> listTasks;//任务对象集合
    
    private User user;//关联用户表
    
    private PersonCustNew personCustNew;//关联客户基本信息表
    
    private Staff staff;//关联员工表
    
    private List<ServiceObjectRecords> serviceObjectRecords;//服务对象记录
    
    private List<String> serviceRequestIds;//服务请求id集合
    
    private FrequencyRecord frequencyRecord;//频率记录表
    
    private List<ExecutionTimeRecords> executionTimeRecords;//执行次数与时间记录表
    
    private ServiceRequestJournal serviceRequestJournal;//服务请日志表
    private OwnerRenovationApply  ownerRenovationApply;
    
    private String source;//抄表来源    1周期性抄表
    
    private Integer goingSum;//进行中总数
    private Integer historySum;//历史总数
    
    public Integer getHistorySum() {
		return historySum;
	}

	public void setHistorySum(Integer historySum) {
		this.historySum = historySum;
	}

	public Integer getGoingSum() {
		return goingSum;
	}

	public void setGoingSum(Integer goingSum) {
		this.goingSum = goingSum;
	}

	public List<InspectionConfiguration> getInspectionConfiguration() {
		return InspectionConfiguration;
	}

	public void setInspectionConfiguration(
			List<InspectionConfiguration> inspectionConfiguration) {
		InspectionConfiguration = inspectionConfiguration;
	}

	public void setOwnerRenovationApply(OwnerRenovationApply ownerRenovationApply) {
		this.ownerRenovationApply = ownerRenovationApply;
	}

	private List<InspectionConfiguration> InspectionConfiguration;// 巡检配置信息表
    private Page page;

    public List<String> getServiceRequestIds() {
		return serviceRequestIds;
	}

	public void setServiceRequestIds(List<String> serviceRequestIds) {
		this.serviceRequestIds = serviceRequestIds;
	}

	public Page getPage() {
		return page;
	}

    public OwnerRenovationApply getOwnerRenovationApply() {
		return ownerRenovationApply;
	}


	public List<Tasks> getListTasks() {
		return listTasks;
	}



	public void setListTasks(List<Tasks> listTasks) {
		this.listTasks = listTasks;
	}



	public List<ServiceObjectRecords> getServiceObjectRecords() {
		return serviceObjectRecords;
	}



	public void setServiceObjectRecords(
			List<ServiceObjectRecords> serviceObjectRecords) {
		this.serviceObjectRecords = serviceObjectRecords;
	}



	public Tasks getTasks() {
		return tasks;
	}

	public void setTasks(Tasks tasks) {
		this.tasks = tasks;
	}

	public void setPage(Page page) {
		this.page = page;
	}

    public String getServiceRequestId() {
        return serviceRequestId;
    }

    public void setServiceRequestId(String serviceRequestId) {
        this.serviceRequestId = serviceRequestId;
    }


    public String getRequestTime() {
		return requestTime;
	}



	public void setRequestTime(String requestTime) {
		this.requestTime = requestTime;
	}



	public String getRequestSource() {
        return requestSource;
    }

    public void setRequestSource(String requestSource) {
        this.requestSource = requestSource;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public Integer getServiceRequestState() {
		return serviceRequestState;
	}

	public void setServiceRequestState(Integer serviceRequestState) {
		this.serviceRequestState = serviceRequestState;
	}

	public Integer getDirectionType() {
		return directionType;
	}

	public void setDirectionType(Integer directionType) {
		this.directionType = directionType;
	}

	public Integer getServiceRequestType() {
		return serviceRequestType;
	}

	public void setServiceRequestType(Integer serviceRequestType) {
		this.serviceRequestType = serviceRequestType;
	}
	
	public String getImportantEventTypeId() {
		return importantEventTypeId;
	}



	public void setImportantEventTypeId(String importantEventTypeId) {
		this.importantEventTypeId = importantEventTypeId;
	}



	public String getWriterId() {
        return writerId;
    }

    public void setWriterId(String writerId) {
        this.writerId = writerId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getImportantEvent() {
		return importantEvent;
	}



	public void setImportantEvent(Integer importantEvent) {
		this.importantEvent = importantEvent;
	}



	public Integer getAnxious() {
		return anxious;
	}



	public void setAnxious(Integer anxious) {
		this.anxious = anxious;
	}



	public String getAccessPhone() {
        return accessPhone;
    }

    public void setAccessPhone(String accessPhone) {
        this.accessPhone = accessPhone;
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public PersonCustNew getPersonCustNew() {
		return personCustNew;
	}

	public void setPersonCustNew(PersonCustNew personCustNew) {
		this.personCustNew = personCustNew;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public FrequencyRecord getFrequencyRecord() {
		return frequencyRecord;
	}

	public void setFrequencyRecord(FrequencyRecord frequencyRecord) {
		this.frequencyRecord = frequencyRecord;
	}

	public Integer getQualityCompanyType() {
		return qualityCompanyType;
	}

	public void setQualityCompanyType(Integer qualityCompanyType) {
		this.qualityCompanyType = qualityCompanyType;
	}

	public String getServiceRequestName() {
		return serviceRequestName;
	}

	public void setServiceRequestName(String serviceRequestName) {
		this.serviceRequestName = serviceRequestName;
	}

	public ServiceRequestJournal getServiceRequestJournal() {
		return serviceRequestJournal;
	}

	public void setServiceRequestJournal(ServiceRequestJournal serviceRequestJournal) {
		this.serviceRequestJournal = serviceRequestJournal;
	}

	public ImportantEventType getImportantEventType() {
		return importantEventType;
	}

	public void setImportantEventType(ImportantEventType importantEventType) {
		this.importantEventType = importantEventType;
	}

	public String getSatisfaction() {
		return satisfaction;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setSatisfaction(String satisfaction) {
		this.satisfaction = satisfaction;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public List<AcceptanceOrders> getAcceptanceOrdersList() {
		return acceptanceOrdersList;
	}

	public void setAcceptanceOrdersList(List<AcceptanceOrders> acceptanceOrdersList) {
		this.acceptanceOrdersList = acceptanceOrdersList;
	}

	public Staff getWriter() {
		return writer;
	}

	public void setWriter(Staff writer) {
		this.writer = writer;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public List<ExecutionTimeRecords> getExecutionTimeRecords() {
		return executionTimeRecords;
	}

	public void setExecutionTimeRecords(List<ExecutionTimeRecords> executionTimeRecords) {
		this.executionTimeRecords = executionTimeRecords;
	}



	
}