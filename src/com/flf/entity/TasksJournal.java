package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * 任务日誌表
 * 创建人：邵政
 * 创建时间：2015/6/23
 */
@XmlRootElement(name = "TasksJournal")
public class TasksJournal {
    private String tasksJournalId;//任务日志id

    private String taskId;//任务id

    private String operatorId;//操作人id
    
    private String operatorName;//操作人姓名

    private String operationTime;//操作时间

    private String creOrderId;//创建工单id

    private Integer creOrderType;//创建工单类型  0.报价单 1.处理单 2.验收单 3.检测单 4.结算单 5.赔偿给业主 6.部门质检 7.回访单 8.申诉单 9.抄水表 10.抄电表 11.投诉单 12.咨询单 13.固定车位工单表 14.装修核查工单 15装修巡检工单16装修核查工单 17.表扬单 18.验房单  19施工核查 20施工巡检 21施工验收23向业主索赔 22维修24失效 

    private Integer changeState;//任务状态修改
    
    private Integer changeOrderState;//工单状态修改

    private String remarks;//备注描述
    
    private Tasks tasks;//关联任务表
    
    private Staff staff;//关联员工表
    
    private QuoteOrders quoteOrders;//报价单
    private CheckOrders checkOrders;//检测单
    private DisposeOrder disposeOrder;//处理单
    private AcceptanceOrders acceptanceOrders;//验收单
    private SettleAccountsOrders settleAccountsOrders;//验收单
    private CompensateOwner compensateOwner;//赔偿给业主工单
    private PraiseOrders praiseOrders;//表扬单
	private DepartmentOrders departmentOrders;//部门质检工单
    private ReturnVisitOrders returnVisitOrders ;//回访工单
    private AppealOrders appealOrders ;//申诉工单
    private WaterMeterOrders waterMeterOrders;//抄水表工单
    private MeterReadingOrders meterReadingOrders;//抄电表工单
    private ComplaintOrders complaintOrders;//投诉表工单
    private ConsultationOrders consultationOrders;//咨询表工单
    private FixedParkingOrders fixedParkingOrders;//固定车位工单
    private RenovationCheckOrders renovationCheckOrders;//装修核查工单
    private RenovationInspectionOrders renovationInspectionOrders;//装修巡检工单
    private RenovationAcceptanceOrders renovationAcceptanceOrders;//装修验收工单
    private InspectorOrder inspectorOrder;//验房工单
    private ConstructionCheckOrders constructionCheckOrders;//施工核查
    private ConstructionInspectionOrders constructionInspectionOrders;//施工巡检
    private ConstructionAcceptanceOrders constructionAcceptanceOrders;//施工核查
    private RepairOrders repairOrders;//维修单
    private ClosedOrders closedOrders;//失效单
    private ClaimToCustomerOrders claimToCustomerOrders;//向业主索赔
    
    private int taskOutType; //任务转出类型
    
    public ClosedOrders getClosedOrders() {
		return closedOrders;
	}

	public void setClosedOrders(ClosedOrders closedOrders) {
		this.closedOrders = closedOrders;
	}

	public RenovationAcceptanceOrders getRenovationAcceptanceOrders() {
		return renovationAcceptanceOrders;
	}

	public void setRenovationAcceptanceOrders(
			RenovationAcceptanceOrders renovationAcceptanceOrders) {
		this.renovationAcceptanceOrders = renovationAcceptanceOrders;
	}

	public RenovationInspectionOrders getRenovationInspectionOrders() {
		return renovationInspectionOrders;
	}

	public void setRenovationInspectionOrders(
			RenovationInspectionOrders renovationInspectionOrders) {
		this.renovationInspectionOrders = renovationInspectionOrders;
	}

	public RenovationCheckOrders getRenovationCheckOrders() {
		return renovationCheckOrders;
	}

	public void setRenovationCheckOrders(RenovationCheckOrders renovationCheckOrders) {
		this.renovationCheckOrders = renovationCheckOrders;
	}

	public FixedParkingOrders getFixedParkingOrders() {
		return fixedParkingOrders;
	}

	public void setFixedParkingOrders(FixedParkingOrders fixedParkingOrders) {
		this.fixedParkingOrders = fixedParkingOrders;
	}

	public ConsultationOrders getConsultationOrders() {
		return consultationOrders;
	}

	public void setConsultationOrders(ConsultationOrders consultationOrders) {
		this.consultationOrders = consultationOrders;
	}

	public ComplaintOrders getComplaintOrders() {
		return complaintOrders;
	}

	public void setComplaintOrders(ComplaintOrders complaintOrders) {
		this.complaintOrders = complaintOrders;
	}

	private Page page;

    public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

    public String getTasksJournalId() {
        return tasksJournalId;
    }

    public void setTasksJournalId(String tasksJournalId) {
        this.tasksJournalId = tasksJournalId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }


    public String getOperationTime() {
		return operationTime;
	}

	public void setOperationTime(String operationTime) {
		this.operationTime = operationTime;
	}

	public String getCreOrderId() {
        return creOrderId;
    }

