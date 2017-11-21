package com.flf.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

//用户角色表
@XmlRootElement(name = "UserPost")

public class UserPost { 
    private String id;     //主键id
 
    private String userId; //用户id

    private String postId; //岗位id

    private String createPersonId;//创建人id

    private Date createDate;//创建时间

    private String lastModifyId;//最后修改人id

    private Date lastModifyDate;//最后修改时间

    private Byte state;//关系启用状态

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId == null ? null : postId.trim();
    }

    public String getCreatePersonId() {
        return createPersonId;
    }

    public void setCreatePersonId(String createPersonId) {
        this.createPersonId = createPersonId == null ? null : createPersonId.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getLastModifyId() {
        return lastModifyId;
    }

    public void setLastModifyId(String lastModifyId) {
        this.lastModifyId = lastModifyId == null ? null : lastModifyId.trim();
    }

    public Date getLastModifyDate() {
        return lastModifyDate;
    }

    public void setLastModifyDate(Date lastModifyDate) {
        this.lastModifyDate = lastModifyDate;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}