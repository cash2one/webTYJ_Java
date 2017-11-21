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

import com.flf.entity.Company;
/**
 * 公司表
 * 创建人：陶勇超
 * 创建时间：2015-12-8
 */
@WebService
@Path("/Company")
public interface CompanyService {
	
	/**
	 * 查询所有的公司
	 * @return
	 */
	@GET
	@Path("/listAllCompany")
	@Produces(MediaType.APPLICATION_JSON)
	List<Company> listAllCompany();
	
	/**
	 * 新增公司
	 * @param company
	 */
	@POST
	@Path("/insertCompany")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void insertCompany(Company company);
	
	/**
	 * 通过ID查询公司
	 * @param companyId
	 * @return
	 */
	@GET
	@Path("/getCompanyById/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	Company getCompanyById(@PathParam("companyId") String companyId);
	
	/**
	 * 通过下属项目id查询对应的公司信息
	 * @param projectId
	 * @return
	 */
	@GET
	@Path("/getCompanyByprojectId/{projectId}")
	@Produces(MediaType.APPLICATION_JSON)
	Company getCompanyByprojectId(@PathParam("projectId") String projectId);
	
	/**
	 * 通过公司id获取公司的详细信息，包括名称、所在地、地址、项目数、人员数、总占地面积等
	 * 王洲
	 * 2016.2.1
	 * @param companyId
	 * @return
	 */
	@GET
	@Path("/getCompanyInformation/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	Company getCompanyInformation(@PathParam("companyId") String companyId);
}
