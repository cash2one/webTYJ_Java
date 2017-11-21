
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
import com.flf.entity.Rules;

@WebService
@Path("/Rules")

public interface RulesService {//规章制度表
	
	/**
	 * 分页查询规章制度信息
	  * listPageRules(这里用一句话描述这个方法的作用)
	  * TODO(这里描述这个方法适用条件 – 可选)
	  * TODO(这里描述这个方法的执行流程 – 可选)
	  * TODO(这里描述这个方法的使用方法 – 可选)
	  * TODO(这里描述这个方法的注意事项 – 可选)
	  *
	  * @Title: listPageRules
	  * @Description: TODO
	  * @param @param rules
	  * @param @return    设定文件
	  * @return List<Rules>    返回类型
	  * @throws
	 */
	@POST
	@Path("/listPageRules")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	PageRestful listPageRules(Rules rules);
	
	/**
	 * 查询所有规章制度信息
	 * @return
	 */
	@GET
	@Path("/listAllRules")
	@Produces(MediaType.APPLICATION_JSON)
	List<Rules> listAllRules();
	
	/**
	 * 查询所有规章制度信息
	 * @return
	 */
	@GET
	@Path("/listAllsRules")
	@Produces(MediaType.APPLICATION_JSON)
	List<Rules> listAllsRules();
	
	/**
	 * 根据id查询规章制度信息
	 * @param id
	 * @return
	 */
	@GET
	@Path("/getRulesById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	Rules getRulesByIdRest(@PathParam("id") String id);
	
	/**
	 * 增加规章制度
	 * @param rules
	 * @return
	 */
	@POST
	@Path("/AddRules")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void AddRules(Rules rules);
	
	
	/**
	 * 修改规章制度
	 * @param rules
	 * @return
	 */
	@PUT
	@Path("/UpdateRules")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void UpdateRules(Rules rules);
	

	/**
	 * 删除追加工单信息
	 * @param sraSrId
	 * @return
	 */
	@DELETE
	@Path("/DeleteRulesById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void DeleteRulesById(@PathParam("id") String id);


}












