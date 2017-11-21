package com.flf.service.impl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.fastjson.JSON;
import com.flf.entity.Account;
import com.flf.entity.AdvancePaymentsDetails;
import com.flf.entity.AreaTypeNew;
import com.flf.entity.AssetAccount;
import com.flf.entity.AssetAccountDetail;
import com.flf.entity.Bill;
import com.flf.entity.BuildingStructureNew;
import com.flf.entity.Constant;
import com.flf.entity.Formula;
import com.flf.entity.HouseNew;
import com.flf.entity.NewLease;
import com.flf.entity.PaymentDetails;
import com.flf.entity.PersonBuildingNew;
import com.flf.entity.PersonCustNew;
import com.flf.entity.Project;
import com.flf.entity.StallNew;
import com.flf.entity.StoreNew;
import com.flf.mapper.AdvancePaymentsDetailsMapper;
import com.flf.mapper.AreaTypeNewMapper;
import com.flf.mapper.AssetAccountDetailMapper;
import com.flf.mapper.AssetAccountMapper;
import com.flf.mapper.BillMapper;
import com.flf.mapper.BuildingStructureNewMapper;
import com.flf.mapper.FormulaMapper;
import com.flf.mapper.HouseNewMapper;
import com.flf.mapper.NewLeaseMapper;
import com.flf.mapper.PaymentDetailsMapper;
import com.flf.mapper.PersonBuildingNewMapper;
import com.flf.mapper.PersonCustNewMapper;
import com.flf.mapper.ProjectMapper;
import com.flf.mapper.StallNewMapper;
import com.flf.mapper.StoreNewMapper;
import com.flf.service.PaymsService;
import com.flf.util.ArithUtils;
import com.flf.util.Tools;

public class PaymsServiceImpl implements PaymsService {
	@Autowired
	private PersonCustNewMapper personCustNewMapper;
	@Autowired
	private PersonBuildingNewMapper personBuildingNewMapper;
	@Autowired
	private BuildingStructureNewMapper buildingStructureNewMapper;
	@Autowired
	private AreaTypeNewMapper areaTypeNewMapper;
	@Autowired
	private HouseNewMapper houseNewMapper;
	@Autowired
	private StoreNewMapper storeNewMapper;
	@Autowired
	private StallNewMapper stallNewMapper;
	@Autowired
	private NewLeaseMapper newLeaseMapper;
	@Autowired
	private AssetAccountMapper assetAccountMapper;
	@Autowired
	private ProjectMapper projectMapper;
	@Autowired
	private AdvancePaymentsDetailsMapper advancePaymentsDetailsMapper;
	@Autowired
	private PaymentDetailsMapper paymentDetailsMapper;
	@Autowired
	private BillMapper billMapper;
	@Autowired
	private FormulaMapper formulaMapper;
	@Autowired
	private AssetAccountDetailMapper assetAccountDetailMapper;
	@Override
	public PersonCustNew getPersonCustByPerson(String name, String cardNum,
			String phoneNum) {
		if(Tools.notEmpty(name) && Tools.notEmpty(phoneNum) && Tools.notEmpty(cardNum)){
			PersonCustNew custNew = personCustNewMapper.getPersonCustNewbyNameAndCardAndNum(name, cardNum, phoneNum);
			if(custNew!=null){
				return custNew;
			}
		}
		return new PersonCustNew();
	}
	
