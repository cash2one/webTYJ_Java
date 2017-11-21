package com.flf.service.impl;

import java.util.List;

import com.flf.entity.FinancialStaff;
import com.flf.mapper.FinancialStaffMapper;
import com.flf.service.FinancialStaffService;

public class FinancialStaffServiceImpl implements FinancialStaffService{
	
	private FinancialStaffMapper financialStaffMapper;

	public FinancialStaffMapper getFinancialStaffMapper() {
		return financialStaffMapper;
	}

	public void setFinancialStaffMapper(FinancialStaffMapper financialStaffMapper) {
		this.financialStaffMapper = financialStaffMapper;
	}
	
	
	/**
	 * 根据id查询上级员工信息
	 * @param orderId
	 */
	@Override
	public FinancialStaff selectById(String financialStaffId) {
		// TODO Auto-generated method stub
		return financialStaffMapper.selectById(financialStaffId);
	}

	@Override
	public FinancialStaff selectAllsById(String financialStaffId) {
		// TODO Auto-generated method stub
		return financialStaffMapper.selectAllsById(financialStaffId);
	}

	@Override
	public FinancialStaff selectCashierById(String financialStaffId) {
		// TODO Auto-generated method stub
		return financialStaffMapper.selectCashierById(financialStaffId);
	}

	@Override
	public FinancialStaff getFinancialStaffbyId(String financialStaffId) {
		// TODO Auto-generated method stub
		return financialStaffMapper.getFinancialStaffbyId(financialStaffId);
	}

	@Override
	public FinancialStaff selectAllsByStaffId(FinancialStaff financialStaff) {
		return financialStaffMapper.selectAllsByStaffId(financialStaff);
	}

	@Override
	public List<FinancialStaff> getFinancialStaffbyStaffId(String staffId) {
		return financialStaffMapper.getFinancialStaffbyStaffId(staffId);
	}
	
}
