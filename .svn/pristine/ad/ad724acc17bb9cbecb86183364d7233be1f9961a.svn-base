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

import com.flf.entity.MeterReadingComplaints;
import com.flf.entity.PageRestful;
/* Created by Administrator on 2015/6/15. 
author:尹磊
修改时间：2015/6/15  修改人：尹磊 */
@WebService
@Path("/MeterReadingComplaints")
public interface MeterReadingComplaintsService {

	/**
	 * 查询所有抄表投诉信息
	 * @return
	 */
	@GET
	@Path("/listAllMeterReadingComplaints")
	@Produces(MediaType.APPLICATION_JSON)
	List<MeterReadingComplaints> listAllMeterReadingComplaints();
	
	
	/**
	 * 分页查询水表投诉
	 * @return
	 */
	@POST
	@Path("/listPageMeterReadingComplaints")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	PageRestful listPageMeterReadingComplaints(MeterReadingComplaints meterReadingComplaints);

	
	/**
	 * 根据id查询所有抄表投诉信息
	 * @return
	 */
	@GET
	@Path("/getMeterReadingComplaintsbyId/{meterReadingComplaintsId}")
	@Produces(MediaType.APPLICATION_JSON)
	MeterReadingComplaints getUserByIdRest(@PathParam("meterReadingComplaintsId") String meterReadingComplaintsId);

	
	/**
	 * 新增抄表投诉信息
	 * @return
	 */
	@POST
	@Path("/insertMeterReadingComplaints")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void insertMeterReadingComplaintsrest(MeterReadingComplaints meterReadingComplaints);

	
	/**
	 * 修改抄表投诉信息
	 * @return
	 */
	@PUT
	@Path("/updateMeterReadingComplaints")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void updateMeterReadingComplaintsrest(MeterReadingComplaints meterReadingComplaints);

	
	/**
	 * 删除抄表投诉信息
	 * @return
	 */
	@DELETE
	@Path("/deleteMeterReadingComplaints/{meterReadingComplaintsId}")
	void deleteMeterReadingComplaintsrest(@PathParam("meterReadingComplaintsId") String meterReadingComplaintsId);

}
