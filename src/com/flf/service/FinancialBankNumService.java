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

import com.flf.entity.FinancialBankNum;
import com.flf.entity.PageRestful;

/**
 * @author maogaofei
 * @date 2016年6月13日 下午5:54:42
 */
@WebService
@Path("/FinancialBankNum")
public interface FinancialBankNumService {

	/**
	 * 通过Id查询
	 * @author maogaofei
	 * @date 2016年6月13日 下午5:54:35
	 * @param id
	 * @return
	 */
	@GET
	@Path("/getFinancialBankNumById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	FinancialBankNum getFinancialBankNumById(@PathParam("id") String id);
	
	/**
	 * 根据条件分页查询银行行别
	 * @author maogaofei
	 * @date 2016年6月13日 下午5:54:25
	 * @param financialGroupTotal
	 * @return
	 */
	@POST
	@Path("/listPageFinancialBankNum")
	@Produces(MediaType.APPLICATION_JSON)
	PageRestful listPageFinancialBankNum(FinancialBankNum financialBankNum);
	
	/**
	 * 根据条件查询所有的银行行别
	 * @author maogaofei
	 * @date 2016年6月14日 下午2:17:57
	 * @param financialBankNum
	 * @return
	 */
	@POST
	@Path("/listAllFinancialBankNum")
	@Produces(MediaType.APPLICATION_JSON)
	List<FinancialBankNum> listAllFinancialBankNum(FinancialBankNum financialBankNum);
	
	/**
	 * 新增银行行别
	 * @author maogaofei
	 * @date 2016年6月14日 上午11:56:37
	 * @param financialBankNum
	 * @return
	 */
	@POST
	@Path("/insertFinancialBankNum")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	String insertFinancialBankNum(FinancialBankNum financialBankNum);
	
	/**
	 * 修改银行行别
	 * @author maogaofei
	 * @date 2016年6月14日 上午11:19:32
	 * @param financialBankNum
	 */
	@POST
	@Path("/updateFinancialBankNum")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	String updateFinancialBankNum(FinancialBankNum financialBankNum);
	
	/**
	 * 删除银行行别
	 * @author maogaofei
	 * @date 2016年6月14日 上午11:27:24
	 * @param financialBankNumId
	 */
	@GET
	@Path("/deleteFinancialBankNum/{financialBankNumId}")
	@Produces(MediaType.APPLICATION_JSON)
	String deleteFinancialBankNum(@PathParam("financialBankNumId") String financialBankNumId);
	
}
