package com.flf.service.impl;

import java.util.List;

import com.flf.entity.CheckItemRecords;
import com.flf.mapper.CheckItemRecordsMapper;
import com.flf.service.CheckItemRecordsService;

public class CheckItemRecordsServiceImpl implements CheckItemRecordsService{

	private CheckItemRecordsMapper checkItemRecordsMapper;
	
	public CheckItemRecordsMapper getCheckItemRecordsMapper() {
		return checkItemRecordsMapper;
	}

	public void setCheckItemRecordsMapper(
			CheckItemRecordsMapper checkItemRecordsMapper) {
		this.checkItemRecordsMapper = checkItemRecordsMapper;
	}

	@Override
	public void insertCheckItemRecords(CheckItemRecords checkItemRecords) {
		// TODO Auto-generated method stub
		checkItemRecordsMapper.insertCheckItemRecords(checkItemRecords);
	}

	@Override
	public CheckItemRecords getCheckItemRecordsbyId(String recordId) {
		// TODO Auto-generated method stub
		return checkItemRecordsMapper.getCheckItemRecordsbyId(recordId);
	}

	@Override
	public void deleteCheckItemRecords(String recordId) {
		// TODO Auto-generated method stub
		checkItemRecordsMapper.deleteCheckItemRecords(recordId);
	}

	@Override
	public List<CheckItemRecords> listAllCheckItemRecords() {
		// TODO Auto-generated method stub
		return checkItemRecordsMapper.listAllCheckItemRecords();
	}

	@Override
	public void updateCheckItemRecords(CheckItemRecords checkItemRecords) {
		// TODO Auto-generated method stub
		checkItemRecordsMapper.updateCheckItemRecords(checkItemRecords);
	}

}
