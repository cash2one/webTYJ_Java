package com.flf.service;

import javax.jws.WebService;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.ChargeTypeProjectBilling;
import com.flf.entity.PageRestful;

/**
 * 收费类型项目计费service
 * @author maogaofei
 * @date 2016年7月9日 下午2:45:41
 */
@WebService
@Path("/ChargeTypeProjectBilling")
public interface ChargeTypeProjectBillingService {
	/**
	 * 根据条件查询项目计费列表
	 * @author maogaofei
	 * @date 2016年7月9日 下午4:08:41
	 * @param financialGroupTotal
	 * @return
	 */
	@POST
	@Path("/listPageChargeTypeProjectBilling")
	@Produces(MediaType.APPLICATION_JSON)
	PageRestful listPageChargeTypeProjectBilling(ChargeTypeProjectBilling chargeTypeProjectBilling);
}
