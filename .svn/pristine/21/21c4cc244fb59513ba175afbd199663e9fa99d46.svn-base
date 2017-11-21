package com.flf.service.impl;

import com.flf.entity.TUser;
import com.flf.mapper.TUserMapper;
import com.flf.service.UserServiceNew;

public class UserServiceNewImpl implements UserServiceNew{

	private TUserMapper tUserMapper;
	
	@Override
	public TUser getTUserbyLoginName(String loginName) {
		
		return tUserMapper.getTUserbyLoginName(loginName);
	}

	public TUserMapper gettUserMapper() {
		return tUserMapper;
	}

	public void settUserMapper(TUserMapper tUserMapper) {
		this.tUserMapper = tUserMapper;
	}
}
