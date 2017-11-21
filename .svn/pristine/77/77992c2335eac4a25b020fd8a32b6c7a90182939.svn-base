package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CorePosition") //核心岗位表
public class CorePosition {
    private String corePositionId; // 核心岗位 id

    private String staffId; // 人员id

    private String postId;  // 岗位id

    private Byte state;  // 是否为项目经理
    
    
    private String staffName; //员工姓名
    
    private String staffNo;//员工工号
    
    public String getStaffNo() {
		return staffNo;
	}

	public void setStaffNo(String staffNo) {
		this.staffNo = staffNo;
	}

	private String telphone;//员工联系电话
    
  

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	private List<Post> post; //核心岗位id集合
    
    private Staff staff;
    
    private String nameOfCustom;  //岗位名称
    
    private Date createTime; //创建时间
     
    public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	private Page page;

	public String getNameOfCustom() {
		return nameOfCustom;
	}

	public void setNameOfCustom(String nameOfCustom) {
		this.nameOfCustom = nameOfCustom;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getCorePositionId() {
        return corePositionId;
    }

    public void setCorePositionId(String corePositionId) {
        this.corePositionId = corePositionId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}