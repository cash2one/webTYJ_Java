package com.flf.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;
@XmlRootElement(name = "TcArticleState")
public class TcArticleState {
    private String articleStateId;//遗失物品关系id

    private String articleId;//物品id

    private String custId;//失主id,也可以是拾取人id，通过遗失物品表中的state判断
    
    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss")//拾到时间
    private Date time;

    private String site;//地点描述

    private String remark;//备注

    private Integer state;//0关系开启，1关系关闭
    
    private TcArticle article;//遗失物品
    
    private PersonCustNew person;//失主或者拾取人
    
    private PersonCustNew claimer;//领取人

	private TcArticleGet articleGet;//领取物品表对象

	private Integer lostState;//遗失物品类别0为拾取的物品，1为丢失的物品
    
    private Page page;
    
    public TcArticleGet getArticleGet() {
		return articleGet;
	}

	public void setArticleGet(TcArticleGet articleGet) {
		this.articleGet = articleGet;
	}
    
    
    public PersonCustNew getClaimer() {
 		return claimer;
 	}

 	public void setClaimer(PersonCustNew claimer) {
 		this.claimer = claimer;
 	}
    
    public Integer getLostState() {
		return lostState;
	}

	public void setLostState(Integer lostState) {
		this.lostState = lostState;
	}

    
    public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public TcArticle getArticle() {
		return article;
	}

	public void setArticle(TcArticle article) {
		this.article = article;
	}

	public PersonCustNew getPerson() {
		return person;
	}

	public void setPerson(PersonCustNew person) {
		this.person = person;
	}
    
    public String getArticleStateId() {
        return articleStateId;
    }

    public void setArticleStateId(String articleStateId) {
        this.articleStateId = articleStateId == null ? null : articleStateId.trim();
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId == null ? null : articleId.trim();
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

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site == null ? null : site.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}