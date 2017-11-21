package com.flf.mapper;

import java.util.List;

import com.flf.entity.ActualConsumptionRecords;

public interface ActualConsumptionRecordsMapper {
	
	//删除维修单
    int deleteByPrimaryKey(String consumptionRecordId);

    //增加维修单
    int insert(ActualConsumptionRecords record);

    //增加维修单
    int insertSelective(ActualConsumptionRecords record);

    //根据工单id查询工单
    ActualConsumptionRecords selectByPrimaryKey(String consumptionRecordId);

    //修改维修单
    int updateByPrimaryKeySelective(ActualConsumptionRecords record);

    //修改维修单
    int updateByPrimaryKey(ActualConsumptionRecords record);
    
    /**
     * 根据工单id查询关联的资源消耗记录
     * @param orderId
     * @return
     */
    List<ActualConsumptionRecords> listRecordsByOrderId(String orderId);
}