package com.flf.mapper;

import java.util.List;

import com.flf.entity.RenovationCheckOrders;

/**
 * 装修核查单Mapper
 * @author 倪明
 *2015/08/18
 */
public interface RenovationCheckOrdersMapper {

	List<RenovationCheckOrders> listAllRenovationCheckOrders();   //查询所有装修核查单
	
	int insertRenovationCheckOrders(RenovationCheckOrders renovationCheckOrders);   //新增装修核查单
	
	int insertRenovationCheckOrdersUUID(RenovationCheckOrders renovationCheckOrders);   //新增装修核查单UUID
	
	RenovationCheckOrders getRenovationCheckOrdersbyId(String orderId);   //根据id查询装修核查单
	
	int updateRenovationCheckOrders(RenovationCheckOrders renovationCheckOrders);   //修改装修核查单
	
	RenovationCheckOrders getRenovationCheckOrdersbyTaskId(String taskId);    //根据任务id查询核查单
	RenovationCheckOrders getRenovationCheckOrdersbyTypeAndTaskId(String orderType,String taskId);
	
	
}
