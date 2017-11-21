package com.flf.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.flf.entity.BillingRecord;
import com.flf.entity.PageRestful;
import com.flf.mapper.BillingRecordMapper;
import com.flf.service.BillingRecordService;
import com.flf.util.Tools;

public class BillingRecordServiceImpl implements BillingRecordService {
	@Autowired
	private BillingRecordMapper billingRecordMapper;

	@Override
	public PageRestful listPageBillingRecord(BillingRecord billingRecord) {
		if(Tools.notEmpty(billingRecord.getBillingStartTime())){
			billingRecord.setBillingStartTime(billingRecord.getBillingStartTime() + " 00:00:00");
		}
		if(Tools.notEmpty(billingRecord.getBillingEndTime())){
			billingRecord.setBillingEndTime(billingRecord.getBillingEndTime() + " 23:59:59");
		}
		PageRestful pageRestful=new PageRestful();
		List<BillingRecord> billingRecords = billingRecordMapper.listPageBillingRecord(billingRecord);
		billingRecords.add(0,null);
		pageRestful.setBillingRecords(billingRecords);
		pageRestful.setPage(billingRecord.getPage());
		return pageRestful;
	}
	
}