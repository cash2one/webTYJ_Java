package com.flf.mapper;

import java.util.List;
import com.flf.entity.AccountRecord;

public interface AccountRecordMapper {
	/*分页查询交账列表*/
    List<AccountRecord> listPageAccountRecord(AccountRecord accountRecord);
    /*确认收账*/
    int updateAccountState(AccountRecord accountRecord);
	
	/* 新增*/
	int insertAccountRecord(AccountRecord accountRecord);

	AccountRecord getAccountRecordById(String accountRecordId);
	/*查询交账中的列表  */
	List<AccountRecord> getAccountRecordListById(String financialStaffId);
	
	/*退回*/
    int updateAccountState1(AccountRecord accountRecord);
    
    /*修改*/
    int update(AccountRecord accountRecord);
	
    /**
     * 分页查询未交帐列表
     * @param accountRecord
     * @return
     */
    List<AccountRecord> listPageAccountRecordUnFinish(AccountRecord accountRecord);
    
    List<AccountRecord> listPageByState(AccountRecord accountRecord);//查询交账中的列表
    
    List<AccountRecord> listPageByStateOtr(AccountRecord accountRecord);//查询未交帐的列表
    
    List<AccountRecord> selectAccountRecordById(String financialStaffId);//查询现金交账的数据(未结算)

    List<AccountRecord> selectARById(String financialStaffId);//查询现金交账的数据(未结算)
    /**
     * 通过批次号查询
     * @param batchNum
     * @return
     */
    List<AccountRecord> getAccountRecordByBatchNum(String batchNum);
    
    /**
     * 通过parentId查询
     * @param parentId
     * @return
     */
    AccountRecord selectARByParenId(String parentId);
    
    /**
     * 通过id查找
     * @param postId
     * @return
     */
    List<AccountRecord> listPagePostIdRecordRes(AccountRecord accountRecord);
    
    /**
     * 查询所有未收账的记录
     * @param accountRecord
     * @return
     */
    List<AccountRecord>listPageAccountRecordUnFinishTest(AccountRecord accountRecord);
    
    /**
     * 根据收款员退回的数据
     * @param accountRecord
     * @return
     */
    List<AccountRecord> selectARByStaffAndState(AccountRecord accountRecord);
    /**
     * 查询未交帐数据
     * @author hanyupeng
     */
    List<AccountRecord> listPageByPost(AccountRecord accountRecord);
    
    /**
     * 根据当前登录人统计 已交金额 总和
     * @param financialStaffId
     * @return
     */
    AccountRecord queryByFsid(String financialStaffId,String projectId);
    
    /**
     * 结算退回时，清空所有的批次号
     * @param batch
     */
	void updateByBatch(String batch);
}