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

import com.flf.entity.BuildingStructureNew;
import com.flf.entity.ChargeItemNew;
/**
 * 计费方案下收费项目service
 * @author maogaofei
 * @date 2016年6月29日 下午3:37:15
 */
@WebService
@Path("/ChargeItemNew")
public interface ChargeItemNewService {
	
	/**
	 * 根据项目ID和计费方案ID查询可选建筑列表
	 * @author maogaofei
	 * @date 2016年6月30日 上午11:35:06
	 * @param projectId
	 * @param schemeId
	 * @return
	 */
	@GET
	@Path("/getBuildingListByProidAndSchemeid/{projectId}/{schemeId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<BuildingStructureNew> getBuildingListByProidAndSchemeid(@PathParam("projectId") String projectId,@PathParam("schemeId") String schemeId);
	
	/**
	 * 新增收费项目、收费项目建筑关系和收费项目详情列表
	 * @author maogaofei
	 * @date 2016年6月30日 下午2:48:48
	 * @param chargeItemNew
	 */
	@POST
	@Path("/insertChargeItemNew")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	void insertChargeItemNew(ChargeItemNew chargeItemNew);
	
	/**
	 * 根据条件查询收费项目列表
	 * @author maogaofei
	 * @date 2016年6月30日 下午3:40:01
	 * @param chargeItemNew
	 * @return
	 */
	@POST
	@Path("/listAllChargeItemNew")
	@PathParam(MediaType.APPLICATION_JSON)
	List<ChargeItemNew> listAllChargeItemNew(ChargeItemNew chargeItemNew);
	
	/**
	 * 根据收费项目ID查询关联建筑列表
	 * @author maogaofei
	 * @date 2016年7月4日 下午5:30:56
	 * @param chargeItemNewId
	 * @return
	 */
	@GET
	@Path("/getBuildingListByChargeItemNewId/{chargeItemNewId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<BuildingStructureNew> getBuildingListByChargeItemNewId(@PathParam("chargeItemNewId") String chargeItemNewId);

	/**
	 * 批量删除收费项目
	 * @author maogaofei
	 * @date 2016年7月4日 下午6:49:47
	 * @param chargeItemNewId
	 */
	@GET
	@Path("/deleteChargeItemNew/{chargeItemNewId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteChargeItemNew(@PathParam("chargeItemNewId") String chargeItemNewId);
	/**
	 * 确认收费项目下收费详情列表是否都已经建立了计费公式
	 * @author maogaofei
	 * @date 2016年7月5日 下午1:56:20
	 * @param chargeItemNewId
	 * @return
	 */
	@GET
	@Path("/confirmList/{chargeItemNewId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String confirmList(@PathParam("chargeItemNewId") String chargeItemNewId);
}
