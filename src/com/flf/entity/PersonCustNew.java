package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;
@XmlRootElement(name = "PersonCustNew")
public class PersonCustNew {
    private String custId;  //客户id
    
    private String userId; //用户id

	private String custCode;  //客户编号

    private String name;//姓名

    private String sex;//性别

    private String nativePlace;//籍贯

    private String census;//户口所在地

    private @DateTimeFormat(pattern="yyyy-MM-dd")Date birthday;//出生日期
    
    private String s_Birthday;//导出用生日字段

    private String cardType;//证件类型

    private String cardNum;//证件号码

    private String jiajiaNum;//家家客户端id

    private String weixinNum;//微信帐号

    private String workUnits;//工作单位

    private String position;//职务

    private Byte marrieState;//婚否

    private Byte eduLevel;//学历

    private String social;//社会关系(需要询问)

    private Byte landscape;//政治面貌

    private String hobby; //兴趣爱好

    private String custLevel;//客户等级

    private Byte isEnterprise;//是否有企业联系

    private String urgentContactPerson;//紧急联系人

    private String urgentContactPhone;//紧急联系电话

    private String uploadImage;//上传图片

    private String phoneNum;//电话号码   
    
    private Page page;
    
    private PersonBuildingNew personBuildingNew;//人员建筑结构关系
    
    private String projectId;//项目id

    private String custType;//客户类型（查询用）
    
    private String custIds;//custId的集合
    
    private List<String> bsnList;//建筑结构集合(查询用)    

	private String registerPhone;//注册电话
    
    private String email;//电子邮件
    
	private List<Annex> annexs; //上传资料实体	
	
	private Integer age;
	
	private String vipId;//vip客户id
	
    private String emphasisId;//重点客户id
	
	private String reviewState;//审核状态
	
	private String applystatus;//审核状态
	
	private String phoneNum1;//电话号码  
	
	private String phoneNum2;//电话号码
	
	private String nation;//民族
	
	private String marry;//婚否导出显示用
	
	
	private String marrieString;//婚否，excel导出
	
	private String companyId;// 公司id
	
	private String enterpriseId;
	
	
	public String getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}



	private	List<PersonCustNew> personCustNews;
	
	

	public List<PersonCustNew> getPersonCustNews() {
		return personCustNews;
	}

	public void setPersonCustNews(List<PersonCustNew> personCustNews) {
		this.personCustNews = personCustNews;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getMarrieString() {
		return marrieString;
	}

	public void setMarrieString(String marrieString) {
		this.marrieString = marrieString;
	}

	public String getMarry() {
		return marry;
	}

	public void setMarry(String marry) {
		this.marry = marry;
	}



	private PersonCustNew personCustNew;
	
	public PersonCustNew getPersonCustNew() {
		return personCustNew;
	}

	public void setPersonCustNew(PersonCustNew personCustNew) {
		this.personCustNew = personCustNew;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}



	private String applystype;
	
	public String getApplystype() {
		return applystype;
	}

	public void setApplystype(String applystype) {
		this.applystype = applystype;
	}

	public String getApplystype1() {
		return applystype1;
	}

	public void setApplystype1(String applystype1) {
		this.applystype1 = applystype1;
	}



	private String applystype1;
	
	public String getPhoneNum1() {
		return phoneNum1;
	}

	public void setPhoneNum1(String phoneNum1) {
		this.phoneNum1 = phoneNum1;
	}

	public String getPhoneNum2() {
		return phoneNum2;
	}

	public void setPhoneNum2(String phoneNum2) {
		this.phoneNum2 = phoneNum2;
	}

	
	public String getVipId() {
		return vipId;
	}

	public void setVipId(String vipId) {
		this.vipId = vipId;
	}

	public String getEmphasisId() {
		return emphasisId;
	}

	public void setEmphasisId(String emphasisId) {
		this.emphasisId = emphasisId;
	}

	public String getReviewState() {
		return reviewState;
	}

	public void setReviewState(String reviewState) {
		this.reviewState = reviewState;
	}

	public String getApplystatus() {
		return applystatus;
	}

	public void setApplystatus(String applystatus) {
		this.applystatus = applystatus;
	}

	

	/***********用于租赁管理的客户信息分页查询*****************/
	private String staffName;//客户姓名
	private String phone;//客户电话
	private String idNum;//身份证号
	

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	/**********************************/
    
    public List<Annex> getAnnexs() {
		return annexs;
	}

	public void setAnnexs(List<Annex> annexs) {
		this.annexs = annexs;
	}
    
    public String getRegisterPhone() {
		return registerPhone;
	}

	public void setRegisterPhone(String registerPhone) {
		this.registerPhone = registerPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getCustCode() {
        return custCode;
    }

    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getCensus() {
        return census;
    }

    public void setCensus(String census) {
        this.census = census;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getJiajiaNum() {
        return jiajiaNum;
    }

    public void setJiajiaNum(String jiajiaNum) {
        this.jiajiaNum = jiajiaNum;
    }

    public String getWeixinNum() {
        return weixinNum;
    }

    public void setWeixinNum(String weixinNum) {
        this.weixinNum = weixinNum;
    }

    public String getWorkUnits() {
        return workUnits;
    }

    public void setWorkUnits(String workUnits) {
        this.workUnits = workUnits;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Byte getMarrieState() {
        return marrieState;
    }

    public void setMarrieState(Byte marrieState) {
        this.marrieState = marrieState;
    }

    public Byte getEduLevel() {
        return eduLevel;
    }

    public void setEduLevel(Byte eduLevel) {
        this.eduLevel = eduLevel;
    }

    public String getSocial() {
        return social;
    }

    public void setSocial(String social) {
        this.social = social;
    }

    public Byte getLandscape() {
        return landscape;
    }

    public void setLandscape(Byte landscape) {
        this.landscape = landscape;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public Byte getIsEnterprise() {
        return isEnterprise;
    }

    public void setIsEnterprise(Byte isEnterprise) {
        this.isEnterprise = isEnterprise;
    }

    public String getUrgentContactPerson() {
        return urgentContactPerson;
    }

    public void setUrgentContactPerson(String urgentContactPerson) {
        this.urgentContactPerson = urgentContactPerson;
    }

    public String getUrgentContactPhone() {
        return urgentContactPhone;
    }

    public void setUrgentContactPhone(String urgentContactPhone) {
        this.urgentContactPhone = urgentContactPhone;
    }

    public String getUploadImage() {
        return uploadImage;
    }

    public void setUploadImage(String uploadImage) {
        this.uploadImage = uploadImage;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

	public PersonBuildingNew getPersonBuildingNew() {
		return personBuildingNew;
	}

	public void setPersonBuildingNew(PersonBuildingNew personBuildingNew) {
		this.personBuildingNew = personBuildingNew;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public List<String> getBsnList() {
		return bsnList;
	}

	public void setBsnList(List<String> bsnList) {
		this.bsnList = bsnList;
	}

	public String getCustIds() {
		return custIds;
	}

	public void setCustIds(String custIds) {
		this.custIds = custIds;
	}

	public String getS_Birthday() {
		return s_Birthday;
	}

	public void setS_Birthday(String s_Birthday) {
		this.s_Birthday = s_Birthday;
	}

    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}