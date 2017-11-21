package com.flf.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 问题类别表
 * @author wangzhou
 *
 */
@XmlRootElement(name="FaqTypes")
public class FaqTypes {
	
	//问题类别id
    private String faqTypeId;

    //问题类别名称
    private String faqTypeName;

    //创建时间
    private Date creTime;

    //创建人
    private String crePersonId;

    public String getFaqTypeId() {
        return faqTypeId;
    }

    public void setFaqTypeId(String faqTypeId) {
        this.faqTypeId = faqTypeId;
    }

    public String getFaqTypeName() {
        return faqTypeName;
    }

    public void setFaqTypeName(String faqTypeName) {
        this.faqTypeName = faqTypeName;
    }

    public Date getCreTime() {
        return creTime;
    }

    public void setCreTime(Date creTime) {
        this.creTime = creTime;
    }

    public String getCrePersonId() {
        return crePersonId;
    }

    public void setCrePersonId(String crePersonId) {
        this.crePersonId = crePersonId;
    }
}