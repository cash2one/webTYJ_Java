package com.flf.mapper;

import java.util.List;

import com.flf.entity.ConstructionCheckOrders;

public interface ConstructionCheckOrdersMapper {

	List<ConstructionCheckOrders> listAllConstructionCheckOrders();   //查询所有施工核查单
	
	int insertConstructionCheckOrders(ConstructionCheckOrders constructionCheckOrders);   //新增施工核查单
	
	int insertConstructionCheckOrdersUUID(ConstructionCheckOrders constructionCheckOrders);   //新增施工核查单UUID
	
	ConstructionCheckOrders getConstructionCheckOrdersbyId(String orderId);   //根据id查询施工核查单
	
	int updateConstructionCheckOrders(ConstructionCheckOrders constructionCheckOrders);   //修改施工核查单
	
	List<ConstructionCheckOrders> getConstructionCheckOrdersbyTaskId(String taskId);    //根据任务id查询核查单
	ConstructionCheckOrders getConstructionCheckOrdersbyTypeAndTaskId(String orderType,String taskId);    //根据任务id查询核查单
}
