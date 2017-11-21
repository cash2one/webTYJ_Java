package com.flf.mapper;

import com.flf.entity.MeterReadingOrders;
import com.flf.entity.WaterMeterOrders;

public interface MeterReadingOrdersMapper {

	int insertMeterReadingOrders(MeterReadingOrders meterReadingOrders);//添加电表工单
	int insertMeterReadingOrdersUUID(MeterReadingOrders meterReadingOrders);//添加电表工单
	int updateMeterReadingOrders(MeterReadingOrders meterReadingOrders);//修改电表工单
	MeterReadingOrders getMeterReadingOrdersbyId(String orderId);//根据工单id获取电表工单
}
