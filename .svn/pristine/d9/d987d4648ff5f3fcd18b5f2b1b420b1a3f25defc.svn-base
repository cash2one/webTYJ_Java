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

import com.flf.entity.PageRestful;
import com.flf.entity.Vacation;

/**
 * 内部专业线_ 假期管理(接口)
 * 
 * @author 阮枚星
 * 
 * @createDate:2015-05-26
 * 
 */
@WebService
@Path("/Vacation")
public interface VacationService {
	/**
	 * 分页获取假期管理信息
	 * 
	 * @param Vacation
	 *            假期管理对象
	 * @return 返回假期管理对象集合
	 */
	@POST
	@Path("/getPageRestfulVacation")
	@Produces(MediaType.APPLICATION_JSON)
	public PageRestful getPageRestfulVacation(Vacation vacation);

	/**
	 * 获取所有假期管理信息
	 * 
	 * @param Vacation
	 *            假期管理对象
	 * @return 返回假期管理对象集合
	 */
	@GET
	@Path("/getAllVacation")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Vacation> getAllVacation(Vacation vacation);

	/**
	 * 根据id获取管理对象
	 * 
	 * @param id
	 *            假期id
	 * @return 返回假期对象
	 */
	@GET
	@Path("/getVacationById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Vacation getVacationById(@PathParam("id") Integer id);

	/**
	 * 根据假期名称模糊查询假期信息
	 * 
	 * @param VacationName
	 *            假期名称
	 * @return 返回假期管理对象集合
	 */
	@POST
	@Path("/getVacationByName/{VacationName}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Vacation> getVacationByName(
			@PathParam("VacationName") String vacationName);

	/**
	 * 修改假期管理信息
	 * 
	 * @param Vacation
	 *            假期对象信息
	 */
	@PUT
	@Path("/editVacation")
	@Consumes(MediaType.APPLICATION_JSON)
	public void editVacation(Vacation vacation);

	/**
	 * 根据假期id删除假期对象信息
	 * 
	 * @param id
	 *            假期id
	 */
	@DELETE
	@Path("/delVacationById/{id}")
	public void delVacationById(@PathParam("id") Integer id);

	/**
	 * 增加假期信息
	 * 
	 * @param Vacation
	 *            假期对象信息
	 */
	@POST
	@Path("/addVacation")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addVacation(Vacation vacation);

	/**
	 * 
	 * getVacation(获取所有假期信息)
	 * 
	 * @Title: getVacation
	 * @Description: TODO
	 * @param @return 设定文件
	 * @return List<Vacation> 假期对象信息
	 * @throws
	 */
	@GET
	@Path("/getVacation")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Vacation> getVacation();
}
