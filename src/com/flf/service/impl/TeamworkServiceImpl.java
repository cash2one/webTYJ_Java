package com.flf.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.cxf.ws.security.policy.SPConstants;

import com.flf.entity.Search;

import net.sf.json.JSONArray;

import com.flf.entity.PageRestful;
import com.flf.entity.Prepare;
import com.flf.entity.Search;
import com.flf.entity.CorePosition;
import com.flf.entity.HrAuthority;
import com.flf.entity.Project;
import com.flf.entity.SpecialtyInfo;
import com.flf.entity.Staff;
import com.flf.entity.TeamPermissions;
import com.flf.entity.Teamwork;
import com.flf.entity.Teamworkstaff;
import com.flf.mapper.CorePositionMapper;
import com.flf.mapper.HrAuthorityMapper;
import com.flf.mapper.PostMapper;
import com.flf.mapper.PrepareMapper;
import com.flf.mapper.ProjectMapper;
import com.flf.mapper.SpecialtyInfoMapper;
import com.flf.mapper.StaffMapper;
import com.flf.mapper.TeamPermissionsMapper;
import com.flf.mapper.TeamworkMapper;
import com.flf.mapper.TeamworkstaffMapper;
import com.flf.request.TeamworkResult;
import com.flf.service.TeamworkService;

public class TeamworkServiceImpl implements TeamworkService {
	
	private StaffMapper staffMapper;
	
	private PostMapper postMapper;
	
	private ProjectMapper projectMapper;
	
	private SpecialtyInfoMapper specialtyInfoMapper;
	
	private TeamPermissionsMapper teamPermissionsMapper;
	
	private TeamworkstaffMapper teamworkstaffMapper;
	
	private PrepareMapper prepareMapper;
	
	private HrAuthorityMapper hrAuthorityMapper;
	
	public HrAuthorityMapper getHrAuthorityMapper() {
		return hrAuthorityMapper;
	}

	public void setHrAuthorityMapper(HrAuthorityMapper hrAuthorityMapper) {
		this.hrAuthorityMapper = hrAuthorityMapper;
	}

	public PrepareMapper getPrepareMapper() {
		return prepareMapper;
	}

	public void setPrepareMapper(PrepareMapper prepareMapper) {
		this.prepareMapper = prepareMapper;
	}
	
	public TeamworkstaffMapper getTeamworkstaffMapper() {
		return teamworkstaffMapper;
	}

	public void setTeamworkstaffMapper(TeamworkstaffMapper teamworkstaffMapper) {
		this.teamworkstaffMapper = teamworkstaffMapper;
	}

	public TeamPermissionsMapper getTeamPermissionsMapper() {
		return teamPermissionsMapper;
	}

	public void setTeamPermissionsMapper(TeamPermissionsMapper teamPermissionsMapper) {
		this.teamPermissionsMapper = teamPermissionsMapper;
	}

	public SpecialtyInfoMapper getSpecialtyInfoMapper() {
		return specialtyInfoMapper;
	}

	public void setSpecialtyInfoMapper(SpecialtyInfoMapper specialtyInfoMapper) {
		this.specialtyInfoMapper = specialtyInfoMapper;
	}

	public ProjectMapper getProjectMapper() {
		return projectMapper;
	}

	public void setProjectMapper(ProjectMapper projectMapper) {
		this.projectMapper = projectMapper;
	}

	private CorePositionMapper corePositionMapper;

	public CorePositionMapper getCorePositionMapper() {
		return corePositionMapper;
	}

	public void setCorePositionMapper(CorePositionMapper corePositionMapper) {
		this.corePositionMapper = corePositionMapper;
	}

	public PostMapper getPostMapper() {
		return postMapper;
	}

	public void setPostMapper(PostMapper postMapper) {
		this.postMapper = postMapper;
	}

	public StaffMapper getStaffMapper() {
		return staffMapper;
	}

	public void setStaffMapper(StaffMapper staffMapper) {
		this.staffMapper = staffMapper;
	}