	@Override
	public List<PersonBuildingNew> listBuildingByCardNum(String custId){
		List<PersonBuildingNew> list = null;
		if(custId != null && custId != ""){
			list = new ArrayList<PersonBuildingNew>();
			list = personBuildingNewMapper.listBuildingByCustId(custId);
		}
		return list;			
	}
	@Override
	public BuildingStructureNew getBuildingStructureNewById(String id){

		BuildingStructureNew bsn = null;
		
		//当传入的id不为空时，查询对应建筑结构
		if(id != null && id != ""){
			bsn = new BuildingStructureNew();
			bsn = buildingStructureNewMapper.getBuildingStructureNewbyId(id);
			
			if(bsn != null){
				
				//查询所有面积类型并放入map
				List<AreaTypeNew> atList = new ArrayList<AreaTypeNew>();
				atList = areaTypeNewMapper.listAllAreaTypeNew();
				Map<String, String> atMap = new HashMap<String, String>();
				for(AreaTypeNew at : atList){
					atMap.put(at.getAreaTypeCode(), at.getId());
				}
				
				//当建筑结构的areaId不为空时，查询对应的住宅/商铺/车位，并放入对应的对象，生成建筑面积
				if((bsn.getAreaId() != null && bsn.getAreaId() != "") || (bsn.getBuildingType() != null && bsn.getBuildingType() != "")){
					
					if(bsn.getBuildingType().toString().equals("住宅") ){
						HouseNew hn = new HouseNew();
						hn = houseNewMapper.getHouseNewByBuildingStructId(bsn.getId());
						bsn.setHouse(hn);
						bsn.setBuildingArea(hn.getHouseArea());
					}else if(bsn.getBuildingType().toString().equals("商业") ){
						StoreNew store = new StoreNew();
						store = storeNewMapper.getStoreNewByBuildingStructureId(bsn.getId());
						bsn.setStore(store);
						bsn.setBuildingArea(store.getBuildingArea());
					}else if(bsn.getBuildingType().toString().equals("车位") ){
						StallNew stall = new StallNew();
						stall = stallNewMapper.listStallByBuildingStructureId(bsn.getId());
						bsn.setStall(stall);
					}
				}
				
				//查询此建筑结构关联的业主
				List<PersonBuildingNew> pbList = new ArrayList<PersonBuildingNew>();
				pbList = personBuildingNewMapper.getAllPersonBuildings(bsn.getId());
				List<PersonCustNew> pcList = new ArrayList<PersonCustNew>();
				PersonCustNew personCust = null;
				if(pbList != null && pbList.size() > 0){
					for(PersonBuildingNew pbn : pbList){
						personCust = new PersonCustNew();
						personCust = personCustNewMapper.getPersonCustById(pbn.getCustId());
						pcList.add(personCust);
					}				
					bsn.setPersonCusts(pcList);
				}
				
				//获取水电物业费单价
				List<Constant> constantList = new ArrayList<Constant>();
//				constantList = constantMapper.listConstantForPay();
				bsn.setConstantList(constantList);
				
			}
			
		}
		return bsn;
	}
	
	@Override
	public NewLease getNewLeaseByleasePersonIdAndHouseId(String leasePersonId, String houseId){
		NewLease newLease = new NewLease();
		HouseNew houseNew = houseNewMapper.getHouseNewByBuildingStructId(houseId);
		if(houseNew != null){
			newLease = newLeaseMapper.getNewLeaseByleasePersonIdAndHouseId(leasePersonId, houseNew.getId());			
		}
		return newLease;
	}
	
	/**
	 * 支付系统接口 
	 * 查询登陆人所在该小区的所有的账户资产
	 * 及每套房子的资产
	 */
	@Override
	public Account getAccountByCustId(String custId, String projectId){
		//定义个人客户
		Account account = new Account();		
		//判断传入参数是否为空
		if(Tools.notEmpty(custId) && Tools.notEmpty(projectId)){
			//查询该项目下总账户及各个房间账户
			List<AssetAccount> assetAccountList = assetAccountMapper.queryByProAndCid(custId,projectId);
			if(assetAccountList.size() > 0){
				double num = 0;
				for(AssetAccount assetBean : assetAccountList){
					List<AssetAccountDetail> detailsList = assetAccountDetailMapper.getAssetAccountDetailById(assetBean.getAssetAccountId());
					double balSum = 0;
					if(detailsList.size()>0){
						for(AssetAccountDetail detailsBean : detailsList){
							if(detailsBean.getDisposableBalance() > 0){
								//每套房子的可抵扣总金额
								balSum += detailsBean.getDisposableBalance();							
							}
						}
					}
					assetBean.setAssetAccountBalance(balSum + assetBean.getGeneralBalance());
					num += assetBean.getAssetAccountBalance();
				}
				account.setTotalBalance(num);
				account.setAssetAccountList(assetAccountList);
			}
		}
		return account;
	}
	
