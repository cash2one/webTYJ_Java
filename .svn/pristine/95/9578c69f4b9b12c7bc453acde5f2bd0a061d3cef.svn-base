package com.flf.mapper;

import java.util.List;

import com.flf.entity.RenovationAcceptanceOrders;

/**
 * 装修验收单Mapper
 * @author 倪明
 * 2015/08/19
 */
public interface RenovationAcceptanceOrdersMapper {
	
	List<RenovationAcceptanceOrders> listAllRenovationAcceptanceOrders();   //查询所有装修验收单
	
	int insertRenovationAcceptanceOrders(RenovationAcceptanceOrders renovationAcceptanceOrders);   //新增装修验收单
	
	int insertRenovationAcceptanceOrdersUUID(RenovationAcceptanceOrders renovationAcceptanceOrders);   //新增装修验收单UUID
	
	RenovationAcceptanceOrders getRenovationAcceptanceOrdersbyId(String orderId);   //根据id查询装修验收单
	
	int updateRenovationAcceptanceOrders(RenovationAcceptanceOrders renovationAcceptanceOrders);   //修改装修验收单
	
	RenovationAcceptanceOrders getRenovationAcceptanceOrdersbyTaskId(String taskId);   //根据任务id查询验收单
	
	RenovationAcceptanceOrders getRenovationAcceptanceOrdersbyTypeAndTaskId(String orderType,String taskId);   //根据工单类型和任务id查询验收单

}
