package com.flf.service.impl;

import java.util.Date;
import java.util.List;

import com.flf.entity.Company;
import com.flf.entity.CompanyBankInfo;
import com.flf.entity.Project;
import com.flf.entity.Staff;
import com.flf.mapper.CompanyBankInfoMapper;
import com.flf.mapper.CompanyMapper;
import com.flf.mapper.ProjectMapper;
import com.flf.mapper.StaffMapper;
import com.flf.service.CompanyBankInfoService;
import com.flf.service.CompanyService;

public class CompanyBankInfoServiceImpl implements CompanyBankInfoService {

	private CompanyBankInfoMapper companyBankInfoMapper;
	
	public CompanyBankInfoMapper getCompanyBankInfoMapper() {
		return companyBankInfoMapper;
	}

	public void setCompanyBankInfoMapper(CompanyBankInfoMapper companyBankInfoMapper) {
		this.companyBankInfoMapper = companyBankInfoMapper;
	}

	@Override
	public CompanyBankInfo listCompanyBankInfo() {
		// TODO Auto-generated method stub
		return companyBankInfoMapper.listCompanyBankInfo();
	}

	@Override
	public void insertCompanyBankInfo(CompanyBankInfo companyBankInfo) {
		// TODO Auto-generated method stub
		companyBankInfo.setSetTime(new Date());
		companyBankInfoMapper.insert(companyBankInfo);
	}

	@Override
	public void updateCompanyBankInfo(CompanyBankInfo companyBankInfo) {
		// TODO Auto-generated method stub
		companyBankInfo.setSetTime(new Date());
		companyBankInfoMapper.updateByPrimaryKey(companyBankInfo);
	}
	
	
}
