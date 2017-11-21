package com.flf.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import net.sf.json.JSONArray;

import org.apache.cxf.binding.corba.wsdl.Array;

import com.flf.entity.CorePosition;
import com.flf.entity.Prepare;
import com.flf.entity.Project;
import com.flf.entity.SpecialtyInfo;
import com.flf.entity.SpecialtyInfoProject;
import com.flf.entity.TeamPermissions;
import com.flf.entity.TeamPermissionsResult;
import com.flf.entity.Teamwork;
import com.flf.mapper.ProjectMapper;
import com.flf.mapper.SpecialtyInfoMapper;
import com.flf.mapper.SpecialtyInfoProjectMapper;
import com.flf.mapper.TeamPermissionsMapper;
import com.flf.mapper.TeamworkMapper;
import com.flf.request.TeamworkResult;
import com.flf.service.TeamPermissionsService;
import com.sun.corba.se.impl.protocol.SpecialMethod;

public class TeamPermissionsServiceImpl implements TeamPermissionsService {
	private TeamPermissionsMapper teamPermissionsMapper;
	
	private ProjectMapper projectMapper;
	
	private SpecialtyInfoMapper specialtyInfoMapper;
	
	private TeamworkMapper teamworkMapper;
	
	private SpecialtyInfoProjectMapper specialtyInfoProjectMapper;

	public TeamPermissionsMapper getTeamPermissionsMapper() {
		return teamPermissionsMapper;
	}



	public void setTeamPermissionsMapper(TeamPermissionsMapper teamPermissionsMapper) {
		this.teamPermissionsMapper = teamPermissionsMapper;
	}


//
//	@Override
//	public TeamPermissions getTeamPermissions(TeamPermissions teamPermissions) {
//		// TODO Auto-generated method stub
//		System.out.println("********************8");
//		return teamPermissionsMapper.getTeamPermissions(teamPermissions);
//	}
	
	

	public SpecialtyInfoProjectMapper getSpecialtyInfoProjectMapper() {
		return specialtyInfoProjectMapper;
	}



	public void setSpecialtyInfoProjectMapper(SpecialtyInfoProjectMapper specialtyInfoProjectMapper) {
		this.specialtyInfoProjectMapper = specialtyInfoProjectMapper;
	}



	public ProjectMapper getProjectMapper() {
		return projectMapper;
	}



	public void setProjectMapper(ProjectMapper projectMapper) {
		this.projectMapper = projectMapper;
	}



	public SpecialtyInfoMapper getSpecialtyInfoMapper() {
		return specialtyInfoMapper;
	}



	public void setSpecialtyInfoMapper(SpecialtyInfoMapper specialtyInfoMapper) {
		this.specialtyInfoMapper = specialtyInfoMapper;
	}



	public TeamworkMapper getTeamworkMapper() {
		return teamworkMapper;
	}



	public void setTeamworkMapper(TeamworkMapper teamworkMapper) {
		this.teamworkMapper = teamworkMapper;
	}



