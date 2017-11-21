package com.flf.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flf.entity.SchemeRelation;
import com.flf.mapper.SchemeRelationMapper;
import com.flf.request.Info;
import com.flf.service.SchemeRelationService;
import com.flf.util.Tools;

public class SchemeRelationServiceImpl implements SchemeRelationService {

	private SchemeRelationMapper schemeRelationMapper;
	
	public SchemeRelationMapper getSchemeRelationMapper() {
		return schemeRelationMapper;
	}

	public void setSchemeRelationMapper(SchemeRelationMapper schemeRelationMapper) {
		this.schemeRelationMapper = schemeRelationMapper;
	}


	/**
	 * 新增方案收费项目关联表数据
	 */
	@Override
	public void insertSchemeRelation(SchemeRelation schemeRelation) {
		schemeRelationMapper.insertSchemeRelation(schemeRelation);
	}
	
	/**
	 * 根据方案id查询与一级收费项目关联数据以及收费项目的信息
	 */
	@Override
	public List<SchemeRelation> getSchemeRelationBySchemeId(String schemeId){
		return schemeRelationMapper.getSchemeRelationBySchemeId(schemeId);
	}

	@Override
	public List<SchemeRelation> getSchemeRelationResBySchemeId(String schemeId) {
		// TODO Auto-generated method stub
		return schemeRelationMapper.getSchemeRelationResBySchemeId(schemeId);
	}

	@Override
	public Info deleteSchemeRelationBySchemeId(String ids,String schemeId) {
		if(Tools.notEmpty(ids) && Tools.notEmpty(schemeId)){
			String[] array = ids.split(",");
			Map<String,Object> map = new HashMap<String,Object>();
			
			map.put("array", array);
			map.put("schemeId", schemeId);
			
			schemeRelationMapper.deleteSchemeRelationByciIdAndSchemeId(map);
			return Tools.msg("操作成功!", true);
		}
		return Tools.msg("操作失败!", false);
	}

}
