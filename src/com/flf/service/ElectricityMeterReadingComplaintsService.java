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

import com.flf.entity.ElectricityMeterReadingComplaints;
import com.flf.entity.PageRestful;
/* Created by Administrator on 2015/7/6. 
author:尹磊
修改时间：2015/7/6  修改人：尹磊 */
@WebService
@Path("/ElectricityMeterReadingComplaints")
public interface ElectricityMeterReadingComplaintsService {

	/**
	 * 查询所有抄表投诉信息
	 * @return
	 */
	@GET
	@Path("/listAllElectricityMeterReadingComplaints")
	@Produces(MediaType.APPLICATION_JSON)
	List<ElectricityMeterReadingComplaints> listAllElectricityMeterReadingComplaints();
	
	
	/**
	 * 分页查询水表投诉
	 * @return
	 */
	@POST
	@Path("/listPageElectricityMeterReadingComplaints")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	PageRestful listPageElectricityMeterReadingComplaints(ElectricityMeterReadingComplaints electricityMeterReadingComplaints);

	
	/**
	 * 根据id查询所有抄表投诉信息
	 * @return
	 */
	@GET
	@Path("/getElectricityMeterReadingComplaintsbyId/electricityMeterReadingComplaintsId}")
	@Produces(MediaType.APPLICATION_JSON)
	ElectricityMeterReadingComplaints getUserByIdRest(@PathParam("electricityMeterReadingComplaintsId") String electricityMeterReadingComplaintsId);

	
	/**
	 * 新增抄表投诉信息
	 * @return
	 */
	@POST
	@Path("/insertElectricityMeterReadingComplaints")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void insertElectricityMeterReadingComplaintsrest(ElectricityMeterReadingComplaints electricityMeterReadingComplaints);

	
	/**
	 * 修改抄表投诉信息
	 * @return
	 */
	@PUT
	@Path("/updateElectricityMeterReadingComplaints")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void updateElectricityMeterReadingComplaintsrest(ElectricityMeterReadingComplaints electricityMeterReadingComplaints);

	
	/**
	 * 删除抄表投诉信息
	 * @return
	 */
	@DELETE
	@Path("/deleteElectricityMeterReadingComplaints/{electricityMeterReadingComplaintsId}")
	void deleteElectricityMeterReadingComplaintsrest(@PathParam("electricityMeterReadingComplaintsId") String electricityMeterReadingComplaintsId);

}
