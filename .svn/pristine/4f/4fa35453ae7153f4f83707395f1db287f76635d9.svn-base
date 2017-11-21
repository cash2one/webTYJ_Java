package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.flf.entity.AdvancePaymentsDetails;
import com.flf.entity.Annex;
import com.flf.entity.AssetAccount;
import com.flf.entity.AssetAccountDetail;
import com.flf.entity.Bill;
import com.flf.entity.ElectronicBilling;
import com.flf.entity.PageRestful;
import com.flf.entity.PaymentDetails;
import com.flf.mapper.AdvancePaymentsDetailsMapper;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.AssetAccountDetailMapper;
import com.flf.mapper.AssetAccountMapper;
import com.flf.mapper.BillMapper;
import com.flf.mapper.ElectronicBillingMapper;
import com.flf.mapper.PaymentDetailsMapper;
import com.flf.service.AdvancePaymentsDetailsService;

public class AdvancePaymentsDetailsServiceImpl implements AdvancePaymentsDetailsService {
	@Autowired
	private AdvancePaymentsDetailsMapper advancePaymentsDetailsMapper;
	@Autowired
	private AssetAccountDetailMapper assetAccountDetailMapper;// 资产账户详情
	@Autowired
	private AssetAccountMapper assetAccountMapper;// 资产账户
	@Autowired
	private BillMapper billMapper;// 账单表
	@Autowired
	private ElectronicBillingMapper electronicBillingMapper;//电子账单
	@Autowired
	private AnnexMapper annexMapper;//
	@Autowired
	private PaymentDetailsMapper paymentDetailsMapper;//历史记录

