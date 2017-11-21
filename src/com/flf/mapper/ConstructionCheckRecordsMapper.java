package com.flf.mapper;

import java.util.List;

import com.flf.entity.ConstructionCheckRecords;

/**
 * 
 * @author shaozheng
 * 2015-9-1
 */
public interface ConstructionCheckRecordsMapper {
	//新增施工核查结果记录表
	int insertConstructionCheckRecords(ConstructionCheckRecords constructionCheckRecords);
	//根据工单id获取记录信息
	List<ConstructionCheckRecords> getConstructionCheckRecordsbyOrderId(String orderId);
}
