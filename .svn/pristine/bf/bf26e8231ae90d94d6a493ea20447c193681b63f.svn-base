package com.flf.service.impl;

import java.util.List;
import java.util.UUID;

import com.flf.entity.AreaTypeNew;
import com.flf.entity.BuildingStructureNew;
import com.flf.entity.IntakeActivity;
import com.flf.entity.IntakeActivityRelation;
import com.flf.entity.IntakeGiftRelation;
import com.flf.entity.PageRestful;
import com.flf.entity.PersonBuildingNew;
import com.flf.mapper.AreaTypeNewMapper;
import com.flf.mapper.BuildingStructureNewMapper;
import com.flf.mapper.IntakeActivityMapper;
import com.flf.mapper.IntakeActivityRelationMapper;
import com.flf.mapper.IntakeGiftRelationMapper;
import com.flf.mapper.PersonBuildingNewMapper;
import com.flf.service.IntakeActivityService;


public class IntakeActivityServiceImpl implements IntakeActivityService {

	private IntakeActivityMapper intakeActivityMapper;
	
	private IntakeActivityRelationMapper intakeActivityRelationMapper;
	
	private IntakeGiftRelationMapper intakeGiftRelationMapper;
	
	private AreaTypeNewMapper areaTypeNewMapper;//面积类型
	
	private BuildingStructureNewMapper buildingStructureNewMapper;//建筑结构
	
	private PersonBuildingNewMapper personBuildingNewMapper;//资产绑定

	public IntakeActivityRelationMapper getIntakeActivityRelationMapper() {
		return intakeActivityRelationMapper;
	}

	public void setIntakeActivityRelationMapper(
			IntakeActivityRelationMapper intakeActivityRelationMapper) {
		this.intakeActivityRelationMapper = intakeActivityRelationMapper;
	}

	public IntakeGiftRelationMapper getIntakeGiftRelationMapper() {
		return intakeGiftRelationMapper;
	}

	public void setIntakeGiftRelationMapper(
			IntakeGiftRelationMapper intakeGiftRelationMapper) {
		this.intakeGiftRelationMapper = intakeGiftRelationMapper;
	}

	public IntakeActivityMapper getIntakeActivityMapper() {
		return intakeActivityMapper;
	}

	public void setIntakeActivityMapper(IntakeActivityMapper intakeActivityMapper) {
		this.intakeActivityMapper = intakeActivityMapper;
	}

	public AreaTypeNewMapper getAreaTypeNewMapper() {
		return areaTypeNewMapper;
	}

	public void setAreaTypeNewMapper(AreaTypeNewMapper areaTypeNewMapper) {
		this.areaTypeNewMapper = areaTypeNewMapper;
	}

	public BuildingStructureNewMapper getBuildingStructureNewMapper() {
		return buildingStructureNewMapper;
	}

	public void setBuildingStructureNewMapper(
			BuildingStructureNewMapper buildingStructureNewMapper) {
		this.buildingStructureNewMapper = buildingStructureNewMapper;
	}

	public PersonBuildingNewMapper getPersonBuildingNewMapper() {
		return personBuildingNewMapper;
	}

	public void setPersonBuildingNewMapper(
			PersonBuildingNewMapper personBuildingNewMapper) {
		this.personBuildingNewMapper = personBuildingNewMapper;
	}
	

	@Override
	public void insertIntakeActivity(
			IntakeActivity intakeActivity) {
		// TODO Auto-generated method stub
		String uuid=UUID.randomUUID().toString();
		intakeActivity.setIntakeActivityId(uuid);
		intakeActivityMapper.insertIntakeActivity(intakeActivity);
		//判断入伙成员是否为空
		if(intakeActivity.getStaffIds()!=null){
			for (String a : intakeActivity.getStaffIds()) {
				IntakeActivityRelation intakeActivityRelation=new IntakeActivityRelation();
				intakeActivityRelation.setStaffId(a);
				intakeActivityRelation.setIntakeActivityId(uuid);
				String uuid1=UUID.randomUUID().toString();
				intakeActivityRelation.setIntakeActivityRelationId(uuid1);
				intakeActivityRelationMapper.insertIntakeActivityRelation(intakeActivityRelation);
			}
		}
		//判断建筑结构id是否为空
		if(intakeActivity.getBuildingStructureIds()!=null){
			for (String b : intakeActivity.getBuildingStructureIds()){
				IntakeGiftRelation intakeGiftRelation=new IntakeGiftRelation();
				intakeGiftRelation.setBuildingStructureId(b);
				intakeGiftRelation.setGiftId(intakeActivity.getGiftId());
				String uuid2=UUID.randomUUID().toString();
				intakeGiftRelation.setIntakeId(uuid);
				intakeGiftRelation.setIntakeGiftRelationId(uuid2);
				intakeGiftRelationMapper.insertIntakeGiftRelation(intakeGiftRelation);
			}
		}
	}

	@Override
	public PageRestful listPageIntakeActivity(IntakeActivity intakeActivity) {
		// TODO Auto-generated method stub
		PageRestful pageRestful=new PageRestful();
		List<IntakeActivity> intakeActivitys=intakeActivityMapper.listPageIntakeActivity(intakeActivity);
		intakeActivitys.add(0,null);
		pageRestful.setIntakeActivity(intakeActivitys);
		pageRestful.setPage(intakeActivity.getPage());
		return pageRestful;
	}
	
	@Override
	public IntakeActivity getAllNumByProjectId(String projectId){
		//获取建筑基础数据的信息
		List<AreaTypeNew> areaTypeList = areaTypeNewMapper.listAllAreaTypeNew();
		//获取建筑结构
		List<BuildingStructureNew> bsList = buildingStructureNewMapper.getBuildingStructureNewbyProjectId(projectId);
		//获取客户资产绑定信息
		List<PersonBuildingNew> pbList = personBuildingNewMapper.getPersonBuildingByProjectId(projectId);
		//获取个人客户信息和企业客户信息
		int pcnum = 0;
		int ecnum = 0;
		for(PersonBuildingNew pbn : pbList){
			if(pbn.getCustId() != null){
				pcnum ++;
			}else if(pbn.getEnterpriseId() != null){
				ecnum ++;
			}
		}
		//初始化对象传到前端
		//将建筑基础数据个数、建筑数、资产绑定数、个人客户数、企业客户数放入对象
		IntakeActivity intakeActivity = new IntakeActivity();
		intakeActivity.setBuildAreaNum(areaTypeList.size());
		intakeActivity.setBuildNum(bsList.size());
		intakeActivity.setAssetNum(pbList.size());
		intakeActivity.setPersonNum(pcnum);
		intakeActivity.setEnterpriseNum(ecnum);
		
		return intakeActivity;
	}
}
