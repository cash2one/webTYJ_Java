package com.flf.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.flf.entity.CorePosition;
import com.flf.entity.PageRestful;
import com.flf.entity.Parcel;
import com.flf.entity.Prepare;
import com.flf.entity.Project;
import com.flf.entity.ProjectCompletion;
import com.flf.entity.SpecialtyInfo;
import com.flf.entity.SubCompany;
import com.flf.entity.TeamPermissions;
import com.flf.entity.Teamworkstaff;
import com.flf.mapper.CorePositionMapper;
import com.flf.mapper.ParcelMapper;
import com.flf.mapper.PrepareMapper;
import com.flf.mapper.ProjectCompletionMapper;
import com.flf.mapper.ProjectMapper;
import com.flf.mapper.SpecialtyInfoMapper;
import com.flf.mapper.TeamPermissionsMapper;
import com.flf.mapper.TeamworkstaffMapper;
import com.flf.request.ProjectResult;
import com.flf.request.Tree;
import com.flf.service.ProjectService;
import com.flf.util.DateUtil;
import com.flf.util.JsonUtil;
import com.flf.util.Tools;

@WebService
public  class ProjectServiceImpl implements ProjectService{
	@Autowired
	private ProjectMapper projectMapper;
	@Autowired
	private PrepareMapper prepareMapper;
	@Autowired
	private SpecialtyInfoMapper specialtyInfoMapper;
	@Autowired
	private TeamworkstaffMapper teamworkstaffMapper;
	@Autowired
	private ParcelMapper parcelMapper;//宗地
	@Autowired
	private ProjectCompletionMapper projectCompletionMapper;//项目完成情况
	@Autowired
	private CorePositionMapper corePositionMapper;//核心岗位
	@Autowired
	private TeamPermissionsMapper teamPermissionsMapper;

	@Override
	public Project getProject(String id) {
		// TODO Auto-generated method stub
		return projectMapper.getProject(id);
	}

	@Override
	public int updateProject(Project project) {
		// TODO Auto-generated method stub
		return projectMapper.updateProject(project);
	}


	@Override
	public int insertProject(Project project) {
		// TODO Auto-generated method stub
		return projectMapper.insertProject(project);
	}


	@Override
	public int deleteProjectById(String id) {
		// TODO Auto-generated method stub
		return projectMapper.deleteProjectById(id);
	}
	@Override
	public List<Project> listAllProject(String companyId) {
		List<Project> pList = projectMapper.listAllProjectByCompany(companyId);
		return pList;
	}
	@Override
	public String updateProjectJson(String project) {
		// TODO Auto-generated method stub
		JSONObject json=JSONObject.fromObject(project);
		Project project2=(Project) JSONObject.toBean(json,Project.class);
		if(projectMapper.updateProjectJson(project2)>0){
			return JsonUtil.success("success",true);
		}
		return JsonUtil.failure("failure",true);
	}
	@Override
	public String deleteProjectByIdJson(String id) {
		// TODO Auto-generated method stub
		try {			
			if(projectMapper.deleteProjectByIdJson(id)>0)
			{
			return JsonUtil.success("success", true);
			}else{
				return JsonUtil.failure("failure", true);
			}

		} catch (Exception e) {
			// TODO: handle exception
			return JsonUtil.failure("failure", true);
		}
	}
	@Override
	public String insertProjectJson(String project) {
		// TODO Auto-generated method stub
		JSONObject json=JSONObject.fromObject(project);
		Project project1=(Project) JSONObject.toBean(json,Project.class);
		if(projectMapper.insertProjectJson(project1)>0){
			return JsonUtil.success("success",true);
		}
		return JsonUtil.failure("failure",true);
	}
	
	@Override
	public String getProjectJson(String id) {
		// TODO Auto-generated method stub
			Project project=projectMapper.getProjectJson(id);
			if(project!=null){
				JSONObject json=JSONObject.fromObject(project);
				return JsonUtil.success(json, false);
			}else{
				return JsonUtil.failure("failure", true);
			}
		
	}
	@Override
	public String getProject1(String id) {
		// TODO Auto-generated method stub
		Project project=projectMapper.getProject(id);
		if(project!=null){
			JSONObject json=JSONObject.fromObject(project);
			return (JsonUtil.success(json, false));
		}else{
			return(JsonUtil.failure("failure", true));
		}
	}
	@Override
	public Project getUserByIdRest(String projectId) {
		Project project = new Project();
		project = projectMapper.getProject(projectId);
		ProjectCompletion pc = projectCompletionMapper.getProjectCompletionByProjectId(projectId);
		if(pc != null){
			project.setProjectCompletion(pc);
		}else{
			pc = new ProjectCompletion();
			pc.setAreaType(1);
			pc.setProjectId(projectId);
			pc.setCompanyId(project.getCompany());
			project.setProjectCompletion(pc);
		}
		return project;
	}
	@Override
	public void insertProjectrest(Project project) {
		// TODO Auto-generated method stub
		projectMapper.insertProject(project);
	}
	
