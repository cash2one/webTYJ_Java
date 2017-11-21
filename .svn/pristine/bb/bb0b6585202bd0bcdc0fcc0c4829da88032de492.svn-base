package com.flf.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.QuoteItemRecords;
import com.flf.entity.SettleAccountsOrders;
@WebService
@Path("/QuoteItemRecords")
/**
 * 报价项记录表
 * 创建人：邵政
 * 创建时间：2015-7-2
 */
public interface QuoteItemRecordsService {

    List<QuoteItemRecords> listPageQuoteItemRecords(QuoteItemRecords quoteItemRecords);//分页查询报价信息
	
	/**
	 * 查询所有报价信息
	 * @return
	 */
	@GET
	@Path("/listAllQuoteItemRecords")
	@Produces(MediaType.APPLICATION_JSON)
	List<QuoteItemRecords> listAllQuoteItemRecords();
	
	/**
	 * 获取未结算的报价信息
	 * @param acceptanceOrders
	 */
	@GET
	@Path("/getQuoteItemRecordsByTaskId/{tasksId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<QuoteItemRecords> getQuoteItemRecordsByTaskId(@PathParam("tasksId") String tasksId);
	
	/**
	 * 通过Id查询报价信息
	 * @param orderId
	 * @return
	 */
	@GET
	@Path("/getQuoteItemRecordsbyId/{recordId}")
	@Produces(MediaType.APPLICATION_JSON)
	QuoteItemRecords getQuoteItemRecordsbyId(@PathParam("recordId") String recordId);
	
	/**
	 * 添加报价信息
	 * @param quoteItemRecords
	 */
	@POST
	@Path("/insertQuoteItemRecords")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void insertQuoteItemRecords(QuoteItemRecords quoteItemRecords);
	
	/**
	 * 修改报价信息
	 * @param quoteItemRecords
	 */
	@PUT
	@Path("/updateQuoteItemRecords")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void updateQuoteItemRecords(QuoteItemRecords quoteItemRecords);
	
	/**
	 * 删除报价信息
	 * @param serverId
	 */
	@DELETE
	@Path("/deleteQuoteItemRecords/{recordId}")
	public void deleteQuoteItemRecords(@PathParam("recordId") String recordId);
	
	@POST
	@Path("/insertQuoteItemRecordsBatch")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void insertQuoteItemRecordsBatch(List<QuoteItemRecords> itemRecords);
	
}