	@Override
	public List<Project> listProjectByCustId(String custId){
		
		List<Project> projectList = null;
		if(Tools.notEmpty(custId)){
			List<String> projectIdList = new ArrayList<String>();
			projectIdList = buildingStructureNewMapper.listProjectIdByCustId(custId);
			if(projectIdList != null && projectIdList.size() > 0){
				projectList = new ArrayList<Project>();
				Project project = null;
				for(String s : projectIdList){
					project = new Project();
					project = projectMapper.getProject(s);
					projectList.add(project);
				}
			}
		}
		
		return projectList;
	}
	
	/**
	 * 根据姓名电话身份证号查询客户信息
	 * @param name
	 * @param cardNum
	 * @param phoneNum
	 * @return
	 */
	@Override
	public PersonCustNew getPersonCustNewbyNameAndCardAndNum(String name, String cardNum, String phoneNum) {
		return personCustNewMapper.getPersonCustNewbyNameAndCardAndNum(name, cardNum, phoneNum);
	}
	
	@Override
	public List<PaymentDetails> getPaymentTypeByPaymentDetailsList(List<PaymentDetails> paymentDetails){
		for (PaymentDetails paymentDetails2 : paymentDetails) {
			//交易类型
			int tmp = 0;
			//现金
			if(paymentDetails2.getCashSum()!=null && paymentDetails2.getCashSum()!=0){
				paymentDetails2.setSum(paymentDetails2.getCashSum());
				//现金
				paymentDetails2.setPaymentType(0);
				tmp++;
				//刷卡交易
			}else if(paymentDetails2.getCreditCardSum()!=null && paymentDetails2.getCreditCardSum()!=0){
				if(tmp!=0){
					paymentDetails2.setSum(paymentDetails2.getCreditCardSum()+paymentDetails2.getCreditCardSum());
					//混合
					paymentDetails2.setPaymentType(8);
				}else{
					paymentDetails2.setSum(paymentDetails2.getCreditCardSum());
					//刷卡
					paymentDetails2.setPaymentType(1);
				}
				tmp++;
				//微信交易
			}else if(paymentDetails2.getWechatSum()!=null && paymentDetails2.getWechatSum()!=0){
				if(tmp!=0){
					paymentDetails2.setSum(paymentDetails2.getWechatSum()+paymentDetails2.getCreditCardSum());
					//混合
					paymentDetails2.setPaymentType(8);
				}else{
					paymentDetails2.setSum(paymentDetails2.getWechatSum());
					//微信
					paymentDetails2.setPaymentType(2);
				}
				tmp++;
				//预付款
			}else if(paymentDetails2.getChargeSum()!=null && paymentDetails2.getChargeSum()!=0){
				if(tmp!=0){
					paymentDetails2.setSum(paymentDetails2.getChargeSum()+paymentDetails2.getSum());
					//混合
					paymentDetails2.setPaymentType(8);
				}else{
					paymentDetails2.setSum(paymentDetails2.getChargeSum());
					//预付款
					paymentDetails2.setPaymentType(3);
				}
			}
		}
		return paymentDetails;
	}
	
