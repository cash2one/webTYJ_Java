package com.flf.mapper;

import java.util.List;

import com.flf.entity.BuildingStructureNew;
import com.flf.entity.ChargeItemNewBuilding;

/**
 * @author maogaofei
 * @date 2016年6月29日 下午4:15:09
 */
public interface ChargeItemNewBuildingMapper {
	//根据主键删除
    int deleteByPrimaryKey(String chargeItemNewBuildingId);
    //插入对象中所有字段
    int insert(ChargeItemNewBuilding record);
    //根据条件插入对象字段
    int insertSelective(ChargeItemNewBuilding record);
    //根据主键查询
    ChargeItemNewBuilding selectByPrimaryKey(String chargeItemNewBuildingId);
    //根据条件修改对象属性
    int updateByPrimaryKeySelective(ChargeItemNewBuilding record);
    //修改对象所有属性
    int updateByPrimaryKey(ChargeItemNewBuilding record);
    /**
     * 根据条件查询收费项目建筑关系列表
     * @author maogaofei
     * @date 2016年6月30日 上午11:57:38
     * @return
     */
	List<ChargeItemNewBuilding> listAllChargeItemNewBuilding(ChargeItemNewBuilding chargeItemNewBuilding);
	/**
	 * 批量插入收费项目建筑关系
	 * @author maogaofei
	 * @date 2016年7月25日 上午11:11:42
	 * @param cinbList
	 */
	int insertBatch(List<ChargeItemNewBuilding> cinbList);
	/**
	 * 获取建筑面积总和
	 * @author maogaofei
	 * @date 2016年7月25日 下午2:36:09
	 * @param bsnList
	 * @return
	 */
	Double getTotalArea(List<BuildingStructureNew> bsnList);
}