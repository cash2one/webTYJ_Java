package com.flf.entity;
/* Created by Administrator on 2015/6/15. 
author:尹磊
修改时间：2015/6/15  修改人：尹磊 */
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "MeterReadingProgram")  //抄表计划表
public class MeterReadingProgram {
    private String meterReadingProgramId;   //抄表计划id

    private String projectName;  //计划名称

    private String projectId;  // 项目id

    private Integer settlementDay;  //月结日

    private String reviewers;  // 审核人员 

    private Integer programExecutionStatus; //计划执行状态
    
    private Integer programExceptionStatus; //计划执行状态

    private Integer meterReadingNum;  //抄表数量

    private Integer unfinishedNum;  // 未完成数量

    private Date startTime;  // 开始日期

    private Date endTime;  //结束日期

    private Date verifyTime;  // 核实日期

    private Integer meterReadingType;  //抄表负责人类型  

    private Integer meterReadingWarningNum; //警告抄表数量

    private Integer meterReadingErrorNum; // 错误抄表数量

    private Integer noMeterReadingNum;  // 未抄表数量

    private Integer reviewMeterNum;  //已审核数量

    private Integer meterReadingNormalNum; //正常抄表数量

    private String currentExecutor;  //抄表人
    
    private String executiveTeam;  //执行团队
    
    private String meterReadingPeople; // 抄表人
    
    private String meterReadingDate ; // 抄表日期
    
    private String reading ; // 本月读数 
    
    private  String fullName ; // 房屋全名
    
    private String waterMeterRecordsId; //水表使用记录id
    
    private List<BuildingStructureNew> buildingStructureNew; //树形集合
    
    private Integer allNum; //总表数
    
    private List<String> ids; //建筑结构id
    
    private Integer automaticExecution;//是否自动执行
   
    private String logId;
     private  Page page;
 	private String colors;//显示颜色（查询用）

    private Project project;

    private String waterMeterNum; // 水表编号（查询用）

    private Double lastMonthReading; //上月读数（查询用）
    private String waterMeterId;//水表ID（查询用）
    private String meterReadingDataId;//抄表数据ID（查询用）
    private WaterMeter waterMeter;
    private Integer verificationRecord;//核实记录 0.已核实 1.读数修正 2.读数重抄 （查询用）
    
    private Integer auditTime; //审核时长
    
    private Integer executionFrequency; // 执行频率
    
    private List<MeterReadingData> meterReadingDataList;
    
    private List<WaterMeter> waterMeterList;//水表集合
    
    private String modifiedPerson; //修改人
  
    private String staffExecutor;//抄表人
    
    private String staffReviewer;//审核人
    
	public String getStaffExecutor() {
		return staffExecutor;
	}

	public void setStaffExecutor(String staffExecutor) {
		this.staffExecutor = staffExecutor;
	}

	public String getStaffReviewer() {
		return staffReviewer;
	}

	public void setStaffReviewer(String staffReviewer) {
		this.staffReviewer = staffReviewer;
	}

	public Integer getVerificationRecord() {
		return verificationRecord;
	}

	public void setVerificationRecord(Integer verificationRecord) {
		this.verificationRecord = verificationRecord;
	}

	public String getMeterReadingDataId() {
		return meterReadingDataId;
	}

	public void setMeterReadingDataId(String meterReadingDataId) {
		this.meterReadingDataId = meterReadingDataId;
	}

	public WaterMeter getWaterMeter() {
		return waterMeter;
	}

	public void setWaterMeter(WaterMeter waterMeter) {
		this.waterMeter = waterMeter;
	}

	public String getWaterMeterId() {
		return waterMeterId;
	}

	public void setWaterMeterId(String waterMeterId) {
		this.waterMeterId = waterMeterId;
	}

	public String getWaterMeterNum() {
		return waterMeterNum;
	}

	public void setWaterMeterNum(String waterMeterNum) {
		this.waterMeterNum = waterMeterNum;
	}

	public Double getLastMonthReading() {
		return lastMonthReading;
	}

	public void setLastMonthReading(Double lastMonthReading) {
		this.lastMonthReading = lastMonthReading;
	}

	public String getColors() {
		return colors;
	}

	public void setColors(String colors) {
		this.colors = colors;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getLogId() {
		return logId;
	}

	public void setLogId(String logId) {
		this.logId = logId;
	}

	public Integer getAutomaticExecution() {
		return automaticExecution;
	}

	public void setAutomaticExecution(Integer automaticExecution) {
		this.automaticExecution = automaticExecution;
	}

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}

	public List<BuildingStructureNew> getBuildingStructureNew() {
		return buildingStructureNew;
	}

	public void setBuildingStructureNew(
			List<BuildingStructureNew> buildingStructureNew) {
		this.buildingStructureNew = buildingStructureNew;
	}

	public String getWaterMeterRecordsId() {
		return waterMeterRecordsId;
	}

	public void setWaterMeterRecordsId(String waterMeterRecordsId) {
		this.waterMeterRecordsId = waterMeterRecordsId;
	}
	

