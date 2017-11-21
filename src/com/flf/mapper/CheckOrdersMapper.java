package com.flf.mapper;

import java.util.List;

import com.flf.entity.CheckOrders;

public interface CheckOrdersMapper {
	
	int deleteCheckOrders(String orderId);//删除检测单信息

	int insertCheckOrders(CheckOrders checkOrders);//添加检测单信息
	
	int insertCheckOrdersUUID(CheckOrders checkOrders);//添加检测单信息(uuid)

    List<CheckOrders> listAllCheckOrders();//查询所有检测单信息

    CheckOrders getCheckOrdersbyId(String orderId);//通过Id查询检测单信息

    CheckOrders getAppCheckOrdersbyId(String orderId);//通过Id查询检测单信息app接口

    int updateCheckOrders(CheckOrders checkOrders);//修改检测单信息
    
    int closeCheckOrders(String orderId); // 关闭检测单
    
    
}
