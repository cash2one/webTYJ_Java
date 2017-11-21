package com.flf.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
/*Created by Administrator on 2015/6/3. 
author:尹磊
修改时间：2015/6/3  修改人：尹磊 */
@XmlRootElement(name = "Teamworkstaff")
public class Teamworkstaff {
    private String id;  //团队人员编制关系ID 

    private String teamworkId;// 团队id

    private String staffId;  //人员id
    
    private String prepareId; // 编制id
    
    private String postId;//岗位id
    
    private String projectId; //项目id
    
    private String professionalLineId; //专业线id
   
    private Staff staff;  //关联人员表
    
    private Teamwork teamwork;  //关联团队表
    
    private Prepare prepare; //关联编制表
    
    private Post post; //关联岗位表
    
    private Project project; //关联项目表
    
    private List<Teamworkstaff> teamwrokstaffs;
    
    private List<Staff> staffs; 
    
    private String staffName;//员工姓名
    
    private String telphone;//员工电话
    
    private Page page;//分页
    
    private Integer state;//关系启用状态0启用，1弃用

	private String specialtyName;//专业线名称
	
    private SpecialtyInfo specialtyInfo;//专业线
    
    private String markState;//图标显示状态
    
    private String projectName;//项目名称

    public String getMarkState() {
		return markState;
	}

	public void setMarkState(String markState) {
		this.markState = markState;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}
    
    public SpecialtyInfo getSpecialtyInfo() {
		return specialtyInfo;
	}

	public void setSpecialtyInfo(SpecialtyInfo specialtyInfo) {
		this.specialtyInfo = specialtyInfo;
	}

	public String getSpecialtyName() {
		return specialtyName;
	}

	public void setSpecialtyName(String specialtyName) {
		this.specialtyName = specialtyName;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getStaffName() {
		return staffName;
	}
    
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
    
    public String getProfessionalLineId() {
		return professionalLineId;
	}

	public void setProfessionalLineId(String professionalLineId) {
		this.professionalLineId = professionalLineId;
	}

	public List<Staff> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<Staff> staffs) {
		this.staffs = staffs;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public List<Teamworkstaff> getTeamwrokstaffs() {
		return teamwrokstaffs;
	}

	public void setTeamwrokstaffs(List<Teamworkstaff> teamwrokstaffs) {
		this.teamwrokstaffs = teamwrokstaffs;
	}

	public String getPrepareId() {
		return prepareId;
	}

	public void setPrepareId(String prepareId) {
		this.prepareId = prepareId;
	}

	public Prepare getPrepare() {
		return prepare;
	}

	public void setPrepare(Prepare prepare) {
		this.prepare = prepare;
	}

	private List<Teamworkstaff> teamworkstaffs;

	public Teamwork getTeamwork() {
		return teamwork;
	}

	public void setTeamwork(Teamwork teamwork) {
		this.teamwork = teamwork;
	}

	public List<Teamworkstaff> getTeamworkstaffs() {
		return teamworkstaffs;
	}

	public void setTeamworkstaffs(List<Teamworkstaff> teamworkstaffs) {
		this.teamworkstaffs = teamworkstaffs;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeamworkId() {
        return teamworkId;
    }

    public void setTeamworkId(String teamworkId) {
        this.teamworkId = teamworkId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}