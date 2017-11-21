package com.flf.mapper;

import java.util.List;

import com.flf.entity.ConstructionAcceptanceOrders;

public interface ConstructionAcceptanceOrdersMapper {

	List<ConstructionAcceptanceOrders> listAllConstructionAcceptanceOrders();   //查询所有施工验收单
	
	int insertConstructionAcceptanceOrders(ConstructionAcceptanceOrders constructionAcceptanceOrders);   //新增施工验收单
	
	int insertConstructionAcceptanceOrdersUUID(ConstructionAcceptanceOrders constructionAcceptanceOrders);   //新增施工验收单UUID
	
	ConstructionAcceptanceOrders getConstructionAcceptanceOrdersbyId(String orderId);   //根据id查询施工验收单
	
	int updateConstructionAcceptanceOrders(ConstructionAcceptanceOrders constructionAcceptanceOrders);   //修改施工验收单
	
	List<ConstructionAcceptanceOrders> getConstructionAcceptanceOrdersbyTaskId(String taskId);    //根据任务id查询验收单
	ConstructionAcceptanceOrders getConstructionAcceptanceOrdersbyTypeAndTaskId(String orderType,String taskId);    //根据任务id查询核查单

}
