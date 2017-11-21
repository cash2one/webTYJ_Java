package com.flf.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;
@XmlRootElement(name = "Functional") 
public class Functional {
	private String functionalId;//功能区id
	
	private String functionalNo;	//功能区间编号

    private String functionalName;//功能区名称

    private String createrName;  //创建人

    private @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")Date createrDate; //创建时间
    
    private String createId;	//创建人id

    private String updateName; //修改人

    private @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")Date updateDate; //修改时间
    
    private String updateId;	//修改人id

    private Page page;
    
    private TUser staff;	//关联创建人  王洲 2016.1.6
    
    private TUser staffs;	//关联修改人  王洲 2016.1.6
    
    
    public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getFunctionalId() {
        return functionalId;
    }

    public void setFunctionalId(String functionalId) {
        this.functionalId = functionalId;
    }

    public String getFunctionalNo() {
		return functionalNo;
	}

	public void setFunctionalNo(String functionalNo) {
		this.functionalNo = functionalNo;
	}

	public String getFunctionalName() {
        return functionalName;
    }

    public void setFunctionalName(String functionalName) {
        this.functionalName = functionalName;
    }

    public String getCreaterName() {
        return createrName;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName;
    }

    public Date getCreaterDate() {
        return createrDate;
    }

    public void setCreaterDate(Date createrDate) {
        this.createrDate = createrDate;
    }

    public String getCreateId() {
		return createId;
	}

	public void setCreateId(String createId) {
		this.createId = createId;
	}

	public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}

	public TUser getStaff() {
		return staff;
	}

	public void setStaff(TUser staff) {
		this.staff = staff;
	}

	public TUser getStaffs() {
		return staffs;
	}

	public void setStaffs(TUser staffs) {
		this.staffs = staffs;
	}
}