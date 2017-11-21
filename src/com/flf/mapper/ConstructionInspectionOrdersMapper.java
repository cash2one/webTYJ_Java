package com.flf.mapper;

import java.util.List;

import com.flf.entity.ConstructionInspectionOrders;

public interface ConstructionInspectionOrdersMapper {

	List<ConstructionInspectionOrders> listAllConstructionInspectionOrders();   //查询所有施工巡检单
	
	int insertConstructionInspectionOrders(ConstructionInspectionOrders constructionInspectionOrders);   //新增施工巡检单
	
	int insertConstructionInspectionOrdersUUID(ConstructionInspectionOrders constructionInspectionOrders);   //新增施工巡检单UUID
	
	ConstructionInspectionOrders getConstructionInspectionOrdersbyId(String orderId);   //根据id查询施工巡检单
	
	int updateConstructionInspectionOrders(ConstructionInspectionOrders constructionInspectionOrders);   //修改施工巡检单
	
	List<ConstructionInspectionOrders> getConstructionInspectionOrdersbyTaskId(String taskId);    //根据任务id查询巡检单
	ConstructionInspectionOrders getConstructionInspectionOrdersbyTypeAndTaskId(String orderType,String taskId);    //根据任务id查询核查单

}
