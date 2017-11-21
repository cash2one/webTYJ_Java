package com.flf.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;




import com.flf.entity.PageRestful;
import com.flf.entity.Post;
import com.flf.entity.Prepare;
import com.flf.entity.Project;
import com.flf.entity.SpecialtyInfo;
import com.flf.entity.SpecialtyInfoProject;
import com.flf.mapper.PostMapper;
import com.flf.mapper.PrepareMapper;
import com.flf.mapper.ProjectMapper;
import com.flf.mapper.SpecialtyInfoMapper;
import com.flf.mapper.SpecialtyInfoProjectMapper;
import com.flf.request.SpecialtyInfoResult;
import com.flf.service.SpecialtyInfoProjectService;
import com.flf.service.SpecialtyInfoService;


public class SpecialtyInfoProjectServiceImpl implements SpecialtyInfoProjectService{
	
	private SpecialtyInfoProjectMapper specialtyInfoProjectMapper;
	
	private PostMapper postMapper;
	
	private ProjectMapper projectMapper;
	
	private SpecialtyInfoMapper specialtyInfoMapper;
	
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

	public SpecialtyInfoProjectMapper getSpecialtyInfoProjectMapper() {
		return specialtyInfoProjectMapper;
	}

	public void setSpecialtyInfoProjectMapper(SpecialtyInfoProjectMapper specialtyInfoProjectMapper) {
		this.specialtyInfoProjectMapper = specialtyInfoProjectMapper;
	}

	public PostMapper getPostMapper() {
		return postMapper;
	}

	public void setPostMapper(PostMapper postMapper) {
		this.postMapper = postMapper;
	}

	@Override
	public List<SpecialtyInfoProject> listSpecialtyInfoProject() {
		// TODO Auto-generated method stub
		return specialtyInfoProjectMapper.listSpecialtyInfoProject();
	}

	@Override
	public void deleteSpecialtyInfoProjectRestful(String specialtyId) {
		// TODO Auto-generated method stub
		specialtyInfoProjectMapper.deleteByPrimaryKey(specialtyId);
	}

	@Override
	public void insertSpecialtyInfoProjectRestful(SpecialtyInfoProject specialtyInfoProject) {
		// TODO Auto-generated method stub
		specialtyInfoProjectMapper.insert(specialtyInfoProject);
	}

	@Override
	public void updateSpecialtyInfoProjectbystate(SpecialtyInfoProject specialtyInfoProject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateListSpecialtyInfoProject(SpecialtyInfoProject specialtyInfoProject) {
		// TODO Auto-generated method stub
		specialtyInfoProjectMapper.updateByPrimaryKeySelective(specialtyInfoProject);
		List<Post> listPost=postMapper.getPostBySpecialtyId(specialtyInfoProject.getSpecialtyId());
		for(Post posts:listPost){
			if(specialtyInfoProject.getState()==1){
				posts.setState(Byte.valueOf("1"));
			}else{
				posts.setState(Byte.valueOf("0"));
			}
			postMapper.updatePostByState(posts);
		}
	}

	@Override
	public List<SpecialtyInfoProject> listAllSpecialtyInfoProjectAndPostOpen(String projectId) {
		// TODO Auto-generated method stub
		return specialtyInfoProjectMapper.listSpecialtyInfoProjectOpen(projectId);
	}

	@Override
	public List<SpecialtyInfoProject> listSpecialtyInfoProjectByCompanyId(String companyId, String specialtyId) {
		// TODO Auto-generated method stub
		return specialtyInfoProjectMapper.listSpecialtyInfoProjectByCompanyId(companyId, specialtyId);
	}

	@Override
	public List<SpecialtyInfoProject> listSpecialtyInfoProjectByProjectId(String projectId) {
		// TODO Auto-generated method stub
		return specialtyInfoProjectMapper.listSpecialtyInfoProjectByProjectId(projectId);
	}

	@Override
	public void initExistedProjectProfessionalLine() {
		// TODO Auto-generated method stub
		SpecialtyInfoProject specialtyInfoProject = new SpecialtyInfoProject();
		List<Project> projectList = projectMapper.listAllProject();
		List<SpecialtyInfo> specialtyInfos = specialtyInfoMapper.listAllSpecialtyInfoAndPostOpen();
		for(Project project : projectList){
			specialtyInfoProject.setProjectId(project.getProjectId());
			for(SpecialtyInfo specialtyInfo : specialtyInfos){
				specialtyInfoProject.setSpecialtyName(specialtyInfo.getSpecialtyName());
				specialtyInfoProject.setSpecialtyDescrible(specialtyInfo.getSpecialtyDescrible());
				specialtyInfoProject.setInstanceId(specialtyInfo.getInstanceId());
				specialtyInfoProject.setState(specialtyInfo.getState());
				specialtyInfoProject.setWillOptions(specialtyInfo.getWillOptions());
				specialtyInfoProject.setCompanyId(specialtyInfo.getCompanyId());
				specialtyInfoProjectMapper.insert(specialtyInfoProject);
			}
		}
	}

}