	private TeamworkMapper teamworkMapper;

	public TeamworkMapper getTeamworkMapper() {
		return teamworkMapper;
	}

	public void setTeamworkMapper(TeamworkMapper teamworkMapper) {
		this.teamworkMapper = teamworkMapper;
	}

	@Override
	public List<Teamwork> listPageTeamwork() {
		// TODO Auto-generated method stub
		return teamworkMapper.listAllTeamwork();
	}

	@Override
	public Teamwork getTeamworkByIdRest(String id) {
		// TODO Auto-generated method stub
		return teamworkMapper.getTeamworkbyId(id);
	}

	@Override
	public void AddTeamwork(Teamwork teamwork) {
		// TODO Auto-generated method stub
		teamworkMapper.insertTeamwork(teamwork);
	}

	@Override
	public void UpdateTeamwork(Teamwork teamwork) {
		// TODO Auto-generated method stub
		teamworkMapper.updateTeamwork(teamwork);
	}

	@Override
	public void DeleteTeamworkById(String id) {
		// TODO Auto-generated method stub
		teamworkMapper.deleteTeamwork(id);
	}

	
	/**
	 * 根据实例id查询团队信息  尹磊
	 * @param instanceId
	 * @return
	 */
	@Override
	public List<Teamwork> listTeamworkbyinstanceId(String instanceId) {
		// TODO Auto-generated method stub
		return teamworkMapper.listTeamworkbyinstanceId(instanceId);
	}

	@Override
	public List<Teamwork> getTeamworkbyLeader(String leader) {
		// TODO Auto-generated method stub
		return teamworkMapper.getTeamworkbyLeader(leader);
	}

	@Override
	public List<Teamwork> listAllTeamwork() {
		// TODO Auto-generated method stub
		List<Teamwork> teamworks = teamworkMapper.listAllTeamwork();//用于查询团队人数并更新人数
		for (Teamwork teamwork : teamworks) {
			if(teamwork!=null){
				String teamworkId = teamwork.getId();
				Integer teamMembers = teamwork.getTeamMembers();
				Integer staffNum = teamworkMapper.countStaffByTeamworkId(teamworkId);
				if(teamwork!=null && teamMembers!=staffNum){
					teamwork.setTeamMembers(staffNum);
					teamworkMapper.updateTeamwork(teamwork);
				}
			}
		}
		return teamworkMapper.listAllTeamwork();
	}
	
	@Override
	public TeamworkResult myTeamProfession(String staffId, String employId) {
		TeamworkResult teamworkResult=new TeamworkResult();
		Teamwork teamwork = new Teamwork();
		List<Teamwork> teamworks=teamworkMapper.getTeamworkBystaffId(staffId);//获取团队信息
		List<Staff> listAllStaffs=new ArrayList<Staff>();//所有员工信息
		//获取当前员工团队下的人
		List<Staff> teamWordStaffs=staffMapper.listTeamWorkStaffBystaffId(staffId);
		int num = 0;
		if(teamWordStaffs.size() > 0){
			num = teamWordStaffs.size();
		}
		if(teamwork != null){
			teamwork.setTeamMembers(num);
			if(teamworks.size() > 0){
				teamwork.setId(teamworks.get(0).getId());
				teamwork.setStaff(teamworks.get(0).getStaff());
				teamwork.setTeamName(teamworks.get(0).getStaff().getStaffName() + "的团队");
			}
		}
		//查询员工所在的核心岗位
		List<CorePosition> corePositionList=corePositionMapper.getCorePositionBystaffId(staffId);//核心岗位
		if(corePositionList.size() > 0){
			int i = 0;
			for(CorePosition cp : corePositionList){
				if(cp.getState()==0){
					i++;
				}
			}
			if(i > 0){//等于1为项目经理
				List<Staff> projectStaffs=staffMapper.listProjectStaffBystaffId(staffId);//查询项目下的员工
				//listAllStaffs=getColorState(teamWordStaffs,projectStaffs);//获取员工的颜色状态
				listAllStaffs = teamWordStaffs;
				List<Project> projects=projectMapper.listAllProject();//查询项目经理的项目
				List<SpecialtyInfo> specialtyInfos=specialtyInfoMapper.listAllSpecialtyInfo();//获取所有专业线信息
				ArrayList<ArrayList<HashMap<String, Object>>> data=matrix(projects,specialtyInfos,staffId,employId,corePositionList);//岗位信息
				JSONArray json =JSONArray.fromObject(data);//转化为json对象
				teamworkResult.setData(json.toString());
			}else{
				List<Staff> specialtyInfoStaffs=staffMapper.listSpecialtyInfoStaffBystaffId(staffId);//查询专业线下的员工
				//listAllStaffs=getColorState(teamWordStaffs,specialtyInfoStaffs);//获取员工的颜色状态
				listAllStaffs = teamWordStaffs;//专业线经理只显示自己团队的员工
				List<Project> projects=projectMapper.listAllProject();//查询所有项目
				List<SpecialtyInfo> specialtyInfos=specialtyInfoMapper.listSpecialtyInfoBystaffId(staffId);//获取专业线经理的专业线
				ArrayList<ArrayList<HashMap<String, Object>>> data=matrix(projects,specialtyInfos,staffId,employId,corePositionList);//岗位信息
				JSONArray json =JSONArray.fromObject(data);
				teamworkResult.setData(json.toString());
			}			
		}
		teamworkResult.setTeamwork(teamwork);
		teamworkResult.setStaffs(listAllStaffs);
		return teamworkResult;
	}
	
