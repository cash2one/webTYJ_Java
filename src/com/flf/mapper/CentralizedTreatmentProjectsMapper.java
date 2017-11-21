package com.flf.mapper;

import java.util.List;

import com.flf.entity.CentralizedTreatmentProjects;

public interface CentralizedTreatmentProjectsMapper {
	
	//添加集中处理项目
	int insertCentralizedTreatmentProjects(CentralizedTreatmentProjects centralizedTreatmentProjects);
	//添加集中处理项目(uuid)
	int insertCentralizedTreatmentProjectsUUID(CentralizedTreatmentProjects centralizedTreatmentProjects);
	//根据状态查询集中处理项目
	List<CentralizedTreatmentProjects> getCentralizedTreatmentProjectsbyState(String state);
	//根据id查询集中处理项目
	CentralizedTreatmentProjects getCentralizedTreatmentProjectsbyId(String projectId);
	//修改集中处理项目
	int updateCentralizedTreatmentProjects(CentralizedTreatmentProjects centralizedTreatmentProjects);
	//获取所有的集中处理项目
	List<CentralizedTreatmentProjects> getAllCentralizedTreatmentProjects();
	//获取所有的集中处理项状态为启动的处理项目
	List<CentralizedTreatmentProjects> getAllCentralizedTreatmentProjectsAlive();
	//根据集中项状态查询集中信息分页
	List<CentralizedTreatmentProjects> listPageCentralizedTreatmentProjectsbyState(CentralizedTreatmentProjects projects);
	//根据状态查询集中处理项目个数
	int getCentralizedTreatmentProjectCountsbyState(String state);
}