	@Override
	public AssetAccount listAssetAccountByHouseIdAndCustId(String buildingId, String custId,String assetAccountId) {
		AssetAccount assetAccounts = new AssetAccount();
		AdvancePaymentsDetails  advancePaymentsDetails = new AdvancePaymentsDetails();
		advancePaymentsDetails.setAssetAccountId(assetAccountId);
		String dispos="";
		if(Tools.notEmpty(assetAccountId)){
			//查询资产账户
			assetAccounts = assetAccountMapper.getAssetAccountById(assetAccountId);
			if(assetAccounts != null && assetAccounts.getAssetAccountType() == 1){
				//查询资产账户明细
				dispos = assetAccountDetailMapper.getTotalDisposableBalance(assetAccountId);
			}
		}
		double generalBalance= assetAccounts.getGeneralBalance();
		double disposableBalance=0;
		if(Tools.notEmpty(dispos)){
			disposableBalance=Double.parseDouble(dispos);
		}
		assetAccounts.setAssetAccountBalance(generalBalance+disposableBalance);
		if(Tools.notEmpty(buildingId)){
			List<AdvancePaymentsDetails> list = advancePaymentsDetailsMapper.listPageAdvancePaymentDetailByAssetAccountId(advancePaymentsDetails);
			/*//获取资产账户和收支记录
			assetAccounts = assetAccountMapper.listAssetAccountByBuildingId(buildingId);
			//获取支付明细
			advancePaymentsDetails = advancePaymentsDetailsMapper.listAdvancePaymentDetailByBuildingId(buildingId);
		}else if(assetAccountId!=null){
			//获取资产账户和收支记录 (押金目前只有充值记录)
			assetAccounts = assetAccountMapper.getAssetAccountById(assetAccountId);
		}
		
		assetAccounts.setPaymentDetails(getPaymentTypeByPaymentDetailsList(assetAccounts.getPaymentDetails()));
		
		//遍历将支付明细加入到list
		for (AdvancePaymentsDetails advancePaymentsDetails2 : advancePaymentsDetails) {
			PaymentDetails pd = new PaymentDetails();
			//支付类型
			pd.setPaymentType(advancePaymentsDetails2.getPaymentType());
			//交易金额
			pd.setSum(advancePaymentsDetails2.getTransactionAmount());
			pd.setCiName("账户充值");
			//交易时间
			if(advancePaymentsDetails2.getTransactionDate()!=null){
				pd.setTransactionDate(advancePaymentsDetails2.getTransactionDate());
			}
			//交易状态
			pd.setIsOutIn(advancePaymentsDetails2.getIsOutIn());
			
			pd.setAdvancePaymentsDetailsId(advancePaymentsDetails2.getAdvancePaymentsDetailsId());
			
			assetAccounts.getPaymentDetails().add(pd);*/
			assetAccounts.setAdvancePaymentsDetails(list);
		}
		
		return assetAccounts;
	}
	
	/* @Override
	public ElectronicBilling listElectronicBillingByHouseIdAndCustId(String houseId, String custId) {
		ElectronicBilling e = electronicBillingMapper.getElectronicBillingByBuildingId(houseId);
		if(e==null){
			return e;
		}
		Bill bill = new Bill();
		bill.setBillDate(e.getBillDate());
		bill.setElectronicBillingId(e.getElectronicBillingId());
		List<Bill> bills = billMapper.listPageBillsByelectronicBillingIdThisMonth(bill);
		if(bills!=null && bills.size()!=0){
			if(e.getBills()==null){
				e.setBills(new ArrayList<Bill>());
			}
			e.getBills().addAll(bills);
		}
		return e;
	}*/
	