	public String getMeterReadingPeople() {

		return meterReadingPeople;
	}

	public void setMeterReadingPeople(String meterReadingPeople) {
		this.meterReadingPeople = meterReadingPeople;
	}

	public String getMeterReadingDate() {
		return meterReadingDate;
	}

	public void setMeterReadingDate(String meterReadingDate) {
		this.meterReadingDate = meterReadingDate;
	}

	public String getReading() {
		return reading;
	}

	public void setReading(String reading) {
		this.reading = reading;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getExecutiveTeam() {
		return executiveTeam;
	}

	public void setExecutiveTeam(String executiveTeam) {
		this.executiveTeam = executiveTeam;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

    public String getMeterReadingProgramId() {
        return meterReadingProgramId;
    }

    public void setMeterReadingProgramId(String meterReadingProgramId) {
        this.meterReadingProgramId = meterReadingProgramId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

   

    public Integer getSettlementDay() {
		return settlementDay;
	}

	public void setSettlementDay(Integer settlementDay) {
		this.settlementDay = settlementDay;
	}

	public String getReviewers() {
        return reviewers;
    }

    public void setReviewers(String reviewers) {
        this.reviewers = reviewers;
    }

 

    public Integer getProgramExecutionStatus() {
		return programExecutionStatus;
	}
    
    public Integer getProgramExceptionStatus() {
		return programExceptionStatus;
	}

	public void setProgramExecutionStatus(Integer programExecutionStatus) {
		this.programExecutionStatus = programExecutionStatus;
	}
	
	public void setProgramExceptionStatus(Integer programExceptionStatus) {
		this.programExceptionStatus = programExceptionStatus;
	}

	public Integer getMeterReadingNum() {
        return meterReadingNum;
    }

    public void setMeterReadingNum(Integer meterReadingNum) {
        this.meterReadingNum = meterReadingNum;
    }

    public Integer getUnfinishedNum() {
        return unfinishedNum;
    }

    public void setUnfinishedNum(Integer unfinishedNum) {
        this.unfinishedNum = unfinishedNum;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getVerifyTime() {
        return verifyTime;
    }

    public void setVerifyTime(Date verifyTime) {
        this.verifyTime = verifyTime;
    }

    public Integer getAllNum() {
		return allNum;
	}

	public void setAllNum(Integer allNum) {
		this.allNum = allNum;
	}

	public Integer getMeterReadingType() {
		return meterReadingType;
	}

	public void setMeterReadingType(Integer meterReadingType) {
		this.meterReadingType = meterReadingType;
	}

	public Integer getMeterReadingWarningNum() {
        return meterReadingWarningNum;
    }

    public void setMeterReadingWarningNum(Integer meterReadingWarningNum) {
        this.meterReadingWarningNum = meterReadingWarningNum;
    }

    public Integer getMeterReadingErrorNum() {
        return meterReadingErrorNum;
    }

    public void setMeterReadingErrorNum(Integer meterReadingErrorNum) {
        this.meterReadingErrorNum = meterReadingErrorNum;
    }

    public Integer getNoMeterReadingNum() {
        return noMeterReadingNum;
    }

    public void setNoMeterReadingNum(Integer noMeterReadingNum) {
        this.noMeterReadingNum = noMeterReadingNum;
    }

    public Integer getReviewMeterNum() {
        return reviewMeterNum;
    }

    public void setReviewMeterNum(Integer reviewMeterNum) {
        this.reviewMeterNum = reviewMeterNum;
    }

    public Integer getMeterReadingNormalNum() {
        return meterReadingNormalNum;
    }

    public void setMeterReadingNormalNum(Integer meterReadingNormalNum) {
        this.meterReadingNormalNum = meterReadingNormalNum;
    }

    public String getCurrentExecutor() {
        return currentExecutor;
    }

    public void setCurrentExecutor(String currentExecutor) {
        this.currentExecutor = currentExecutor;
    }

	public Integer getAuditTime() {
		return auditTime;
	}

	public void setAuditTime(Integer auditTime) {
		this.auditTime = auditTime;
	}

	public Integer getExecutionFrequency() {
		return executionFrequency;
	}

	public void setExecutionFrequency(Integer executionFrequency) {
		this.executionFrequency = executionFrequency;
	}

	public List<MeterReadingData> getMeterReadingDataList() {
		return meterReadingDataList;
	}

	public void setMeterReadingDataList(List<MeterReadingData> meterReadingDataList) {
		this.meterReadingDataList = meterReadingDataList;
	}

	public List<WaterMeter> getWaterMeterList() {
		return waterMeterList;
	}

	public void setWaterMeterList(List<WaterMeter> waterMeterList) {
		this.waterMeterList = waterMeterList;
	}

	public String getModifiedPerson() {
		return modifiedPerson;
	}

	public void setModifiedPerson(String modifiedPerson) {
		this.modifiedPerson = modifiedPerson;
	}
    
}