package com.flf.mapper;

import java.util.List;

import com.flf.entity.ChargeTypeBuildingBilling;

/**
 * @author maogaofei
 * @date 2016年7月9日 下午2:03:16
 */
public interface ChargeTypeBuildingBillingMapper {
	//根据主键删除
    int deleteByPrimaryKey(String chargeTypeBuildingBillingId);
    //插入对象中所有字段
    int insert(ChargeTypeBuildingBilling record);
    //根据条件插入对象字段
    int insertSelective(ChargeTypeBuildingBilling record);
    //根据主键查询
    ChargeTypeBuildingBilling selectByPrimaryKey(String chargeTypeBuildingBillingId);
    //根据条件修改对象属性
    int updateByPrimaryKeySelective(ChargeTypeBuildingBilling record);
    //修改对象所有属性
    int updateByPrimaryKey(ChargeTypeBuildingBilling record);
    /**
     * 根据条件分页查询收费类型建筑计费列表
     * @author maogaofei
     * @date 2016年7月9日 下午5:26:57
     * @param chargeTypeBuildingBilling
     * @return
     */
	List<ChargeTypeBuildingBilling> listPageChargeTypeBuildingBilling(
			ChargeTypeBuildingBilling chargeTypeBuildingBilling);
	/**
	 * 根据条件查询收费类型建筑计费列表
	 * @author maogaofei
	 * @date 2016年7月12日 上午10:21:14
	 * @param chargeTypeBuildingBilling
	 * @return
	 */
	List<ChargeTypeBuildingBilling> listAllChargeTypeBuildingBilling(
			ChargeTypeBuildingBilling chargeTypeBuildingBilling);
}