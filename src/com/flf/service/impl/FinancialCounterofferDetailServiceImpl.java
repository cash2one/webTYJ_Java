package com.flf.service.impl;

import java.util.List;

import com.flf.entity.FinancialCounterofferDetail;
import com.flf.entity.PageRestful;
import com.flf.mapper.FinancialCounterofferDetailMapper;
import com.flf.service.FinancialCounterofferDetailService;

public class FinancialCounterofferDetailServiceImpl implements FinancialCounterofferDetailService{

	private FinancialCounterofferDetailMapper financialCounterofferDetailMapper;
	
	public FinancialCounterofferDetailMapper getFinancialCounterofferDetailMapper() {
		return financialCounterofferDetailMapper;
	}

	public void setFinancialCounterofferDetailMapper(
			FinancialCounterofferDetailMapper FinancialCounterofferDetailMapper) {
		this.financialCounterofferDetailMapper = FinancialCounterofferDetailMapper;
	}

	@Override
	public PageRestful listPageFinancialCounterofferDetail(
			FinancialCounterofferDetail financialCounterofferDetail) {
		PageRestful pageRestful=new PageRestful();
		List<FinancialCounterofferDetail> financialCounterofferDetails=financialCounterofferDetailMapper.listPageFinancialCounterofferDetail(financialCounterofferDetail);
		financialCounterofferDetails.add(0,null);
		pageRestful.setFinancialCounterofferDetails(financialCounterofferDetails);
		pageRestful.setPage(financialCounterofferDetail.getPage());
		return pageRestful;
	}
}
