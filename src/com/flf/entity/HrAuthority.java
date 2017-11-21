package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 用户团队关联表
 * @author wangzhou
 *
 */
@XmlRootElement(name="HrAuthority")
public class HrAuthority {
    private String authorityId;

    private String tUserId;

    private String corePositionId;

	private Integer type;
    
    private String projectOrTeamName;
    
    private String powerName;
    
    private String permissionsId;
    
    private HrPermissions permissions;	//功能权限表  朱琪 2016.03.04
    
    private String teamworkId;
    
    private String projectId;
    
   
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

	public Integer getType() {
 		return type;
 	}

 	public void setType(Integer type) {
 		this.type = type;
 	}
	public String getProjectOrTeamName() {
		return projectOrTeamName;
	}

	public void setProjectOrTeamName(String projectOrTeamName) {
		this.projectOrTeamName = projectOrTeamName;
	}

	public String getPowerName() {
		return powerName;
	}

	public void setPowerName(String powerName) {
		this.powerName = powerName;
	}

	public String getPermissionsId() {
		return permissionsId;
	}

	public void setPermissionsId(String permissionsId) {
		this.permissionsId = permissionsId;
	}

    public String getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(String authorityId) {
        this.authorityId = authorityId;
    }

    public String gettUserId() {
        return tUserId;
    }

    public void settUserId(String tUserId) {
        this.tUserId = tUserId;
    }

    public String getCorePositionId() {
        return corePositionId;
    }

    public void setCorePositionId(String corePositionId) {
        this.corePositionId = corePositionId;
    }

	public HrPermissions getPermissions() {
		return permissions;
	}

	public void setPermissions(HrPermissions permissions) {
		this.permissions = permissions;
	}
}