	@Override
	public void updateProjectrest(Project project) {
		// TODO Auto-generated method stub
		projectMapper.updateProject(project);
	}
	
	@Override
	public void updateProjectrestNew(ProjectResult projectResult) {
		Project project=projectResult.getProject();
		project.setSortDate(DateUtil.currentDate());//设置排序时间
		projectMapper.updateProject(project);
		if(projectMapper.updateProject(project) > 0){
			List<Prepare> oldPrepareList = prepareMapper.getPreparebyprojectId(project.getProjectId());
			List<Parcel> oldParcelList = parcelMapper.selectByProjectId(project.getProjectId());
			List<Prepare> prepares=new ArrayList<Prepare>();
			List<Parcel> parcels =new ArrayList<Parcel>();
			for (Prepare prepare : projectResult.getPrepares()) {
				boolean updatePrepareFlag = false;
				for (Prepare prepareOld : oldPrepareList) {
					if(prepareOld.getPrepareId().equals(prepare.getPrepareId())){
						updatePrepareFlag = true;
						break;
					}
				}
				if(updatePrepareFlag){
					prepareMapper.updatePrepare(prepare);
				}else{
					Prepare p=prepare;
					p.setProjectId(project.getProjectId().toString());
					prepares.add(p);
				}
			}
			if(prepares.size()>0){
				prepareMapper.insertListPrepare(prepares);
			}
			for(Parcel parcel :projectResult.getParcels() ){
				boolean updateParcelFlag = false;
				for (Parcel parcelOld : oldParcelList) {
					if(parcelOld.getParcelId().equals(parcel.getParcelId())){
						updateParcelFlag = true;
						break;
					}
				}
				if(updateParcelFlag){
					parcelMapper.updateByPrimaryKey(parcel);
				}else{
					Parcel par=parcel;
					par.setProjectId(project.getProjectId().toString());
					parcels.add(par);
				}
			}
			if(parcels.size()>0){
				parcelMapper.insertListParcel(parcels);
			}
			
			//增加项目完成情况记录
			ProjectCompletion pc = projectCompletionMapper.getProjectCompletionByProjectId(project.getProjectId());
			if(pc != null){
				pc.setAreaType(1);
				projectCompletionMapper.updateProjectCompletion(pc);
			}else{
				pc = new ProjectCompletion();
				pc.setId(UUID.randomUUID().toString());
				pc.setProjectId(project.getProjectId());
				pc.setCompanyId(project.getCompany());
				pc.setAreaType(1);
				projectCompletionMapper.insertProjectCompletion(pc);
			}
			String staffId = project.getStaffId();
			List<CorePosition> corePositions = corePositionMapper.getCorePositionBystaffId(staffId);
			String corePositionId = "";
			for(CorePosition cp : corePositions){
				if(cp.getState().equals((byte) 0)){
					corePositionId = cp.getCorePositionId();
				}
			}
			List<SpecialtyInfo> infoList = specialtyInfoMapper.listAllSpecialtyInfo();
			String professionalLineId = "";
			for(SpecialtyInfo si : infoList){
				if(si.getSpecialtyName().equals("项目")){
					professionalLineId = si.getSpecialtyId();
				}
			}
			TeamPermissions tpToSelect = new TeamPermissions();
			tpToSelect.setProjectId(project.getProjectId());
			tpToSelect.setProfessionalLineId(professionalLineId);
			TeamPermissions tp = teamPermissionsMapper.getCorePositionByProjectAndSpecialty(tpToSelect);
			if(tp != null){
				tp.setStaffId(project.getStaffId());
				tp.setCorePositionId(corePositionId);
				teamPermissionsMapper.updateTeamPermissions(tp);				
			}
		}
	}
	@Override
	public void deleteProjectrest(String projectId) {
		// TODO Auto-generated method stub
		
		projectMapper.deleteProjectById(projectId);
	}
	@Override
	public List<Project> getProjectbyteamworkId(String teamworkId) {
		// TODO Auto-generated method stub
		return projectMapper.getProjectbyteamworkId(teamworkId);
	}
	
