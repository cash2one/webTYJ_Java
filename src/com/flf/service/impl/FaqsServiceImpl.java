package com.flf.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.flf.entity.FaqJournals;
import com.flf.entity.Faqs;
import com.flf.entity.PageRestful;
import com.flf.mapper.FaqJournalsMapper;
import com.flf.mapper.FaqTypesMapper;
import com.flf.mapper.FaqsMapper;
import com.flf.service.FaqsService;

public class FaqsServiceImpl implements FaqsService {

	private FaqsMapper faqsMapper;
	
	private FaqTypesMapper faqTypesMapper;
	
	private FaqJournalsMapper faqJournalsMapper;
	
	/**
	 * 分页查询
	 */
	@Override
	public PageRestful listPageFaqs(Faqs faqs) {
		
		//定义返回值
		PageRestful pageRestful = new PageRestful();

		//查询问题
		List<Faqs> faqsnew = faqsMapper.listPageFaqs(faqs);
		faqsnew.add(0, null);
		//将查询结果放入返回值
		pageRestful.setFaqnew(faqsnew);
		pageRestful.setPage(faqs.getPage());
		
		return pageRestful;
	}
	
	/**
	 * 分页查询所有待办FAQS
	 */
	@Override
	public PageRestful listPageFaqsNoAnswer(Faqs faqs){
		
		PageRestful pageRestful = new PageRestful();
		
		List<Faqs> faqsnew = faqsMapper.listPageFaqsNoAnswer(faqs);
		faqsnew.add(0, null);
		
		pageRestful.setFaqnew(faqsnew);
		pageRestful.setPage(faqs.getPage());
		
		return pageRestful;
	}

	/**
	 * 新增FAQS
	 */
	@Override
	public int insertFaqs(Faqs faqs) {
		
		//判断faqs中的FaqTypes的faqTypeId是否有值，如果没有值说明需要新增FaqTypes
		/*if(faqs.getFaqTypes().getFaqTypeId().isEmpty()){
			faqs.getFaqTypes().setFaqTypeId(UUID.randomUUID().toString());
			faqs.getFaqTypes().setCreTime(new Date());
			faqs.getFaqTypes().setCrePersonId(faqs.getCrePersonId());
			faqTypesMapper.insert(faqs.getFaqTypes());
		}*/
		
		//新增FAQ
		faqs.setFaqQuestionId(UUID.randomUUID().toString());
		faqs.setFaqQuestionNum("");		//须确认问题编号的生成规则
		faqs.setFaqQuestionState((byte)0);
		if(faqs.getFaqTypeId()!=null){
			faqs.setFaqTypeId(faqs.getFaqTypeId());
		}
		faqs.setCreTime(new Date());
		return faqsMapper.insert(faqs);
	}

	/**
	 * 修改FAQS
	 */
	@Override
	public void updateFaqs(Faqs faqs, String operatorId) {
		faqsMapper.updateByPrimaryKey(faqs);
		//将修改操作写入faq日志
		FaqJournals faqJournals = new FaqJournals();
		faqJournals.setFaqJournalId(UUID.randomUUID().toString());
		faqJournals.setRelationId(faqs.getFaqQuestionId());
		faqJournals.setOperatorId(operatorId);
		faqJournals.setChangeState("修改");
		faqJournals.setOperationRemarks("成功");
		faqJournals.setOperationTime(new Date());
		faqJournalsMapper.insert(faqJournals);
	}

	/**
	 * 删除FAQS
	 */
	@Override
	public int deleteFaqs(String faqQuestionId) {
		return faqsMapper.deleteByPrimaryKey(faqQuestionId);
	}
	
	@Override
	public void failFaqs(String faqids, String operatorId){
		String[] ids = faqids.split(",");
		for(int i = 0; i < ids.length; i++){
			faqsMapper.failFaqs(ids[i]);
			FaqJournals faqJournals = new FaqJournals();
			faqJournals.setFaqJournalId(UUID.randomUUID().toString());
			faqJournals.setRelationId(ids[i]);
			faqJournals.setOperatorId(operatorId);
			faqJournals.setChangeState("失效");
			faqJournals.setOperationRemarks("成功");
			faqJournals.setOperationTime(new Date());
			faqJournalsMapper.insert(faqJournals);
		}
	}
	
	/**
	 * 根据FAQS名称查询FAQS
	 */
	@Override
	public List<Faqs> getFaqsByfaqQuestionName(String faqQuestionName){
		return faqsMapper.getFaqsByfaqQuestionName(faqQuestionName);
	}

	@Override
	public Faqs getFaqsById(String faqQuestionId){
		return faqsMapper.selectByPrimaryKey(faqQuestionId);
	}
	
	
	public FaqsMapper getFaqsMapper() {
		return faqsMapper;
	}

	public void setFaqsMapper(FaqsMapper faqsMapper) {
		this.faqsMapper = faqsMapper;
	}

	public FaqTypesMapper getFaqTypesMapper() {
		return faqTypesMapper;
	}

	public void setFaqTypesMapper(FaqTypesMapper faqTypesMapper) {
		this.faqTypesMapper = faqTypesMapper;
	}

	public FaqJournalsMapper getFaqJournalsMapper() {
		return faqJournalsMapper;
	}

	public void setFaqJournalsMapper(FaqJournalsMapper faqJournalsMapper) {
		this.faqJournalsMapper = faqJournalsMapper;
	}

}
