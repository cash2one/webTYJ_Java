package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="CorrectedReading")
public class CorrectedReading {
    private String correctedReadingId;//读数修正ID

    private String waterMeterId;//水表ID
    
    private String electricityMeterId;//电表ID

    private Date correctedTime;//修正时间

    private String operator;//操作人

    private Double correction;//修正量

    private String reason;//原因

    private String annexId;//附件ID

    private Double correctionValue;//修正值
    
    private String meterReadingDataId;
    
    private String electricityMeterReadingDataId;
    
    private List<Annex> annexs;//附件表
    
    private String returnPremium;//退费(0,账户；1,现金)
    
    
    public List<Annex> getAnnexs() {
		return annexs;
	}

	public void setAnnexs(List<Annex> annexs) {
		this.annexs = annexs;
	}

	public String getMeterReadingDataId() {
		return meterReadingDataId;
	}

	public void setMeterReadingDataId(String meterReadingDataId) {
		this.meterReadingDataId = meterReadingDataId;
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

    public String getWaterMeterId() {
        return waterMeterId;
    }

    public void setWaterMeterId(String waterMeterId) {
        this.waterMeterId = waterMeterId;
    }
    
    public String getElectricityMeterId() {
        return electricityMeterId;
    }

    public void setElectricityMeterId(String electricityMeterId) {
        this.electricityMeterId = electricityMeterId;
    }

    public Date getCorrectedTime() {
        return correctedTime;
    }

    public void setCorrectedTime(Date correctedTime) {
        this.correctedTime = correctedTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }



    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getAnnexId() {
        return annexId;
    }

    public void setAnnexId(String annexId) {
        this.annexId = annexId;
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

	public String getReturnPremium() {
		return returnPremium;
	}

	public void setReturnPremium(String returnPremium) {
		this.returnPremium = returnPremium;
	}

 
}