package com.flf.service.impl;

import com.flf.entity.Condition;
import com.flf.mapper.ConditionMapper;
import com.flf.service.ConditionService;

public class ConditionServiceImpl implements ConditionService {

	private ConditionMapper conditionMapper;
	
	public ConditionMapper getConditionMapper() {
		return conditionMapper;
	}

	public void setConditionMapper(ConditionMapper conditionMapper) {
		this.conditionMapper = conditionMapper;
	}

	/**
	 * 新增条件
	 */
	@Override
	public void insertCondition(Condition condition) {
		conditionMapper.insertCondition(condition);
	}

	@Override
	public void updateCondition(Condition condition) {
		// TODO Auto-generated method stub
		
	}

}
