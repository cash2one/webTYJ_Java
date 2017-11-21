package com.flf.service.impl;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.flf.entity.FinancialCounterofferDetail;
import com.flf.entity.FinancialCounterofferTotal;
import com.flf.entity.PageRestful;
import com.flf.mapper.FinancialCounterofferDetailMapper;
import com.flf.mapper.FinancialCounterofferTotalMapper;
import com.flf.service.FinancialCounterofferTotalService;

public class FinancialCounterofferTotalServiceImpl implements FinancialCounterofferTotalService{
	private FinancialCounterofferTotalMapper financialCounterofferTotalMapper;//回盘总结文件
	@Autowired
	private FinancialCounterofferDetailMapper financialCounterofferDetailMapper;//

	public FinancialCounterofferTotalMapper getFinancialCounterofferTotalMapper() {
		return financialCounterofferTotalMapper;
	}

	public void setFinancialCounterofferTotalMapper(
			FinancialCounterofferTotalMapper financialCounterofferTotalMapper) {
		this.financialCounterofferTotalMapper = financialCounterofferTotalMapper;
	}

	@Override
	public PageRestful listPageFinancialCounterofferTotal(
			FinancialCounterofferTotal financialCounterofferTotal) {
		PageRestful pageRestful=new PageRestful();
		List<FinancialCounterofferTotal> financialCounterofferTotals=financialCounterofferTotalMapper.listPageFinancialCounterofferTotal(financialCounterofferTotal);
		financialCounterofferTotals.add(0,null);
		pageRestful.setFinancialCounterofferTotals(financialCounterofferTotals);
		pageRestful.setPage(financialCounterofferTotal.getPage());
		return pageRestful;
	}

	@Override
	public FinancialCounterofferTotal getTotalFinancialCounterofferTotals(
			FinancialCounterofferTotal financialCounterofferTotal) {
		List<FinancialCounterofferTotal> fctList =financialCounterofferTotalMapper.
				listAllFinancialCounterofferTotal(financialCounterofferTotal);
		int proposeNum = 0;//提出笔数
		BigDecimal proposeAmount = BigDecimal.valueOf(0);//提出金额
		int successNum = 0;//成功笔数
		BigDecimal successAmount = BigDecimal.valueOf(0);//成功金额
		int failNum = 0;//失败笔数
		BigDecimal failAmount = BigDecimal.valueOf(0);//失败金额
		for(FinancialCounterofferTotal fct:fctList){
			FinancialCounterofferDetail fcd = new FinancialCounterofferDetail();
			fcd.setFinancialCounterofferTotalId(fct.getFinancialCounterofferTotalId());
			List<FinancialCounterofferDetail> fcdList = financialCounterofferDetailMapper.
					listAllFinancialCounterofferDetail(fcd);
			for(FinancialCounterofferDetail fcDetail:fcdList){
				proposeNum++;
				proposeAmount = proposeAmount.add(BigDecimal.valueOf(fcDetail.getSum()));
				if("Y".equals(fcDetail.getDeductionsTag())){
					successNum++;
					successAmount = successAmount.add(BigDecimal.valueOf(fcDetail.getSum()));
				}else{
					failNum++;
					failAmount = failAmount.add(BigDecimal.valueOf(fcDetail.getSum()));
				}
			}
		}
		FinancialCounterofferTotal fcTotal = new FinancialCounterofferTotal();
		fcTotal.setProposeNum(proposeNum);
		fcTotal.setProposeAmount(proposeAmount);
		fcTotal.setSuccessNum(successNum);
		fcTotal.setSuccessAmount(successAmount);
		fcTotal.setFailNum(failNum);
		fcTotal.setFailAmount(failAmount);
		return fcTotal;
	}

}
