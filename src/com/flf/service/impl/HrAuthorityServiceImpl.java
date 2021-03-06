package com.flf.service.impl;

import java.util.List;

import com.flf.entity.HrAuthority;
import com.flf.mapper.HrAuthorityMapper;
import com.flf.service.HrAuthorityService;

public class HrAuthorityServiceImpl implements HrAuthorityService{
	
	private HrAuthorityMapper hrAuthorityMapper;

	@Override
	public List<HrAuthority> getHrAuthorityByUserId(String userId) {
		return hrAuthorityMapper.getHrAuthorityByUserId(userId);
	}

	public HrAuthorityMapper getHrAuthorityMapper() {
		return hrAuthorityMapper;
	}

	public void setHrAuthorityMapper(HrAuthorityMapper hrAuthorityMapper) {
		this.hrAuthorityMapper = hrAuthorityMapper;
	}
	

}
