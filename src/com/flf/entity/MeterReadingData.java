package com.flf.entity;

/* Created by Administrator on 2015/6/15. 
author:尹磊
修改时间：2015/6/15  修改人：尹磊 */
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "MeterReadingData") // 抄表数据
public class MeterReadingData {

	private MeterReadingData meterReadingData;

	private String meterReadingDataId; // 抄表数据id

	private String waterMeterRecordId; // 水表使用记录id

	private Double lastMonthReading; // 上月读数

	private Double reading; // 读数

	private String meterReadingPeople; // 抄表人

	private Byte meterReadingState; // 抄表状态

	private Date meterReadingDate; // 抄表日期

	private Byte readingState; // 读数状态
	
	 private String staffExecutor;//抄表人
	

	public String getStaffExecutor() {
		return staffExecutor;
	}

	public void setStaffExecutor(String staffExecutor) {
		this.staffExecutor = staffExecutor;
	}

	private String note; // 备注

	private Byte auditState; // 审核状态

	private String auditPeople; // 审核人

	private Double correction; // 修正量

	private String reason; // 原因

	private Double waterDamage; // 水损量

	private String meterReadingProgramId; // 抄表计划id

	private String teamworkId; // 团队id

	private String fullName; // 房屋全名

	private Double dosage; // 用量

	private String waterMeterNum; // 水表编号

	private String waterMeterDescribed; // 水表描述
	
	private String projectName; // 计划名称

	private String waterMeterId; // 水表id

	private List<MeterReadingData> meterReadingDatass;
	
	private List<String> listleasesArray;
	
	private List<String> listleasesArray1;//重抄任务抄表数据id
	
	private List<String> listleasesArray2;//重抄任务建筑id

	private String meterExecutiveId;// 抄表执行结果Id

	private String correctedReadingId;// 读数修正ID

	private Double surplus;// 用余量

	private WaterMeterRecords waterMeterRecords;
	private Integer abnormalState; // 0.正常，1.异常，2.错误

	private Integer verificationRecord;// 核实记录 0.待核实，1.已核实，2.待重抄，3.已重抄

	private Date specifiedDate;// 指定抄表日期

	private Double consumption;// 水表用量

	private Double lastMonthUse;// 上月用量

	private Double lastYearRead;// 去年读数

	private Double lastYearUse;// 去年用量
	
	private Double loopNum;//循环修正量
	
	private String id;// 读数修正ID

	public String getWaterMeterId() {
		return waterMeterId;
	}

	public void setWaterMeterId(String waterMeterId) {
		this.waterMeterId = waterMeterId;
	}

	public Integer getVerificationRecord() {
		return verificationRecord;
	}

	public void setVerificationRecord(Integer verificationRecord) {
		this.verificationRecord = verificationRecord;
	}

	public Integer getAbnormalState() {
		return abnormalState;
	}

	public void setAbnormalState(Integer abnormalState) {
		this.abnormalState = abnormalState;
	}

	public WaterMeterRecords getWaterMeterRecords() {
		return waterMeterRecords;
	}

	public void setWaterMeterRecords(WaterMeterRecords waterMeterRecords) {
		this.waterMeterRecords = waterMeterRecords;
	}

	public String getMeterExecutiveId() {
		return meterExecutiveId;
	}

	public void setMeterExecutiveId(String meterExecutiveId) {
		this.meterExecutiveId = meterExecutiveId;
	}

	public String getCorrectedReadingId() {
		return correctedReadingId;
	}

	public void setCorrectedReadingId(String correctedReadingId) {
		this.correctedReadingId = correctedReadingId;
	}

	public Double getSurplus() {
		return surplus;
	}

	public void setSurplus(Double surplus) {
		this.surplus = surplus;
	}

	public Double getDosage() {
		// this. dosage=this.reading-this.lastMonthReading;
		return this.dosage;
	}

	private Double comparedSame; // 同比

	private Double sequential; // 环比

	private Double dosagePoor; // 用量差

	private List<String> meterReadingDataIds;

	private String buildingStructureId; // 建筑结构id

	public String getBuildingStructureId() {
		return buildingStructureId;
	}

	public void setBuildingStructureId(String buildingStructureId) {
		this.buildingStructureId = buildingStructureId;
	}

	public String getWaterMeterNum() {
		return waterMeterNum;
	}

	public void setWaterMeterNum(String waterMeterNum) {
		this.waterMeterNum = waterMeterNum;
	}

	public List<String> getListleasesArray() {
		return listleasesArray;
	}

	public void setListleasesArray(List<String> listleasesArray) {
		this.listleasesArray = listleasesArray;
	}
	
	public List<String> getListleasesArray1() {
		return listleasesArray1;
	}

	public void setListleasesArray1(List<String> listleasesArray1) {
		this.listleasesArray1 = listleasesArray1;
	}//重抄任务抄表数据id
	
	public List<String> getListleasesArray2() {
		return listleasesArray2;
	}

