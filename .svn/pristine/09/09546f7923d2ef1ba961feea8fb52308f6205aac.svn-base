package com.flf.service;


import javax.jws.WebService;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.BillingRecord;
import com.flf.entity.PageRestful;


/**
 * 计费记录service
 * @author maogaofei
 * @date 2016年7月12日 下午4:43:33
 */
@WebService
@Path("/BillingRecord")
public interface BillingRecordService {
	
	/**
	 * 根据条件分页查询计费记录
	 * @author maogaofei
	 * @date 2016年7月13日 下午2:16:40
	 * @param billingRecord
	 * @return
	 */
	@POST
	@Path("/listPageBillingRecord")
	@Produces(MediaType.APPLICATION_JSON)
	PageRestful listPageBillingRecord(BillingRecord billingRecord);
	
}
