package com.flf.mapper;

import java.util.List;

import com.flf.entity.AccountRelation;

public interface AccountRelationMapper {
	/*查询所有的账户关系信息*/
	List<AccountRelation> listAllAccountRelation();
	/*分页查询账户关系信息*/
    List<AccountRelation> listPageAccountRelation(AccountRelation accountRelation);
    /*根据id查询账户关系信息*/
    AccountRelation getAccountRelationById(String accountRelationId);
    /*删除账户关系信息*/
    int deleteAccountRelation(String accountRelationId);
    /*新增账户关系信息*/
    int insertAccountRelation(AccountRelation accountRelation);
    /*修改账户关系信息*/
    int updateAccountRelation(AccountRelation accountRelation);
    /*根据账户id获取账户关联信息*/
    List<AccountRelation> getAccountRelationByAccountId(String accountId);
    
    /**
     * 批量插入关联表数据
     * 王洲
     * 2016.04.19
     * @param list
     * @return
     */
    int insertRelationList(List<AccountRelation> list);
    
    /**
     * 根据个人账户id和资产账户id查询是否存在数据
     * 王洲
     * 2016.04.19
     * @param accountId
     * @param assetAccount
     * @return
     */
    AccountRelation getAssetRelationByParams(String accountId, String assetAccount);
}