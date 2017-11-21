package com.flf.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.springframework.beans.factory.annotation.Autowired;

import net.sf.json.JSONObject;

import com.flf.entity.DataDictionarySlave;
import com.flf.entity.Formula;
import com.flf.mapper.FormulaMapper;
import com.flf.service.DataDictionarySlaveService;
import com.flf.service.FormulaService;
import com.flf.util.Tools;
/**
 * 
 * @author maogaofei
 * @date 2016年7月1日 下午3:18:08
 */
public class FormulaServiceImpl implements FormulaService {

	private FormulaMapper formulaMapper;
	
	public FormulaMapper getFormulaMapper() {
		return formulaMapper;
	}

	public void setFormulaMapper(FormulaMapper formulaMapper) {
		this.formulaMapper = formulaMapper;
	}
	@Autowired
	private DataDictionarySlaveService dataDictionarySlaveService;

	@Override
	public List<Formula> listAllFormula(Formula formula) {
		List<Formula> list = formulaMapper.listAllFormula(formula);
		return list;
	}

	@Override
	public String insertFormula(Formula formula) {
		ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript"); 
		Map<String,String> map=new HashMap<String,String>();
		formula.setFormulaId(UUID.randomUUID().toString());
		
		String formulaExpression = formula.getFormulaExpression();
		List<DataDictionarySlave> variableList = dataDictionarySlaveService.getDataDictionarySlaveRes("variable", formula.getProjectId());
		for(DataDictionarySlave dds:variableList){
			formulaExpression = formulaExpression.replaceAll(dds.getSlaveName(), "1");
		}
		try{
			jse.eval(formulaExpression).toString();
		}catch (Exception e) {
			 map.put("code","3001");
			 map.put("information","公式有误！");
			 return JSONObject.fromObject(map).toString();//3001表示错误   200表示成功
		}
		
		formulaMapper.insertSelective(formula);
		map.put("code","200");
		map.put("information","保存成功");
	    return JSONObject.fromObject(map).toString();//3001表示错误   200表示成功
	}

	@Override
	public void deleteChargeItemNew(String formulaId) {
		if (!Tools.isEmpty(formulaId)) {
			String[] array = formulaId.split(",");
			for (int i = 0 ; i < array.length; i++) {
				formulaMapper.deleteByPrimaryKey(array[i]);
			}
		}
		
	}

}
