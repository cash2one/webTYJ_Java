package com.flf.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.Account;
import com.flf.entity.AdvancePaymentsDetails;

@WebService
@Path("/Account")
public interface AccountService {

	/**
	 * 根据用户Id查询账户信息，包含资产账户信息
	 */
	@GET
	@Path("/getAccountByCustId/{custId}")
	@Produces(MediaType.APPLICATION_JSON)
	Account getAccountByCustId(@PathParam("custId") String custId);
	
	/*根据资产编号获取账单明细*/
	@GET
	@Path("/getAdvancePaymentDetailsCustId/{assetAccuontNum}")
	@Produces(MediaType.APPLICATION_JSON)
	List<AdvancePaymentsDetails> getAdvancePaymentDetailsCustId(@PathParam("assetAccuontNum") String assetAccuontNum);
	
}
