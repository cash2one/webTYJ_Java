package com.flf.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 问题日志记录表
 * @author wnagzhou
 *
 */
@XmlRootElement(name="FaqJournals")
public class FaqJournals {
	
	//问题日志记录表主键
    private String faqJournalId;

    //关联对象id
    private String relationId;

    //操作人id
    private String operatorId;

    //状态变更
    private String changeState;

    //操作说明
    private String operationRemarks;

    //操作时间
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date operationTime;

    public String getFaqJournalId() {
        return faqJournalId;
    }

    public void setFaqJournalId(String faqJournalId) {
        this.faqJournalId = faqJournalId;
    }

    public String getRelationId() {
        return relationId;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getChangeState() {
        return changeState;
    }

    public void setChangeState(String changeState) {
        this.changeState = changeState;
    }

    public String getOperationRemarks() {
        return operationRemarks;
    }

    public void setOperationRemarks(String operationRemarks) {
        this.operationRemarks = operationRemarks;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }
}