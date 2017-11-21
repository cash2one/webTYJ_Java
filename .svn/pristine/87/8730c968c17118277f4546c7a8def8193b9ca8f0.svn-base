package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.flf.entity.ConsultationOrders;
import com.flf.entity.FaqTypes;
import com.flf.entity.Faqs;
import com.flf.entity.TasksJournal;
import com.flf.mapper.ConsultationOrdersMapper;
import com.flf.mapper.FaqTypesMapper;
import com.flf.mapper.FaqsMapper;
import com.flf.mapper.TasksJournalMapper;
import com.flf.service.ConsultationOrdersService;
/**
 * 创建人：倪明
 * 创建时间：2015/8/13
 * ConsultationOrders实现类
 * @author Administrator
 *
 */
public class ConsultationOrdersServiceImpl implements ConsultationOrdersService {

	private ConsultationOrdersMapper consultationOrdersMapper;
	private TasksJournalMapper tasksJournalMapper;
	private FaqsMapper faqsMapper;
	
	public ConsultationOrdersMapper getConsultationOrdersMapper() {
		return consultationOrdersMapper;
	}

	public void setConsultationOrdersMapper(
			ConsultationOrdersMapper consultationOrdersMapper) {
		this.consultationOrdersMapper = consultationOrdersMapper;
	}

	public TasksJournalMapper getTasksJournalMapper() {
		return tasksJournalMapper;
	}

	public void setTasksJournalMapper(TasksJournalMapper tasksJournalMapper) {
		this.tasksJournalMapper = tasksJournalMapper;
	}

	public FaqsMapper getFaqsMapper() {
		return faqsMapper;
	}

	public void setFaqsMapper(FaqsMapper faqsMapper) {
		this.faqsMapper = faqsMapper;
	}

	@Override
	public List<ConsultationOrders> listAllConsultationOrders() {
		// TODO Auto-generated method stub
		return consultationOrdersMapper.listAllConsultationOrders();
	}

	@Override
	public void insertConsultationOrders(ConsultationOrders consultationOrders) {
		// TODO Auto-generated method stub
		String uuid = UUID.randomUUID().toString();
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		if(consultationOrders != null){
			consultationOrders.setOrderId(uuid);
			consultationOrders.setFinishTime(new Date());
			Integer result = consultationOrdersMapper.insertConsultationOrdersUUID(consultationOrders);
			if(result>0){
				TasksJournal journal = new TasksJournal();
				journal.setTaskId(consultationOrders.getTaskId());
				journal.setCreOrderId(uuid);
				journal.setCreOrderType(consultationOrders.getOrderType());
				journal.setChangeOrderState(consultationOrders.getOrderState());
				journal.setOperatorId(consultationOrders.getOperatorId());
				journal.setRemarks(consultationOrders.getRemarks());
				journal.setOperationTime(date);
				tasksJournalMapper.insertTasksJournal(journal);
			}
			//如果咨询工单无引用faqid,无回答，则生成一条待办faq
			if(consultationOrders.getFaqQuestionId() == null && consultationOrders.getRemarks() == null){
				Faqs faqs = new Faqs();
				faqs.setFaqQuestionId(UUID.randomUUID().toString());
				faqs.setFaqQuestionNum("");		//须确认问题编号的生成规则
				faqs.setFaqQuestionState((byte)0);
				faqs.setCreTime(new Date());
				faqs.setFaqQuestionName(consultationOrders.getProblemRemarks());
				faqs.setCrePersonId(consultationOrders.getOperatorId());
				faqs.setPersonCustId(consultationOrders.getPersonId());
				faqsMapper.insert(faqs);
			}
		}
	}

	@Override
	public void deleteConsultationOrders(String orderId) {
		// TODO Auto-generated method stub
		consultationOrdersMapper.deleteConsultationOrders(orderId);
	}

	@Override
	public ConsultationOrders getConsultationOrdersbyId(String orderId) {
		// TODO Auto-generated method stub
		return consultationOrdersMapper.getConsultationOrdersbyId(orderId);
	}

	@Override
	public void closeConsultationOrders(ConsultationOrders consultationOrders) {
		// TODO Auto-generated method stub
		if(consultationOrders != null){
			Integer orderState = consultationOrders.getOrderState();
			String closePersonId = consultationOrders.getClosePersonId();
			String closeRemarks = consultationOrders.getCloseRemarks();
			if(orderState != null && closePersonId != null){
				consultationOrders.setOrderState(0);
				consultationOrders.setCloseTime(new Date());
				consultationOrders.setCloseRemarks(closeRemarks);
				consultationOrdersMapper.updateConsultationOrders(consultationOrders);
			}
		}
		return;
	}

	@Override
	public void updateConsultationOrders(ConsultationOrders consultationOrders) {
		// TODO Auto-generated method stub
		consultationOrdersMapper.updateConsultationOrders(consultationOrders);
	}

}