	@Override
	public int insertAdvancePaymentsDetails(AdvancePaymentsDetails advancePaymentsDetails) {

		// 存放结算金额
		double transactionAmount = advancePaymentsDetails.getTransactionAmount();
		// 获取用户通用余额
		AssetAccount assetAccount = assetAccountMapper.getAssetAccountById(advancePaymentsDetails.getAssetAccountId());
		// 通用余额
		double generalBalance = assetAccount.getGeneralBalance();
		//电子账单总计
		ElectronicBilling electronicBilling = electronicBillingMapper.getElectronicBillingById(advancePaymentsDetails.getBills().get(0).getElectronicBillingId());
		//收费项目id
		String chargeTypeId = advancePaymentsDetails.getBills().get(0).getChargeTypeId();
		boolean itemName = true;
		
		// 获取可抵扣收费项目对应余额
		if (advancePaymentsDetails.getBills().size() != 0) {
			// 获取可抵扣收费项目id
			for (Bill bills : advancePaymentsDetails.getBills()) {
				//是否是相同的收费项目
				if(!bills.getChargeTypeId().equals(chargeTypeId)){
					itemName = false;
				}
				bills = billMapper.getBillById(bills.getBillId());
				if(transactionAmount <= 0){
					break;
				}
				double tmpSurplus  = generalBalance - transactionAmount;
				// 对应可抵扣收费项目
				AssetAccountDetail aadTmp = assetAccountDetailMapper.getAssetAccountDetailByIdAndCiId(advancePaymentsDetails.getAssetAccountId(), bills.getChargeTypeId());
				if(aadTmp == null){
					aadTmp = new AssetAccountDetail();
				}else{
					tmpSurplus += aadTmp.getDisposableBalance();
				}
				//通用及可抵扣余额是否足够
				if(tmpSurplus <0){
					return 1;
				}
				if (transactionAmount > 0 && bills.getOverdue() >0) {
					// 结算金额先减去滞纳金
					Double ta = transactionAmount - bills.getOverdue();
					double aadTmpSum = 0.0;
					// 结算金额足够
					if(ta <=0){
						electronicBilling.setOverdue(electronicBilling.getOverdue()-transactionAmount);
						bills.setOverdue(Math.abs(ta));
					}
					// 可抵扣-滞纳金
					if(ta>0){
						if(aadTmp.getDisposableBalance()!=null){
							aadTmpSum = aadTmp.getDisposableBalance() - bills.getOverdue();
						}else{
							aadTmpSum = -bills.getOverdue();
						}
					}else{
						if(aadTmp.getDisposableBalance()!=null){
							aadTmpSum = aadTmp.getDisposableBalance() - transactionAmount;
						}else{
							aadTmpSum = -transactionAmount;
						}
					}
					// 可抵扣足够
					if (aadTmpSum >= 0) {
						aadTmp.setDisposableBalance(aadTmpSum);
						if(ta>0){
							electronicBilling.setOverdue(electronicBilling.getOverdue()-bills.getOverdue());
							bills.setOverdue(0);
						}
					} else {
						// 通用余额-可抵扣不够的金额
						double tmpSum = generalBalance - Math.abs(aadTmpSum);
						// 如果通用足够
						if (tmpSum > 0) {
							if(ta>0){
								electronicBilling.setOverdue(electronicBilling.getOverdue()-bills.getOverdue());
								bills.setOverdue(0);
							}
							generalBalance = tmpSum;
						} else {
							if(ta>0){
								electronicBilling.setOverdue(electronicBilling.getOverdue()-generalBalance);
								bills.setOverdue(bills.getOverdue() - generalBalance);
							}
							generalBalance = 0;
						}
					}
					transactionAmount = ta;
				}
				if (transactionAmount > 0 && bills.getLastOweSum()>0 ) {
					// 结算金额减去上期未结清累计金额
					Double ta = transactionAmount - bills.getLastOweSum();
					double aadTmpSum = 0.0;
					if(ta <=0){
						electronicBilling.setLastOweSum(electronicBilling.getLastOweSum()-transactionAmount);
						bills.setLastOweSum(Math.abs(ta));
					}
					//if (ta > 0) {
						// 可抵扣-上期未结清累计金额
					if(ta>0){
						if(aadTmp.getDisposableBalance()!=null){
							aadTmpSum = aadTmp.getDisposableBalance() - bills.getLastOweSum();
						}else{
							aadTmpSum = -bills.getLastOweSum();
						}
					}else{
						if(aadTmp.getDisposableBalance()!=null){
							aadTmpSum = aadTmp.getDisposableBalance() - transactionAmount;
						}else{
							aadTmpSum = -transactionAmount;
						}
					}
					// 可抵扣足够
					if (aadTmpSum >= 0) {
						aadTmp.setDisposableBalance(aadTmpSum);
						if(ta>0){
							electronicBilling.setLastOweSum(electronicBilling.getLastOweSum()-bills.getLastOweSum());
							bills.setLastOweSum(0);
						}
					} else {
						// 通用余额-可抵扣不够的金额
						double tmpSum = generalBalance - Math.abs(aadTmpSum);
						/*if(aadTmp.getDisposableBalance()!=null){
							aadTmp.setDisposableBalance(0.0);
						}*/
						// 如果通用足够
						if (tmpSum > 0) {
							if(ta>0){
								electronicBilling.setLastOweSum(electronicBilling.getLastOweSum()-bills.getLastOweSum());
								bills.setLastOweSum(0);
							}
							generalBalance = tmpSum;
							} else {
							if(ta>0){
								electronicBilling.setLastOweSum(electronicBilling.getLastOweSum()-generalBalance);
								bills.setLastOweSum(bills.getLastOweSum() - generalBalance);
							}
							generalBalance = 0;
						}
					}
					transactionAmount = ta;
				}
				if (transactionAmount > 0 && bills.getCurrentOweSum()>0) {
					// 结算金额减去本期应交金额
					Double ta = transactionAmount - bills.getCurrentOweSum();
					double aadTmpSum = 0.0;
					if(ta<=0){
						electronicBilling.setCurrentOweSum(electronicBilling.getCurrentOweSum()-transactionAmount);
						bills.setCurrentOweSum(Math.abs(ta));
					}
					
					// 可抵扣-上期未结清累计金额
					if(ta>0){
						if(aadTmp.getDisposableBalance()!=null){
							aadTmpSum = aadTmp.getDisposableBalance() - bills.getCurrentOweSum();
						}else{
							aadTmpSum = -bills.getCurrentOweSum();
						}
					}else{
						if(aadTmp.getDisposableBalance()!=null){
							aadTmpSum = aadTmp.getDisposableBalance() - transactionAmount;
						}else{
							aadTmpSum = -transactionAmount;
						}
					}
						// 可抵扣足够
						if (aadTmpSum >= 0) {
							if(ta>0){
								aadTmp.setDisposableBalance(aadTmpSum);
								electronicBilling.setCurrentOweSum(electronicBilling.getCurrentOweSum()-bills.getCurrentOweSum());
							}
							bills.setCurrentOweSum(0);
						} else {
							// 通用余额-可抵扣不够的金额
							double tmpSum = generalBalance - Math.abs(aadTmpSum);
							// 如果通用足够
							if (tmpSum > 0) {
								if(ta>0){
									electronicBilling.setCurrentOweSum(electronicBilling.getCurrentOweSum()-bills.getCurrentOweSum());
									bills.setCurrentOweSum(0);
								}
								generalBalance = tmpSum;
							} else {
								if(ta>0){
									electronicBilling.setCurrentOweSum(electronicBilling.getCurrentOweSum()-generalBalance);
									bills.setCurrentOweSum(bills.getCurrentOweSum() - generalBalance);
								}
								generalBalance = 0;
							}
						}
					transactionAmount = ta;
				}
				if(aadTmp.getDisposableBalance()!=null){
					assetAccountDetailMapper.updateAssetAccountDetail(aadTmp);
				}
				billMapper.updateBill(bills);
			}
			//保存电子账户
			electronicBillingMapper.updateElectronicBilling(electronicBilling);
			// 保存通用余额;
			assetAccount.setGeneralBalance(generalBalance);
			assetAccountMapper.updateAssetAccount(assetAccount);
		}
		advancePaymentsDetails.setAdvancePaymentsDetailsId(UUID.randomUUID().toString());
		advancePaymentsDetails.setIsOutIn(1);// 支出
		advancePaymentsDetails.setPaymentType(3);
		if(itemName){
			advancePaymentsDetails.setChargeTypeId(chargeTypeId);
		}
		advancePaymentsDetails.setAssetAccountNum(assetAccount.getAssetAccountNum());
		advancePaymentsDetails.setTransactionDate(new Date());
		advancePaymentsDetailsMapper.insertAdvancePaymentsDetails(advancePaymentsDetails);
		return 0;
	}

