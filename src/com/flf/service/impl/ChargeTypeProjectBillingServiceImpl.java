package com.flf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.flf.entity.ChargeType;
import com.flf.entity.ChargeTypeProjectBilling;
import com.flf.entity.PageRestful;
import com.flf.entity.Project;
import com.flf.entity.ProjectBilling;
import com.flf.mapper.ChargeTypeMapper;
import com.flf.mapper.ChargeTypeProjectBillingMapper;
import com.flf.mapper.ProjectBillingMapper;
import com.flf.mapper.ProjectMapper;
import com.flf.service.ChargeTypeProjectBillingService;
/**
 * @author maogaofei
 * @date 2016年7月9日 下午2:47:03
 */
public class ChargeTypeProjectBillingServiceImpl implements ChargeTypeProjectBillingService {
	
	private ChargeTypeProjectBillingMapper chargeTypeProjectBillingMapper;
	@Autowired
	private ProjectBillingMapper projectBillingMapper;
	@Autowired
	private ProjectMapper projectMapper;
	@Autowired
	private ChargeTypeMapper chargeTypeMapper;

	public ChargeTypeProjectBillingMapper getChargeTypeProjectBillingMapper() {
		return chargeTypeProjectBillingMapper;
	}

	public void setChargeTypeProjectBillingMapper(
			ChargeTypeProjectBillingMapper chargeTypeProjectBillingMapper) {
		this.chargeTypeProjectBillingMapper = chargeTypeProjectBillingMapper;
	}

	@Override
	public PageRestful listPageChargeTypeProjectBilling(
			ChargeTypeProjectBilling chargeTypeProjectBilling) {
		PageRestful pageRestful=new PageRestful();
		List<ChargeTypeProjectBilling> chargeTypeProjectBillings = chargeTypeProjectBillingMapper.listPageChargeTypeProjectBilling(chargeTypeProjectBilling);
		for(ChargeTypeProjectBilling cpb:chargeTypeProjectBillings){
			ProjectBilling projectBilling = projectBillingMapper.selectByPrimaryKey(cpb.getProjectBillingId());
			Project project = projectMapper.getProject(projectBilling.getProjectId());
			ChargeType chargeType = chargeTypeMapper.selectByPrimaryKey(cpb.getChargeTypeId());
			cpb.setMonth(projectBilling.getMonth());
			cpb.setProjectName(project.getProjectName());
			cpb.setChargeTypeName(chargeType.getChargeTypeName());
		}
		chargeTypeProjectBillings.add(0,null);
		pageRestful.setChargeTypeProjectBillings(chargeTypeProjectBillings);
		pageRestful.setPage(chargeTypeProjectBilling.getPage());
		return pageRestful;
	}
}
