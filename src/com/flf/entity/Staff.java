package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Staff")
// 员工表
public class Staff {
	private String staffId;// 员工id

	private String companyId;// 公司id

	private String staffNumber;// 员工编号

	private String staffNo;//员工工号
	
	private String id;  //团队人员编制关系ID 
	
	private String addState;//添加用状态 朱琪 2016.03.02

	public String getStaffNo() {
		return staffNo;
	}

	public void setStaffNo(String staffNo) {
		this.staffNo = staffNo;
	}

	private String firstName;// 姓氏

	private String lastName;// 名字

	private String firstNameSpell;// 姓氏拼音

	private String lastNameSpell;// 名字拼音

	private Integer sex;// 性别

	private String nativePlace;// 籍贯

	private Integer married;// 婚否

	private String eduLever;// 学历

	private Integer landscape;// 政治面貌

	private Date birthday;// 出生日期

	private String hobby;// 兴趣爱好

	private Integer cardType;// 证件类型

	private String cardNum;// 证件号码

	private String address;// 地址

	private String telphone;// 电话

	private String email;// 邮箱

	private String qq;// QQ号码

	private Integer position;// 职务

	private Division division;// 部门对象

	private String divisionId;// 部门id

	private String divisionname; // 部门名称

	private String postId; // 岗位ID

	private int workCount; // 连续上班天数

	private String teamworkId;// 团队id

	private int colorState;// 判断员工的颜色状态(0不能操作,1可操作,2空闲)

	private List<Annex> annexs; // 上传附件

	private String roleType;// 角色类型	
	
	private Integer processStatus;//'处理状态(-2、已离职；-1、不通过；0、未处理[待检测]；1、[已检测]待回复；2、[已回复]待审核；3、[已审核]已完成；)'

	//工作流审批页面使用以下三个字段

	private String specialtyName;//部门	
	
	private String nameOfCustom;//岗位名称
	
	private String userId;//用户ID
	
	private String cashierStatus;// 收银员审批状态（0没有交账权限 1有交账权限）
	private String cashierLeaderStatus;// 收银组长审批状态（0没有交账权限 1有交账权限）
	private String tellerStatus;// 出纳审批状态（0没有交账权限 1有交账权限）
	private String accountantStatus;// 会计审批状态（0没有交账权限 1有交账权限）
	
	private String userAppId;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCashierStatus() {
		return cashierStatus;
	}

	public void setCashierStatus(String cashierStatus) {
		this.cashierStatus = cashierStatus;
	}

	public String getCashierLeaderStatus() {
		return cashierLeaderStatus;
	}

	public void setCashierLeaderStatus(String cashierLeaderStatus) {
		this.cashierLeaderStatus = cashierLeaderStatus;
	}

	public String getTellerStatus() {
		return tellerStatus;
	}

	public void setTellerStatus(String tellerStatus) {
		this.tellerStatus = tellerStatus;
	}

	public String getAccountantStatus() {
		return accountantStatus;
	}

	public void setAccountantStatus(String accountantStatus) {
		this.accountantStatus = accountantStatus;
	}

	public String getNameOfCustom() {
		return nameOfCustom;
	}

	public void setNameOfCustom(String nameOfCustom) {
		this.nameOfCustom = nameOfCustom;
	}

	public String getSpecialtyName() {
		return specialtyName;
	}

	public void setSpecialtyName(String specialtyName) {
		this.specialtyName = specialtyName;
	}

	public List<Annex> getAnnexs() {
		return annexs;
	}

	public void setAnnexs(List<Annex> annexs) {
		this.annexs = annexs;
	}

	public int getColorState() {
		return colorState;
	}

	public void setColorState(int colorState) {
		this.colorState = colorState;
	}

	private String state;// 状态（0失效 1有效）

	private List<Staff> staffs;

	private Page page;
	private String staffName;// 员工姓名

	private String projectId;// 项目id

	private String instanceId;// 实例id
	/*
	 * 新建 肖聪 2015/6/1 新增年龄字段，用于页面显示
	 */
	private Integer age;// 新增年龄字段，用于页面显示

