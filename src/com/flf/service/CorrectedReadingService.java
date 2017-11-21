package com.flf.service;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.CorrectedReading;

@WebService
@Path("/CorrectedReading")
public interface CorrectedReadingService {

	@POST
	@Path("/insert")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void insert(CorrectedReading record);
	
	/**
	 * 抄表管理--水表列表
	 * 2015-12-29
	 * 陶勇超
	 * 水表数据修正
	 * @return
	 */
	@POST
	@Path("/addCorrectRead")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void  addCorrectRead(CorrectedReading correctedReading);
	
	/**
	 * 抄表管理--电表列表
	 * 电表数据修正
	 * @return
	 */
	@POST
	@Path("/addElectricityMeterCorrectRead")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void  addElectricityMeterCorrectRead(CorrectedReading correctedReading);
}