	/**
	 * 获取员工的颜色状态
	 * @param a
	 * @param b
	 * @return
	 */
	private List<Staff> getColorState(List<Staff> a,List<Staff> b){
		List<Staff> allStaffs=new ArrayList<Staff>();//存放空闲的员工
		List<Staff> retainList=a;//存放两个list的交集,即为可以操作的员工
		List<Staff> removeList=a;//存放两个list的差集,即为可以不可操作的员工
		if(a.size()>0){
			allStaffs.addAll(a);
		}
		if(b.size()>0){
			allStaffs.addAll(b);
		}
		allStaffs.removeAll(retainList);
		allStaffs.removeAll(removeList);
		if(allStaffs.size()>0){
			retainList.retainAll(retainList);
			removeList.removeAll(retainList);
		}
		for (Staff staff : retainList) {
			staff.setColorState(1);//1可操作(黄色)
		}
		for (Staff staff : removeList) {
			staff.setColorState(0);//0不能操作(灰色)
		}
		for (Staff staff : allStaffs) {
			staff.setColorState(2);//2空闲(绿色)
		}
		return allStaffs;
	}
	
	
	/**
	 * 矩阵
	 * @param projects 项目集合
	 * @param specialtyInfos 专业线集合
	 * @return
	 */
	private ArrayList<ArrayList<HashMap<String, Object>>> matrix(List<Project> projects,List<SpecialtyInfo> specialtyInfos,String staffId,String employId,List<CorePosition> corePositionList){
		//判断是否有项目经理
		String cpId = null;
		for(CorePosition cp : corePositionList){
			if(cp.getState() == 0){
				cpId = cp.getCorePositionId();
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
				TeamPermissions teamPermissions= new TeamPermissions();
				if(cpId != null && staffId.equals(employId)){
					teamPermissions = teamPermissionsMapper.checkPremissions(project.getProjectId(), specialtyInfo.getSpecialtyId(), cpId);
				}else{
					teamPermissions = teamPermissionsMapper.isStaffPermissions(project.getProjectId(), specialtyInfo.getSpecialtyId(), employId);//判断权限					
				}
				int count=teamworkstaffMapper.staffCount(project.getProjectId(), specialtyInfo.getSpecialtyId());//该岗位已有人数
				int totalcount = 0;  //该项目专业线下总人数
				//获取该项目专业线下所有为核心岗位编制
				List<Prepare> prepareList = prepareMapper.listAllSearchPrepare(project.getProjectId(), specialtyInfo.getSpecialtyId());
				for(Prepare prepare : prepareList){
					if(prepare.getPrepareNumber() == null){
						prepare.setPrepareNumber(0);
					}
					totalcount = totalcount + prepare.getPrepareNumber();
				}
				map.put("count", totalcount-count);
				if(teamPermissions != null){
					map.put("TeamPermissions", 1);//有权限
				}else{
					map.put("TeamPermissions", 0);//没有权限
				}
				//查询团队操作员是否有权限
				if(!staffId.equals(employId) && map.get("TeamPermissions").equals(0)){
					HrAuthority hrAuthority = new HrAuthority();
					hrAuthority.settUserId(employId);
					hrAuthority.setTeamworkId(teamworkMapper.getTeamworkIdByStaffId(staffId));
					hrAuthority.setCorePositionId(specialtyInfo.getSpecialtyId());
					hrAuthority.setProjectId(project.getProjectId());
					hrAuthority = hrAuthorityMapper.getAllByHrAuthority(hrAuthority);
					if(hrAuthority != null){
						map.put("TeamPermissions", 2);//团队操作员权限
					}
				}
				list.add(map);
			}
			dataList.add(list);
		}
		
		return dataList;
	}


