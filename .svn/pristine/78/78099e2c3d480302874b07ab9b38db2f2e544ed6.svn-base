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
import com.flf.entity.Produceprice;


@WebService
@Path(value = "/Produceprice")
public interface ProducepriceService {// 产品价格表
	List<String> listType();// 查询所有产品价格表

	List<Produceprice> listProducequotelistByType(String type);// 根据类型查询产品价格

	List<Produceprice> listAllProduceprice();

	/**
	 * 查询产品价格信息
	 * 
	 * @return
	 */
	String listProducepriceType();

	/**
	 * 查询所有产品信息表
	 * 
	 * @return
	 */
	@POST
	@Path("/listPageProduceprice")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	PageRestful listPageProduceprice(Produceprice produceprice);

	/**
	 * 根据Id查询产品信息表List<Produceprice> listPageProduceprice(Produceprice
	 * produceprice);
	 * 
	 * @param id
	 * @return
	 */
	@GET
	@Path("/getProducepriceById/{productId}")
	@Produces(MediaType.APPLICATION_JSON)
	Produceprice getProducepriceById(@PathParam("productId") int productId);

	/**
	 * 添加产品信息表信息
	 * 
	 * @param produceprice
	 */
	@POST
	@Path("/AddProduceprice")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void AddProduceprice(Produceprice produceprice);

	/**
	 * 修改产品信息表信息
	 * 
	 * @param produceprice
	 */
	@PUT
	@Path("/UpdateProduceprice")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void UpdateProducepriceById(Produceprice produceprice);

	/**
	 * 删除产品信息表信息
	 * 
	 * @param id
	 */
	@DELETE
	@Path("/DeleteProducepriceById/{productId}")
	void DeleteProducepriceById(@PathParam("productId") Integer productId);

	/**
	 * 修改产品信息表状态
	 * 
	 * @param productIdi亢
	 */
	@GET
	@Path("/UpdateProduceprice/{productId}")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void UpdateStateById(@PathParam("productId") int productId);

}
