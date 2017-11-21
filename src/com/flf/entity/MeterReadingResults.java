package com.flf.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="MeterReadingResults")
public class MeterReadingResults {
    private String meterExecutiveId;//执行结果ID

    private String meterReadingProgramId;//计划ID

    private Date meterExecutiveTime;//执行时间

    private Integer meterReadingNum;//抄表数量

    private Integer unfinishedNum;//未完成数量

    private Integer meterReadingWarningNum;//警告抄表数量

    private Integer meterReadingErrorNum;//错误抄表数量

    private Integer noMeterReadingNum;//未抄表数量

    private Integer reviewMeterNum;//已审核数量

    private Integer meterReadingNormalNum;//正常抄表数量

    private String currentExecutor;//当前执行人

    private String whetherUploadSuccess;//是否上传成功
    
    private String projectName;
    
    private MeterReadingProgram meterReadingProgram;
    
    
    public MeterReadingProgram getMeterReadingProgram() {
		return meterReadingProgram;
	}

	public void setMeterReadingProgram(MeterReadingProgram meterReadingProgram) {
		this.meterReadingProgram = meterReadingProgram;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	private Page page;
	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

    public String getMeterExecutiveId() {
        return meterExecutiveId;
    }

    public void setMeterExecutiveId(String meterExecutiveId) {
        this.meterExecutiveId = meterExecutiveId;
    }

    public String getMeterReadingProgramId() {
        return meterReadingProgramId;
    }

    public void setMeterReadingProgramId(String meterReadingProgramId) {
        this.meterReadingProgramId = meterReadingProgramId;
    }

    public Date getMeterExecutiveTime() {
        return meterExecutiveTime;
    }

    public void setMeterExecutiveTime(Date meterExecutiveTime) {
        this.meterExecutiveTime = meterExecutiveTime;
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

    public String getWhetherUploadSuccess() {
        return whetherUploadSuccess;
    }

    public void setWhetherUploadSuccess(String whetherUploadSuccess) {
        this.whetherUploadSuccess = whetherUploadSuccess;
    }
}