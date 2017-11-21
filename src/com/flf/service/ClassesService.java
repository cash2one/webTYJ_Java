package com.flf.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.Classes;

public interface ClassesService {
	List<Classes> listAllClasses();
	Classes getClassesById(String id);
	int insertClasses(Classes classes);
	int updateClasses(Classes classes);
	int deleteClasses(String id);
	
	int updateClassesState(Classes classes);//修改班次状态
	
	/**
	 * 根据id查询班次信息
	 * @param ClassesId
	 * @return
	 */
	@GET
	@Path("/getUserByIdRest/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	Classes getUserByIdRest(@PathParam("id") String id);
	
	/**
	 * 添加班次信息
	 * @param Classes
	 * @return
	 */
	@POST
	@Path("/AddClasses")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void AddClasses(Classes classes);
	
	
	/**
	 *修改班次信息
	 * @param Classes
	 * @return
	 */
	@PUT
	@Path("/UpdateClasses")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void UpdateClasses(Classes classes);
	
	/**
	 * 删除班次信息
	 * @param id
	 * @return
	 */
	@DELETE
	@Path("/DeleteClassesById/{id}")
	void DeleteClassesById(@PathParam("id") String id);

	 /**
		 * 查询所有班次信息
		 * @return
		 */
		@GET
		@Path("/listPageuser")
		@Produces(MediaType.APPLICATION_JSON)
		List<Classes> listPageuser();
	
	/**
	 * 根据岗位id查询班次并按岗位类型排序
	 * @param postId
	 * @return
	 */
	List<Classes> listClassesByPostIdAndOrderByPostTypeId(String postId);
}
