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

import com.flf.entity.Division;
@WebService
@Path("/Division")//部门表
public interface DivisionService {
	int deleteDivision(String id);//删除

    int insertDivision(Division division);//添加

    List<Division> listPageDivision(Division division);//分页查询所有
    
    List<Division> listAllDivision();//查询所有

    Division getDivisionbyId(String id);//根据id查询

    int updateDivision(Division division);//修改
    
    int deleteDivisionId(String id);
    
    String updateDivisionJson(String division);

	String getDivisionbyIdJson(String id);
	
	String deleteDivisionJson(String id);

    String insertDivisionJson(String division);
    
    boolean isinitialize(String id);//判断部门是否初始化
    
    int updateDivisionisinitialize(String id);
    /**
     * 查询所有部门信息
     * @return
     */
    /**
     * 查询所有部门信息
     * @return
     */
    @GET
	@Path("/listPagedivision")
	@Produces(MediaType.APPLICATION_JSON)
	List<Division> listPagedivision();
	/**
	 * 根据id查询部门信息
	 * @param id
	 * @return
	 */
    /**
     * 根据id查询部门信息
     * @param id
     * @return
     */
	@GET
	@Path("/getDivisionbyId/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	Division getDivisionId(@PathParam("id") String id);
	/**
	 * 查询所有部门信息
	 * @param division
	 */
	/**添加部门信息
	 * 
	 * @param division
	 */
	@POST
	@Path("/AllDivision")
	@Consumes( MediaType.APPLICATION_JSON)
	public List<Division> AllDivision();
	/**
	 * 修改部门信息
	 * @param division
	 */

	/**修改部门信息
	 * 
	 * @param division
	 */
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/UpdateDivision")
	public void UpdateDivision(Division division);
	/**
	 * 删除部门信息
	 * @param id
	 */

	/**删除部门信息
	 * 
	 * @param division
	 */
	@DELETE
	@Path("/deleteDivisionId/{id}")
	public void DeleteDivisionId(@PathParam("id") String id);
	
	/**
	 * 添加处理信息
	 * @param Division
	 * @return
	 */
	@POST
	@Path("/AddDivision")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void AddDeal(Division division);
}
