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
import com.flf.entity.ElectricityMeterReadingData;
import com.flf.entity.MeterReadingData;
import com.flf.entity.PageRestful;
import com.flf.entity.Search;
import com.flf.entity.SearchMeter;
import com.flf.request.Info;
/* Created by Administrator on 2015/7/6. 
author:尹磊
修改时间：2015/7/6  修改人：尹磊 */
@WebService
@Path("/ElectricityMeterReadingData")
public interface ElectricityMeterReadingDataService {
	
	/**
	 * 分页查询抄表数据信息
	 * @return
	 */
	@POST
	@Path("/listPageElectricityMeterReadingData")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	PageRestful listPageElectricityMeterReadingData(ElectricityMeterReadingData electricityMeterReadingData);
	/**
	 * 异常数据处理多条件查询功能
	 * @return
	 */
	@POST
	@Path("/listElectricityMeterReadingDate")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	PageRestful listPageElectricityMeterReadingDate(SearchMeter searchMeter);
	
	/**
	 * 查询水表数据报表
	 * @return
	 */
	@GET
	@Path("/listElectricityMeterReadingDatebyDate/{meterReadingDate}")
	@Produces(MediaType.APPLICATION_JSON)
	List<ElectricityMeterReadingData> listElectricityMeterReadingDatebyDate(@PathParam("meterReadingDate") Date meterReadingDate);
	

	/**
	 * 查询所有抄表数据信息
	 * @return
	 */
	@GET
	@Path("/listAllElectricityMeterReadingData")
	@Produces(MediaType.APPLICATION_JSON)
	List<ElectricityMeterReadingData> listAllElectricityMeterReadingData();

	
	/**
	 * 根据id查询所有抄表数据信息
	 * @return
	 */
	@GET
	@Path("/getElectricityMeterReadingDatabyId/{electricityMeterReadingDataId}")
	@Produces(MediaType.APPLICATION_JSON)
	ElectricityMeterReadingData getUserByIdRest(@PathParam("electricityMeterReadingDataId") String electricityMeterReadingDataId);
	
	/**
	 * 根据计划名称查询所有抄表数据信息
	 * @return
	 */
	@GET
	@Path("/listElectricityMeterReadingDatebyName/{projectName}")
	@Produces(MediaType.APPLICATION_JSON)
	List<ElectricityMeterReadingData> listElectricityMeterReadingDatebyName(@PathParam("projectName") String projectName);
	

	/**
	 * 根据水表id查询所有抄表数据信息
	 * @return
	 */
	@GET
	@Path("/listElectricityMeterReadingDatabyId/{electricityMeterRecordId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<ElectricityMeterReadingData> listElectricityMeterReadingDatabyId(@PathParam("electricityMeterRecordId") String electricityMeterRecordId);
	
	/**
	 * 根据建筑id查询所有抄表数据信息
	 * @return
	 */
	@GET
	@Path("/listElectricityMeterReadingDatabyBuildingId/{addressId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<ElectricityMeterReadingData> listElectricityMeterReadingDatabyBuildingId(@PathParam("addressId") String addressId);

	
	/**
	 * 新增抄表数据信息
	 * @return
	 */
	@POST
	@Path("/insertElectricityMeterReadingData")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void insertElectricityMeterReadingDatarest(ElectricityMeterReadingData electricityMeterReadingData);

	
	/**
	 * 修改抄表数据信息
	 * @return
	 */
	@PUT
	@Path("/updateElectricityMeterReadingData")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void updateElectricityMeterReadingDatarest(ElectricityMeterReadingData electricityMeterReadingData);

	
	/**
	 * 删除抄表数据信息
	 * @return
	 */
	@DELETE
	@Path("/deleteElectricityMeterReadingData/{electricityMeterReadingDataId}")
	void deleteElectricityMeterReadingDatarest(@PathParam("electricityMeterReadingDataId") String electricityMeterReadingDataId);

	/**
	 * 获取电表当月用量接口
	 * @param meterReadingData
	 * @return
	 */
	/*@POST
	@Path("/getElectricityMeterUsage")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	Double getElectricityMeterUsage(ElectricityMeterReadingData electricityMeterReadingData);*/

	
	/**
	 * 电表报表分页显示
	 * @return
	 */
	@POST
	@Path("/listPageElectricityMeterRecordAll")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	PageRestful listPageElectricityMeterRecordAll(ElectricityMeterReadingData electricityMeterReadingData);
	
	/**
	 * 导出电表数据报表 
	 * @return
	 */
	InputStream exportElectricityDataReportExcel();
	/**
	 * 抄表结果列表分页
	 * @param meterReadingData
	 * @return
	 */
	@POST
	@Path("/listPageMeterRecoedDateList")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	PageRestful listPageMeterRecoedDateList(ElectricityMeterReadingData electricityMeterReadingData);
	
	/**
	 * 设置修改电表读数接口
	 * @param meterReadingData
	 * @return
	 */
	@POST
	@Path("/setMeterReadingData")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	String setMeterReadingData(ElectricityMeterReadingData electricityMeterReadingData);
	
	/**
	 * 电表抄表结果批量导入
	 * @param annex
	 * @return
	 */
	@POST
	@Path("/importExcelFileMeterReadingData")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	Info importExcelFileMeterReadingData(Annex annex);
	
	/**
	 * 修改抄表数据信息 里层核实 
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
	 * 审核，设置循环修正量
	 * @param electricityMeterReadingData
	 * @return
	 */
	@POST
	@Path("/setLoopNum")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	String setLoopNum(ElectricityMeterReadingData electricityMeterReadingData);
	
	/**
	 * 重抄任务模态框中列表分页
	 * @param meterReadingData
	 * @return
	 */
	@POST
	@Path("/listPageMeterRecoedDateList2")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	PageRestful listPageMeterRecoedDateList2(ElectricityMeterReadingData electricityMeterReadingData);
	
	/**
	 * 修改电表抄表数据信息 驳回
	 * @return
	 */
	@POST
	@Path("/updateMeterReject")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void updateMeterReject(ElectricityMeterReadingData searchMeters);
	
	/**
	 * 修改抄表数据信息 重抄任务
	 * @return
	 */

	@POST
	@Path("/updateVerification")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void updateVerification(ElectricityMeterReadingData searchMeters);
}
