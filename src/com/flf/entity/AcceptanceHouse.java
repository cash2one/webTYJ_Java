package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
/**
 * @see <code>验房管理，验房活动记录</code>
 * @author zhuwei
 * @date 2015-07-17
 */
@XmlRootElement(name = "AcceptanceHouse")
public class AcceptanceHouse {

	private String id;//验房活动id
	private String personInCharge;//验房活动团队负责人
	private String personInChargeName;//验房活动团队负责人姓名
	private Date startDate;//验房活动开始时间
	private Date endDate;//验房活动结束时间
	private String acceptanceType;//验房活动类型：默认为验房类型
	private String issuer;//验房活动发布人
	private Date issuerDate;//验房活动发布日期
	private String projectId;//验房项目id
	private String serviceRequestId;//验房服务请求id
	private List<Tasks> finishNum;
	private List<Tasks> allNum;
	private List<AcceptanceHouseRelation> ahrList;//验房活动关系集合（包含了人员建筑结构关系）
	private Page page;
	
	private TUser issuerName;//验房人姓名
    
	
    public TUser getIssuerName() {
		return issuerName;
	}

	public void setIssuerName(TUser issuerName) {
		this.issuerName = issuerName;
	}

	public Page getPage() {
    	if(this.page==null){
    		this.page=new Page();
    	}
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
	public String getPersonInCharge() {
		return personInCharge;
	}
	public void setPersonInCharge(String personInCharge) {
		this.personInCharge = personInCharge;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getAcceptanceType() {
		return acceptanceType;
	}
	public void setAcceptanceType(String acceptanceType) {
		this.acceptanceType = acceptanceType;
	}
	public String getIssuer() {
		return issuer;
	}
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}
	public Date getIssuerDate() {
		return issuerDate;
	}
	public void setIssuerDate(Date issuerDate) {
		this.issuerDate = issuerDate;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getServiceRequestId() {
		return serviceRequestId;
	}

	public void setServiceRequestId(String serviceRequestId) {
		this.serviceRequestId = serviceRequestId;
	}

	public List<Tasks> getFinishNum() {
		return finishNum;
	}

	public void setFinishNum(List<Tasks> finishNum) {
		this.finishNum = finishNum;
	}

	public List<Tasks> getAllNum() {
		return allNum;
	}

	public void setAllNum(List<Tasks> allNum) {
		this.allNum = allNum;
	}

	public List<AcceptanceHouseRelation> getAhrList() {
		return ahrList;
	}
	public void setAhrList(List<AcceptanceHouseRelation> ahrList) {
		this.ahrList = ahrList;
	}
	public String getPersonInChargeName() {
		return personInChargeName;
	}
	public void setPersonInChargeName(String personInChargeName) {
		this.personInChargeName = personInChargeName;
	}
	
}
