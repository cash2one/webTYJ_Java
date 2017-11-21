package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ElectricityMeterRecords") 
public class ElectricityMeterRecords {
   
    private String electricityMeterRecordsId; // 电表使用记录id

    private String electricityMeterId;  // 电表id

    private Date installationTime; //安装时间

    private Date enablingTime;// 启用时间

    private String install; //安装人

    private Date outageTime; //停用时间

    private String usingNature; //使用性质

    private String electricityMeterBuildingId; //

    private String assetsId; //电表所属建筑id

    private Integer state; //表状态

    private String readingWay; //抄表方式

    private String parentId; // 父表id

    private String isBilling; //是否计费表 0，否 1，是

    private Double lastTimeReading; //上次读数

    private Double initialReading; //初始读数

    private Double stopReading; //停用读数

    private String buildingStructureId; // 建筑结构id
    
    private String electricityMeterNum; //电表编号
    
    private String fullName; // 房屋全名
    
    private String reading; // 本月读数
    
    private String meterReadingPeople; //抄表人
    
    private  Date  meterReadingDate; //抄表日期    

    private Double lastMonthReading;  //上次读数
    
    private ElectricityMeter electricityMeter; // 电表表
    
    private String parentNum; //父表编号
    
    private String mainNum;//主表编号
    
    private String electricityMeterDescribed; //表描述
    
    private String fromNum; //从表编号
    
    private String meterReadingProgramId;//
    
    private Double lastMonthReadings;  //上次读数
    
    private int year;//年份
    private Double correction;//修正量
    private Double surplus;//用余量
    private String electricityMeterReadingDataId;//抄表数据id
    private Double correctionValue;//修正值
    private String correctedReadingId;
    private Integer abnormalState;//异常状态
    
    private double consumption;//水表用量
    
    private Double childMeterReading;//子表读数总和
    private Double childConsumption;//电表用量总和
    private Date queryDate; //电损查询日期
    
    private List<String> parentNumList; //电损查询，父表编号集合
    
    private String parentNumOne;
    
    private String parentNumTwo;
    
    private String hasChird; //判断是否有子表
    
    private int level; //层级
    
    private Property property ; //资产表
    
    private Page page;

    private String lossRate;//电损率
    
    private Double electricityLoss;//电损
    
    private Double bootChildConsumption;//底层子级电表用量
    
    private String electricityName;//电表描述
    
    private Date specifiedDate;//抄表日期

    public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
    
    public Integer getAbnormalState() {
		return abnormalState;
	}

	public void setAbnormalState(Integer abnormalState) {
		this.abnormalState = abnormalState;
	}
    
