package com.flf.service;


import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.ChargeTypeDetails;

/**
 * 收费类型详情service
 * @author maogaofei
 * @date 2016年6月28日 下午1:52:39
 */
@WebService
@Path("/ChargeTypeDetails")
public interface ChargeTypeDetailsService {
	
	/**
	 * 根据条件查询收费类型详情列表
	 * @author maogaofei
	 * @date 2016年6月30日 下午6:36:04
	 * @param chargeTypeDetails
	 * @return
	 */
	@POST
	@Path("/listAllCharegeTypeDetails")
	@Produces(MediaType.APPLICATION_JSON)
	List<ChargeTypeDetails> listAllCharegeTypeDetails(ChargeTypeDetails chargeTypeDetails);
	
	//根据ID查其他信息
	@GET
	@Path("/getChargeTypeDetailsById/{chargeTypeId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ChargeTypeDetails> getChargeTypeDetailsById(@PathParam("chargeTypeId") String chargeTypeId);
	
	@POST
	@Path("/getCode")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	String getCode();
	
	
}
