package com.flf.service;

import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.CompanyBankInfo;
/**
 * 公司表
 * 创建人：陈瑞
 * 创建时间：2016-8-12
 */
@WebService
@Path("/CompanyBankInfo")
public interface CompanyBankInfoService {
	
	/**
	 * 查询所有的公司银行信息
	 * @return
	 */
	@GET
	@Path("/listCompanyBankInfo")
	@Produces(MediaType.APPLICATION_JSON)
	CompanyBankInfo listCompanyBankInfo();
	
	/**
	 * 新增公司银行信息
	 * @param companyBankInfo
	 */
	@POST
	@Path("/insertCompanyBankInfo")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void insertCompanyBankInfo(CompanyBankInfo companyBankInfo);
	
	/**
	 * 更新公司银行信息
	 * @param companyBankInfo
	 */
	@PUT
	@Path("/updateCompanyBankInfo")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void updateCompanyBankInfo(CompanyBankInfo companyBankInfo);
	
}
