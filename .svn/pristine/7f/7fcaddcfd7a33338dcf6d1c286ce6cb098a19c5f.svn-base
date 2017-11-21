package com.flf.service;

import java.io.InputStream;
import java.util.Date;
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

import com.flf.entity.Annex;
import com.flf.entity.CorrectedReading;
import com.flf.entity.MeterReadingData;
import com.flf.entity.PageRestful;
import com.flf.entity.SearchMeter;
import com.flf.request.Info;
/* Created by Administrator on 2015/6/15. 
author:尹磊
修改时间：2015/6/15  修改人：尹磊 */
@WebService
@Path("/MeterReadingData")
public interface MeterReadingDataService {
	
	/**
	 * 分页查询抄表数据信息
	 * @return
	 */
	@POST
	@Path("/listPageMeterReadingData")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	PageRestful listPageMeterReadingData(MeterReadingData meterReadingData);
	
	/**
	 * 异常数据处理多条件查询功能
	 * @return
	 */
	@POST
	@Path("/listMeterReadingDate")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	PageRestful listPageMeterReadingDate(SearchMeter searchMeter);
	
	/**
	 * 查询水表数据报表
	 * @return
	 */
	@GET
	@Path("/listMeterReadingDatebyDate/{meterReadingDate}")
	@Produces(MediaType.APPLICATION_JSON)
	List<MeterReadingData> listMeterReadingDatebyDate(@PathParam("meterReadingDate") Date meterReadingDate);
	

	/**
	 * 查询所有抄表数据信息
	 * @return
	 */
	@GET
	@Path("/listAllMeterReadingData")
	@Produces(MediaType.APPLICATION_JSON)
	List<MeterReadingData> listAllMeterReadingData();
	
	/**
	 * excel导入
	 * @return
	 */
	@POST
	@Path("/getExcel")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void getExcel(String filePath);

	
	/**
	 * 根据id查询所有抄表数据信息
	 * @return
	 */
	@GET
	@Path("/getMeterReadingDatabyId/{meterReadingDataId}")
	@Produces(MediaType.APPLICATION_JSON)
	MeterReadingData getUserByIdRest(@PathParam("meterReadingDataId") String meterReadingDataId);
	
	/**
	 * 根据计划名称查询所有抄表数据信息
	 * @return
	 */
	@GET
	@Path("/listMeterReadingDatebyName/{projectName}")
	@Produces(MediaType.APPLICATION_JSON)
	List<MeterReadingData> listMeterReadingDatebyName(@PathParam("projectName") String projectName);
	

