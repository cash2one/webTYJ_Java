package com.flf.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 功能权限
 * @author wangzhou
 *
 */
@XmlRootElement(name="HrPermissions")
public class HrPermissions {
    private String permissionsId;    //功能主键
 
    private String permissionsName;   //功能名称

    private String permissionsAddress; //功能地址

    private String permissionsDescription;//功能描述

    private String permissionsType;//功能匪类

    private Byte status;//功能标识，默认0为开启
    
    private List<Action> actionList;//操作权限集合

    public String getPermissionsId() {
        return permissionsId;
    }

    public void setPermissionsId(String permissionsId) {
        this.permissionsId = permissionsId;
    }

    public String getPermissionsName() {
        return permissionsName;
    }

    public void setPermissionsName(String permissionsName) {
        this.permissionsName = permissionsName;
    }

    public String getPermissionsAddress() {
        return permissionsAddress;
    }

    public void setPermissionsAddress(String permissionsAddress) {
        this.permissionsAddress = permissionsAddress;
    }

    public String getPermissionsDescription() {
        return permissionsDescription;
    }

    public void setPermissionsDescription(String permissionsDescription) {
        this.permissionsDescription = permissionsDescription;
    }

    public String getPermissionsType() {
        return permissionsType;
    }

    public void setPermissionsType(String permissionsType) {
        this.permissionsType = permissionsType;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

	public List<Action> getActionList() {
		return actionList;
	}

	public void setActionList(List<Action> actionList) {
		this.actionList = actionList;
	}
}