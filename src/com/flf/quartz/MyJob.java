package com.flf.quartz;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import com.flf.entity.Bill;
import com.flf.entity.BillingRecord;
import com.flf.entity.ChargeItemNew;
import com.flf.entity.DataDictionarySlave;
import com.flf.mapper.BillMapper;
import com.flf.mapper.BillingRecordMapper;
import com.flf.mapper.DataDictionarySlaveMapper;
import com.flf.service.BillService;
import com.flf.util.Tools;

public class MyJob extends QuartzJobBean{
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	@Autowired
	private BillMapper billMapper;//账单表
	@Autowired
	private DataDictionarySlaveMapper dataDictionarySlaveMapper;//字典从表
	@Autowired
	private BillService billService;
	@Autowired
	private BillingRecordMapper billingRecordMapper;//计费记录id
	
	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		
	}
	
	public void quartMethod() {
		// 打印当前时间
		String time = new SimpleDateFormat("MMM d，yyyy KK:mm:ss a", Locale.ENGLISH).format(System.currentTimeMillis());
		System.out.println("time:" + time);
	}

	//违约金生成方法
	public void chargeOverdue(){
		Bill bean = new Bill();
		bean.setType("2");
		List<Bill> buildList = billMapper.queryByBillState(bean);//查询生成的账单表中的有效账单的building_id
		if(buildList.size()>0){
			for(Bill bill : buildList){
				billService.deduction(bill);
			}
		}
		bean.setEndDate(new Date());
		bean.setType("1");
		List<Bill> list = billMapper.queryByBillState(bean); //查询bill表中所有违约收费项目
		List<BillingRecord> brList=new ArrayList<BillingRecord>();
    	if(list.size()>0){
    		for(Bill bill : list){
    			DataDictionarySlave dataDictionarySlave = new DataDictionarySlave();
    			dataDictionarySlave.setProjectId(bill.getProjectId());
    			//根据项目id关联查询项目违约系数
    			DataDictionarySlave dataDictionarySlaves = dataDictionarySlaveMapper.queryByPro(dataDictionarySlave);
    			double num = 0.0;
    			double overdue = 0.0;
    			if(dataDictionarySlaves != null && Tools.notEmpty(dataDictionarySlaves.getDescription())){
    				//获取定义的违约系数
    				num = Double.parseDouble(dataDictionarySlaves.getDescription());
    				overdue=(bill.getLastOweSum()+bill.getOverdue()) * num + bill.getOverdue();
    				bill.setNoCollectSum(bill.getNoCollectSum()+(bill.getLastOweSum()+bill.getOverdue()) * num);
    				//保存计费记录
    				if((bill.getLastOweSum()+bill.getOverdue()) * num > 0){
	    				BillingRecord record =new BillingRecord();
	    				record.setBillingRecordId(UUID.randomUUID().toString());
	    				record.setChargeTypeDetailsId(bill.getChargeTypeId());
	    				BigDecimal bd = new BigDecimal((bill.getLastOweSum()+bill.getOverdue()) * num);
	    				record.setAmount(bd);
	    				record.setProjectId(bill.getProjectId());
	    				record.setBuildingId(bill.getBuildingId());
	    				record.setBillingTime(sdf.format(new Date()));
	    				record.setCreateTime(sdf.format(new Date()));
    					brList.add(record);
    				}
    			}else{
    				overdue=bill.getOverdue();
    			}
    			bill.setOverdue(overdue);
    			billMapper.updateBill(bill);
    		}
    		
    		if(brList.size()>0){
    			billingRecordMapper.insertList(brList);
    		}
    	}
	}

	// 手动计费
	public void personCharge(List<ChargeItemNew> list, String projectBillingId) {

	}

	// 重新计费
	public void resetCharge(List<String> projectBillingIds) {

	}

	// 初始化调度任务
	public void initSchedulerTask() throws SchedulerException, ParseException {
		
	}

}
