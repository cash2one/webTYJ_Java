package com.flf.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.flf.entity.PaymentRecords;
import com.flf.mapper.PaymentRecordsMapper;
import com.flf.service.PaymentRecordsService;

public class PaymentRecordsServiceImpl implements PaymentRecordsService{

	private PaymentRecordsMapper paymentRecordsMapper;
	
	public PaymentRecordsMapper getPaymentRecordsMapper() {
		return paymentRecordsMapper;
	}
	public void setPaymentRecordsMapper(PaymentRecordsMapper paymentRecordsMapper) {
		this.paymentRecordsMapper = paymentRecordsMapper;
	}
	@Override
	public void insertPaymentRecords(PaymentRecords paymentRecords) {
		// TODO Auto-generated method stub
		paymentRecords.setPaymentRecordsId(UUID.randomUUID().toString());
		paymentRecords.setPaymentDate(new Date());		
		paymentRecordsMapper.insertPaymentRecords(paymentRecords);
	}
	@Override
	public List<PaymentRecords> getPaymentRecordsById(String financialStaffId) {
		// TODO Auto-generated method stub
		return paymentRecordsMapper.getPaymentRecordsById(financialStaffId);
	}
	@Override
	public void updatePaymentRecords(PaymentRecords paymentRecords) {
		// TODO Auto-generated method stub
		paymentRecordsMapper.updatePaymentRecords(paymentRecords);
	}

}
