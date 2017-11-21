package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 任务表
 * 创建人：邵政
 * 创建时间：2015/6/23
 */
@XmlRootElement(name = "Tasks")
public class Tasks {
	
    private String taskId;//任务id
    private String serverId;//关联服务请求id
    private String customerId;//客户id
    private String customerName;//客户姓名
    private String customerFullName;//客户住址
    private String customerPhone;//客户注册电话
    private Integer taskType;//任务类型  园林0 维修1 护管2 部门质检3 装修巡检4 装修验收5 施工巡检6 施工核查7 施工验收8 赔偿给业主9 向业主索赔10 清洁11 回访12 投诉13 验房 14 咨询15 抄水表16 抄电表17 装修核查18固定车位19巡检20通用21重大事项22申诉23
    private Integer taskState;//任务状态   0.关闭 1.重启 2.已完成   3.已接受 4.未处理  5.转出   6.提交完成  7.处理中   8.合并9.转专项  10.转集中处理(8,9,10这三个特殊处理) 11.指派     12.延时 13.催促  （12,13 只用任务操作的记录）
    private Integer professional;//专业
    private Integer product;//产品
    private String addressId;//地址id
    private List<String> addressIds;//地址集合
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private Date estimatedTime;//预计完成时间
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private Date finishTime;//实际完成时间
    private String createTime;//创建时间
    private String taskDescription;//任务描述
    private String principal;//负责人
    private String subordinateId;//从属id
    private Integer subordinateType;//从属类型   1.专项 2.集中处理
    private String subordinateOperation;//从属操作人id
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private Date subordinateTime;//从属操作时间
    private String transferPrincipal;//转出负责人
    
    private PersonCustNew personCustNew;//关联客户基本信息表
    private ServiceRequest serviceRequest;//关联服务请求表
    private String remarks; // 备注
    private Staff staff; //员工表
    private String turnSpecialRecordsId;//转专项id
    private String projectId;//集中处理项目id
    private String lesserTasksId; //子任务id
    private BuildingStructureNew buildingStructureNew; // 建筑结构对像
    private List<ServiceObjectRecords> objectRecordsList;//服务对象记录集合
    private List<String> tasksIds;//任务id集合
    private CompensateObject compensateObject;//赔偿对象记录表
    private List<Annex> annexs;//附件表
    private Page page;
    private List<Tasks> tasks;//任务集合
    
    private String urgeCount;//催办次数
    private String urgeRidicule; //催办调侃语句
    
    private String delayCount;//延时次数
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private Date delayTime;
    
    private int taskOutType; //任务转出类型
    
    //我的任务获取条件
    private String state1;
    private String state2;
    
    private String fullName; //巡检目标名
    private String checkItemName;//巡检项目名
    private String checkItemUnit;//巡检单位
    private String recordId;//巡检记录id
    private String inspectionResult;//巡检结果
    private String state; //巡检单提交状态
    private String orderId; //巡检单id
    

    public List<Tasks> getTasks() {
		return tasks;
	}

	public void setTasks(List<Tasks> tasks) {
		this.tasks = tasks;
	}

	public Page getPage() {
		return page;
	}

	public List<String> getTasksIds() {
		return tasksIds;
	}