	private List<Post> post;

	private String s_birthday;// 导出字段（生日）

	private String cardType1;// 导出字段(证件类型)

	private String sex1;// 导出字段(性别)

	private String marry;// 导出字段婚否
	
	private String paramForSearch;//查询条件（工号或姓名），用于核心岗位任命处的查询  王洲  2016.02.29
	
	private List<Post> corePost;//员工关联的核心岗位
	
	private @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")java.util.Date entryDatetime;
	private @org.springframework.format.annotation.DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")java.util.Date quitDatetime;

	public String getMarry() {
		return marry;
	}

	public void setMarry(String marry) {
		this.marry = marry;
	}

	public String getSex1() {
		return sex1;
	}

	public void setSex1(String sex1) {
		this.sex1 = sex1;
	}

	public String getCardType1() {
		return cardType1;
	}

	public void setCardType1(String cardType1) {
		this.cardType1 = cardType1;
	}

	public String getS_birthday() {
		return s_birthday;
	}

	public void setS_birthday(String s_birthday) {
		this.s_birthday = s_birthday;
	}

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getTeamworkId() {
		return teamworkId;
	}

	public void setTeamworkId(String teamworkId) {
		this.teamworkId = teamworkId;
	}

	public List<Staff> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<Staff> staffs) {
		this.staffs = staffs;
	}

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

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getDivisionname() {
		return divisionname;
	}

	public void setDivisionname(String divisionname) {
		this.divisionname = divisionname;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public int getWorkCount() {
		return workCount;
	}

	public void setWorkCount(int workCount) {
		this.workCount = workCount;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDivisionId() {
		return divisionId;
	}

	public void setDivisionId(String divisionId) {
		this.divisionId = divisionId;
	}

	public Division getDivision() {
		return division;
	}

	public void setDivision(Division division) {
		this.division = division;
	}

	/*
	 * public List<Scheduling> getSchedulings() { return schedulings; }
	 * 
	 * public void setSchedulings(List<Scheduling> schedulings) {
	 * this.schedulings = schedulings; }
	 * 
	 * private List<Scheduling> schedulings;
	 */

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public String getStaffNumber() {
		return staffNumber;
	}

	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstNameSpell() {
		return firstNameSpell;
	}

	public void setFirstNameSpell(String firstNameSpell) {
		this.firstNameSpell = firstNameSpell;
	}

	public String getLastNameSpell() {
		return lastNameSpell;
	}

	public void setLastNameSpell(String lastNameSpell) {
		this.lastNameSpell = lastNameSpell;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public Integer getMarried() {
		return married;
	}

	public void setMarried(Integer married) {
		this.married = married;
	}

	public String getEduLever() {
		return eduLever;
	}

	public void setEduLever(String eduLever) {
		this.eduLever = eduLever;
	}

	public Integer getLandscape() {
		return landscape;
	}

	public void setLandscape(Integer landscape) {
		this.landscape = landscape;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Integer getCardType() {
		return cardType;
	}

	public void setCardType(Integer cardType) {
		this.cardType = cardType;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getParamForSearch() {
		return paramForSearch;
	}

	public void setParamForSearch(String paramForSearch) {
		this.paramForSearch = paramForSearch;
	}

	public String getAddState() {
		return addState;
	}

	public void setAddState(String addState) {
		this.addState = addState;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Post> getCorePost() {
		return corePost;
	}

	public void setCorePost(List<Post> corePost) {
		this.corePost = corePost;
	}

	public Integer getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(Integer processStatus) {
		this.processStatus = processStatus;
	}

	public String getUserAppId() {
		return userAppId;
	}

	public void setUserAppId(String userAppId) {
		this.userAppId = userAppId;
	}

	public java.util.Date getEntryDatetime() {
		return entryDatetime;
	}

	public void setEntryDatetime(java.util.Date entryDatetime) {
		this.entryDatetime = entryDatetime;
	}

	public java.util.Date getQuitDatetime() {
		return quitDatetime;
	}

	public void setQuitDatetime(java.util.Date quitDatetime) {
		this.quitDatetime = quitDatetime;
	}
	
}
