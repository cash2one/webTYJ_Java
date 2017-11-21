package com.flf.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.flf.entity.BuildingNew;
import com.flf.entity.RegionNew;
import com.flf.mapper.BuildingNewMapper;
import com.flf.mapper.RegionNewMapper;
import com.flf.request.BuildingRegionNew;
import com.flf.service.RegionNewService;
import com.flf.util.JsonUtil;

public class RegionNewServiceImpl implements RegionNewService {
	
	private RegionNewMapper regionNewMapper;
	
	private BuildingNewMapper buildingNewMapper;
	

	/*
	  * <p>Title: deleteRegionNew</p>
	  * <p>Description: </p>
	  * @param id
	  * @return
	  * @see com.flf.service.RegionNewService#deleteRegionNew(java.lang.String)
	  */
	
	
	public BuildingNewMapper getBuildingNewMapper() {
		return buildingNewMapper;
	}

	public void setBuildingNewMapper(BuildingNewMapper buildingNewMapper) {
		this.buildingNewMapper = buildingNewMapper;
	}

	public RegionNewMapper getRegionNewMapper() {
		return regionNewMapper;
	}

	public void setRegionNewMapper(RegionNewMapper regionNewMapper) {
		this.regionNewMapper = regionNewMapper;
	}

	@Override
	public int deleteRegionNew(String id) {
		// TODO Auto-generated method stub
		return regionNewMapper.deleteRegionNew(id);
	}

	/*
	  * <p>Title: insertRegionNew</p>
	  * <p>Description: </p>
	  * @param region
	  * @return
	  * @see com.flf.service.RegionNewService#insertRegionNew(com.flf.entity.RegionNew)
	  */
	
	
	@Override
	public int insertRegionNew(RegionNew region) {
		// TODO Auto-generated method stub
		return regionNewMapper.insertRegionNew(region);
	}

	/*
	  * <p>Title: listPageRegionNew</p>
	  * <p>Description: </p>
	  * @param region
	  * @return
	  * @see com.flf.service.RegionNewService#listPageRegionNew(com.flf.entity.RegionNew)
	  */
	
	
	@Override
	public List<RegionNew> listPageRegionNew(RegionNew region) {
		// TODO Auto-generated method stub
		return regionNewMapper.listPageRegionNew(region);
	}

	/*
	  * <p>Title: listAllRegionNew</p>
	  * <p>Description: </p>
	  * @return
	  * @see com.flf.service.RegionNewService#listAllRegionNew()
	  */
	
	
	@Override
	public List<RegionNew> listAllRegionNew() {
		// TODO Auto-generated method stub
		return regionNewMapper.listAllRegionNew();
	}

	/*
	  * <p>Title: getRegionNewbyId</p>
	  * <p>Description: </p>
	  * @param id
	  * @return
	  * @see com.flf.service.RegionNewService#getRegionNewbyId(java.lang.String)
	  */
	
	
	@Override
	public RegionNew getRegionNewById(String id) {
		// TODO Auto-generated method stub
		return regionNewMapper.getRegionNewById(id);
	}

	/*
	  * <p>Title: updateRegionNew</p>
	  * <p>Description: </p>
	  * @param region
	  * @return
	  * @see com.flf.service.RegionNewService#updateRegionNew(com.flf.entity.RegionNew)
	  */
	
	
	@Override
	public int updateRegionNew(RegionNew region) {
		// TODO Auto-generated method stub
		return regionNewMapper.updateRegionNew(region);
	}

	/*
	  * <p>Title: deleteRegionNewCxf</p>
	  * <p>Description: </p>
	  * @param id
	  * @return
	  * @see com.flf.service.RegionNewService#deleteRegionNewCxf(java.lang.String)
	  */
	
	
	@Override
	public String deleteRegionNewCxf(String id) {
		// TODO Auto-generated method stub
		if(regionNewMapper.deleteRegionNew(id)>0)
		{
			return JsonUtil.success("success",false);
		}
		return JsonUtil.failure("failure",false);
	}

