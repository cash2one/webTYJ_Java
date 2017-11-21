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

import com.flf.entity.PageRestful;
import com.flf.entity.Search;
import com.flf.entity.SearchMeter;
import com.flf.entity.ElectricityMeterRecords;
import com.flf.entity.WaterMeterRecords;
/* Created by Administrator on 2015/7/6. 
author:尹磊
修改时间：2015/7/6  修改人：尹磊 */
@WebService
@Path("/ElectricityMeterRecords")
public interface ElectricityMeterRecordsService {
	
	

	
	/**
	 * 多条件查询水表接口	
	 * @return
	 */
	@POST
	@Path("/listElectricityMeterRecords")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	PageRestful listElectricityMeterRecords(SearchMeter searchMeter);

	
	/**
	 * 根据建筑结构id查询电表使用记录
	 * @return
	 */
	@POST
	@Path("/listElectricityMeterRecordsbybuildigIds")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	List<ElectricityMeterRecords> listElectricityMeterRecordsbybuildigIds(List<String> ids);
	
	/**
	 * 查询所有水表使用记录信息
	 * @return
	 */
	@GET
	@Path("/listAllElectricityMeterRecords")
	@Produces(MediaType.APPLICATION_JSON)
	List<ElectricityMeterRecords> listAllElectricityMeterRecords();

	
	/**
	 * 根据id查询所有水表使用记录信息
	 * @return
	 */
	@GET
	@Path("/getElectricityMeterRecordsbyId/{electricityMeterRecordsId}")
	@Produces(MediaType.APPLICATION_JSON)
	ElectricityMeterRecords getUserByIdRest(@PathParam("electricityMeterRecordsId") String electricityMeterRecordsId);
	
	
	/**
	 * 根据水表id查询水表使用记录信息
	 * @return
	 */
	@GET
	@Path("/listElectricityMeterRecordsbyWaterId/{waterMeterNum}")
	@Produces(MediaType.APPLICATION_JSON)
	List<ElectricityMeterRecords> listElectricityMeterRecordsbyWaterId(@PathParam("waterMeterNum") String waterMeterNum);

	
	/**
	 * 新增电表使用记录信息
	 * @return
	 */
	@POST
	@Path("/insertElectricityMeterRecords")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void insertElectricityMeterRecordsrest(ElectricityMeterRecords electricityMeterRecords);

	
	/**
	 * 修改电表使用记录信息
	 * @return
	 */
	@PUT
	@Path("/updateElectricityMeterRecords")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void updateElectricityMeterRecordsrest(ElectricityMeterRecords electricityMeterRecords);
	
	/**
	 * 停用水表
	 * @return
	 */
	@PUT
	@Path("/updateElectricityMeterRecordsrestbyNum")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void updateElectricityMeterRecordsrestbyNum(ElectricityMeterRecords electricityMeterRecords);

	
	/**
	 * 删除水表使用记录信息
	 * @return
	 */
	@DELETE
	@Path("/deleteElectricityMeterRecords/{electricityMeterRecordsId}")
	void deleteElectricityMeterRecordsrest(@PathParam("electricityMeterRecordsId") String electricityMeterRecordsId);
	
	/**
	 * 根据建筑结构id查询电表使用记录
	 * @return
	 */
	@GET
	@Path("/electricityMeterRecordsbybuildigId/{buildingId}")
	@Produces(MediaType.APPLICATION_JSON)
	ElectricityMeterRecords electricityMeterRecordsbybuildigId(@PathParam("buildingId") String buildingId);
	
	/**
	 * 抄表管理--电表维护-电表列表--历史用表
	 * 根据建筑结构id查询停用电表使用记录
	 * @return
	 */
	@GET
	@Path("/listElectricityMeterRecordsbybuildigId/{buildingStructureId}")
	@Produces(MediaType.APPLICATION_JSON)
	 List<ElectricityMeterRecords> listElectricityMeterRecordsbybuildigId(@PathParam("buildingStructureId") String buildingStructureId);

	
	/**
	 * 抄表管理--电表维护-电表列表--换表记录
	 * 根据建筑结构id查询停用水表使用记录
	 * @return
	 */
	@GET
	@Path("/listElectricityMeterRecordsByIds/{buildingStructureId}")
	@Produces(MediaType.APPLICATION_JSON)
	 List<ElectricityMeterRecords> listElectricityMeterRecordsByIds(@PathParam("buildingStructureId") String buildingStructureId);

	
	/**
	 * 抄表管理--电表维护-电表列表--抄表历史
	 * 根据电表ID查询电表使用记录信息
	 * @return
	 */
	@GET
	@Path("/listElectricityMeterRecordsByElectricityMeterId/{electricityMeterId}/{year}")
	@Produces(MediaType.APPLICATION_JSON)
	 List<ElectricityMeterRecords> listElectricityMeterRecordsByElectricityMeterId(@PathParam("electricityMeterId") String electricityMeterId,@PathParam("year") Integer year);

	
	/**
	 * 电损分析列表第一级
	 * @return
	 */
	@POST
	@Path("/getElectricityDamage")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	PageRestful getElectricityDamage(ElectricityMeterRecords electricityMeterRecords);
	
	/**
	 * 电损分析列表第二级
	 * @return
	 */
	@POST
	@Path("/getElectricityDamageTwo")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	PageRestful getElectricityDamageTwo(ElectricityMeterRecords electricityMeterRecords);
	
	@GET
	@Path("/qweqwe")
	@Produces(MediaType.APPLICATION_JSON)
	void getElectricityDamage();
	
}
