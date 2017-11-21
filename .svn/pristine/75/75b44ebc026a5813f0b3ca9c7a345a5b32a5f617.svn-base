package com.flf.service.impl;

import java.util.List;
import java.util.UUID;

import com.flf.entity.Parcel;
import com.flf.mapper.ParcelMapper;
import com.flf.mapper.ProjectMapper;
import com.flf.service.ParcelService;

public class ParcelServiceImpl implements ParcelService {
	private ParcelMapper parcelMapper;//宗地
	private ProjectMapper projectMapper;//项目表

	
	public ProjectMapper getProjectMapper() {
		return projectMapper;
	}


	public void setProjectMapper(ProjectMapper projectMapper) {
		this.projectMapper = projectMapper;
	}


	public ParcelMapper getParcelMapper() {
		return parcelMapper;
	}


	public void setParcelMapper(ParcelMapper parcelMapper) {
		this.parcelMapper = parcelMapper;
	}


	@Override
	public Parcel insertParcel(Parcel parcel) {
		// TODO Auto-generated method stub
		
		
		return null;
	}


	@Override
	public List<Parcel> getParcelByprojectId(String projectId) {
		// TODO Auto-generated method stub
		return parcelMapper.selectByProjectId(projectId);
	}

}
