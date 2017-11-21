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

import com.flf.entity.Items;


@WebService
@Path("/Items")
public interface ItemsService {

	/**
	 * 查询所有物品信息
	 * @return
	 */
	@GET
	@Path("/listAllItems")
	@Produces(MediaType.APPLICATION_JSON)
	List<Items> listAllItems();

	
	/**
	 * 根据物品id查询物品信息
	 * @return
	 */
	@GET
	@Path("/getItemsbyId/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	Items getUserByIdRest(@PathParam("id") String id);

	
	/**
	 * 新增物品信息
	 * @return
	 */
	@POST
	@Path("/insertItems")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void insertItemsrest(Items items);

	
	/**
	 * 修改物品信息
	 * @return
	 */
	@PUT
	@Path("/updateItems")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void updateItemsrest(Items items);

	
	/**
	 * 删除物品信息
	 * @return
	 */
	@DELETE
	@Path("/deleteItems/{id}")
	void deleteItemsrest(@PathParam("id") String id);

}
