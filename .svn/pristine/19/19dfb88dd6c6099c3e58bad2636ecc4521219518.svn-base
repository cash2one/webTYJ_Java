package com.flf.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.flf.entity.AboutScheme;
import com.flf.entity.BuildingStructureNew;
import com.flf.entity.Formula;
import com.flf.entity.SchemeDatails;
import com.flf.mapper.ChargeItemNewMapper;
import com.flf.mapper.ConstantMapper;
import com.flf.mapper.FormulaMapper;
import com.flf.mapper.SchemeDatailsMapper;
import com.flf.service.SchemeDatailsService;

public class SchemeDatailsServiceImpl implements SchemeDatailsService {

	private SchemeDatailsMapper schemeDatailsMapper;
	
	private ChargeItemNewMapper chargeItemNewMapper;
	
	private ConstantMapper constantMapper;
	
	private FormulaMapper formulaMapper;
	
	public SchemeDatailsMapper getSchemeDatailsMapper() {
		return schemeDatailsMapper;
	}

	public void setSchemeDatailsMapper(SchemeDatailsMapper schemeDatailsMapper) {
		this.schemeDatailsMapper = schemeDatailsMapper;
	}

	public ChargeItemNewMapper getChargeItemNewMapper() {
		return chargeItemNewMapper;
	}

	public void setChargeItemNewMapper(ChargeItemNewMapper chargeItemNewMapper) {
		this.chargeItemNewMapper = chargeItemNewMapper;
	}

	public ConstantMapper getConstantMapper() {
		return constantMapper;
	}

	public void setConstantMapper(ConstantMapper constantMapper) {
		this.constantMapper = constantMapper;
	}

	public FormulaMapper getFormulaMapper() {
		return formulaMapper;
	}

	public void setFormulaMapper(FormulaMapper formulaMapper) {
		this.formulaMapper = formulaMapper;
	}

	/**
	 * 新增方案公式收费项目关联数据
	 */
	@Override
	public void insertSchemeDetails(SchemeDatails schemeDatails) {
		schemeDatailsMapper.insertSchemeDatails(schemeDatails);
	}

	/**
	 * 根据方案id和一级收费项目id查询方案公式收费项目关联数据
	 */
	@Override
	public AboutScheme getSchemeDatailsListByScheme(String schemeId, String chargeItemId){
		
		//初始化返回集合
		AboutScheme aboutScheme = new AboutScheme();
		
//		//根据一级收费项目id查询此项目下所有二级收费项目信息
//		List<ChargeItemNew> chargeItemNewList = chargeItemNewMapper.getChargeItemNewByIds(chargeItemId);
//		//根据方案id和二级收费项目集合匹配方案公式收费项目关联表中的数据
//		List<SchemeDatails> schemeDatailsList = new ArrayList<SchemeDatails>();
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("schemeId", schemeId);
//		for(int i = 0; i <chargeItemNewList.size(); i ++){
//			map.put("chargeItemId", chargeItemNewList.get(i).getCiId());
//			schemeDatailsList.addAll(schemeDatailsMapper.getSchemeDatailsBySchemeIdAndchargeItemId(map));
//		}
//		aboutScheme.setSchemeDetails(schemeDatailsList);
		return aboutScheme;
	}
	
	/**
	 * 根据方案id查询方案公式收费项目关联表中所属的建筑结构id
	 */
	@Override
	public List<String> getBuildingIdBySchemeId(String schemeId){
		return schemeDatailsMapper.getBuildingIdBySchemeId(schemeId);
	}
	
	/**
	 * 根据收费项目id查询关联的公式及条件
	 */
	@Override
	public List<Formula> getFormulaByChargeItemId(String chargeItemId){
		//根据收费项目id查询关联表中的公式id
		List<SchemeDatails> schemeDatailsList = schemeDatailsMapper.getSchemeDatailsByChargeItemId(chargeItemId);
		//根据公式id查询公式及条件
		List<Formula> formulaList = new ArrayList<Formula>();
//		for(SchemeDatails list : schemeDatailsList){
//			formulaList.addAll(formulaMapper.getFormulaByciId(list.getFormulaId()));
//		}
		return formulaList;
	}
	
	/**
	 * 跟据方案id查询建筑结构id及名称
	 */
	@Override
	public List<BuildingStructureNew> getBuildingBySchemeId(String schemeId){
		return schemeDatailsMapper.getBuildingBySchemeId(schemeId);
	}

	@Override
	public List<SchemeDatails> getSchemeDatailsBySchemeId(String schemeId) {
		// TODO Auto-generated method stub
		return schemeDatailsMapper.getSchemeDatailsBySchemeId(schemeId);
	}

	@Override
	public List<SchemeDatails> getSchemeDatailsResBySchemeId(String schemeId) {
		// TODO Auto-generated method stub
		return schemeDatailsMapper.getSchemeDatailsResBySchemeId(schemeId);
	}
}
