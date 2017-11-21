package com.flf.service.impl;

import java.net.InetAddress;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.flf.entity.AdvancePaymentsDetails;
import com.flf.entity.Bill;
import com.flf.entity.PageRestful;
import com.flf.entity.PaymentDetails;
import com.flf.mapper.AdvancePaymentsDetailsMapper;
import com.flf.mapper.BillMapper;
import com.flf.mapper.PaymentDetailsMapper;
import com.flf.plugin.WeixinApi;
import com.flf.request.ScanPayReqData;
import com.flf.request.ScanPayResData;
import com.flf.service.PaymentDetailsService;
import com.flf.service.ProductCommonserviceService;
import com.flf.service.ScanPayService;
import com.flf.util.PrintPay;
import net.sf.json.JSONObject;

public class PaymentDetailsServiceImpl implements PaymentDetailsService {
	@Autowired
	private PaymentDetailsMapper paymentDetailsMapper;// 支付明细
	@Autowired
	private BillMapper billMapper;// 每月账单
	@Autowired
	private ProductCommonserviceService productCommonserviceService;
	@Autowired
	private AdvancePaymentsDetailsMapper advancePaymentsDetailsMapper;
	@Autowired
	private ScanPayService scanPayService;
	/** 日志文件生成器 */
	private static final Logger logger = LoggerFactory.getLogger(PaymentDetailsServiceImpl.class);
	@Override
	public List<PaymentDetails> listAllPaymentDetails(String financialStaffId) {
		return paymentDetailsMapper.listAllPaymentDetails(financialStaffId);
	}

	@Override
	public PageRestful listPagePaymentDetails(PaymentDetails paymentDetails) {
		PageRestful pageRestful = new PageRestful();
		List<PaymentDetails> paymentDetailss = paymentDetailsMapper.listPagePaymentDetails(paymentDetails);
		paymentDetailss.add(0, null);
		pageRestful.setPaymentDetail(paymentDetailss);
		pageRestful.setPage(paymentDetails.getPage());
		return pageRestful;
	}

	@Override
	public PaymentDetails getPaymentDetailsById(String paymentDetailsId) {
		return paymentDetailsMapper.getPaymentDetailsById(paymentDetailsId);
	}

