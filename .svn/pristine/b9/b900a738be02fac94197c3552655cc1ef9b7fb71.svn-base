package com.flf.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.format.annotation.DateTimeFormat;
@XmlRootElement(name = "TcArticleGet")
public class TcArticleGet {
    private String articleGetId;//物品领取id

    private String articleStateId;//遗失物品关系id

    private String custId;//领取人id
    
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private Date time;//领取时间

    public String getArticleGetId() {
        return articleGetId;
    }

    public void setArticleGetId(String articleGetId) {
        this.articleGetId = articleGetId == null ? null : articleGetId.trim();
    }

    public String getArticleStateId() {
        return articleStateId;
    }

    public void setArticleStateId(String articleStateId) {
        this.articleStateId = articleStateId == null ? null : articleStateId.trim();
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId == null ? null : custId.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}