package com.flf.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.flf.entity.FaqTypes;
import com.flf.mapper.FaqTypesMapper;
import com.flf.service.FaqTypesService;

public class FaqTypesServiceImpl implements FaqTypesService {

	private FaqTypesMapper faqTypesMapper;
	
	@Override
	public List<FaqTypes> listFaqTypes(FaqTypes faqTypes) {
		return faqTypesMapper.listFaqTypes(faqTypes);
	}

	@Override
	public int insertFaqTypes(FaqTypes faqTypes) {
		faqTypes.setFaqTypeId(UUID.randomUUID().toString());
		faqTypes.setCreTime(new Date());
		return faqTypesMapper.insert(faqTypes);
	}

	@Override
	public void updateFaqTypes(FaqTypes faqTypes) {
		faqTypesMapper.updateByPrimaryKey(faqTypes);
	}

	@Override
	public int deleteFaqTypes(String faqTypeId) {
		return faqTypesMapper.deleteByPrimaryKey(faqTypeId);
	}
	
	@Override
	public int getFaqTypesByName(String faqTypeName){
		return faqTypesMapper.getFaqTypesByName(faqTypeName);
	}

	public FaqTypesMapper getFaqTypesMapper() {
		return faqTypesMapper;
	}

	public void setFaqTypesMapper(FaqTypesMapper faqTypesMapper) {
		this.faqTypesMapper = faqTypesMapper;
	}

}
