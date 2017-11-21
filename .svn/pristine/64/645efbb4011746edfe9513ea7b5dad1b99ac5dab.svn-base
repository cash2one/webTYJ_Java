package com.flf.service;

import java.util.List;
import java.util.Map;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.AreaTypeNew;
import com.flf.entity.Bill;
import com.flf.entity.ElectronicBilling;
import com.flf.entity.PageRestful;

@WebService
@Path("/ElectronicBilling")
public interface ElectronicBillingService {

	/*根据客户id获取资产建筑下的电子账单*/
	@GET
	@Path("/getElectronicBillingsByCustId/{custId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<ElectronicBilling> getElectronicBillingsByCustId(@PathParam("custId") String custId);
	/*条件查询*/
	@POST
	@Path("/QueryResultElectronicBillings")
	@Produces(MediaType.APPLICATION_JSON)
	List<ElectronicBilling> QueryResultElectronicBillings(ElectronicBilling electronicBilling);//条件查询（账单时间，账单编号，收费对象，必须包含客户id）
	/*查询本月明细*/
	@GET
	@Path("/getBillsThisMonth/{electronicBillingId}/{currentDate}")
	@Produces(MediaType.APPLICATION_JSON)
	List<Bill> getBillsThisMonth(@PathParam("electronicBillingId")String electronicBillingId,@PathParam("currentDate")String currentDate);
	/*查询历史明细*/
	@GET
	@Path("/getBillsLastMonth/{electronicBillingId}/{currentDate}")
	@Produces(MediaType.APPLICATION_JSON)
	List<Bill> getBillsLastMonth(@PathParam("electronicBillingId")String electronicBillingId,@PathParam("currentDate")String currentDate);
	
	/***
	 * 新增
	 */
	@POST
	@Path("/insertElectronicBilling")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void insertElectronicBillingRes(ElectronicBilling electronicBilling);
	
	
	/*
	 * 分页查询
	 */
    @POST
 	@Path("/listPageElectronicBilling")
  	@Produces(MediaType.APPLICATION_JSON)
    PageRestful listPageElectronicBilling(ElectronicBilling electronicBilling);

	
}
