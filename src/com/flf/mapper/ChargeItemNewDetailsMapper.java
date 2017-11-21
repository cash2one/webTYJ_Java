package com.flf.mapper;

import java.util.List;

import com.flf.entity.ChargeItemNewDetails;

/**
 * 
 * @author maogaofei
 * @date 2016年6月29日 下午3:46:44
 */
public interface ChargeItemNewDetailsMapper {
	//根据主键删除
    int deleteByPrimaryKey(String chargeItemDetailsId);
    //插入对象中所有字段
    int insert(ChargeItemNewDetails record);
    //根据条件插入对象字段
    int insertSelective(ChargeItemNewDetails record);
    //根据主键查询
    ChargeItemNewDetails selectByPrimaryKey(String chargeItemDetailsId);
    //根据条件修改对象属性
    int updateByPrimaryKeySelective(ChargeItemNewDetails record);
    //修改对象所有属性
    int updateByPrimaryKey(ChargeItemNewDetails record);
    /**
     * 根据收费类型详情ID和收费项目ID查询收费类型详情
     * @author maogaofei
     * @date 2016年7月1日 上午10:55:06
     * @param chargeTypeDetailsId
     * @param chargeItemNewId
     * @return
     */
	ChargeItemNewDetails getCIDByCtdAndCin(String chargeTypeDetailsId,
			String chargeItemNewId);
	/**
	 * 根据条件查询所有的收费项目详情列表
	 * @author maogaofei
	 * @date 2016年7月5日 下午2:00:23
	 * @param cid
	 * @return
	 */
	List<ChargeItemNewDetails> listAllChargeItemNewDetails(
			ChargeItemNewDetails chargeItemNewDetails);
}