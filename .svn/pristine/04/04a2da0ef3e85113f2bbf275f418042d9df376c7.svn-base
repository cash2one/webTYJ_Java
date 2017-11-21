package com.flf.service.impl;
import java.util.List;

import javax.jws.WebService;

import com.flf.entity.DisposeInformationRecords;
import com.flf.mapper.DisposeInformationRecordsMapper;
import com.flf.service.DisposeInformationRecordsService;
/**
 * 处理信息记录表
 * 创建人：邵政
 * 创建时间：2015-7-2
 */
@WebService
public class DisposeInformationRecordsServiceImpl implements DisposeInformationRecordsService {
	
	private DisposeInformationRecordsMapper disposeInformationRecordsMapper;
	

	public DisposeInformationRecordsMapper getDisposeInformationRecordsMapper() {
		return disposeInformationRecordsMapper;
	}

	public void setDisposeInformationRecordsMapper(DisposeInformationRecordsMapper disposeInformationRecordsMapper) {
		this.disposeInformationRecordsMapper = disposeInformationRecordsMapper;
	}

	@Override
	public List<DisposeInformationRecords> listPageDisposeInformationRecords(
			DisposeInformationRecords disposeInformationRecords) {
		// TODO Auto-generated method stub
		return disposeInformationRecordsMapper.listPageDisposeInformationRecords(disposeInformationRecords);
	}

	@Override
	public List<DisposeInformationRecords> listAllDisposeInformationRecords() {
		// TODO Auto-generated method stub
		return disposeInformationRecordsMapper.listAllDisposeInformationRecords();
	}

	@Override
	public DisposeInformationRecords getDisposeInformationRecordsbyId(String recordId) {
		// TODO Auto-generated method stub
		return disposeInformationRecordsMapper.getDisposeInformationRecordsbyId(recordId);
	}

	@Override
	public void insertDisposeInformationRecords(DisposeInformationRecords disposeInformationRecords) {
		// TODO Auto-generated method stub
		disposeInformationRecordsMapper.insertDisposeInformationRecords(disposeInformationRecords);
	}

	@Override
	public void updateDisposeInformationRecords(DisposeInformationRecords disposeInformationRecords) {
		// TODO Auto-generated method stub
		disposeInformationRecordsMapper.updateDisposeInformationRecords(disposeInformationRecords);
	}

	@Override
	public void deleteDisposeInformationRecords(String recordId) {
		// TODO Auto-generated method stub
		disposeInformationRecordsMapper.deleteDisposeInformationRecords(recordId);
	}

	
}
