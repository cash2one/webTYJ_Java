package com.flf.service;

import java.util.List;

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

import com.flf.entity.AcceptanceInformationRecords;

@WebService
@Path("/AcceptanceInformationRecords")
public interface AcceptanceInformationRecordsService {
	/**
	 * 查询所有验收信息记录
	 * @return
	 */
	@GET
	@Path("/listAllAcceptanceInformationRecords")
	@Produces(MediaType.APPLICATION_JSON)
	List<AcceptanceInformationRecords> listAllAcceptanceInformationRecords();
	
	/**
	 * 通过Id查询验收信息记录
	 * @param orderId
	 * @return
	 */
	@GET
	@Path("/getAcceptanceInformationRecordsbyId/{recordId}")
	@Produces(MediaType.APPLICATION_JSON)
	AcceptanceInformationRecords getAcceptanceInformationRecordsbyId(@PathParam("recordId") String recordId);
	
	/**
	 * 添加处理验收记录
	 * @param disposeInformationRecords
	 */
	@POST
	@Path("/insertAcceptanceInformationRecords")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void insertAcceptanceInformationRecords(AcceptanceInformationRecords acceptanceInformationRecords);
	
	/**
	 * 修改验收信息记录
	 * @param disposeInformationRecords
	 */
	@PUT
	@Path("/updateAcceptanceInformationRecords")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void updateAcceptanceInformationRecords(AcceptanceInformationRecords acceptanceInformationRecords);
	
	/**
	 * 删除验收信息记录
	 * @param serverId
	 */
	@DELETE
	@Path("/deleteAcceptanceInformationRecords/{recordId}")
	public void deleteAcceptanceInformationRecords(@PathParam("recordId") String recordId);
}
