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
import com.flf.entity.BankDeposit;

@WebService
@Path("/BankDeposit")
public interface BankDepositService {
	/**
	 *根据交账记录id查询银行存单表
	 * @param accountRecordId
	 * @return
	 */
	@GET
	@Path("/getBankDepositById/{accountRecordId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<BankDeposit> getBankDepositByIdRest(@PathParam("accountRecordId") String accountRecordId);
	
	/*
	 * 新增
	 */
	@POST
	@Path("/insertBankDeposit")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void insertBankDeposit(BankDeposit bankDeposit);
}
