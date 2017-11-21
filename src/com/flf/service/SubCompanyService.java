package com.flf.service;
import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.ConpanyTree;
import com.flf.entity.PageRestful;
import com.flf.entity.SubCompany;
import com.flf.entity.SubCompanyProjectRelation;
import com.flf.request.OrgTree;
@WebService
@Path("/SubCompany")
public interface SubCompanyService {

	/* 分页查询子公司信息 */
	@POST
	@Path("/listPageAllSubCompanys")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	PageRestful listPageAllSubCompanys(SubCompany subCompany);
	
	/* 根据id查询子公司 */
	@GET
	@Path("/getSubCompanyById/{subCompanyId}")
	@Produces(MediaType.APPLICATION_JSON)
	SubCompany getSubCompanyById(@PathParam("subCompanyId")String subCompanyId);
	
	/* 修改子公司信息 */
	@POST
	@Path("/updateSubCompany")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	int updateSubCompany(SubCompany subCompany);
	
	/* 删除子公司 */
	@POST
	@Path("/deleteSubCompany")
	@Produces(MediaType.APPLICATION_JSON)
	void deleteSubCompany(SubCompany subCompany);
	
	/* 添加子公司信息 */
	@POST
	@Path("/insertSubCompany")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	int insertSubCompany(SubCompany subCompany);
//	
//	@DELETE
//	@Path("/deleteProject/{projectId}")
//	void deleteProjectrest(@PathParam("projectId") String projectId);
	
	/**
	 * 获取公司组织结构二叉树结构
	 * @return
	 */
	@GET
	@Path("/getSubCompanyTree")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ConpanyTree> getSubCompanyTree();
	
	
	/*查询所有数据*/
	@GET
	@Path("/getAllSubCompany")
	@Produces(MediaType.APPLICATION_JSON)
	List<SubCompany> getAllSubCompany();
	

	/**
	 * 查询所有的组织结构树结构
	 * @return
	 */
	@GET
	@Path("/getAllSubCompanyStructure")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ConpanyTree> getAllSubCompanyStructure();
	
	@GET
	@Path("/getAllSubCompanyData/{subCompanyId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<SubCompany> getAllSubCompanyData(@PathParam("subCompanyId")String subCompanyId);
	
	/* 根据公司ID查询子公司 */
	@GET
	@Path("/getSubCompanyByCompanyId/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<SubCompany> getSubCompanyByCompanyId(@PathParam("companyId") String companyId);
	
	/**
	 * 获取组织结构
	 * @param project
	 * @return
	 * @author shaozheng 2015-12-11
	 * 
	 */
	@GET
	@Path("/getOrganizationStructureTree/{projectId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<OrgTree> getOrganizationStructureTree(@PathParam("projectId") String projectId);
	

	@GET
	@Path("/getAllProject/{subCompanyId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<SubCompanyProjectRelation> getAllProject(@PathParam("subCompanyId")String subCompanyId);
}
