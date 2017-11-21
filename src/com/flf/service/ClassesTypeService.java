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

import com.flf.entity.ClassesType;

@WebService
@Path("ClassesType")
public interface ClassesTypeService {
	
	/**
	 * 查询所有班次类型信息
	 * @return
	 */
	@GET
	@Path("/listPageuser")
	@Produces(MediaType.APPLICATION_JSON)
	List<ClassesType> listPageuser();
	
	/**
	 * 根据id查询班次类型信息
	 * @param appuserId
	 * @return
	 */
	@GET
	@Path("/getClassesTypeByIdRest/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	ClassesType getClassesTypeByIdRest(@PathParam("id") String id);
	
	/**
	 * 添加班次类型信息
	 * @param appUser
	 * @return
	 */
	@POST
	@Path("/AddClassesType")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void AddClassesType(ClassesType classesType);
	
	
	/**
	 *修改班次类型信息
	 * @param appUser
	 * @return
	 */
	@PUT
	@Path("/UpdateClassesType")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void UpdateClassesType(ClassesType classesType);
	
	/**
	 * 根据id删除班次类型信息
	 * @param appUserId
	 * @return
	 */
	@DELETE
	@Path("/DeleteUpdateClassesTypeById/{id}")
	void DeleteClassesTypeById(@PathParam("id") String id);

}
