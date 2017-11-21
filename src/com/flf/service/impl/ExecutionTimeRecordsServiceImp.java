package com.flf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.flf.entity.DecorationInspectionPlans;
import com.flf.entity.ExecutionTimeRecords;
import com.flf.entity.PageRestful;
import com.flf.mapper.ExecutionTimeRecordsMapper;
import com.flf.service.ExecutionTimeRecordsService;

public class ExecutionTimeRecordsServiceImp implements ExecutionTimeRecordsService {
	@Autowired
	private ExecutionTimeRecordsMapper executionTimeRecordsMapper;
	@Override
	public PageRestful listPageDecorationsExecutionTime(ExecutionTimeRecords executionTimeRecords) {
		PageRestful pageRestful = new PageRestful();
		List<ExecutionTimeRecords> executionTimeRecord = executionTimeRecordsMapper.listPageDecorationsExecutionTime(executionTimeRecords);
		executionTimeRecord.add(0, executionTimeRecords);
		pageRestful.setExecutionTimeRecord(executionTimeRecord);
		pageRestful.setPage(executionTimeRecords.getPage());
		return pageRestful;
		
	}

}
