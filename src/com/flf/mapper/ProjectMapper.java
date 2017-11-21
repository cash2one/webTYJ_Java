package com.flf.mapper;

import java.util.List;
import com.flf.entity.Project;
import com.flf.entity.SubCompany;

public interface ProjectMapper {// 项目表

	List<Project> listPageProject(Project project);// 分页查询项目

	List<Project> listPageProjectAll(Project project);// 分页查询项目,查询状态不为5的项目

	List<Project> listPageProjectByCompany(Project project);// 根据公司id分页

	List<Project> listAllProject();// 查询所有项目

	List<Project> listAllProjectByCompany(String companyId);

	List<Project> listAllPageProject(); // 查询前6个项目

	Project getProject(String projectId);// 通过Id查询项目
	
	Project getProjectNameByProjectId(String projectId);//通过项目id查询项目名称

	int updateProject(Project project);// 修改项目表

	int deleteSubProject(String state, String projectId);

	int insertProject(Project project);// 添加项目表信息

	int deleteProjectById(String projectId);// 删除项目信息

	int updateProjectJson(Project project);// 修改项目信息

	int deleteProjectByIdJson(String id);// 删除项目信息

	int insertProjectJson(Project project);// 添加项目信息

	int insertProjectByid(Project project);// 添加项目自己生成id

	Project getProjectJson(String id);// 通过Id查询项目表

	List<Project> getProjectbyteamworkId(String teamworkId); // 根据团队id查询项目信息

	List<Project> listProjectBystaffId(String staffId); // 根据项目经理查询项目

	// 查询项目所有信息
	public List<Project> selectAllProject();

	// 查询所有项目是否启用收费计费功能
	public List<String> getUSeSystemCount();

	// 查询所有项目，包含区
	List<Project> getAllProjectWithRegion(String companyId);

	// 根据子公司id获取子公司管理的项目
	List<Project> getProjectBySubCompanyId(String subCompanyId);

	String selectProjectCode();// 获取项目中的编号最大值

	Project getProjectByState();

	List<String> getProjectByCompanyId(String companyId);// 根据公司获取项目项目信息

	/**
	 * 根据公司id获取所有在有效状态的项目 王洲 216.2.1
	 * 
	 * @param companyId
	 * @return
	 */
	List<Project> getAllProjectByCompanyId(String companyId);

	/**
	 * 根据用户名查询所在公司下的所有项目
	 * 
	 * @param userName
	 * @return
	 */
	List<Project> selectProjectByUser(String userName);

	/**
	 * 分页查询及默认项目 zhuqi 2016.03.14
	 * 
	 * @param property
	 * @return List<Property>
	 */
	List<Project> listPageProjectByState(Project project);

	// 更新项目的收费启用状态
	void updateIsUseSystemByProjectId(Project project);

	// 获取项目详细信息
	List<Project> getAllProjectByProjectIds(List<String> projectIds);

	// 获取所有开启收费的项目
	List<Project> listPageProjectByIsUseSystem();

	List<Project> listPageAllsubCompanyProject(SubCompany subCompany);
}
