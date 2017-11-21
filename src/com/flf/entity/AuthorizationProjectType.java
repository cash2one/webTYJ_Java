package com.flf.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "AuthorizationProjectType") 
//授权项目类型表
public class AuthorizationProjectType {
    private String authorizationProjectId;

    private String authorizationProjectName;

    public String getAuthorizationProjectId() {
        return authorizationProjectId;
    }

    public void setAuthorizationProjectId(String authorizationProjectId) {
        this.authorizationProjectId = authorizationProjectId;
    }

    public String getAuthorizationProjectName() {
        return authorizationProjectName;
    }

    public void setAuthorizationProjectName(String authorizationProjectName) {
        this.authorizationProjectName = authorizationProjectName;
    }
}