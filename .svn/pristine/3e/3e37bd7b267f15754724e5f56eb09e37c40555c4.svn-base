package com.flf.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.AcceptanceHouse;
/**
 * @see <code>验房管理，验房活动接口</code>
 * @author zhuwei
 * @date 2015-07-17
 */
import com.flf.entity.PageRestful;
@WebService
@Path("/AcceptanceHouse")
public interface AcceptanceHouseService {
	
	/**
	 * 查询所有验房活动信息
	 * @return
	 */
	@GET
	@Path("/listAllAcceptanceHouse")
	@Produces(MediaType.APPLICATION_JSON)
	List<AcceptanceHouse> listAllAcceptanceHouse();
	
	/**
	 * 通过Id查询验房活动信息
	 * @param orderId
	 * @return
	 */
	@GET
	@Path("/getAcceptanceHousebyId/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	AcceptanceHouse getAcceptanceHousebyId(@PathParam("id") String id);
	
	/**
	 * 新增验房活动信息
	 * @param acceptanceHouse
	 */
	@POST
	@Path("/insertAcceptanceHouse")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void insertAcceptanceHouse(AcceptanceHouse acceptanceHouse);
	
	/**
	 * 分页查询
	 * @param acceptanceHouse
	 * @return
	 */
	@POST
	@Path("/listPageAcceptanceHouse")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	PageRestful listPageAcceptanceHouse(AcceptanceHouse acceptanceHouse);

}