	@Override
	public void insertPaymentDetailsRes(PaymentDetails paymentDetails) {

		//PrintPay printPay = new PrintPay();
		//printPay.Print(paymentDetails);
		// 结算总金额
		double sum = 0;
		// 支付类型
		String str = "";
		// 收费项目
		String namtTmp = "混合";
		if (paymentDetails.getCreditCardSum() != null) {
			sum += paymentDetails.getCreditCardSum();

			str = str + "1";
		}
		if (paymentDetails.getWechatSum() != null) {
			ScanPayResData scanPayResData = requestScanPayService(paymentDetails);
			if (scanPayResData.getReturn_code().equals("SUCCESS")) {
				sum += paymentDetails.getWechatSum();
				str = str + "2";
			}else{
				sum += paymentDetails.getWechatSum();
				str = str + "2";
			}
		}
		if (paymentDetails.getCashSum() != null) {
			sum += paymentDetails.getCashSum();
			str = str + "0";
		}
		// 变成整型
		int paymentType = Integer.parseInt(str);
		if (paymentDetails.getBills() != null && paymentDetails.getBills().size() != 0
				&& paymentDetails.getBills().get(0).getChargeTypeId() != null) {
			namtTmp = paymentDetails.getBills().get(0).getChargeTypeId();
		}

		List<Bill> list = paymentDetails.getBills();
		// 把优先级为空的放在最后面

		// 把list变成数组排序
		Bill[] billArray = new Bill[list.size()];
		int t = 0;
		for (int i = 0; i < paymentDetails.getBills().size(); i++) {
			if (paymentDetails.getBills().get(i).getChargeTypePriority() != null) {
				billArray[t++] = paymentDetails.getBills().get(i);
			}
		}
		for (int i = 0; i < paymentDetails.getBills().size(); i++) {
			if (paymentDetails.getBills().get(i).getChargeTypePriority() == null) {
				billArray[t++] = paymentDetails.getBills().get(i);
			}
		}
		for (int i = 0; i < billArray.length; i++) {
			for (int j = i; j < billArray.length; j++) {
				if (billArray[j].getChargeTypePriority() != null) {
					if (billArray[i].getChargeTypePriority() >= billArray[j].getChargeTypePriority()) {
						Bill billtag;
						billtag = billArray[i];
						billArray[i] = billArray[j];
						billArray[j] = billtag;

					}
				}
			}
		}
		for (int i = 0; i < billArray.length; i++) {
			// billArray[i] = billMapper.getBillById(billArray[i].getBillId());
			Bill bill = billArray[i];
			List<Bill> billsDetails = billMapper.findChargeDetailsBychargeTypeIdThisMonth(bill);
			if (sum <= 0) {
				return;
			} else { // 结算违约金
				double total = sum;
				if (bill.getTotalOverdue() > 0 && sum > 0) {
					double tmpSum = sum - bill.getTotalOverdue();
					if (tmpSum > 0) {
						for (Bill bill1 : billsDetails) {
							bill1.setOverdue(0);
							bill1.setNoCollectSum(bill1.getOverdue()+bill1.getCurrentOweSum()+bill1.getLastOweSum());
							billMapper.updateBill(bill1);
						}
						sum -= bill.getTotalOverdue();
					} else {
						for (Bill bill1 : billsDetails) {
							if (bill1.getOverdue() > 0 && sum > 0) {
								if (sum - bill1.getOverdue() >= 0) {
									bill1.setOverdue(0);
									bill1.setNoCollectSum(bill1.getOverdue()+bill1.getCurrentOweSum()+bill1.getLastOweSum());
									billMapper.updateBill(bill1);
									sum = sum - bill1.getOverdue();
								} else {
									bill1.setOverdue(bill1.getOverdue() - sum);
									bill1.setNoCollectSum(bill1.getOverdue()+bill1.getCurrentOweSum()+bill1.getLastOweSum());
									billMapper.updateBill(bill1);
									sum = 0;
								}

							}
						}

					}

				}
				// 上期累计未结清
				if (bill.getTotalLastOweSum() > 0 && sum > 0) {
					if (sum - bill.getTotalLastOweSum() >= 0) {
						for (Bill bill1 : billsDetails) {
							bill1.setLastOweSum(0);
							bill1.setNoCollectSum(bill1.getOverdue()+bill1.getCurrentOweSum()+bill1.getLastOweSum());
							billMapper.updateBill(bill1);
						}
						sum -= bill.getTotalLastOweSum();
					} else {
						for (Bill bill1 : billsDetails) {
							if (sum - bill1.getLastOweSum() > 0) {
								bill1.setLastOweSum(0);
								bill1.setNoCollectSum(bill1.getOverdue()+bill1.getCurrentOweSum()+bill1.getLastOweSum());
								billMapper.updateBill(bill1);
								sum = sum - bill1.getLastOweSum();
							} else {
								bill1.setLastOweSum(bill1.getLastOweSum() - sum);
								bill1.setNoCollectSum(bill1.getOverdue()+bill1.getCurrentOweSum()+bill1.getLastOweSum());
								billMapper.updateBill(bill1);
								sum = 0;
							}
						}
					}
				}
				// 本期欠款结清
				if (sum > 0 && bill.getTotalCurrentOweSum() > 0) {
					if (sum - bill.getTotalCurrentOweSum() > 0) {
						for (Bill bill1 : billsDetails) {
							bill1.setCurrentOweSum(0);
							bill1.setNoCollectSum(bill1.getOverdue()+bill1.getCurrentOweSum()+bill1.getLastOweSum());
							billMapper.updateBill(bill1);
						}
						sum = sum - bill.getTotalCurrentOweSum();
					} else {
						for (Bill bill1 : billsDetails) {
							if (sum - bill1.getCurrentOweSum() > 0) {
								bill1.setCurrentOweSum(0);
								bill1.setNoCollectSum(bill1.getOverdue()+bill1.getCurrentOweSum()+bill1.getLastOweSum());
								billMapper.updateBill(bill1);
								sum = sum - bill1.getCurrentOweSum();
							} else {
								bill1.setCurrentOweSum(bill1.getCurrentOweSum() - sum);
								bill1.setNoCollectSum(bill1.getOverdue()+bill1.getCurrentOweSum()+bill1.getLastOweSum());
								billMapper.updateBill(bill1);
								sum = 0;
							}
						}
					}
				}
			/*for (Bill bill1 : billsDetails){
					bill1.setNoCollectSum(bill1.getOverdue()+bill1.getCurrentOweSum()+bill1.getLastOweSum());
					billMapper.updateBill(bill1);	
				}*/
				AdvancePaymentsDetails apd = new AdvancePaymentsDetails();
				if (sum > 0) {
					apd.setTransactionAmount(bill.getTotalCurrentOweSum() + bill.getLastOweSum() + bill.getOverdue());
					apd.setRefundableDepositAmount(
							bill.getTotalCurrentOweSum() + bill.getLastOweSum() + bill.getOverdue());
				} else {
					apd.setTransactionAmount(total);
					apd.setRefundableDepositAmount(total);
				}
				apd.setAdvancePaymentsDetailsId(UUID.randomUUID().toString());
				apd.setChargeTypeId(bill.getChargeTypeId());
				apd.setAssetAccountId(paymentDetails.getAssetAccountId());
				apd.setAssetAccountNum(paymentDetails.getAssetAccountNum());
				apd.setChargeTypeName(bill.getChargeTypeName());
				apd.setPaymentType(paymentType);
				apd.setTransactionDate(new Date());
				apd.setIsOutIn(1);
				advancePaymentsDetailsMapper.insertAdvancePaymentsDetails(apd);
			}
		}
		if (paymentDetails.getCashSum() != null && sum > 0) {
			paymentDetails.setCashSum(paymentDetails.getCashSum() - sum);
		}
		paymentDetails.setPaymentDetailsId(UUID.randomUUID().toString());
		paymentDetails.setTransactionDate(new Date());
		// String paymentNum=Long.toString(System.currentTimeMillis());
		// paymentDetails.setPaymentNum(paymentNum);
		paymentDetails.setRefundState(0);
		paymentDetails.setCiName(namtTmp);
		// 支出
		paymentDetails.setIsOutIn(1);
		paymentDetailsMapper.insertPaymentDetails(paymentDetails);
	}

