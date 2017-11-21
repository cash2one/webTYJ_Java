package com.flf.mapper;

import java.util.List;

import com.flf.entity.Faqs;

public interface FaqsMapper {
	
	/**
	 * 根据faqQuestionId删除FAQS
	 * @param faqQuestionId
	 * @return
	 */
    int deleteByPrimaryKey(String faqQuestionId);

    /**
     * 新增FAQS
     * @param record
     * @return
     */
    int insert(Faqs record);

    int insertSelective(Faqs record);

    /**
     * 根据faqQuestionId查询FAQS
     * @param faqQuestionId
     * @return
     */
    Faqs selectByPrimaryKey(String faqQuestionId);

    int updateByPrimaryKeySelective(Faqs record);

    /**
     * 根据faqQuestionId修改FAQS
     * @param record
     * @return
     */
    int updateByPrimaryKey(Faqs record);
    
    /**
     * 查询所有FAQS
     * @param faqs
     * @return
     */
    List<Faqs> listPageFaqs(Faqs faqs);
    
    /**
     * 查询所有待办faqs
     * @param faqs
     * @return
     */
    List<Faqs> listPageFaqsNoAnswer(Faqs faqs);
    
    /**
     * 根据faqs名称模糊查询faqs
     * @param faqQuestionName
     * @return
     */
    List<Faqs> getFaqsByfaqQuestionName(String faqQuestionName);
    
    /**
     * 根据faq的id将对应faq设置为失效
     * @param faqQuestionId
     * @return
     */
    int failFaqs(String faqQuestionId);
}