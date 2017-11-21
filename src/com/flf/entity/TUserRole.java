package com.flf.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 用户岗位表
 * @author wangzhou
 *
 */
@XmlRootElement(name="TUserRole")
public class TUserRole {
	
	//主键
    private String id;

    //用户id
    private String userId;

    //角色id
    private String roleId;
    
    //关联用户
    private TUser tUser;
    
    //分页
    private Page page;
    
	private String roleType;
	
	//关联角色
	private TRole tRole;
	
	private Date createTime;
	
	 public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

	public TUser gettUser() {
		return tUser;
	}

	public void settUser(TUser tUser) {
		this.tUser = tUser;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public TRole gettRole() {
		return tRole;
	}

	public void settRole(TRole tRole) {
		this.tRole = tRole;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}