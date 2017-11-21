package com.flf.mapper;

import java.util.List;

import com.flf.entity.Company;

public interface CompanyMapper {
	
	int insertCompany(Company company); //新增公司
	
	Company getCompanyById(String companyId); //通过公司Id查询公司信息
	
	List<Company> listAllCompany();  //查询所有的公司

	Company getCompanyByprojectId(String projectId);	//通过下属项目id查询对应的公司信息
}
