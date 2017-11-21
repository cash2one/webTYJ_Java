package com.flf.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 面积管理
 * @author niming
 *
 */
@XmlRootElement(name = "AreaTypeNew") 
public class AreaTypeNew {
	
    private String id;   //面积管理id
    
    private String areaTypeCode;	//面积管理代号

    private String areaTypeName;  //面积类型名称

    private String remark;  //备注
    
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm")
    private Date createTime;  //创建时间

	private Page page;  //分页
    
    public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAreaTypeCode() {
    	return areaTypeCode;
    }
    
    public void setAreaTypeCode(String areaTypeCode) {
    	this.areaTypeCode = areaTypeCode;
    }
    
    public String getAreaTypeName() {
        return areaTypeName;
    }

	public void setAreaTypeName(String areaTypeName) {
        this.areaTypeName = areaTypeName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}