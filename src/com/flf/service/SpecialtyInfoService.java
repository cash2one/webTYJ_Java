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
import com.flf.request.SpecialtyInfoResult;

@Path("/SpecialtyInfo")
public interface SpecialtyInfoService {
	List<SpecialtyInfo> listAllSpecialtyInfo();
    List<SpecialtyInfo> listPageSpecialtyInfo(SpecialtyInfo specialtyInfo);
    SpecialtyInfo getSpecialtyInfoById(String specialtyId);
    //int deleteSpecialtyInfo(int id);
    int insertSpecialtyInfo(SpecialtyInfo specialtyInfo);
    int updateSpecialtyInfo(SpecialtyInfo specialtyInfo);
          /**
           * 查询所有专业线,(专业线初始化)
           * @param specialtyInfo
           * @return
           */
    @POST
  	@Path("/listPageSpecialtyInfoRestful")
    @Produces(MediaType.APPLICATION_JSON)
    PageRestful listPageSpecialtyInfoRestful(SpecialtyInfo specialtyInfo);
    
    @GET
  	@Path("/listAllSpecialtyInfoRestfulList")
    @Produces(MediaType.APPLICATION_JSON)
    List<SpecialtyInfo> listAllSpecialtyInfoRestfulList();
    
    @GET
  	@Path("/listAllSpecialtyInfoRestful")
    @Produces(MediaType.APPLICATION_JSON)
    List<SpecialtyInfo> listAllSpecialtyInfoRestful();
    
    @GET
  	@Path("/listAllSpecialtyInfoAndPostRestful")
    @Produces(MediaType.APPLICATION_JSON)
    List<SpecialtyInfo> listAllSpecialtyInfoAndPostRestful();
    
    @GET
  	@Path("/getSpecialtyInfoByIdRestful/{specialtyId}")
  	@Produces(MediaType.APPLICATION_JSON)
    SpecialtyInfo getSpecialtyInfoByIdRestful(@PathParam("specialtyId") String specialtyId);
    
    
    /**
     * 根据项目id查询专业线信息
     * @param specialtyId
     * @return
     */
    @GET
  	@Path("/getPreparebyprojectId/{projectId}")
  	@Produces(MediaType.APPLICATION_JSON)
    List<SpecialtyInfo> getPreparebyprojectId(@PathParam("projectId") String projectId);
    
    
    
    @DELETE
   	@Path("/deleteSpecialtyInfoRestful/{specialtyId}")
    @Produces(MediaType.APPLICATION_JSON)
    void deleteSpecialtyInfoRestful(@PathParam("specialtyId") String specialtyId);
    
    @POST
   	@Path("/insertSpecialtyInfoRestful")
   	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    void insertSpecialtyInfoRestful(SpecialtyInfo specialtyInfo);
    
    @PUT
   	@Path("/updateSpecialtyInfoRestful")
   	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    void updateSpecialtyInfoRestful(SpecialtyInfo specialtyInfo);
    
    
    /**
     * 开启专业线
     * @param specialtyInfo
     */
    @PUT
   	@Path("/updateSpecialtyInfobystate")
   	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    void updateSpecialtyInfobystate(SpecialtyInfo specialtyInfo);
    
    
    /**
     * 修改专业线状态
     * @param specialtyInfo
     */
    @POST
   	@Path("/updateListSpecialtyInfo")
   	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    void updateListSpecialtyInfo(SpecialtyInfoResult specialtyInfoResult);
	
    /**
     * 查询所有开启了的专业线
     * @param specialtyId
     * @return
     */
    @GET
  	@Path("/listAllSpecialtyInfoAndPostOpen")
  	@Produces(MediaType.APPLICATION_JSON)
    List<SpecialtyInfo> listAllSpecialtyInfoAndPostOpen();
   
    
    /**
     * 查询专业线下是否有其他任命
     * @param specialtyInfo
     */
    @GET
   	@Path("/listSpecialtyInfoByCompanyId/{companyId}/{specialtyId}/")
 	@Produces(MediaType.APPLICATION_JSON)
    List<SpecialtyInfo> listSpecialtyInfoByCompanyId(@PathParam("companyId")String companyId,@PathParam("specialtyId")String specialtyId);
    
    /**
     * 根据专业线名称查询专业线信息
     * 王洲
     * 2016.03.17
     * @param specialtyName
     * @return
     */
    @GET
    @Path("/getSpecialtyInfoByName/{specialtyName}")
    @Produces(MediaType.APPLICATION_JSON)
    SpecialtyInfo getSpecialtyInfoByName(@PathParam("specialtyName") String specialtyName);
    
    @POST
   	@Path("/updateListSpecialtyInfoTest")
   	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    void updateListSpecialtyInfoTest(SpecialtyInfo specialtyInfo) ;
    
}
