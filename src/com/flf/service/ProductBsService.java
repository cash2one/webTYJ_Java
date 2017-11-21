package com.flf.service;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.CarInfo;
import com.flf.entity.LeaseContract;
import com.flf.entity.PageRestful;
import com.flf.entity.ProductBs;
import com.flf.entity.Search;
import com.flf.entity.SearchCar;

@Path("/ProductBs")
public interface ProductBsService {
	/**
	 * 查询所有租赁合同管理列表
	 * @return
	 */
	@POST
	@Path("/listPageProductBs")
	@Produces(MediaType.APPLICATION_JSON)
	PageRestful listPageProductBs(ProductBs productBs); 
	
	/**
	 * 修改状态为失效
	 * 
	 * */
	
	@GET
	@Path("/changeStateByProductId/{productids}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	void changeStateByProductId(@PathParam("productids")String productids); 
	
	
}
