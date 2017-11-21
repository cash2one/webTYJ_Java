package com.flf.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.AboutScheme;
import com.flf.entity.BuildingStructureNew;
import com.flf.entity.Formula;
import com.flf.entity.SchemeDatails;

/**
 * 方案公式收费项目关联表
 * @author wangzhou
 *
 */
@WebService
@Path("/SchemeDetails")
public interface SchemeDatailsService {

	/**
	 * 新增方案公式收费项目关联数据
	 * @param schemeDatails
	 */
	public void insertSchemeDetails(SchemeDatails schemeDatails);
	
	/**
	 * 根据传入的方案id和以及一级收费项目id查询方案公式收费项目关联数据
	 * @param schemeId chargeItemId
	 * @return list
	 */
	@GET
	@Path("/getSchemeDatailsByScheme/{schemeId}/{chargeItemId}")
	@Produces(MediaType.APPLICATION_JSON)
	public AboutScheme getSchemeDatailsListByScheme(@PathParam("schemeId")String schemeId, @PathParam("chargeItemId")String chargeItemId);
	
	/**
	 * 根据方案id查询所属的建筑结构id集合
	 * @param schemeId
	 * @return list
	 */
	@GET
	@Path("/getBuildingIdBySchemeId/{schemeId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getBuildingIdBySchemeId(@PathParam("schemeId")String schemeId);
	
	/**
	 * 根据收费项目id查询公式及条件
	 * @param chargeItemId
	 * @return
	 */
	@GET
	@Path("/getFormulaByChargeItemId/{chargeItemId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Formula> getFormulaByChargeItemId(@PathParam("chargeItemId") String chargeItemId);
	
	@GET
	@Path("/getBuildingBySchemeId/{schemeId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<BuildingStructureNew> getBuildingBySchemeId(@PathParam("schemeId") String schemeId);

	@GET
	@Path("/getBuildingBySchemeId/{schemeId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SchemeDatails> getSchemeDatailsBySchemeId(@PathParam("schemeId") String schemeId);

	@GET
	@Path("/getBuildingResBySchemeId/{schemeId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SchemeDatails> getSchemeDatailsResBySchemeId(@PathParam("schemeId") String schemeId);

	
}
