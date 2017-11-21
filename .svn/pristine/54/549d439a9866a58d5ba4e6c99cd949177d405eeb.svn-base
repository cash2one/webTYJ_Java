package com.flf.mapper;

import java.util.List;

import com.flf.entity.SettleAccountsOrders;

public interface SettleAccountsOrdersMapper {
	
	int insertSettleAccountsOrders(SettleAccountsOrders settleAccountsOrders);//添加结算信息
	int insertSettleAccountsOrdersUUID(SettleAccountsOrders settleAccountsOrders);//添加结算单信息(uuid)
	SettleAccountsOrders getSettleAccountsOrdersById(String recordsId);//通过ID获取结算信息
	int changeSettleAccountsOrdersState(SettleAccountsOrders settleAccountsOrders);//改变结算单状态
	int updateSettleAccountsOrders(SettleAccountsOrders settleAccountsOrders);//修改结算单
	
	/**
	 * 根据任务id结算信息 
	 * @author zhuqi 
	 * @date 2016-06-15
	 * @param TaskId
	 * @return
	 */
	List<SettleAccountsOrders> getSettleAccountsOrdersByTaskId(String TaskId);
	
}
