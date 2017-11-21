package com.flf.mapper;


import java.util.List;


import com.flf.entity.AppealOrders;
/**
 * 申诉单
 * @author 陶勇超
 *2015-8-11
 */

public interface AppealOrdersMapper {
	
	int deleteAppealOrders(String orderId);//删除申诉单信息

	int insertAppealOrders(AppealOrders appealOrders);//添加申诉单信息
	AppealOrders getAppealOrdersbyId(String orderId);//通过Id查询申诉单信息
    List<AppealOrders> listAllAppealOrders();//查询所有申诉单信息
	int updateAppealOrders(AppealOrders appealOrders);//修改申诉单信息

	int closeAppealOrders(String orderId); // 关闭申诉单

	int insertAppealOrdersUUID(AppealOrders appealOrders);//添加申诉单信息(带UUID)

}
