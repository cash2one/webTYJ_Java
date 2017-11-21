package com.flf.quartz;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.flf.entity.BillingRecord;
import com.flf.entity.BuildingStructureNew;
import com.flf.entity.ChargeItemNew;
import com.flf.entity.ChargeItemNewBuilding;
import com.flf.entity.ChargeItemNewDetails;
import com.flf.entity.ChargeTypeBuildingBilling;
import com.flf.entity.ChargeTypeDetailsBuildingBilling;
import com.flf.entity.ChargeTypeProjectBilling;
import com.flf.entity.DataDictionarySlave;
import com.flf.entity.Formula;
import com.flf.entity.MeterReadingData;
import com.flf.entity.ProjectBilling;
import com.flf.entity.Scheme;
import com.flf.mapper.BillingRecordMapper;
import com.flf.mapper.BuildingStructureNewMapper;
import com.flf.mapper.ChargeItemNewBuildingMapper;
import com.flf.mapper.ChargeItemNewDetailsMapper;
import com.flf.mapper.ChargeItemNewMapper;
import com.flf.mapper.ChargeTypeBuildingBillingMapper;
import com.flf.mapper.ChargeTypeDetailsBuildingBillingMapper;
import com.flf.mapper.ChargeTypeProjectBillingMapper;
import com.flf.mapper.FormulaMapper;
import com.flf.mapper.HouseNewMapper;
import com.flf.mapper.ProjectBillingMapper;
import com.flf.mapper.StallNewMapper;
import com.flf.mapper.StoreNewMapper;
import com.flf.service.DataDictionarySlaveService;
import com.flf.service.MeterReadingDataService;
import com.flf.service.SchemeService;
import com.flf.util.DateUtil;
import com.flf.util.Tools;

public class BillingJob extends QuartzJobBean{
	@Autowired
	private ChargeItemNewMapper chargeItemNewMapper;
	@Autowired
	private ChargeItemNewBuildingMapper chargeItemNewBuildingMapper;
	@Autowired
	private BuildingStructureNewMapper buildingStructureNewMapper;
	@Autowired
	private ChargeItemNewDetailsMapper chargeItemNewDetailsMapper;
	@Autowired
	private FormulaMapper formulaMapper;
	@Autowired
	private DataDictionarySlaveService dataDictionarySlaveService;
	@Autowired
	private ChargeTypeBuildingBillingMapper chargeTypeBuildingBillingMapper;
	@Autowired
	private ChargeTypeProjectBillingMapper chargeTypeProjectBillingMapper;
	@Autowired
	private ProjectBillingMapper projectBillingMapper;
	@Autowired
	private BillingRecordMapper billingRecordMapper;
	@Autowired
	private MeterReadingDataService meterReadingDataService;
	@Autowired
	private SchemeService schemeService;
	@Autowired
	private ChargeTypeDetailsBuildingBillingMapper chargeTypeDetailsBuildingBillingMapper;
	@Autowired
	private HouseNewMapper houseNewMapper;
	@Autowired
	private StoreNewMapper storeNewMapper;
	@Autowired
	private StallNewMapper stallNewMapper;
	
