package com.flf.mapper;

import java.util.List;

import com.flf.entity.ComponentProperty;
import com.flf.entity.InspectorOrder;

public interface InspectorOrderMapper {
	InspectorOrder getInspectorOrderBytaskId(String taskId);
	int insertInspectorOrder(InspectorOrder inspectorOrder);//添加验房工单
	int insertInspectorOrderUUID(InspectorOrder inspectorOrder);//添加验房工单
    List<InspectorOrder> listAllInspectorOrder();//查询所有验房工单信息
    InspectorOrder getInspectorOrderbyId(String orderId);//通过Id查询验房工单
    int updateInspectorOrder(InspectorOrder inspectorOrder);//修改验房工单
    List<ComponentProperty> getInspectorOrderBySRId(String buildingStructureId);//根据建筑结构id查询资产，功能区
}