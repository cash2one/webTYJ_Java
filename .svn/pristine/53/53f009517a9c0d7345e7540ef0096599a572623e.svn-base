package com.flf.service.impl;
import java.util.List;

import javax.jws.WebService;
import javax.ws.rs.Path;

import com.flf.entity.CompensateMethods;
import com.flf.mapper.CompensateMethodsMapper;
import com.flf.service.CompensateMethodsService;
@Path("/CompensateMethods")
/**
 * 赔偿方案
 * 创建人：邵政
 * 创建时间：2015/6/25
 */
@WebService
public class CompensateMethodsServiceImpl implements CompensateMethodsService {
	
	private CompensateMethodsMapper compensateMethodsMapper;
	

	public CompensateMethodsMapper getCompensateMethodsMapper() {
		return compensateMethodsMapper;
	}

	public void setCompensateMethodsMapper(CompensateMethodsMapper compensateMethodsMapper) {
		this.compensateMethodsMapper = compensateMethodsMapper;
	}

	@Override
	public List<CompensateMethods> listPageCompensateMethods(
			CompensateMethods compensateMethods) {
		// TODO Auto-generated method stub
		return compensateMethodsMapper.listPageCompensateMethods(compensateMethods);
	}

	@Override
	public List<CompensateMethods> listAllCompensateMethods() {
		// TODO Auto-generated method stub
		return compensateMethodsMapper.listAllCompensateMethods();
	}

	@Override
	public CompensateMethods getCompensateMethodsbyId(String compensateMethodId) {
		// TODO Auto-generated method stub
		return compensateMethodsMapper.getCompensateMethodsbyId(compensateMethodId);
	}

	@Override
	public void insertCompensateMethods(CompensateMethods compensateMethods) {
		// TODO Auto-generated method stub
		compensateMethodsMapper.insertCompensateMethods(compensateMethods);
	}

	@Override
	public void updateCompensateMethods(CompensateMethods compensateMethods) {
		// TODO Auto-generated method stub
		compensateMethodsMapper.updateCompensateMethods(compensateMethods);
	}

	@Override
	public void deleteCompensateMethods(String compensateMethodId) {
		// TODO Auto-generated method stub
		compensateMethodsMapper.deleteCompensateMethods(compensateMethodId);
	}

	
}
