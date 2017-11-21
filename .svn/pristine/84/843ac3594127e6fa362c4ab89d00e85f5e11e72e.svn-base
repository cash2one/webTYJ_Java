package com.flf.service;
import java.util.List;

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
import com.flf.entity.SpecialtyInfo;
import com.flf.entity.SpecialtyInfoProject;
import com.flf.request.SpecialtyInfoResult;

@Path("/SpecialtyInfoProject")
public interface SpecialtyInfoProjectService {
	@GET
  	@Path("/listSpecialtyInfoProject")
    @Produces(MediaType.APPLICATION_JSON)
    List<SpecialtyInfoProject> listSpecialtyInfoProject();
    
    
    
    @DELETE
   	@Path("/deleteSpecialtyInfoProjectRestful/{specialtyId}")
    @Produces(MediaType.APPLICATION_JSON)
    void deleteSpecialtyInfoProjectRestful(@PathParam("specialtyId") String specialtyId);
    
    @POST
   	@Path("/insertSpecialtyInfoProjectRestful")
   	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    void insertSpecialtyInfoProjectRestful(SpecialtyInfoProject specialtyInfoProject);
    
    
    /**
     * 开启专业线
     * @param specialtyInfoProject
     */
    @PUT
   	@Path("/updateSpecialtyInfoProjectbystate")
   	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    void updateSpecialtyInfoProjectbystate(SpecialtyInfoProject specialtyInfoProject);
    
    
    /**
     * 修改专业线状态
     * @param specialtyInfo
     */
    @PUT
   	@Path("/updateListSpecialtyInfoProject")
   	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    void updateListSpecialtyInfoProject(SpecialtyInfoProject specialtyInfoProject);
	
    /**
     * 查询所有开启了的专业线
     * @param projectId
     * @return
     */
    @GET
  	@Path("/listAllSpecialtyInfoProjectAndPostOpen/{projectId}")
  	@Produces(MediaType.APPLICATION_JSON)
    List<SpecialtyInfoProject> listAllSpecialtyInfoProjectAndPostOpen(@PathParam("projectId")String projectId);
   
    
    /**
     * 查询专业线下是否有其他任命
     * @param specialtyInfo
     */
    @GET
   	@Path("/listSpecialtyInfoProjectByCompanyId/{companyId}/{specialtyId}/")
 	@Produces(MediaType.APPLICATION_JSON)
    List<SpecialtyInfoProject> listSpecialtyInfoProjectByCompanyId(@PathParam("companyId")String companyId,@PathParam("specialtyId")String specialtyId);
    
    /**
     * 根据项目id查询项目专业线
     * @param specialtyInfo
     */
    @GET
    @Path("/listSpecialtyInfoProjectByProjectId/{projectId}")
    @Produces(MediaType.APPLICATION_JSON)
    List<SpecialtyInfoProject> listSpecialtyInfoProjectByProjectId(@PathParam("projectId")String projectId);
    
    /**
     * 初始化已存在项目的专业线
     * @param specialtyInfo
     */
    @POST
   	@Path("/initExistedProjectProfessionalLine")
   	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    void initExistedProjectProfessionalLine();
}
