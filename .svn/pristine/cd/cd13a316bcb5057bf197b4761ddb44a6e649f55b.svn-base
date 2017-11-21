package com.flf.service.impl;

import java.util.Date;
import java.util.List;
import com.flf.entity.Bill;
import com.flf.entity.ElectronicBilling;
import com.flf.entity.PageRestful;
import com.flf.mapper.BillMapper;
import com.flf.mapper.ElectronicBillingMapper;
import com.flf.service.ElectronicBillingService;

public class ElectronicBillingServiceImpl implements ElectronicBillingService {

	private ElectronicBillingMapper electronicBillingMapper;//电子账单
	private BillMapper billMapper;//应收款单
	
	
	public BillMapper getBillMapper() {
		return billMapper;
	}

	public void setBillMapper(BillMapper billMapper) {
		this.billMapper = billMapper;
	}

	public ElectronicBillingMapper getElectronicBillingMapper() {
		return electronicBillingMapper;
	}

	public void setElectronicBillingMapper(
			ElectronicBillingMapper electronicBillingMapper) {
		this.electronicBillingMapper = electronicBillingMapper;
	}

	@Override
	public List<ElectronicBilling> getElectronicBillingsByCustId(String custId) {
		// TODO Auto-generated method stub
		List<ElectronicBilling> electronicBilling = electronicBillingMapper.getElectronicBillingsByCustId(custId);
		if(electronicBilling!=null){//判断是否为空
			for (ElectronicBilling electronicBilling2 : electronicBilling) {
				String electronicBillingId = electronicBilling2.getElectronicBillingId();
				String buildingId = electronicBilling2.getBuildingId();
				/*获取上期未结清累计金额*/
				Double lastOweSum = billMapper.getNoCollectSumByElectronicBillIdAndBuildingId(electronicBillingId, buildingId);
				double lastOweSum1 = lastOweSum==null?0:lastOweSum;
				/*获取滞纳金总额*/
				Double overdue = billMapper.getOverdueByElectronicBillIdAndBuildingId(electronicBillingId, buildingId);
				double overdue1 = overdue==null?0:overdue;
				/*本期应收余额为本期应收金额-已交金额*/
				Double currentSum = electronicBilling2.getCurrentSum();//本期金额
				Double collectSum = electronicBilling2.getCollectSum();//已交金额
				double currentSum1 = currentSum==null?0:currentSum;
				double collectSum1 = collectSum==null?0:collectSum;
				double leftSum = currentSum1-collectSum1;
				/*本期欠款累计金额 是指本期应该缴纳的所有金额	 即本期应收余额+上期未结清累计金额+滞纳金*/
				double currentOweSum = leftSum+lastOweSum1+overdue1;
				
				electronicBilling2.setLastOweSum(lastOweSum1);
				electronicBilling2.setOverdue(overdue1);
				electronicBilling2.setCurrentOweSum(currentOweSum);
				/*更新数据库*/
				electronicBillingMapper.updateElectronicBilling(electronicBilling2);
			}
		}
		return electronicBillingMapper.getElectronicBillingsByCustId(custId);
	}

	/*条件查询*/
	@Override
	public List<ElectronicBilling> QueryResultElectronicBillings(
			ElectronicBilling electronicBilling) {
		// TODO Auto-generated method stub
		String custId = electronicBilling.getCustId();
		if(custId!=null && !custId.isEmpty()){
			return electronicBillingMapper.QueryResultElectronicBillings(electronicBilling);
		}
		return null;
	}

	@Override
	public List<Bill> getBillsThisMonth(String electronicBillingId,
			String currentDate) {
		// TODO Auto-generated method stub
		List<Bill> bills = billMapper.getBillsByelectronicBillingIdThisMonth(electronicBillingId, currentDate);
		if(bills!=null){
			for (Bill bill : bills) {
				Double noCollectSumOfLastMonth = billMapper.getNoCollectSumOfLastMonth(bill);//获取上月未交金额
				double noCollectSumOfLastMonth1 = noCollectSumOfLastMonth==null?0:noCollectSumOfLastMonth;
				double cumulativeAmountOfArrears = noCollectSumOfLastMonth1+bill.getNoCollectSum()+bill.getOverdue();//上期欠款累计金额
				bill.setCumulativeAmountOfArrears(cumulativeAmountOfArrears);
				bill.setNoCollectSum(noCollectSumOfLastMonth1);
				billMapper.updateBill(bill);
			}
		}
		return billMapper.getBillsByelectronicBillingIdThisMonth(electronicBillingId, currentDate);
	}

	@Override
	public List<Bill> getBillsLastMonth(String electronicBillingId,
			String currentDate) {
		// TODO Auto-generated method stub
		return billMapper.getBillsByelectronicBillingIdLastMonth(electronicBillingId, currentDate);
	}

	@Override
	public void insertElectronicBillingRes(ElectronicBilling electronicBilling) {
		// TODO Auto-generated method stub
		electronicBilling.setBillDate(new Date());
		electronicBillingMapper.insertElectronicBilling(electronicBilling);
	}

	@Override
	public PageRestful listPageElectronicBilling(
			ElectronicBilling electronicBilling) {
		// TODO Auto-generated method stub
		PageRestful pagerestful=new PageRestful();
		if(electronicBilling.getCardNum()!=null){
			if(electronicBilling.getCardNum().length()>=18){
				electronicBilling.setCardNum(electronicBilling.getCardNum()+"S");
			}
		}
		List<ElectronicBilling> electronicBillings =electronicBillingMapper.listPageElectronicBilling(electronicBilling);
		electronicBillings.add(0,null);
		pagerestful.setElectronicBillings(electronicBillings);
		pagerestful.setPage(electronicBilling.getPage());
		return pagerestful;
	}

}
