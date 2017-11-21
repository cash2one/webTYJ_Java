package com.flf.mapper;

import com.flf.entity.MeterReadingRecords;

public interface MeterReadingRecordsMapper {

	int insertMeterReadingRecords(MeterReadingRecords meterReadingRecords);//新增工单记录信息
	MeterReadingRecords getMeterReadingRecordsbyOrderId(String orderId);//根据记录id获取工单信息
}