	@Override
	public Teamwork getTeamworkIdBySearch(String projectId,String specialtyId) {
		// TODO Auto-generated method stub
		return teamworkMapper.getTeamworkIdBySearch( projectId, specialtyId).get(0);
	}
	
	
	
	@Override
	public TeamworkResult myTeamProfessionone() {
		// TODO Auto-generated method stub
		TeamworkResult teamworkResult=new TeamworkResult();
		List<Project> projects=projectMapper.listAllProject();
		List<SpecialtyInfo> specialtyInfos=specialtyInfoMapper.listAllSpecialtyInfo();
		ArrayList<ArrayList<HashMap<String, Object>>> data=matrixone(projects,specialtyInfos);//岗位信息
		JSONArray json =JSONArray.fromObject(data);
		teamworkResult.setData(json.toString());
		/*Teamwork teamwork=teamworkMapper.getTeamworkBystaffId(staffId);//获取团队信息
		List<Staff> listAllStaffs=new ArrayList<Staff>();//所有员工信息
		获取当前员工团队下的人
		List<Staff> teamWordStaffs=staffMapper.listTeamWorkStaffBystaffId(staffId);
		查询员工所在的核心岗位
		CorePosition corePosition=corePositionMapper.getCorePositionBystaffId(staffId);//核心岗位
		if(corePosition!=null && corePosition.getState()==1){//等于1为项目经理
			List<Staff> projectStaffs=staffMapper.listProjectStaffBystaffId(staffId);//查询项目下的员工
			listAllStaffs=getColorState(teamWordStaffs,projectStaffs);//获取员工的颜色状态
			List<Project> projects=projectMapper.listProjectBystaffId(staffId);//查询项目经理的项目
			List<SpecialtyInfo> specialtyInfos=specialtyInfoMapper.listAllSpecialtyInfo();//获取所有专业线信息
			ArrayList<ArrayList<HashMap<String, Object>>> data=matrix(projects,specialtyInfos,staffId);//岗位信息
			JSONArray json =JSONArray.fromObject(data);//转化为json对象
			teamworkResult.setData(json.toString());
		}else{
			List<Staff> specialtyInfoStaffs=staffMapper.listSpecialtyInfoStaffBystaffId(staffId);//查询专业线下的员工
			listAllStaffs=getColorState(teamWordStaffs,specialtyInfoStaffs);//获取员工的颜色状态
			List<Project> projects=projectMapper.listAllProject();//查询所有项目
			List<SpecialtyInfo> specialtyInfos=specialtyInfoMapper.listSpecialtyInfoBystaffId(staffId);//获取专业线经理的专业线
			ArrayList<ArrayList<HashMap<String, Object>>> data=matrix(projects,specialtyInfos,staffId);//岗位信息
			JSONArray json =JSONArray.fromObject(data);
			teamworkResult.setData(json.toString());
		}*/
		//teamworkResult.setTeamwork(teamwork);
		//teamworkResult.setStaffs(listAllStaffs);
		return teamworkResult;
	}
	
	
	private ArrayList<ArrayList<HashMap<String, Object>>> matrixone(List<Project> projects,List<SpecialtyInfo> specialtyInfos){
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
				List<Prepare> prepares= prepareMapper.listAllSearchPrepare(project.getProjectId(),specialtyInfo.getSpecialtyId());
				int numAll=0;
				for(Prepare prepare:prepares){
					if(prepare.getPrepareNumber() != null){
						numAll=prepare.getPrepareNumber()+numAll;	
					}
				}
				int count=teamworkstaffMapper.staffCountForPrepare(project.getProjectId(), specialtyInfo.getSpecialtyId()); 
				map.put("countTeamStaff", count);
				count=numAll-count;
                map.put("count", count>0?count:0);   
				list.add(map);
			}
			dataList.add(list);
		}
		return dataList;
	}

	//分页查询
	public PageRestful listPageTeamworksRestful(Teamwork teamwork){
		// TODO Auto-generated method stub
		PageRestful pagerestful=new PageRestful();
		List<Teamwork> teamList = null;
		List<Teamwork> teamworks =teamworkMapper.listPageTeamworks(teamwork);
		//增加方法，查询每个leader的团队list，通过list获取leader所有团队的总人数  王洲  2016.1.26
		for(Teamwork tw : teamworks){
			//获取核心岗位数
			Map map = new HashMap();
			map.put("staffId", tw.getLeader());
			Integer core = teamworkMapper.getNumberByMap(map);
			tw.setCorePostNumber(core.toString());
			teamList = new ArrayList<Teamwork>();
			//获取此leader的所有团队
			teamList = teamworkMapper.getTeamworkbyLeader(tw.getLeader());
			int num = 0;
			//循环获取每个团队的人数并累计
			for(Teamwork temp : teamList){
				num = num + teamworkstaffMapper.getCountByTeamworkId(temp.getId());
			}
			//将总人数放入传到前端的对象中
			tw.setTeamworkAmount(num);
		}
		teamworks.add(0,null);
		pagerestful.setTeamworks(teamworks);
		pagerestful.setPage(teamwork.getPage());
		return pagerestful;
	}

	@Override
	public Teamwork insertTeamwork(Teamwork teamwork){
		if(teamwork.getId() == null){
		teamwork.setId(UUID.randomUUID().toString());
		teamworkMapper.insertTeamworkUUID(teamwork);
		}else{
			teamworkMapper.updateTeamwork(teamwork);
		}
		return teamwork;
	}
	
	@Override
	public void delTeamwork(String teamworkId){
		teamworkstaffMapper.deleteByTeamworkId(teamworkId);
		teamworkMapper.deleteTeamwork(teamworkId);
	}
	
	@Override
	public Teamworkstaff getChildTeamById(String teamworkId){
		Teamworkstaff teamworkstaff = new Teamworkstaff();
		Map map = new HashMap();
		map.put("id", teamworkId);
		teamworkstaff = teamworkMapper.getStaffBystaffIdOrId(map);
		teamworkstaff.setTeamwork(teamworkMapper.getTeamworkbyId(teamworkId));
		teamworkstaff.setStaffs(teamworkstaffMapper.getStaffByTeamworkId(teamworkId));
		return teamworkstaff;
	}
	
	@Override
	public List<Teamwork> getChildTeam(){
		List<Teamwork> childTeamList = new ArrayList<Teamwork>();
		childTeamList = teamworkMapper.getChildTeam();
		if(childTeamList.size() > 0){
			for(Teamwork tw : childTeamList){
				tw.setTeamworkAmount(teamworkstaffMapper.getCountByTeamworkId(tw.getId()));
			}
		}
		return childTeamList;
	}
	
}
