package com.flf.mapper;

import java.util.List;
import com.flf.entity.Account;

public interface AccountMapper {
	/*查询所有的账户信息*/
	List<Account> listAllAccount();
	/*分页查询账户信息*/
    List<Account> listPageAccount(Account account);
    /*根据id查询账户信息*/
    Account getAccountById(String accountId);
    /*删除账户信息*/
    int deleteAccount(String accountId);
    /*新增账户信息*/
    int insertAccount(Account account);
    /*修改账户信息*/
    int updateAccount(Account account);
    /*根据客户id获取账户信息*/
    Account getAccountByCustId(String custId);
    
}