	@Override
	public PageRestful listPageAdvancePaymentDetailByAssetAccuontNum(AdvancePaymentsDetails advancePaymentsDetails) {
		// TODO Auto-generated method stub
		PageRestful pageRestful = new PageRestful();
		List<AdvancePaymentsDetails> advancePaymentsDetails2 = advancePaymentsDetailsMapper.listPageAdvancePaymentDetailByAssetAccuontNum(advancePaymentsDetails);
		advancePaymentsDetails2.add(0, null);
		pageRestful.setAdvancePaymentsDetails(advancePaymentsDetails2);
		pageRestful.setPage(advancePaymentsDetails.getPage());
		return pageRestful;
	}

	@Override
	public PageRestful listPageAdvancePaymentDetailByAssetAccountId(AdvancePaymentsDetails advancePaymentsDetails) {
		// TODO Auto-generated method stub
		PageRestful pageRestful = new PageRestful();
		List<AdvancePaymentsDetails> list = advancePaymentsDetailsMapper.listPageAdvancePaymentDetailByAssetAccountId(advancePaymentsDetails);
		list.add(0, null);
		pageRestful.setAdvancePaymentsDetails(list);
		pageRestful.setPage(advancePaymentsDetails.getPage());
		return pageRestful;
	}

	@Override
	public int refundMoney(AdvancePaymentsDetails advancePaymentsDetails) {
		AdvancePaymentsDetails apd = advancePaymentsDetailsMapper.queryByBean(advancePaymentsDetails);
		if(apd == null){
			return 2;
		}
		if(advancePaymentsDetails.getRefundMoneySum() > apd.getRefundableDepositAmount()){
			return 0;
		}else{
			apd.setRefundableDepositAmount(apd.getRefundableDepositAmount() - advancePaymentsDetails.getRefundMoneySum());
			List<Annex> annexList = advancePaymentsDetails.getAnnexs();
			if (annexList != null && annexList.size() > 0) {
				for (Annex annex : annexList) {
					annex.setRelationId(apd.getAdvancePaymentsDetailsId());
					annex.setAnnexTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
					annexMapper.insertAnnex(annex);
				}
			}
			advancePaymentsDetailsMapper.updateAdvancePaymentsDetails(apd);
			
			/**
			 * 1.退款两种类型：
			 * 1.1.现金 1.2.预付款
			 * 2.类型为预付款；修改对应通用余额
			 * 3.生成新的账户支收信息
			 * 4.生成历史记录
			 * hulili 
			 * 2016.7.3
			 */
			
			//类型为预付款；修改对应通用余额
			AssetAccount assetAccount = assetAccountMapper.getAssetAccountById(advancePaymentsDetails.getAssetAccountId());
			if(assetAccount != null && "2".equals(advancePaymentsDetails.getType())){
				assetAccount.setGeneralBalance(assetAccount.getGeneralBalance()+advancePaymentsDetails.getRefundMoneySum());
				assetAccountMapper.updateAssetAccount(assetAccount);
			}
			
			//生成新的账户支收信息
			apd.setAdvancePaymentsDetailsId(UUID.randomUUID().toString());
			apd.setIsOutIn(3);
			if("1".equals(advancePaymentsDetails.getType())){
				apd.setPaymentType(0);
			}else{
				apd.setPaymentType(3);
			}
			apd.setTransactionDate(new Date());
			apd.setTransactionAmount(advancePaymentsDetails.getRefundMoneySum());
			apd.setRefundableDepositAmount(0);
			advancePaymentsDetailsMapper.insertAdvancePaymentsDetails(apd);
			
			//历史记录
			PaymentDetails details=new PaymentDetails();
			details.setPaymentDetailsId(UUID.randomUUID().toString());
			details.setTransactionDate(new Date());
			String paymentNum=Long.toString(System.currentTimeMillis());//交易单号
			details.setPaymentNum(paymentNum);
			details.setRefundState(0);
			details.setAssetAccountId(assetAccount.getAssetAccountId());
			if("1".equals(advancePaymentsDetails.getType())){
				details.setCashSum(advancePaymentsDetails.getRefundMoneySum());
			}else{
				details.setChargeSum(advancePaymentsDetails.getRefundMoneySum());
			}
			details.setFinancialStaffId(advancePaymentsDetails.getFinancialStaffId());
			details.setFinancialStaffName(advancePaymentsDetails.getFinancialStaffName());
			details.setCustId(assetAccount.getCustId());
			details.setIsOutIn(1);
			paymentDetailsMapper.insertPaymentDetails(details);
			
			return 1;
		}
		
	}
	
}