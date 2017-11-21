package com.flf.service;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.flf.entity.InspectionRecords;




/**
 * 巡检记录
 * @author yangshengquan
 *	2016-7-27
 */
@WebService
@Path("/InspectionRecordsService")
public interface InspectionRecordsService {
	/**
	 * 修改巡检结果
	 * @param inspectionRecords
	 */
	@POST
	@Path("/updateInspectionRecords")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void updateInspectionRecords(InspectionRecords inspectionRecords);
	
	
}
