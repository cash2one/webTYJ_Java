package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

@XmlRootElement(name = "LeaseContract")
public class LeaseContract {
    private String contractId;//租赁合同id

    private String productBsId;//产品关系id
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date leaseStartDate;//租约开始日期
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date leaseEndDate;//租约结束日期
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date freeStartDate;//免租开始日期
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date freeEndDate;//免租结束日期

    private String strattach;//附件路径

    private String custId;//承租人id
    
    private ProductBs  productBs;//建筑产品关联表
    
    private PersonCustNew person;//承租人
    
    private Page page;
    
    private String payWay;//用于条件查询 支付方式

    private String rentType;//用于条件查询  递增类型
    
    private String projectId;//用于条件查询 项目id
    
    private String name;//用于条件查询 承接人姓名
    
    private Date deadTime;//快失效时间
    
    private Integer state;//判断失效，已失效的状态字段 0表示全部查询，1表示执行中，2表示快失效，3表示已失效
    
    private List<Annex> annexs;   //上传附件
    
    public List<Annex> getAnnexs() {
		return annexs;
	}

	public void setAnnexs(List<Annex> annexs) {
		this.annexs = annexs;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getDeadTime() {
		return deadTime;
	}

	public void setDeadTime(Date deadTime) {
		this.deadTime = deadTime;
	}

	public String getPayWay() {
		return payWay;
	}

	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}

	public String getRentType() {
		return rentType;
	}

	public void setRentType(String rentType) {
		this.rentType = rentType;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PersonCustNew getPerson() {
		return person;
	}

	public void setPerson(PersonCustNew person) {
		this.person = person;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}


    public ProductBs getProductBs() {
		return productBs;
	}

	public void setProductBs(ProductBs productBs) {
		this.productBs = productBs;
	}

	public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public String getProductBsId() {
        return productBsId;
    }

    public void setProductBsId(String productBsId) {
        this.productBsId = productBsId == null ? null : productBsId.trim();
    }

    public Date getLeaseStartDate() {
        return leaseStartDate;
    }

    public void setLeaseStartDate(Date leaseStartDate) {
        this.leaseStartDate = leaseStartDate;
    }

    public Date getLeaseEndDate() {
        return leaseEndDate;
    }

    public void setLeaseEndDate(Date leaseEndDate) {
        this.leaseEndDate = leaseEndDate;
    }

    public Date getFreeStartDate() {
        return freeStartDate;
    }

    public void setFreeStartDate(Date freeStartDate) {
        this.freeStartDate = freeStartDate;
    }

    public Date getFreeEndDate() {
        return freeEndDate;
    }

    public void setFreeEndDate(Date freeEndDate) {
        this.freeEndDate = freeEndDate;
    }

    public String getStrattach() {
        return strattach;
    }

    public void setStrattach(String strattach) {
        this.strattach = strattach == null ? null : strattach.trim();
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }
}