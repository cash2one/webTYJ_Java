package com.flf.service;

import javax.jws.WebService;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.ExecutionTimeRecords;
import com.flf.entity.PageRestful;

@WebService
@Path("/ExecutionTimeRecords")
public interface ExecutionTimeRecordsService {
	/**
	 * 装修巡检方案id查询执行次数 分页
	 * @param decorationInspectionPlans
	 * @return
	 */
	@POST
	@Path("/listPageDecorationsExecutionTime")
	@Produces(MediaType.APPLICATION_JSON)
	PageRestful listPageDecorationsExecutionTime(ExecutionTimeRecords executionTimeRecords);
	
	
		
}
