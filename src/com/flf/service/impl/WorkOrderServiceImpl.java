package com.flf.service.impl;

import com.flf.mapper.AcceptanceOrdersMapper;
import com.flf.mapper.DisposeOrderMapper;
import com.flf.mapper.QuoteOrdersMapper;
import com.flf.service.WorkOrderService;

public class WorkOrderServiceImpl implements WorkOrderService{
	
	private QuoteOrdersMapper quoteOrdersMapper;
	private DisposeOrderMapper disposeOrderMapper;
	private AcceptanceOrdersMapper acceptanceOrdersMapper;
	
	public QuoteOrdersMapper getQuoteOrdersMapper() {
		return quoteOrdersMapper;
	}


	public void setQuoteOrdersMapper(QuoteOrdersMapper quoteOrdersMapper) {
		this.quoteOrdersMapper = quoteOrdersMapper;
	}


	public DisposeOrderMapper getDisposeOrderMapper() {
		return disposeOrderMapper;
	}


	public void setDisposeOrderMapper(DisposeOrderMapper disposeOrderMapper) {
		this.disposeOrderMapper = disposeOrderMapper;
	}


	public AcceptanceOrdersMapper getAcceptanceOrdersMapper() {
		return acceptanceOrdersMapper;
	}


	public void setAcceptanceOrdersMapper(
			AcceptanceOrdersMapper acceptanceOrdersMapper) {
		this.acceptanceOrdersMapper = acceptanceOrdersMapper;
	}


	//0.报价;1.处理;2.验收;3.表扬;4.投诉;5.赔偿给业主;6.向业主索赔;7.装修/施工巡检;8.装修/施工核查;9.装修/施工验收;10.部门质检工单
	//orderType 工单类型 orderId 工单id
	@Override
	public int closeWorkOrderByOrderType(Integer orderType , String orderId) {
		if(orderType == 0){
			quoteOrdersMapper.closeQuoteOrders(orderId);
		}else if(orderType == 2){
			disposeOrderMapper.closeDisposeOrder(orderId);
		}else if(orderType == 3){
			acceptanceOrdersMapper.closeAcceptanceOrders(orderId);
		}
		return 0;
	}

}
