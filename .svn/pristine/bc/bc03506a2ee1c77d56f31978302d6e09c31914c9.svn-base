package com.flf.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import net.sf.json.JSONObject;

import com.flf.entity.ChargeType;
import com.flf.entity.Constant;
import com.flf.entity.DataDictionarySlave;
import com.flf.mapper.ChargeTypeMapper;
import com.flf.mapper.ConstantMapper;
import com.flf.service.ConstantService;
import com.flf.service.DataDictionarySlaveService;

public class ConstantServiceImpl implements ConstantService {
	private ConstantMapper constantMapper;
	@Autowired
	private DataDictionarySlaveService dataDictionarySlaveService;
	@Autowired
	private ChargeTypeMapper chargeTypeMapper;
	
	public ConstantMapper getConstantMapper() {
		return constantMapper;
	}

	public void setConstantMapper(ConstantMapper constantMapper) {
		this.constantMapper = constantMapper;
	}

	@Override
	public Constant getConstantByConstantId(String constantId) {
		return constantMapper.selectByPrimaryKey(constantId);
	}
	@Override
	public String insertConstant(Constant constant) {
		Map<String,String> map=new HashMap<String,String>();
		constant.setConstantId(UUID.randomUUID().toString());
		constant.setParentsId("1");
		constantMapper.insertSelective(constant);
		map.put("code","200");
		map.put("information","保存成功");
	    return JSONObject.fromObject(map).toString();//3001表示参数不全    200表示成功
	}

	@Override
	public List<Constant> listAllConstant(String chargeTypeId) {
		List<Constant> constantList = constantMapper.getConstantListByChargeTypeId(chargeTypeId);
		List<Constant> parentConstantList = constantMapper.getParentConstantList();
		for(Constant constant:parentConstantList){
			constantList.add(constant);
		}
		ChargeType chargeType = chargeTypeMapper.selectByPrimaryKey(chargeTypeId);
		List<DataDictionarySlave> variableList = dataDictionarySlaveService.getDataDictionarySlaveRes("variable", chargeType.getProjectId());
		for(DataDictionarySlave dds:variableList){
			Constant constant = new Constant();
			constant.setConstantId(UUID.randomUUID().toString());
			constant.setConstantName(dds.getDescription());
			constant.setCommonValue(dds.getSlaveName());
			constant.setParentsId("2");
			constantList.add(constant);
		}
		List<DataDictionarySlave> operationSymbolList = dataDictionarySlaveService.getDataDictionarySlaveRes("operationSymbol", chargeType.getProjectId());
		for(DataDictionarySlave dds:operationSymbolList){
			Constant constant = new Constant();
			constant.setConstantId(UUID.randomUUID().toString());
			constant.setConstantName(dds.getSlaveName());
			constant.setCommonValue(dds.getSlaveName());
			constant.setParentsId("3");
			constantList.add(constant);
		}
		return constantList;
	}
}
