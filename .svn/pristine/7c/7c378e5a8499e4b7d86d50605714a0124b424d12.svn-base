package com.flf.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.transaction.annotation.Transactional;

import com.flf.entity.ChargeTypeDetailsBuildingBilling;

/**
 * 收费类型详情建筑计费service
 * @author maogaofei
 * @date 2016年7月9日 下午2:45:41
 */
@WebService
@Path("/ChargeTypeDetailsBuildingBilling")
public interface ChargeTypeDetailsBuildingBillingService {
	/**
	 * 根据条件查询收费项目详情建筑计费列表
	 * @author maogaofei
	 * @date 2016年7月11日 上午11:05:19
	 * @param chargeTypeDetailsBuildingBilling
	 * @return
	 */
	@POST
	@Path("/listAllChargeTypeDetailsBuildingBilling")
	@PathParam(MediaType.APPLICATION_JSON)
	public List<ChargeTypeDetailsBuildingBilling> listAllChargeTypeDetailsBuildingBilling(ChargeTypeDetailsBuildingBilling chargeTypeDetailsBuildingBilling);
	/**
	 * 根据选择的计费方案手动计费
	 * @author maogaofei
	 * @date 2016年7月11日 下午3:48:08
	 * @param schemeIds
	 */
	@GET
	@Path("/manualBilling/{projectId}/{schemeIds}")
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public void manualBilling(@PathParam("projectId") String projectId,@PathParam("schemeIds") String schemeIds);
	/**
	 * 根据选中的项目计费记录重新计费
	 * @author maogaofei
	 * @date 2016年7月12日 上午9:32:13
	 * @param projectBillingIds
	 */
	@GET
	@Path("/reBilling/{projectBillingIds}")
	@Produces(MediaType.APPLICATION_JSON)
	public void reBilling(@PathParam("projectBillingIds") String projectBillingIds);
	/**
	 * 根据选中的收费类型项目计费记录重新计费
	 * @author maogaofei
	 * @date 2016年7月14日 上午11:14:08
	 * @param chargeTypeProjectBillingIds
	 */
	@GET
	@Path("/reChargeTypeProjectBilling/{chargeTypeProjectBillingIds}")
	@Produces(MediaType.APPLICATION_JSON)
	public void reChargeTypeProjectBilling(@PathParam("chargeTypeProjectBillingIds") String chargeTypeProjectBillingIds);
	/**
	 * 根据选中的收费类型建筑计费记录重新计费
	 * @author maogaofei
	 * @date 2016年7月14日 下午2:41:00
	 * @param chargeTypeBuildingBillingIds
	 */
	@GET
	@Path("/reChargeTypeBuildingBilling/{chargeTypeBuildingBillingIds}")
	@Produces(MediaType.APPLICATION_JSON)
	public void reChargeTypeBuildingBilling(@PathParam("chargeTypeBuildingBillingIds") String chargeTypeBuildingBillingIds);
	/**
	 * 根据选中的项目计费记录确认计费
	 * @author maogaofei
	 * @date 2016年7月14日 下午3:46:55
	 * @param projectBillingIds
	 */
	@GET
	@Path("/confirmProjectBilling/{confirmProjectBillingIds}")
	@Produces(MediaType.APPLICATION_JSON)
	public void confirmProjectBilling(@PathParam("confirmProjectBillingIds") String confirmProjectBillingIds);
	/**
	 * 根据选中的收费类型项目计费记录确认计费
	 * @author maogaofei
	 * @date 2016年7月14日 下午4:12:47
	 * @param chargeTypeProjectBillingIds
	 */
	@GET
	@Path("/confirmChargeTypeProjectBilling/{confirmChargeTypeProjectBillingIds}")
	@Produces(MediaType.APPLICATION_JSON)
	public void confirmChargeTypeProjectBilling(@PathParam("confirmChargeTypeProjectBillingIds") String confirmChargeTypeProjectBillingIds);
	/**
	 * 根据选中的收费类型建筑计费记录确认计费
	 * @author maogaofei
	 * @date 2016年7月14日 下午4:20:06
	 * @param confirmChargeTypeBuildingBillingIdss
	 */
	@GET
	@Path("/confirmChargeTypeBuildingBilling/{confirmChargeTypeBuildingBillingIds}")
	@Produces(MediaType.APPLICATION_JSON)
	public void confirmChargeTypeBuildingBilling(@PathParam("confirmChargeTypeBuildingBillingIds") String confirmChargeTypeBuildingBillingIds);
}
