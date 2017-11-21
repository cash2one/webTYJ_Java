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

import com.flf.entity.Inform;
import com.flf.entity.PageRestful;
@WebService
@Path("/Inform")
//内部通知
public interface InformService {
	List<Inform> listPageInform(Inform inform);//查找所有的通知信息
	String getInformById(String id);//根据id查询通知信息
	String deleteInform(String id);//删除通知信息
	String insertInform(String inform);//增加通知信息
	String updateInform(String inform);//更新通知信息
	List<Inform> listAllInform();

	Inform getInforms(String id);

	int updateInforms(Inform inform);

	//int insertInforms(Inform inform);

	int deleteInforms(String id);
	
	@POST
	@Path("/listPageinform")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	PageRestful listPageinform(Inform inform);
	
	@GET
	@Path("/listAllinform")
	@Produces(MediaType.APPLICATION_JSON)
	List<Inform> listAllinform();
	
	@GET
	@Path("/listAllsinform")
	@Produces(MediaType.APPLICATION_JSON)
	List<Inform> listAllsinform();
	
	@GET
	@Path("/listAllsinformByUserId/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<Inform> listAllsinformByUserId(@PathParam("userId") String userId);
	
	@GET
	@Path("/getInformById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	Inform getInformByIdRest(@PathParam("id") String id);
	
	@POST
	@Path("/AllInform")
	@Consumes( MediaType.APPLICATION_JSON)
	public void AllInform(Inform inform);
	
	//插入内部公告
	@POST
	@Path("/insertInforms")
	@Consumes( MediaType.APPLICATION_JSON)
	public void insertInforms(Inform inform);
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/UpdateInform")
	public void UpdateInform(Inform inform);
	
	//@POST
	@DELETE
	@Path("/deleteInform/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void DeleteInform(@PathParam("id") String id);
}