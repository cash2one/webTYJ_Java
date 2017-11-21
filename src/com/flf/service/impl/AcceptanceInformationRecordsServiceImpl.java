package com.flf.service.impl;

import java.util.List;

import com.flf.entity.AcceptanceInformationRecords;
import com.flf.mapper.AcceptanceInformationRecordsMapper;
import com.flf.service.AcceptanceInformationRecordsService;

public class AcceptanceInformationRecordsServiceImpl implements AcceptanceInformationRecordsService{

	private AcceptanceInformationRecordsMapper acceptanceInformationRecordsMapper;
	
	public AcceptanceInformationRecordsMapper getAcceptanceInformationRecordsMapper() {
		return acceptanceInformationRecordsMapper;
	}

	public void setAcceptanceInformationRecordsMapper(
			AcceptanceInformationRecordsMapper acceptanceInformationRecordsMapper) {
		this.acceptanceInformationRecordsMapper = acceptanceInformationRecordsMapper;
	}

	@Override
	public void deleteAcceptanceInformationRecords(String recordId) {
		// TODO Auto-generated method stub
		acceptanceInformationRecordsMapper.deleteAcceptanceInformationRecords(recordId);
	}

	@Override
	public AcceptanceInformationRecords getAcceptanceInformationRecordsbyId(
			String recordId) {
		// TODO Auto-generated method stub
		return acceptanceInformationRecordsMapper.getAcceptanceInformationRecordsbyId(recordId);
	}

	@Override
	public void insertAcceptanceInformationRecords(
			AcceptanceInformationRecords acceptanceInformationRecords) {
		// TODO Auto-generated method stub
		acceptanceInformationRecordsMapper.insertAcceptanceInformationRecords(acceptanceInformationRecords);
	}

	@Override
	public List<AcceptanceInformationRecords> listAllAcceptanceInformationRecords() {
		// TODO Auto-generated method stub
		return acceptanceInformationRecordsMapper.listAllAcceptanceInformationRecords();
	}

	@Override
	public void updateAcceptanceInformationRecords(
			AcceptanceInformationRecords acceptanceInformationRecords) {
		// TODO Auto-generated method stub
		acceptanceInformationRecordsMapper.updateAcceptanceInformationRecords(acceptanceInformationRecords);
	}
	
}
