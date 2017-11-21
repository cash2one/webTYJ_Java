package com.flf.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.DataDictionarySlave;

@WebService
@Path("/DataDictionarySlaveService")
public interface DataDictionarySlaveService {

	/**
	 * 根据数据类型和项目id获取
	 * @param masterName
	 * @param projectId
	 * @return
	 */
	@GET
	@Path("/getDataDictionarySlave/{masterName}/{buildingId}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	List<DataDictionarySlave> getDataDictionarySlave(@PathParam("masterName") String masterName,@PathParam("buildingId") String buildingId);
	
	
	/**
	 * 根据数据类型和项目id获取属性
	 */
	@GET
	@Path("/getDataDictionarySlaveRes/{masterName}/{projectId}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	List<DataDictionarySlave> getDataDictionarySlaveRes(@PathParam("masterName") String masterName,@PathParam("projectId") String projectId);
	
	
}
