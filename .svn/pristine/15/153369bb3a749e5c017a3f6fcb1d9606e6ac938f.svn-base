package com.flf.service.impl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.jws.WebService;

import com.flf.entity.Annex;
import com.flf.entity.QuoteItemRecords;
import com.flf.entity.QuoteOrders;
import com.flf.entity.TasksJournal;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.QuoteItemRecordsMapper;
import com.flf.mapper.QuoteOrdersMapper;
import com.flf.mapper.TasksJournalMapper;
import com.flf.service.QuoteOrdersService;
/**
 * 报价工单表
 * 创建人：邵政
 * 创建时间：2015/6/24
 */
@WebService
public class QuoteOrdersServiceImpl implements QuoteOrdersService {
	
	private QuoteOrdersMapper quoteOrdersMapper;
	private QuoteItemRecordsMapper quoteItemRecordsMapper;
	private TasksJournalMapper tasksJournalMapper;
	private AnnexMapper annexMapper;
	
	public AnnexMapper getAnnexMapper() {
		return annexMapper;
	}

	public void setAnnexMapper(AnnexMapper annexMapper) {
		this.annexMapper = annexMapper;
	}

	public TasksJournalMapper getTasksJournalMapper() {
		return tasksJournalMapper;
	}

	public void setTasksJournalMapper(TasksJournalMapper tasksJournalMapper) {
		this.tasksJournalMapper = tasksJournalMapper;
	}

	public QuoteItemRecordsMapper getQuoteItemRecordsMapper() {
		return quoteItemRecordsMapper;
	}

	public void setQuoteItemRecordsMapper(
			QuoteItemRecordsMapper quoteItemRecordsMapper) {
		this.quoteItemRecordsMapper = quoteItemRecordsMapper;
	}

	public QuoteOrdersMapper getQuoteOrdersMapper() {
		return quoteOrdersMapper;
	}

	public void setQuoteOrdersMapper(QuoteOrdersMapper quoteOrdersMapper) {
		this.quoteOrdersMapper = quoteOrdersMapper;
	}

//	@Override
//	public List<QuoteOrders> listPageQuoteOrders(
//			QuoteOrders quoteOrders) {
//		// TODO Auto-generated method stub
//		return quoteOrdersMapper.listPageQuoteOrders(quoteOrders);
//	}

	@Override
	public List<QuoteOrders> listAllQuoteOrders() {
		// TODO Auto-generated method stub
		return quoteOrdersMapper.listAllQuoteOrders();
	}

	@Override
	public QuoteOrders getQuoteOrdersbyId(String orderId) {
		// TODO Auto-generated method stub
		return quoteOrdersMapper.getQuoteOrdersbyId(orderId);
	}

	@Override
	public void insertQuoteOrders(QuoteOrders quoteOrders) {
		
		UUID uuid = UUID.randomUUID();
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()).toString();
		
		if(quoteOrders != null){
			List<QuoteItemRecords> itemRecords = quoteOrders.getItemRecords();
			List<Annex> annexList = quoteOrders.getAnnexs();
			
			quoteOrders.setOrderId(uuid.toString());
			int result = quoteOrdersMapper.insertQuoteOrdersUUID(quoteOrders);
			//插入报价信息记录表
			if(result>0 && itemRecords!=null && itemRecords.size()>0){
				for(int i=0;i<itemRecords.size();i++){
					QuoteItemRecords quoteItemRecords = itemRecords.get(i);
					quoteItemRecords.setOrderId(uuid.toString());
					quoteItemRecordsMapper.insertQuoteItemRecords(quoteItemRecords);
				}
				
				//附件信息保存
				if(annexList!=null && annexList.size()>0){
					for(Annex annex :annexList){
						annex.setRelationId(uuid.toString());
						annex.setAnnexTime(date);
						annexMapper.insertAnnex(annex);
					}
				}
				//记录日志
				TasksJournal journal = new TasksJournal();
				journal.setTaskId(quoteOrders.getTaskId());
				journal.setCreOrderId(uuid.toString());
				journal.setCreOrderType(quoteOrders.getOrderType());
				journal.setChangeOrderState(quoteOrders.getOrderState());
				journal.setOperatorId(quoteOrders.getOperatorId());
				journal.setRemarks(quoteOrders.getRemarks());
				journal.setOperationTime(date);
				tasksJournalMapper.insertTasksJournal(journal);
			}
		}
		return;
	}

	@Override
	public void updateQuoteOrders(QuoteOrders quoteOrders) {
		// TODO Auto-generated method stub
		quoteOrdersMapper.updateQuoteOrders(quoteOrders);
	}

	@Override
	public void deleteQuoteOrders(String orderId) {
		// TODO Auto-generated method stub
		quoteOrdersMapper.deleteQuoteOrders(orderId);
	}

	@Override
	public void closeOrderState(QuoteOrders quoteOrders) {
		// TODO Auto-generated method stub
		if(quoteOrders != null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date = sdf.format(new Date());
			Integer orderState = quoteOrders.getOrderState();
			String closePersonId = quoteOrders.getClosePerson();
			
			//关闭操作
			if(orderState!= null && closePersonId!=null){
				quoteOrders.setOrderState(0);
				quoteOrders.setCloseTime(date);
				quoteOrdersMapper.updateQuoteOrders(quoteOrders);
			}
		}
		
		return;
	}

	@Override
	public List<QuoteOrders> getQuoteOrdersbyTasksId(String tasksId) {
		List<QuoteOrders> quoteOrders = quoteOrdersMapper.getQuoteOrdersbyTasksId(tasksId);
		return quoteOrders;
	}
}
