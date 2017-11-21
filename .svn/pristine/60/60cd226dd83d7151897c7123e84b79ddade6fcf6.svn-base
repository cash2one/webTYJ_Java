package com.flf.service.impl;


import java.util.List;


import javax.jws.WebService;


import com.flf.entity.Faq;

import com.flf.entity.PageRestful;


import com.flf.mapper.FaqMapper;
import com.flf.service.FaqService;


@WebService
public class FaqServiceImpl implements FaqService{
	private FaqMapper faqMapper;

	public FaqMapper getFaqMapper() {
		return faqMapper;
	}

	public void setFaqMapper(FaqMapper faqMapper) {
		this.faqMapper = faqMapper;
	}


	/*
	  * <p>Title: getFAQByIdRest</p>
	  * <p>Description: </p>
	  * @param id
	  * @return
	  * @see com.flf.service.FAQService#getFAQByIdRest(java.lang.Integer)
	  */
	
	
	@Override
	public Faq getFAQById(String id) {
		// TODO Auto-generated method stub
		Faq faq=faqMapper.getFAQById(id);
		return faq;
	}

	/*
	  * <p>Title: insertFAQRest</p>
	  * <p>Description: </p>
	  * @param faq
	  * @see com.flf.service.FAQService#insertFAQRest(com.flf.entity.FAQ)
	  */
	
	
	@Override
	public void insertFAQ(Faq faq) {
		// TODO Auto-generated method stub
		faqMapper.insertFAQ(faq);
		return;
	}

	/*
	  * <p>Title: updateFAQRest</p>
	  * <p>Description: </p>
	  * @param faq
	  * @see com.flf.service.FAQService#updateFAQRest(com.flf.entity.FAQ)
	  */
	
	
	@Override
	public void updateFAQ(Faq faq) {
		// TODO Auto-generated method stub
		faqMapper.updateFAQ(faq);
		return;
	}

	/*
	  * <p>Title: deleteFAQRest</p>
	  * <p>Description: </p>
	  * @param id
	  * @see com.flf.service.FAQService#deleteFAQRest(java.lang.Integer)
	  */
	
	
	@Override
	public void deleteFAQ(String id) {
		// TODO Auto-generated method stub
		faqMapper.deleteFAQ(id);
		return;
	}

	/*
	  * <p>Title: listPageFAQ</p>
	  * <p>Description: </p>
	  * @param faq
	  * @return
	  * @see com.flf.service.FaqService#listPageFAQ(com.flf.entity.Faq)
	  */
	
	
	@Override
	public PageRestful listPageFAQ(Faq faq) {
		// TODO Auto-generated method stub
		PageRestful pageRestful=new PageRestful();
		List<Faq> faqs = faqMapper.listPageFAQ(faq);
		faqs.add(0,null);
		pageRestful.setFaqs(faqs);
		pageRestful.setPage(faq.getPage());
		return pageRestful;
	}

	/*
	  * <p>Title: listAllFAQ</p>
	  * <p>Description: </p>
	  * @return
	  * @see com.flf.service.FaqService#listAllFAQ()
	  */
	
	
	@Override
	public List<Faq> listAllFAQ() {
		// TODO Auto-generated method stub

		List<Faq> faqs = faqMapper.listAllFAQ();
		return faqs;
	}

}
