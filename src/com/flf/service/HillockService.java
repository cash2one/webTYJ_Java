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

import com.flf.entity.Hillock;
@WebService
@Path("/Hillock")
public interface HillockService {
	int deleteHillock(Integer id);//删除岗位信息

    int insertHillock(Hillock hillock);//添加岗位信息

    List<Hillock> listPageHillock(Hillock hillock);//分页显示所有岗位信息
    
 

    int updateHillock(Hillock hillock);//修改催费信息

	
	String listHillockBydivision(int divisionId);  //根据部门id查询岗位集合
	
	List<Hillock> listHillockBydivisionId(int divisionId);  //根据部门id查询岗位集合


	String updateHillockJson(String hillock);

	String getHillockbyIdJson(Integer id);
	
	String deleteHillockJson(Integer id);

    String insertHillockJson(String hillock);
    
    @GET
	@Path("/listAllHillock")//查询所有
	@Produces(MediaType.APPLICATION_JSON)
    List<Hillock> listAllHillock();
    
    @GET
	@Path("/getHillockbyId/{id}")//根据id查询
	@Produces(MediaType.APPLICATION_JSON)
    Hillock getHillockbyId(@PathParam("appuserId") Integer id);
    
     
    @POST
   	@Path("/AddHillock")//添加岗位信息
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
   	void AddHillock(Hillock hillock);
   	
   	@PUT
   	@Path("/UpdateHillockById")//修改催费信息
   	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
   	void UpdateHillockById(Hillock hillock);
   	
   	@DELETE
   	@Path("/DeleteHillockById/{id}")//删除岗位信息
   	void DeleteHillockById(@PathParam("id") Integer id);
   	
}
