package com.flf.mapper;

import java.util.List;

import com.flf.entity.ChargeTypeDetails;

/**
 * 
 * @author maogaofei
 * @date 2016年6月29日 下午3:44:50
 */
public interface ChargeTypeDetailsMapper {
	//根据主键删除
    int deleteByPrimaryKey(String chargeTypeDetailsId);
    //插入对象中所有字段
    int insert(ChargeTypeDetails record);
    //根据条件插入对象字段
    int insertSelective(ChargeTypeDetails record);
    //根据主键查询
    
    //根据更新时间和ID删除
    int deleteTimeId(ChargeTypeDetails record);
    
    ChargeTypeDetails selectByPrimaryKey(String chargeTypeDetailsId);
    //根据条件修改对象属性
    int updateByPrimaryKeySelective(ChargeTypeDetails record);
    //修改对象所有属性
    int updateByPrimaryKey(ChargeTypeDetails record);
    /**
     * 根据条件查询收费类型详情列表
     * @author maogaofei
     * @date 2016年7月1日 上午9:21:47
     * @param chargeTypeDetails
     * @return
     */
	List<ChargeTypeDetails> listAllCharegeTypeDetails(ChargeTypeDetails chargeTypeDetails);
	//通过收费项目ID删除详情列表
    int deleteByChargeTypeId(String chargeTypeId);
    //通过收费项目ID查询所有项目列表
	List<ChargeTypeDetails> getChargeTypeDetailsById(String chargeTypeId);
	ChargeTypeDetails getCode();
}