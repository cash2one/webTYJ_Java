package com.flf.mapper;

import java.util.List;
import com.flf.entity.PaymentDetails;

public interface PaymentDetailsMapper {
	/*查询员工下所有的账单信息*/
	List<PaymentDetails> listAllPaymentDetails(String financialStaffId);
	/*分页查询账单信息*/
    List<PaymentDetails> listPagePaymentDetails(PaymentDetails paymentDetails);
    /*根据id查询账单信息*/
    PaymentDetails getPaymentDetailsById(String paymentDetailsId);
    /*删除账单信息*/
    int deletePaymentDetails(String paymentDetailsId);
    /*新增账单信息*/
    int insertPaymentDetails(PaymentDetails paymentDetails);
    /*修改账单信息*/
    int updatePaymentDetails(PaymentDetails paymentDetails);
    /*条件查询账单所有信息*/
    List<PaymentDetails> searchPaymentDetails(PaymentDetails paymentDetails);

    List<PaymentDetails> listPageWithPaymentDetails(PaymentDetails paymentDetail);
    
    /*
     * 获取现金，刷卡，微信各自的总额
     */
    List<PaymentDetails> getPaymentDetailsSum(String financialStaffId, String projectId);
    
    /*
     * 通过交账id查找付款详情
     */
    List<PaymentDetails> getPaymentDetailsByAccountId(String accountRecordId);
    
    /**
     * 根据资产账户id查询收支明细
     * @author zhuqi 2016.04.28 
     * @param assetAccountId
     * @return
     */
    List<PaymentDetails>listPaymentDatilsByAssetAccountId(String assetAccountId);
	
	PaymentDetails getPaymentNum();

}