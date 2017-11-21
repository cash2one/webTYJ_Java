package com.flf.mapper;

import java.util.List;

import com.flf.entity.InspectorRecord;

public interface InspectorRecordMapper {

	int insertInspectorRecord(InspectorRecord inspectorRecord);//添加验房工单记录信息
	List<InspectorRecord> getInspectorRecordbyOrderId(String orderId);//根据工单id获取验收工单
}