    public void setCreOrderId(String creOrderId) {
        this.creOrderId = creOrderId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

	public Tasks getTasks() {
		return tasks;
	}

	public void setTasks(Tasks tasks) {
		this.tasks = tasks;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Integer getCreOrderType() {
		return creOrderType;
	}

	public void setCreOrderType(Integer creOrderType) {
		this.creOrderType = creOrderType;
	}

	public Integer getChangeState() {
		return changeState;
	}

	public void setChangeState(Integer changeState) {
		this.changeState = changeState;
	}

	public Integer getChangeOrderState() {
		return changeOrderState;
	}

	public void setChangeOrderState(Integer changeOrderState) {
		this.changeOrderState = changeOrderState;
	}

	public QuoteOrders getQuoteOrders() {
		return quoteOrders;
	}

	public void setQuoteOrders(QuoteOrders quoteOrders) {
		this.quoteOrders = quoteOrders;
	}

	public CheckOrders getCheckOrders() {
		return checkOrders;
	}

	public void setCheckOrders(CheckOrders checkOrders) {
		this.checkOrders = checkOrders;
	}

	public DisposeOrder getDisposeOrder() {
		return disposeOrder;
	}

	public void setDisposeOrder(DisposeOrder disposeOrder) {
		this.disposeOrder = disposeOrder;
	}

	public AcceptanceOrders getAcceptanceOrders() {
		return acceptanceOrders;
	}

	public void setAcceptanceOrders(AcceptanceOrders acceptanceOrders) {
		this.acceptanceOrders = acceptanceOrders;
	}

	public SettleAccountsOrders getSettleAccountsOrders() {
		return settleAccountsOrders;
	}

	public void setSettleAccountsOrders(SettleAccountsOrders settleAccountsOrders) {
		this.settleAccountsOrders = settleAccountsOrders;
	}

	public CompensateOwner getCompensateOwner() {
		return compensateOwner;
	}

	public void setCompensateOwner(CompensateOwner compensateOwner) {
		this.compensateOwner = compensateOwner;
	}

	public PraiseOrders getPraiseOrders() {
		return praiseOrders;
	}

	public void setPraiseOrders(PraiseOrders praiseOrders) {
		this.praiseOrders = praiseOrders;
	}
	
	public DepartmentOrders getDepartmentOrders() {
		return departmentOrders;
	}

	public void setDepartmentOrders(DepartmentOrders departmentOrders) {
		this.departmentOrders = departmentOrders;
	}

	public ReturnVisitOrders getReturnVisitOrders() {
		return returnVisitOrders;
	}

	public void setReturnVisitOrders(ReturnVisitOrders returnVisitOrders) {
		this.returnVisitOrders = returnVisitOrders;
	}

	public AppealOrders getAppealOrders() {
		return appealOrders;
	}

	public void setAppealOrders(AppealOrders appealOrders) {
		this.appealOrders = appealOrders;
	}

	public WaterMeterOrders getWaterMeterOrders() {
		return waterMeterOrders;
	}

	public void setWaterMeterOrders(WaterMeterOrders waterMeterOrders) {
		this.waterMeterOrders = waterMeterOrders;
	}

	public MeterReadingOrders getMeterReadingOrders() {
		return meterReadingOrders;
	}

	public void setMeterReadingOrders(MeterReadingOrders meterReadingOrders) {
		this.meterReadingOrders = meterReadingOrders;
	}

	public InspectorOrder getInspectorOrder() {
		return inspectorOrder;
	}

	public void setInspectorOrder(InspectorOrder inspectorOrder) {
		this.inspectorOrder = inspectorOrder;
	}

	public ConstructionCheckOrders getConstructionCheckOrders() {
		return constructionCheckOrders;
	}

	public void setConstructionCheckOrders(
			ConstructionCheckOrders constructionCheckOrders) {
		this.constructionCheckOrders = constructionCheckOrders;
	}

	public ConstructionInspectionOrders getConstructionInspectionOrders() {
		return constructionInspectionOrders;
	}

	public void setConstructionInspectionOrders(
			ConstructionInspectionOrders constructionInspectionOrders) {
		this.constructionInspectionOrders = constructionInspectionOrders;
	}

	public ConstructionAcceptanceOrders getConstructionAcceptanceOrders() {
		return constructionAcceptanceOrders;
	}

	public void setConstructionAcceptanceOrders(
			ConstructionAcceptanceOrders constructionAcceptanceOrders) {
		this.constructionAcceptanceOrders = constructionAcceptanceOrders;
	}

	public RepairOrders getRepairOrders() {
		return repairOrders;
	}

	public void setRepairOrders(RepairOrders repairOrders) {
		this.repairOrders = repairOrders;
	}

	public ClaimToCustomerOrders getClaimToCustomerOrders() {
		return claimToCustomerOrders;
	}

	public void setClaimToCustomerOrders(ClaimToCustomerOrders claimToCustomerOrders) {
		this.claimToCustomerOrders = claimToCustomerOrders;
	}

	public int getTaskOutType() {
		return taskOutType;
	}

	public void setTaskOutType(int taskOutType) {
		this.taskOutType = taskOutType;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	
}