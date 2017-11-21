package com.flf.mapper;

import java.util.List;

import com.flf.entity.SubCompanyProjectRelation;

public interface SubCompanyProjectRelationMapper {
	/* 添加子公司、项目关系 */
	int insertSubCompanyProjectRelation(SubCompanyProjectRelation subCompanyProjectRelation);
	/* 删除子公司、项目关系 */
	int deleteSubCompanyProjectRelation(String subCompanyProjectRelationId);
	/* 修改子公司、项目关系*/
	int updateSubCompanyProjectRelation(SubCompanyProjectRelation subCompanyProjectRelation);
    /*根据子公司ID查询其下所有项目*/
	List<SubCompanyProjectRelation> getAllProject(String subCompanyId);
	List<SubCompanyProjectRelation> getAllData();
	/* 根据子公司id删除关系表 */
	int deleteRelationsBySubCompanyId(String subCompanyId);
	/* 获取所有已与子公司关联的项目id */
	List<String> getAllUsedProjectIds();
	
	/*分页查询子公司下项目*/
	List<SubCompanyProjectRelation> listAllsubCompanyProject(String subCompanyId);

}
