package com.flf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.flf.entity.Account;
import com.flf.entity.AccountRelation;
import com.flf.entity.AdvancePaymentsDetails;
import com.flf.mapper.AccountMapper;
import com.flf.mapper.AccountRelationMapper;
import com.flf.mapper.AdvancePaymentsDetailsMapper;
import com.flf.mapper.AssetAccountMapper;
import com.flf.service.AccountService;

public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountMapper accountMapper;//账户
	@Autowired
	private AssetAccountMapper assetAccountMapper;//资产账户
	@Autowired
	private AccountRelationMapper accountRelationMapper;//账户关系表
	@Autowired
	private AdvancePaymentsDetailsMapper advancePaymentsDetailsMapper;//与支付明细表

	@Override
	public Account getAccountByCustId(String custId) {
		// TODO Auto-generated method stub
		Account account = accountMapper.getAccountByCustId(custId);
		if(account!=null){
			String accountId = account.getAccountId();
			List<AccountRelation> accountRelations = accountRelationMapper.getAccountRelationByAccountId(accountId);//获取包含资产账户信息的账户关系
			if(accountRelations!=null){
				double totalBalanceOfDelinquentAccounts = 0;//欠费账户总余额
				for (AccountRelation accountRelation : accountRelations) {
					String assetAccountId = accountRelation.getAssetAccount();
					Double totalBalanceOfDelinquentAccount = assetAccountMapper.getTotalBalanceOfDelinquentAccounts(assetAccountId);
					totalBalanceOfDelinquentAccounts+=(totalBalanceOfDelinquentAccount==null?0:totalBalanceOfDelinquentAccount);
				}
				account.setTotalBalanceOfDelinquentAccounts(totalBalanceOfDelinquentAccounts);//设置欠费账户总余额
			}
			accountRelations.add(0, null);
			account.setAccountRelations(accountRelations);
		}
		return account;
	}

	/**
	 * 根据资产账户编号获取该编号下的支付明细
	 */
	@Override
	public List<AdvancePaymentsDetails> getAdvancePaymentDetailsCustId(
			String assetAccuontNum) {
		// TODO Auto-generated method stub
		return advancePaymentsDetailsMapper.getAdvancePaymentDetailByAssetAccuontNum(assetAccuontNum);
	}
}
