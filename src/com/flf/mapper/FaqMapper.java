package com.flf.mapper;

import java.util.List;
import com.flf.entity.Faq;

public interface FaqMapper {
	List<Faq> listPageFAQ(Faq faq);//分页显示所有FAQ信息
	List<Faq> listAllFAQ();//显示所有FAQ信息
	void insertFAQ(Faq faq);//添加FAQ信息
	
	void updateFAQ(Faq faq);//修改FAQ信息
	
	void deleteFAQ(String id);//删除FAQ信息
	
	Faq getFAQById(String id);//根据id查FAQ信息
	
}