	public void setTasksIds(List<String> tasksIds) {
		this.tasksIds = tasksIds;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    
    public Integer getTaskType() {
		return taskType;
	}

	public void setTaskType(Integer taskType) {
		this.taskType = taskType;
	}

	public Integer getTaskState() {
		return taskState;
	}

	public void setTaskState(Integer taskState) {
		this.taskState = taskState;
	}

	public Integer getProfessional() {
		return professional;
	}

	public void setProfessional(Integer professional) {
		this.professional = professional;
	}

	public Integer getProduct() {
		return product;
	}

	public void setProduct(Integer product) {
		this.product = product;
	}

	public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

	public String getSubordinateId() {
		return subordinateId;
	}

	public void setSubordinateId(String subordinateId) {
		this.subordinateId = subordinateId;
	}

	public Integer getSubordinateType() {
		return subordinateType;
	}

	public void setSubordinateType(Integer subordinateType) {
		this.subordinateType = subordinateType;
	}

	public String getSubordinateOperation() {
		return subordinateOperation;
	}

	public void setSubordinateOperation(String subordinateOperation) {
		this.subordinateOperation = subordinateOperation;
	}

	public Date getSubordinateTime() {
		return subordinateTime;
	}

	public void setSubordinateTime(Date subordinateTime) {
		this.subordinateTime = subordinateTime;
	}

	public PersonCustNew getPersonCustNew() {
		return personCustNew;
	}

	public void setPersonCustNew(PersonCustNew personCustNew) {
		this.personCustNew = personCustNew;
	}

	public ServiceRequest getServiceRequest() {
		return serviceRequest;
	}

	public void setServiceRequest(ServiceRequest serviceRequest) {
		this.serviceRequest = serviceRequest;
	}
//
//	public ServiceObjectRecords getServiceObjectRecords() {
//		return serviceObjectRecords;
//	}
//
//	public void setServiceObjectRecords(ServiceObjectRecords serviceObjectRecords) {
//		this.serviceObjectRecords = serviceObjectRecords;
//	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public BuildingStructureNew getBuildingStructureNew() {
		return buildingStructureNew;
	}

	public void setBuildingStructureNew(BuildingStructureNew buildingStructureNew) {
		this.buildingStructureNew = buildingStructureNew;
	}


	public String getRemarks() {
		return remarks;
	}


	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getTurnSpecialRecordsId() {
		return turnSpecialRecordsId;
	}

	public void setTurnSpecialRecordsId(String turnSpecialRecordsId) {
		this.turnSpecialRecordsId = turnSpecialRecordsId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getLesserTasksId() {
		return lesserTasksId;
	}

	public void setLesserTasksId(String lesserTasksId) {
		this.lesserTasksId = lesserTasksId;
	}

	public List<ServiceObjectRecords> getObjectRecordsList() {
		return objectRecordsList;
	}

	public void setObjectRecordsList(List<ServiceObjectRecords> objectRecordsList) {
		this.objectRecordsList = objectRecordsList;
	}

	public CompensateObject getCompensateObject() {
		return compensateObject;
	}

	public void setCompensateObject(CompensateObject compensateObject) {
		this.compensateObject = compensateObject;
	}

	public List<Annex> getAnnexs() {
		return annexs;
	}

	public void setAnnexs(List<Annex> annexs) {
		this.annexs = annexs;
	}

	public Date getEstimatedTime() {
		return estimatedTime;
	}

	public void setEstimatedTime(Date estimatedTime) {
		this.estimatedTime = estimatedTime;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public String getUrgeCount() {
		return urgeCount;
	}

	public void setUrgeCount(String urgeCount) {
		this.urgeCount = urgeCount;
	}

	public String getState1() {
		return state1;
	}

	public String getState2() {
		return state2;
	}

	public void setState1(String state1) {
		this.state1 = state1;
	}

	public void setState2(String state2) {
		this.state2 = state2;
	}

	public Date getDelayTime() {
		return delayTime;
	}

	public void setDelayTime(Date delayTime) {
		this.delayTime = delayTime;
	}

	public String getDelayCount() {
		return delayCount;
	}

	public void setDelayCount(String delayCount) {
		this.delayCount = delayCount;
	}

	public String getUrgeRidicule() {
		return urgeRidicule;
	}

	public void setUrgeRidicule(String urgeRidicule) {
		this.urgeRidicule = urgeRidicule;
	}

	public int getTaskOutType() {
		return taskOutType;
	}

	public void setTaskOutType(int taskOutType) {
		this.taskOutType = taskOutType;
	}

	public List<String> getAddressIds() {
		return addressIds;
	}

	public void setAddressIds(List<String> addressIds) {
		this.addressIds = addressIds;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public String getRecordId() {
		return recordId;
	}

	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}

	public String getInspectionResult() {
		return inspectionResult;
	}

	public void setInspectionResult(String inspectionResult) {
		this.inspectionResult = inspectionResult;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getTransferPrincipal() {
		return transferPrincipal;
	}

	public void setTransferPrincipal(String transferPrincipal) {
		this.transferPrincipal = transferPrincipal;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getCustomerFullName() {
		return customerFullName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setCustomerFullName(String customerFullName) {
		this.customerFullName = customerFullName;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}


	
	
	
	
	
}