	@Override
	public List<Bill> listBillByElectronicBillingId(String buildingId,String chargeTypeId) {
		Bill bill = new Bill();
		bill.setBuildingId(buildingId);
		bill.setChargeTypeId(chargeTypeId);
		DecimalFormat df = new DecimalFormat("0.00");   
		List<Bill> bills = new ArrayList<>();
			bills = billMapper.listBillByElectronicBillingId(bill);	
			for (Bill bill1 : bills) {
				bill1.setTotalLastOweSum(Double.parseDouble((df.format(bill1.getLastOweSum()))));
				bill1.setCurrentOweSum(Double.parseDouble((df.format(bill1.getCurrentOweSum()))));
				bill1.setCurrentSum(Double.parseDouble((df.format(bill1.getCurrentSum()))));
				bill1.setOverdue(Double.parseDouble((df.format(bill1.getOverdue()))));
				bill1.setTotalCurrentSum(Double.parseDouble((df.format(bill1.getTotalCurrentSum()))));
				bill1.setTotalCurrentOweSum(Double.parseDouble((df.format(bill1.getTotalCurrentOweSum()))));
				bill1.setTotalOverdue(Double.parseDouble((df.format(bill1.getTotalOverdue()))));
				bill1.setTotalLastOweSum(Double.parseDouble((df.format(bill1.getTotalLastOweSum()))));
			}
		return bills;
	}
	
	@Override
	public int updateBillByPaymentDetailsJson(String paymentDetailsJson) {
		PaymentDetails paymentDetails = JSON.parseObject(paymentDetailsJson, PaymentDetails.class);
		Bill bill = billMapper.getBillById(paymentDetails.getBillId());
		Double sum = bill.getOverdue()+bill.getLastOweSum()+bill.getCurrentOweSum();
		if(paymentDetails.getWechatSum() - bill.getBillingSum() == 0){
			bill.setBillingSum(0.0);
			bill.setOverdue(0);
			bill.setLastOweSum(0);
			bill.setCurrentOweSum(0);
			int bm = billMapper.updateBill(bill);
			
			paymentDetails.setPaymentDetailsId(UUID.randomUUID().toString());
			paymentDetails.setTransactionAmount(paymentDetails.getWechatSum());
			paymentDetails.setTransactionDate(new Date());
			paymentDetails.setNote("微信接口");
			paymentDetails.setPaymentNum(paymentDetails.getOutTradeNo());
			paymentDetailsMapper.insertPaymentDetails(paymentDetails);
			if(bm >0){
				return 1;
			}
		}
		//批量支付
		/*for (Bill bill : paymentDetails.getBills()) {
			sum = bill.getOverdue()+bill.getLastOweSum()+bill.getCurrentOweSum();
			if(paymentDetails.getWechatSum() == sum){
				bill.setOverdue(0);
				bill.setLastOweSum(0);
				bill.setCurrentOweSum(0);
			}else{
				return 0;
			}
		}
		if(paymentDetails.getBills()!=null && paymentDetails.getBills().size()!=0){
			//批量跟新
			int bm = billMapper.updateBillList(paymentDetails.getBills());
			if(bm>0){
				return 1;
			}
		}*/
		return 0;
	}
	
	@Override
	public AdvancePaymentsDetails getPaymentDetailsByPaymentDetailsId(String advancePaymentsDetailsId) {
		AdvancePaymentsDetails  advancePaymentsDetails = new AdvancePaymentsDetails();
		if(advancePaymentsDetailsId!=null||advancePaymentsDetailsId!=""){
			 advancePaymentsDetails = advancePaymentsDetailsMapper.getAdvancePaymentDetailByAdvancePaymentsDetailsId(advancePaymentsDetailsId);
		}
		return advancePaymentsDetails;
	}

	@Override
	public List<Bill> listElectronicBillingByHouseIdAndCustId(String houseId) {
		Bill bill = new Bill();
		bill.setBuildingId(houseId);
/*		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());//设置一个日期用来测试
		calendar.add(Calendar.MONTH, -1);
	    bill.setBillDate(calendar.getTime());*/
		List<Bill> bills=billMapper.listPageFindChargeBybuildingId(bill);
		DecimalFormat df = new DecimalFormat("0.00");
		for (Bill bill1 : bills) {
			bill1.setTotalLastOweSum(Double.parseDouble((df.format(bill1.getLastOweSum()))));
			bill1.setCurrentOweSum(Double.parseDouble((df.format(bill1.getCurrentOweSum()))));
			bill1.setCurrentSum(Double.parseDouble((df.format(bill1.getCurrentSum()))));
			bill1.setOverdue(Double.parseDouble((df.format(bill1.getOverdue()))));
			bill1.setTotalCurrentSum(Double.parseDouble((df.format(bill1.getTotalCurrentSum()))));
			bill1.setTotalCurrentOweSum(Double.parseDouble((df.format(bill1.getTotalCurrentOweSum()))));
			bill1.setTotalOverdue(Double.parseDouble((df.format(bill1.getTotalOverdue()))));
			bill1.setTotalLastOweSum(Double.parseDouble((df.format(bill1.getTotalLastOweSum()))));
		}
		return bills;
	}

