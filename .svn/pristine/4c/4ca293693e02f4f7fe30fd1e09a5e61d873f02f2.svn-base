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

import com.flf.entity.ScoreCriteria;

@WebService
@Path("/ScoreCriteria")
public interface ScoreCriteriaService {

	/**
	 * 添加评分标准
	 * @param scoreCriteria
	 */
	@POST
	@Path("/insertScoreCriteria")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void insertScoreCriteria(ScoreCriteria scoreCriteria);
	
	
	/**
	 * 修改评分标准
	 * @param scoreCriteria
	 */
	
	@PUT
	@Path("/updateScoreCriteria")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void updateScoreCriteria(ScoreCriteria scoreCriteria);
	
	/**
	 * 根据id查询评分标准
	 * @param criteriaId
	 * @return
	 */
	@GET
	@Path("/getScoreCriteriabyId/{criteriaId}")
	@Produces(MediaType.APPLICATION_JSON)
	ScoreCriteria getScoreCriteriabyId(@PathParam("criteriaId") String criteriaId);
	
	/**
	 * 根据类型查询评分标准
	 * @param criteriabyType
	 * @return
	 */
	@GET
	@Path("/getScoreCriteriabyType/{criteriabyType}")
	@Produces(MediaType.APPLICATION_JSON)
	List<ScoreCriteria> getScoreCriteriabyType(@PathParam("criteriabyType") String criteriabyType);
	
	/**
	 * 根据id查询评分标准详细信息
	 * @param criteriaId
	 * @return
	 */
	@GET
	@Path("/getScoreCriteriaDetailedbyId/{criteriaId}")
	@Produces(MediaType.APPLICATION_JSON)
	ScoreCriteria getScoreCriteriaDetailedbyId(@PathParam("criteriaId") String criteriaId);
	
}
