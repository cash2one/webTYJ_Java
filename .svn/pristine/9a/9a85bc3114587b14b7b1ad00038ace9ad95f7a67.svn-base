package com.flf.service.impl;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.flf.entity.QuoteItemRecords;
import com.flf.entity.QuoteOrders;
import com.flf.entity.SettleAccountsItemRecords;
import com.flf.entity.SettleAccountsOrders;
import com.flf.mapper.QuoteItemRecordsMapper;
import com.flf.mapper.QuoteOrdersMapper;
import com.flf.mapper.SettleAccountsItemRecordsMapper;
import com.flf.mapper.SettleAccountsOrdersMapper;
import com.flf.service.QuoteItemRecordsService;
/**
 * 报价项记录表
 * 创建人：邵政
 * 创建时间：2015-7-2
 */
@WebService
public class QuoteItemRecordsServiceImpl implements QuoteItemRecordsService {
	
	private QuoteItemRecordsMapper quoteItemRecordsMapper;
	private QuoteOrdersMapper quoteOrdersMapper;
	private SettleAccountsOrdersMapper settleAccountsOrdersMapper;
	private SettleAccountsItemRecordsMapper settleAccountsItemRecordsMapper;

	public QuoteOrdersMapper getQuoteOrdersMapper() {
		return quoteOrdersMapper;
	}

	public SettleAccountsOrdersMapper getSettleAccountsOrdersMapper() {
		return settleAccountsOrdersMapper;
	}

	public SettleAccountsItemRecordsMapper getSettleAccountsItemRecordsMapper() {
		return settleAccountsItemRecordsMapper;
	}

	public void setQuoteOrdersMapper(QuoteOrdersMapper quoteOrdersMapper) {
		this.quoteOrdersMapper = quoteOrdersMapper;
	}

	public void setSettleAccountsOrdersMapper(SettleAccountsOrdersMapper settleAccountsOrdersMapper) {
		this.settleAccountsOrdersMapper = settleAccountsOrdersMapper;
	}

	public void setSettleAccountsItemRecordsMapper(SettleAccountsItemRecordsMapper settleAccountsItemRecordsMapper) {
		this.settleAccountsItemRecordsMapper = settleAccountsItemRecordsMapper;
	}

	public QuoteItemRecordsMapper getQuoteItemRecordsMapper() {
		return quoteItemRecordsMapper;
	}

	public void setQuoteItemRecordsMapper(QuoteItemRecordsMapper quoteItemRecordsMapper) {
		this.quoteItemRecordsMapper = quoteItemRecordsMapper;
	}

	@Override
	public List<QuoteItemRecords> listPageQuoteItemRecords(
			QuoteItemRecords quoteItemRecords) {
		// TODO Auto-generated method stub
		return quoteItemRecordsMapper.listPageQuoteItemRecords(quoteItemRecords);
	}
	
	@Override
	public List<QuoteItemRecords> getQuoteItemRecordsByTaskId(String tasksId) {
		List<SettleAccountsItemRecords> SAIR = new ArrayList<>();
		List<QuoteItemRecords> QIR = new ArrayList<>();
		if(tasksId!=null && !tasksId.equals("")){
			//获取结算工单记录
			List<SettleAccountsOrders> sao = new ArrayList<>();
			sao = settleAccountsOrdersMapper.getSettleAccountsOrdersByTaskId(tasksId);
			for (SettleAccountsOrders settleAccountsOrders2 : sao) {
				if(settleAccountsOrders2.getOrderId()!=null){
					SAIR.addAll(settleAccountsItemRecordsMapper.getSettleAccountsItemRecordsByOrderId(settleAccountsOrders2.getOrderId()));
				}
			}
			//获取报价单记录
			List<QuoteOrders> qo = new ArrayList<>();
			qo = quoteOrdersMapper.getQuoteOrdersbyTasksId(tasksId);
			for (QuoteOrders quoteOrders : qo) {
				if(quoteOrders.getOrderId()!=null){
					QIR.addAll(quoteItemRecordsMapper.getQuoteItemRecordsbyOrderId(quoteOrders.getOrderId()));
				}
			}
			//获取未结算的报价
			for (int j = 0; j < SAIR.size(); j++) {
				for (int i = 0; i < QIR.size(); i++) {
					if(SAIR.get(j).getQuoteItemRecordsId().equals(QIR.get(i).getRecordId())){
						QIR.remove(i--);
					}
				}
			}
		}
		return QIR;
	}


	@Override
	public List<QuoteItemRecords> listAllQuoteItemRecords() {
		// TODO Auto-generated method stub
		return quoteItemRecordsMapper.listAllQuoteItemRecords();
	}

	@Override
	public QuoteItemRecords getQuoteItemRecordsbyId(String recordId) {
		// TODO Auto-generated method stub
		return quoteItemRecordsMapper.getQuoteItemRecordsbyId(recordId);
	}

	@Override
	public void insertQuoteItemRecords(QuoteItemRecords quoteItemRecords) {
		// TODO Auto-generated method stub
		quoteItemRecordsMapper.insertQuoteItemRecords(quoteItemRecords);
	}

	@Override
	public void updateQuoteItemRecords(QuoteItemRecords quoteItemRecords) {
		// TODO Auto-generated method stub
		quoteItemRecordsMapper.updateQuoteItemRecords(quoteItemRecords);
	}

	@Override
	public void deleteQuoteItemRecords(String recordId) {
		// TODO Auto-generated method stub
		quoteItemRecordsMapper.deleteQuoteItemRecords(recordId);
	}

	@Override
	public void insertQuoteItemRecordsBatch(List<QuoteItemRecords> itemRecords) {
		// TODO Auto-generated method stub
		System.out.println("222222222222222222222");
		System.out.println(itemRecords);
		System.out.println(itemRecords.size());
		quoteItemRecordsMapper.insertQuoteItemRecordsBatch(itemRecords);
	}

	
}