	@Override
	public void ProjectInitialization(ProjectResult projectResult) {
		// TODO 自动生成的方法存根
		//UUID projectUuid=UUID.randomUUID();
		Project project=projectResult.getProject();
		String staffId = project.getStaffId();
		project.setSortDate(DateUtil.currentDate());
		//project.setProjectId(projectUuid.toString());
		project.setState(0);
		String num=projectMapper.selectProjectCode();		
		if(num==null||num.equals("")){
			num="001";			
		}else{
			num=String.valueOf(Integer.parseInt(num)+1);
			for(int i = num.length(); i < 3; i ++){//循环补0
				num = "0"+num;
			}
		}
		project.setProjectNumber(num);//项目编号
		if(projectMapper.insertProject(project)>0){
			List<Prepare> prepares=new ArrayList<Prepare>();
			List<Parcel> parcels =new ArrayList<Parcel>();
			for (Prepare prepare : projectResult.getPrepares()) {
				Prepare p=prepare;
				p.setProjectId(project.getProjectId().toString());
				prepares.add(p);
			}
			if(prepares.size()>0){
				prepareMapper.insertListPrepare(prepares);
			}
			for(Parcel parcel :projectResult.getParcels() ){
				Parcel par=parcel;
				par.setProjectId(project.getProjectId().toString());
				parcels.add(par);
			}
			if(parcels.size()>0){
				parcelMapper.insertListParcel(parcels);
			}
			
			//增加项目完成情况记录
			ProjectCompletion pc = projectCompletionMapper.getProjectCompletionByProjectId(project.getProjectId());
			if(pc != null){
				pc.setAreaType(1);
				projectCompletionMapper.updateProjectCompletion(pc);
			}else{
				pc = new ProjectCompletion();
				pc.setId(UUID.randomUUID().toString());
				pc.setProjectId(project.getProjectId());
				pc.setCompanyId(project.getCompany());
				pc.setAreaType(1);
				projectCompletionMapper.insertProjectCompletion(pc);
			}
			//向team_permissions表添加数据
			List<CorePosition> corePositions = corePositionMapper.getCorePositionBystaffId(staffId);
			String corePositionId = "";
			for(CorePosition cp : corePositions){
				if(cp.getState().equals((byte) 0)){
					corePositionId = cp.getCorePositionId();
				}
			}
			List<SpecialtyInfo> infoList = specialtyInfoMapper.listAllSpecialtyInfo();
			String professionalLineId = "";
			for(SpecialtyInfo si : infoList){
				if(si.getSpecialtyName().equals("项目")){
					professionalLineId = si.getSpecialtyId();
				}
			}
			
			TeamPermissions tp = new TeamPermissions();
			tp.setTeamPermissionsId(UUID.randomUUID().toString());
			tp.setProjectId(project.getProjectId());
			tp.setProfessionalLineId(professionalLineId);
			tp.setStaffId(staffId);
			tp.setCorePositionId(corePositionId);
			teamPermissionsMapper.insertTeamPermissions(tp);
		}
	}
	
	
	@Override
	public List<Tree> getStaffTree() {
		List<Tree> treeList = new ArrayList<Tree>();
		//获取所有的项目信息
		List<Project> plist = projectMapper.listAllProject();
		//获取专业线信息
		List<SpecialtyInfo> infoList = specialtyInfoMapper.listAllSpecialtyInfo();
		//遍历项目集合
		if(plist!=null && plist.size()>0){
			for(Project p : plist){
				List<Tree> t1 = new ArrayList<Tree>();
				Tree tree = new Tree();
				tree.setId(p.getProjectId());
				tree.setName(p.getProjectName());
				tree.setpId("0");
//				treeList.add(tree);
				//专业线
				if(infoList!=null && infoList.size()>0){
					for(SpecialtyInfo info : infoList){
						List<Tree> t2 = new ArrayList<Tree>();
						Tree tree1 = new Tree();
						tree1.setId(info.getSpecialtyId());
						tree1.setName(info.getSpecialtyName());
						tree1.setpId(p.getProjectId());
//						treeList.add(tree1);
						
						List<Teamworkstaff> tlist = teamworkstaffMapper.getTeamworkstaffbyProjectAndSpecial(p.getProjectId(), info.getSpecialtyId());
						if(tlist!=null && tlist.size()>0){
							for(Teamworkstaff t : tlist){
								if(t.getStaff()!=null){//判断是否有该员工
									Tree tree2 = new Tree();
									tree2.setId(t.getStaffId());
									tree2.setName(t.getStaff().getStaffName());
									tree2.setpId(info.getSpecialtyId());
	//								treeList.add(tree2);
									t2.add(tree2);
								}
							}
							tree1.setChildren(t2);
						}
						t1.add(tree1);
					}
					tree.setChildren(t1);
				}
				treeList.add(tree);
			}
			return treeList;
		}
		return null;
	}
	
