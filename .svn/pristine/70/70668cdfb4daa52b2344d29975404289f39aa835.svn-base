package com.flf.mapper;


import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.flf.entity.QuoteOrders;
/**
 * 报价工单表
 * 创建人：邵政
 * 创建时间：2015/6/24
 */
@XmlRootElement(name = "QuoteOrders")
public interface QuoteOrdersMapper {
	
	int deleteQuoteOrders(String orderId);//删除报价信息
	int insertQuoteOrders(QuoteOrders quoteOrders);//添加报价信息
	int insertQuoteOrdersUUID(QuoteOrders quoteOrders);//添加报价信息uuid
//    List<QuoteOrders> listPageQuoteOrders(QuoteOrders quoteOrders);//分页查询报价信息
    List<QuoteOrders> listAllQuoteOrders();//查询所有报价信息
    QuoteOrders getQuoteOrdersbyId(String orderId);//通过Id查询报价信息
    QuoteOrders getAppQuoteOrdersbyId(String orderId);//通过Id查询报价信息app接口
    int updateQuoteOrders(QuoteOrders quoteOrders);//修改报价信息
    int closeQuoteOrders(String orderId);
    List<QuoteOrders> getQuoteOrdersbyTasksId(String tasksId);//通过任务id获取报价单信息
    
}