	/*
	  * <p>Title: insertRegionNewCXF</p>
	  * <p>Description: </p>
	  * @param region
	  * @return
	  * @see com.flf.service.RegionNewService#insertRegionNewCXF(java.lang.String)
	  */
	
	
	@Override
	public String insertRegionNewCxf(String region) {
		// TODO Auto-generated method stub
		RegionNew obj=(RegionNew) JSONObject.toBean(JSONObject.fromObject(region),RegionNew.class);
		if(regionNewMapper.insertRegionNew(obj)>0)
		{
			return JsonUtil.success("success",false);
		}
		return JsonUtil.failure("failure",false);
	}

	/*
	  * <p>Title: listAllRegionNewCxf</p>
	  * <p>Description: </p>
	  * @return
	  * @see com.flf.service.RegionNewService#listAllRegionNewCxf()
	  */
	
	
	@Override
	public String listAllRegionNewCxf() {
		// TODO Auto-generated method stub
		List<RegionNew> regions = regionNewMapper.listAllRegionNew();
		JSONArray json=JSONArray.fromObject(regions);
		return JsonUtil.success(json,true);
	}

	/*
	  * <p>Title: getRegionNewbyIdCxf</p>
	  * <p>Description: </p>
	  * @param id
	  * @return
	  * @see com.flf.service.RegionNewService#getRegionNewbyIdCxf(java.lang.String)
	  */
	
	
	@Override
	public String getRegionNewByIdCxf(String id) {
		// TODO Auto-generated method stub
		RegionNew region = regionNewMapper.getRegionNewById(id);
		JSONObject json = JSONObject.fromObject(region);
		return JsonUtil.success(json,true);
	}

	/*
	  * <p>Title: updateRegionNewCxf</p>
	  * <p>Description: </p>
	  * @param region
	  * @return
	  * @see com.flf.service.RegionNewService#updateRegionNewCxf(java.lang.String)
	  */
	
	
	@Override
	public String updateRegionNewCxf(String region) {
		// TODO Auto-generated method stub
		RegionNew obj=(RegionNew) JSONObject.toBean(JSONObject.fromObject(region),RegionNew.class);
		if(regionNewMapper.updateRegionNew(obj)>0)
		{
			return JsonUtil.success("success",false);
		}
		return JsonUtil.failure("failure",false);
	}

	/*
	  * <p>Title: listRegionNew</p>
	  * <p>Description: </p>
	  * @return
	  * @see com.flf.service.RegionNewService#listRegionNew()
	  */
	
	
	@Override
	public List<RegionNew> listRegionNew() {
		// TODO Auto-generated method stub
		return regionNewMapper.listAllRegionNew();
	}

	/*
	  * <p>Title: getRegionNewByIdRest</p>
	  * <p>Description: </p>
	  * @param RegionNewId
	  * @return
	  * @see com.flf.service.RegionNewService#getRegionNewByIdRest(java.lang.String)
	  */
	
	
	@Override
	public RegionNew getRegionNewByIdRest(String RegionNewId) {
		// TODO Auto-generated method stub
		return regionNewMapper.getRegionNewById(RegionNewId);
	}

	/*
	  * <p>Title: AddRegionNew</p>
	  * <p>Description: </p>
	  * @param RegionNew
	  * @see com.flf.service.RegionNewService#AddRegionNew(com.flf.entity.RegionNew)
	  */
	
	
	@Override
	public void AddRegionNew(RegionNew RegionNew) {
		// TODO Auto-generated method stub
		regionNewMapper.insertRegionNew(RegionNew);
	}

	/*
	  * <p>Title: UpdateRegionNew</p>
	  * <p>Description: </p>
	  * @param RegionNew
	  * @see com.flf.service.RegionNewService#UpdateRegionNew(com.flf.entity.RegionNew)
	  */
	
	
	@Override
	public void UpdateRegionNew(RegionNew RegionNew) {
		// TODO Auto-generated method stub
		regionNewMapper.updateRegionNew(RegionNew);
	}