	@Override
	public List<TeamPermissions> getTeamPermissions(TeamPermissions teamPermissions) {
		// TODO Auto-generated method stub
		return teamPermissionsMapper.getTeamPermissions(teamPermissions);
	}


/**
 * 权限管理保存
 * yinlei
 */
	@Override
	public void AddCorePosition(
			TeamPermissionsResult teamPermissionsResult) {
		// TODO Auto-generated method stub
		TeamPermissions teamPermissionss=new TeamPermissions(); //存放每一组项目id和专业线id
		//TeamPermissions ObjectTP=new TeamPermissions();  //获取数据库每一组项目id和专业线id的负责人
		List<TeamPermissions> ObjectTP=new ArrayList<TeamPermissions>();  //获取数据库每一组项目id和专业线id的负责人
		for (TeamPermissions teamPermissions : teamPermissionsResult.getTeamPermissions()) {
			teamPermissionss.setProjectId(teamPermissions.getProjectId());
			teamPermissionss.setProfessionalLineId(teamPermissions.getProfessionalLineId());
//			ObjectTP=teamPermissionsMapper.getTeamPermissions(teamPermissionss); //查询改项目及该专业线的负责人信息
			ObjectTP=teamPermissionsMapper.getTeamPermissions(teamPermissionss); //查询改项目及该专业线的负责人信息
			//判断该项目及该专业线对应负责人是否为空以及操作后该负责人是否为空
			for(int i=0;i<ObjectTP.size();i++){
				if(teamPermissions.getStaffId()!=null &&ObjectTP.get(i).getStaffId()!=null){
					if(teamPermissions.getStaffId()==ObjectTP.get(i).getStaffId()){
						continue;
					}else{
						//修改权限管理信息
						//teamPermissions.setTeamPermissionsId(ObjectTP.get(i).getTeamPermissionsId());
						teamPermissionsMapper.updateTeamPermissions(teamPermissions);
					}
				}else{
					String uuid=UUID.randomUUID().toString();
					teamPermissions.setTeamPermissionsId(uuid);
					//新增权限管理信息
					teamPermissionsMapper.insertTeamPermissions(teamPermissions);
				}
			}
			
//			if(teamPermissions.getStaffId()!=null && ObjectTP..getStaffId()!=null){
//				if(teamPermissions.getStaffId()==ObjectTP.getStaffId()){
//					continue;
//				}else{
//					//修改权限管理信息
//					teamPermissionsMapper.updateTeamPermissions(teamPermissions);
//				}
//			}else{
//				String uuid=UUID.randomUUID().toString();
//				teamPermissions.setTeamPermissionsId(uuid);
//				//新增权限管理信息
//				teamPermissionsMapper.insertTeamPermissions(teamPermissions);
//			}
		}
	}



@Override
public List<TeamPermissions> listAllTeamPermissionsStaff() {
	// TODO Auto-generated method stub
	return teamPermissionsMapper.listAllTeamPermissionsStaff();
}

	@Override
	public TeamworkResult getTeamworkByProjectAndSpecialty(){
		TeamworkResult teamworkResult=new TeamworkResult();
		List<Project> projects=projectMapper.listAllProject();
		List<SpecialtyInfo> specialtyInfos=specialtyInfoMapper.listAllSpecialtyInfo();
		ArrayList<ArrayList<HashMap<String, Object>>> dataList=new ArrayList<ArrayList<HashMap<String,Object>>>(); 
		/*第一行数据(title)*/
		ArrayList<HashMap<String, Object>> listTitle=new ArrayList<HashMap<String,Object>>();
		for (SpecialtyInfo specialtyInfo : specialtyInfos) {
			HashMap<String, Object> map=new HashMap<String,Object>();
			map.put("SpecialtyInfo",specialtyInfo);
			listTitle.add(map);
		}
		dataList.add(listTitle);
		/*正文数据*/
		for (Project project : projects) {
			ArrayList<HashMap<String, Object>> list=new ArrayList<HashMap<String,Object>>();
			HashMap<String, Object> projectMap=new HashMap<String,Object>();
			projectMap.put("project", project);
			list.add(0,projectMap);
			for (SpecialtyInfo specialtyInfo : specialtyInfos) {
				HashMap<String, Object> map=new HashMap<String,Object>();
				List<Teamwork> teamwork= teamworkMapper.getTeamworkIdBySearch(project.getProjectId(),specialtyInfo.getSpecialtyId());
                map.put("teamid", teamwork.size() != 0 ? teamwork.get(0).getId() : "novalue");
                map.put("corePositionId", specialtyInfo.getSpecialtyId());
              //  map.put("corpPositionId", );
				list.add(map);
			}
			dataList.add(list);
		}
		JSONArray json =JSONArray.fromObject(dataList);
		teamworkResult.setData(json.toString());
		return teamworkResult;
	}

