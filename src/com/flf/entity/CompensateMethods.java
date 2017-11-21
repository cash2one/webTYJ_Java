package com.flf.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * 赔偿方案
 * 创建人：邵政
 * 创建时间：2015/6/25
 */
@XmlRootElement(name="CompensateMethods")
public class CompensateMethods {
    private String compensateMethodId;//方案id

    private String taskId;//关联任务id

    private String orderId;//关联工单id

    private String customerId;//关联赔偿对象id

    private Double compensateSum;//赔付金额

    private Integer compensateMeans;//赔付方式（物业费、水费）  1水费 2电费 3现金 4停车费 5物业费 6服务费

    private Integer compensateCycle;//赔付周期   0 一次性   周期1-12个月
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date compensateStartTime;//赔付开始时间
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date compensateEndTime;//赔付结束时间
    
    private Page page;

    public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

    public String getCompensateMethodId() {
        return compensateMethodId;
    }

    public void setCompensateMethodId(String compensateMethodId) {
        this.compensateMethodId = compensateMethodId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    public Double getCompensateSum() {
		return compensateSum;
	}

	public void setCompensateSum(Double compensateSum) {
		this.compensateSum = compensateSum;
	}

	public Integer getCompensateMeans() {
		return compensateMeans;
	}

	public void setCompensateMeans(Integer compensateMeans) {
		this.compensateMeans = compensateMeans;
	}

    public Date getCompensateStartTime() {
        return compensateStartTime;
    }

    public void setCompensateStartTime(Date compensateStartTime) {
        this.compensateStartTime = compensateStartTime;
    }

    public Date getCompensateEndTime() {
        return compensateEndTime;
    }

    public void setCompensateEndTime(Date compensateEndTime) {
        this.compensateEndTime = compensateEndTime;
    }

	public Integer getCompensateCycle() {
		return compensateCycle;
	}

	public void setCompensateCycle(Integer compensateCycle) {
		this.compensateCycle = compensateCycle;
	}
}