	/**
	 * 支付系统接口调用  查询计费详情Id
	 */
	@Override
	public List<Formula> getChargeItemDetailId(String buildingId,String projectId,String courrentTime,String btjj) {
		Map<String, Object> map = new HashMap<>();
		map.put("buildingId",buildingId);
		map.put("projectId",projectId);
		map.put("courrentTime",courrentTime);
		map.put("btjj",btjj);
		return formulaMapper.getChargeItemDetailId(map);
	}
  /**
   * 根据计费详情Id 查询物业费  本体基金
   */
	@Override
	public List<Formula> getFormularInfo(String chargeItemDetailsId) {
		List<Formula> list = null;
		if(chargeItemDetailsId != null && chargeItemDetailsId != ""){
			list = new ArrayList<Formula>();
			Map<String,Object> map =new HashMap<>();
			map.put("chargeItemDetailsId", chargeItemDetailsId);
			list = formulaMapper.getFormularInfo(map);
		}
		return list;	
	}
	
	/**
	 * 邻音支付后销帐
	 * 
	 * @author Zms
	 * @param buildingId
	 * @param chargeTypeId
	 * @param money
	 */
	public void crossOfAccount(String buildingId, String chargeTypeId, Double money) {
		Bill bil = new Bill();
		bil.setBuildingId(buildingId);
		bil.setChargeTypeId(chargeTypeId);
		List<Bill> billList = billMapper.listAllBill(bil);
		BigDecimal total_noColl = BigDecimal.valueOf(0);
		for (Bill deBill : billList) {
			total_noColl = total_noColl.add(new BigDecimal(deBill.getNoCollectSum()));
		}
		Double d_no = ArithUtils.sub(total_noColl.doubleValue(), money);

		for (int i = 0; i < billList.size(); i++) {
			Bill bill = billList.get(i);
			bill.setCollectSum(bill.getNoCollectSum());// 实收金额
			bill.setCurrentOweSum(0.0);// 本期欠款余额
			bill.setLastOweSum(0.0);// 上期欠款余额
			if (i == 0) {
				bill.setNoCollectSum(d_no);// 未收金额
				bill.setOverdue(d_no);// 滞纳金
			} else {
				bill.setNoCollectSum(0.0);// 未收金额
				bill.setOverdue(0.0);// 滞纳金
			}
			BigDecimal zero = BigDecimal.valueOf(0);
			BigDecimal b_no = new BigDecimal(d_no);
			if (zero.compareTo(b_no) == 0) {
				bill.setBillState(1);// 1-已核销
			}
			billMapper.updateBill(bill);

			AdvancePaymentsDetails apd = new AdvancePaymentsDetails();
			apd.setAdvancePaymentsDetailsId(UUID.randomUUID().toString());
			apd.setTransactionAmount(money);
			apd.setIsOutIn(3);
			apd.setTransactionDate(new Date());
			advancePaymentsDetailsMapper.insertAdvancePaymentsDetails(apd);
		}
	}

/*	@Override
	public List<PersonBuildingNew> listBuildingByCardNum(String cardNum){
		List<PersonBuildingNew> list = null;
		if(cardNum != null && cardNum != ""){
			list = new ArrayList<PersonBuildingNew>();
			list = personBuildingNewMapper.listBuildingByCardNum(cardNum);
		}
		return list;			
	}*/

}
