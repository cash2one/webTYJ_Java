package com.flf.mapper;

import java.util.List;

import com.flf.entity.FaqTypes;

public interface FaqTypesMapper {
	
	/**
	 * 根据问题类型id删除问题类型
	 * @param faqTypeId
	 * @return
	 */
    int deleteByPrimaryKey(String faqTypeId);

    /**
     * 新增问题类型
     * @param record
     * @return
     */
    int insert(FaqTypes record);

    int insertSelective(FaqTypes record);

    /**
     * 根据问题类型id查询问题类型
     * @param faqTypeId
     * @return
     */
    FaqTypes selectByPrimaryKey(String faqTypeId);

    int updateByPrimaryKeySelective(FaqTypes record);

    /**
     * 修改问题类型
     * @param record
     * @return
     */
    int updateByPrimaryKey(FaqTypes record);
    
    /**
     * 查询所有问题类型
     * @param faqTypes
     * @return
     */
    List<FaqTypes> listFaqTypes(FaqTypes faqTypes);
    
    /**
     * 根据问题类型名称查询问题类型
     * @param faqTypeName
     * @return
     */
    FaqTypes getFaqTypesByfaqTypeName(String faqTypeName);
    
    /**
     * 根据问题类型名称查询此名称是否存在，全匹配查询
     * @param faqTypeName
     * @return
     */
    int getFaqTypesByName(String faqTypeName);
}