package com.flf.mapper;

import java.util.List;

import com.flf.entity.AcceptanceOrders;

/**
 * 验收单表
 * @author shaozheng
 * 创建时间:2015-6-24 
 */
public interface AcceptanceOrdersMapper {
	
	int updateAcceptanceOrdersOnSatisfaction(AcceptanceOrders acceptanceOrders);//修改满意度
	
	int deleteAcceptanceOrders(String orderId);//删除验收单信息

	int insertAcceptanceOrders(AcceptanceOrders acceptanceOrders);//添加验收单信息

    List<AcceptanceOrders> listAcceptanceOrders(AcceptanceOrders acceptanceOrders);//分页查询验收单信息
    
    List<AcceptanceOrders> listAllAcceptanceOrders();//查询所有验收单信息

    AcceptanceOrders getAcceptanceOrdersbyId(String orderId);//通过Id查询验收单信息
    
    AcceptanceOrders getAppAcceptanceOrdersbyId(String orderId);//通过Id查询验收单信息app接口
    
    List<AcceptanceOrders> getAcceptanceOrdersbyServiceRequsetId(String serviceRequsetId);//通过服务请求Id查询验收单信息

    int updateAcceptanceOrders(AcceptanceOrders AcceptanceOrders);//修改验收单信息
    
    int closeAcceptanceOrders(String orderId); // 关闭验收单
    
    int insertAcceptanceOrdersUUID(AcceptanceOrders acceptanceOrders);//添加验收单信息(带UUID)
}
