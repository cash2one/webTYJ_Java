package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 六.	施工单位关联表
 * @author 陶勇超
 *  2015-8-31
 */
@XmlRootElement(name="ConstructionAssociatedRecord")
public class ConstructionAssociatedRecord {
	private String recordId;//施工记录id
	private String applyId; //关联施工申请ID
	private String constructionId;  //施工公司id
	private String headId;    //现场负责人id
	private EnterpriseCustNew enterpriseCustNew; //关联企业信息
	private PersonCustNew   personCustNew;        //企业员工信息
	
	public EnterpriseCustNew getEnterpriseCustNew() {
		return enterpriseCustNew;
	}
	public void setEnterpriseCustNew(EnterpriseCustNew enterpriseCustNew) {
		this.enterpriseCustNew = enterpriseCustNew;
	}
	public PersonCustNew getPersonCustNew() {
		return personCustNew;
	}
	public void setPersonCustNew(PersonCustNew personCustNew) {
		this.personCustNew = personCustNew;
	}
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

	public String getConstructionId() {
		return constructionId;
	}
	public void setConstructionId(String constructionId) {
		this.constructionId = constructionId;
	}
	public String getHeadId() {
		return headId;
	}
	public void setHeadId(String headId) {
		this.headId = headId;
	}
	
	
}
