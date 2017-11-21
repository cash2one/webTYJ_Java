package com.flf.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.flf.entity.CorePosition;
import com.flf.entity.PageRestful;
import com.flf.entity.Post;
import com.flf.entity.SpecialtyInfo;
import com.flf.entity.TeamPermissions;
import com.flf.entity.Teamwork;
import com.flf.entity.Teamworkstaff;
import com.flf.mapper.CorePositionMapper;
import com.flf.mapper.SpecialtyInfoMapper;
import com.flf.mapper.TeamPermissionsMapper;
import com.flf.mapper.TeamworkMapper;
import com.flf.mapper.TeamworkstaffMapper;
import com.flf.request.Info;
import com.flf.service.CorePositionService;
import com.flf.service.PostService;
import com.flf.util.Tools;

public class CorePositionServiceImpl implements CorePositionService {
	
private CorePositionMapper corePositionMapper;
	
	private TeamworkMapper teamworkMapper;
	
	private PostService postService;
	
	private SpecialtyInfoMapper specialtyInfoMapper;
	
	private TeamworkstaffMapper teamworkstaffMapper;
	
	private TeamPermissionsMapper teamPermissionsMapper;

	public TeamPermissionsMapper getTeamPermissionsMapper() {
		return teamPermissionsMapper;
	}

	public void setTeamPermissionsMapper(TeamPermissionsMapper teamPermissionsMapper) {
		this.teamPermissionsMapper = teamPermissionsMapper;
	}

	public TeamworkstaffMapper getTeamworkstaffMapper() {
		return teamworkstaffMapper;
	}

	public void setTeamworkstaffMapper(TeamworkstaffMapper teamworkstaffMapper) {
		this.teamworkstaffMapper = teamworkstaffMapper;
	}

