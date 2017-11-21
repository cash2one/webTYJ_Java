package com.flf.mapper;

import java.util.List;

import com.flf.entity.AreaDivision;

public interface AreaDivisionMapper {
    int deleteByPrimaryKey(String areaDivisionId);

    int insert(AreaDivision record);

    int insertSelective(AreaDivision record);

    AreaDivision selectByPrimaryKey(String areaDivisionId);

    int updateByPrimaryKeySelective(AreaDivision record);

    int updateByPrimaryKey(AreaDivision record);
    
    /**
     * 根据产品id查询关联的面积划分表数据
     * @param productId
     * @return list
     */
    List<AreaDivision> listAreaDivisionByProductId(String productId);
    
    /**
     * 根据产品id删除关联的面积划分表数据
     * @param productId
     * @return
     */
    int deleteByProductId(String productId);
    
}