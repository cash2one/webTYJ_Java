package com.flf.mapper;

import com.flf.entity.WaterMeterOrders;

public interface WaterMeterOrdersMapper {

	int insertWaterMeterOrders(WaterMeterOrders waterMeterOrders);//添加水表工单
	int insertWaterMeterOrdersUUID(WaterMeterOrders waterMeterOrders);//添加水表工单
	int updateWaterMeterOrders(WaterMeterOrders waterMeterOrders);//修改水表工单
	WaterMeterOrders getWaterMeterOrdersbyId(String orderId);//根据工单id获取水表工单
	int closeWaterMeterOrders(WaterMeterOrders waterMeterOrders);//关闭水表工单
	int submitWaterMeterOrders(String orderId);
}
