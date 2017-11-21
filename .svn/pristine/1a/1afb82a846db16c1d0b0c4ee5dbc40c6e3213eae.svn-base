package com.flf.mapper;

import java.util.List;

import com.flf.entity.ChargeItemNew;

/**
 * 
 * @author maogaofei
 * @date 2016年6月29日 下午3:36:37
 */
public interface ChargeItemNewMapper {
	//根据主键删除
    int deleteByPrimaryKey(String chargeItemNewId);
    //插入对象中所有字段
    int insert(ChargeItemNew record);
    //根据条件插入对象字段
    int insertSelective(ChargeItemNew record);
    //根据主键查询
    ChargeItemNew selectByPrimaryKey(String chargeItemNewId);
    //根据条件修改对象属性
    int updateByPrimaryKeySelective(ChargeItemNew record);
    //修改对象所有属性
    int updateByPrimaryKey(ChargeItemNew record);
    /**
     * 根据条件查询收费项目列表
     * @author maogaofei
     * @date 2016年6月30日 上午11:49:21
     * @param cin
     * @return
     */
	List<ChargeItemNew> listAllChargeItemNew(ChargeItemNew chargeItemNew);
}