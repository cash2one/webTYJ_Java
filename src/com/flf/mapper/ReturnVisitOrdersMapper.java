package com.flf.mapper;


import java.util.List;
import com.flf.entity.ReturnVisitOrders;

/**
 * 回访工单
 * @author taoyongchao
 *2015-8-7
 */

public interface ReturnVisitOrdersMapper {
	
	int deleteReturnVisitOrders(String orderId);//删除回访单
	int insertReturnVisitOrders(ReturnVisitOrders returnVisitOrders);//添加回访单信息
	int updateReturnVisitOrders(ReturnVisitOrders returnVisitOrders);//修改回访单信息
	int closeReturnVisitOrders(ReturnVisitOrders returnVisitOrders);//关闭回访单
	int insertReturnVisitOrdersUUID(ReturnVisitOrders returnVisitOrders);//添加回访单信息(带UUID)
	ReturnVisitOrders getReturnVisitOrdersbyId(String orderId);//通过Id查询回访单信息
	ReturnVisitOrders getReturnVisitOrdersbyOrderId(String orderId);//通过orderId查询回访工单记录信息
	   List<ReturnVisitOrders> listAllReturnVisitOrders();//查询所有回访单信息
}
