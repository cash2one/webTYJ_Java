package com.flf.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Gating {
	private String id;

    private String equipmentNum;

    private String accountId;

    private String equipmentName;

    private String equipmentModel;

    private String batchNummer;

    private @DateTimeFormat(pattern="yyyy-MM-dd")Date manufactureDate;

    private @DateTimeFormat(pattern="yyyy-MM-dd")Date scrapTime;

    private String scrapCause;

    private Integer qualityTerm;

    private Integer employTerm;

    private String facilityState;
    
    private @DateTimeFormat(pattern="yyyy-MM-dd")Date qualityTimeStart;

    private String marketId;

    private String purchaseId;

    private String productionFirm;

    private String productionSite;

    private String district;

    private String twoDimensionCode;

	public Date getQualityTimeStart() {
		return qualityTimeStart;
	}
	public void setQualityTimeStart(Date qualityTimeStart) {
		this.qualityTimeStart = qualityTimeStart;
	}

	private Page page;

    public Page getPage() {
		if(page==null)
			page = new Page();
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}

    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEquipmentNum() {
		return equipmentNum;
	}
	public void setEquipmentNum(String equipmentNum) {
		this.equipmentNum = equipmentNum;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getBatchNummer() {
		return batchNummer;
	}
	public void setBatchNummer(String batchNummer) {
		this.batchNummer = batchNummer;
	}
	public String getMarketId() {
		return marketId;
	}
	public void setMarketId(String marketId) {
		this.marketId = marketId;
	}
	public String getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(String purchaseId) {
		this.purchaseId = purchaseId;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getTwoDimensionCode() {
		return twoDimensionCode;
	}
	public void setTwoDimensionCode(String twoDimensionCode) {
		this.twoDimensionCode = twoDimensionCode;
	}
	public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentModel() {
        return equipmentModel;
    }

    public void setEquipmentModel(String equipmentModel) {
        this.equipmentModel = equipmentModel;
    }


    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

	public Date getScrapTime() {
        return scrapTime;
    }

    public void setScrapTime(Date scrapTime) {
        this.scrapTime = scrapTime;
    }

    public String getScrapCause() {
        return scrapCause;
    }

    public void setScrapCause(String scrapCause) {
        this.scrapCause = scrapCause;
    }

    public Integer getQualityTerm() {
        return qualityTerm;
    }

    public void setQualityTerm(Integer qualityTerm) {
        this.qualityTerm = qualityTerm;
    }

    public Integer getEmployTerm() {
        return employTerm;
    }

    public void setEmployTerm(Integer employTerm) {
        this.employTerm = employTerm;
    }

    public String getFacilityState() {
        return facilityState;
    }

    public void setFacilityState(String facilityState) {
		this.facilityState = facilityState;
	}
	public String getProductionFirm() {
        return productionFirm;
    }

    public void setProductionFirm(String productionFirm) {
        this.productionFirm = productionFirm;
    }

    public String getProductionSite() {
        return productionSite;
    }

    public void setProductionSite(String productionSite) {
        this.productionSite = productionSite;
    }
}