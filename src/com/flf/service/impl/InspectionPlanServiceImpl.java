package com.flf.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.flf.entity.InspectionPlan;
import com.flf.entity.InspectionPropertyCheckItem;
import com.flf.entity.PageRestful;
import com.flf.mapper.InspectionPlanMapper;
import com.flf.mapper.InspectionPropertyCheckItemMapper;
import com.flf.service.InspectionPlanService;

public class InspectionPlanServiceImpl implements InspectionPlanService{

	private InspectionPlanMapper inspectionPlanMapper;
	
	private InspectionPropertyCheckItemMapper inspectionPropertyCheckItemMapper;

	public InspectionPropertyCheckItemMapper getInspectionPropertyCheckItemMapper() {
		return inspectionPropertyCheckItemMapper;
	}

	public void setInspectionPropertyCheckItemMapper(
			InspectionPropertyCheckItemMapper inspectionPropertyCheckItemMapper) {
		this.inspectionPropertyCheckItemMapper = inspectionPropertyCheckItemMapper;
	}

	public InspectionPlanMapper getInspectionPlanMapper() {
		return inspectionPlanMapper;
	}

	public void setInspectionPlanMapper(InspectionPlanMapper inspectionPlanMapper) {
		this.inspectionPlanMapper = inspectionPlanMapper;
	}

	/**
	 * 新增巡检方案
	 */
	@Override
	public void insert(InspectionPlan inspectionPlan) {
		// TODO Auto-generated method stub
		String uuid= UUID.randomUUID().toString();
		inspectionPlan.setInspectionPlanId(uuid);
		inspectionPlan.setCreateTime(new Date());
		inspectionPlan.setState((byte) 1);//有效
		inspectionPlanMapper.insert(inspectionPlan);
		if(inspectionPlan.gettList()!= null && inspectionPlan.gettList().size() > 0){
			for(InspectionPropertyCheckItem ipc :inspectionPlan.gettList()){
				ipc.setInspectionCheckItemId(UUID.randomUUID().toString());
				ipc.setInspectionPlanId(uuid);
				inspectionPropertyCheckItemMapper.insert(ipc);
			}
		}
		
	}
	
	//查询所有的巡检方案
	@Override
	public List<InspectionPlan> listAllInspectionPlan() {
		// TODO Auto-generated method stub
		return inspectionPlanMapper.listAllInspectionPlan();
	}
	
	//查询有效的巡检方案
	@Override
	public PageRestful listPageInspectionPlanByStateRestful(
			InspectionPlan inspectionPlan) {
		// TODO Auto-generated method stub
		PageRestful pageRestful = new PageRestful();
		List<InspectionPlan> inspectionPlans = inspectionPlanMapper.listPageInspectionPlanByState(inspectionPlan);
		inspectionPlans.add(0,null);
		pageRestful.setInspectionPlan(inspectionPlans);
		pageRestful.setPage(inspectionPlan.getPage());
		return pageRestful;
	}
	
	//修改
	@Override
	public void updateByPrimaryKeySelective(InspectionPlan inspectionPlan) {
		// TODO Auto-generated method stub
		inspectionPlanMapper.updateByPrimaryKeySelective(inspectionPlan);
	}

	@Override
	public List<InspectionPlan> listAllInspectionPlan1(String state) {
		// TODO Auto-generated method stub
		return inspectionPlanMapper.listAllInspectionPlan1(state);
	}

	@Override
	public InspectionPlan getInspectionPlan1(String inspectionPlanId) {
		
		return inspectionPlanMapper.getInspectionPlan1(inspectionPlanId);
	}
	
	

	

	
}
