package com.flf.mapper;

import java.util.List;

import com.flf.entity.ChargeTypeProjectBilling;

/**
 * @author maogaofei
 * @date 2016年7月9日 下午2:03:16
 */
public interface ChargeTypeProjectBillingMapper {
	//根据主键删除
    int deleteByPrimaryKey(String chargeTypeProjectBillingId);
    //插入对象中所有字段
    int insert(ChargeTypeProjectBilling record);
    //根据条件插入对象字段
    int insertSelective(ChargeTypeProjectBilling record);
    //根据主键查询
    ChargeTypeProjectBilling selectByPrimaryKey(String chargeTypeProjectBillingId);
    //根据条件修改对象属性
    int updateByPrimaryKeySelective(ChargeTypeProjectBilling record);
    //修改对象所有属性
    int updateByPrimaryKey(ChargeTypeProjectBilling record);
    /**
     * 根据条件分页查询收费类型项目计费列表
     * @author maogaofei
     * @date 2016年7月9日 下午4:40:06
     * @param chargeTypeProjectBilling
     * @return
     */
	List<ChargeTypeProjectBilling> listPageChargeTypeProjectBilling(
			ChargeTypeProjectBilling chargeTypeProjectBilling);
	/**
	 * 根据条件查询收费类型项目计费列表
	 * @author maogaofei
	 * @date 2016年7月12日 上午9:43:14
	 * @param chargeTypeProjectBilling
	 * @return
	 */
	List<ChargeTypeProjectBilling> listAllChargeTypeProjectBilling(
			ChargeTypeProjectBilling chargeTypeProjectBilling);
}