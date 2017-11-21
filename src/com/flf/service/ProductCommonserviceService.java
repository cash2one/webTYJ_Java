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
import com.flf.entity.DataDictionarySlave;
import com.flf.entity.PageRestful;
import com.flf.entity.Product;
import com.flf.entity.ProductCommonservice;
import com.flf.entity.Project;
import com.flf.entity.StallNew;
import com.flf.request.Info;

/**
 * 普通服务产品
 * @author wangzhou
 *
 */
@WebService
@Path("/ProductCommonservice")
public interface ProductCommonserviceService{
	/*
	 * @author hanyupeng
	 * date 2016年7月4日19:10:38
	 * 增加普通服务产品
	 */
	@POST
	@Path("/addProductCommon")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	String addProductCommon(ProductCommonservice productCommon);
	/*
	 * 检查产品是否存在
	 */
	@POST
	@Path("/checkProduct/{productId}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	String checkProduct(@PathParam("productId") String productId);
	
	/*
	 * 更改
	 */
	@POST
	@Path("/updateProduct")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	String updateProduct(ProductCommonservice productCommon);
	/*
	 * 生成编号
	 */
	@POST
	@Path("/getProductNumber/{areaCode}/{projectId}/{divideCode}/{productTypeNumber}/{serialNumber}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	String getProductNumber(@PathParam("areaCode") String areaCode,@PathParam("projectId")  String projectId,
			@PathParam("divideCode") String divideCode,@PathParam("productTypeNumber") String productTypeNumber,
			@PathParam("serialNumber") String serialNumber);
	
	/**
	 * 获取产品通过分类
	 * @param Type
	 * @return
	 */
	@GET
	@Path("/getProductCommonListByType/{Type}")
	@Produces(MediaType.APPLICATION_JSON)
	List<ProductCommonservice> getProductCommonListByType(@PathParam("Type") String Type);
}
