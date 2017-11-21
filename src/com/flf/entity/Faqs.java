package com.flf.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 服务请求FAQ表
 * @author wangzhou
 *
 */
@XmlRootElement(name="Faqs")
public class Faqs {
	
	//问题id
    private String faqQuestionId;

    //问题编号
    private String faqQuestionNum;

    //问题状态
    private Byte faqQuestionState;

    //问题内容
    private String faqQuestionName;

    //答案
    private String faqQuestionAnswer;

    //faq类别id
    private String faqTypeId;

    //关键字
    private String keyword;

    //创建人id
    private String crePersonId;

    //创建时间
    private Date creTime;
    
    //关联客户id
    private String personCustId;
    
    //关联客户
    private PersonCustNew personCustNew;
    
    //关联分页属性
    private Page page;
    
    //关联FAQ类型
    private FaqTypes faqTypes;
    
    //查询条件
    private String condition;
    
    //关联staff
    private Staff staff;

    public String getFaqQuestionId() {
        return faqQuestionId;
    }

    public void setFaqQuestionId(String faqQuestionId) {
        this.faqQuestionId = faqQuestionId;
    }

    public String getFaqQuestionNum() {
        return faqQuestionNum;
    }

    public void setFaqQuestionNum(String faqQuestionNum) {
        this.faqQuestionNum = faqQuestionNum;
    }

    public Byte getFaqQuestionState() {
        return faqQuestionState;
    }

    public void setFaqQuestionState(Byte faqQuestionState) {
        this.faqQuestionState = faqQuestionState;
    }

    public String getFaqQuestionName() {
        return faqQuestionName;
    }

    public void setFaqQuestionName(String faqQuestionName) {
        this.faqQuestionName = faqQuestionName;
    }

    public String getFaqQuestionAnswer() {
        return faqQuestionAnswer;
    }

    public void setFaqQuestionAnswer(String faqQuestionAnswer) {
        this.faqQuestionAnswer = faqQuestionAnswer;
    }

    public String getFaqTypeId() {
        return faqTypeId;
    }

    public void setFaqTypeId(String faqTypeId) {
        this.faqTypeId = faqTypeId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getCrePersonId() {
        return crePersonId;
    }

    public void setCrePersonId(String crePersonId) {
        this.crePersonId = crePersonId;
    }

    public Date getCreTime() {
        return creTime;
    }

    public void setCreTime(Date creTime) {
        this.creTime = creTime;
    }

	public String getPersonCustId() {
		return personCustId;
	}

	public void setPersonCustId(String personCustId) {
		this.personCustId = personCustId;
	}

	public PersonCustNew getPersonCustNew() {
		return personCustNew;
	}

	public void setPersonCustNew(PersonCustNew personCustNew) {
		this.personCustNew = personCustNew;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public FaqTypes getFaqTypes() {
		return faqTypes;
	}

	public void setFaqTypes(FaqTypes faqTypes) {
		this.faqTypes = faqTypes;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}
}