package com.flf.mapper;

import java.util.List;

import com.flf.entity.AdvancePaymentsDetails;

public interface AdvancePaymentsDetailsMapper {

	List<AdvancePaymentsDetails> getAdvancePaymentDetailByAssetAccountId(String assetAccountId);//根据资产账户id获取对应的账单信息
	List<AdvancePaymentsDetails> getAdvancePaymentDetailByAssetAccuontNum(String AssetAccuontNum);//根据资产编号获取对应账单信息
	
	List<AdvancePaymentsDetails> listPageAdvancePaymentDetailByAssetAccuontNum(AdvancePaymentsDetails advancePaymentsDetails);//分页根据资产编号获取对应账单信息
	
	Double sumTransactionAmountByassetAccountId(String assetAccountId);//汇总押金金额
	Double sumRefundableDepositAmountByassetAccountId(String assetAccountId);//汇总可退押金金额

    /*新增*/
    int insertAdvancePaymentsDetails(AdvancePaymentsDetails advancePaymentsDetails);
    /*更新*/
    int updateAdvancePaymentsDetails(AdvancePaymentsDetails advancePaymentsDetails);
    /* 分页查询 */
    List<AdvancePaymentsDetails> listPageAdvancePaymentDetailByAssetAccountId(AdvancePaymentsDetails advancePaymentsDetails);
    
    /**
     * 根据预收款明细id查询收款信息
     * @author zhuqi 2016.04.20
     * @param AdvancePaymentsDetailsId
     * @return
     */
    AdvancePaymentsDetails getAdvancePaymentDetailByAdvancePaymentsDetailsId(String AdvancePaymentsDetailsId);
	
    /**
     * 根据押金单号查询
     * @author zhuqi 2016.04.22
     * @param depositNum
     * @return
     */
    AdvancePaymentsDetails getAdvancePaymentDetailByDepositNum(String depositNum);
    
    List<AdvancePaymentsDetails> listAdvancePaymentDetailByBuildingId(String buildingId);
    /**
     * 根据传入的对象查询数据
     * @param advancePaymentsDetails
     * @return
     */
	AdvancePaymentsDetails queryByBean(AdvancePaymentsDetails advancePaymentsDetails);
}
