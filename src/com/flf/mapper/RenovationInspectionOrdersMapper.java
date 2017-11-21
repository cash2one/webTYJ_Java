package com.flf.mapper;

import java.util.List;

import com.flf.entity.RenovationInspectionOrders;

/**
 * 装修巡检单Mapper
 * @author 倪明
 *2015/08/18
 */
public interface RenovationInspectionOrdersMapper {

	List<RenovationInspectionOrders> listAllRenovationInspectionOrders();    //查询所有装修巡检单
	
	int insertRenovationInspectionOrders(RenovationInspectionOrders renovationInspectionOrders);   //新增装修巡检单
	
	int insertRenovationInspectionOrdersUUID(RenovationInspectionOrders renovationInspectionOrders);   //新增装修巡检单UUID
	
	RenovationInspectionOrders getRenovationInspectionOrdersbyId(String orderId);   //根据id查询装修 巡检单
	
	int updateRenovationInspectionOrders(RenovationInspectionOrders renovationInspectionOrders);   //修改装修巡检单
	
	RenovationInspectionOrders getRenovationInspectionOrdersbyTaskId(String taskId);   //根据任务id查询巡检单
	RenovationInspectionOrders getRenovationInspectionOrdersbyTypeAndTaskId(String orderType,String taskId);   //根据工单类型和任务id查询巡检单
}
