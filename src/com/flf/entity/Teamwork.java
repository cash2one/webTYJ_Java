package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;

import com.flf.request.propertyService;
/*Created by Administrator on 2015/6/3. 
author:尹磊
修改时间：2015/6/3  修改人：尹磊 */
@XmlRootElement(name = "Teamwork")//�Ŷӹ�����
public class Teamwork {
    private String id;  //团队工作id

    private String manage; //团队工作信息

    private Integer teamMembers; //团队工作成员

    private String teamName; //团队名称

    private String teamMajor; 	//团队主管

    private String leader; //负责人

    private String managementItem;//管理项目

    private String projectId;//项目id
    
    private String instanceId;//公司id
    
    private Integer teamworkAmount; //团队人数
    
    private Project project;//项目    

	private String staffName;//员工姓名
	
private String corePositionId;//核心岗位id

	private String corePostNumber;//核心岗位数
    
    public String getCorePositionId() {
		return corePositionId;
	}

	public void setCorePositionId(String corePositionId) {
		this.corePositionId = corePositionId;
	}
    
    public String getStaffName() {
		return staffName;
	}
    
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
    
    private Page page;
    
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	private Staff staff; 
    
    public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Integer getTeamworkAmount() {
		return teamworkAmount;
	}

	public void setTeamworkAmount(Integer teamworkAmount) {
		this.teamworkAmount = teamworkAmount;
	}

	public String getId() {
        return id;
    }

    public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public void setId(String id) {
        this.id = id;
    }

    public String getManage() {
        return manage;
    }

    public void setManage(String manage) {
        this.manage = manage;
    }

    public Integer getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(Integer teamMembers) {
        this.teamMembers = teamMembers;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamMajor() {
        return teamMajor;
    }

    public void setTeamMajor(String teamMajor) {
        this.teamMajor = teamMajor;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getManagementItem() {
        return managementItem;
    }

    public void setManagementItem(String managementItem) {
        this.managementItem = managementItem;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

	public String getCorePostNumber() {
		return corePostNumber;
	}

	public void setCorePostNumber(String corePostNumber) {
		this.corePostNumber = corePostNumber;
	}
}