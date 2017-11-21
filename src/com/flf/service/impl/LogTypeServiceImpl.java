package com.flf.service.impl;

import java.util.List;

import com.flf.entity.LogType;
import com.flf.mapper.LogTypeMapper;
import com.flf.service.LogTypeService;

public class LogTypeServiceImpl implements LogTypeService {
	
	private LogTypeMapper logTypeMapper;

	public LogTypeMapper getLogTypeMapper() {
		return logTypeMapper;
	}

	public void setLogTypeMapper(LogTypeMapper logTypeMapper) {
		this.logTypeMapper = logTypeMapper;
	}

	@Override
	public List<LogType> listAllLogTypeeRestful() {
		// TODO Auto-generated method stub
		return logTypeMapper.listAllLogType();
	}

	@Override
	public LogType selectLogTypeById(String logTypeId) {
		// TODO Auto-generated method stub
		return logTypeMapper.getLogTypeById(logTypeId);
	}

	@Override
	public void insertLogTypeRestful(LogType logType) {
		// TODO Auto-generated method stub
		logTypeMapper.insertLogType(logType);
	}

	@Override
	public void updateArticleReleaserestRestful(LogType logType) {
		// TODO Auto-generated method stub
		logTypeMapper.updateLogType(logType);
	}

}
