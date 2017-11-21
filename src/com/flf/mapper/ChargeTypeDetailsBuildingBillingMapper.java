package com.flf.mapper;

import java.util.List;

import com.flf.entity.ChargeTypeDetailsBuildingBilling;

/**
 * @author maogaofei
 * @date 2016年7月9日 下午2:03:16
 */
public interface ChargeTypeDetailsBuildingBillingMapper {
	//根据主键删除
    int deleteByPrimaryKey(String chargeTypeDetailsBuildingBillingId);
    //插入对象中所有字段
    int insert(ChargeTypeDetailsBuildingBilling record);
    //根据条件插入对象字段
    int insertSelective(ChargeTypeDetailsBuildingBilling record);
    //根据主键查询
    ChargeTypeDetailsBuildingBilling selectByPrimaryKey(String chargeTypeDetailsBuildingBillingId);
    //根据条件修改对象属性
    int updateByPrimaryKeySelective(ChargeTypeDetailsBuildingBilling record);
    //修改对象所有属性
    int updateByPrimaryKey(ChargeTypeDetailsBuildingBilling record);
    /**
     * 根据条件查询收费项目详情建筑计费列表
     * @author maogaofei
     * @date 2016年7月11日 上午11:09:08
     * @return
     */
	List<ChargeTypeDetailsBuildingBilling> listAllChargeTypeDetailsBuildingBilling(ChargeTypeDetailsBuildingBilling chargeTypeDetailsBuildingBilling);
}