	@Override
	public TeamworkResult getCorePositionByProjectAndSpecialty(){
		TeamworkResult teamworkResult=new TeamworkResult();
		List<Project> projects=projectMapper.listAllProject();
		List<SpecialtyInfo> specialtyInfos=specialtyInfoMapper.listAllSpecialtyInfo();
		for(int i = 0; i < specialtyInfos.size(); i ++){
			if(specialtyInfos.get(i).getSpecialtyName().equals("项目")){
				SpecialtyInfo si = specialtyInfos.get(i);
				specialtyInfos.remove(i);
				specialtyInfos.add(0, si);
			}
		}
		ArrayList<ArrayList<HashMap<String, Object>>> dataList=new ArrayList<ArrayList<HashMap<String,Object>>>(); 
		/*第一行数据(title)*/
		ArrayList<HashMap<String, Object>> listTitle=new ArrayList<HashMap<String,Object>>();
		for (SpecialtyInfo specialtyInfo : specialtyInfos) {
			HashMap<String, Object> map=new HashMap<String,Object>();
			map.put("SpecialtyInfo",specialtyInfo);
			listTitle.add(map);
		}
		dataList.add(listTitle);
		/*正文数据*/
		for (Project project : projects) {
			ArrayList<HashMap<String, Object>> list=new ArrayList<HashMap<String,Object>>();
			HashMap<String, Object> projectMap=new HashMap<String,Object>();
			projectMap.put("project", project);
			list.add(0,projectMap);
			for (SpecialtyInfo specialtyInfo : specialtyInfos) {
				HashMap<String, Object> map=new HashMap<String,Object>();
				TeamPermissions forSearch = new TeamPermissions();
				forSearch.setProjectId(project.getProjectId());
				forSearch.setProfessionalLineId(specialtyInfo.getSpecialtyId());
				TeamPermissions tp = teamPermissionsMapper.getCorePositionByProjectAndSpecialty(forSearch);
                map.put("teamper", tp != null ? tp : "");
				list.add(map);
			}
			dataList.add(list);
		}
		JSONArray json =JSONArray.fromObject(dataList);
		teamworkResult.setData(json.toString());
		return teamworkResult;
	}
	
	@Override
	public void addOrUpdateTeamPermissions(TeamPermissions teamPermissions){
		if(teamPermissions.getTeamPermissionsId().equals("")){
			teamPermissions.setTeamPermissionsId(UUID.randomUUID().toString());
			teamPermissionsMapper.insertTeamPermissions(teamPermissions);
		}else{
			teamPermissionsMapper.updateTeamPermissions(teamPermissions);
		}
	}



	@Override
	public TeamworkResult getCorePositionByProjectAndSpecialty2() {
		// TODO Auto-generated method stub
		TeamworkResult teamworkResult=new TeamworkResult();
		List<Project> projects=projectMapper.listAllProject();
		List<SpecialtyInfo> specialtyInfos=specialtyInfoMapper.listSpecialtyInfo();
		for(int i = 0; i < specialtyInfos.size(); i ++){
			if(specialtyInfos.get(i).getSpecialtyName().equals("项目")){
				SpecialtyInfo si = specialtyInfos.get(i);
				specialtyInfos.remove(i);
				specialtyInfos.add(0, si);
			}
		}
		ArrayList<ArrayList<HashMap<String, Object>>> dataList=new ArrayList<ArrayList<HashMap<String,Object>>>(); 
		/*第一行数据(title)*/
		ArrayList<HashMap<String, Object>> listTitle=new ArrayList<HashMap<String,Object>>();
		for (SpecialtyInfo specialtyInfo : specialtyInfos) {
			HashMap<String, Object> map=new HashMap<String,Object>();
			map.put("SpecialtyInfo",specialtyInfo);
			listTitle.add(map);
		}
		dataList.add(listTitle);
		/*正文数据*/
		for (Project project : projects) {
			ArrayList<HashMap<String, Object>> list=new ArrayList<HashMap<String,Object>>();
			HashMap<String, Object> projectMap=new HashMap<String,Object>();
			projectMap.put("project", project);
			list.add(0,projectMap);
			for (SpecialtyInfo specialtyInfo : specialtyInfos) {
				HashMap<String, Object> map=new HashMap<String,Object>();
				TeamPermissions forSearch = new TeamPermissions();
				forSearch.setProjectId(project.getProjectId());
				forSearch.setProfessionalLineId(specialtyInfo.getSpecialtyId());
				List<SpecialtyInfoProject> specialInfoProjects = specialtyInfoProjectMapper.listSpecialtyInfoProjectOpen(project.getProjectId());
				Boolean tag = false;
				for(SpecialtyInfoProject specialtyInfoProject : specialInfoProjects){
					if(specialtyInfoProject.getSpecialtyName().equals(specialtyInfo.getSpecialtyName())){
						tag = true;
						break;
					}
				}
				if(tag){
					TeamPermissions tp = teamPermissionsMapper.getCorePositionByProjectAndSpecialty(forSearch);
	                map.put("teamper", tp != null ? tp : "");
					list.add(map);
				}
				else{
					String str = "nothing";
					map.put("error",str);
					list.add(map);
				}
			}
			dataList.add(list);
		}
		JSONArray json =JSONArray.fromObject(dataList);
		teamworkResult.setData(json.toString());
		return teamworkResult;
	}
}
