package com.flf.service.impl;

import com.flf.entity.WaterMeterOrderRecords;
import com.flf.mapper.WaterMeterOrderRecordsMapper;
import com.flf.service.WaterMeterOrderRecordsService;

public class WaterMeterOrderRecordsServiceImpl implements WaterMeterOrderRecordsService{
	
	private WaterMeterOrderRecordsMapper waterMeterOrderRecordsMapper;

	public WaterMeterOrderRecordsMapper getWaterMeterOrderRecordsMapper() {
		return waterMeterOrderRecordsMapper;
	}

	public void setWaterMeterOrderRecordsMapper(WaterMeterOrderRecordsMapper waterMeterOrderRecordsMapper) {
		this.waterMeterOrderRecordsMapper = waterMeterOrderRecordsMapper;
	}

	@Override
	public void upDataWaterMeterOrderRecordsById(WaterMeterOrderRecords waterMeterOrderRecords) {
		waterMeterOrderRecordsMapper.updateWaterMeterOrderRecords(waterMeterOrderRecords);
	}

}