	private static final Logger log = Logger.getLogger(BillingJob.class);

	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		
	}
	/**
	 * 自动计费
	 * @author maogaofei
	 * @date 2016年7月14日 下午5:05:30
	 */
	public void AutoBilling(){
		List<Scheme> schemeList = schemeService.getAutoSchemeList();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		SimpleDateFormat sdfDay = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cald = Calendar.getInstance(); 
		cald.add(Calendar.MONTH, -1);//获取上个月月份
		String month = sdf.format(cald.getTime());//计费月份
		for(Scheme sm:schemeList){//计费方案列表
			String chargeFre = sm.getChargeFre();//计费频率
			String chargeTime = sm.getChargeTime();//自动计费日期
			int int_chargeTime = Integer.parseInt(chargeTime);
			String billingDate = sm.getBillingDate();//上次计费日期
			
			Date newDate = new Date();
			String billingMonth = sdf.format(newDate);
			if(Tools.isEmpty(billingDate)){
				ProjectBilling projectBilling = new ProjectBilling();
				projectBilling.setMonth(month);
				projectBilling.setProjectId(sm.getProjectId());
				List<ProjectBilling> pbList = projectBillingMapper.listAllProjectBilling(projectBilling);
				List<ChargeTypeProjectBilling> ctpbList = new ArrayList<>();
				if(pbList.size() > 0){
					ChargeTypeProjectBilling chargeTypeProjectBilling = new ChargeTypeProjectBilling();
					chargeTypeProjectBilling.setProjectBillingId(pbList.get(0).getProjectBillingId());
					chargeTypeProjectBilling.setChargeTypeId(sm.getChargeTypeId());
					ctpbList = chargeTypeProjectBillingMapper.listAllChargeTypeProjectBilling(chargeTypeProjectBilling);
				}
				Calendar calendar = Calendar.getInstance();
				int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);//当月最后一天
				if(lastDay < int_chargeTime){
					Calendar cal=Calendar.getInstance();
					int int_day = cal.get(Calendar.DATE);
					if(int_day == lastDay){//计费时间为当月最后一天
						if(ctpbList.size() == 0){
							//计费
							billing(sm,month,billingMonth,chargeFre);
						}
					}
				}else{
					Calendar cal=Calendar.getInstance();
					int int_day = cal.get(Calendar.DATE);
					if(int_day == int_chargeTime){
						if(ctpbList.size() == 0){
							//计费
							billing(sm,month,billingMonth,chargeFre);
						}
					}
				}
			}else{
				ProjectBilling projectBilling = new ProjectBilling();
				projectBilling.setMonth(month);
				projectBilling.setProjectId(sm.getProjectId());
				List<ProjectBilling> pbList = projectBillingMapper.listAllProjectBilling(projectBilling);
				if(pbList.size() > 0){
					ChargeTypeProjectBilling chargeTypeProjectBilling = new ChargeTypeProjectBilling();
					chargeTypeProjectBilling.setProjectBillingId(pbList.get(0).getProjectBillingId());
					chargeTypeProjectBilling.setChargeTypeId(sm.getChargeTypeId());
					List<ChargeTypeProjectBilling> ctpbList = chargeTypeProjectBillingMapper.listAllChargeTypeProjectBilling(chargeTypeProjectBilling);
					if(ctpbList.size() == 0){
						if("02".equals(chargeFre)){
							try {
								Date billDate = sdfDay.parse(billingDate);
								Calendar c = Calendar.getInstance();
								c.setTime(billDate);
								c.add(Calendar.MONTH,2);//在日历的月份上增加2个月
								String billDateStr = sdf.format(c.getTime());
								Date nowDate = new Date();
								String nowDateStr = sdf.format(nowDate);
								if(nowDateStr.equals(billDateStr)){
									Calendar calendar = Calendar.getInstance();
									int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);//当月最后一天
									if(lastDay < int_chargeTime){
										Calendar cal=Calendar.getInstance();
										int int_day = cal.get(Calendar.DATE);
										if(int_day == lastDay){//计费时间为当月最后一天
											//计费
											billing(sm,month,billingMonth,chargeFre);
										}
									}else{
										Calendar cal=Calendar.getInstance();
										int int_day = cal.get(Calendar.DATE);
										if(int_day == int_chargeTime){
											//计费
											billing(sm,month,billingMonth,chargeFre);
										}
									}
								}
								
							} catch (ParseException e) {
								e.printStackTrace();
							}
						}else{
							Calendar calendar = Calendar.getInstance();
							int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);//当月最后一天
							if(lastDay < int_chargeTime){
								Calendar cal=Calendar.getInstance();
								int int_day = cal.get(Calendar.DATE);
								if(int_day == lastDay){//计费时间为当月最后一天
									//计费
									billing(sm,month,billingMonth,chargeFre);
								}
							}else{
								Calendar cal=Calendar.getInstance();
								int int_day = cal.get(Calendar.DATE);
								if(int_day == int_chargeTime){
									//计费
									billing(sm,month,billingMonth,chargeFre);
								}
							}
						}
						
					}
				}else{
					//计费
					billing(sm,month,billingMonth,chargeFre);
				}
			}
		}
	}
	/**
	 * 计费
	 * @author maogaofei
	 * @date 2016年7月15日 上午9:27:05
	 * @param sm 计费方案
	 * @param month 计费月份
	 * @param billingMonth 计费日期
	 */
	private void billing(Scheme sm, String month, String billingMonth,String chargeFre) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		ProjectBilling projectBilling = new ProjectBilling();
		projectBilling.setMonth(month);
		projectBilling.setProjectId(sm.getProjectId());
		List<ProjectBilling> pbList = projectBillingMapper.listAllProjectBilling(projectBilling);
		if(pbList.size()>0){
			projectBilling = pbList.get(0);
		}else{
			projectBilling.setProjectBillingId(UUID.randomUUID().toString());
		}
		
		String projectId = sm.getProjectId();
		ChargeItemNew chargeItemNew = new ChargeItemNew();
		chargeItemNew.setSchemeId(sm.getSchemeId());
		List<ChargeItemNew> chargeItemNewList = chargeItemNewMapper.listAllChargeItemNew(chargeItemNew);
		String chargeTypeProjectBillingId = UUID.randomUUID().toString();//收费类型项目计费ID
		BigDecimal b_ctProjectBillAmount = BigDecimal.valueOf(0);
		
		for(ChargeItemNew cin:chargeItemNewList){//收费项目列表
			ChargeItemNewDetails chargeItemNewDetails = new ChargeItemNewDetails();
			chargeItemNewDetails.setChargeItemNewId(cin.getChargeItemNewId());
			List<ChargeItemNewDetails> cinDetailsList = chargeItemNewDetailsMapper.listAllChargeItemNewDetails(chargeItemNewDetails);
			
			ChargeItemNewBuilding chargeItemNewBuilding = new ChargeItemNewBuilding();
			chargeItemNewBuilding.setChargeItemNewId(cin.getChargeItemNewId());
			List<ChargeItemNewBuilding> cinbList = chargeItemNewBuildingMapper.listAllChargeItemNewBuilding(chargeItemNewBuilding);
			for(ChargeItemNewBuilding cinb:cinbList){//收费项目建筑关系列表
				String chargeTypeBuildingBillingId = UUID.randomUUID().toString();
				BigDecimal ctBuildBillAmount = BigDecimal.valueOf(0);
				String buildingId = cinb.getBuildingId();
				BuildingStructureNew buildingStructureNew = buildingStructureNewMapper.getBuildingStructureNewbyId(buildingId);
				
				Calendar cald = Calendar.getInstance(); 
				cald.add(Calendar.MONTH, -1);//获取上个月月份
				Date month_one = new Date();
				try {
					month_one = sdf.parse(sdf.format(cald.getTime()));
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				String waterSumStr_one = getWaterSum(buildingId,month_one);//获取上个月的用水量
				String electricSumStr_one = "0";//获取上个月的用电量
				String buildAreaStr = "0";//获取建筑面积
				String rTBuildAreaStr = "0";//使用范围总建筑面积
				String totalInAreaStr = "0";//总套内面积
				String totalCompAreaStr = "0";//总竣工面积
				if(Tools.notEmpty(buildingStructureNew.getBuildingType())){
					if("住宅".equals(buildingStructureNew.getBuildingType())){
						Double houseArea = houseNewMapper.getHouseAreaByBuildingStructId(buildingId);
						if(houseArea != null){
							buildAreaStr = houseArea.toString();
						}
					}
					if("商铺".equals(buildingStructureNew.getBuildingType())){
						Double buildingArea = storeNewMapper.getBuildingAreaByBuildingStructureId(buildingId);
						if(buildingArea != null){
							buildAreaStr = buildingArea.toString();
						}
					}
					if("车位".equals(buildingStructureNew.getBuildingType())){
						Double usableArea = stallNewMapper.getUsableAreaByBuildingStructureId(buildingId);
						if(usableArea != null){
							buildAreaStr = usableArea.toString();
						}
					}
				}
				
				for(ChargeItemNewDetails cinDetails:cinDetailsList){//收费项目详情列表
					ChargeTypeDetailsBuildingBilling chargeTypeDetailsBuildingBilling = new ChargeTypeDetailsBuildingBilling();
					String chargeTypeDetailsBuildingBillingId = UUID.randomUUID().toString();
					chargeTypeDetailsBuildingBilling.setChargeTypeDetailsBuildingBillingId(chargeTypeDetailsBuildingBillingId);
					chargeTypeDetailsBuildingBilling.setChargeTypeBuildingBillingId(chargeTypeBuildingBillingId);
					chargeTypeDetailsBuildingBilling.setChargeTypeDetailsId(cinDetails.getChargeTypeDetailsId());
					chargeTypeDetailsBuildingBilling.setChargeItemDetailsId(cinDetails.getChargeItemDetailsId());
					//获取收费类型详情建筑计费金额
					BigDecimal b_amount = BigDecimal.valueOf(0);
					if("02".equals(chargeFre)){
						Calendar cal = Calendar.getInstance(); 
						cal.add(Calendar.MONTH, -2);//获取上上个月月份
						Date month_two = new Date();
						try {
							month_two = sdf.parse(sdf.format(cal.getTime()));
						} catch (ParseException e) {
							e.printStackTrace();
						}
						
						String waterSumStr_two = getWaterSum(buildingId,month_two);//获取上上个月的用水量
						String electricSumStr_two = "0";//获取上上个月的用电量
						b_amount = getAmount(cinDetails.getChargeItemDetailsId(),waterSumStr_one,
								electricSumStr_one,buildAreaStr,rTBuildAreaStr,totalInAreaStr,totalCompAreaStr,projectId);
						b_amount = b_amount.add(getAmount(cinDetails.getChargeItemDetailsId(),
								waterSumStr_two,electricSumStr_two,buildAreaStr,rTBuildAreaStr,totalInAreaStr,totalCompAreaStr,projectId));
					}else{
						b_amount = getAmount(cinDetails.getChargeItemDetailsId(),waterSumStr_one,
								electricSumStr_one,buildAreaStr,rTBuildAreaStr,totalInAreaStr,totalCompAreaStr,projectId);
					}
					chargeTypeDetailsBuildingBilling.setAmount(b_amount);
					chargeTypeDetailsBuildingBilling.setStatus("00");//00-未出账，01-已出账
					chargeTypeDetailsBuildingBilling.setCreateTime(DateUtil.getToday("yyyy-MM-dd HH:mm:ss"));
					chargeTypeDetailsBuildingBilling.setUpdateTime(DateUtil.getToday("yyyy-MM-dd HH:mm:ss"));
					chargeTypeDetailsBuildingBilling.setBillingTime(DateUtil.getToday("yyyy-MM-dd HH:mm:ss"));
					chargeTypeDetailsBuildingBillingMapper.insertSelective(chargeTypeDetailsBuildingBilling);
					
					BillingRecord billingRecord = new BillingRecord();//计费记录
					billingRecord.setBillingRecordId(UUID.randomUUID().toString());
					billingRecord.setProjectId(projectId);
					billingRecord.setBuildingId(buildingId);
					billingRecord.setChargeTypeDetailsId(cinDetails.getChargeTypeDetailsId());
					billingRecord.setChargeTypeDetailsBuildingBillingId(chargeTypeDetailsBuildingBillingId);
					billingRecord.setBillingTime(DateUtil.getToday("yyyy-MM-dd HH:mm"));
					billingRecord.setAmount(b_amount);
					billingRecord.setCreateTime(DateUtil.getToday("yyyy-MM-dd HH:mm:ss"));
					billingRecord.setUpdateTime(DateUtil.getToday("yyyy-MM-dd HH:mm:ss"));
					billingRecordMapper.insertSelective(billingRecord);
					ctBuildBillAmount = ctBuildBillAmount.add(b_amount);
				}
				ChargeTypeBuildingBilling chargeTypeBuildingBilling = new ChargeTypeBuildingBilling();
				chargeTypeBuildingBilling.setChargeTypeBuildingBillingId(chargeTypeBuildingBillingId);
				chargeTypeBuildingBilling.setChargeTypeProjectBillingId(chargeTypeProjectBillingId);
				chargeTypeBuildingBilling.setChargeTypeId(sm.getChargeTypeId());
				chargeTypeBuildingBilling.setBuildingId(buildingId);
				chargeTypeBuildingBilling.setBillingMonth(billingMonth);
				chargeTypeBuildingBilling.setAmount(ctBuildBillAmount);
				chargeTypeBuildingBilling.setStatus("00");//00-未出账，01-已出账
				chargeTypeBuildingBilling.setCreateTime(DateUtil.getToday("yyyy-MM-dd HH:mm:ss"));
				chargeTypeBuildingBilling.setUpdateTime(DateUtil.getToday("yyyy-MM-dd HH:mm:ss"));
				chargeTypeBuildingBilling.setBillingTime(DateUtil.getToday("yyyy-MM-dd HH:mm:ss"));
				chargeTypeBuildingBillingMapper.insertSelective(chargeTypeBuildingBilling);
				b_ctProjectBillAmount = b_ctProjectBillAmount.add(ctBuildBillAmount);
			}
		}
		ChargeTypeProjectBilling chargeTypeProjectBilling = new ChargeTypeProjectBilling();
		chargeTypeProjectBilling.setChargeTypeProjectBillingId(chargeTypeProjectBillingId);
		chargeTypeProjectBilling.setAmount(b_ctProjectBillAmount);
		chargeTypeProjectBilling.setProjectBillingId(projectBilling.getProjectBillingId());
		chargeTypeProjectBilling.setChargeTypeId(sm.getChargeTypeId());
		chargeTypeProjectBilling.setBillingMonth(billingMonth);
		chargeTypeProjectBilling.setStatus("00");//00-未出账，01-已出账
		chargeTypeProjectBilling.setCreateTime(DateUtil.getToday("yyyy-MM-dd HH:mm:ss"));
		chargeTypeProjectBilling.setUpdateTime(DateUtil.getToday("yyyy-MM-dd HH:mm:ss"));
		chargeTypeProjectBilling.setBillingTime(DateUtil.getToday("yyyy-MM-dd HH:mm:ss"));
		chargeTypeProjectBillingMapper.insertSelective(chargeTypeProjectBilling);
		
		ChargeTypeProjectBilling ctpBilling = new ChargeTypeProjectBilling();
		ctpBilling.setProjectBillingId(projectBilling.getProjectBillingId());
		List<ChargeTypeProjectBilling> ctpbList = chargeTypeProjectBillingMapper.listAllChargeTypeProjectBilling(ctpBilling);
		BigDecimal b_pBillingAmount = BigDecimal.valueOf(0);
		for(ChargeTypeProjectBilling ctpb:ctpbList){
			b_pBillingAmount = b_pBillingAmount.add(ctpb.getAmount());
		}
		projectBilling.setAmount(b_pBillingAmount);
		projectBilling.setUpdateTime(DateUtil.getToday("yyyy-MM-dd HH:mm:ss"));
		projectBilling.setBillingTime(DateUtil.getToday("yyyy-MM-dd HH:mm:ss"));
		projectBilling.setStatus("00");//00-未出账，01-已出账
		if(pbList.size()>0){
			projectBillingMapper.updateByPrimaryKeySelective(projectBilling);
		}else{
			projectBilling.setCreateTime(DateUtil.getToday("yyyy-MM-dd HH:mm:ss"));
			projectBilling.setBillingMonth(billingMonth);
			projectBillingMapper.insertSelective(projectBilling);
		}
		
		if("02".equals(chargeFre)){
			SimpleDateFormat sdFormat= new SimpleDateFormat("yyyy-MM-dd");
			sm.setBillingDate(sdFormat.format(new Date()));
		}
	}
	/**
	 * 计算收费类型详情建筑计费金额
	 * @author maogaofei
	 * @date 2016年7月15日 上午11:08:33
	 * @param chargeItemNewDetailsId 收费项目详情ID
	 * @param waterSumStr_one 用水量
	 * @param electricSumStr_one 用电量
	 * @param buildAreaStr 建筑面积
	 * @param projectId 项目ID
	 * @return
	 */
	private BigDecimal getAmount(String chargeItemNewDetailsId,
			String waterSumStr,String electricSumStr,
			String buildAreaStr,String rTBuildAreaStr,
			String totalInAreaStr,String totalCompAreaStr,String projectId){
		ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript"); 
		Formula formula = new Formula();
		formula.setChargeItemDetailsId(chargeItemNewDetailsId);
		List<Formula> formulaList = formulaMapper.listAllFormula(formula);
		String amountStr = "0";
		for(Formula fm:formulaList){
			String conditionExpression = fm.getConditionExpression();
			String formulaExpression = fm.getFormulaExpression();
			List<DataDictionarySlave> variableList = dataDictionarySlaveService.getDataDictionarySlaveRes("variable", projectId);
			for(DataDictionarySlave dds:variableList){
				if("waterSum".equals(dds.getSlaveName())){
					if(Tools.notEmpty(conditionExpression)){
						conditionExpression = conditionExpression.replaceAll(dds.getSlaveName(), waterSumStr);
					}
					formulaExpression = formulaExpression.replaceAll(dds.getSlaveName(), waterSumStr);
				}
				if("electricSum".equals(dds.getSlaveName())){
					if(Tools.notEmpty(conditionExpression)){
						conditionExpression = conditionExpression.replaceAll(dds.getSlaveName(), electricSumStr);
					}
					formulaExpression = formulaExpression.replaceAll(dds.getSlaveName(), electricSumStr);
				}
				if("buildArea".equals(dds.getSlaveName())){
					if(Tools.notEmpty(conditionExpression)){
						conditionExpression = conditionExpression.replaceAll(dds.getSlaveName(), buildAreaStr);
					}
					formulaExpression = formulaExpression.replaceAll(dds.getSlaveName(), buildAreaStr);
				}
				if("RTBuildArea".equals(dds.getSlaveName())){
					if(Tools.notEmpty(conditionExpression)){
						conditionExpression = conditionExpression.replaceAll(dds.getSlaveName(), rTBuildAreaStr);
					}
					formulaExpression = formulaExpression.replaceAll(dds.getSlaveName(), rTBuildAreaStr);
				}
				if("TotalInArea".equals(dds.getSlaveName())){
					if(Tools.notEmpty(conditionExpression)){
						conditionExpression = conditionExpression.replaceAll(dds.getSlaveName(), totalInAreaStr);
					}
					formulaExpression = formulaExpression.replaceAll(dds.getSlaveName(), totalInAreaStr);
				}
				if("TotalCompArea".equals(dds.getSlaveName())){
					if(Tools.notEmpty(conditionExpression)){
						conditionExpression = conditionExpression.replaceAll(dds.getSlaveName(), totalCompAreaStr);
					}
					formulaExpression = formulaExpression.replaceAll(dds.getSlaveName(), totalCompAreaStr);
				}
			}
			try{
				if(Tools.isEmpty(conditionExpression)){
					amountStr = jse.eval(formulaExpression).toString();
				}else{
					if("true".equals(jse.eval(conditionExpression).toString())){
						amountStr = jse.eval(formulaExpression).toString();
					}
				}
				
			}catch (Exception e) {
				 log.error("公式运算错误！"); 
			}
		}
		BigDecimal b_amount = new BigDecimal(amountStr);
		b_amount.setScale(2, BigDecimal.ROUND_UP);
		return b_amount;
	}
	/**
	 * 获取用水量
	 * @author maogaofei
	 * @date 2016年7月15日 上午10:37:44
	 * @param buildingId 建筑ID
	 * @param month_one 月份
	 * @return
	 */
	private String getWaterSum(String buildingId, Date month_one) {
		MeterReadingData meterReadingData = new MeterReadingData();
		meterReadingData.setBuildingStructureId(buildingId);
		meterReadingData.setSpecifiedDate(month_one);
		Double d_waterSum =  meterReadingDataService.getWaterMeterUsage(meterReadingData);
		return d_waterSum.toString();
	}

}
