package com.flf.service;

import java.io.InputStream;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.Annex;
import com.flf.entity.MeterReadingResults;
import com.flf.entity.PageRestful;
import com.flf.entity.SearchMeter;
import com.flf.request.Info;
@WebService
@Path("MeterReadingResults")
public interface MeterReadingResultsService {
	/**
	 * 抄表执行结果多条件查询接口
	 * @return
	 */
	@POST
	@Path("/listPageMeterReadingResults") 
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	PageRestful listPageMeterReadingResults(SearchMeter searchMerter);

	
	/**
	 * 新增抄表执行结果信息
	 * @return
	 */
	@POST
	@Path("/insertMeterReadingResults")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void insertMeterReadingResults(MeterReadingResults meterReadingResults);

	
	/**
	 * 修改抄表执行结果信息
	 * @return
	 */
	@PUT
	@Path("/updateMeterReadingResults")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void updateMeterReadingResults(MeterReadingResults meterReadingResults);

	
	/**
	 * 删除抄表执行结果信息
	 * @return
	 */
	@DELETE
	@Path("/deleteMeterReadingResults/{meterReadingResultsId}")
	void deleteMeterReadingResults(@PathParam("meterReadingResultsId") String meterReadingResultsId);

	 /**
     * 将需要进行EXCEL导入的数据先写入模板并导出到本地
     */
    InputStream exportMeterReadingResults();
    

	 /**
    * 将需要进行EXCEL导入的抄表结果数据先写入模板并导出到本地
    * 2015-12-22 陶勇超
 	* 水表管理抄表结果导入模版下载
    */
   InputStream exportMeterReading();
   
	/**
 	 * 导入抄表结果数据Excel数据文档
 	 * @param annex
 	 * @return
 	 * 2015-12-22 陶勇超
 	 * 水表管理抄表结果导入
 	 */
 	@POST
 	@Path("/importExcelFileWaterMeter")
 	@Produces(MediaType.APPLICATION_JSON)
 	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
 	Info importExcelFileWaterMeter(Annex annex);
}