	@Override
	public PaymentDetails createPaymentNum(String projectId) {
		PaymentDetails paymentDetailsRes = new PaymentDetails();
		PaymentDetails paymentDetails = paymentDetailsMapper.getPaymentNum();
		String serialNumber = paymentDetails.getPaymentNum();
		String paymentNumJson = productCommonserviceService.getProductNumber("440300", projectId, "02", "005",
				serialNumber);
		JSONObject jasonObject = JSONObject.fromObject(paymentNumJson);
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) jasonObject;
		String paymentNum = map.get("code");
		paymentDetailsRes.setPaymentNum(paymentNum);
		return paymentDetailsRes;
	}

	@Override
	public PageRestful listPageWithPaymentDetails(PaymentDetails paymentDetail) {
		PageRestful pageRestful = new PageRestful();
		List<PaymentDetails> paymentDetails = paymentDetailsMapper.listPageWithPaymentDetails(paymentDetail);
		paymentDetails.add(0, null);
		pageRestful.setPaymentDetail(paymentDetails);
		pageRestful.setPage(paymentDetail.getPage());
		return pageRestful;
	}

	@Override
	public List<PaymentDetails> getPaymentDatilsSumByStaffId(String financialStaffId, String projectId) {
		return paymentDetailsMapper.getPaymentDetailsSum(financialStaffId, projectId);
	}

	@Override
	public void printPaymentBills(PaymentDetails paymentDetails) {
//		PrintPay printPay = new PrintPay();
//		printPay.Print(paymentDetails);
	}

	/**
	 * 请求支付服务
	 * 
	 * @param scanPayReqData
	 *            这个数据对象里面包含了API要求提交的各种数据字段
	 * @return API返回的数据
	 * @throws Exception
	 */
	public ScanPayResData requestScanPayService(PaymentDetails paymentDetails) {
		int totalFee = (int) (paymentDetails.getWechatSum() * 100);// 接口中参数支付金额单位为【分】，参数值不能带小数
		InetAddress ia = null;
		ScanPayResData scanPayResData = null;
		try {
			ia = ia.getLocalHost();
			String localip = ia.getHostAddress();// 本机的ip
			//传参
			ScanPayReqData scanPayReqData = new ScanPayReqData(WeixinApi.appid, WeixinApi.mchId,
					paymentDetails.getAuthorizationCode(), "payment", totalFee, 
					localip, paymentDetails.getOutTradeNo());
			//请求接口
			scanPayResData = scanPayService.request(scanPayReqData);
		} catch (IllegalAccessException e) {
			logger.error("安全权限异常", e);
		} catch (InstantiationException e) {
			logger.error("实例化异常", e);
		} catch (ClassNotFoundException e) {
			logger.error("无法找到指定的类异常", e);
		} catch (Exception e) {
			logger.error("查询失败", e);
		}
		return scanPayResData;
	}
}
