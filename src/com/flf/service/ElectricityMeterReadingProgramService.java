package com.flf.service;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.ElectricityMeterReadingProgram;
import com.flf.entity.MeterReadingProgram;
import com.flf.entity.PageRestful;
import com.flf.entity.SearchMeter;
/* Created by Administrator on 2015/7/6. 
author:尹磊
修改时间：2015/7/6  修改人：尹磊 */
@WebService
@Path("/ElectricityMeterReadingProgram")
public interface ElectricityMeterReadingProgramService {
	
	
	/**
	 * 查询所有抄表计划信息
	 * @return
	 */
	@GET
	@Path("/listAllElectricityMeterReadingProgram")
	@Produces(MediaType.APPLICATION_JSON)
	List<ElectricityMeterReadingProgram> listAllElectricityMeterReadingProgram();

	
	/**
	 * 根据id查询所有抄表计划信息
	 * @return
	 */
	@GET
	@Path("/getElectricityMeterReadingProgrambyId/{electricityMeterReadingProgramId}")
	@Produces(MediaType.APPLICATION_JSON)
	ElectricityMeterReadingProgram getUserByIdRest(@PathParam("electricityMeterReadingProgramId") String electricityMeterReadingProgramId);
	
	
	/**
	 * 根据年月查询所有抄表计划信息
	 * @return
	 */
	@GET
	@Path("/listElectricityMeterReadingProgrambyDate/{date}")
	@Produces(MediaType.APPLICATION_JSON)
	List<ElectricityMeterReadingProgram> listElectricityMeterReadingProgrambyDate(@PathParam("date") Date date);
	
	/**
	 * 根据执行人查询所有抄表计划信息
	 * @return
	 */
	@GET
	@Path("/listElectricityMeterReadingProgrambyStaff/{currentExecutor}")
	@Produces(MediaType.APPLICATION_JSON)
	List<ElectricityMeterReadingProgram> listElectricityMeterReadingProgrambyStaff(@PathParam("currentExecutor") String currentExecutor);
	
	
	/**
	 * 根据执行状态查询所有抄表计划信息
	 * @return
	 */
	@GET
	@Path("/listElectricityMeterReadingProgrambyState/{programExecutionStatus}")
	@Produces(MediaType.APPLICATION_JSON)
	List<ElectricityMeterReadingProgram> listElectricityMeterReadingProgrambyState(@PathParam("programExecutionStatus") byte programExecutionStatus);
	
	/**
	 * 根据执行团队查询所有抄表计划信息
	 * @return
	 */
	@GET
	@Path("/listElectricityMeterReadingProgrambyStaff/{executiveTeam}")
	@Produces(MediaType.APPLICATION_JSON)
	List<ElectricityMeterReadingProgram> listElectricityMeterReadingProgrambyTeam(@PathParam("executiveTeam") String executiveTeam);
	
	
	
	/**
	 * 根据抄表计划名称查询所有抄表计划信息
	 * @return
	 */
	@GET
	@Path("/listElectricityMeterReadingProgrambyName/{projectName}")
	@Produces(MediaType.APPLICATION_JSON)
	List<ElectricityMeterReadingProgram> listElectricityMeterReadingProgrambyName(@PathParam("projectName") String projectName);
	
	
	/**
	 * 抄表计划多条件查询接口
	 * @return
	 */
	@POST
	@Path("/listElectricityMeterReadingProgram") 
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	PageRestful listPageElectricityMeterReadingProgram(SearchMeter searchMeter);

	
	/**
	 * 新增抄表计划信息
	 * @return
	 */
	@POST
	@Path("/insertElectricityMeterReadingProgram")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void insertElectricityMeterReadingProgramrest(ElectricityMeterReadingProgram electricityMeterReadingProgram);

	
	/**
	 * 修改抄表计划信息
	 * @return
	 */
	@POST
	@Path("/updateElectricityMeterReadingProgram")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void updateElectricityMeterReadingProgramrest(ElectricityMeterReadingProgram electricityMeterReadingProgram);

	
	/**
	 * 删除抄表计划信息
	 * @return
	 */
	@DELETE
	@Path("/deleteElectricityMeterReadingProgram/{electricityMeterReadingProgramId}")
	void deleteElectricityMeterReadingProgramrest(@PathParam("electricityMeterReadingProgramId") String electricityMeterReadingProgramId);
	
	/**
	 * 电损导出
	 * @param request
	 * @return
	 */
	InputStream exportElectricityLossExcel(HttpServletRequest request);
	/**
	 * 执行抄表计划
	 * @param meterReadingProgramId
	 * @return
	 */
	@POST
	@Path("/implementProgram") 
	@Produces(MediaType.APPLICATION_JSON)
	String implementProgram(String meterReadingProgramId);
	
	/**
	 * 电表抄表计划的导出
	 * @param request
	 * @return
	 */
	InputStream exportElectricityMeterReadingDataFile(HttpServletRequest request);
	
	/**
	 * 获取电表抄表计划详情
	 * @param meterReadingProgramId 抄表计划id
	 * @return
	 */
	@GET
	@Path("/editData/{meterReadingProgramId}")
	@Produces(MediaType.APPLICATION_JSON)
	ElectricityMeterReadingProgram editData(@PathParam("meterReadingProgramId") String meterReadingProgramId);
	
	/**
	 * 抄表结果列表
	 * @param searchMerter
	 * @return
	 */
	@POST
	@Path("/listMeterReadingResult") 
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	PageRestful listPageMeterReadingResult(SearchMeter searchMerter);
	
	/**
	 * 修改抄表数据信息 外层核实:根据选中的id,查询对应的抄表计划
	 * @return
	 */
	@POST
	@Path("/selectMeterChecked")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	List<ElectricityMeterReadingProgram> selectMeterChecked(String meterReadingProgramId);
}
