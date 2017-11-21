package com.flf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.flf.entity.DecorateComponentRecords;
import com.flf.mapper.DecorateComponentRecordsMapper;
import com.flf.service.DecorateComponentRecordsService;

public class DecorateComponentRecordsServiceImp implements DecorateComponentRecordsService {

	@Autowired
	private DecorateComponentRecordsMapper decorateComponentRecordsMapper;
	@Override
	public List<DecorateComponentRecords> listAllDecorateComponentRecords() {
		
		return decorateComponentRecordsMapper.listAllDecorateComponentRecords();
	}

}
