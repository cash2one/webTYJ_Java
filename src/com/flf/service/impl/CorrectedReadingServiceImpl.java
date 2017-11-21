package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.flf.entity.Annex;
import com.flf.entity.CorrectedReading;
import com.flf.entity.ElectricityMeter;
import com.flf.entity.ElectricityMeterReadingData;
import com.flf.entity.MeterReadingData;
import com.flf.entity.WaterMeter;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.CorrectedReadingMapper;
import com.flf.mapper.MeterMapper;
import com.flf.mapper.MeterReadingDataMapper;
import com.flf.mapper.ElectricityMeterMapper;
import com.flf.mapper.ElectricityMeterReadingDataMapper;
import com.flf.service.CorrectedReadingService;

public class CorrectedReadingServiceImpl implements CorrectedReadingService {

	private CorrectedReadingMapper correctedReadingMapper;
	
	private ElectricityMeterReadingDataMapper electricityMeterReadingDataMapper;
	
	private MeterReadingDataMapper meterReadingDataMapper;
	private AnnexMapper annexMapper;
	
	private ElectricityMeterMapper electricityMeterMapper;
	
	private MeterMapper meterMapper;
	
	
	public AnnexMapper getAnnexMapper() {
		return annexMapper;
	}

	public void setAnnexMapper(AnnexMapper annexMapper) {
		this.annexMapper = annexMapper;
	}

	public ElectricityMeterReadingDataMapper getElectricityMeterReadingDataMapper() {
		return electricityMeterReadingDataMapper;
	}

	public void setElectricityMeterReadingDataMapper(ElectricityMeterReadingDataMapper electricityMeterReadingDataMapper) {
		this.electricityMeterReadingDataMapper = electricityMeterReadingDataMapper;
	}

	public MeterReadingDataMapper getMeterReadingDataMapper() {
		return meterReadingDataMapper;
	}

	public void setMeterReadingDataMapper(
			MeterReadingDataMapper meterReadingDataMapper) {
		this.meterReadingDataMapper = meterReadingDataMapper;
	}

	public CorrectedReadingMapper getCorrectedReadingMapper() {
		return correctedReadingMapper;
	}

	public void setCorrectedReadingMapper(
			CorrectedReadingMapper correctedReadingMapper) {
		this.correctedReadingMapper = correctedReadingMapper;
	}

	public ElectricityMeterMapper getElectricityMeterMapper() {
		return electricityMeterMapper;
	}

	public void setElectricityMeterMapper(ElectricityMeterMapper electricityMeterMapper) {
		this.electricityMeterMapper = electricityMeterMapper;
	}

	public MeterMapper getMeterMapper() {
		return meterMapper;
	}

	public void setMeterMapper(MeterMapper meterMapper) {
		this.meterMapper = meterMapper;
	}

	@Override
	public void insert(CorrectedReading record) {
		// TODO Auto-generated method stub
		String uuid=UUID.randomUUID().toString();
		String uuid1=UUID.randomUUID().toString();
		record.setCorrectedReadingId(uuid);
		
		correctedReadingMapper.insert(record);
	}

	@Override
	public void addCorrectRead(CorrectedReading correctedReading) {
		// TODO Auto-generated method stub
		String uuid=UUID.randomUUID().toString();
		//String uuid1=UUID.randomUUID().toString();
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		List<Annex> annexList = correctedReading.getAnnexs();
		MeterReadingData meterReadingData =meterReadingDataMapper.getMeterReadingDatabyId(correctedReading.getMeterReadingDataId());
		WaterMeter waterMeter = meterMapper.getWaterMeterbywaterMeterRecordsId(meterReadingData.getWaterMeterRecordId());
		//添加附件
		String annexUUUID = UUID.randomUUID().toString();
		if(annexList != null && annexList.size()>0){
			for(Annex annex :annexList){
				annex.setAnnexId(annexUUUID);
				annex.setRelationId(uuid);
				annex.setAnnexTime(date);
				annexMapper.insertAnnexUUID(annex);
			}
		}
		correctedReading.setWaterMeterId(waterMeter.getWaterMeterId());
		correctedReading.setCorrectedReadingId(uuid);
		correctedReading.setCorrectedTime(new Date());
		correctedReading.setAnnexId(annexUUUID);
		if(meterReadingData!=null){
			meterReadingData.setCorrectedReadingId(uuid);
			meterReadingData.setCorrection(correctedReading.getCorrection());
			meterReadingData.setReading(correctedReading.getCorrectionValue());
			meterReadingData.setConsumption(correctedReading.getCorrectionValue() - meterReadingData.getLastMonthReading());
		}
//		meterReadingData.setAbnormalState(1);
		meterReadingDataMapper.updateByPrimaryKeySelective(meterReadingData);
		correctedReadingMapper.insert(correctedReading);
	
	}
	
	
	@Override
	public void addElectricityMeterCorrectRead(CorrectedReading correctedReading) {
		// TODO Auto-generated method stub
		String uuid=UUID.randomUUID().toString();
		//String uuid1=UUID.randomUUID().toString();
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		List<Annex> annexList = correctedReading.getAnnexs();
		ElectricityMeterReadingData electricityMeterReadingData =electricityMeterReadingDataMapper.getElectricityMeterReadingDatabyId(correctedReading.getElectricityMeterReadingDataId());
		ElectricityMeter electricityMeter = electricityMeterMapper.getElectricityMeterbyElectricityMeterRecordsId(electricityMeterReadingData.getElectricityMeterRecordId());
		//添加附件
		String annexUUUID = UUID.randomUUID().toString();
		if(annexList != null && annexList.size()>0){
			for(Annex annex :annexList){
				annex.setAnnexId(annexUUUID);
				annex.setRelationId(uuid);
				annex.setAnnexTime(date);
				annexMapper.insertAnnexUUID(annex);
			}
		}
		correctedReading.setElectricityMeterId(electricityMeter.getElectricityMeterId());
		correctedReading.setCorrectedReadingId(uuid);
		correctedReading.setCorrectedTime(new Date());
		correctedReading.setAnnexId(annexUUUID);
		electricityMeterReadingData.setCorrectedReadingId(uuid);
		electricityMeterReadingData.setCorrection(correctedReading.getCorrection());
		electricityMeterReadingData.setReading(correctedReading.getCorrectionValue());
		electricityMeterReadingData.setConsumption(correctedReading.getCorrectionValue() - electricityMeterReadingData.getLastMonthReading());
//		meterReadingData.setAbnormalState(1);
		electricityMeterReadingDataMapper.updateByPrimaryKeySelective(electricityMeterReadingData);
		correctedReadingMapper.insertElectricity(correctedReading);
	
	}
}
