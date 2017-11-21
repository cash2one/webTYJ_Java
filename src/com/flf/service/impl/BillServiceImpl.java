package com.flf.service.impl;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import com.flf.entity.AdvancePaymentsDetails;
import com.flf.entity.AssetAccount;
import com.flf.entity.AssetAccountDetail;
import com.flf.entity.Bill;
import com.flf.entity.BillExport;
import com.flf.entity.Billing;
import com.flf.entity.BuildingStructureNew;
import com.flf.entity.PageRestful;
import com.flf.mapper.AdvancePaymentsDetailsMapper;
import com.flf.mapper.AssetAccountDetailMapper;
import com.flf.mapper.AssetAccountMapper;
import com.flf.mapper.BillMapper;
import com.flf.mapper.BuildingStructureNewMapper;
import com.flf.service.BillService;
import com.flf.util.ExportExcel;
import com.flf.util.Tools;

public class BillServiceImpl implements BillService {

	@Autowired
	private BillMapper billMapper;
	@Autowired
	private AssetAccountMapper assetAccountMapper;// 资产账户
	@Autowired
	private AssetAccountDetailMapper assetAccountDetailMapper;
	@Autowired
	private BuildingStructureNewMapper buildingStructureNewMapper;
	@Autowired
	private AdvancePaymentsDetailsMapper advancePaymentsDetailsMapper;// 预支付明细

	@Override
	public PageRestful listPageBill(Bill bill) {
		PageRestful pageRestful = new PageRestful();
		List<Bill> bills = billMapper.listPageBill(bill);
		bills.add(0, null);
		pageRestful.setBills(bills);
		pageRestful.setPage(bill.getPage());
		return pageRestful;
	}

	/* 获取客户资产下的建筑结构的账单 */
	@Override
	public List<Bill> getBillsByCustId(String custId) {
		List<Bill> bills = new ArrayList<Bill>();
		List<String> buildingIds = billMapper.getAllBuildingIdOfCust(custId);// 获取所有账户下建筑结构Id
		if (buildingIds != null && !buildingIds.isEmpty()) {
			for (String bId : buildingIds) {
				Bill bill = billMapper.getBillByBuildingId(bId);
				bills.add(bill);
			}
		}
		return bills;
	}

	@Override
	public PageRestful listPageBillsByelectronicBillingIdThisMonth(Bill bill) {
		PageRestful pageRestful = new PageRestful();
		List<Bill> bills = billMapper.listPageBillsByelectronicBillingIdThisMonth(bill);
		bills.add(0, null);
		pageRestful.setBills(bills);
		pageRestful.setPage(bill.getPage());
		return pageRestful;
	}

	@Override
	public PageRestful listPageBillsByelectronicBillingIdLastMonth(Bill bill) {
		PageRestful pageRestful = new PageRestful();
		List<Bill> bills = billMapper.listPageBillsByelectronicBillingIdLastMonth(bill);
		bills.add(0, null);
		pageRestful.setBills(bills);
		pageRestful.setPage(bill.getPage());
		return pageRestful;
	}

	@Override
	public void UpdateRefund(Bill bill) {
		billMapper.updateRefund(bill);
	}

	@Override
	public void UpdateImpact(Bill bill) {
		billMapper.updateImpact(bill);
	}

