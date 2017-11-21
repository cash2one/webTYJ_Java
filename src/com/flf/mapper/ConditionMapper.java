package com.flf.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.flf.entity.Condition;

public interface ConditionMapper {
	/*查询所有的条件信息*/
	List<Condition> listAllCondition();
	/*分页查询条件信息*/
    List<Condition> listPageCondition(Condition condition);
    /*根据id查询条件信息*/
    Condition getConditionById(String conditionId);
    /*删除条件信息*/
    int deleteCondition(String conditionId);
    /*新增条件信息*/
    int insertCondition(Condition condition);
    /*修改条件信息*/
    int updateCondition(Condition condition);
    
    /**
     * 根据公式id查询条件
     * @param formulaId
     * @return
     */
    public List<Condition> getConditionByFormulaId(String formulaId);
}