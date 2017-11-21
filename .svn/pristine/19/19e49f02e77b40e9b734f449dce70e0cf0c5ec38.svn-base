package com.flf.entity;


import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
  * @ClassName: 重点客户信息表
  * @Description: TODO
  * @author chenjie
  * @date 2015-8-6 下午15:35:55
  *
 */
@XmlRootElement(name = "PersonEmphasis")
public class PersonEmphasis {
//	人员ID，姓名，申请理由、上传申请的资料、申请时间、审核状态、未通过原因、身份证号码、联系电话

    private String emphasisId;  //重点客户id

    private String username;//客户姓名username

    private String applyreason;  //申请理由 applyreason

    private List<Annex> applyfilepath;//上传申请的资料路径applyfilepath

    private @DateTimeFormat(pattern="yyyy-MM-dd")Date applydate;//申请日期applydate
    
    private @DateTimeFormat(pattern="yyyy-MM-dd")Date applyeddate;//审核日期applyeddate

	private int applystatus ;//审核状态applystatus(0待审核1完成2驳回)

    private String failreason; //未通过原因failreason
    
    private String idcard;//身份证号码idcard
    
    private String phonenum;//联系电话phonenum

	private String enterpriseId;//企业客户id

    private String custId;  //个人客户id
    
    private String approvalId;//审批代办id
    
    public Byte getApplystype() {
		return applystype;
	}

	public void setApplystype(Byte applystype) {
		this.applystype = applystype;	}

	private Byte applystype;//申请类型(2申请3失效申请)
	private String theme;
	
	private Byte applystype1;//申请类型(2申请3失效申请)
	public Byte getApplystype1() {
		return applystype1;
	}

	public void setApplystype1(Byte applystype1) {
		this.applystype1 = applystype1;
	}

	public String getTheme1() {
		return theme1;
	}

	public void setTheme1(String theme1) {
		this.theme1 = theme1;
	}

	private String theme1;
    
    public String getApprovalId() {
		return approvalId;
	}

	public void setApprovalId(String approvalId) {
		this.approvalId = approvalId;
	}

	private PersonCustNew personCustNew;  //个人客户对象
    
    private EnterpriseCustNew  enterpriseCustNew; //企业客户对象
    
    public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	
    
    private Page page;

	public String getEmphasisId() {
		return emphasisId;
	}

	public void setEmphasisId(String emphasisId) {
		this.emphasisId = emphasisId;
	}

	   
    public String getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getApplyreason() {
		return applyreason;
	}

	public void setApplyreason(String applyreason) {
		this.applyreason = applyreason;
	}


	public Date getApplydate() {
		return applydate;
	}

	public void setApplydate(Date applydate) {
		this.applydate = applydate;
	}

	public int getApplystatus() {
		return applystatus;
	}

	public void setApplystatus(int applystatus) {
		this.applystatus = applystatus;
	}

	public String getFailreason() {
		return failreason;
	}

	public void setFailreason(String failreason) {
		this.failreason = failreason;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public PersonCustNew getPersonCustNew() {
		return personCustNew;
	}

	public void setPersonCustNew(PersonCustNew personCustNew) {
		this.personCustNew = personCustNew;
	}

	public EnterpriseCustNew getEnterpriseCustNew() {
		return enterpriseCustNew;
	}

	public void setEnterpriseCustNew(EnterpriseCustNew enterpriseCustNew) {
		this.enterpriseCustNew = enterpriseCustNew;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
    

    public Date getApplyeddate() {
		return applyeddate;
	}

	public void setApplyeddate(Date applyeddate) {
		this.applyeddate = applyeddate;
	}

	public List<Annex> getApplyfilepath() {
		return applyfilepath;
	}

	public void setApplyfilepath(List<Annex> applyfilepath) {
		this.applyfilepath = applyfilepath;
	}
}