    public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}
	
    public String getReading() {	
		return reading;
	}

	public void setReading(String reading) {
		this.reading = reading;
	}

	public String getMeterReadingPeople() {
		return meterReadingPeople;
	}

	public void setMeterReadingPeople(String meterReadingPeople) {
		this.meterReadingPeople = meterReadingPeople;
	}

	public Date getMeterReadingDate() {
		return meterReadingDate;
	}

	public void setMeterReadingDate(Date meterReadingDate) {
		this.meterReadingDate = meterReadingDate;
	}

	public String getElectricityMeterNum() {
		return electricityMeterNum;
	}

	public void setElectricityMeterNum(String electricityMeterNum) {
		this.electricityMeterNum = electricityMeterNum;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

    public ElectricityMeter getElectricityMeter() {
		return electricityMeter;
	}

	public void setElectricityMeter(ElectricityMeter electricityMeter) {
		this.electricityMeter = electricityMeter;
	}

	public String getElectricityMeterRecordsId() {
        return electricityMeterRecordsId;
    }

    public void setElectricityMeterRecordsId(String electricityMeterRecordsId) {
        this.electricityMeterRecordsId = electricityMeterRecordsId;
    }

    public String getElectricityMeterId() {
        return electricityMeterId;
    }

    public void setElectricityMeterId(String electricityMeterId) {
        this.electricityMeterId = electricityMeterId;
    }

    public Date getInstallationTime() {
        return installationTime;
    }

    public void setInstallationTime(Date installationTime) {
        this.installationTime = installationTime;
    }

    public Date getEnablingTime() {
        return enablingTime;
    }

    public void setEnablingTime(Date enablingTime) {
        this.enablingTime = enablingTime;
    }

    public String getInstall() {
        return install;
    }

    public void setInstall(String install) {
        this.install = install;
    }

    public Date getOutageTime() {
        return outageTime;
    }

    public void setOutageTime(Date outageTime) {
        this.outageTime = outageTime;
    }

    public String getUsingNature() {
        return usingNature;
    }

    public void setUsingNature(String usingNature) {
        this.usingNature = usingNature;
    }

    public String getElectricityMeterBuildingId() {
        return electricityMeterBuildingId;
    }

    public void setElectricityMeterBuildingId(String electricityMeterBuildingId) {
        this.electricityMeterBuildingId = electricityMeterBuildingId;
    }

    public String getAssetsId() {
        return assetsId;
    }

    public void setAssetsId(String assetsId) {
        this.assetsId = assetsId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getReadingWay() {
        return readingWay;
    }

    public void setReadingWay(String readingWay) {
        this.readingWay = readingWay;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getIsBilling() {
        return isBilling;
    }

    public void setIsBilling(String isBilling) {
        this.isBilling = isBilling;
    }

    public Double getLastTimeReading() {
        return lastTimeReading;
    }

    public void setLastTimeReading(Double lastTimeReading) {
        this.lastTimeReading = lastTimeReading;
    }

    public Double getInitialReading() {
        return initialReading;
    }

    public void setInitialReading(Double initialReading) {
        this.initialReading = initialReading;
    }

    public Double getStopReading() {
        return stopReading;
    }

    public void setStopReading(Double stopReading) {
        this.stopReading = stopReading;
    }

    public String getBuildingStructureId() {
        return buildingStructureId;
    }

    public void setBuildingStructureId(String buildingStructureId) {
        this.buildingStructureId = buildingStructureId;
    }
    public Double getLastMonthReadings() {
		return lastMonthReadings;
	}

	public void setLastMonthReadings(Double lastMonthReadings) {
		this.lastMonthReadings = lastMonthReadings;
	}
	
	public Double getLastMonthReading() {
		return lastMonthReading;
	}

	public void setLastMonthReading(Double lastMonthReading) {
		this.lastMonthReading = lastMonthReading;
	}

	public String getParentNum() {
		return parentNum;
	}

	public void setParentNum(String parentNum) {
		this.parentNum = parentNum;
	}
	
	public List<String> getParentNumList() {
		return parentNumList;
	}

	public void setParentNumList(List<String> parentNumList) {
		this.parentNumList = parentNumList;
	}

	public String getParentNumOne() {
		return parentNumOne;
	}

	public void setParentNumOne(String parentNumOne) {
		this.parentNumOne = parentNumOne;
	}

	public String getParentNumTwo() {
		return parentNumTwo;
	}

	public void setParentNumTwo(String parentNumTwo) {
		this.parentNumTwo = parentNumTwo;
	}

	public String getElectricityMeterDescribed() {
		return electricityMeterDescribed;
	}

	public void setElectricityMeterDescribed(String electricityMeterDescribed) {
		this.electricityMeterDescribed = electricityMeterDescribed;
	}
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Double getCorrection() {
		return correction;
	}

	public void setCorrection(Double correction) {
		this.correction = correction;
	}
	

	public Double getCorrectionValue() {
		return correctionValue;
	}

	public void setCorrectionValue(Double correctionValue) {
		this.correctionValue = correctionValue;
	}
	
	public Double getSurplus() {
		return surplus;
	}

	public void setSurplus(Double surplus) {
		this.surplus = surplus;
	}
	
	public String getElectricityMeterReadingDataId() {
		return electricityMeterReadingDataId;
	}

	public void setElectricityMeterReadingDataId(String electricityMeterReadingDataId) {
		this.electricityMeterReadingDataId = electricityMeterReadingDataId;
	}
	
	public String getCorrectedReadingId() {
		return correctedReadingId;
	}

	public void setCorrectedReadingId(String correctedReadingId) {
		this.correctedReadingId = correctedReadingId;
	}

	public Double getChildMeterReading() {
		return childMeterReading;
	}

	public void setChildMeterReading(Double childMeterReading) {
		this.childMeterReading = childMeterReading;
	}

	public Date getQueryDate() {
		return queryDate;
	}

	public void setQueryDate(Date queryDate) {
		this.queryDate = queryDate;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getHasChird() {
		return hasChird;
	}

	public void setHasChird(String hasChird) {
		this.hasChird = hasChird;
	}
	
	public Double getChildConsumption() {
		return childConsumption;
	}

	public void setChildConsumption(Double childConsumption) {
		this.childConsumption = childConsumption;
	}

	public double getConsumption() {
		return consumption;
	}

	public void setConsumption(double consumption) {
		this.consumption = consumption;
	}

	public String getMainNum() {
		return mainNum;
	}

	public void setMainNum(String mainNum) {
		this.mainNum = mainNum;
	}
	
	public String getFromNum() {
		return fromNum;
	}

	public void setFromNum(String fromNum) {
		this.fromNum = fromNum;
	}

	public String getLossRate() {
		return lossRate;
	}

	public void setLossRate(String lossRate) {
		this.lossRate = lossRate;
	}

	public Double getElectricityLoss() {
		return electricityLoss;
	}

	public void setElectricityLoss(Double electricityLoss) {
		this.electricityLoss = electricityLoss;
	}

	public Double getBootChildConsumption() {
		return bootChildConsumption;
	}

	public void setBootChildConsumption(Double bootChildConsumption) {
		this.bootChildConsumption = bootChildConsumption;
	}

	public String getElectricityName() {
		return electricityName;
	}

	public void setElectricityName(String electricityName) {
		this.electricityName = electricityName;
	}

	public Date getSpecifiedDate() {
		return specifiedDate;
	}

	public void setSpecifiedDate(Date specifiedDate) {
		this.specifiedDate = specifiedDate;
	}
	
}