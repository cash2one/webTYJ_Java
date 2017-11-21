package com.flf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.flf.entity.InspectionRecords;
import com.flf.mapper.InspectionRecordsMapper;
import com.flf.service.InspectionRecordsService;

public class InspectionRecordsServiceImp implements InspectionRecordsService {
	@Autowired
	private InspectionRecordsMapper inspectionRecordsMapper;
	

	public InspectionRecordsMapper getInspectionRecordsMapper() {
		return inspectionRecordsMapper;
	}


	public void setInspectionRecordsMapper(InspectionRecordsMapper inspectionRecordsMapper) {
		this.inspectionRecordsMapper = inspectionRecordsMapper;
	}

/**
 * 修改信息
 * */
	@Override
	public void updateInspectionRecords(InspectionRecords inspectionRecords) {
		inspectionRecordsMapper.updateInspectionRecords(inspectionRecords);

	}

}
