package com.flf.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
//FAQ
@XmlRootElement(name = "Faq")
public class Faq {
    private String id;//ID

    private String headline;//标题

    private String content;//内容

    private Date date;//日期
    
	private String faqNum;//faq编号
	
	private byte faqState;//faq使用状态
     
	private Page page;
	
	 public byte getFaqState() {
			return faqState;
		}
		public void setFaqState(byte faqState) {
			this.faqState = faqState;
		}

    
    public String getFaqNum() {
		return faqNum;
	}
	public void setFaqNum(String faqNum) {
		this.faqNum = faqNum;
	}
    
	public Page getPage() {
   		return page;
   	}
   	public void setPage(Page page) {
   		this.page = page;
   	}

    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}