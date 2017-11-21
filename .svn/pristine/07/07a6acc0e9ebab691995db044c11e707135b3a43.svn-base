package com.flf.mapper;

import java.util.List;

import com.flf.entity.AssetAccountDetail;

/**
 * 2015-10-10
 * @author taoyongchao
 *资产账户详情表
 */
public interface AssetAccountDetailMapper {
	
	List<AssetAccountDetail> getAssetAccountDetailById(String assetAccountId);
	 /*删除资产账户信息*/
    int deleteAssetAccountDetail(String assetAccountDetailId);
    /*新增资产账户信息*/
    int insertAssetAccountDetail(AssetAccountDetail assetAccountDetail);
    /*修改资产账户信息*/
    int updateAssetAccountDetail(AssetAccountDetail assetAccountDetail);
    
    /**
     * 根据id修改金额值
     * 王洲
     * 2015.12.31
     * @param assetAccountDetail
     */
    void changePriceById(AssetAccountDetail assetAccountDetail);
    
    /**
     * 根据资产账户id以及收费项目id查询是否已有对应数据
     * @param assetAccountId
     * @param chargeItemId
     * @return
     */
    AssetAccountDetail getAssetAccountDetailByIdAndCiId(String assetAccountId, String chargeItemId);
    
    /**
     * 根据id查询记录
     * @param assetAccountDetail
     * @return
     */
	int queryByIdCount(AssetAccountDetail assetAccountDetail);
	/**
	 * 根据资产Id查询改账户的总的可抵扣金额
	 * @param assetAccountId
	 * @return
	 */
	String getTotalDisposableBalance(String assetAccountId);
}
