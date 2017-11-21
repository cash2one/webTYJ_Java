package com.flf.service.impl;

import java.util.List;

import com.flf.entity.PageRestful;
import com.flf.entity.ProjectBilling;
import com.flf.mapper.ProjectBillingMapper;
import com.flf.service.ProjectBillingService;
/**
 * @author maogaofei
 * @date 2016年7月9日 下午2:47:03
 */
public class ProjectBillingServiceImpl implements ProjectBillingService {
	
	private ProjectBillingMapper projectBillingMapper;

	public ProjectBillingMapper getProjectBillingMapper() {
		return projectBillingMapper;
	}

	public void setProjectBillingMapper(ProjectBillingMapper projectBillingMapper) {
		this.projectBillingMapper = projectBillingMapper;
	}

	@Override
	public PageRestful listPageProjectBilling(ProjectBilling projectBilling) {
		PageRestful pageRestful=new PageRestful();
		List<ProjectBilling> projectBillings = projectBillingMapper.listPageProjectBilling(projectBilling);
		projectBillings.add(0,null);
		pageRestful.setProjectBillings(projectBillings);
		pageRestful.setPage(projectBilling.getPage());
		return pageRestful;
	}
}
