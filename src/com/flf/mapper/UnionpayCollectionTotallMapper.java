package com.flf.mapper;

import java.util.List;

import com.flf.entity.UnionpayCollectionTotall;

public interface UnionpayCollectionTotallMapper {
     
	//通过主键ID
    List<UnionpayCollectionTotall> getUnionpayCollectionTotallById(String unionpayCollectionTotallId);
    //分页查询
    List<UnionpayCollectionTotall> listPageUnionpayCollectionTotall(UnionpayCollectionTotall unionpayCollectionTotall);
    
    
    
    /**
     * 按照托收状态查询
     * @param collectionType
     * @return
     */
    List<UnionpayCollectionTotall> listAllUnionpay(String ProjectId);
    
    /**
     * 插入银联托收总结表
     * @param unionpayCollectionTotall
     * @return
     */
    int insertUnionpayCollectionTotall(UnionpayCollectionTotall unionpayCollectionTotall);
    
    /**
     * 银联取消托收删除数据
     * @param unionpayCollectionTotallId
     */
    void deleteTotallById(String unionpayCollectionTotallId);
    
    /**
     * 修改托收状态为已托收
     */
    void updateCollectionState(String unionpayCollectionTotallId);
    
    /**
     * 修改托收状态为已回盘
     * @param orderId
     */
    void updateCollectionStateTo(UnionpayCollectionTotall unionpayCollectionTotall);
    
    List<UnionpayCollectionTotall> listPageUnionpay(UnionpayCollectionTotall unionpayCollectionTotall);
    
    /**
     * 根据项目Id和托收状态判断是否有重复记录
     * @param projectId
     * @return
     */
	int queryCount(UnionpayCollectionTotall uct);
	/**
	 * 根据项目id和托收状态为0的查询
	 * @param uct
	 * @return
	 */
	List<UnionpayCollectionTotall> queryByIdAndType(UnionpayCollectionTotall uct);
	
	/**
	 * 获取最大的批次号
	 * @return
	 */
	int getBatchNum(String projectId);
}
