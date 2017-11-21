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

import com.flf.entity.ApplicationDelayRecords;
import com.flf.entity.PageRestful;
@WebService
@Path("/ApplicationDelayRecords")
public interface ApplicationDelayRecordsService {

	List<ApplicationDelayRecords> listAllApplicationDelayRecords();//获取所有延时对象
	ApplicationDelayRecords getApplicationDelayRecordsById(String recordId);//根据记录Id获取延时对象
	int insertApplicationDelayRecords(ApplicationDelayRecords applicationDelayRecords);//添加延时对象
	int deleteApplicationDelayRecordsById(String recordId);//根据记录Id删除延时对象
	int updateApplicationDelayRecords(ApplicationDelayRecords applicationDelayRecords);//更新延时对象
	
	/* 前台关联方法  */
	/*根据记录Id获取延时对象*/
	@GET
	@Path("/getApplicationDelayRecordsById/{recordId}")
	@Produces(MediaType.APPLICATION_JSON)
	ApplicationDelayRecords FindApplicationDelayRecordsById(@PathParam("recordId") String recordId);
	
	/*添加延时对象*/
	@POST
	@Path("/insertApplicationDelayRecords")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	int addApplicationDelayRecords(ApplicationDelayRecords applicationDelayRecords);
	
	/*根据记录Id删除延时对象*/
	@DELETE
	@Path("/deleteApplicationDelayRecordsById/{recordId}")
	@Produces(MediaType.APPLICATION_JSON)
	int deleteApplicationDelayRecords(@PathParam("recordId") String recordId);
	
	/*更新延时对象*/
	@PUT
	@Path("/updateApplicationDelayRecords")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	int updateApplicationDelayRecordsInfo(ApplicationDelayRecords applicationDelayRecords);
	
	/**
	 * 获取延时任务个数
	 * @param taskId
	 * @return
	 */
	@GET
	@Path("/getApplicationDelayRecordsCount/{taskId}")
	@Produces(MediaType.APPLICATION_JSON)
	int getApplicationDelayRecordsCount(@PathParam("taskId")String taskId);
	
	/**
	 * 通过任务id获取延时记录信息
	 * @param taskId
	 * @return
	 */
	@GET
	@Path("/getApplicationDelayRecordsbyTaskId/{taskId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<ApplicationDelayRecords> getApplicationDelayRecordsbyTaskId(@PathParam("taskId")String taskId);
	
	/**
	 * 分页查询
	 * @param applicationDelayRecords
	 * @return
	 */
	@POST
	@Path("/listPageApplicationDelayRecordsRestful")
	@Produces(MediaType.APPLICATION_JSON)
	PageRestful listPageApplicationDelayRecordsRestful(ApplicationDelayRecords applicationDelayRecords);
}
