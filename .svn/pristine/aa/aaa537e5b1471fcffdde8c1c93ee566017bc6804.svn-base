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

import com.flf.entity.OrganizationStructure;
import com.flf.request.OrgTree;
import com.flf.request.Tree;

@WebService
@Path("/OrganizationStructure")
public interface OrganizationStructureService {
	
	/**
	 * 查询所有的组织结构树结构
	 * @return
	 */
	@GET
	@Path("/getAllOrganizationStructure")
	@Produces(MediaType.APPLICATION_JSON)
	public List<OrgTree> getAllOrganizationStructure();
	
	/**
	 * 根据组结构id获取组织结构信息
	 * @param organizationId
	 * @return
	 */
	@GET
	@Path("/getOrganizationStructurebyId/{organizationId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Tree> getOrganizationStructurebyId(@PathParam("organizationId") String organizationId);
	
	/**
	 * 删除组织结构
	 * @param organizationId
	 */
	@DELETE
	@Path("/deleteOrganizationStructure/{organizationId}")
	public void deleteOrganizationStructure(@PathParam("organizationId") String organizationId);
	
	/**
	 * 修改组织结构
	 * @param organizationStructure
	 */
	@PUT
	@Path("/updateOrganizationStructure")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void updateOrganizationStructure(OrganizationStructure organizationStructure);
	
	/**
	 * 添加组织结构
	 * @param organizationStructure
	 */
	@POST
	@Path("/insertOrganizationStructure")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public void insertOrganizationStructure(OrganizationStructure organizationStructure);
	
	/**
	 * 获取组织结构二叉树结构
	 * @return
	 */
	@GET
	@Path("/getOrganizationStructureTree")
	@Produces(MediaType.APPLICATION_JSON)
	public List<OrgTree> getOrganizationStructureTree();
}
