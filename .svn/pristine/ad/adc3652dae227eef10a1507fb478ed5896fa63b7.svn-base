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

import com.flf.entity.Constant;

/**
 * 常量对象service
 * @author maogaofei
 * @date 2016年7月8日 下午1:09:39
 */
@Path("/Constant")
@WebService
public interface ConstantService {
	
	/**
	 * 根据ID查询常量
	 * @author maogaofei
	 * @date 2016年7月8日 下午1:09:27
	 * @param constantId
	 * @return
	 */
	@GET
	@Path("/getConstantByConstantId/{constantId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Constant getConstantByConstantId(@PathParam("constantId") String constantId);
	/**
	 * 新增常量
	 * @author maogaofei
	 * @date 2016年7月8日 下午1:09:05
	 * @param constant
	 * @return
	 */
	@POST
	@Path("/insertConstant")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public String insertConstant(Constant constant);
	/**
	 * 根据收费类型ID查询所有的变量、运算符号和常量
	 * @author maogaofei
	 * @date 2016年7月8日 下午1:12:49
	 * @param constant
	 * @return
	 */
	@GET
	@Path("/listAllConstant/{chargeTypeId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Constant> listAllConstant(@PathParam("chargeTypeId") String chargeTypeId);
	
}
