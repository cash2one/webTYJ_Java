package com.flf.service.impl;

import java.util.List;

import com.flf.entity.AuthorizationProjectType;
import com.flf.mapper.AuthorizationProjectTypeMapper;
import com.flf.service.AuthorizationProjectTypeService;

public class AuthorizationProjectTypeServiceImpl implements AuthorizationProjectTypeService{
	
	private AuthorizationProjectTypeMapper authorizationProjectTypeMapper;
	
										   
	public AuthorizationProjectTypeMapper getAuthorizationProjectTypeMapper() {
		return authorizationProjectTypeMapper;
	}


	public void setAuthorizationProjectTypeMapper(
			AuthorizationProjectTypeMapper authorizationProjectTypeMapper) {
		this.authorizationProjectTypeMapper = authorizationProjectTypeMapper;
	}


	@Override
	public List<AuthorizationProjectType> listAllData() {
		// TODO Auto-generated method stub
		return authorizationProjectTypeMapper.listAllData();
	}

}
