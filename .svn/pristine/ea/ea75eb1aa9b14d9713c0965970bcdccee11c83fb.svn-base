package com.flf.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.AdvancePaymentsDetails;
import com.flf.entity.AssetAccount;
import com.flf.entity.DepositDeduct;
import com.flf.entity.PageRestful;
import com.flf.entity.Search;
@WebService
@Path("/AssetAccount")
public interface AssetAccountService {

	/*查询押金账户信息assetAccountType=1	（押金）*/
    /****获取后调用预支付明细表的汇总接口并设置相应字段*****/
	@GET
	@Path("/getAssetAccountByCustId/{custId}")
	@Produces(MediaType.APPLICATION_JSON)
    List<AssetAccount> getAssetAccountByCustId(@PathParam("custId")String custId);
	
	/*根据资产账户id查询押金明细*/
	@GET
	@Path("/getAdvancePaymentsDetailsByAssetAccountId/{AssetAccountId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<AdvancePaymentsDetails> getAdvancePaymentsDetailsByAssetAccountId(@PathParam("AssetAccountId")String assetAccountId);
	
	/**
	 * 根据客户id查询资产账户信息 
	 * @return
	 */
	@GET
	@Path("/seletctAssetAccountByCustId/{custId}/{buildingId}")
	@Produces(MediaType.APPLICATION_JSON)
	AssetAccount seletctAssetAccountByCustIdRest(@PathParam("custId") String custId,@PathParam("buildingId") String buildingId);
	
	/**
	 * 修改
	 * @param Authorization
	 */
	@PUT
	@Path("/Update")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void updateAssetAccount(AssetAccount assetAccount);
	
	/*根据押金明细id获取押金付款信息*/
	@GET
	@Path("/getDepositDeductsByAdvancePaymentId/{AdvancePaymentId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<DepositDeduct> getDepositDeductsByAdvancePaymentId(@PathParam("AdvancePaymentId") String advancePaymentId);

	@POST
	@Path("/listPageAssetAccount")
	@Produces(MediaType.APPLICATION_JSON)
	PageRestful listPageAssetAccount(Search search);
	
	/**
	 * 根据项目id获取管理项目数
	 * @param projectId
	 * @return
	 */
	@GET
	@Path("/countAccountNumByProjectId/{projectId}")
	@Produces(MediaType.APPLICATION_JSON)
	int countAccountNumByProjectId(@PathParam("projectId") String projectId);
	
	
	/**
	 * 充值
	 * @param Authorization
	 */
	@PUT
	@Path("/topUP")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void topUP(AssetAccount assetAccount);
}