	public void setListleasesArray2(List<String> listleasesArray2) {
		this.listleasesArray2 = listleasesArray2;
	}//重抄任务建筑id

	public List<MeterReadingData> getMeterReadingDatass() {
		return meterReadingDatass;
	}

	public void setMeterReadingDatass(List<MeterReadingData> meterReadingDatass) {
		this.meterReadingDatass = meterReadingDatass;
	}

	public List<String> getMeterReadingDataIds() {
		return meterReadingDataIds;
	}

	public void setMeterReadingDataIds(List<String> meterReadingDataIds) {
		this.meterReadingDataIds = meterReadingDataIds;
	}

	public void setDosage(Double dosage) {
		this.dosage = dosage;
	}

	public Double getComparedSame() {
		return comparedSame;
	}

	public void setComparedSame(Double comparedSame) {
		this.comparedSame = comparedSame;
	}

	public Double getSequential() {
		return sequential;
	}

	public void setSequential(Double sequential) {
		this.sequential = sequential;
	}

	public Double getDosagePoor() {
		return dosagePoor;
	}

	public void setDosagePoor(Double dosagePoor) {
		this.dosagePoor = dosagePoor;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getTeamworkId() {
		return teamworkId;
	}

	public void setTeamworkId(String teamworkId) {
		this.teamworkId = teamworkId;
	}

	public String getMeterReadingProgramId() {
		return meterReadingProgramId;
	}

	public void setMeterReadingProgramId(String meterReadingProgramId) {
		this.meterReadingProgramId = meterReadingProgramId;
	}

	private Page page;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getMeterReadingDataId() {
		return meterReadingDataId;
	}

	public void setMeterReadingDataId(String meterReadingDataId) {
		this.meterReadingDataId = meterReadingDataId;
	}

	public String getWaterMeterRecordId() {
		return waterMeterRecordId;
	}

	public void setWaterMeterRecordId(String waterMeterRecordId) {
		this.waterMeterRecordId = waterMeterRecordId;
	}

	public Double getLastMonthReading() {
		return lastMonthReading;
	}

	public void setLastMonthReading(Double lastMonthReading) {
		this.lastMonthReading = lastMonthReading;
	}

	public Double getReading() {
		return reading;
	}

	public void setReading(Double reading) {
		this.reading = reading;
	}

	public String getMeterReadingPeople() {
		return meterReadingPeople;
	}

	public void setMeterReadingPeople(String meterReadingPeople) {
		this.meterReadingPeople = meterReadingPeople;
	}

	public Byte getMeterReadingState() {
		return meterReadingState;
	}

	public void setMeterReadingState(Byte meterReadingState) {
		this.meterReadingState = meterReadingState;
	}

	public Date getMeterReadingDate() {
		return meterReadingDate;
	}

	public void setMeterReadingDate(Date meterReadingDate) {
		this.meterReadingDate = meterReadingDate;
	}

	public Byte getReadingState() {
		return readingState;
	}

	public void setReadingState(Byte readingState) {
		this.readingState = readingState;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Byte getAuditState() {
		return auditState;
	}

	public void setAuditState(Byte auditState) {
		this.auditState = auditState;
	}

	public String getAuditPeople() {
		return auditPeople;
	}

	public void setAuditPeople(String auditPeople) {
		this.auditPeople = auditPeople;
	}

	public Double getCorrection() {
		return correction;
	}

	public void setCorrection(Double correction) {
		this.correction = correction;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Double getWaterDamage() {
		return waterDamage;
	}

	public void setWaterDamage(Double waterDamage) {
		this.waterDamage = waterDamage;
	}

	public Date getSpecifiedDate() {
		return specifiedDate;
	}

	public void setSpecifiedDate(Date specifiedDate) {
		this.specifiedDate = specifiedDate;
	}

	public Double getConsumption() {
		return consumption;
	}

	public void setConsumption(Double consumption) {
		this.consumption = consumption;
	}

	public Double getLastMonthUse() {
		return lastMonthUse;
	}

	public void setLastMonthUse(Double lastMonthUse) {
		this.lastMonthUse = lastMonthUse;
	}

	public Double getLastYearRead() {
		return lastYearRead;
	}

	public void setLastYearRead(Double lastYearRead) {
		this.lastYearRead = lastYearRead;
	}

	public Double getLastYearUse() {
		return lastYearUse;
	}

	public void setLastYearUse(Double lastYearUse) {
		this.lastYearUse = lastYearUse;
	}

	public MeterReadingData getMeterReadingData() {
		return meterReadingData;
	}

	public void setMeterReadingData(MeterReadingData meterReadingData) {
		this.meterReadingData = meterReadingData;
	}

	public String getWaterMeterDescribed() {
		return waterMeterDescribed;
	}

	public void setWaterMeterDescribed(String waterMeterDescribed) {
		this.waterMeterDescribed = waterMeterDescribed;
	}
	
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Double getLoopNum() {
		return loopNum;
	}

	public void setLoopNum(Double loopNum) {
		this.loopNum = loopNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}