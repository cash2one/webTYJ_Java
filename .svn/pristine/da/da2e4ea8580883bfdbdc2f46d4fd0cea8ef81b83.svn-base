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

import com.flf.entity.AreaTypeNew;
import com.flf.entity.PageRestful;

/**
 * 面积名称service
 * @author niming
 *
 */
@WebService
@Path(value = "/AreaTypeNew")
public interface AreaTypeNewService {
	
	List<AreaTypeNew> listPageAreaTypeNew(AreaTypeNew areaType);
	
	List<AreaTypeNew> listAllAreaTypeNew();
	
	AreaTypeNew getAreaTypeNewById(String id);
	
	int insertAreaTypeNew(AreaTypeNew areaType);
	
	int updateAreaTypeNew(AreaTypeNew areaType);
	
	int deleteAreaTypeNew(String id);
	
	//Cxf
	String listAllAreaTypeNewCxf();
    
	String getAreaTypeNewbyIdCxf(String id);

    String insertAreaTypeNewCxf(String areaType);
    
    String updateAreaTypeNewCxf(String areaType);
    
    String deleteAreaTypeNewCxf(String id);

    /**
     * 查询所有面积类型
     * @return
     */
    @GET
	@Path("/listAllAreaTypeNew")
	@Produces(MediaType.APPLICATION_JSON)
    List<AreaTypeNew> listAllAreaTypeNeweRestful();
    
    /**
     * 根据id查询面积类型
     * @return
     */
    @GET
	@Path("/selectAreaTypeNewById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
    AreaTypeNew selectAreaTypeNewById(@PathParam("id") String id);
    
	/**
	 * 新增面积类型
	 * @return
	 */
	@POST
	@Path("/insertAreaTypeNewRestful")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	int insertAreaTypeNewRestful(AreaTypeNew areaTypeNew);

	
	/**
	 * 修改面积类型
	 * @return
	 */
	@PUT
	@Path("/updateArticleRelease")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	void updateArticleReleaserestRestful(AreaTypeNew areaTypeNew);
	
	/*
	 * 分页查询
	 */
    @POST
 	@Path("/listPageAreaTypeNewRestful")
  	@Produces(MediaType.APPLICATION_JSON)
    PageRestful listPageAreaTypeNewRestful(AreaTypeNew areaTypeNew);
	
}
