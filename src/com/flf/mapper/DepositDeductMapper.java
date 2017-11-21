package com.flf.mapper;

import java.util.List;

import com.flf.entity.DepositDeduct;

public interface DepositDeductMapper {

	void insertDepositDeduct(DepositDeduct depositDeduct);//添加押金付款项
	void updateDepositDeduct(DepositDeduct depositDeduct);//更新押金付款项
	
	List<DepositDeduct> getDepositDeductsByAdvancePaymentId(String AdvancePaymentDetailId);//根据账单id查询押金付款项
	Double countDeductionsSumByAdvancePaymentId(String AdvancePaymentDetailId);//根据账单id汇总押金付款总额
	
}
