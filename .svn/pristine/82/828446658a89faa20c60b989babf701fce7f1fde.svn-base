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

import com.flf.entity.RegionNew;
import com.flf.request.BuildingRegionNew;

@WebService
@Path("/RegionNew")
public interface RegionNewService {
	
	List<RegionNew> listPageRegionNew(RegionNew region);
	
	List<RegionNew> listAllRegionNew();
	
	RegionNew getRegionNewById(String id);
	
	int insertRegionNew(RegionNew region);
	
	int updateRegionNew(RegionNew region);
	
	int deleteRegionNew(String id);
	
	//Cxf
	String listAllRegionNewCxf();
    
	String getRegionNewByIdCxf(String id);

    String insertRegionNewCxf(String region);
    
    String updateRegionNewCxf(String region);
    
    String deleteRegionNewCxf(String id);  
    
    
    
    /**
	 * 查询所有区域信息
	 * @return
	 */
	@GET
	@Path("/listRegionNew")
	@Produces(MediaType.APPLICATION_JSON)
	List<RegionNew> listRegionNew();
	
	/**
	 * 根据id查询区域信息
	 * @param RegionNewId
	 * @return
	 */
	@GET
	@Path("/getRegionNewByIdRest/{RegionNewId}")
	@Produces(MediaType.APPLICATION_JSON)
	RegionNew getRegionNewByIdRest(@PathParam("RegionNewId") String RegionNewId);
	
	/**
	 * 添加区域信息
	 * @param RegionNew
	 * @return
	 */
	@POST
	@Path("/AddRegionNew")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void AddRegionNew(RegionNew RegionNew);
	
	
	/**
	 *修改区域信息
	 * @param RegionNew
	 * @return
	 */
	@PUT
	@Path("/UpdateRegionNew")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void UpdateRegionNew(RegionNew RegionNew);
	
	/**
	 * 删除区域信息
	 * @param RegionNewId
	 * @return
	 */
	@DELETE
	@Path("/DeleteRegionNewById/{RegionNewId}")
	void DeleteRegionNewById(@PathParam("RegionNewId") String RegionNewId);
	
	
	/**
	 * 根据项目id查询区域信息
	 * @param RegionNewId
	 * @return
	 */
	@GET
	@Path("/getRegionNewprojectIdRest/{projectId}")
	@Produces(MediaType.APPLICATION_JSON)
	List<RegionNew> getRegionNewprojectIdRest(@PathParam("projectId") String projectId);

	/**
	 * 根据项目id查询区域信息和为分区的建筑信息
	 * @param RegionNewId
	 * @return
	 */
	@GET
	@Path("/getBuildingRegionNewRest/{projectId}")
	@Produces(MediaType.APPLICATION_JSON)
	BuildingRegionNew getBuildingRegionNewRest(@PathParam("projectId") String projectId);
	
	/**
	 * 修改建筑所在区域
	 * @param RegionNewId
	 * @return
	 */
	@PUT
	@Path("/updateBuildingRegionNewRest")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void updateBuildingRegionNewRest(BuildingRegionNew buildingRegionNew);
	
	/**
	 * 将建筑移到空闲分区
	 * @param RegionNewId
	 * @return
	 */
	@PUT
	@Path("/moveBuildingOutofRegion/{buildingId}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void moveBuildingOutofRegion(@PathParam("buildingId") String buildingId);
	
	/**
	 * 将建筑移动到分区
	 * @param regionId
	 * @param buildingId
	 */
	@PUT
	@Path("/moveBuildingToRegion/{regionId}/{buildingId}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void moveBuildingToRegion(@PathParam("regionId") String regionId,@PathParam("buildingId") String buildingId);
	
	/**
	 * 清空分区并删除分区
	 * @param regionId
	 */
	@PUT
	@Path("/enptyAndDeleteTheRegion/{regionId}")
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	void enptyAndDeleteTheRegion(@PathParam("regionId") String regionId);
}
