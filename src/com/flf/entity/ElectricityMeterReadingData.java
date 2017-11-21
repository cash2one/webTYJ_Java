package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ElectricityMeterReadingData") // 抄表数据
public class ElectricityMeterReadingData {
	
	private ElectricityMeterReadingData electricityMeterReadingData;
	
	//private List<ElectricityMeterReadingData> electricityMeterReadingDatass;
	
	private List<String> listleasesArray;
	
	private List<String> listleasesArray1;//重抄任务抄表数据id
	
	private List<String> listleasesArray2;//重抄任务建筑id

	private ElectricityMeterRecords electricityMeterRecords;

	private Double lastYearRead;// 去年读数

	private Double loopNum;//循环修正量
	
    private String electricityMeterReadingDataId; //抄表数据id

    private String electricityMeterRecordId;  // 电表使用记录id

    private Double reading;  // 读数
    private Double lastMonthReading;  // 上月读数
	private String note; //  备注
    private String meterReadingPeople;  // 抄表人

	private Byte auditState; // 审核状态
    private Byte meterReadingState;  // 抄表状态
    
    private String staffExecutor;//抄表人
    
    public String getStaffExecutor() {
		return staffExecutor;
	}




	public void setStaffExecutor(String staffExecutor) {
		this.staffExecutor = staffExecutor;
	}

	private Date meterReadingDate;  // 抄表日期

    private Byte readingState;  //读数状态
    
    private String auditPeople;  // 审核人

    private Double correction;  // 修正量

    private String reason;  // 原因

	private Double electricityDamage; // 电损量(无用字段)

	private Integer abnormalState; // 0.正常，1.异常，2.错误
    
	private String electricityMeterReadingProgramId; // 抄表计划id

	private String teamworkId; // 团队id

	private String fullName; // 房屋全名

	private String electricityMeterNum; // 电表编号
	
	private String electricityMeterDescribed; // 电表描述

	private String electricityMeterId; // 电表id

	private String projectName; // 计划名称
	
	private Page page;//分页

	private Date specifiedDate;// 指定抄表日期

    
	private Double consumption;// 电表用量

	private Double lastMonthUse;// 上月用量

	private Double lastYearUse;// 去年用量

	private Double dosage; // 用量

	private Double comparedSame; // 同比

	private Double sequential; // 环比

	private Double dosagePoor; // 用量差

	private String buildingStructureId; // 建筑结构id

	private List<String> meterReadingDataIds;
	
	private String meterExecutiveId;// 抄表执行结果Id
	
	private String correctedReadingId;// 读数修正ID
	
	private Double surplus;// 用余量
	
	private Integer verificationRecord;// 核实记录 0.待核实，1.已核实，2.待重抄，3.已重抄
	
	
	
	
	public String getMeterExecutiveId() {
		return meterExecutiveId;
	}

	
	
	
	public Double getDosage() {
		if (this.reading != null && this.lastMonthReading != null) {
			this.dosage = this.reading - this.lastMonthReading;
		}
		return this.dosage;
	}
	

	public List<String> getMeterReadingDataIds() {
		return meterReadingDataIds;
	}

	public void setMeterReadingDataIds(List<String> meterReadingDataIds) {
		this.meterReadingDataIds = meterReadingDataIds;
	}

	public String getBuildingStructureId() {
		return buildingStructureId;
	}

	public void setBuildingStructureId(String buildingStructureId) {
		this.buildingStructureId = buildingStructureId;
	}

	public String getElectricityMeterNum() {
		return electricityMeterNum;
	}

	public void setElectricityMeterNum(String electricityMeterNum) {
		this.electricityMeterNum = electricityMeterNum;
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

	public void setDosage(Double dosage) {
		this.dosage = dosage;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getElectricityMeterReadingDataId() {
		return electricityMeterReadingDataId;
	}

	public void setElectricityMeterReadingDataId(String electricityMeterReadingDataId) {
		this.electricityMeterReadingDataId = electricityMeterReadingDataId;
	}

	public String getElectricityMeterRecordId() {
		return electricityMeterRecordId;
	}

	public void setElectricityMeterRecordId(String electricityMeterRecordId) {
		this.electricityMeterRecordId = electricityMeterRecordId;
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

	public Double getElectricityDamage() {
		return electricityDamage;
	}

	public void setElectricityDamage(Double electricityDamage) {
		this.electricityDamage = electricityDamage;
	}


	public String getElectricityMeterReadingProgramId() {
		return electricityMeterReadingProgramId;
	}

	public void setElectricityMeterReadingProgramId(String electricityMeterReadingProgramId) {
		this.electricityMeterReadingProgramId = electricityMeterReadingProgramId;
	}

	public String getTeamworkId() {
		return teamworkId;
	}

	public void setTeamworkId(String teamworkId) {
		this.teamworkId = teamworkId;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
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

	public Double getLastYearUse() {
		return lastYearUse;
	}

	public void setLastYearUse(Double lastYearUse) {
		this.lastYearUse = lastYearUse;
	}

	public ElectricityMeterReadingData getElectricityMeterReadingData() {
		return electricityMeterReadingData;
	}

	public void setElectricityMeterReadingData(ElectricityMeterReadingData electricityMeterReadingData) {
		this.electricityMeterReadingData = electricityMeterReadingData;
	}

	public String getElectricityMeterId() {
		return electricityMeterId;
	}

	public void setElectricityMeterId(String electricityMeterId) {
		this.electricityMeterId = electricityMeterId;
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


	public String getElectricityMeterDescribed() {
		return electricityMeterDescribed;
	}

	public void setElectricityMeterDescribed(String electricityMeterDescribed) {
		this.electricityMeterDescribed = electricityMeterDescribed;
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
	
	public Double getSurplus() {
		return surplus;
	}
	

	public void setSurplus(Double surplus) {
		this.surplus = surplus;
	}
	
	public ElectricityMeterRecords getElectricityMeterRecords() {
		return electricityMeterRecords;
	}

	public void setElectricityMeterRecords(ElectricityMeterRecords electricityMeterRecords) {
		this.electricityMeterRecords = electricityMeterRecords;
	}
	
	public Integer getVerificationRecord() {
		return verificationRecord;
	}

	public void setVerificationRecord(Integer verificationRecord) {
		this.verificationRecord = verificationRecord;
	}
	
	public Double getLastYearRead() {
		return lastYearRead;
	}

	public void setLastYearRead(Double lastYearRead) {
		this.lastYearRead = lastYearRead;
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

	public Integer getAbnormalState() {
		return abnormalState;
	}

	public void setAbnormalState(Integer abnormalState) {
		this.abnormalState = abnormalState;
	}
	
}