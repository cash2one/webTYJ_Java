package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;

/*
 * 岗位类型表
 */
@XmlRootElement(name = "PostType") 
public class PostType {
    private Integer postTypeId;//岗位类型id

    private Integer divisionId;//岗位类型名称
    
    private String postTypeName;//部门id

    private String remark;//备注

    
    
    public Integer getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(Integer divisionId) {
		this.divisionId = divisionId;
	}

	public Integer getPostTypeId() {
        return postTypeId;
    }

    public void setPostTypeId(Integer postTypeId) {
        this.postTypeId = postTypeId;
    }

    public String getPostTypeName() {
        return postTypeName;
    }

    public void setPostTypeName(String postTypeName) {
        this.postTypeName = postTypeName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}