	/*
	  * <p>Title: DeleteRegionNewById</p>
	  * <p>Description: </p>
	  * @param RegionNewId
	  * @see com.flf.service.RegionNewService#DeleteRegionNewById(java.lang.String)
	  */
	
	
	@Override
	public void DeleteRegionNewById(String RegionNewId) {
		// TODO Auto-generated method stub
		regionNewMapper.deleteRegionNew(RegionNewId);
	}

	/*
	  * <p>Title: getRegionNewprojectIdRest</p>
	  * <p>Description: </p>
	  * @param projectId
	  * @return
	  * @see com.flf.service.RegionNewService#getRegionNewprojectIdRest(java.lang.String)
	  */
	
	
	@Override
	public List<RegionNew> getRegionNewprojectIdRest(String projectId) {
		// TODO Auto-generated method stub
		List<RegionNew> regionNews = new ArrayList<RegionNew>();
		if(projectId!=null && !projectId.isEmpty()){
			regionNews = regionNewMapper.getRegionNewprojectIdRest(projectId);
			for (RegionNew regionNew : regionNews) {
				List<BuildingNew> buildingNews = regionNew.getBuildingNews();
				if(buildingNews.size()<2){
					buildingNews.add(0, null);
					regionNew.setBuildingNews(buildingNews);
				}
			}
		}
		return regionNews;
	}

	/*
	  * <p>Title: getBuildingRegionNewRest</p>
	  * <p>Description: </p>
	  * @param projectId
	  * @return
	  * @see com.flf.service.RegionNewService#getBuildingRegionNewRest(java.lang.String)
	  */
	
	
	@Override
	public BuildingRegionNew getBuildingRegionNewRest(String projectId) {
		// TODO Auto-generated method stub
		List<RegionNew> regionNews=	getRegionNewprojectIdRest(projectId); //获取区域信息列表
		List<BuildingNew> buildingNews= buildingNewMapper.ListBuildingNewByprojectId(projectId); //根据项目id查询未分区的建筑信息
		BuildingRegionNew buildingRegionNew=new BuildingRegionNew();  //将区域信息列表与未分区的建筑信息封装进入 buildingRegionNew 对象中
		buildingRegionNew.setBuildingNews(buildingNews);
		buildingRegionNew.setRegionNews(regionNews);
		return buildingRegionNew;
	}

	/*
	  * <p>Title: updateBuildingRegionNewRest</p>
	  * <p>Description: </p>
	  * @param buildingRegionNew
	  * @return
	  * @see com.flf.service.RegionNewService#updateBuildingRegionNewRest(com.flf.request.BuildingRegionNew)
	  */
	
	
	@Override
	public void updateBuildingRegionNewRest(
			BuildingRegionNew buildingRegionNew) {
		// TODO Auto-generated method stub
	List<BuildingNew> buildingNews=buildingRegionNew.getBuildingNews(); //获取所有未分区的信息列表
	List<RegionNew> regionNews=buildingRegionNew.getRegionNews();  //获取建筑分区信息列表
	for (BuildingNew buildingNew : buildingNews) {
		buildingNew.setProjectId(null);
		buildingNewMapper.updateBuildingNewSetRegionId(buildingNew);  //修改建筑所在区信息
	}
	for (RegionNew regionNew : regionNews) {
		for (BuildingNew buildingNew : regionNew.getBuildingNews()) {
			buildingNew.setRegionId(regionNew.getId());  //循环修改建筑所在区域
			buildingNewMapper.updateBuildingNew(buildingNew);  // 修改建筑所在区
		}
	}
	}

	@Override
	public void moveBuildingOutofRegion(String buildingId) {
		// TODO Auto-generated method stub
		buildingNewMapper.moveOutFromRegion(buildingId);
	}

	@Override
	public void moveBuildingToRegion(String regionId, String buildingId) {
		// TODO Auto-generated method stub
		buildingNewMapper.moveToRegion(regionId, buildingId);
	}

	@Override
	public void enptyAndDeleteTheRegion(String regionId) {
		// TODO Auto-generated method stub
		buildingNewMapper.cleanAllBuildingsInRegion(regionId);//清空分区中的建筑
		regionNewMapper.deleteRegionNew(regionId);//删除分区
	}

	
}
