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

import com.flf.entity.BuildingNew;
import com.flf.request.Tree;

@WebService
@Path("/BuildingNew")
public interface BuildingNewService {
    
	List<BuildingNew> listPageBuildingNew(BuildingNew building);
	
	List<BuildingNew> listAllBuildingNew();
	
	BuildingNew getBuildingNewById(String id);
	
	int insertBuildingNew(BuildingNew building);
	
	int updateBuildingNew(BuildingNew building);
	
	int deleteBuildingNew(String id);
	
	//Cxf
	String listAllBuildingNewCxf();
    
	String getBuildingNewByIdCxf(String id);

    String insertBuildingNewCxf(String building);
    
    String updateBuildingNewCxf(String building);
    
    String deleteBuildingNewCxf(String id);
    
   
    /**添加建筑信息与建筑类型面积
      * @Title: AddBuilding
      * @Description: TODO
      * @param @param buildingnew
      * @param @param areaNew    设定文件
      * @return void    返回类型
      * 2015-6-9 wangyong
      * @throws
     */
    @POST
   	@Path("/AddBuildingNew")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
   	void AddBuildingNew(BuildingNew buildingnew);
    
    
   /**
    * 根据建筑id查询建筑详细信息
    * 2015-6-9 wangyong
    */
    @GET
    @Path("/getBuildingbyId/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    BuildingNew getBuildingbyId(@PathParam("id") String id);
    
    /**
     * 查询所有建筑信息
     * 2015-6-9 wangyong
      * @Title: ListBuildingNew
      * @Description: TODO
      * @param     设定文件
      * @return void    返回类型
      * @throws
     */
    @GET
   	@Path("/ListBuildingNew")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
   	List<BuildingNew> ListBuildingNew();
    
    /**
     * 根据项目id查询项目建筑信息
     * 2015-6-9 wangyong
      * @Title: ListBuildingNew
      * @Description: TODO
      * @param     设定文件
      * @return void    返回类型
      * @throws
     */
    @GET
   	@Path("/ListBuildingNewprojectIdAll/{projectId}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
   	List<BuildingNew> ListBuildingNewprojectIdAll(@PathParam("projectId") String projectId);
    
    @GET
   	@Path("/jsonBuildingNewAll/{projectId}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_XML})
    String jsonBuildingNewAll(@PathParam("projectId") String projectId);
    
    /**
     * @author zhuwei
     * @date 2015-07-02
     * @param projectId
     * @return
     */
    @GET
   	@Path("/jsonBuildingNewprojectIdAll/{projectId}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    List<Tree> jsonBuildingNewprojectIdAll(@PathParam("projectId") String projectId);
    
    @GET
   	@Path("/BuildingNewprojectIdAll/{projectId}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    List<Tree> BuildingNewprojectIdAll(@PathParam("projectId") String projectId);
    
    
    /**
     * 根据项目id查询未划分区域的项目建筑信息
     * 2015-6-9 wangyong
      * @Title: ListBuildingNew
      * @Description: TODO
      * @param     设定文件
      * @return void    返回类型
      * @throws
     */
    @GET
   	@Path("/ListBuildingNewByprojectId/{projectId}")
    @Consumes({MediaType.APPLICATION_JSON})
   	List<BuildingNew> ListBuildingNewByprojectId(@PathParam("projectId") String projectId);
    
    /**
     * 根据项目id和区域id查询分区后的项目建筑信息
     * 2015-9-11
     * @author Fansensen
     */
    @GET
   	@Path("/listBuildingNewsByProjectIdAndRegionId/{projectId}/{regionId}")
    @Consumes({MediaType.APPLICATION_JSON})
    List<BuildingNew> listBuildingNewsByProjectIdAndRegionId(@PathParam("projectId") String projectId,@PathParam("regionId") String regionId);
}
