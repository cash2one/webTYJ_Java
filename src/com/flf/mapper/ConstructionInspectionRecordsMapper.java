package com.flf.mapper;

import java.util.List;

import com.flf.entity.ConstructionInspectionRecords;

public interface ConstructionInspectionRecordsMapper {

	//新增巡检结果记录表
	int insertConstructionInspectionRecords(ConstructionInspectionRecords constructionInspectionRecords);
	//根据工单id获取记录信息
	List<ConstructionInspectionRecords> getConstructionInspectionRecordsbyOrderId(String orderId);
}
