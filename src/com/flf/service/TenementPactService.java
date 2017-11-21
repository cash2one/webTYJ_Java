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
import com.flf.entity.SearchPact;
import com.flf.entity.TenementPact;
import com.flf.request.TenementPactResult;
import com.flf.request.TenementPactSearch;
@Path(value="/TenementPact")
public interface TenementPactService {      
	
	/**
     * 搜素查询物业合同
     */
    @POST
  	@Path("/listPageTenementPactRestful")
  	@Produces(MediaType.APPLICATION_JSON)
    PageRestful listPageTenementPactRestful(TenementPact tenementPact);
    
    @GET
  	@Path("/listAllTenementPactRestful")
  	@Produces(MediaType.APPLICATION_JSON)
    List<TenementPact> listAllTenementPactRestful();
    
    @GET
  	@Path("/getTenementPactByIdRestful/{pactId}")
  	@Produces(MediaType.APPLICATION_JSON)
    TenementPact getTenementPactByIdRestful(@PathParam("pactId") String pactId);
    
    
    /**
     * 删除物业合同
     * @param pactId
     * @return
     */
    /*@DELETE
   	@Path("/deleteTenementPactRestful/{pactId}")
    @Produces(MediaType.APPLICATION_JSON)
    int deleteTenementPactRestful(@PathParam("pactId") String pactId);*/
    
    
    
    @POST
   	@Path("/insertTenementPactRestful")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    void insertTenementPactRestful(TenementPact tenementPact);
    
    
    /**
     * 修改物业合同
     * @param tenementPact
     */
    /*@PUT
   	@Path("/updateTenementPactRestful")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    int updateTenementPactRestful(TenementPactResult tenementPactResult);*/
    
    
    /**
     * 新增物业合同
     * @param tenementPact
     */
    @POST
   	@Path("/insertTenementPact")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    void insertTenementPact(TenementPact tenementPact);
    
    
    
    @POST
   	@Path("/searchTenementPact")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    void searchTenementPact(TenementPactSearch tenementPactSearch);
    
    /**
     * 物业合同生效
     * @param tenementPact
     * @return
     */
    @PUT
   	@Path("/updateTenementPactState")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    int updateTenementPactState(TenementPact tenementPact);
}
