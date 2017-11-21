package com.flf.mapper;

import java.util.List;
import java.util.Map;

import com.flf.entity.Formula;

/**
 * 
 * @author maogaofei
 * @date 2016年7月1日 下午3:07:43
 */
public interface FormulaMapper {
	//根据主键删除
    int deleteByPrimaryKey(String formulaId);
    //插入对象中所有字段
    int insert(Formula record);
    //根据条件插入对象字段
    int insertSelective(Formula record);
    //根据主键查询
    Formula selectByPrimaryKey(String formulaId);
    //根据条件修改对象属性
    int updateByPrimaryKeySelective(Formula record);
    //修改对象所有属性
    int updateByPrimaryKey(Formula record);
    /**
     * 根据条件查询公式列表
     * @author maogaofei
     * @date 2016年7月1日 下午3:07:39
     * @param formula
     * @return
     */
	List<Formula> listAllFormula(Formula formula);
	
	/**
	 * 支付系统 接口调用
	 * @return
	 */
	List<Formula> getChargeItemDetailId(Map<String,Object> map);
	List<Formula> getFormularInfo(Map<String,Object> map);
}