	/**
	 * 根据水表id查询所有抄表数据信息
	 * @return
	 */
	@GET
	@Path("/listMeterReadingDatabyId/{waterMeterRecordId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<MeterReadingData> listMeterReadingDatabyId(@PathParam("waterMeterRecordId") String waterMeterRecordId);

	
	/**
	 * 新增抄表数据信息
	 * @return
	 */
	@POST
	@Path("/insertMeterReadingData")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void insertMeterReadingDatarest(MeterReadingData meterReadingData);

	
	/**
	 * 修改抄表数据信息
	 * @return
	 */
	@PUT
	@Path("/updateMeterReadingData")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void updateMeterReadingDatarest(MeterReadingData meterReadingData);

	/**
	 * 修改抄表数据信息 驳回
	 * @return
	 */
	@POST
	@Path("/updateMeterReject")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void updateMeterReject(MeterReadingData searchMeters);

	/**
	 * 修改抄表数据信息 重抄任务
	 * @return
	 */

	@POST
	@Path("/updateVerification")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void updateVerification(MeterReadingData searchMeters);
	/*@POST
	@Path("/updateVerification")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void updateVerification(String meterReadingDataId);
	@POST
	@Path("/updateVerification")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	String updateVerification(MeterReadingData searchMeter2);
	@PUT
	@Path("/updateMeterReadingData")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void updateMeterReadingDatarest(MeterReadingData meterReadingData);

	
	/**
	 * 删除抄表数据信息
	 * @return
	 */
	@DELETE
	@Path("/deleteMeterReadingData/{meterReadingDataId}")
	void deleteMeterReadingDatarest(@PathParam("meterReadingDataId") String meterReadingDataId);


	/**
	 * 根据建筑结构id查询水表读数 
	 * @return
	 */
	@GET
	@Path("/getMeterReadings/{buildingStructureId}")
	@Produces(MediaType.APPLICATION_JSON)
	MeterReadingData getMeterReadings(@PathParam("buildingStructureId") String buildingStructureId);

	/**
	 * 数据报表分页显示
	 * @return
	 */
	@POST
	@Path("/listMeterReading")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	PageRestful listPageMeterReading(MeterReadingData meterReadingData);
	
	/**
	 * 抄表管理--水表数据报表
	 * 2015-12-25
	 * 陶勇超
	 * 水表数据报表分页显示
	 * @return
	 */
	@POST
	@Path("/listPageMeterReadingDates")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	PageRestful listPageMeterReadingDates(MeterReadingData meterReadingData);
	
     /**
	 * 抄表管理--水表列表
	 * 2015-12-29
	 * 陶勇超
	 * 水表数据修正
	 * @return
	 *//*
	@POST
	@Path("/insertCorrect")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void  insertCorrect(CorrectedReading correctedReading);*/
	
	
	/**
	 * 修改抄表数据信息 修正读数
	 * @return
	 */
	@PUT
	@Path("/updateMeter/{meterReadingDataId}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void updateMeter(@PathParam("meterReadingDataId") String meterReadingDataId);

	
	
	/**
	 * 修改抄表数据信息 核实 
	 * @return
	 */
	@POST
	@Path("/updateMeterChecked")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void updateMeterChecked(String meterReadingDataId);

	
	
	/**
	 * 修改抄表数据信息 添加重抄任务
	 * @return
	 */
	@POST
	@Path("/updateMeterRecoed")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void updateMeterRecoed(String meterReadingDataId);
	
	
	
	/**
	 * 获取新建水表工单时的信息
	 */
	@GET
	@Path("/getMeterReadingsByBuildingId/{addressId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<MeterReadingData> getMeterReadingsByBuildingId(@PathParam("addressId") String addressId);
	
	/**
	 * 抄表结果列表分页
	 * @param meterReadingData
	 * @return
	 */
	@POST
	@Path("/listPageMeterRecoedDateList")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	PageRestful listPageMeterRecoedDateList(MeterReadingData meterReadingData);
	
	/**
	 * 重抄任务模态框中列表分页
	 * @param meterReadingData
	 * @return
	 */
	@POST
	@Path("/listPageMeterRecoedDateList2")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	PageRestful listPageMeterRecoedDateList2(MeterReadingData meterReadingData);
	
	/**
	 * 设置水表抄表结果接口
	 * @param meterReadingData
	 * @return
	 */
	@POST
	@Path("/setMeterReadingData")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	String setMeterReadingData(MeterReadingData meterReadingData);
	
	/**
	 * 水表抄表结果批量导入
	 * @param annex
	 * @return
	 */
	@POST
	@Path("/importExcelFileMeterReadingData")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	Info importExcelFileMeterReadingData(Annex annex);
	
	/**
	 * 水表报表分页显示
	 * @return
	 */
	@POST
	@Path("/listPageWaterMeterRecordAll")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	PageRestful listPageWaterMeterRecordAll(MeterReadingData meterReadingData);
	
	/**
	 * 审核，设置循环修正量
	 * @param meterReadingData
	 * @return
	 */
	@POST
	@Path("/setLoopNum")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	String setLoopNum(MeterReadingData meterReadingData);
	
	
	/**
	 * 获取水表当月用量接口
	 * @param meterReadingData
	 * @return
	 */
	@POST
	@Path("/getWaterMeterUsage")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	Double getWaterMeterUsage(MeterReadingData meterReadingData);
	
	/**
	 * 导出水表数据报表 
	 * @return
	 */
	InputStream exportWaterDataReportExcel();
}



	