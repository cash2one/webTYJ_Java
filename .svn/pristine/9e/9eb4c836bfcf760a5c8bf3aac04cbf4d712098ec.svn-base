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

import com.flf.entity.DecoreateInspectionRecords;
/**
 * 装修巡检记录表
 * @author taoyongchao
 *  2015-8-18
 */
@WebService
@Path("/DecoreateInspectionRecords")
public interface DecoreateInspectionRecordsService {
	
	/**
	 * 通过Id查询装修巡检记录表信息记录
	 * @param recordId
	 * @return
	 */
	@GET
	@Path("/getDecoreateInspectionRecordsbyId/{recordId}")
	@Produces(MediaType.APPLICATION_JSON)
	DecoreateInspectionRecords getDecoreateInspectionRecordsbyId(@PathParam("recordId") String recordId);
	
	/**
	 * 添加装修巡检记录表记录
	 * @param decoratePersonnelAssociated
	 */
	@POST
	@Path("/insertDecoreateInspectionRecords")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void insertDecoreateInspectionRecords(DecoreateInspectionRecords DecoreateInspectionRecords);
	
	/**
	 * 修改装修巡检记录表信息记录
	 * @param decoratePersonnelAssociated
	 */
	@PUT
	@Path("/updateDecoreateInspectionRecords")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void updateDecoreateInspectionRecords(DecoreateInspectionRecords DecoreateInspectionRecords);
	
	/**
	 * 删除装修巡检记录表信息记录
	 * @param recordId
	 */
	@DELETE
	@Path("/deleteDecoreateInspectionRecords/{recordId}")
	public void deleteDecoreateInspectionRecords(@PathParam("recordId") String recordId);



}
