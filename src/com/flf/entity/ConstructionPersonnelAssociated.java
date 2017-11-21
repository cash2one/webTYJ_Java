package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 七.	施工人员关联表 
 * @author 陶勇超
 *  2015-8-31
 */
@XmlRootElement(name="ConstructionPersonnelAssociated")
public class ConstructionPersonnelAssociated {
	private String recordId ;  //记录ID
	private String applyId;    //关联施工申请ID
	private String personnelId;  //关联施工人员ID
	private String personnelName;  //关联施工人员姓名
	private String personnelPhone;  //关联施工人员电话
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getApplyId() {
		return applyId;
	}
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}
	public String getPersonnelId() {
		return personnelId;
	}
	public void setPersonnelId(String personnelId) {
		this.personnelId = personnelId;
	}
	public String getPersonnelName() {
		return personnelName;
	}
	public void setPersonnelName(String personnelName) {
		this.personnelName = personnelName;
	}
	public String getPersonnelPhone() {
		return personnelPhone;
	}
	public void setPersonnelPhone(String personnelPhone) {
		this.personnelPhone = personnelPhone;
	}
	
}
