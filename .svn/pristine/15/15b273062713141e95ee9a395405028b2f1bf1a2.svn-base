package com.flf.mapper;


import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.flf.entity.QuoteItemRecords;
/**
 * 报价项记录表
 * 创建人：邵政
 * 创建时间：2015-7-2
 */
@XmlRootElement(name = "QuoteItemRecords")
public interface QuoteItemRecordsMapper {
	
	int deleteQuoteItemRecords(String recordId);//删除报价项记录信息
	int insertQuoteItemRecords(QuoteItemRecords quoteItemRecords);//添加报价项记录信息
    List<QuoteItemRecords> listPageQuoteItemRecords(QuoteItemRecords quoteItemRecords);//分页查询报价项记录信息
    List<QuoteItemRecords> listAllQuoteItemRecords();//查询所有报价项记录信息
    QuoteItemRecords getQuoteItemRecordsbyId(String recordId);//通过Id查询报价项记录信息
    int updateQuoteItemRecords(QuoteItemRecords quoteItemRecords);//修改报价项记录信息
    int insertQuoteItemRecordsBatch(List<QuoteItemRecords> itemRecords);//批量插入报价项纪录信息
    List<QuoteItemRecords> getQuoteItemRecordsbyOrderId(String orderId);//根据工单id查询报价信息
    
}