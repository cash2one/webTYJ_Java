package com.flf.mapper;

import java.util.List;

import com.flf.entity.RepairOrders;

public interface RepairOrdersMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(RepairOrders record);

    int insertSelective(RepairOrders record);

    RepairOrders selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(RepairOrders record);

    int updateByPrimaryKey(RepairOrders record);
    
    /**
     * 查询所有维修单信息
     * @return
     */
    List<RepairOrders> listAllRepairOrders();
}