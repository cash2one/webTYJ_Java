package com.flf.service.impl;

import java.util.UUID;

import com.flf.entity.ProjectCompletion;
import com.flf.mapper.ProjectCompletionMapper;
import com.flf.mapper.ProjectMapper;
import com.flf.request.Info;
import com.flf.service.ProjectCompletionService;
import com.flf.util.Tools;

public class ProjectCompletionServiceImpl implements ProjectCompletionService {
	
	private ProjectCompletionMapper projectCompletionMapper;
	
	private ProjectMapper projectMapper;

	@Override
	public Info changeStateByProjectIdAndParamTypes(String projectId,
			String paramTypes) {
		
		//查询记录
		ProjectCompletion pc = projectCompletionMapper.getProjectCompletionByProjectId(projectId);
		
		//无记录时新增
		if(pc == null){
			pc = new ProjectCompletion();
			pc.setId(UUID.randomUUID().toString());
			pc.setProjectId(projectId);
			pc.setCompanyId(projectMapper.getProject(projectId).getCompany());
			pc.setAreaType(1);
			if(paramTypes.toString().equals("building")){
				pc.setBuilding(1);
			}else if(paramTypes.toString().equals("person")){
				pc.setPerson(1);
			}else if(paramTypes.toString().equals("enterprise")){
				pc.setEnterprise(1);
			}else if(paramTypes.toString().equals("assetBinding")){
				pc.setAssetbinding(1);
			}
			try {
				projectCompletionMapper.insertProjectCompletion(pc);
				return Tools.msg("success", true);
			} catch (Exception e) {
				e.printStackTrace();
				return Tools.msg("fail", false);
			}
		}else {
			if(paramTypes.toString().equals("building")){
				pc.setBuilding(1);
			}else if(paramTypes.toString().equals("person")){
				pc.setPerson(1);
			}else if(paramTypes.toString().equals("enterprise")){
				pc.setEnterprise(1);
			}else if(paramTypes.toString().equals("assetBinding")){
				pc.setAssetbinding(1);
			}
			try {
				projectCompletionMapper.updateProjectCompletion(pc);
				return Tools.msg("success", true);
			} catch (Exception e) {
				e.printStackTrace();
				return Tools.msg("fail", false);
			}
		}
	}

	public ProjectCompletionMapper getProjectCompletionMapper() {
		return projectCompletionMapper;
	}

	public void setProjectCompletionMapper(
			ProjectCompletionMapper projectCompletionMapper) {
		this.projectCompletionMapper = projectCompletionMapper;
	}

	public ProjectMapper getProjectMapper() {
		return projectMapper;
	}

	public void setProjectMapper(ProjectMapper projectMapper) {
		this.projectMapper = projectMapper;
	}

}
