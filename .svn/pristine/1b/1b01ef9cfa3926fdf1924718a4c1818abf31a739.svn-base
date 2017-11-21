package com.flf.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.flf.entity.Scheduling;
@Path("/Scheduling")
@WebService

public interface SchedulingService {//排班表
	List<Scheduling> listAllScheduling();//查询所有排班信息
	Scheduling getScheduling(int id);//根据Id查询排班信息
	int insertScheduling(Scheduling scheduling);//添加排班表信息
	int updateScheduling(Scheduling scheduling);//修改排班表信息
	int deleteScheduling(int id);//删除排班表信息
	boolean getCountBydivisionIdAndDate(String divisionId, int year, int month);//判断部门当前月是否已经排班

	/**
	 * 查询所有排班表
	 * @return
	 */
	@GET
	@Path("/listPagescheduling")
	@Produces(MediaType.APPLICATION_JSON)
	List<Scheduling> listPagescheduling();
	
	/**
	 * 根据Id查询排班表
	 * @param id
	 * @return
	 */
	@GET
	@Path("/getSchedulingById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	Scheduling getSchedulingByIdRest(@PathParam("id") Integer id);
	
	/**
	 * 添加排班信息
	 * @param scheduling
	 */
	@POST
	@Path("/AddScheduling")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void AddScheduling(Scheduling scheduling);
	
	/**
	 * 修改排班信息
	 * @param scheduling
	 */
	@PUT
	@Path("/UpdateScheduling")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void UpdateScheduling(Scheduling scheduling);
	
	/**
	 * 删除排班信息
	 * @param id
	 */
	@DELETE
	@Path("/DeleteSchedulingById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void DeleteSchedulingById(@PathParam("id") Integer id);
	


	/**
	 * 岗位id or
	 * 员工id or
	 * 时间  or
	 * @param scheduling
	 * @return
	 */
	List<Map> listAllSchedulingBypostIdOrStaffId(Scheduling scheduling);//查询所有排班表
	
	
	/**
	 * 部门id or
	 * 岗位id or
	 * 时间  or
	 * @param scheduling
	 * @return
	 */
	List<Map> listAllSchedulingBypostIdOrStaffName(Scheduling scheduling);//查询所有排班表
	
	
	/**
	 * 添加排班信息
	 * List<Staff>  staffs集合对象
	 * Post  post 岗位对象
	 * Classes  classes班次对象
	 * 
	 * 
	 * currentDate  日期
	 * @param map
	 * @return
	 */
	void addScheduLing(HashMap<String, Object> map);
	
	/**
	 * 通过员工id跟日期，修改员工班次
	 * @param scheduling
	 * @return
	 */
	int updateSchedulingByStaffId(Scheduling scheduling);

	
}
