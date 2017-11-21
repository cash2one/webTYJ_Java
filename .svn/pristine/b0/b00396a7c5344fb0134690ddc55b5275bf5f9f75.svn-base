package com.flf.service;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.ConstructionRecordCard;
/**
 * 施工备案证
 * @author taoyongchao
 *  2015-8-19
 */
@WebService
@Path("/ConstructionRecordCard")
public interface ConstructionRecordCardService {
	

	/**
	 * 通过Id查询施工备案证信息记录
	 * @param recordId
	 * @return
	 */
	@GET
	@Path("/getConstructionRecordCardbyId/{recordId}")
	@Produces(MediaType.APPLICATION_JSON)
	ConstructionRecordCard getConstructionRecordCardbyId(@PathParam("recordId") String recordId);
	
	/**
	 * 通过申请Id查询施工备案证信息记录
	 * @param recordId
	 * @return
	 */
	@GET
	@Path("/getConstructionRecordCardbyApplyId/{applyId}")
	@Produces(MediaType.APPLICATION_JSON)
	ConstructionRecordCard getConstructionRecordCardbyApplyId(@PathParam("applyId") String applyId);
	
	/**
	 * 添加施工备案证记录
	 * @param constructionRecordCard
	 */
	@POST
	@Path("/insertConstructionRecordCard")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void insertConstructionRecordCard(ConstructionRecordCard constructionRecordCard);
	
	/**
	 * 修改施工备案证信息记录
	 * @param constructionRecordCard
	 */
	@PUT
	@Path("/updateConstructionRecordCard")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void updateConstructionRecordCard(ConstructionRecordCard constructionRecordCard);
	
	/**
	 * 删除施工备案证信息记录
	 * @param recordId
	 */
	@DELETE
	@Path("/deleteConstructionRecordCard/{recordId}")
	public void deleteConstructionRecordCard(@PathParam("recordId") String recordId);

}
