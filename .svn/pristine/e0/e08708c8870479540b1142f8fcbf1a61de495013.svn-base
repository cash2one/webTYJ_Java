package com.flf.service;

import javax.jws.WebService;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.ChargeTypeBuildingBilling;
import com.flf.entity.PageRestful;

/**
 * 收费类型建筑计费service
 * @author maogaofei
 * @date 2016年7月9日 下午2:45:41
 */
@WebService
@Path("/ChargeTypeBuildingBilling")
public interface ChargeTypeBuildingBillingService {
	/**
	 * 根据条件查询收费项目建筑计费列表
	 * @author maogaofei
	 * @date 2016年7月9日 下午4:08:41
	 * @param chargeTypeBuildingBilling
	 * @return
	 */
	@POST
	@Path("/listPageChargeTypeBuildingBilling")
	@Produces(MediaType.APPLICATION_JSON)
	PageRestful listPageChargeTypeBuildingBilling(ChargeTypeBuildingBilling chargeTypeBuildingBilling);
}
