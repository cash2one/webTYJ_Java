package com.flf.entity;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.format.annotation.DateTimeFormat;
@XmlRootElement(name = "TcArticle")
public class TcArticle {
    private String articleId;//物品id

    private String articleName;//物品名称

    private String articleDescribe;//物品描述

    private Integer state;//状态（0是拾到物品，1是遗失物品）

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId == null ? null : articleId.trim();
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName == null ? null : articleName.trim();
    }

    public String getArticleDescribe() {
        return articleDescribe;
    }

    public void setArticleDescribe(String articleDescribe) {
        this.articleDescribe = articleDescribe == null ? null : articleDescribe.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}