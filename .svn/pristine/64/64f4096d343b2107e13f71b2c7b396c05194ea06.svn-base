package com.flf.mapper;

import java.util.List;
import java.util.Map;

import com.flf.entity.ChargeItemNew;
import com.flf.entity.SchemeRelation;

/**
 * 方案收费项目关联表mapper
 * @author wangzhou
 *
 */
public interface SchemeRelationMapper {

	/**
	 * 新增方案收费项目关联表数据
	 * @param schemeRelation
	 */
	void insertSchemeRelation(SchemeRelation schemeRelation);
	
	/**
	 * 根据方案id查询方案与一级收费项目关联数据以及对应收费项目数据
	 * @param schemeId
	 * @return list
	 */
	List<SchemeRelation> getSchemeRelationBySchemeId(String schemeId);
	
	/**
	 * 根据方案收费项目关联表查询一级收费项目下的二级收费项目
	 * @param chargeItemId
	 * @return
	 */
	List<ChargeItemNew> getChargeItemNewListByParentId(String chargeItemId);
	
	/**
	 * 根据方案id查询方案
	 */
	List<SchemeRelation> getSchemeRelationResBySchemeId(String schemeId);
	
	/**
	 * 删除方案收费项目关联表数据
	 * @param schemeRelation
	 */
	void deleteSchemeRelation(SchemeRelation schemeRelation);
	
	/**
	 * 根据id删除项目关联表数据
	 * @param ids
	 */
	void deleteSchemeRelationById(String[] ids);
	
	/**
	 * 根据项目id和方案id删除项目关联表数据
	 */
	void deleteSchemeRelationByciIdAndSchemeId(Map<String,Object> map);
	
	/**
	 * 根据方案id删除项目关联表数据
	 */
	void deleteSchemeRelationBySchemeId(String schemeId);
	
	//根据收费项目ID查询方案信息
	SchemeRelation getSchemeByChargeItemId(String cinId);
	
	/**
	 * 批量增加方案收费项目关联数据
	 * @author wangzhou
	 * 2016.04.25
	 * @param list
	 * @return
	 */
	void insertSchemeRelationList(List<SchemeRelation> list);
}
