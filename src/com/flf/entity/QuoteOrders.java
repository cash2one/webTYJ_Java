package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * 报价工单表
 * 创建人：邵政
 * 创建时间：2015/6/24
 */
@XmlRootElement(name = "QuoteOrders")
public class QuoteOrders {
	
    private String orderId;//报价工单id
    private Integer orderType;//工单类型
    private Integer orderState; //工单状态  0关闭 1完成
    private String taskId;//任务id
    private String serviceRequestId;//服务请求id
    private String operatorId;//操作人id
    private Date finishTime;//完成时间
    private Long allTotal;//全部总价
    private String remarks;//备注说明
    private String closeTime;//关闭时间
    private String closePerson;//关闭操作人
    private String closeRemarks;//关闭原因
    private String discount;//折扣
    private Double finalPrice;//最终价格
    
    private String changeStateRemarks; //修改状态备注
    private Staff staff;//关联员工表
    private List<QuoteItemRecords> itemRecords; //报价项纪录表
    private List<Annex> annexs;//附件表
    private String signature;  //签字人
//    private Tasks Tasks;//关联任务表
//    
//    private ServiceRequest serviceRequest;//关联服务请求表
    
//    private Page page;
//
//    public Page getPage() {
//		return page;
//	}
//
//	public void setPage(Page page) {
//		this.page = page;
//	}

    public Integer getOrderState() {
		return orderState;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getCloseRemarks() {
		return closeRemarks;
	}

	public void setCloseRemarks(String closeRemarks) {
		this.closeRemarks = closeRemarks;
	}

	public String getChangeStateRemarks() {
		return changeStateRemarks;
	}

	public void setChangeStateRemarks(String changeStateRemarks) {
		this.changeStateRemarks = changeStateRemarks;
	}

	public String getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}

	public String getClosePerson() {
		return closePerson;
	}

	public void setClosePerson(String closePerson) {
		this.closePerson = closePerson;
	}

	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
	}

	public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderType() {
		return orderType;
	}

	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}

	public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getServiceRequestId() {
        return serviceRequestId;
    }

    public void setServiceRequestId(String serviceRequestId) {
        this.serviceRequestId = serviceRequestId;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Long getAllTotal() {
        return allTotal;
    }

    public void setAllTotal(Long allTotal) {
        this.allTotal = allTotal;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public List<QuoteItemRecords> getItemRecords() {
		return itemRecords;
	}

	public void setItemRecords(List<QuoteItemRecords> itemRecords) {
		this.itemRecords = itemRecords;
	}
//	public Tasks getTasks() {
//		return Tasks;
//	}
//
//	public void setTasks(Tasks tasks) {
//		Tasks = tasks;
//	}
//
//	public ServiceRequest getServiceRequest() {
//		return serviceRequest;
//	}
//
//	public void setServiceRequest(ServiceRequest serviceRequest) {
//		this.serviceRequest = serviceRequest;
//	}

	public List<Annex> getAnnexs() {
		return annexs;
	}

	public void setAnnexs(List<Annex> annexs) {
		this.annexs = annexs;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public Double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(Double finalPrice) {
		this.finalPrice = finalPrice;
	}
}