	@Override
	public PageRestful listPageProject(Project project) {
		// TODO Auto-generated method stub
		PageRestful pageRestful =new PageRestful();
		List<Project> projectList=projectMapper.listPageProject(project);
		projectList.add(0,null);
	//	projectList.add(1,projectMapper.getProjectByState());
		pageRestful.setProject(projectList);
		pageRestful.setPage(project.getPage());
		return pageRestful;
	}
	
	@Override
	public PageRestful listPageProjectByState(Project project) {
		// TODO Auto-generated method stub
		PageRestful pageRestful =new PageRestful();
		List<Project> projectList=projectMapper.listPageProjectByState(project);
		projectList.add(0,null);
	//	projectList.add(1,projectMapper.getProjectByState());
		pageRestful.setProject(projectList);
		pageRestful.setPage(project.getPage());
		return pageRestful;
	}
	
	
	@Override
	public List<Project> selectAllProject(){
		return projectMapper.selectAllProject();
	}
	
	@Override
	public String getUSeSystemCount(){
		Map<String, Integer> map = new HashMap<String, Integer>();
		//获取查询是否启用收费管理结果集
		List<String> isUseSystem = projectMapper.getUSeSystemCount();
		int totalcount = isUseSystem.size();
		//遍历结果集，等于0的为已启用项目
		int isusecount = 0;
		for(String i : isUseSystem){
			if(i!=null && Integer.parseInt(i) == 0){
				isusecount++;
			}
		}
		//未启用计费项目
		int notusecount = totalcount - isusecount;
		//将结果放入map
		map.put("totalcount", totalcount);
		map.put("isusecount", isusecount);
		map.put("notusecount", notusecount);
		//传到前端
		return JSONObject.fromObject(map).toString();
	}
	
	@Override
	public List<Project> getAllProjectWithRegion(String companyId) {
		// TODO Auto-generated method stub
		return projectMapper.getAllProjectWithRegion(companyId);
	}
	@Override
	public void deleteSubProject(Project project) {
		// TODO Auto-generated method stub
		List<String> list = project.getSubProjectIds();
		String state=project.getState().toString();
		for (String sId : list) {
			if(sId != null && !"".equals(sId)){
				projectMapper.deleteSubProject(state,sId);
			
			}
		}
	}
	@Override
	public Project getProjectByState() {
		// TODO Auto-generated method stub
		return projectMapper.getProjectByState();
	}
	@Override
	public String getProjectByCompany(String company) {
		if(Tools.notEmpty(company)){
			List<String> plist = projectMapper.getProjectByCompanyId(company);
			JSONArray json = JSONArray.fromObject(plist);
			return json.toString();
		}
		return null;
	}
	@Override
	public String getProjectName(String projectId) {
		return projectMapper.getProject(projectId).getProjectName();
	}
	
	@Override
	public PageRestful listPageProjectAll(Project project) {
		PageRestful pageRestful =new PageRestful();
		List<Project> projectList=projectMapper.listPageProjectAll(project);
		projectList.add(0,null);
		pageRestful.setProject(projectList);
		pageRestful.setPage(project.getPage());
		return pageRestful;
	}
	
	@Override
	public String getProjectListByUser(String userName) {
		List<Project> projectList = projectMapper.selectProjectByUser(userName);
		if(projectList.size()>0){
			return JsonUtil.success(projectList, true);
		}
		return JsonUtil.failure("未查询到项目信息", false);
	}
	
	@Override
	public String getCompanyIdByProjectIid(String projectId) {
		Project project = projectMapper.getProject(projectId);
		return project.getCompany();
	}
	@Override
	public String updateIsUseSystemByProjectId(Project project) {
		String result = "0";
		if("0".equals(project.getIsUseSystem())){
			project.setIsUseSystem("1");
		}else{
			project.setIsUseSystem("0");
		}
		try {
			projectMapper.updateIsUseSystemByProjectId(project);
			result = "1";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public List<Project> getAllProjectByProjectIds(List<String> projectIds) {
		return projectMapper.getAllProjectByProjectIds(projectIds);
	}

	@Override
	public PageRestful listPageAllsubCompanyProject(SubCompany subCompany) {
		PageRestful pageRestful = new PageRestful();
		List<Project> projects = projectMapper.listPageAllsubCompanyProject(subCompany);
		projects.add(0, null);
		pageRestful.setProject(projects);
		pageRestful.setPage(subCompany.getPage());
		return pageRestful;
	}

	@Override
	public PageRestful listPageProjectByCompany(Project project) {
		// TODO Auto-generated method stub
		PageRestful pageRestful = new PageRestful();
		List<Project> projects = projectMapper.listPageProjectByCompany(project);
		projects.add(0,null);
		pageRestful.setProject(projects);
		pageRestful.setPage(project.getPage());
		return pageRestful;
	}

}
