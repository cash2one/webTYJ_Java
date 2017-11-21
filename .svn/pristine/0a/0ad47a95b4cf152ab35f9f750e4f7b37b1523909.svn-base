package com.flf.service.impl;
import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Path;

import com.flf.entity.CompensateObject;
import com.flf.mapper.CompensateObjectMapper;
import com.flf.service.CompensateObjectService;
@Path("/CompensateObject")
/**
 * 赔偿对象表
 * 创建人：邵政
 * 创建时间：2015/6/25
 */
@WebService
public class CompensateObjectServiceImpl implements CompensateObjectService {
	
	private CompensateObjectMapper compensateObjectMapper;
	

	public CompensateObjectMapper getCompensateObjectMapper() {
		return compensateObjectMapper;
	}

	public void setCompensateObjectMapper(CompensateObjectMapper compensateObjectMapper) {
		this.compensateObjectMapper = compensateObjectMapper;
	}

	@Override
	public List<CompensateObject> listPageCompensateObject(
			CompensateObject compensateObject) {
		// TODO Auto-generated method stub
		return compensateObjectMapper.listPageCompensateObject(compensateObject);
	}

	@Override
	public List<CompensateObject> listAllCompensateObject() {
		// TODO Auto-generated method stub
		return compensateObjectMapper.listAllCompensateObject();
	}

	@Override
	public CompensateObject getCompensateObjectbyId(String recordId) {
		// TODO Auto-generated method stub
		return compensateObjectMapper.getCompensateObjectbyId(recordId);
	}

	@Override
	public void insertCompensateObject(CompensateObject compensateObject) {
		// TODO Auto-generated method stub
		compensateObjectMapper.insertCompensateObject(compensateObject);
	}

	@Override
	public void updateCompensateObject(CompensateObject compensateObject) {
		// TODO Auto-generated method stub
		compensateObjectMapper.updateCompensateObject(compensateObject);
	}

	@Override
	public void deleteCompensateObject(String recordId) {
		// TODO Auto-generated method stub
		compensateObjectMapper.deleteCompensateObject(recordId);
	}

	
}
