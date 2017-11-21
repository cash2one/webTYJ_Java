package com.flf.mapper;

import java.util.List;

import com.flf.entity.SpecialRepairProject;

public interface SpecialRepairProjectMapper {
	//添加专项信息
	int insertSpecialRepairProject(SpecialRepairProject project);
	int insertSpecialRepairProjectUUID(SpecialRepairProject project);
	//查询所有的专项信息
	List<SpecialRepairProject> getAllSpecialRepairProject();
	//根据专项id获取专项信息
	SpecialRepairProject getSpecialRepairProjectbyId(String specialId);
	//修改专项信息
	int updateSpecialRepairProject(SpecialRepairProject specialRepairProject);
	//根据专项状态查询专项信息
	List<SpecialRepairProject> getSpecialRepairProjectbyState(String state);
	//根据专项状态查询专项信息分页
	List<SpecialRepairProject> listPageSpecialRepairProjectbyState(SpecialRepairProject project);
	//根据专项状态查询个数
	int getSpecialRepairProjectCountbyState(String specialState);
}
