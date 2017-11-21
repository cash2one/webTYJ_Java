package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "PendingApproval")//审核代办表
public class PendingApproval {
    private String pendingApprovalId;

    private Byte types;//（0vip申请1vip失效申请2重点申请3重点失效申请）

    private String theme;    
    
    private String custId;//用于查询（校验用）

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public Byte getTypes() {
		return types;
	}

	public void setTypes(Byte types) {
		this.types = types;
	}

	public Date getCurrentDates() {
		return currentDates;
	}

	public void setCurrentDates(Date currentDates) {
		this.currentDates = currentDates;
	}

	public PersonVip getPersonVip() {
		return personVip;
	}

	public void setPersonVip(PersonVip personVip) {
		this.personVip = personVip;
	}

	private Date currentDates;
    
    private PersonVip personVip;
    
    private PersonEmphasis  personEmphasis;   
  

	private List<Teamworkstaff> teamworkstaff;//团队人员对象
	
	private PersonCustNew personCustNew;//客户
	
	
	public PersonCustNew getPersonCustNew() {
		return personCustNew;
	}

	public void setPersonCustNew(PersonCustNew personCustNew) {
		this.personCustNew = personCustNew;
	}

	public List<Teamworkstaff> getTeamworkstaff() {
		return teamworkstaff;
	}

	public void setTeamworkstaff(List<Teamworkstaff> teamworkstaff) {
		this.teamworkstaff = teamworkstaff;
	}

	private List<Annex> vipList;//vip附件列表
	
	public List<Annex> getVipList() {
		return vipList;
	}

	public void setVipList(List<Annex> vipList) {
		this.vipList = vipList;
	}

	public List<Annex> getEmphasisList() {
		return emphasisList;
	}

	public void setEmphasisList(List<Annex> emphasisList) {
		this.emphasisList = emphasisList;
	}

	private List<Annex> emphasisList;//重点客户附件列表
    
    public PersonVip getPersonvip() {
		return personVip;
	}

	public void setPersonvip(PersonVip personVip) {
		this.personVip = personVip;
	}

	public PersonEmphasis getPersonEmphasis() {
		return personEmphasis;
	}

	public void setPersonEmphasis(PersonEmphasis personEmphasis) {
		this.personEmphasis = personEmphasis;
	}	   
    
    public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	private Page page ;

    public String getPendingApprovalId() {
        return pendingApprovalId;
    }

    public void setPendingApprovalId(String pendingApprovalId) {
        this.pendingApprovalId = pendingApprovalId;
    }


    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

}