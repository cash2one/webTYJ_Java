package com.flf.mapper;

import java.util.List;


import com.flf.entity.ClosedOrders;

public interface ClosedMapper {
	int deleteClosedOrders(String orderId);//删除失效单信息

	int insertClosedOrders(ClosedOrders closedOrders);//添加失效单信息
	ClosedOrders getClosedOrdersbyId(String orderId);//通过Id查询失效单信息
    List<ClosedOrders> listAllClosedOrders();//查询所有失效单信息
	int updateClosedOrders(ClosedOrders closedOrders);//修改失效单信息

	int closeClosedOrders(String orderId); // 关闭失效单

	int insertClosedOrdersUUID(ClosedOrders closedOrders);//添加失效单信息(带UUID)

}
