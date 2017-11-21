package com.flf.mapper;

import java.util.List;
import com.flf.entity.BankDeposit;

public interface BankDepositMapper {
	
	/*根据交账记录id查询银行存单表*/
	List<BankDeposit> getBankDepositById(String accountRecordId);
	
	/* 新增*/
	void insertBankDeposit(BankDeposit bankDeposit);

	/* 上级撤回数据时 删除之前产生的存单数据 */
	void delete(String bankDepositId);
}