	public PostService getPostService() {
		return postService;
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	public TeamworkMapper getTeamworkMapper() {
		return teamworkMapper;
	}

	public void setTeamworkMapper(TeamworkMapper teamworkMapper) {
		this.teamworkMapper = teamworkMapper;
	}

	public CorePositionMapper getCorePositionMapper() {
		return corePositionMapper;
	}

	public void setCorePositionMapper(CorePositionMapper corePositionMapper) {
		this.corePositionMapper = corePositionMapper;
	}

	public SpecialtyInfoMapper getSpecialtyInfoMapper() {
		return specialtyInfoMapper;
	}

	public void setSpecialtyInfoMapper(SpecialtyInfoMapper specialtyInfoMapper) {
		this.specialtyInfoMapper = specialtyInfoMapper;
	}

	@Override
	public void AddCorePosition(CorePosition corePosition) {
		// TODO Auto-generated method stub
		String uuid= UUID.randomUUID().toString();
		corePosition.setCorePositionId(uuid);
		corePosition.setCreateTime(new Date());
		corePositionMapper.insertCorePosition(corePosition);
		//判断此员工是否已存在团队，如果有，不新增团队，如果没有，则新增团队  王洲   2016.1.26
		List<Teamwork> teamworkList = teamworkMapper.getTeamworkBystaffId(corePosition.getStaffId());
		//判断此员工是否已有团队
		if(teamworkList.size() == 0 ){
			Teamwork teamwork=new Teamwork();
			String uuid1= UUID.randomUUID().toString();
			teamwork.setId(uuid1);
			teamwork.setLeader(corePosition.getStaffId());
			teamwork.setCorePositionId(corePosition.getCorePositionId());
			teamworkMapper.insertTeamwork(teamwork);			
		}
	}

	@Override
	public List<CorePosition> listCorePost() {
		// TODO Auto-generated method stub
		CorePosition corePosition=new CorePosition();
		List<Post> post =new ArrayList<Post>();
		//查询核心岗位
		post=postService.listPostbyState();
		corePosition.setPost(post);
		List<CorePosition> corePositions=new ArrayList<CorePosition>();
		List<CorePosition> corePositionss=new ArrayList<CorePosition>();
		//判断核心岗位集合是否为空
		if(corePosition.getPost() != null){
			//循环核心岗位集合
			for(Post s: corePosition.getPost()){
				corePosition.setPostId(s.getPostId());
				corePosition.setState((byte) 1);
				corePositions=corePositionMapper.listCorePost(corePosition);
				corePositionss.addAll(corePositions);
				}			
		}
		return corePositionss;
	}

	@Override
	public List<CorePosition> listCorePostbyState() {
		// TODO Auto-generated method stub
		return corePositionMapper.listAllCorePosition();
	}

	@Override
	public List<CorePosition> listAllCorePost() {
		// TODO Auto-generated method stub
		CorePosition corePosition=new CorePosition();
		List<Post> post =new ArrayList<Post>();
		post=postService.listPostbyState();
		corePosition.setPost(post);
		List<CorePosition> corePositions=new ArrayList<CorePosition>();
		List<CorePosition> corePositionss=new ArrayList<CorePosition>();
		//判断核心岗位集合是否为空
		if(corePosition.getPost() != null){
			//循环核心岗位id集合
			for(Post s: corePosition.getPost()){
				corePosition.setPostId(s.getPostId());
				corePositions=corePositionMapper.listCorePost(corePosition);				
			}
			corePositionss.addAll(corePositions);
		}
		return corePositionss;
	}

	@Override
	public PageRestful listPageCorePositionRestful(CorePosition corePosition) {
		// TODO Auto-generated method stub
		PageRestful pageRestful=new PageRestful();
		List<CorePosition> corePositions =corePositionMapper.listPageCorePosition(corePosition);
		corePositions.add(0,null);				
		pageRestful.setCorePositions(corePositions);
		pageRestful.setPage(corePosition.getPage());
		return pageRestful;
	}

	@Override
	public List<CorePosition> listAllCorePositionRes() {
		// TODO Auto-generated method stub
		List<CorePosition> corePositions =corePositionMapper.listAllCorePositionRes();

		return corePositions;
	}

	@Override
	public List<CorePosition> listCorePositionBySid(String specialtyId){
		List<CorePosition> returnList = new ArrayList<CorePosition>();
		//查询专业线信息,将专业线名称与专业线id放入map
		Map<String, String> specialtyMap = new HashMap<String, String>();
		List<SpecialtyInfo> specialtyList = specialtyInfoMapper.listAllSpecialtyInfo();
		for(SpecialtyInfo si : specialtyList){
			specialtyMap.put(si.getSpecialtyId(), si.getSpecialtyName());
		}
		//判断传入的专业线id是项目，还是专业线
		if(specialtyMap.get(specialtyId).equals("项目")){
			//当查询项目时，查询岗位对应为项目的核心团队
			returnList = corePositionMapper.listAllCorePosition();
		//当查询专业线时，查询专业线核心团队和项目经理
		}else{
			CorePosition cp = new CorePosition();
			cp.setPostId(specialtyId);
			returnList = corePositionMapper.listAllCorePosition();
			List<CorePosition> list1 = corePositionMapper.listCorePost(cp);
			//判断经理和项目经理是否重复 朱琪 2016-2-18
			for (CorePosition corePosition : list1) {
				int i = 0;
				for (CorePosition corePosition2 : returnList) {
					if (corePosition2.getStaffId().equals(corePosition.getStaffId())){
						i ++;
					}
				}
				if(i == 0){
					returnList.add(corePosition);
				}
			}
		}
		return returnList;
	}

	@Override
	public void deleteCorePositionRes(String cpid) {
	
		//获取此核心岗位的leader，根据此leader的剩余核心岗位数据判断是否删除团队  王洲  2016.1.26
		CorePosition corePosition = corePositionMapper.getCorePositionbyId(cpid);
		List<CorePosition> cpList = corePositionMapper.getCorePositionBystaffId(corePosition.getStaffId());
		
		corePositionMapper.deleteCorePositionRes(cpid);//根据核心岗位id删除核心人员
		
		if(cpList.size() == 1){
			List<Teamwork> teamwork=teamworkMapper.getTeamworkbyLeader(cpList.get(0).getStaffId());
			List<Teamworkstaff> teamworkstaffes=teamworkstaffMapper.getTeamworkstaffbyTeamworkId(teamwork.get(0).getId());
			
			if(teamworkstaffes != null && teamworkstaffes.size() > 0){
				teamworkstaffMapper.deleteByTeamworkId(teamwork.get(0).getId());	//删除团队编制
			}
			
			List<TeamPermissions> teamPermissionses=teamPermissionsMapper.getTeamPermissionsByTeamworkId(teamwork.get(0).getId());	 
			
			if(teamPermissionses!=null && teamPermissionses.size()>0){
				teamPermissionsMapper.deleteTeamPermissionsByTeamworkId(teamwork.get(0).getId());			 
			}
			teamworkMapper.deleteTeamwork(teamwork.get(0).getId());		
		}
	}
	
	
	/**
	 * 根据登录的员工id查询是否存在核心岗位
	 * 如果有核心岗位判断是专业线经理还是项目经理
	 * 王洲
	 * 2016.1.26
	 */
	@Override
	public Info checkCorePositionByStaffId(String staffId){
		//根据传入的staffId查询是否此员工关联的核心岗位
		List<CorePosition> cpList = corePositionMapper.getCorePositionBystaffId(staffId);
		if(cpList.size() == 0){
			return Tools.msg("not coreposition", false);
		}else{
			int num = 0;
			for(CorePosition cp : cpList){
				if(cp.getState() == 0){
					num++;
				}
			}
			if(num == 0){
				return Tools.msg("0", true);
			}else{
				return Tools.msg("1", true);
			}
		}
	}

	@Override
	public List<CorePosition> listAllCorePositionByCore(
			CorePosition corePosition) {
		List<CorePosition> corePositions =corePositionMapper.listAllCorePositionByCore(corePosition);
		return corePositions;
	}
	
}
