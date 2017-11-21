package com.flf.mapper;

import java.util.List;

import com.flf.entity.ConstructionAcceptanceRecords;

public interface ConstructionAcceptanceRecordsMapper {

	//新增验收结果记录表
	int insertConstructionAcceptanceRecords(ConstructionAcceptanceRecords constructionAcceptanceRecords);
	//根据工单id获取记录信息
	List<ConstructionAcceptanceRecords> getConstructionAcceptanceRecordsbyOrderId(String orderId);
}
