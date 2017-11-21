package com.flf.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.flf.entity.BankDeposit;
import com.flf.mapper.BankDepositMapper;
import com.flf.service.BankDepositService;

public class BankDepositServiceImpl implements BankDepositService{

	@Autowired
	private BankDepositMapper bankDepositMapper;
	
	@Override
	public List<BankDeposit> getBankDepositByIdRest(String accountRecordId) {
		return bankDepositMapper.getBankDepositById(accountRecordId);
	}
	
	@Override
	public void insertBankDeposit(BankDeposit bankDeposit) {
		bankDepositMapper.insertBankDeposit(bankDeposit);
	}

}
