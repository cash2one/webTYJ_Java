package com.flf.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import com.flf.entity.ChargeItemNewDetails;

/**
 * 收费项目详情service
 * @author maogaofei
 * @date 2016年6月29日 下午3:37:15
 */
@WebService
@Path("/ChargeItemNewDetails")
public interface ChargeItemNewDetailsService {
	/**
	 * 根据条件查询收费项目详情列表
	 * @author maogaofei
	 * @date 2016年6月30日 下午3:40:01
	 * @param chargeItemNew
	 * @return
	 */
	@POST
	@Path("/listAllChargeItemNewDetails")
	@PathParam(MediaType.APPLICATION_JSON)
	List<ChargeItemNewDetails> listAllChargeItemNewDetails(ChargeItemNewDetails chargeItemNewDetails);
}
