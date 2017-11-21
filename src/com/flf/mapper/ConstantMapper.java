package com.flf.mapper;

import java.util.List;

import com.flf.entity.Constant;

/**
 * @author maogaofei
 * @date 2016年7月8日 下午1:04:37
 */
public interface ConstantMapper {
	//根据主键删除
    int deleteByPrimaryKey(String constantId);
    //插入对象中所有字段
    int insert(Constant record);
    //根据条件插入对象字段
    int insertSelective(Constant record);
    //根据主键查询
    Constant selectByPrimaryKey(String constantId);
    //根据条件修改对象属性
    int updateByPrimaryKeySelective(Constant record);
    //修改对象所有属性
    int updateByPrimaryKey(Constant record);
    /**
     * 根据收费类型ID查询所有的常量
     * @author maogaofei
     * @date 2016年7月8日 下午1:50:29
     * @param chargeTypeId
     * @return
     */
    List<Constant> getConstantListByChargeTypeId(String chargeTypeId);
    /**
     * 查询常量表中父级元素
     * @author maogaofei
     * @date 2016年7月8日 下午1:51:47
     * @return
     */
    List<Constant> getParentConstantList();
}