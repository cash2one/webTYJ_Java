package com.flf.service.impl;

import java.util.List;

import com.flf.entity.AuthorizationProject;
import com.flf.mapper.AuthorizationProjectMapper;
import com.flf.service.AuthorizationProjectService;

public class AuthorizationProjectServiceImpl implements AuthorizationProjectService{

	private AuthorizationProjectMapper authorizationProjectMapper;
	
	public AuthorizationProjectMapper getAuthorizationProjectMapper() {
		return authorizationProjectMapper;
	}
	public void setAuthorizationProjectMapper(
			AuthorizationProjectMapper authorizationProjectMapper) {
		this.authorizationProjectMapper = authorizationProjectMapper;
	}
	@Override
	public List<AuthorizationProject> selectAllData() {
		// TODO Auto-generated method stub
		return authorizationProjectMapper.selectAllData();
	}

}
