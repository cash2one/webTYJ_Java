package com.flf.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.ChargeItemNew;
import com.flf.entity.SchemeRelation;
import com.flf.request.Info;

@WebService
@Path("/SchemeRelation")
public interface SchemeRelationService {

	/**
	 * 新增方案收费项目关系表数据
	 * @param schemeRelation
	 */
	public void insertSchemeRelation(SchemeRelation schemeRelation);
	
	/**
	 * 根据方案id查询方案与一级收费项目关联数据，以及对应收费项目数据
	 * @param SchemeId
	 * @return
	 */
	@GET
	@Path("/getSchemeRelationBySchemeId/{schemeId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SchemeRelation> getSchemeRelationBySchemeId(@PathParam("schemeId") String schemeId);

	/**
	 * 根据方案id查询方案
	 */
	@GET
	@Path("/getSchemeRelationResBySchemeId/{schemeId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SchemeRelation> getSchemeRelationResBySchemeId(@PathParam("schemeId") String schemeId);
	
	/**
	 * 根据收费项目id和方案id删除关系表数据
	 */
	@GET
	@Path("/deleteSchemeRelationBySchemeId/{ids}/{schemeId}")
	@Produces(MediaType.APPLICATION_JSON)
	Info deleteSchemeRelationBySchemeId(@PathParam("ids") String ids,@PathParam("schemeId") String schemeId);
	
}