	@Override
	public void exportExcelFile(BillExport billExport) {
		ExportExcel<BillExport> ex = new ExportExcel<BillExport>();
		String[] headers = { "创建时间", "未缴费", "已缴费" };
		List<BillExport> dataset = new ArrayList<BillExport>();
		dataset.add(billExport);
		try {
			OutputStream out = new FileOutputStream("E://收缴率.xls");
			ex.exportExcel(headers, dataset, out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "导出成功!");
		System.out.println("excel导出成功！");
	}

	@Override
	public void updateBill(Bill bill) {
		billMapper.updateBill(bill);
	}

	/**
	 * 账单新增
	 */
	@Override
	public void AddBill(Bill bill) {
		bill.setBillId(UUID.randomUUID().toString());
		billMapper.insertBill(bill);
	}

	@Override
	public void serviceRequestAddBill(Bill bill) {
		bill.setBillId(UUID.randomUUID().toString());
		BuildingStructureNew buildingStructureNew = new BuildingStructureNew();
		buildingStructureNew = buildingStructureNewMapper.getBuildingStructurebyId(bill.getBuildingId());
		if (buildingStructureNew != null) {
			// 项目id
			bill.setProjectId(buildingStructureNew.getProjectId());
			if (buildingStructureNew.getBuilding() != null) {
				// 建筑编号
				bill.setBuildingNum(buildingStructureNew.getBuilding().getBuildingNum());
				;
			}
		}
		String billNum;
		if (bill.getPersonCustNew() != null) {
			if (bill.getPersonCustNew().getCardNum() != null && !bill.getPersonCustNew().getCardNum().equals("")) {
				// 截取证件号前5位
				billNum = bill.getPersonCustNew().getCardNum().substring(0, 5);
				if (bill.getBuildingNum() != null && !bill.getBuildingNum().equals("")) {
					// 截取5位建筑编号
					billNum += (bill.getBuildingNum().length() < 5 ? String.format("%05d", bill.getBuildingNum())
							: bill.getPersonCustNew().getCardNum().substring(0, 5));
				} else {
					// 生成5位随机数
					Random random = new Random();
					billNum += (int) (random.nextDouble() * (100000 - 10000) + 10000);
				}
				bill.setBillNum(billNum);
			}
		}

		bill.setBillDate(new Date());
		// 未支付状态
		bill.setBillState(1);
		billMapper.insertBill(bill);
	}

	@Override
	public List<Bill> getBillsByProjectIdAndDate(Bill bill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Billing> getSubBillsForSubChargeItem(Bill bill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bill> getOwe(Bill bill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bill> getCollectFee(Bill bill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void AddBillRes(String ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void AddBillForChargeItemBilling(String ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void AddBillForBuildingBilling(String ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public PageRestful listPageFindBillsByPersonMessage(Bill bill) {
		// TODO Auto-generated method stub
		PageRestful pageRestful = new PageRestful();
		if (bill.getCardNum() != null) {
			if (bill.getCardNum().length() >= 18) {
				bill.setCardNum(bill.getCardNum() + "S");
			}
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(bill.getBillDate());// 设置一个日期用来测试
		calendar.add(Calendar.MONTH, -1);
		bill.setBillDate(calendar.getTime());
		List<Bill> billList = billMapper.listPageFindBillsByPersonMessage(bill);
		billList.add(0, null);
		pageRestful.setBills(billList);
		pageRestful.setPage(bill.getPage());
		return pageRestful;
	}

	@Override
	public PageRestful listPageFindChargeBybuildingIdThisMonth(Bill bill) {
		// TODO Auto-generated method stub
		PageRestful pageRestful = new PageRestful();
		List<Bill> bills = billMapper.listPageFindChargeBybuildingIdThisMonth(bill);
		bills.add(0, null);
		pageRestful.setBills(bills);
		pageRestful.setPage(bill.getPage());
		return pageRestful;
	}

	@Override
	public PageRestful findChargeDetailsBychargeTypeIdThisMonth(Bill bill) {
		// TODO Auto-generated method stub
		PageRestful pageRestful = new PageRestful();
		List<Bill> bills = billMapper.findChargeDetailsBychargeTypeIdThisMonth(bill);
		bills.add(0, null);
		pageRestful.setBills(bills);
		pageRestful.setPage(bill.getPage());
		return pageRestful;
	}

	@Override
	public PageRestful listPageBillsBybuildingIdLastMonth(Bill bill) {
		PageRestful pageRestful = new PageRestful();
		List<Bill> bills = billMapper.listPageBillsBybuildingIdLastMonth(bill);
		bills.add(0, null);
		pageRestful.setBills(bills);
		pageRestful.setPage(bill.getPage());
		return pageRestful;
	}

	@Override
	public PageRestful findChargeDetailsBychargeTypeIdLastMonth(Bill bill) {
		// TODO Auto-generated method stub
		PageRestful pageRestful = new PageRestful();
		List<Bill> bills = billMapper.findChargeDetailsBychargeTypeIdLastMonth(bill);
		bills.add(0, null);
		pageRestful.setBills(bills);
		pageRestful.setPage(bill.getPage());
		return pageRestful;
	}

	public void deduction(Bill bill) {
		String typeName = bill.getChargeTypeId();
		AssetAccount account = new AssetAccount();
		AssetAccountDetail assetAccountDetail = new AssetAccountDetail();
		account.setBuildingId(bill.getBuildingId());
		List<AssetAccount> assetList = assetAccountMapper.queryByBuild(account);// 根据building_id查询账户详情
		double genSum = 0.0;// 通用金额
		double overSum = 0.0;// 滞纳金总金额
		double lastOweSum = 0.0;// 上期欠款总金额
		double currOweSum = 0.0;// 本期欠款总金额
		double subSum = 0.0;// 金额差
		double balaSum = 0.0;// 账单明细可抵扣金额
		if (assetList.get(0).getGeneralBalance() > 0) {
			genSum = assetList.get(0).getGeneralBalance();
		}
		AdvancePaymentsDetails apd = new AdvancePaymentsDetails();
		List<Bill> billList = new ArrayList<Bill>();
		List<Bill> billList1 = new ArrayList<Bill>();
		List<Bill> billList2 = new ArrayList<Bill>();
		List<Bill> billList3 = new ArrayList<Bill>();
		if (assetList.size() > 0) {
			apd.setAssetAccountId(assetList.get(0).getAssetAccountId());
			for (AssetAccount assetAccount : assetList) {
				if (assetAccount.getDisposableBalance() != null && assetAccount.getDisposableBalance() > 0) {
					assetAccountDetail.setAssetAccountDetailId(assetAccount.getAssetAccountDetailId());
					balaSum = assetAccount.getDisposableBalance();
				}
				subSum = balaSum + genSum;
				if (Tools.notEmpty(bill.getBillId())) {
					bill.setType("3");
					bill.setChargeTypeId(assetAccount.getChargeTypeId());
					billList = billMapper.queryByBillState(bill);
				} else {
					bill.setChargeTypeId(typeName);
					billList.add(bill);
				}
				//不管是否是生成账单调用    还是定时计算违约金调用  都要比较收费类型
				if (Tools.notEmpty(assetAccount.getChargeTypeId()) 
						&& assetAccount.getChargeTypeId().equals(bill.getChargeTypeId())) {
					if (billList.size() > 0) {
						for (Bill bean : billList) {
							overSum += bean.getOverdue();
							lastOweSum += bean.getLastOweSum();
							currOweSum += bean.getCurrentOweSum();
							if (subSum > bean.getOverdue()) {
								subSum = subSum - bean.getOverdue();
								bean.setOverdue(0.0);
							} else {
								bean.setOverdue(bean.getOverdue() - subSum);
								subSum = 0.0;
							}
							billList1.add(bean);
						}
						if (subSum > 0) {
							for (Bill bean1 : billList1) {
								if (subSum > bean1.getLastOweSum()) {
									subSum = subSum - bean1.getLastOweSum();
									bean1.setLastOweSum(0.0);
								} else {
									bean1.setLastOweSum(bean1.getLastOweSum() - subSum);
									subSum = 0.0;
								}
								billList2.add(bean1);
							}
						}
						if (subSum > 0) {
							for (Bill bean2 : billList2) {
								if (subSum > bean2.getCurrentOweSum()) {
									subSum = subSum - bean2.getCurrentOweSum();
									bean2.setCurrentOweSum(0.0);
								} else {
									bean2.setCurrentOweSum(bean2.getCurrentOweSum() - subSum);
									subSum = 0.0;
								}
								billList3.add(bean2);
							}
						}
					}
					int count = assetAccountDetailMapper.queryByIdCount(assetAccountDetail);
					if (subSum > 0 && (balaSum) >= (overSum + lastOweSum + currOweSum)) {
						// 可抵扣金额大于账单总金额
						if (count > 0) {
							assetAccountDetail.setDisposableBalance(balaSum - (overSum + lastOweSum + currOweSum));
							assetAccountDetailMapper.changePriceById(assetAccountDetail);
						}
					} else if (subSum > 0 && (balaSum) < (overSum + lastOweSum + currOweSum)) {
						// subSum为剩余通用金额
						if (count > 0) {
							assetAccountDetail.setDisposableBalance(0.0);
							assetAccountDetailMapper.changePriceById(assetAccountDetail);
						}
						assetAccount.setGeneralBalance(subSum);
						assetAccountMapper.topUP(assetAccount);
					} else if (subSum == 0.0) {
						if (count > 0) {
							assetAccountDetail.setDisposableBalance(subSum);
							assetAccountDetailMapper.changePriceById(assetAccountDetail);
						}
						assetAccount.setGeneralBalance(subSum);
						assetAccountMapper.topUP(assetAccount);
					}
				} else {
					if (billList.size() > 0) {
						for (Bill bean1 : billList) {
							if (bean1.getChargeTypePriority() != null) {
								overSum += bean1.getOverdue();
								lastOweSum += bean1.getLastOweSum();
								currOweSum += bean1.getCurrentOweSum();
								if (subSum > bean1.getOverdue()) {
									subSum = subSum - bean1.getOverdue();
									if (subSum > bean1.getLastOweSum()) {
										subSum = subSum - bean1.getLastOweSum();
										bean1.setOverdue(0.0);
										bean1.setLastOweSum(0.0);
									} else {
										bean1.setLastOweSum(bean1.getLastOweSum() - subSum);
										bean1.setOverdue(0.0);
										subSum = 0.0;
									}
								} else {
									bean1.setOverdue(bean1.getOverdue() - subSum);
									subSum = 0.0;
								}
							}
							billList2.add(bean1);
						}
						if (subSum > 0) {
							for (Bill bean2 : billList2) {
								if (bean2.getChargeTypePriority() != null) {
									if (subSum > bean2.getCurrentOweSum()) {
										subSum = subSum - bean2.getCurrentOweSum();
										bean2.setCurrentOweSum(0.0);
									} else {
										bean2.setOverdue(bean2.getCurrentOweSum() - subSum);
										subSum = 0.0;
									}
								}
								billList3.add(bean2);
							}
						}
					}
					// 修改通用余额
					assetAccount.setGeneralBalance(subSum);
					assetAccountMapper.topUP(assetAccount);
				}
				apd.setAdvancePaymentsDetailsId(UUID.randomUUID().toString());
				apd.setIsOutIn(2);// 抵扣欠款状态
				apd.setPaymentType(4);
				if (Tools.notEmpty(bill.getChargeTypeId())) {
					apd.setChargeTypeId(bill.getChargeTypeId());
				}
				apd.setTransactionDate(new Date());
				if (subSum > 0) {
					apd.setTransactionAmount(overSum + lastOweSum + currOweSum);
				} else {
					if (Tools.notEmpty(bill.getChargeTypeId())) {
						apd.setTransactionAmount(balaSum + genSum);
					} else {
						apd.setTransactionAmount(genSum);
					}
				}
				if (apd.getTransactionAmount() > 0) {
					// 新增明细抵扣记录
					advancePaymentsDetailsMapper.insertAdvancePaymentsDetails(apd);
				}
			}
			if (billList3.size() > 0) {
				for (Bill bill2 : billList3) {
					if (Tools.notEmpty(bill2.getBillId())) {
						bill2.setNoCollectSum(bill2.getOverdue() + bill2.getLastOweSum() + bill2.getCurrentOweSum());
						billMapper.updateBill(bill2);
					} else {
						bill2.setBillId(UUID.randomUUID().toString());
						bill2.setChargeTypeId(typeName);
						billMapper.insertBill(bill2);
					}
				}
			} else if (billList2.size() > 0) {
				for (Bill bill2 : billList2) {
					if (Tools.notEmpty(bill2.getBillId())) {
						bill2.setNoCollectSum(bill2.getOverdue() + bill2.getLastOweSum() + bill2.getCurrentOweSum());
						billMapper.updateBill(bill2);
					} else {
						bill2.setBillId(UUID.randomUUID().toString());
						bill2.setChargeTypeId(typeName);
						billMapper.insertBill(bill2);
					}
				}
			} else if (billList1.size() > 0) {
				for (Bill bill2 : billList1) {
					if (Tools.notEmpty(bill2.getBillId())) {
						bill2.setNoCollectSum(bill2.getOverdue() + bill2.getLastOweSum() + bill2.getCurrentOweSum());
						billMapper.updateBill(bill2);
					} else {
						bill2.setBillId(UUID.randomUUID().toString());
						bill2.setChargeTypeId(typeName);
						billMapper.insertBill(bill2);
					}
				}
			}
		}
	}

}
