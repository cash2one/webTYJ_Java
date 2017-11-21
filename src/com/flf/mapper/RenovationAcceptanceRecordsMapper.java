package com.flf.mapper;

import java.util.List;

import com.flf.entity.RenovationAcceptanceRecords;

/**
 * 装修验收结果记录Mapper
 * @author 倪明
 * 2015/08/19
 */
public interface RenovationAcceptanceRecordsMapper {

	int insertRenovationAcceptanceRecords(RenovationAcceptanceRecords renovationAcceptanceRecords);   //新增装修验收记录
	
	List<RenovationAcceptanceRecords> getRenovationAcceptanceRecordsbyOrderId(String orderId);   //根据工单id查询装修验收记录
	
}
