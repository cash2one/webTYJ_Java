package com.flf.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.flf.entity.WaterMeterOrderRecords;

/**
 * @author zhuqi
 * @date 2016.07.20
 */
@Path(value="/WaterMeterOrderRecords")
public interface WaterMeterOrderRecordsService {
	
	/**
	 * 修改本次读数
	 * @return
	 */
	@POST
	@Path("/updataWaterMeterOrderRecordsById")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void upDataWaterMeterOrderRecordsById(WaterMeterOrderRecords waterMeterOrderRecords);

}
