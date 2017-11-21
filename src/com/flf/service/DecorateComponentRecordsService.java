package com.flf.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.DecorateComponentRecords;

/**
 * 装修组件记录表
 * @author yangshengquan
 * 
 * 2016-8-3
 */
public interface DecorateComponentRecordsService {

	//查询所有装修组件记录表信息记录
	@GET
	@Path("/listDecorateComponentRecords")
	@Produces(MediaType.APPLICATION_JSON)
	List<DecorateComponentRecords> listAllDecorateComponentRecords();;
}
