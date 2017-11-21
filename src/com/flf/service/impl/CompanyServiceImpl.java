package com.flf.service.impl;

import java.util.List;

import com.flf.entity.Company;
import com.flf.entity.Project;
import com.flf.entity.Staff;
import com.flf.mapper.CompanyMapper;
import com.flf.mapper.ProjectMapper;
import com.flf.mapper.StaffMapper;
import com.flf.service.CompanyService;

public class CompanyServiceImpl implements CompanyService {
	private CompanyMapper companyMapper;
	
	private ProjectMapper projectMapper;
	
	private StaffMapper staffMapper;

	public CompanyMapper getCompanyMapper() {
		return companyMapper;
	}

	public void setCompanyMapper(CompanyMapper companyMapper) {
		this.companyMapper = companyMapper;
	}

	public ProjectMapper getProjectMapper() {
		return projectMapper;
	}

	public void setProjectMapper(ProjectMapper projectMapper) {
		this.projectMapper = projectMapper;
	}

	public StaffMapper getStaffMapper() {
		return staffMapper;
	}

	public void setStaffMapper(StaffMapper staffMapper) {
		this.staffMapper = staffMapper;
	}

	@Override
	public List<Company> listAllCompany() {
		// TODO Auto-generated method stub
		return companyMapper.listAllCompany();
	}

	@Override
	public void insertCompany(Company company) {
		// TODO Auto-generated method stub
		companyMapper.insertCompany(company);
	}

	@Override
	public Company getCompanyById(String companyId) {
		// TODO Auto-generated method stub
		return companyMapper.getCompanyById(companyId);
	}
	
	@Override
	public Company getCompanyByprojectId(String projectId){
		return companyMapper.getCompanyByprojectId(projectId);
	}

	@Override
	public Company getCompanyInformation(String companyId){
		
		//初始化传出对象
		Company company = new Company();
		company.setCompanyId(companyId);
		
		//获取公司基本信息
		company = companyMapper.getCompanyById(companyId);
		
		//获取公司下的所有有效项目
		List<Project> project = projectMapper.getAllProjectByCompanyId(companyId);
		
		//获取公司下的所有项目的总占地面积
		double projectarea = 0.0;
		for(int i = 0; i < project.size(); i++){
			projectarea = projectarea + project.get(i).getProjectTotalarea();
		}
		
		//获取公司下的所有员工
		List<Staff> staff = staffMapper.getStaffByCompanyId(companyId);
		
		//将公司的项目信息和员工信息放入对象
		project.add(0,null);
		if(company!=null){
			company.setProjectList(project);
			company.setProjectNum(project.size()-1);
			company.setStaffNum(staff.size());
			company.setProjectArea(projectarea);
		}
		return company;
	}
	
}